 <%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.product.model.*"%>
<%-- 此頁練習採用 Script 的寫法取值 --%>

<%-- 取出 Concroller ProductServlet.java已存入request的ProductVO物件--%>
<%ProductVO productVO = (ProductVO) request.getAttribute("productVO");%>

<html>
<head>
<title>商品資料 - listOneProduct.jsp</title>
</head>
<body bgcolor='white'>
<b><font color=red>此頁練習採用 Script 的寫法取值:</font></b>
<table border='1' cellpadding='5' cellspacing='0' width='800'>
    <tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
        <td>
        <h3>商品資料 - ListOneProduct.jsp</h3>
        <a href="<%=request.getContextPath()%>/product/select_page.jsp"><img src="<%=request.getContextPath()%>/images/back1.gif" width="100" height="32" border="0">回首頁</a>
        </td>
    </tr>
</table>

<!--  -->
<table border='1' bordercolor='#CCCCFF'>
    <tr>
		<th>商品編號</th>
		<th>商品名稱</th>
		<th>商品簡介</th>
		<th>商品價格</th>
		<th>商品庫存量</th>
		<th>商品圖片</th>
		<th>商品圖片（縮圖）</th>
		<th>商品上下架狀態</th>
		<th>商品建立日期</th>
		<th>商品資訊</th>
		<th>商品類別編號</th>

    </tr>
    <tr align='center' valign='middle'>    
			<td>${productVO.product_no}</td>
			<td>${productVO.product_name}</td>
			<td>${productVO.product_introduction}</td>
			<td>${productVO.product_price}</td>
			<td>${productVO.product_stock}</td>
			<td>${productVO.product_picture_large}</td>
			<td>${productVO.product_picture_small}</td>
			<td>${productVO.product_status}</td>
			<td>${productVO.product_create_date}</td>
			<td>${productVO.product_info}</td>
			<td>${productVO.product_kind_no}</td>
    
    </tr>
</table>

</body>
</html>        
