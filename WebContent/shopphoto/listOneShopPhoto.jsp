 <%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.shopphoto.model.*"%>
<%-- 此頁練習採用 Script 的寫法取值 --%>

<%-- 取出 Concroller ShopPhotoServlet.java已存入request的ShopPhotoVO物件--%>
<%ShopPhotoVO shopphotoVO = (ShopPhotoVO) request.getAttribute("shopphotoVO");%>

<html>
<head>
<title>商家相片資料 - listOneShopPhoto.jsp</title>
</head>
<body bgcolor='white'>
<b><font color=red>此頁練習採用 Script 的寫法取值:</font></b>
<table border='1' cellpadding='5' cellspacing='0' width='800'>
    <tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
        <td>
        <h3>商家相片資料 - ListOneShopPhoto.jsp</h3>
        <a href="<%=request.getContextPath()%>/shopphoto/select_page.jsp"><img src="<%=request.getContextPath()%>/images/back1.gif" width="100" height="32" border="0">回首頁</a>
        </td>
    </tr>
</table>

<!--  -->
<table border='1' bordercolor='#CCCCFF'>
    <tr>
		<th>相片編號</th>
		<th>商家編號(相片擁有商家)</th>
		<th>相片</th>
		<th>是否為大頭貼相片</th>
		<th>相片名稱</th>
		<th>相片副檔名</th>

    </tr>
    <tr align='center' valign='middle'>    
			<td>${shopphotoVO.shopPhoto_Id}</td>
			<td>${shopphotoVO.shopPhoto_ShopId}</td>
			<td>${shopphotoVO.shopPhoto_photo}</td>
			<td>${shopphotoVO.isDisp_shopPhoto}</td>
			<td>${shopphotoVO.shopPhoto_name}</td>
			<td>${shopphotoVO.shopPhoto_extent}</td>
    
    </tr>
</table>

</body>
</html>        
