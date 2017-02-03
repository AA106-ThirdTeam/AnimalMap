 <%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.park.model.*"%>
<%-- 此頁練習採用 Script 的寫法取值 --%>

<%-- 取出 Concroller ParkServlet.java已存入request的ParkVO物件--%>
<%ParkVO parkVO = (ParkVO) request.getAttribute("parkVO");%>

<html>
<head>
<title>公園資料 - listOnePark.jsp</title>
</head>
<body bgcolor='white'>
<b><font color=red>此頁練習採用 Script 的寫法取值:</font></b>
<table border='1' cellpadding='5' cellspacing='0' width='800'>
    <tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
        <td>
        <h3>公園資料 - ListOnePark.jsp</h3>
        <a href="<%=request.getContextPath()%>/park/select_page.jsp"><img src="<%=request.getContextPath()%>/images/back1.gif" width="100" height="32" border="0">回首頁</a>
        </td>
    </tr>
</table>

<!--  -->
<table border='1' bordercolor='#CCCCFF'>
    <tr>
		<th>公園編號</th>
		<th>員工編號</th>
		<th>公園標題</th>
		<th>公園內容</th>
		<th>公園照片</th>
		<th>公園發布時間</th>
		<th>公園更新時間</th>
		<th>縣市</th>
		<th>鄉鎮市區</th>
		<th>道路街名村里</th>
		<th>公園經度座標</th>
		<th>緯度座標緯度座標</th>

    </tr>
    <tr align='center' valign='middle'>    
			<td>${parkVO.park_Id}</td>
			<td>${parkVO.emp_Id}</td>
			<td>${parkVO.park_title}</td>
			<td>${parkVO.park_content}</td>
			<td>${parkVO.park_pic}</td>
			<td>${parkVO.adp_start_date}</td>
			<td>${parkVO.adp_upDate}</td>
			<td>${parkVO.adp_city}</td>
			<td>${parkVO.park_town}</td>
			<td>${parkVO.park_road}</td>
			<td>${parkVO.park_lon}</td>
			<td>${parkVO.park_lat}</td>
    
    </tr>
</table>

</body>
</html>        
