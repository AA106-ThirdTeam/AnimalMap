<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.product.model.*"%>
<%-- 此頁練習採用 EL 的寫法取值 --%>

<%
	ProductService productSvc = new ProductService();
	List<ProductVO> list = productSvc.getAll();
	pageContext.setAttribute("list",list);
%>
<jsp:useBean id="product_kindSvc" scope="page" class="com.product_kind.model.Product_kindService" />
<style>
	.wrapper {
	  text-align: center;
	  border-bottom: 3px solid #343436;
	  background-color: #333;
	}
	table{
	  margin: auto;
	  padding: 20px;
	  border-collapse: separate;
	  border-spacing: 0;
	}
	tr{
	  border: 1px solid #E0607E;
	}
	td{
	
	  padding: 10px 30px;
	  background-color:#e4edf5;
	  color: #000;
	}
	th{
	
	  padding: 10px 30px;
	  background-color:	#d1cbee;
	  color: #000;
	}
	/*第一欄第一列：左上*/
	tr:first-child th:first-child{
	  border-top-left-radius: 10px;
	}
	/*第一欄最後列：左下*/
	tr:last-child td:first-child{
	  border-bottom-left-radius: 10px;
	}
	/*最後欄第一列：右上*/
	tr:first-child th:last-child{
	  border-top-right-radius: 10px;
	}
	/*最後欄第一列：右下*/
	tr:last-child td:last-child{
	  border-bottom-right-radius: 10px;
	}
</style>
<html>
<head>
<title>listAllProduct.jsp</title>
</head>
<body background="<%=request.getContextPath() %>/back-end/images/bgp.jpg">
	<%-- 錯誤表列 --%>
<c:if test="${not empty errorMsgs}">
	<font color='red'>請修正以下錯誤:
	<ul>
		<c:forEach var="message" items="${errorMsgs}">
			<li>${message}</li>
		</c:forEach>
	</ul>
	</font>
</c:if>
<table width='1400'>
	
		<tr class="table-tr-content">
			<th>商品編號</th>
			<th>商品名稱</th>
			<th>商品簡介</th>
			<th>商品價格</th>
			<th>商品庫存量</th>
			<th>商品圖片</th>			
<!-- 			<th>商品圖片（縮圖</th> -->
			<th>上下架狀態</th>
			<th>建立日期</th>
			<th>商品資訊</th>
			<th>商品類別編號</th>
			<th>修改</th>
			<th>刪除</th>
		</tr>
		<%@ include file="pages/page1.file" %> 
	<c:forEach var="productVO" items="${list}" begin="<%=pageIndex%>" end="<%=pageIndex+rowsPerPage-1%>">
		<tr class="table-tr-content" align='center' valign='middle' ${(productVO.product_no==param.product_no) ? 'bgcolor=#CCCCFF':''}><!--將修改的那一筆加入對比色而已-->
			<td>${productVO.product_no}</td>
			<td>${productVO.product_name}</td>
			<td>${productVO.product_introduction}</td>
			<td>${productVO.product_price}</td>
			<td>${productVO.product_stock}</td>
<%-- 			<td><img src="${productVO.product_picture_large}" width="auto" height="100"></td> --%>
  			<td><img src="${productVO.product_picture_small}" width="auto" height="100"></td>
			<td>${productVO.product_status}</td>
			<td>${productVO.product_create_date}</td>
			<td>${productVO.product_info}</td>
			<td>${productVO.product_kind_no}
				<c:forEach var="product_kindVO" items="${product_kindSvc.all}">
                    <c:if test="${productVO.product_kind_no==product_kindVO.product_kind_no}">【${product_kindVO.product_kind_name}】
                    </c:if>
                </c:forEach>
			</td>
			<td>
				<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/back-end/product/product.do">
			    	<input type="submit" value="修改">
			     	<input type="hidden" name="product_no" value="${productVO.product_no}">
			     	<input type="hidden" name="requestURL"	value="<%=request.getServletPath()%>"><!--送出本網頁的路徑給Controller-->
			     	<input type="hidden" name="whichPage"	value="<%=whichPage%>">               <!--送出當前是第幾頁給Controller-->
			    	<input type="hidden" name="action"	value="getOne_For_Update">
				</FORM>
			</td>
			<td>
			  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/back-end/product/product.do">
			    <input type="submit" value="刪除">
			    <input type="hidden" name="product_no" value="${productVO.product_no}">
			    <input type="hidden" name="requestURL"	value="<%=request.getServletPath()%>"><!--送出本網頁的路徑給Controller-->
			    <input type="hidden" name="whichPage"	value="<%=whichPage%>">               <!--送出當前是第幾頁給Controller-->
			    <input type="hidden" name="action"value="delete"></FORM>
			</td>
		</tr>	
	</c:forEach>
</table>
<%@ include file="pages/page2.file" %>
</body>
</html>