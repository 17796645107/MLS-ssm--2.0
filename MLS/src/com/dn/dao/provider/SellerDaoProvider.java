package com.dn.dao.provider;

import org.apache.ibatis.jdbc.SQL;

import static com.dn.util.DBContext.productTableName;
public class SellerDaoProvider {

	//管理员关键词查询商品
	public String queryProductByKey(final String titleKey,final Integer price1,final Integer price2,
			final Integer collect1,final Integer collect2 ,final Integer midInt){		
		
		return new SQL(){
			{
				SELECT("*");
				FROM(productTableName);
				if(titleKey!=null){
					WHERE("title LIKE '%"+titleKey+"%'");
				}
				if(price1!=null && price2!=null){
					WHERE("price between "+price1+" and "+price2);
				}
				if(collect1!=null && collect2!=null){
					WHERE("collect between "+collect1+" and "+collect2);
				}
				if(midInt!=null){
					WHERE("mid="+midInt);
				}
			}
		}.toString();
	}
}
