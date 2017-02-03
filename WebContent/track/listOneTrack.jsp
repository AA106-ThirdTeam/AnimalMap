 <%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.track.model.*"%>
<%-- 此頁練習採用 Script 的寫法取值 --%>

<%-- 取出 Concroller TrackServlet.java已存入request的TrackVO物件--%>
<%TrackVO trackVO = (TrackVO) request.getAttribute("trackVO");%>

<html>
<head>
<title>追蹤收藏資料 - listOneTrack.jsp</title>
</head>
<body bgcolor='white'>
<b><font color=red>此頁練習採用 Script 的寫法取值:</font></b>
<table border='1' cellpadding='5' cellspacing='0' width='800'>
    <tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
        <td>
        <h3>追蹤收藏資料 - ListOneTrack.jsp</h3>
        <a href="<%=request.getContextPath()%>/track/select_page.jsp"><img src="<%=request.getContextPath()%>/images/back1.gif" width="100" height="32" border="0">回首頁</a>
        </td>
    </tr>
</table>

<!--  -->
<table border='1' bordercolor='#CCCCFF'>
    <tr>
		<th>收藏編號</th>
		<th>會員編號</th>
		<th>收藏種類</th>
		<th>種類編號</th>

    </tr>
    <tr align='center' valign='middle'>    
			<td>${trackVO.track_Id}</td>
			<td>${trackVO.mem_Id}</td>
			<td>${trackVO.track_record_class}</td>
			<td>${trackVO.track_record_class_Id}</td>
    
    </tr>
</table>

</body>
</html>        
