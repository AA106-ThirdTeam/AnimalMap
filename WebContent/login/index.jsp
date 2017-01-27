<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<html>

<head>
<meta charset="UTF-8">
<style type="text/css">
body {
	padding: 0;
	margin: 0;
}

.vid-container {
	position: relative;
	height: 100vh;
	overflow: hidden;
}

.bgvid {
	position: absolute;
	left: 0;
	top: 0;
	width: 100vw;
}

.inner-container {
	width: 400px;
	height: 400px;
	position: absolute;
	top: calc(50vh - 200px);
	left: calc(50vw - 200px);
	overflow: hidden;
}

.bgvid.inner {
	top: calc(-50vh + 200px);
	left: calc(-50vw + 200px);
	filter:
		url("data:image/svg+xml;utf9,<svg%20version='1.1'%20xmlns='http://www.w3.org/2000/svg'><filter%20id='blur'><feGaussianBlur%20stdDeviation='10'%20/></filter></svg>#blur");
	-webkit-filter: blur(10px);
	-ms-filter: blur(10px);
	-o-filter: blur(10px);
	filter: blur(10px);
}

.box {
	position: absolute;
	height: 100%;
	width: 100%;
	font-family: Helvetica;
	color: #fff;
	background: rgba(0, 0, 0, 0.13);
	padding: 30px 0px;
}

.box h1 {
	text-align: center;
	margin: 30px 0;
	font-size: 30px;
}

.box input {
	display: block;
	width: 300px;
	margin: 20px auto;
	padding: 15px;
	background: rgba(0, 0, 0, 0.2);
	color: #fff;
	border: 0;
}

.box input:focus, .box input:active, .box button:focus, .box button:active
	{
	outline: none;
}

.box button {
	background: #2ecc71;
	border: 0;
	color: #fff;
	padding: 10px;
	font-size: 20px;
	width: 330px;
	margin: 20px auto;
	display: block;
	cursor: pointer;
}

.box button:active {
	background: #27ae60;
}

.box p {
	font-size: 14px;
	text-align: center;
}

.box p span {
	cursor: pointer;
	color: #666;
}
</style>
</head>

<body>
	<!-- Modal -->
	<div class="modal fade" id="myModal" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
<!-- 				<div class="modal-header"> -->
<!-- 					<button type="button" class="close" data-dismiss="modal">&times;</button> -->
<!-- 					<h4 class="modal-title">Modal Header</h4> -->
<!-- 				</div> -->
				<div class="modal-body" >
					<p style="text-align: center;">帳號錯誤 請重新輸入</p>
				</div>
<!-- 				<div class="modal-footer"> -->
<!-- 					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button> -->
<!-- 				</div> -->
			</div>

		</div>
	</div>


	<div class="vid-container">
		<video class="bgvid" autoplay="autoplay" muted="muted" preload="auto"
			loop="" style="">
			<source src="http://mazwai.com/#/grid/videos/161" type="video/webm">
		</video>
		<div class="inner-container">
			<!-- muted="muted" 是靜音效果 -->
			<video class="bgvid inner" autoplay="autoplay" muted="muted"
				preload="auto" loop="">
				<source
					src="http://mazwai.com/system/posts/videos/000/000/161/original/leonard_soosay--missfit.mp4?1424004876"
					type="video/webm">
			</video>
			<div class="box" id="AM_log_welcome">
				<h1>登入</h1>
				<input type="text" name="account" value="" placeholder="Username">
				<input type="password" name="password" value=""
					placeholder="Password">
				<button id="AM_btn_Member">登入</button>
				<p>
					忘記密碼? <span>註冊</span>
				</p>
			</div>
		</div>
	</div>
</body>
<script>
	$(document).ready(function() {
	    $("#AM_btn_Member").click(function() {
		    	$.ajax({
		            url:   "<%=request.getContextPath()%>/LoginHandler",
				type : "POST",
				data : {
					account : $("input[name='account']").val(),
					password : $("input[name='password']").val()
				},
				//傳帳號密碼。
				success : function(data, status) {
					// 		            	alert(data);
					// 		            	$("#AM_log_welcome").html("<div style=\"text-align: center;padding-top: 40%;\">歡迎回來</div>");
					// 		            	setTimeout(function(){ $("#AM_Login").html(""); }, 3000);
					if (data.indexOf('Login Success') != -1) {
						$("#AM_Login").html("");
					}
					if (data.indexOf('Login faild') != -1){
						$("#myModal").modal();
					}
				},
				error : function(data, status, er) {
// 					console(data + "_" + status + "_" + er);
// 					alert();
// 					$("#myModal").modal();
				}
			});
		});
	});
</script>

</html>