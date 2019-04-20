package com.dn.dao;

import java.util.List;
import static com.dn.util.DBContext.addressTableName;
import static com.dn.util.DBContext.userTableName;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;

import com.dn.dao.provider.UserDaoProvider;
import com.dn.domain.Address;
import com.dn.domain.Product;
import com.dn.domain.User;
//用户Dao类
public interface UserDao {

	//用户注册 
	@Insert("insert into "+userTableName+"(telephone,password,nickname)values(#{telephone},#{password},#{nickname})")
	int register(@Param("telephone")String telephone,@Param("password")String password,@Param("nickname")String nickname);
	
	//用户登陆
	@Select("select * from "+userTableName+" where telephone=#{telephone} and password=#{password}")
	User login(@Param("telephone")String telephone,@Param("password")String password);
	
	//更新密码
	@Update("update "+userTableName+" set password=#{password}")
	void update(@Param("password") String password);
	 
	//删除用户
	@Delete("delete from "+userTableName+" where id=#{id}")
	void delete(@Param("uid")Integer uid);

	//查询手机号是否已经注册过
	@Select("select telephone from "+userTableName+" where telephone=#{telephone}")
	String selectTelephone(String telephone);

	//读取用户个人信息
	@Select("select * from "+userTableName+" where id=#{id}")
	User selectUserMessage(Integer id);

	//修改用户个人信息
	@Update("update "+userTableName+" set email=#{email},nickname=#{nickname},birthday=#{birthday},sex=#{sex} where id=#{id} ")
	int modifyUserMessage(@Param("email")String email,@Param("nickname")String nickname,@Param("id")Integer id,@Param("birthday")String birthday,@Param("sex")String sex);

	//读取收货地址
	@Select("select * from "+addressTableName+" where user_id=#{user_id}")
	List<Address> selectAllAddress(Integer user_id);

	//用户添加收货地址
	@Insert("insert into "+addressTableName+"(user_id,address,name,province,city,area,postcode,telephone)values(#{address.user_id},#{address.address},#{address.name},#{address.province},#{address.city},#{address.area},#{address.postcode},#{address.telephone})")
	int addAddress(@Param("address")Address address);

	//用户删除收货地址
	@Delete("delete from "+addressTableName+" where id=#{id}")
	void deleteAddressById(Integer id);

	//用户根据关键词查询商品
	/*@Select("select * from "+productTableName+" where title like '%${key}%'")*/
	@SelectProvider(type=UserDaoProvider.class,method="searchProductByKey")
	List<Product> searchProductByKey(String key);

	//查询用户默认地址
	@Select("select * from "+addressTableName+" where status=1 and user_id=#{id}")
	Address selectDefaultUserAddress(Integer id);

	//用户设置默认收货地址
	@Update("update "+addressTableName+" set status=1 where id=#{id}")
	int setDefalutAddress(Integer id);
	
	
}
