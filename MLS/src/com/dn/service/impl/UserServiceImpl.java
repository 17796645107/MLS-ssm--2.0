package com.dn.service.impl;

/*import java.util.List;*/

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dn.dao.UserDao;
import com.dn.domain.Address;
import com.dn.domain.Product;
import com.dn.domain.User;
import com.dn.service.UserService;
//用户service实现类
@Service("userService")
public class UserServiceImpl implements UserService{
	
	//自动注入userMapper
	@Autowired
	private UserDao userDao;
	
	//用户注册
	public int register(String telephone, String password,String nickname) {
		 return userDao.register(telephone,password,nickname);
	}
	
	//用户登陆
	public User login(String telephone, String password) {
		return userDao.login(telephone,password);
	}

	//查询手机号
	public String selectTelephone(String telephone) {
		return userDao.selectTelephone(telephone);
	}

	//读取用户个人信息
	public User selectUserMessage(Integer id) {
		return userDao.selectUserMessage(id);
	}


	//修改用户个人信息
	public int modifyUserMessage(String email, String nickname, Integer id ,
			String birthday,String sex) {
		return  userDao.modifyUserMessage(email,nickname,id,birthday,sex);
	}

	//读取收货地址
	public List<Address> selectAllAddress(Integer user_id) {
		return userDao.selectAllAddress(user_id);
	}

	//用户添加收货地址
	public int addAddress(Address address) {
		return userDao.addAddress(address);
	}

	//用户删除收货地址
	public void deleteAddressById(Integer id) {
		userDao.deleteAddressById(id);
	}

	//用户根据关键词查询商品
	public List<Product> searchProductByKey(String key) {
		return userDao.searchProductByKey(key);
	}

	//查询用户默认地址
	public Address selectDefaultUserAddress(Integer id) {
		return userDao.selectDefaultUserAddress(id);
	}

	//用户设置默认收货地址
	public int setDefalutAddress(Integer id) {
		return userDao.setDefalutAddress(id);
	}

}
