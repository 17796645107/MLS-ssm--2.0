package com.dn.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.dn.dao.CartDao;
import com.dn.domain.Cart;
import com.dn.service.CartService;
//购物车业务层实现类
@Service("cartService")
public class CartServiceImpl implements CartService{

	//自动注入cartDao
	@Autowired
	@Qualifier("cartDao")
	private CartDao cartDao;
	
	//遍历购物车
	public List<Cart> selectAllToCart(Integer user_id) {
		return cartDao.selectAllToCart(user_id);
	}

	//删除购物车中单个商品
	public int deleteProductFromCart(Integer id) {
		return cartDao.deleteProductFromCart(id);
	}

	//根据购物车查询购买用户
	public Integer selectUserIdByCartId(Integer id) {
		return cartDao.selectUserIdByCartId(id);
	}

	//查询单条购物车记录
	public List<Cart> selectOneCart(Integer product_id, Integer user_id) {
		return cartDao.selectOneCart(product_id,user_id);
	}

	//更新商品数量
	public int updateProductNumberToCart(Integer product_number,Integer id) {
		return cartDao.updateProductNumberToCart(product_number,id);
	}


}
