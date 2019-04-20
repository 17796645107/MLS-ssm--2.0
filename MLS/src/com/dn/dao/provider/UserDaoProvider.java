package com.dn.dao.provider;

import static com.dn.util.DBContext.productTableName;
public class UserDaoProvider {

	String sql="";
	
	public String searchProductByKey(String key){	
		
		sql="select * from "+productTableName+" where title like '%"+key+"%'";
		
		return sql;
	}
}
