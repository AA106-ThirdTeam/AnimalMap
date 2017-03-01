<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.post.model.*"%>
<%@ page import="com.offiMsg.model.*" %>
<%@ page import="com.offiMsg.controller.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>


<head>
<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
<title>Insert title here</title>
<!-- <script src="https://code.jquery.com/jquery.js"></script> -->
<!-- <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script> -->
<!-- <link rel="stylesheet" href="https://www.w3schools.com/lib/w3.css"> -->
<!-- <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css"> -->
</head>
<body>
<!-- 導覽列 -->
<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
					<span class="sr-only">選單切換</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#"><img src="https://static.wixstatic.com/media/41d000_a6eb09d797ef2140acb90fa24442e5d5.png/v1/fill/w_75,h_75,al_c,usm_0.66_1.00_0.01/41d000_a6eb09d797ef2140acb90fa24442e5d5.png" style="width: 25px; height: 25px;"></a>
			</div>
		
			<!-- 手機隱藏選單區 -->
			<div class="collapse navbar-collapse navbar-ex1-collapse">
				<!-- 左選單 -->
				<ul class="nav navbar-nav">
					<li class="active"><a href="#">AnimalMap首頁</a></li>
					<li><a href='<%=request.getContextPath()%>/front-end/post/addPost.jsp'>新增文章</a></li>
					<!-- <li><a href="#">分類文章</a></li> -->
					<li><a href='<%=request.getContextPath()%>/front-end/post/listAllPost.jsp'>討論區</a></li>
					
<%-- 						<li><a href='<%=request.getContextPath()%>/post/addPost.jsp'>新增文章</a></li> --%>
					
				</ul>
		
				<!-- 右選單 -->
				<ul class="nav navbar-nav navbar-right">
					<li><a href="#"><i class="glyphicon glyphicon-user"></i> Admin 您好</a></li>
					<li><a href="#"><i class="glyphicon glyphicon-log-out"></i>登出</a></li>
					<li><a href="#"><i class="glyphicon glyphicon-cog"></i>個人設定</a></li>
					<li class="dropdown">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown">系統訊息 <b class="caret"></b></a>
						<ul class="dropdown-menu" style="width: 300px;">
						
						<%
						OffiMsgService offiMsgSvc = new OffiMsgService();
						List<OffiMsgVO> listOffiMsg = offiMsgSvc.getAll();
						request.setAttribute("listOffiMsg", listOffiMsg);
						%>
						
						<c:forEach var="OffiMsgVO" items="${listOffiMsg}">
							<div class="row" style="width: 100px;">
					<li><a href="#modal-id${OffiMsgVO.offiMsg_Id}" data-toggle="modal" class="btn" style="padding-left: 20px;">標題:${OffiMsgVO.offiMsg_Title}</a></li>

							
						</div>
						</c:forEach>
							
						</ul>
					</li>
				</ul>
			</div>
			<!-- 手機隱藏選單區結束 -->
		</nav>

<!-- nav -->
		
			c
	<c:forEach var="OffiMsgVO" items="${listOffiMsg}">
					
			<div class="modal fade" id="modal-id${OffiMsgVO.offiMsg_Id}">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
					
							<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
						
							${OffiMsgVO.offiMsg_Id}<h4 class="modal-title"><b>標題${OffiMsgVO.offiMsg_Title}</h4>
						</div>
						<div class="modal-body">
							<a>內容:${OffiMsgVO.offiMsg_Content}</a>
						</div>
					
						<div class="modal-footer">
							<button type="button" class="btn btn-default" data-dismiss="modal">關閉</button>
						
						</div>
				
				</div>
			</div>
		</div>
		</c:forEach>
</body>
</html>