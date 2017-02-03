 <%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.adp.model.*"%>
<%-- 此頁練習採用 Script 的寫法取值 --%>

<%-- 取出 Concroller AdpServlet.java已存入request的AdpVO物件--%>
<%AdpVO adpVO = (AdpVO) request.getAttribute("adpVO");%>

<html>
<head>
<title>領養活動資料 - listOneAdp.jsp</title>
</head>
<body bgcolor='white'>
<b><font color=red>此頁練習採用 Script 的寫法取值:</font></b>
<table border='1' cellpadding='5' cellspacing='0' width='800'>
    <tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
        <td>
        <h3>領養活動資料 - ListOneAdp.jsp</h3>
        <a href="<%=request.getContextPath()%>/adp/select_page.jsp"><img src="<%=request.getContextPath()%>/images/back1.gif" width="100" height="32" border="0">回首頁</a>
        </td>
    </tr>
</table>

<!--  -->
<table border='1' bordercolor='#CCCCFF'>
    <tr>
		<th>領養活動編號</th>
		<th>發布會員編號</th>
		<th>領養活動標題</th>
		<th>領養活動內容</th>
		<th>領養活動發布時間</th>
		<th>領養活動到期時間</th>
		<th>領養活動更新時間</th>
		<th>縣市</th>
		<th>鄉鎮市區</th>
		<th>道路街名村里</th>
		<th>領養活動經度座標</th>
		<th>緯度座標緯度座標</th>

    </tr>
    <tr align='center' valign='middle'>    
			<td>${adpVO.adp_Id}</td>
			<td>${adpVO.mem_Id}</td>
			<td>${adpVO.adp_title}</td>
			<td>${adpVO.adp_adp_content}</td>
			<td>${adpVO.adp_start_date}</td>
			<td>${adpVO.adp_end_date}</td>
			<td>${adpVO.adp_upDate}</td>
			<td>${adpVO.adp_city}</td>
			<td>${adpVO.adp_town}</td>
			<td>${adpVO.adp_road}</td>
			<td>${adpVO.adp_lon}</td>
			<td>${adpVO.adp_lat}</td>
    
    </tr>
</table>

</body>
</html>        
