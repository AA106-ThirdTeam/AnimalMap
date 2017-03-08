<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.post.model.*"%>
<%@ page import="com.post.controller.*"%>
<%
	PostVO postVO = (PostVO) request.getAttribute("postVO");
	System.out.println("postVO : " + postVO);
	//PostServlet.java (Concroller), 存入req的postVO物件 (包括幫忙取出的postVO, 也包括輸入資料錯誤時的postVO物件)
%>

<%
	boolean isLogin = false;
	// 【從 session 判斷此user是否登入過】
	heibernate_com.mem.model.MemVO account = (heibernate_com.mem.model.MemVO)session.getAttribute("account");
	
	
	if (account != null) {
		isLogin = true;
	}
	request.setAttribute("isLogin", isLogin);
%>

<%-- <% String mem_Id = "1000000"; %> --%>
<!-- ==================================下面是HEAD部分=============================== -->

<!DOCTYPE html>
<html>
<title>文章資料修改</title> <!-- update_post_input.jsp -->
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/lib/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/lib/w3.css">

<style>
body, h1, h2, h3, h4, h5 {
	font-family: "Raleway", sans-serif
}
</style>
<body class="w3-light-grey">
<%-- 錯誤表列 --%>
	<c:if test="${not empty errorMsgs}">
		<font color='red'>請修正以下錯誤:
			<ul>
				<c:forEach var="message" items="${errorMsgs}">
					<li>${message}</li>
				</c:forEach>
			</ul>
		</font>
	</c:if>
	<!-- w3-content defines a container for fixed size centered content, 
and is wrapped around the whole page content, except for the footer in this example -->
	<div class="w3-content" style="max-width: 1400px">
<!-- 	套論導覽列 -->
<%@include file="/front-end/homepage/nav.jsp"%>

	
		<!-- Header -->
		<header class="w3-container w3-center w3-padding-32">
			<h1><b>動物地圖討論區-文章資料修改</b></h1>
		<li>
			<a href='<%=request.getContextPath()%>/front-end/homepage/index.jsp' class="w3-btn w3-white w3-border">首頁</a>
			<a href='<%=request.getContextPath()%>/front-end/post/listAllPost.jsp' class="w3-btn w3-white w3-border">討論區</a>
		</li>
			
		</header>

		<!-- Grid -->
		<div class="w3-row">
<%
	
// 	PostVO postVO = (PostVO) request.getAttribute("postVO");
	

%>
		<!-- ==================================下面是標題、內容=============================== -->
			<!-- Blog entries -->
			<div class="w3-col l8 s12">
	
				<!-- Blog entry -->

				<div class="w3-card-4 w3-margin w3-white">
				

				
					<div class="w3-container w3-padding-8">
					<form METHOD="post" ACTION="<%=request.getContextPath()%>/front-end/post/post.do">
						<h3>
<%-- 							發文者 :<%=postVO.getMem_Id() %> <a href="#" style="color: rgba(255, 0, 0, 0.49);"></a> --%>
							發文者 :<%=account.getMem_Id() %> <a href="#" style="color: rgba(255, 0, 0, 0.49);"></a>
						</h3>
						<h4>文章分類：<font color=red><b>*</b></font>
						<td><select size="1" name="post_class_Id$post_class">
						    <option value="1-自介" ${(param.post_class_Id$post_class=='1-自介')? 'selected':'' }>自介
							<option value="2-請問" ${(param.post_class_Id$post_class=='2-請問')? 'selected':'' }>請問
							<option value="3-資訊" ${(param.post_class_Id$post_class=='3-資訊')? 'selected':'' }>資訊
							<option value="4-推薦" ${(param.post_class_Id$post_class=='4-推薦')? 'selected':'' }>推薦
							<option value="5-認養" ${(param.post_class_Id$post_class=='5-認養')? 'selected':'' }>認養
							<option value="6-協尋" ${(param.post_class_Id$post_class=='6-協尋')? 'selected':'' }>協尋
							<option value="7-捨獲" ${(param.post_class_Id$post_class=='7-捨獲')? 'selected':'' }>捨獲
							<option value="8-心得" ${(param.post_class_Id$post_class=='8-心得')? 'selected':'' }>心得
						</select></td></h4>
						
						<h4><td>文章標題：<input type="TEXT" name="post_title" size="35" 
							onfocus="if(value =='請輸入標題'){value=''}"
							onblur="if(value ==''){value='請輸入標題'}"
							value="<%=(postVO == null) ? "請輸入標題" : postVO.getPost_title() %>" />
						</td></h4>
						
						<h4><td>文章內容：</td><br>
						<td><br><textarea  name="post_content" style="width:800px;height:300px;"
						value="<%=(postVO == null) ? "" : postVO.getPost_content()%>"></textarea></td></h4>
					<div style="text-align: right" >
					
					<input type="hidden" name="action" value="update">
						<input type="hidden" name="mem_Id" value="<%=account.getMem_Id() %>">
					<input type="hidden" name="post_Id" value="${postVO.post_Id}">
					<input type="hidden" name="psot_time" value="${postVO.post_time }">
					<input type="hidden" name="requestURL" value="<%=request.getParameter("requestURL")%>"><!--接收原送出修改的來源網頁路徑後,再送給Controller準備轉交之用-->
					<input type="hidden" name="whichPage" value="<%=request.getParameter("whichPage")%>">  <!--只用於:istAllPost.jsp-->
					<input type="submit" value="送出修改" class="w3-btn w3-padding-large w3-white w3-border w3-hover-border-black"></div>
						
<!-- 					<input type="hidden" name="action" value="update"> -->
<%-- 					<input type="hidden" name="post_Id" value="${postVO.post_Id}"> --%>
	
<%-- 					<input type="hidden" name="requestURL" value="<%=request.getParameter("requestURL")%>"><!--接收原送出修改的來源網頁路徑後,再送給Controller準備轉交之用--> --%>
<%-- 					<input type="hidden" name="whichPage" value="<%=request.getParameter("whichPage")%>">  <!--只用於:istAllPost.jsp--> --%>
<!-- 					<input type="submit" value="送出修改" class="w3-btn w3-padding-large w3-white w3-border w3-hover-border-black"> -->
					
					
				</form>
					</div>


				</div>

				<hr>
			
				<!-- END BLOG ENTRIES -->

			</div>








			<!-- ==================================下面是側邊的畫面=============================== -->

			<!-- Introduction menu -->
				<div class="w3-col l4">
			<!-- About Card -->
<!-- 公告訊息 -->
			<div class="w3-card-2 w3-margin w3-margin-top">
	<img src="images/images.jpg" style="width: 100%" style="width: 100%">
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
	<footer class="w3-container w3-dark-grey w3-padding-32 w3-margin-top">
			<p>Powered by <a href="#" target="_blank">©2017_AnimalMap</a></p>
	</footer>


</body>
</html>