package com.dn.service;

/*import java.util.List;*/

import java.util.List;

import com.dn.domain.Address;
import com.dn.domain.Product;
import com.dn.domain.User;
//用户service接口
public interface UserService {
	//用户注册
	int register(String telephone,String password,String nickname);
	
	//用户登陆
	User login(String telephone, String password);
	
	//查询手机号是否被注册过
	String selectTelephone(String telephone);
	
	//读取用户个人信息
	User selectUserMessage(Integer id);
	
	//修改用户个人信息
	int modifyUserMessage(String email, String nickname,Integer id,String birthday,String sex);
	
	//读取收货地址
	List<Address> selectAllAddress(Integer user_id);
	
	//用户添加收货地址
	int addAddress(Address address);

	//用户删除收货地址
	void deleteAddressById(Integer id);

	//用户根据关键词查询商品
	List<Product> searchProductByKey(String key);
	
	//查询用户默认地址
	Address selectDefaultUserAddress(Integer id);

	//用户设置默认收货地址
	int setDefalutAddress(Integer id);
	
}
