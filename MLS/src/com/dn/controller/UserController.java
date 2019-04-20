package com.dn.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dn.domain.Address;
import com.dn.domain.Product;
import com.dn.domain.User;
import com.dn.service.UserService;
//用户控制器类
@Controller
@RequestMapping(value="/user")
public class UserController {

	//自动注入userService
	@Autowired
	@Qualifier("userService")
	private UserService userService;
	
	//跳转到注册页面
	@RequestMapping(value="/registerFrom")
	public String forwardRegister(){
		return "registerFrom";
	}
	//用户注册
	@RequestMapping(value="/register")
	public String register(HttpSession session,
			String telephone,String password,String nickname,Model model){
			int flag=userService.register(telephone,password,nickname);			
			if(flag>0){
				User user=userService.login(telephone,password);
				session.setAttribute("USER", user);
				return "redirect:/product/shop";
			}
			else{
				return "registerFrom";
			}		
	}
	
	//跳转到登录页面
	@RequestMapping(value="/loginFrom")
	public String loginFrom(){
		return "loginFrom";
	}
	
	@RequestMapping(value="/login")
	//用户登录
	public ModelAndView login(
			ModelAndView mv,HttpSession session,String telephone,String password){
		
		User user=userService.login(telephone,password);
		if(user!=null){
			session.setAttribute("USER", user);
			mv.setViewName("redirect:/product/shop");
		}
		else{
			mv.addObject("ErrorMessage", "账号或密码错误，请重试");
			mv.setViewName("loginFrom");
		}
		return mv;		
	}
	
	//AjAX异步判断手机号是否被注册
	@RequestMapping(value="/cheackUsername")
	public String checkUsername(String telephone,
			HttpServletResponse response) throws IOException{
		response.setCharacterEncoding("utf-8");
		
		if(telephone==null || "".equals(telephone)){
			response.getWriter().print("请输入手机号");		
		}
		else{	
			String queryTelephone=userService.selectTelephone(telephone);//
			if(queryTelephone!=null){
				response.getWriter().print("手机号已被注册");
			}
			else{
				response.getWriter().print("手机号可以使用");
			}
		}	
		return null;
	}
	
	//用户根据关键字查询商品
	@RequestMapping(value="/searchProductByKey")
	public String searchProductByKey(String key,Model model){
		List<Product>productList=userService.searchProductByKey(key);
		model.addAttribute("productList", productList);
		model.addAttribute("key", key);
		return "searchResult";
	}
	
	//跳转到个人中心
	@RequestMapping(value="/personal")
	public String toPersonal(){
		return "personal/personal";
	}
	
	//用户注销
	@RequestMapping(value="/logout")
	public String logout(HttpSession session){
		session.removeAttribute("USER");
		return "redirect:/product/shop";
	}
	
	
	//跳转到个人信息
	@RequestMapping(value="/personalMessage")
	public String toPersonalMessage(Integer id,Model model,HttpSession session){

		if(id!=null){
			User user=userService.selectUserMessage(id);
			model.addAttribute("UserMessage", user);
		}
		
		return "personal/personalMessage";
	}
	
	//跳转到修改密码
	@RequestMapping(value="/personalPassword")
	public String toPersonalPassword(){
		return "personal/personalPassword";
	}
	
	//修改个人信息
	@RequestMapping(value="/modifyPersonalMessage")
	public String modifyPersonalMessage(
			String email,String nickname,Integer id,RedirectAttributes arr,
			String birthday,String sex,Model model){
		
		int flag=userService.modifyUserMessage(email,nickname,id,birthday,sex);
		
		if(flag>0){
			model.addAttribute("modifyResult", "success");
		}
		else{
			model.addAttribute("modifyResult", "fail");
		}
		arr.addAttribute("id", id);
		return "redirect:/user/personalMessage";
	}
	
	//读取收货地址,跳转到收货地址页面
	@RequestMapping(value="/selctAllAddress")
	public String userSelectAllAdress(Integer user_id,Model model){
		List<Address>addresslisst=userService.selectAllAddress(user_id);
		model.addAttribute("addressList", addresslisst);
		return "personal/personalAddress";
	}
	
	//用户添加收货地址
	@RequestMapping(value="addAddress")
	public String userAddAdress(Address address,RedirectAttributes arr){
		int flag=userService.addAddress(address);//添加操作
		if(flag>0){
			arr.addAttribute("user_id", address.getUser_id());
		}
		return "redirect:/user/selctAllAddress";//跳转到读取收货地址方法
	}
	
	//用户删除收货地址
	@RequestMapping(value="/deleteAddressById")
	public String deleteAddressById(Integer id,Integer user_id,RedirectAttributes arr){
		userService.deleteAddressById(id);
		arr.addAttribute("user_id", user_id);
		return "redirect:/user/selctAllAddress";//跳转到读取收货地址方法
	}
	
	//用户设置默认收货地址
	@RequestMapping(value="/setDefalutAddress")
	public String setDefalutAddress(Integer id,RedirectAttributes arr){
		int flag=userService.setDefalutAddress(id);
		if(flag>0){
			arr.addAttribute("user_id", id);
		}
		return "redirect:/user/selctAllAddress";
	}
}
