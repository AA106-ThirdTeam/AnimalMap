 <%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.orders_item.model.*"%>
<%-- 此頁練習採用 Script 的寫法取值 --%>

<%-- 取出 Concroller Orders_itemServlet.java已存入request的Orders_itemVO物件--%>
<%Orders_itemVO orders_itemVO = (Orders_itemVO) request.getAttribute("orders_itemVO");%>

<html>
<head>
<title>訂單明細資料 - listOneOrders_item.jsp</title>
</head>
<body bgcolor='white'>
<b><font color=red>此頁練習採用 Script 的寫法取值:</font></b>
<table border='1' cellpadding='5' cellspacing='0' width='800'>
    <tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
        <td>
        <h3>訂單明細資料 - ListOneOrders_item.jsp</h3>
        <a href="<%=request.getContextPath()%>/orders_item/select_page.jsp"><img src="<%=request.getContextPath()%>/images/back1.gif" width="100" height="32" border="0">回首頁</a>
        </td>
    </tr>
</table>

<!--  -->
<table border='1' bordercolor='#CCCCFF'>
    <tr>
		<th>訂單編號</th>
		<th>商品編號</th>
		<th>訂購數量</th>
		<th>商品售價</th>

    </tr>
    <tr align='center' valign='middle'>    
			<td>${orders_itemVO.orders_no}</td>
			<td>${orders_itemVO.product_no}</td>
			<td>${orders_itemVO.commodities_amout}</td>
			<td>${orders_itemVO.selling_price}</td>
    
    </tr>
</table>

</body>
</html>        
