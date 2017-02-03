 <%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.anihome_photos.model.*"%>
<%-- 此頁練習採用 Script 的寫法取值 --%>

<%-- 取出 Concroller AniHome_PhotosServlet.java已存入request的AniHome_PhotosVO物件--%>
<%AniHome_PhotosVO anihome_photosVO = (AniHome_PhotosVO) request.getAttribute("anihome_photosVO");%>

<html>
<head>
<title>動物之家相簿資料 - listOneAniHome_Photos.jsp</title>
</head>
<body bgcolor='white'>
<b><font color=red>此頁練習採用 Script 的寫法取值:</font></b>
<table border='1' cellpadding='5' cellspacing='0' width='800'>
    <tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
        <td>
        <h3>動物之家相簿資料 - ListOneAniHome_Photos.jsp</h3>
        <a href="<%=request.getContextPath()%>/anihome_photos/select_page.jsp"><img src="<%=request.getContextPath()%>/images/back1.gif" width="100" height="32" border="0">回首頁</a>
        </td>
    </tr>
</table>

<!--  -->
<table border='1' bordercolor='#CCCCFF'>
    <tr>
		<th>相片編號</th>
		<th>動物之家編號</th>
		<th>動物之家照片</th>

    </tr>
    <tr align='center' valign='middle'>    
			<td>${anihome_photosVO.aniHome_Photos_Id}</td>
			<td>${anihome_photosVO.aniHome_Id}</td>
			<td>${anihome_photosVO.aniHome_Photos_pic}</td>
    
    </tr>
</table>

</body>
</html>        
