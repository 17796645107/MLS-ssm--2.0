package com.dn.dao;

import java.util.List;

import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.dn.dao.provider.OrderDaoProvider;
import com.dn.domain.Address;
import com.dn.domain.Cart;
import com.dn.domain.Order;
import static com.dn.util.DBContext.orderTableName;
//订单dao层
public interface OrderDao {

	//移除购物车中的商品
	@DeleteProvider(type=OrderDaoProvider.class,method="removeProductFromCart")
	int removeProductFromCart(int[] idArr);

	//将商品和用户地址添加到订单表中
	@InsertProvider(type=OrderDaoProvider.class,method="addToOrder")
	void addToOrder(Cart cart, Address address);

	//查询所有订单
	@Select("select * from "+orderTableName+" where user_id=#{id}")
	List<Order> selctAllOrder(Integer id);

	//查询单个订单
	@Select("select * from "+orderTableName+" where id=#{id}")
	Order selectOneOrder(Integer id);

	//减库存
	@Update("update tb_product_num set num=num-#{product_number} where color=#{product_color} and size=#{product_size}")
	int minuteProductNum(@Param("product_color")String product_color,@Param("product_size") String product_size,
			@Param("product_number")Integer product_number);

	//更新订单状态：完成订单
	@Update("update "+orderTableName+" set status=1 where id=#{id}")
	void updateOrderToComplete(Integer id);

	//商家查看订单
	@Select("select * from "+orderTableName+" where seller_id=#{seller_id}")
	List<Order> queryOrderFromSeller(Integer seller_id);

	//商家发货
	@Update("update "+orderTableName+" set status=2 where id=#{id}")
	int updateOrderToGoods(Integer id);

	//用户确认收货
	@Update("update "+orderTableName+" set status=3 where id=#{id}")
	void updateOrderToTakeGoods(Integer id);

}
