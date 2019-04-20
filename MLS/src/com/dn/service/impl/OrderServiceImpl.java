package com.dn.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.dn.dao.OrderDao;
import com.dn.domain.Address;
import com.dn.domain.Cart;
import com.dn.domain.Order;
import com.dn.service.OrderService;
//订单业务层实现类
@Service("orderService")
public class OrderServiceImpl implements OrderService {

	//自动注入cartDao
	@Autowired
	@Qualifier("orderDao")
	private OrderDao orderDao;
	
	//移除购物车中的商品
	public int removeProductFromCart(int[] idArr) {
		return orderDao.removeProductFromCart(idArr);
	}

	//将商品和用户地址添加到订单表中
	public void addToOrder(Cart cart, Address address) {
		orderDao.addToOrder(cart,address);
	}

	//查询所有订单
	public List<Order> selectAllOrder(Integer id) {
		return orderDao.selctAllOrder(id);
	}

	//查询单个订单
	public Order selectOneOrder(Integer id) {
		return orderDao.selectOneOrder(id);
	}

	//减库存
	public int minuteProductNum(String product_color, String product_size,
			Integer product_number) {
		return orderDao.minuteProductNum(product_color,product_size,product_number);
	}

	//更新订单状态：完成订单
	public void updateOrderToComplete(Integer id) {
		orderDao.updateOrderToComplete(id);
	}

	//商家查看订单
	public List<Order> queryOrderFromSeller(Integer seller_id) {
		return orderDao.queryOrderFromSeller(seller_id);
	}

	//商家发货
	public int updateOrderToGoods(Integer id) {
		
		 return orderDao.updateOrderToGoods(id);
	}

	//用户确认收货
	public void updateOrderToTakeGoods(Integer id) {
		orderDao.updateOrderToTakeGoods(id);
	}

}
