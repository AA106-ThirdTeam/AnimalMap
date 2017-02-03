 <%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.shop_comment.model.*"%>
<%-- 此頁練習採用 Script 的寫法取值 --%>

<%-- 取出 Concroller Shop_commentServlet.java已存入request的Shop_commentVO物件--%>
<%Shop_commentVO shop_commentVO = (Shop_commentVO) request.getAttribute("shop_commentVO");%>

<html>
<head>
<title>商家留言資料 - listOneShop_comment.jsp</title>
</head>
<body bgcolor='white'>
<b><font color=red>此頁練習採用 Script 的寫法取值:</font></b>
<table border='1' cellpadding='5' cellspacing='0' width='800'>
    <tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
        <td>
        <h3>商家留言資料 - ListOneShop_comment.jsp</h3>
        <a href="<%=request.getContextPath()%>/shop_comment/select_page.jsp"><img src="<%=request.getContextPath()%>/images/back1.gif" width="100" height="32" border="0">回首頁</a>
        </td>
    </tr>
</table>

<!--  -->
<table border='1' bordercolor='#CCCCFF'>
    <tr>
		<th>診所留言編號</th>
		<th>發送會員編號</th>
		<th>商店編號</th>
		<th>發送內容</th>
		<th>發送時間</th>

    </tr>
    <tr align='center' valign='middle'>    
			<td>${shop_commentVO.shopComm_Id}</td>
			<td>${shop_commentVO.shopComm_MemId}</td>
			<td>${shop_commentVO.shopComm_ShopId}</td>
			<td>${shop_commentVO.shopComm_content}</td>
			<td>${shop_commentVO.shopComm_SendTime}</td>
    
    </tr>
</table>

</body>
</html>        
