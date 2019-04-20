package com.dn.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dn.domain.Cart;
/*import com.dn.domain.Color;
*/import com.dn.domain.Menu;
import com.dn.domain.Num;
import com.dn.domain.Product;
/*import com.dn.domain.Size;
*/import com.dn.service.CartService;
import com.dn.service.ProductService;
/*import com.dn.util.FileUpLoadUtil;*/

//商品控制器类
@Controller
@RequestMapping(value="/product")
public class ProductController {
	
	//自动注入ProductService
	@Autowired
	@Qualifier("productService")
	private ProductService productService;
	
	//自动注入ProductService
	@Autowired
	@Qualifier("cartService")
	private CartService cartService;
	
/******************************用户*********************************************/

	//跳转到主页，并查询所有商品
	@RequestMapping(value="/shop",method=RequestMethod.GET)
	public ModelAndView forwordIndex(ModelAndView mv){	
	
		//查询所有商品
		List<Product>productList=productService.selectAllProduct();
		//查询菜单列表
		List<Menu>menuList=productService.selectMenuName();
		
		//把List放到model中
		mv.addObject("productList", productList);
		mv.addObject("menu", menuList);
		//转发到index页面
		mv.setViewName("index");
		return mv;
	}

	//商品展示,查询单个商品
	@RequestMapping(value="/showOneProduct")
	public String show(Model model,Integer id){
		
		//查询操作，商品表，颜色表，尺寸表，库存表联合查询		
		List<Product> product=productService.selectOneProduct(id);
			
		//查询菜单列表
		List<Menu>menuList=productService.selectMenuName();
		model.addAttribute("menu", menuList);
		/*//查询商品颜色
		List<Color>colorList=productService.selectAllColor();
		String product_Color[]=product.getColor().split(",");//分割字符串
		//迭代器
		Iterator<Color> iter = colorList.iterator();
		boolean flag=true;
        while(iter.hasNext()){     
            Color color = iter.next();
            //判断字符数组和颜色集合中元素是否相同，不同则移除
            for(int i=0;i<product_Color.length;i++){
            	if(color.getId()==Integer.valueOf(product_Color[i])){     
            		flag=false;
                } 
            }
            if(flag){
            	iter.remove(); 
            }
        }
		//查询商品尺寸
		List<Size>sizeList=productService.selectAllSize();
		String product_Size[]=product.getSize().split(",");
		//迭代器
		Iterator<Size> iter1 = sizeList.iterator();
		boolean flag1=true;
        while(iter1.hasNext()){     
            Size size = iter1.next();
            for(int i=0;i<product_Size.length;i++){
            	if(size.getId()==Integer.valueOf(product_Size[i])){     
            		flag1=false;
                } 
            }
            if(flag1){
            	iter1.remove(); 
            }
        }*/
        
		//推荐商品
		int count=productService.selectCountFromProduct();//商品表总记录数
		Random random=new Random();//随机数
		List<Product>hotProductList=new ArrayList<Product>();
		for(int i=0;i<3;i++){
			int rid=1+random.nextInt(count);//产生3个随机ID
			Product hotProduct=productService.recommendOneProduct(rid);//随机推荐3个商品
			hotProductList.add(hotProduct);//添加到List中
		}
		/*model.addAttribute("colorList", colorList);//商品颜色
		model.addAttribute("sizeList", sizeList);//商品尺寸*/
		model.addAttribute("productOne", product);//单个商品
		model.addAttribute("hotProductList", hotProductList);//推荐商品
		return "product";
	}
	
	//显示商品库存
	@RequestMapping(value="/shouProductNum")
	public String shouProductNmu(@RequestBody Num num,HttpServletResponse response) throws IOException{
		if(num!=null){
			Integer product_num=productService.selectProductNum(num);
			response.getWriter().print(product_num);
		}
		return null;
	}
	
	//用户添加商品到购物车
	@RequestMapping(value="/addProductToCart")
	public ModelAndView addCart(@RequestBody Cart cart, 
			HttpServletResponse response) throws IOException{
		
		response.setContentType("text/html;charset=UTF-8");
		
		if(cart!=null){
			//判断是否选择了颜色和尺寸
			if(cart.getProduct_color()=="" || cart.getProduct_size()=="" ){
				response.getWriter().print("error");//未选择颜色或尺寸
			}
			else{
				//判断该商品是否已经购买过
				List<Cart> RcartList=cartService.selectOneCart(cart.getProduct_id(),cart.getUser_id());//查询购物车中是否已经存在当前购买商品
				int flag = 0;
				boolean mark = false;
				//如果已经购买过，则另需判断商品颜色和尺寸是否一致
				if(RcartList!=null){	
					//迭代器
					Iterator<Cart> iter = RcartList.iterator();
			        while(iter.hasNext()){
			        	Cart Rcart=iter.next();
			        	 //一致则更新商品数量
			        	if(Rcart.getProduct_color().equals(cart.getProduct_color()) && Rcart.getProduct_size().equals(cart.getProduct_size())){				
							mark=true;//如果存在则为真
			        		Integer product_number=Rcart.getProduct_number();//查询原商品数量
							product_number+=cart.getProduct_number();//更新后商品数量
							flag=cartService.updateProductNumberToCart(product_number,Rcart.getId());
						}
			        }
			      //如果不存在则为假
			        if(mark==false){
						Product product=productService.recommendOneProduct(cart.getProduct_id());//查询商品信息
						cart.setProduct_image(product.getImage());//设置商品图片路径
						cart.setProduct_price(product.getPrice());//设置商品价格
						cart.setProduct_title(product.getTitle());//设置商品名称
						flag=productService.addToCart(cart);
					}
				}
				else{
					//没有购买过，则添加到购物车中，生成新的记录		
					Product product=productService.recommendOneProduct(cart.getProduct_id());//查询商品信息
					cart.setProduct_image(product.getImage());//设置商品图片路径
					cart.setProduct_price(product.getPrice());//设置商品价格
					cart.setProduct_title(product.getTitle());//设置商品名称
					flag=productService.addToCart(cart);
					
				}
				//判断是否添加成功
				if(flag>0){
					response.getWriter().print("success");//商品添加成功
				}
				else{
					response.getWriter().print("fail");//商品添加失败
				}
			}			
		}
		else{
			response.getWriter().print("fail");//购物车为空，添加失败
		}
		
		//无论成功失败都返回前台页面
		return null;
	}
}
