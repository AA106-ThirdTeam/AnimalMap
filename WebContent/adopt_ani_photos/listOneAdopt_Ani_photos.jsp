 <%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.adopt_ani_photos.model.*"%>
<%-- 此頁練習採用 Script 的寫法取值 --%>

<%-- 取出 Concroller Adopt_Ani_photosServlet.java已存入request的Adopt_Ani_photosVO物件--%>
<%Adopt_Ani_photosVO adopt_ani_photosVO = (Adopt_Ani_photosVO) request.getAttribute("adopt_ani_photosVO");%>

<html>
<head>
<title>送養動物相簿資料 - listOneAdopt_Ani_photos.jsp</title>
</head>
<body bgcolor='white'>
<b><font color=red>此頁練習採用 Script 的寫法取值:</font></b>
<table border='1' cellpadding='5' cellspacing='0' width='800'>
    <tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
        <td>
        <h3>送養動物相簿資料 - ListOneAdopt_Ani_photos.jsp</h3>
        <a href="<%=request.getContextPath()%>/adopt_ani_photos/select_page.jsp"><img src="<%=request.getContextPath()%>/images/back1.gif" width="100" height="32" border="0">回首頁</a>
        </td>
    </tr>
</table>

<!--  -->
<table border='1' bordercolor='#CCCCFF'>
    <tr>
		<th>送養動物相片編號</th>
		<th>送養動物編號</th>
		<th>發布者會員編號</th>
		<th>送養動物相片</th>
		<th>寵物相片檔名</th>
		<th>寵物相片副檔名</th>
		<th>發布時間</th>
		<th>相片類型</th>

    </tr>
    <tr align='center' valign='middle'>    
			<td>${adopt_ani_photosVO.ado_Ani_Pic_No}</td>
			<td>${adopt_ani_photosVO.adopt_Ani_Id}</td>
			<td>${adopt_ani_photosVO.mem_Id}</td>
			<td>${adopt_ani_photosVO.ado_Ani_Pic}</td>
			<td>${adopt_ani_photosVO.ado_Pic_name}</td>
			<td>${adopt_ani_photosVO.ado_Pic_extent}</td>
			<td>${adopt_ani_photosVO.ado_Pic_time}</td>
			<td>${adopt_ani_photosVO.ado_Pic_type}</td>
    
    </tr>
</table>

</body>
</html>        
