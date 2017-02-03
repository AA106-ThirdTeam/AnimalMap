 <%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.grp_comment.model.*"%>
<%-- 此頁練習採用 Script 的寫法取值 --%>

<%-- 取出 Concroller Grp_commentServlet.java已存入request的Grp_commentVO物件--%>
<%Grp_commentVO grp_commentVO = (Grp_commentVO) request.getAttribute("grp_commentVO");%>

<html>
<head>
<title>揪團留言資料 - listOneGrp_comment.jsp</title>
</head>
<body bgcolor='white'>
<b><font color=red>此頁練習採用 Script 的寫法取值:</font></b>
<table border='1' cellpadding='5' cellspacing='0' width='800'>
    <tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
        <td>
        <h3>揪團留言資料 - ListOneGrp_comment.jsp</h3>
        <a href="<%=request.getContextPath()%>/grp_comment/select_page.jsp"><img src="<%=request.getContextPath()%>/images/back1.gif" width="100" height="32" border="0">回首頁</a>
        </td>
    </tr>
</table>

<!--  -->
<table border='1' bordercolor='#CCCCFF'>
    <tr>
		<th>揪團留言編號</th>
		<th>發送會員編號</th>
		<th>揪團編號</th>
		<th>發送內容</th>
		<th>發送時間</th>

    </tr>
    <tr align='center' valign='middle'>    
			<td>${grp_commentVO.grpComment_Id}</td>
			<td>${grp_commentVO.grpComment_MemId}</td>
			<td>${grp_commentVO.grpComment_GrpId}</td>
			<td>${grp_commentVO.grpComment_content}</td>
			<td>${grp_commentVO.grpComment_SendTime}</td>
    
    </tr>
</table>

</body>
</html>        
