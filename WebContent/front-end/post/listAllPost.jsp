<%@page import="heibernate_com.mem.model.MemService"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.post.model.*"%>
<%@ page import="com.offiMsg.controller.*" %>
<%@ page import="com.offiMsg.model.*" %>
<%@ page import="heibernate_com.mem.model.MemVO"%>
<%
	boolean isLogin = false;
	// 【從 session 判斷此user是否登入過】
	heibernate_com.mem.model.MemVO account = (heibernate_com.mem.model.MemVO)session.getAttribute("account");
	
	
	if (account != null) {
		isLogin = true;
	}
	request.setAttribute("isLogin", isLogin);
%>

<!-- ==================================下面是HEAD部分=============================== -->

<!DOCTYPE html>
<html>
<title>動物地圖討論區</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/lib/w3.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
<script src="https://code.jquery.com/jquery.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
body, h1, h2, h3, h4, h5 {
	font-family: "Raleway", sans-serif
}
</style>
<body class="w3-light-grey">

	<!-- w3-content defines a container for fixed size centered content, 
and is wrapped around the whole page content, except for the footer in this example -->
	<div class="w3-content" style="max-width: 1400px">


<!-- nav -->
					<%@include file="/front-end/homepage/nav.jsp"%>

<%-- <%@ include file="/front-end/post/postnav.jsp" %> --%>
<!-- nav -->
		<!-- Header -->
		<header class="w3-container w3-center w3-padding-32">
			<h1><b>動物地圖討論區</b></h1>
			
			<dt><a href='<%=request.getContextPath()%>/front-end/homepage/index.jsp' class="w3-btn w3-white w3-border">首頁</a>
			<a href='<%=request.getContextPath()%>/front-end/post/listAllPost.jsp' class="w3-btn w3-white w3-border">討論區</a>
			<a href='<%=request.getContextPath()%>/front-end/post/addPost.jsp' class="w3-btn w3-white w3-border w3-hover-border-black">新增文章</a>
			</dt ->
		</header>
	
		<!-- Grid -->
		<div class="w3-row">

			<!-- ==================================下面是標題、內容=============================== -->
			<!-- Blog entries -->
			<div class="w3-col l8 s12">
				<%
					PostService postSvc = new PostService();
					List<PostVO> list = postSvc.getAll();
					request.setAttribute("list", list);
				%>
	<!-- Blog entry -->
							<!--include分頁 -->
	<%@ include file="page/page1.file"%>
	
	<%
// 		for(PostVO vo:list){ 
		for(int i = pageIndex;i<pageIndex+rowsPerPage-1;i++){
// 			System.out.println(i);
			PostVO vo = list.get(i);
			String tem_pic_path = new MemService().getOneMem(vo.getMem_Id()).getMem_profile();
	%>
	
		

<%-- <c:forEach var="postVO" items="${list}" begin="<%=pageIndex%>" end="<%=pageIndex+rowsPerPage-1%>"> --%>

		<div class="w3-card-4 w3-margin w3-white">
<!-- 取出會員編號及大頭照 -->


	<img src="<%=tem_pic_path %>" alt="Nature" style="width: 45%;height:220px;">
							
	<div class="w3-container w3-padding-8">
		<h3>發文者 : <a href="#" style="color: rgba(255, 0, 0, 0.49);"> <%=vo.getMem_Id() %></a></h3>
<!-- 		用el的方式從DB取值 -->
			<h5><%=vo.getPost_title() %>, <span class="w3-opacity"><%=vo.getPost_time() %></span></h5>
	</div>
	
	<div class="w3-container">
		<p><%=vo.getPost_content() %></p>
			<div class="w3-row">
				<div class="w3-col m8 s12">
				<p>
					<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/front-end/post/post.do">
						<input type="submit" value="READ MORE »" class="w3-btn w3-padding-large w3-white w3-border w3-hover-border-black">
						<input type="hidden" name="post_Id" value="<%=vo.getPost_Id() %>">
						<input type="hidden" name="action" value="listPost_Responses_ByPost_Id_B">
					</FORM>
				</p>
				</div>
								
			</div>
	</div>
				
		</div>
	<%
		} 
	%>		
<%-- </c:forEach> --%>
<hr>

<!-- END BLOG ENTRIES -->
</div>
			<!-- ==================================下面是側邊的畫面=============================== -->

		<!-- Introduction menu -->
						<div class="w3-col l4">
			<!-- About Card -->
<!-- 公告訊息 -->
			<div class="w3-card-2 w3-margin w3-margin-top">
				<img src="images/images.jpg" style="width: 100%">
					<div class="w3-container w3-white">
						<h4><b>公告訊息</b></h4>
						<p>以領養代替購買，以結紮代替撲殺<br>
							To adopt instead of buying, ligation instead of culling</p></div>
			</div>
<hr>
<!-- Posts -->
	<div class="w3-card-2 w3-margin">
		<div class="w3-container w3-padding">
			<h4>可愛的毛小孩 Posts</h4>
		</div>
	<ul class="w3-ul w3-hoverable w3-white">
		<li class="w3-padding-16">
		<img src="images/dog1.png" alt="Image" class="w3-left w3-margin-right" style="width: 110px">
			<span class="w3-large">毛小孩-柴犬</span><br>
			<span>我們很可愛很乖,別丟棄我們</span></li>
		<li class="w3-padding-16">
			<img src="images/dog1_1.png" alt="Image" class="w3-left w3-margin-right" style="width: 110px">
			<span class="w3-large">毛小孩-柯基犬</span><br>
			<span>雖然我腿短~但我很萌~</span></li>
		<li class="w3-padding-16">
			<img src="images/dog1-2.png" alt="Image" class="w3-left w3-margin-right" style="width: 110px">
			<span class="w3-large">毛小孩-臘腸狗</span><br>
			<span>雖然身體長腿短,但我有優雅的姿態<</span></li>

	</ul>
	</div>
<hr>
				<!-- Labels / tags -->
		<div class="w3-card-2 w3-margin">
			<div class="w3-container w3-padding">
				<h4>Tags</h4>
			</div>
			<div class="w3-container w3-white">
				<p><span class="w3-tag w3-black w3-margin-bottom">狗狗</span>
				<span class="w3-tag w3-light-grey w3-small w3-margin-bottom">貓咪</span>
				<span class="w3-tag w3-light-grey w3-small w3-margin-bottom">認養</span>
				<span class="w3-tag w3-light-grey w3-small w3-margin-bottom">流浪狗</span>
				<span class="w3-tag w3-light-grey w3-small w3-margin-bottom">流浪貓咪</span>
				<span class="w3-tag w3-light-grey w3-small w3-margin-bottom">AnimalMap</span>
				<span class="w3-tag w3-light-grey w3-small w3-margin-bottom">哈士奇</span>
				<span class="w3-tag w3-light-grey w3-small w3-margin-bottom">黃金獵犬</span></p>
			</div>
		</div>

				<!-- END Introduction Menu -->
</div>

			<!-- END GRID -->
	</div>
<br>
		<!-- END w3-content -->
</div>

	<!-- Footer -->
	<footer class="w3-container w3-dark w3-padding-32 w3-margin-top">
		<div class="row">			
			<%@ include file="page/page2.file"%>
		</div>
			<p>Powered by <a href="#" target="_blank">AnimalMap</a></p>
	</footer>

</body>
</html>
