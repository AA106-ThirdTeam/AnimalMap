 <%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.second_prod.model.*"%>
<%-- 此頁練習採用 Script 的寫法取值 --%>

<%-- 取出 Concroller Second_ProdServlet.java已存入request的Second_ProdVO物件--%>
<%Second_ProdVO second_prodVO = (Second_ProdVO) request.getAttribute("second_prodVO");%>

<html>
<head>
<title>二手商品資料 - listOneSecond_Prod.jsp</title>
</head>
<body bgcolor='white'>
<b><font color=red>此頁練習採用 Script 的寫法取值:</font></b>
<table border='1' cellpadding='5' cellspacing='0' width='800'>
    <tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
        <td>
        <h3>二手商品資料 - ListOneSecond_Prod.jsp</h3>
        <a href="<%=request.getContextPath()%>/second_prod/select_page.jsp"><img src="<%=request.getContextPath()%>/images/back1.gif" width="100" height="32" border="0">回首頁</a>
        </td>
    </tr>
</table>

<!--  -->
<table border='1' bordercolor='#CCCCFF'>
    <tr>
		<th>二手商品編號</th>
		<th>發布會員編號</th>
		<th>二手商品標題</th>
		<th>二手商品內容</th>
		<th>二手商品發布時間</th>
		<th>二手商品截止時間</th>
		<th>二手商品更新時間</th>
		<th>縣市</th>
		<th>鄉鎮市區</th>
		<th>道路街名村里</th>
		<th>二手商品經度座標</th>
		<th>緯度座標緯度座標</th>

    </tr>
    <tr align='center' valign='middle'>    
			<td>${second_prodVO.second_Prod_Id}</td>
			<td>${second_prodVO.mem_Id}</td>
			<td>${second_prodVO.second_Prod_Title}</td>
			<td>${second_prodVO.second_Prod_Content}</td>
			<td>${second_prodVO.second_Prod_adp_start_date}</td>
			<td>${second_prodVO.second_Prod_adp_end_date}</td>
			<td>${second_prodVO.second_Prod_adp_upDate}</td>
			<td>${second_prodVO.second_Prod_adp_city}</td>
			<td>${second_prodVO.second_Prod_Town}</td>
			<td>${second_prodVO.second_Prod_Road}</td>
			<td>${second_prodVO.second_Prod_Lon}</td>
			<td>${second_prodVO.second_Prod_Lat}</td>
    
    </tr>
</table>

</body>
</html>        
