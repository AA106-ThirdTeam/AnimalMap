 <%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.product_kind.model.*"%>
<%-- 此頁練習採用 Script 的寫法取值 --%>

<%-- 取出 Concroller Product_kindServlet.java已存入request的Product_kindVO物件--%>
<%Product_kindVO product_kindVO = (Product_kindVO) request.getAttribute("product_kindVO");%>

<html>
<head>
<title>商品類別資料 - listOneProduct_kind.jsp</title>
</head>
<body bgcolor='white'>
<b><font color=red>此頁練習採用 Script 的寫法取值:</font></b>
<table border='1' cellpadding='5' cellspacing='0' width='800'>
    <tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
        <td>
        <h3>商品類別資料 - ListOneProduct_kind.jsp</h3>
        <a href="<%=request.getContextPath()%>/product_kind/select_page.jsp"><img src="<%=request.getContextPath()%>/images/back1.gif" width="100" height="32" border="0">回首頁</a>
        </td>
    </tr>
</table>

<!--  -->
<table border='1' bordercolor='#CCCCFF'>
    <tr>
		<th>商品類別編號</th>
		<th>商品類別名稱</th>

    </tr>
    <tr align='center' valign='middle'>    
			<td>${product_kindVO.product_kind_no}</td>
			<td>${product_kindVO.product_kind_name}</td>
    
    </tr>
</table>

</body>
</html>        
