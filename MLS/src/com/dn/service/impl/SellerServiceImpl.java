package com.dn.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;





import com.dn.dao.SellerDao;
import com.dn.domain.Page;
import com.dn.domain.Product;
import com.dn.domain.Seller;
//管理员业务实现类
import com.dn.service.SellerService;
@Service("sellerService")
public class SellerServiceImpl implements SellerService {

	//自动注入adminMapper
	@Autowired
	private SellerDao sellerDao;
	
	//登陆方法
	public Seller login(String username, String password) {
		return sellerDao.login(username,password);
	}

	//获取总记录数
	public int getCount(Integer seller_id) {
		return sellerDao.getCount(seller_id);
	}

	//分页查询所有商品
	public List<Product> pageSelectAllProduct(Integer seller_id,Page page) {
		return sellerDao.pageSelectAllProduct(seller_id,page);
	}

	//商家添加商品
	public int addProduct(Product product) {
		return sellerDao.addProduct(product);
	}

	//商家修改商品
	public Product modifyProduct(Product peoduct) {
		return sellerDao.modifyProduct(peoduct);
	}

	//商家删除商品
	public int deleteProduct(Integer id) {
		return sellerDao.deleteProduct(id);
	}

	//商家动态查询商品
	public List<Product> queryProduct(String titleKey, Integer price1,
			Integer price2, Integer collect1, Integer collect2, Integer midInt) {
		return sellerDao.queryProduct(titleKey,price1,price2,collect1,collect2,midInt);
	}

	//所有商品总记录数
	public int getCount() {
		return sellerDao.getConut();
	}
	
	

}
