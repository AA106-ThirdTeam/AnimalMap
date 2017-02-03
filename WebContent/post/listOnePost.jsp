 <%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.post.model.*"%>
<%-- 此頁練習採用 Script 的寫法取值 --%>

<%-- 取出 Concroller PostServlet.java已存入request的PostVO物件--%>
<%PostVO postVO = (PostVO) request.getAttribute("postVO");%>

<html>
<head>
<title>討論區資料 - listOnePost.jsp</title>
</head>
<body bgcolor='white'>
<b><font color=red>此頁練習採用 Script 的寫法取值:</font></b>
<table border='1' cellpadding='5' cellspacing='0' width='800'>
    <tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
        <td>
        <h3>討論區資料 - ListOnePost.jsp</h3>
        <a href="<%=request.getContextPath()%>/post/select_page.jsp"><img src="<%=request.getContextPath()%>/images/back1.gif" width="100" height="32" border="0">回首頁</a>
        </td>
    </tr>
</table>

<!--  -->
<table border='1' bordercolor='#CCCCFF'>
    <tr>
		<th>文章編號</th>
		<th>會員編號(發文者)</th>
		<th>文章分類</th>
		<th>文章分類編號</th>
		<th>文章標題</th>
		<th>文章內容</th>
		<th>發佈時間</th>
		<th>修改時間</th>
		<th>回覆數量</th>

    </tr>
    <tr align='center' valign='middle'>    
			<td>${postVO.post_Id}</td>
			<td>${postVO.mem_Id}</td>
			<td>${postVO.post_class}</td>
			<td>${postVO.post_class_Id}</td>
			<td>${postVO.post_title}</td>
			<td>${postVO.post_content}</td>
			<td>${postVO.post_time}</td>
			<td>${postVO.post_upDate}</td>
			<td>${postVO.post_resNum}</td>
    
    </tr>
</table>

</body>
</html>        
