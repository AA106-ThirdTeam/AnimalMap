 <%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.vet_hospital.model.*"%>
<%-- 此頁練習採用 Script 的寫法取值 --%>

<%-- 取出 Concroller Vet_hospitalServlet.java已存入request的Vet_hospitalVO物件--%>
<%Vet_hospitalVO vet_hospitalVO = (Vet_hospitalVO) request.getAttribute("vet_hospitalVO");%>

<html>
<head>
<title>診所資料 - listOneVet_hospital.jsp</title>
</head>
<body bgcolor='white'>
<b><font color=red>此頁練習採用 Script 的寫法取值:</font></b>
<table border='1' cellpadding='5' cellspacing='0' width='800'>
    <tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
        <td>
        <h3>診所資料 - ListOneVet_hospital.jsp</h3>
        <a href="<%=request.getContextPath()%>/vet_hospital/select_page.jsp"><img src="<%=request.getContextPath()%>/images/back1.gif" width="100" height="32" border="0">回首頁</a>
        </td>
    </tr>
</table>

<!--  -->
<table border='1' bordercolor='#CCCCFF'>
    <tr>
		<th>診所編號</th>
		<th>會員編號(負責人)</th>
		<th>診所名稱</th>
		<th>縣/市</th>
		<th>鄉鎮市區</th>
		<th>道路街名村里</th>
		<th>評價</th>
		<th>URL</th>
		<th>開始營業時間</th>
		<th>結束營業時間</th>
		<th>電話</th>
		<th>診所敘述</th>
		<th>診所經度座標</th>
		<th>診所緯度座標</th>
		<th>建立時間</th>
		<th>物件顯示狀態</th>

    </tr>
    <tr align='center' valign='middle'>    
			<td>${vet_hospitalVO.hos_Id}</td>
			<td>${vet_hospitalVO.mem_Id}</td>
			<td>${vet_hospitalVO.hos_name}</td>
			<td>${vet_hospitalVO.hos_city}</td>
			<td>${vet_hospitalVO.hos_town}</td>
			<td>${vet_hospitalVO.hos_road}</td>
			<td>${vet_hospitalVO.hos_Eval}</td>
			<td>${vet_hospitalVO.hos_URL}</td>
			<td>${vet_hospitalVO.hos_StartTime}</td>
			<td>${vet_hospitalVO.hos_EndTime}</td>
			<td>${vet_hospitalVO.hos_Tel}</td>
			<td>${vet_hospitalVO.hos_Desc}</td>
			<td>${vet_hospitalVO.hos_Long}</td>
			<td>${vet_hospitalVO.hos_Lat}</td>
			<td>${vet_hospitalVO.hos_CreateTime}</td>
			<td>${vet_hospitalVO.hos_visible}</td>
    
    </tr>
</table>

</body>
</html>        
