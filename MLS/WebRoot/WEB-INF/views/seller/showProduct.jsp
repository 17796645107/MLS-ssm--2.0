<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <base href="<%=basePath%>">    
    <meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
    <title>My JSP 'showStudentManager.jsp' starting page</title>   
	<style type="text/css">
		a{
			color:black;
		}
		a:HOVER{
			color: red;
		}
		table input{
			width:90%;
		}
		/* .ceng{
			display: none;
		}
		.bian{
			position:absolute; 
			top:100px; 
			left:20%;
			z-index:10; 
			border: 1px solid black;
			padding:20px;
			background-color: gray;
		} */
		img{
			width:80px;
			height:80px;
		}
	</style>
	<script type="text/javascript" src="Resources/js/goodslist.js"></script>
	<script type="text/javascript" src="Resources/js/seller/showProduct.js"></script>
    <script type="text/javascript" src="Resources/js/jquery-1.4.2.min.js"></script>
   
  </head>  
  <body>
  		<h1>商品列表</h1>
    	<table  width="1127px">
    		<tr>
    			<th width="5%"><input type="checkbox" id="selectall" name="case" onclick="cli('case')" /></th>
    			<th width="5%">编号</th>
    			<th width="10%">图片</th>
    			<th width="45%">名称</th>
    			<!-- <th width="5%">库存</th> -->
    			<th width="5%">价格</th>
    			<th width="5%">分类</th>
    			<th width="10%">操作</th>
    			<td width="10%"><input type="button" value="批量删除" onclick="todelete()" /></td>
    		</tr>
    	</table>
   		<c:forEach items="${productList }" var="product">   			
			<form action="seller/deleteProduct" method="post">
				<table>
					<tr>
						<td width="5%"><input type="checkbox" id="case" name="case"/></td>
						<td width="5%"><span>${product.id }</span></td>
	    				<td width="10%"><img src="Resources/images/products/${product.image }"/></td>
	    				<td width="45%">
	    					<input type="hidden" id="id" name="id" value="${product.id}">
	    					<input type="hidden" id="seller_id" name="seller_id" value="${product.seller_id }">
	    					<input type="hidden" id="pageNow" name="pageNow" value="${page.pageNow}">
	    					<input type="hidden" id="retunMessage" value="${deleteMessage}">
	    					<input type="text" class="pname" value="${product.title }"/>
	    				</td>
	    			    <%-- <td width="5%"><input type="text" class="pdesc" value="${product.num }"/></td>	 --%>
		                <td width="5%"><input type="text" class="mprice" value="${product.price }" /></td>	
		                <td width="5%">
		                	<c:choose>
               					<c:when test="${product.mid==1}"><input type="text" value="上衣"></c:when>
               					<c:when test="${product.mid==2}"><input type="text" value="裙子"></c:when>
               					<c:when test="${product.mid==3}"><input type="text" value="裤子"></c:when>
               					<c:when test="${product.mid==4}"><input type="text" value="女鞋"></c:when>
               					<c:when test="${product.mid==5}"><input type="text" value="包包"></c:when>
               					<c:when test="${product.mid==6}"><input type="text" value="配饰"></c:when>
               					<c:when test="${product.mid==7}"><input type="text" value="美妆"></c:when>
               					<c:when test="${product.mid==8}"><input type="text" value="男友"></c:when>
               					<c:when test="${product.mid==9}"><input type="text" value="童装"></c:when>
               					<c:otherwise><input type="text" value="家居"></c:otherwise>
               				</c:choose>
		                </td>
	                    <td width="10%">
		                    <input type="submit"  value="删除"/>
		    				<input type="submit"  value="修改"/>
		    			</td>
		    			<td width="10%"></td>
					</tr>   
   				</table>
   			</form>  						
   		</c:forEach>
   		<!-- 分页功能 start -->
            <div align="center">
                <font size="2">共 ${page.totalPageCount} 页</font> <font size="2">第${page.pageNow} 页
                </font> <a href="seller/pageSelectAllProduct?pageNow=1&seller_id=${SELLER.id}">首页</a>
                <c:choose>
                    <c:when test="${page.pageNow - 1 > 0}">
                        <a href="seller/pageSelectAllProduct?pageNow=${page.pageNow - 1}&seller_id=${SELLER.id}">上一页</a>
                    </c:when>
                    <c:otherwise>
                    </c:otherwise>
                    <%-- <c:when test="${page.pageNow - 1 <= 0}">
                        <a href="seller/pageSelectAllProduct?pageNow=1&seller_id=${SELLER.id}">上一页</a>
                    </c:when> --%>
                </c:choose>
                <c:choose>
                    <%-- <c:when test="${page.totalPageCount==0}">
                        <a href="seller/pageSelectAllProduct?pageNow=${page.pageNow}&seller_id=${SELLER.id}">下一页</a>
                    </c:when> --%>
                    <c:when test="${page.pageNow + 1 <= page.totalPageCount}">
                        <a href="seller/pageSelectAllProduct?pageNow=${page.pageNow + 1}&seller_id=${SELLER.id}">下一页</a>
                    </c:when>
                    <%-- <c:when test="${page.pageNow + 1 >= page.totalPageCount}">
                        <a href="seller/pageSelectAllProduct?pageNow=${page.totalPageCount}&seller_id=${SELLER.id}">下一页</a>
                    </c:when> --%>
                </c:choose>
                <c:choose>
                    <c:when test="${page.totalPageCount==0}">
                        <a href="seller/pageSelectAllProduct?pageNow=${page.pageNow}&seller_id=${SELLER.id}">尾页</a>
                    </c:when>
                    <c:otherwise>
                        <a href="seller/pageSelectAllProduct?pageNow=${page.totalPageCount}&seller_id=${SELLER.id}">尾页</a>
                    </c:otherwise>
                </c:choose>
            </div>
            <!-- 分页功能 End -->
  </body>
</html>
						