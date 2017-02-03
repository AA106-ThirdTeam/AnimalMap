 <%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.second_prodphotos.model.*"%>
<%-- 此頁練習採用 Script 的寫法取值 --%>

<%-- 取出 Concroller Second_ProdPhotosServlet.java已存入request的Second_ProdPhotosVO物件--%>
<%Second_ProdPhotosVO second_prodphotosVO = (Second_ProdPhotosVO) request.getAttribute("second_prodphotosVO");%>

<html>
<head>
<title>二手商品相簿資料 - listOneSecond_ProdPhotos.jsp</title>
</head>
<body bgcolor='white'>
<b><font color=red>此頁練習採用 Script 的寫法取值:</font></b>
<table border='1' cellpadding='5' cellspacing='0' width='800'>
    <tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
        <td>
        <h3>二手商品相簿資料 - ListOneSecond_ProdPhotos.jsp</h3>
        <a href="<%=request.getContextPath()%>/second_prodphotos/select_page.jsp"><img src="<%=request.getContextPath()%>/images/back1.gif" width="100" height="32" border="0">回首頁</a>
        </td>
    </tr>
</table>

<!--  -->
<table border='1' bordercolor='#CCCCFF'>
    <tr>
		<th>二手商品相簿編號</th>
		<th>二手商品編號</th>

    </tr>
    <tr align='center' valign='middle'>    
			<td>${second_prodphotosVO.second_ProdPhotos_Id}</td>
			<td>${second_prodphotosVO.second_Prod_Id}</td>
    
    </tr>
</table>

</body>
</html>        
