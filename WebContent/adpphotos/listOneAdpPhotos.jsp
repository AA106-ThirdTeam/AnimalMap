 <%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.adpphotos.model.*"%>
<%-- 此頁練習採用 Script 的寫法取值 --%>

<%-- 取出 Concroller AdpPhotosServlet.java已存入request的AdpPhotosVO物件--%>
<%AdpPhotosVO adpphotosVO = (AdpPhotosVO) request.getAttribute("adpphotosVO");%>

<html>
<head>
<title>領養活動相簿資料 - listOneAdpPhotos.jsp</title>
</head>
<body bgcolor='white'>
<b><font color=red>此頁練習採用 Script 的寫法取值:</font></b>
<table border='1' cellpadding='5' cellspacing='0' width='800'>
    <tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
        <td>
        <h3>領養活動相簿資料 - ListOneAdpPhotos.jsp</h3>
        <a href="<%=request.getContextPath()%>/adpphotos/select_page.jsp"><img src="<%=request.getContextPath()%>/images/back1.gif" width="100" height="32" border="0">回首頁</a>
        </td>
    </tr>
</table>

<!--  -->
<table border='1' bordercolor='#CCCCFF'>
    <tr>
		<th>領養活動相簿編號</th>
		<th>領養活動編號</th>
		<th>領養活動照片</th>

    </tr>
    <tr align='center' valign='middle'>    
			<td>${adpphotosVO.adpPhotos_Id}</td>
			<td>${adpphotosVO.adp_Id}</td>
			<td>${adpphotosVO.adpPhotosPic}</td>
    
    </tr>
</table>

</body>
</html>        
