package com.dn.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dn.dao.ProductDao;
import com.dn.domain.Cart;
import com.dn.domain.Menu;
import com.dn.domain.Num;
import com.dn.domain.Product;
import com.dn.service.ProductService;
//商品Service实现类
@Service("productService")
public class ProductServiceImpl implements ProductService {

	//自动注入productMapper
	@Autowired
	private ProductDao productDao;

	//查询所有商品
	public List<Product> selectAllProduct() {
		/*List<Product>product=productDao.selectAllProduct();
		for (Product product2 : product) {
			product2.setPrice(PriceToDouble.conversion(product2.getPrice()));
		}*/
		return productDao.selectAllProduct();
	}

	//查询单个商品
	public List<Product> selectOneProduct(Integer id) {
		return productDao.selectOneProduct(id);
	}

	//添加商品到购物车
	public int addToCart(Cart cart) {
		return productDao.addToCart(cart);
	}

	//查询商品总记录数
	public int selectCountFromProduct() {
		return productDao.selectCountFromProduct();
	}

	//查询菜单列表
	public List<Menu> selectMenuName() {
		return productDao.selectMenuName();
	}

	//推荐商品
	public Product recommendOneProduct(int rid) {
		return productDao.recommendOneProduct(rid);
	}

	//显示商品库存
	public Integer selectProductNum(Num num) {
		return productDao.selectProductNum(num);
	}

	/*//查询商品颜色
	public List<Color> selectAllColor() {
		return productDao.selectAllColor();
	}

	//查询商品尺寸
	public List<Size> selectAllSize() {
		return productDao.selectAllSize();
	}*/
}
