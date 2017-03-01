<%@ page contentType="text/html; charset=Big5"%>
<%@ page import="com.post_Response.model.*"%>
<%@ page import="com.post.model.*"%>>
<%-- 此頁練習採用 Script 的寫法取值 --%>

<%-- //Post_ResponseServlet.java(Concroller)已存入request的EmpVO物件--%>
<%	
Post_ResponseVO post_ResponseVO = (Post_ResponseVO) request.getAttribute("post_ResponseVO");
%>

<%-- 取出 對應的PostVO物件--%>
<%
  PostService postSvc = new PostService();
  PostVO postVO = postSvc.getOnePost(post_ResponseVO.getPost_Id());
%>
<html>
<head>
<title>留言資料 - listOnePost_Response.jsp</title>
</head>
<body bgcolor='white'>

	<table border='1' cellpadding='5' cellspacing='0' width='800'>
		<tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
			<td>
				<h3>留言資料 - listOnePost_Response.jsp</h3>
				<a href="<%=request.getContextPath()%>/select_page.jsp">
				<img src="images/back1.gif" width="100" height="32" border="0">回首頁</a>
			</td>
		</tr>
	</table>

	<table border='1' bordercolor='#CCCCFF' width='800' height='30'>
		<tr>
			<th>留言(回覆)編號</th>
			<th>會員編號(發文者)</th>
			<th>文章編號</th>
			<th>文章留言內容</th>
			<th>發佈時間</th>
			<th>修改時間</th>
		</tr>
		<tr align='center' valign='middle'>
			<td><%=post_ResponseVO.getRes_Id()%></td>
			<td><%=post_ResponseVO.getMem_Id()%></td>
			<td><%=post_ResponseVO.getPost_Id()%></td>
			<td><%=post_ResponseVO.getPost_Response_content()%></td>
			<td><%=post_ResponseVO.getPost_time()%></td>
			<td><%=post_ResponseVO.getPost_Response_upDate()%></td>

		</tr>
	</table>

</body>
</html>
