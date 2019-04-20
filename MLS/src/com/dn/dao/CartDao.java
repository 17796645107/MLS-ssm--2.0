package com.dn.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import static com.dn.util.DBContext.cartTableName;
import com.dn.domain.Cart;
//购物车Dao层
public interface CartDao {

	//遍历购物车
	@Select("select * from "+cartTableName+" where user_id=#{user_id}")
	List<Cart> selectAllToCart(Integer user_id);

	//删除购物车中单个商品
	@Delete("delete from "+cartTableName+" where id=#{id}")
	int deleteProductFromCart(Integer id);

	//根据购物车查询购买用户
	@Select("select user_id from "+cartTableName+" where id=#{id}")
	Integer selectUserIdByCartId(@Param("id")Integer id);

	//查询单条购物车记录
	@Select("select * from "+cartTableName+" where product_id=#{product_id} and user_id=#{user_id}")
	List<Cart> selectOneCart(@Param("product_id")Integer product_id,@Param("user_id")Integer user_id);

	//更新商品数量
	@Update("update "+cartTableName+" set product_number=#{product_number} where id=#{id}")
	int updateProductNumberToCart(@Param("product_number")Integer product_number,@Param("id")Integer id);

	/*@Select("select product_number form "+cartTableName+" where id=#{Rcart}")
	Integer selectProductNumberByCart(Integer Rcart);*/

}
