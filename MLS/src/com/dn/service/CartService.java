package com.dn.service;

import java.util.List;

import com.dn.domain.Cart;
//购物车业务层类
public interface CartService {

	//遍历购物车
	List<Cart> selectAllToCart(Integer user_id);

	//删除购物车中单个商品
	int deleteProductFromCart(Integer id);

	//根据购物车查询购买用户
	Integer selectUserIdByCartId(Integer id);

	//查询单条购物车记录
	List<Cart> selectOneCart(Integer product_id, Integer user_id);

	//更新商品数量
	int updateProductNumberToCart(Integer product_number,Integer id);

	
}
