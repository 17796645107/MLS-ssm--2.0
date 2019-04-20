package com.dn.service;

import java.util.List;

import com.dn.domain.Cart;
import com.dn.domain.Menu;
import com.dn.domain.Num;
import com.dn.domain.Product;

//商品Service接口
public interface ProductService {

	//查询所有商品
	List<Product> selectAllProduct();

	//查询单个商品
	List<Product> selectOneProduct(Integer id);

	//添加商品到购物车
	int addToCart(Cart cart);

	//查询商品总记录数
	int selectCountFromProduct();

	//查询菜单列表
	List<Menu> selectMenuName();

	//推荐商品
	Product recommendOneProduct(int rid);

	//显示商品库存
	Integer selectProductNum(Num num);

	/*//查询商品颜色
	List<Color> selectAllColor();

	//查询商品尺寸
	List<Size> selectAllSize();*/

	
	

}
