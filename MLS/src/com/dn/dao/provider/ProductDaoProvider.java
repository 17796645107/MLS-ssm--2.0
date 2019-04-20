package com.dn.dao.provider;
import static com.dn.util.DBContext.productTableName;
/*import static com.dn.util.DBContext.colorTableName;
import static com.dn.util.DBContext.sizeTableName;*/
import static com.dn.util.DBContext.numTableName;
import static com.dn.util.DBContext.cartTableName;
import com.dn.domain.Cart;
//sql语句
public class ProductDaoProvider {
	String sql="";
	
	//查询单个商品
	public String selectOneProduct(Integer id){
		sql="select * from "+productTableName+" p " +
			/*"LEFT JOIN "+colorTableName+" c on p.id=c.product_id " +
			"LEFT JOIN "+sizeTableName+" s on p.id=s.product_id " +*/
			"LEFT JOIN "+numTableName+" n on n.product_id=p.id " +
			"where id="+id+" and status=1";	
		return sql;	
	}
	
	//添加商品到购物车
	public String addToCart(final Cart cart){
		sql="insert into "+cartTableName+" ()";
		return sql;
	}
	
	
}
