package com.dn.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import com.dn.dao.provider.ProductDaoProvider;
import com.dn.domain.Cart;
import com.dn.domain.Menu;
import com.dn.domain.Num;
import com.dn.domain.Product;

import static com.dn.util.DBContext.productTableName;
import static com.dn.util.DBContext.cartTableName;
import static com.dn.util.DBContext.numTableName;
//商品dao接口
public interface ProductDao {

	//查询所有商品
	@Select("select * from "+productTableName+" where status=1")
	List<Product> selectAllProduct();

	//查询单个商品
	/*@Select("select * from "+productTableName+" where id=#{id} and status=1")
	Product selectOneProduct(Integer id);*/

	//查询单个商品
	@SelectProvider(type=ProductDaoProvider.class,method="selectOneProduct")
	List<Product> selectOneProduct(Integer id);
	
	
	//添加商品到购物车
	@Insert("insert into "+cartTableName+" (user_id,product_id,product_title,product_number,product_image,product_price,product_color,product_size)values(#{cart.user_id},#{cart.product_id},#{cart.product_title},#{cart.product_number},#{cart.product_image},#{cart.product_price},#{cart.product_color},#{cart.product_size})")
	int addToCart(@Param("cart")Cart cart);

	
	//查询商品总记录数
	@Select("select count(*) from "+productTableName+" where status=1")
	int selectCountFromProduct();

	//查询菜单列表
	@Select("select * from tb_product_menu")
	List<Menu> selectMenuName();

	//推荐商品
	@Select("select * from "+productTableName+" where id=#{rid} and status=1")
	Product recommendOneProduct(int rid);

	//显示商品库存
	@Select("select num from "+numTableName+" where product_id=#{num.product_id} and color=#{num.color} and size=#{num.size}")
	Integer selectProductNum(@Param("num")Num num);

	/*//查询商品颜色
	@Select("select * from tb_product_color")
	List<Color> selectAllColor();

	//查询商品尺寸
	@Select("select * from tb_product_size")
	List<Size> selectAllSize();*/
	
}
