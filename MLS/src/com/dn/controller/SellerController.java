package com.dn.controller;

/*import java.util.Iterator;*/
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
//管理员前端控制器类

import com.dn.domain.Menu;
import com.dn.domain.Page;
import com.dn.domain.Product;
import com.dn.domain.Seller;
import com.dn.service.ProductService;
import com.dn.service.SellerService;
import com.dn.util.FileUpLoadUtil;
//商家Controller类
@Controller
@RequestMapping(value="/seller")//类路径映射
public class SellerController {
	
	//自动注入AdminService
	@Autowired
	@Qualifier("sellerService")
	private SellerService sellerService;
	
	//自动注入AdminService
	@Autowired
	@Qualifier("productService")
	private ProductService productService;
	
	//跳转到管理员登陆页面
	@RequestMapping(value="/loginFrom")
	public String forwardLogin(){
		return "seller/loginFrom";
	}
	
	//管理员登陆
	@RequestMapping(value="/login")
	public String login(Model model,String username,String password,HttpSession session){
		
		Seller seller=sellerService.login(username,password);
		if(seller!=null){
			session.setAttribute("SELLER", seller);
			return "seller/main";
		}
		else{
			model.addAttribute("errorMessage", "用户名或密码不正确");
			return "seller/loginFrom";
		}
	}
	
	//框架页面跳转
	@RequestMapping(value="/top")
	public String forwordTop(){
		return "seller/top";
	}
	@RequestMapping(value="/left")
	public String forwordLeft(){
		return "seller/left";
	}
	@RequestMapping(value="/right")
	public String forwordRight(){
		return "seller/right";
	}
	
	//跳转到添加商品页面
	@RequestMapping(value="/forwardAddProduct")
	public String forwordAdd(Model model){
		List<Menu>menu=productService.selectMenuName();
		model.addAttribute("menuList", menu);
		return "seller/addProduct";
	}
	
	//跳转到查询商品页面
	@RequestMapping(value="/forwardQueryProduct")
	public String forwordQuery(Model model){
		List<Menu>menu=productService.selectMenuName();
		model.addAttribute("menuList", menu);
		return "seller/queryProduct";
	}
	
	//商家分页查询所有商品
	@RequestMapping(value="/pageSelectAllProduct")
	public ModelAndView pageAllProduct(ModelAndView mv,int pageNow,Integer seller_id){
		
		int totalCount=sellerService.getCount();//获取所有商品总记录条数
        Page page = new Page(totalCount,pageNow);
        List<Product> productList=sellerService.pageSelectAllProduct(seller_id,page);//获取所有商品
        //重置记录数
        int totalCount2=sellerService.getCount(seller_id);//获取商家所属商品总记录条数
        page.setTotalCount(totalCount2);
       /* //分类转换
        List<Menu>menuList=productService.selectMenuName();
        //迭代器
  		Iterator<Product> iter = productList.iterator();
  		while(iter.hasNext()){
			Product product = iter.next();
			//判断商品所属分类
			for(int i=0;i<menuList.size();i++){
		      	if(product.getMid()==menuList.get(i).getId()){     
		      		product
	      		} 
			}
  		}*/
        //返回信息      
        mv.addObject("page",page);
        mv.addObject("productList",productList);
        mv.setViewName("seller/showProduct");
		return mv;
	}
	
	//商家删除商品
	@RequestMapping(value="/deleteProduct")
	public String deleteProduct(Integer id,Integer seller_id,int pageNow,
			Model model,RedirectAttributes arr){
		
		//删除操作
		int flag=sellerService.deleteProduct(id);
		if(flag>0){
			model.addAttribute("deleteMessage", "success");
		}
		else{
			model.addAttribute("deleteMessage", "fail");
		}
		arr.addAttribute("seller_id", seller_id);
		arr.addAttribute("pageNow", pageNow);
		return "redirect:/seller/pageSelectAllProduct";
	}
	
	//管理员添加商品
	@RequestMapping(value="/addProduct")
	public String addProduct(HttpServletRequest request,Model model){
		
		Product product=new Product();
		FileUpLoadUtil file=FileUpLoadUtil.upload(request);
		product.setSeller_id(Integer.valueOf(file.getParameter("seller_id")));
		product.setImage(file.getParameter("image"));
		product.setMid(Integer.valueOf(file.getParameter("mid")));
		/*product.setNum(Integer.valueOf(file.getParameter("num")));*/
		product.setTitle(file.getParameter("title"));
		product.setPrice(Double.valueOf(file.getParameter("price")));
		int flag=sellerService.addProduct(product);
		if(flag>0){
			model.addAttribute("uploadMessage", "success");
		}
		else{
			model.addAttribute("uploadMessage", "fail");
		}
		return null;
	}
	
	//商家根据条件查询商品
	@RequestMapping(value="/queryProductByKey")
	public ModelAndView queryKeyProduct(ModelAndView mv,
			String titleKey,String price,String collect,String mid){
/*		System.out.println(titleKey+"*"+price+"*"+collect+"*"+mid);
*/
		
		Integer price1,price2,collect1,collect2,midInt;
		if(price==null || "".equals(price)){
			//默认值，
			price1=null;
			price2=null;
		}
		else{
			//分割参数
			String []arrPrice=price.split("~");
			price1=Integer.valueOf(arrPrice[0]);
			price2=Integer.valueOf(arrPrice[1]);
		}
		if(collect==null || "".equals(collect)){
			//默认值，
			collect1=null;
			collect2=null;
		}
		else{
			//分割参数
			String []arrCollect=collect.split("~");			
			collect1=Integer.valueOf(arrCollect[0]);
			collect2=Integer.valueOf(arrCollect[1]);
		}
		if(mid==null || "".equals(mid)){
			midInt=null;
		}
		else{
			midInt=Integer.valueOf(mid);
		}
		
/*		System.out.println(titleKey+" "+price1+" "+price2+" "+collect1+" "+collect2+" "+midInt);
*/		//查询商品
		List<Product>product=sellerService.queryProduct(titleKey,price1,price2,collect1,collect2,midInt);
		/*for (Product product2 : product) {
			System.out.print(product2.getTitle()+" ");
		}*/
		mv.addObject("productList",product);
		mv.addObject("titleKey", titleKey);
		//商品分类菜单
		List<Menu>menu=productService.selectMenuName();
		mv.addObject("menuList", menu);
		
		mv.setViewName("seller/queryProduct");
		
		return  mv;
	}
}
