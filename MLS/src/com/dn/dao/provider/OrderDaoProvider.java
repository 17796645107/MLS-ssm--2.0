package com.dn.dao.provider;

import static com.dn.util.DBContext.cartTableName;
import static com.dn.util.DBContext.orderTableName;

import com.dn.domain.Address;
import com.dn.domain.Cart;
public class OrderDaoProvider {

	String sql="";
	
	//移除购物车中的商品
	public String removeProductFromCart(int[]idArr){
		StringBuilder sql=new StringBuilder();
		for(int i=0;i<idArr.length;i++){
			sql.append("delete from "+cartTableName+" where id="+idArr[i]);
		}	
		return sql.toString();
	}
	
	//将商品和用户地址添加到订单表中
	public String addToOrder(Cart cart, Address address){
		sql="insert into "+orderTableName+"(user_id,product_id,product_title," +
				"product_price,product_color,product_size,product_number,product_image," +
				"user_name,user_address,user_province,user_city,user_area,user_postcode,user_telephone)" +
				"values('"+cart.getUser_id()+"','"+cart.getProduct_id()+"','"+cart.getProduct_title()+"','"+cart.getProduct_price()+"','" +
				cart.getProduct_color()+"','"+cart.getProduct_size()+"','" +cart.getProduct_number()+"','"+cart.getProduct_image()+"','" +
				address.getName()+"','"+address.getAddress()+"','"+address.getProvince()+"','" +address.getCity()+"','"+address.getArea()+"','"+
				address.getPostcode()+"','" +address.getTelephone()+"');";
		return sql;
	}
}
