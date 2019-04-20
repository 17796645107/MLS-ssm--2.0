package com.dn.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;

import com.dn.dao.provider.SellerDaoProvider;
import com.dn.domain.Page;
import com.dn.domain.Product;
import com.dn.domain.Seller;
import static com.dn.util.DBContext.productTableName;
import static com.dn.util.DBContext.sellerTableName;
//商家dao接口
public interface SellerDao {

	//登陆
	@Select("select * from "+sellerTableName+" where username=#{username} and password=#{password}")
	Seller login(@Param("username")String username,@Param("password")String password);

	//获取商家所属商品记录数
	@Select("select count(*) from "+productTableName+" where seller_id=#{seller_id} and status=1")
	int getCount(Integer seller_id);
	
	//所有商品总记录数
	@Select("select count(*) from "+productTableName+" where status=1")
	int getConut();
	
	//分页查询所有商品<!--startPos开始页 ， pageSize每页显示的记录条数-->
	@Select("SELECT * FROM "+productTableName+" where seller_id=#{seller_id} and status=1 limit #{page.startPos},#{page.pageSize}")
	List<Product> pageSelectAllProduct(@Param("seller_id")Integer seller_id,@Param("page")Page page);

	//商家添加商品
	/*@InsertProvider(type=ProductDaoProvider.class,method="adminAddProduct")*/
	@Insert("insert into "+productTableName+" (seller_id,mid,title,price,image)values(#{product.seller_id},#{product.mid},#{product.title},#{product.price},#{product.image})")
	int addProduct(@Param("product")Product product);


	//商家删除商品
	@Update("UPDATE tb_product SET status='2' WHERE id=#{id}")
	int deleteProduct(Integer id);

	//商家修改商品
	Product modifyProduct(Product peoduct);
	
	//商家根据关键词动态查询商品
	@SelectProvider(type=SellerDaoProvider.class,method="queryProductByKey")
	List<Product> queryProduct(String titleKey, Integer price1, Integer price2,
			Integer collect1, Integer collect2, Integer midInt);

	

}
