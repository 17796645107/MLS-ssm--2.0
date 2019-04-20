package com.dn.service;

import java.util.List;

import com.dn.domain.Page;
import com.dn.domain.Product;
import com.dn.domain.Seller;

//管理员业务接口
public interface SellerService {

	//商家登录
	Seller login(String username, String password);

	//获取商家所有商品总记录数
	int getCount(Integer seller_id);

	//分页查询所有商品
	List<Product> pageSelectAllProduct(Integer seller_id,Page page);

	//商家添加商品
	int addProduct(Product product);
	
	//商家删除商品
	int deleteProduct(Integer id);

	//商家动态查询商品
	List<Product> queryProduct(String titleKey, Integer price1, Integer price2,
			Integer collect1, Integer collect2, Integer midInt);
	
	//所有商品总记录数
	int getCount();
}
