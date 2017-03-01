<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.post.model.*"%>
<%@ page import="com.offiMsg.model.*" %>
<%@ page import="com.offiMsg.controller.*" %>

<!-- ==================================下面是HEAD部分=============================== -->

<!DOCTYPE html>
<html>
<title>動物地圖討論區</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/lib/w3.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Raleway">
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
					<li class="active"><a href="#">關於AnimalMap</a></li>
					<li><a href="#">討論區</a></li>
					<!-- <li><a href="#">分類文章</a></li> -->
					<li><a href="#">首頁</a></li>
				</ul>
		
				<!-- 搜尋表單 -->
				<form class="navbar-form navbar-left" role="search">
					<div class="form-group">
						<input type="text" class="form-control" placeholder="請輸入關鍵字">
					</div>
					<button type="submit" class="btn btn-default">搜尋</button>
				</form>
		
				<!-- 右選單 -->
				<ul class="nav navbar-nav navbar-right">
					<li><a href="#"><i class="glyphicon glyphicon-user"></i> Admin 您好</a></li>
					<li><a href="#"><i class="glyphicon glyphicon-log-out"></i>登出</a></li>
					<li><a href="#"><i class="glyphicon glyphicon-cog"></i>個人設定</a></li>
					<li class="dropdown">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown">系統訊息 <b class="caret"></b></a>
						<ul class="dropdown-menu">
						
						<%
						OffiMsgService offiMsgSvc = new OffiMsgService();
						List<OffiMsgVO> listOffiMsg = offiMsgSvc.getAll();
						request.setAttribute("listOffiMsg", listOffiMsg);
						%>
						
						<c:forEach var="OffiMsgVO" items="${listOffiMsg}">
						<div class="container">
							<div class="row">
					<li><a href="#modal-id${OffiMsgVO.offiMsg_Id}" data-toggle="modal" class="btn btn-primary">標題:${OffiMsgVO.offiMsg_Title}</a></li>

							
						</div>
						</div>
						</c:forEach>
							
						</ul>
					</li>
				</ul>
			</div>
			<!-- 手機隱藏選單區結束 -->
		</nav>

<!-- nav -->
		
			
	<c:forEach var="OffiMsgVO" items="${listOffiMsg}">
					
			<div class="modal fade" id="modal-id${OffiMsgVO.offiMsg_Id}">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
					
							<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
						
							${OffiMsgVO.offiMsg_Id}<h4 class="modal-title">標題${OffiMsgVO.offiMsg_Title}</h4>
						</div>
						<div class="modal-body">
							<a  data-toggle="modal" >內容:${OffiMsgVO.offiMsg_Content}</a>
						</div>
					
						<div class="modal-footer">
							<button type="button" class="btn btn-default" data-dismiss="modal">關閉</button>
						
						</div>
				
				</div>
			</div>
		</div>
		</c:forEach>

		<!-- Header -->
		<header class="w3-container w3-center w3-padding-32">
			<h1>
				<b>動物地圖討論區</b>
			</h1>

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
				<%@ include file="page/page1.file"%>
				<c:forEach var="postVO" items="${list}" begin="<%=pageIndex%>"
					end="<%=pageIndex+rowsPerPage-1%>">

					<div class="w3-card-4 w3-margin w3-white">

						<img src="<%=request.getContextPath() %>/post/DBGifReader4?mem_id=${postVO.mem_Id}" alt="Nature" style="width: 45%;height:220px;">
							
						<div class="w3-container w3-padding-8">
							<h3>
								發文者 : <a href="#" style="color: rgba(255, 0, 0, 0.49);">${postVO.mem_Id}</a>
							</h3>
							<h5>${postVO.post_title}, <span class="w3-opacity">${postVO.post_time}</span>
							</h5>
						</div>

						<div class="w3-container">
							<p>${postVO.post_content}</p>
							<div class="w3-row">
								<div class="w3-col m8 s12">
									<p>
									<FORM METHOD="post"
										ACTION="<%=request.getContextPath()%>/post/post.do">
										<input type="submit" value="READ MORE »"
											class="w3-btn w3-padding-large w3-white w3-border w3-hover-border-black">
										<input type="hidden" name="post_Id"
											value="${postVO.post_Id }"> <input type="hidden"
											name="action" value="listPost_Responses_ByPost_Id_B">
									</FORM>

									</p>
								</div>
								
							</div>


						</div>

					</div>
				</c:forEach>
				<hr>
			
				
				<!-- END BLOG ENTRIES -->
			</div>
		


			<!-- ==================================下面是側邊的畫面=============================== -->


			<!-- Introduction menu -->
			<div class="w3-col l4">
			
			
				<div class="row">
					<ul>
						<a class="w3-btn w3-white w3-border w3-hover-border-black"
							href='<%=request.getContextPath()%>/post/addPost.jsp'>新增文章</a>
						<a class="w3-btn w3-white w3-border w3-hover-border-black">AnimalMap首頁</a>
						<a class="w3-btn w3-white w3-border w3-hover-border-black">關於AnimalMap</a>
					</ul>
				</div>

				<!-- About Card -->
				<div class="w3-card-2 w3-margin w3-margin-top">
					<img src="images/images.jpg" style="width: 100%">
					<div class="w3-container w3-white">
						<h4>
							<b>公告訊息</b>
						</h4>
						<p>以領養代替購買，以結紮代替撲殺<br>
							To adopt instead of buying, ligation instead of culling</p>
					</div>
				</div>
				<hr>

	
	
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
						<p>
							<span class="w3-tag w3-black w3-margin-bottom">狗狗</span> <span
								class="w3-tag w3-light-grey w3-small w3-margin-bottom">貓咪</span>
							<span class="w3-tag w3-light-grey w3-small w3-margin-bottom">認養</span>
							<span class="w3-tag w3-light-grey w3-small w3-margin-bottom">流浪狗</span>
							<span class="w3-tag w3-light-grey w3-small w3-margin-bottom">流浪貓咪</span>
							<span class="w3-tag w3-light-grey w3-small w3-margin-bottom">AnimalMap</span>
							<span class="w3-tag w3-light-grey w3-small w3-margin-bottom">哈士奇</span>
							<span class="w3-tag w3-light-grey w3-small w3-margin-bottom">黃金獵犬</span>
						</p>
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
		<div class="row">			
					<%@ include file="page/page2.file"%>
				</div>

		<p>Powered by <a href="#" target="_blank">AnimalMap</a></p>
	</footer>

</body>
</html>

<!-- <script> -->
    
//     var MyPoint = "/test/peter/206";
//     var host = window.location.host;
//     var path = window.location.pathname;
//     var webCtx = path.substring(0, path.indexOf('/', 1));
//     var endPointURL = "ws://" + window.location.host + webCtx + MyPoint;
    
// 	var statusOutput = document.getElementById("statusOutput");
// 	var webSocket;
	
// 	function connect() {
// 		// 建立 websocket 物件
// // 		alert(endPointURL);
// 		webSocket = new WebSocket(endPointURL);
		
// 		webSocket.onopen = function(event) {
// 			updateStatus("WebSocket 成功連線");
// 			document.getElementById('sendMessage').disabled = false;
// 			document.getElementById('connect').disabled = true;
// 			document.getElementById('disconnect').disabled = false;
// 		};

// 		webSocket.onmessage = function(event) {
// 			var messagesArea = document.getElementById("messagesArea");
// 	        var jsonObj = JSON.parse(event.data);
// 	        var message = jsonObj.userName + ": " + jsonObj.message + "\r\n";
// 	        messagesArea.value = messagesArea.value + message;
// 	        messagesArea.scrollTop = messagesArea.scrollHeight;
// 		};

// 		webSocket.onclose = function(event) {
// 			updateStatus("WebSocket 已離線");
// 		};
// 	}
	
	
// 	var inputUserName = document.getElementById("userName");
// 	inputUserName.focus();
	
// 	function sendMessage() {
// 	    var userName = inputUserName.value.trim();
// 	    if (userName === ""){
// 	        alert ("使用者名稱請勿空白!");
// 	        inputUserName.focus();	
// 			return;
// 	    }
	    
// 	    var inputMessage = document.getElementById("message");
// 	    var message = inputMessage.value.trim();
	    
// 	    if (message === ""){
// 	        alert ("訊息請勿空白!");
// 	        inputMessage.focus();	
// 	    }else{
// 	        var jsonObj = {"userName" : userName, "message" : message};
// 	        webSocket.send(JSON.stringify(jsonObj));
// 	        inputMessage.value = "";
// 	        inputMessage.focus();
// 	    }
// 	}

	
// 	function disconnect () {
// 		webSocket.close();
// 		document.getElementById('sendMessage').disabled = true;
// 		document.getElementById('connect').disabled = false;
// 		document.getElementById('disconnect').disabled = true;
// 	}

	
// 	function updateStatus(newStatus) {
// 		statusOutput.innerHTML = newStatus;
// 	}
<!-- </script> -->