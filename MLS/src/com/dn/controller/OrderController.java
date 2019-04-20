package com.dn.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dn.domain.Address;
import com.dn.domain.Cart;
import com.dn.domain.Order;
import com.dn.domain.Product;
import com.dn.domain.Seller;
import com.dn.domain.User;
import com.dn.service.CartService;
import com.dn.service.OrderService;
import com.dn.service.ProductService;
import com.dn.service.UserService;

@Controller
@RequestMapping(value="/order")
public class OrderController {
	
	//自动注入ProductService
	@Autowired
	@Qualifier("productService")
	private ProductService productService;
		
	//自动注入CartService
	@Autowired
	@Qualifier("cartService")
	private CartService cartService;
	
	//自动注入CartService
	@Autowired
	@Qualifier("orderService")
	private OrderService orderService;
	
	//自动注入userService
	@Autowired
	@Qualifier("userService")
	private UserService userService;

	//生成订单
	@RequestMapping(value="/toPay")
	public String toPay(HttpSession session,ModelAndView mv,int[]idList,RedirectAttributes arr){
		
		User user=(User) session.getAttribute("USER");
		//如果从购物车传过来值得话，生成订单
		if(idList.length>0){
			//查询用户购物车中所有商品
			List<Cart>cartList=cartService.selectAllToCart(user.getId());
			//查询用户默认收货地址
			Address address=userService.selectDefaultUserAddress(user.getId());
			//如果没有默认收货地址，则按顺序选择第一个收货地址
			if(address==null){
				List<Address>addressList=userService.selectAllAddress(user.getId());//查询用户所有地址
				address=addressList.get(0);//选择第一个收货地址
				//如果用户收货地址为空，则跳转到添加收货地址页面
				if(address==null){
					return "redirect:/user/selctAllAddress";
				}
			}	
			//移除购物车中的商品
			boolean mark=true;
			for(int i=0;i<idList.length;i++){
				int flag=cartService.deleteProductFromCart(idList[i]);
				if(flag<0){
					mark=false;//没有删除成功则为假
				}
			}
			//购物车商品都全部删除
			if(mark){
				//将商品和用户地址添加到订单表中
				for(int i=0;i<cartList.size();i++){
					orderService.addToOrder(cartList.get(i),address);
				}
			}
			return "redirect:/order/lookOrder";
						
		}
		//否则跳转到购物车
		else{
			arr.addAttribute("user_id", user.getId());
			return "redirect:/cart/toCart";
		}	
	}
	
	//用户查看所有订单
	@RequestMapping(value="/lookOrder")
	public String lookOrder(HttpSession session,Model model,HttpServletRequest request){
		/*String url=request.getHeader("REFERER");
		String arr[]=url.split("[?]");
		if(arr[0].trim().equals("http://localhost:8080/MLS/product/showOneProduct")){
			System.out.println(arr[0]+"**");
		}*/
		User user=(User)session.getAttribute("USER");
		if(user==null){
			return "redirect:/user/loginFrom";
		}
		else{
			List<Order>orderList=orderService.selectAllOrder(user.getId());
			model.addAttribute("orderList", orderList);
			return "pay";
		}	
	}
	
	//用户直接购买商品
	@RequestMapping(value="/addOrder")
	public String addOrder(Order order,RedirectAttributes arr){
		System.out.println("*****");
		Product product=productService.recommendOneProduct(order.getProduct_id());
		List<Address>addressList=userService.selectAllAddress(order.getUser_id());//查询用户所有地址
		//如果用户没有填写收货地址，就跳转到收货地址页面
		if(addressList==null){
			arr.addAttribute("user_id", order.getUser_id());
			return "personal/personal";
		}
		else if(order.getProduct_color()==null || order.getProduct_color()=="" || order.getProduct_size()==null || order.getProduct_size()==""){
			arr.addAttribute("id", order.getProduct_id());
			return "redirect:/product/showOneProduct";
		}
		else{
			//如果用户存在收货地址，则先查询默认收货地址
			Address address=userService.selectDefaultUserAddress(order.getUser_id());
			//如果不存在默认收货地址，则选择第一个收货地址
			if(address==null){
				address=addressList.get(0);//选择第一个收货地址
			}
			Cart cart=new Cart();
			cart.setUser_id(order.getUser_id());
			cart.setProduct_id(order.getProduct_id());
			cart.setProduct_color(order.getProduct_color());
			cart.setProduct_size(order.getProduct_size());
			cart.setProduct_number(order.getProduct_number());
			cart.setProduct_image(product.getImage());
			cart.setProduct_price(product.getPrice());
			cart.setProduct_title(product.getTitle());
			orderService.addToOrder(cart, address);
			return "redirect:/order/lookOrder";
		}
		
	}
	
	//支付
	@RequestMapping(value="/pay")
	public String pay(int[]idList,Model model){
		boolean mark=true;
		for(int i=0;i<idList.length;i++){
			//查询单个订单
			Order order=orderService.selectOneOrder(idList[i]);
			//减库存操作
			int flag=orderService.minuteProductNum(order.getProduct_color(),order.getProduct_size(),order.getProduct_number());
			//更新订单状态：完成订单
			orderService.updateOrderToComplete(idList[i]);
			if(flag<0){
				mark=false;
			}
		}
		if(mark){
			return "success";
		}
		else{
			model.addAttribute("message", "fail");
			return "redirect:/order/lookOrder";
		}	
	}
	
	//商家查看订单
	@RequestMapping(value="/queryOrderFromSeller")
	public String queryOrderFromSeller(HttpSession session,Model model){
		Seller seller=(Seller) session.getAttribute("SELLER");
		List<Order>orderList=orderService.queryOrderFromSeller(seller.getId());
		model.addAttribute("sellerOrder", orderList);
		return "seller/sellerOrder";
	}
	
	//商家发货
	@RequestMapping(value="/toGoods")
	public String toGoods(Integer id){
		int flag=orderService.updateOrderToGoods(id);
		if(flag>0){
			return "redirect:/order/queryOrderFromSeller";
		}
		else{
			return "seller/sellerOrder";
		}
		
	}
	
	//用户确认收货
	@RequestMapping(value="/takeGoods")
	public String takeGoods(Integer id){
		orderService.updateOrderToTakeGoods(id);
		return "redirect:/order/lookOrder";
	}
}
