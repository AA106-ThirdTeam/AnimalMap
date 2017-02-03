 <%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.stray_ani_photos.model.*"%>
<%-- 此頁練習採用 Script 的寫法取值 --%>

<%-- 取出 Concroller Stray_Ani_photosServlet.java已存入request的Stray_Ani_photosVO物件--%>
<%Stray_Ani_photosVO stray_ani_photosVO = (Stray_Ani_photosVO) request.getAttribute("stray_ani_photosVO");%>

<html>
<head>
<title>社區流浪動物相簿資料 - listOneStray_Ani_photos.jsp</title>
</head>
<body bgcolor='white'>
<b><font color=red>此頁練習採用 Script 的寫法取值:</font></b>
<table border='1' cellpadding='5' cellspacing='0' width='800'>
    <tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
        <td>
        <h3>社區流浪動物相簿資料 - ListOneStray_Ani_photos.jsp</h3>
        <a href="<%=request.getContextPath()%>/stray_ani_photos/select_page.jsp"><img src="<%=request.getContextPath()%>/images/back1.gif" width="100" height="32" border="0">回首頁</a>
        </td>
    </tr>
</table>

<!--  -->
<table border='1' bordercolor='#CCCCFF'>
    <tr>
		<th>相片編號</th>
		<th>社區動物編號</th>
		<th>發布者會員編號</th>
		<th>流浪動物相片</th>
		<th>相片檔名</th>
		<th>相片副檔名</th>
		<th>相片發布時間</th>
		<th>相片類型</th>

    </tr>
    <tr align='center' valign='middle'>    
			<td>${stray_ani_photosVO.str_Ani_Pic_No}</td>
			<td>${stray_ani_photosVO.stray_Ani_Id}</td>
			<td>${stray_ani_photosVO.mem_Id}</td>
			<td>${stray_ani_photosVO.stray_Ani_Pic}</td>
			<td>${stray_ani_photosVO.stray_Pic_name}</td>
			<td>${stray_ani_photosVO.stray_Pic_extent}</td>
			<td>${stray_ani_photosVO.stray_Pic_time}</td>
			<td>${stray_ani_photosVO.stray_Pic_type}</td>
    
    </tr>
</table>

</body>
</html>        
