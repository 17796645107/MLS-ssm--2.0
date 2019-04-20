package com.dn.service;

import java.util.List;

import com.dn.domain.Address;
import com.dn.domain.Cart;
import com.dn.domain.Order;

//订单业务层接口
public interface OrderService {

	//移除购物车中的商品
	int removeProductFromCart(int[] idArr);

	//将商品和用户地址添加到订单表中
	void addToOrder(Cart cart, Address address);

	//查询所有订单
	List<Order> selectAllOrder(Integer id);

	//查询单个订单
	Order selectOneOrder(Integer id);

	//减库存
	int minuteProductNum(String product_color, String product_size,
			Integer product_number);

	//更新订单状态：完成订单
	void updateOrderToComplete(Integer id);

	//商家查看订单
	List<Order> queryOrderFromSeller(Integer seller_id);

	//商家发货
	int updateOrderToGoods(Integer id);

	//用户确认收货
	void updateOrderToTakeGoods(Integer id);
}
