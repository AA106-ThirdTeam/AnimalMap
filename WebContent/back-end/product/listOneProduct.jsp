<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ page import="com.product.model.*"%>
<%@ page import="com.product_kind.model.*"%>
<%-- 此頁練習採用 Script 的寫法取值 --%>

<%-- 取出 Concroller EmpServlet.java已存入request的EmpVO物件--%>
<%ProductVO productVO = (ProductVO) request.getAttribute("productVO"); %>

<%--取出對應product_kind物件 --%>
<%
	Product_kindService product_kindSvc = new Product_kindService();
	Product_kindVO product_kindVO = product_kindSvc.getOneProduct_kind(productVO.getProduct_kind_no());
%>
<html>
<head>
<title>商品資料~~~listOneProduct</title>
</head>
<body>
	<h1>listOneProduct.jsp</h1>
	<b><font color=red>採Script寫法取值</font></b>
	<table border='1' cellpadding='5' cellspacing='0' width='1200'>
		<tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
			<td>
			<h3>商品資料-listOneProduct</h3>
				<a href="<%=request.getContextPath()%>/back-end/select_page.jsp"><img src="images/back1.gif" width="100" height="32" border="0">回首頁</a>
			</td>
		</tr>
	</table>
	
	<table border='1' bordercolor='#ccccff' width='1200'>
		<tr>
			<th>商品編號</th>
			<th>商品名稱</th>
			<th>商品簡介</th>
			<th>商品價格</th>
			<th>商品庫存量</th>
			<th>商品圖片</th>			
			<th>商品圖片（縮圖</th>
			<th>商品上下架狀態</th>
			<th>商品建立日期</th>
			<th>商品資訊</th>
			<th>商品類別編號</th>
		</tr>
		<tr align='center' valign='middle'>
			<td><%=productVO.getProduct_no()%></td>
			<td><%=productVO.getProduct_name()%></td>
			<td><%=productVO.getProduct_introduction()%></td>
			<td><%=productVO.getProduct_price()%></td>
			<td><%=productVO.getProduct_stock()%></td>
			<td><img src="${productVO.product_picture_large}" width="auto" height="100"></td>
   			<td><img src="${productVO.product_picture_small}" width="auto" height="100"></td>
			<td><%=productVO.getProduct_status()%></td>
			<td><%=productVO.getProduct_create_date()%></td>
			<td><%=productVO.getProduct_info()%></td>
			<td><%=productVO.getProduct_kind_no()%>【<%=product_kindVO.getProduct_kind_name()%>】</td>
		</tr>
	
	</table>
</body>
</html>