 <%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.res_ponse.model.*"%>
<%-- 此頁練習採用 Script 的寫法取值 --%>

<%-- 取出 Concroller Res_ponseServlet.java已存入request的Res_ponseVO物件--%>
<%Res_ponseVO res_ponseVO = (Res_ponseVO) request.getAttribute("res_ponseVO");%>

<html>
<head>
<title>討論區留言資料 - listOneRes_ponse.jsp</title>
</head>
<body bgcolor='white'>
<b><font color=red>此頁練習採用 Script 的寫法取值:</font></b>
<table border='1' cellpadding='5' cellspacing='0' width='800'>
    <tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
        <td>
        <h3>討論區留言資料 - ListOneRes_ponse.jsp</h3>
        <a href="<%=request.getContextPath()%>/res_ponse/select_page.jsp"><img src="<%=request.getContextPath()%>/images/back1.gif" width="100" height="32" border="0">回首頁</a>
        </td>
    </tr>
</table>

<!--  -->
<table border='1' bordercolor='#CCCCFF'>
    <tr>
		<th>留言(回覆)編號</th>
		<th>會員編號(發文者)</th>
		<th>文章編號</th>
		<th>文章留言內容</th>
		<th>發佈時間</th>
		<th>修改時間</th>

    </tr>
    <tr align='center' valign='middle'>    
			<td>${res_ponseVO.res_Id}</td>
			<td>${res_ponseVO.mem_Id}</td>
			<td>${res_ponseVO.post_Id}</td>
			<td>${res_ponseVO.res_ponse_content}</td>
			<td>${res_ponseVO.post_time}</td>
			<td>${res_ponseVO.res_ponse_upDate}</td>
    
    </tr>
</table>

</body>
</html>        
