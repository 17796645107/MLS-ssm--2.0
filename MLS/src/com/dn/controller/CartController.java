package com.dn.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dn.domain.Cart;
import com.dn.service.CartService;

//购物车控制器类
@Controller
@RequestMapping(value="/cart")
public class CartController {
	
	//自动注入CartService
	@Autowired
	@Qualifier("cartService")
	private CartService cartService;
		
		
	//跳转到购物车页面，并且遍历购物车
	@RequestMapping(value="/toCart")
	public String selectAllToCart(Model model,Integer user_id){
		//判断用户是否登录
		if(user_id==null){
			return "redirect:/user/loginFrom";
		}
		else{
			List<Cart>cartList=cartService.selectAllToCart(user_id);
			model.addAttribute("cartList", cartList);
			return "goodCart";
		}
	}
	
	//删除购物车中单个商品
	@RequestMapping(value="/deleteProductFromCart")
	public String deleteOneCart(Integer id,Integer user_id,RedirectAttributes arr) throws IOException{
		
		cartService.deleteProductFromCart(id);//删除购物车中商品			
		arr.addAttribute("user_id", user_id);
		//跳转到购物车页面，并且遍历购物车
		return "redirect:/cart/toCart";
	}
}
