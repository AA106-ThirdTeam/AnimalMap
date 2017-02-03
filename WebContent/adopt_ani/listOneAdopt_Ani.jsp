 <%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.adopt_ani.model.*"%>
<%-- 此頁練習採用 Script 的寫法取值 --%>

<%-- 取出 Concroller Adopt_AniServlet.java已存入request的Adopt_AniVO物件--%>
<%Adopt_AniVO adopt_aniVO = (Adopt_AniVO) request.getAttribute("adopt_aniVO");%>

<html>
<head>
<title>送養動物資料 - listOneAdopt_Ani.jsp</title>
</head>
<body bgcolor='white'>
<b><font color=red>此頁練習採用 Script 的寫法取值:</font></b>
<table border='1' cellpadding='5' cellspacing='0' width='800'>
    <tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
        <td>
        <h3>送養動物資料 - ListOneAdopt_Ani.jsp</h3>
        <a href="<%=request.getContextPath()%>/adopt_ani/select_page.jsp"><img src="<%=request.getContextPath()%>/images/back1.gif" width="100" height="32" border="0">回首頁</a>
        </td>
    </tr>
</table>

<!--  -->
<table border='1' bordercolor='#CCCCFF'>
    <tr>
		<th>送養動物編號</th>
		<th>發布者會員編號</th>
		<th>送養動物名字</th>
		<th>送養動物動物種類</th>
		<th>送養動物性別</th>
		<th>送養動物健康狀況</th>
		<th>送養動物疫苗接踵</th>
		<th>送養動物毛色</th>
		<th>送養動物體型</th>
		<th>送養動物年齡</th>
		<th>送養動物節育</th>
		<th>送養動物晶片編號</th>
		<th>送養時間</th>
		<th>送養動物物件狀態</th>
		<th>送養動物建立時間</th>
		<th>送養地點經度</th>
		<th>送養地點緯度</th>
		<th>縣/市</th>
		<th>鄉鎮市區</th>
		<th>道路街名村里</th>

    </tr>
    <tr align='center' valign='middle'>    
			<td>${adopt_aniVO.adopt_Ani_Id}</td>
			<td>${adopt_aniVO.mem_Id}</td>
			<td>${adopt_aniVO.adopt_Ani_name}</td>
			<td>${adopt_aniVO.adopt_Ani_type}</td>
			<td>${adopt_aniVO.adopt_Ani_gender}</td>
			<td>${adopt_aniVO.adopt_Ani_heal}</td>
			<td>${adopt_aniVO.adopt_Ani_Vac}</td>
			<td>${adopt_aniVO.adopt_Ani_color}</td>
			<td>${adopt_aniVO.adopt_Ani_body}</td>
			<td>${adopt_aniVO.adopt_Ani_age}</td>
			<td>${adopt_aniVO.adopt_Ani_Neu}</td>
			<td>${adopt_aniVO.adopt_Ani_chip}</td>
			<td>${adopt_aniVO.adopt_Ani_date}</td>
			<td>${adopt_aniVO.adopt_Ani_status}</td>
			<td>${adopt_aniVO.adopt_Ani_CreDate}</td>
			<td>${adopt_aniVO.adopt_Ani_FinLat}</td>
			<td>${adopt_aniVO.adopt_Ani_FinLon}</td>
			<td>${adopt_aniVO.adopt_Ani_city}</td>
			<td>${adopt_aniVO.adopt_Ani_town}</td>
			<td>${adopt_aniVO.adopt_Ani_road}</td>
    
    </tr>
</table>

</body>
</html>        
