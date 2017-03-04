<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/front-end/assets/header.jsp"%>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<style type="text/css">
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
<!-- login畫面 -->

<div id="AM_Login"
	style="background-color: rgba(38, 35, 35, 0.83); position: fixed; width: 100%; z-index: 10000;">

	<!-- Modal -->
	<div class="modal fade" id="myModal" role="dialog">
		<div class="modal-dialog">
			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-body">
					<p style="text-align: center;" id="login_Modal_info_window"></p>
					<br> <br>
					<!-- Trigger the modal with a button -->
					<!--   					<button type="button" class="btn btn-info btn-md" id="loging_modal_close" style="padding: 10px;width: 100%;margin: 0 auto;">關閉</button> -->
				</div>
			</div>
		</div>
	</div>

	<div class="vid-container" id="AM_Login_main_window">
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
				<form id="AM_LOGIN_from">
					<input type="text" name="mem_account" value=""
						placeholder="Username" /> <input type="password" name="mem_Psw"
						value="" placeholder="Password" /> <input type="hidden"
						name="action" value="list_ByCompositeQuery" />
				</form>
				<button type="button" class="btn btn-info btn-md" id="AM_btn_Member"
					style="padding: 10px; width: 100%; margin: 0 auto;">會員登入</button>
				<!-- 				<button type="button" class="btn btn-info btn-md" style="padding: 10px;width: 100%;margin: 0 auto;">訪客登入</button> -->
				<p>
					忘記密碼? <span class="red" href="#signup" data-toggle="modal"
						data-target=".bs-modal-sm">註冊</span>
				</p>
			</div>
		</div>
	</div>

	<div class="modal fade bs-modal-sm" id="myModal" tabindex="-1"
		role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-sm" style="width: 100%; height: 100%;">
			<div class="modal-content">
				<br>
				<div class="bs-example bs-example-tabs">
					<ul id="myTab" class="nav nav-tabs">

						<li class=""><a href="#signup" data-toggle="tab"
							aria-expanded="false" class="active">一般會員</a></li>
						<li class=""><a href="#signup_Volunte" data-toggle="tab"
							aria-expanded="false">志工</a></li>
						<li class="active"><a href="#bussiness" data-toggle="tab"
							aria-expanded="true">商家</a></li>
					</ul>
				</div>
				<div class="modal-body" style="margin-left: 4%; margin-right: 6%;">

					<div id="myTabContent" class="tab-content">
						<!-- 一般會員 -->
						<%@ include file="/front-end/login/sign_01.jsp"%>
					</div>
				</div>
				<div class="modal-footer">
<center>
	<button id="confirmsignup" onclick="sign_up()" class="btn btn-success">確定註冊</button>
	
	<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
</center>				
				</div>
			</div>
		</div>
	</div>

</div>


<script>
	$("#mem_profile").change(function() {
		change_readImage(this);
// 		alert(this);
	});
	
	function change_readImage(input) {
		if (input.files && input.files[0]) {
			var picFile = new FileReader();
			picFile.onload = function(e) {
				var pic = e.target.result; //string
// 				console.log(pic);
				console.log(input.id);
				$("#" +　input.id + "_img" ).show();
				$("#" +　input.id + "_img" ).attr("src", pic);
				$("#" +　input.id + "_value" ).attr("value", pic);
				
// 				input.next("input").value = "<img style=' width: 150px; height: 150px; ' src='"+ pic +"' />";
			};
			picFile.readAsDataURL(input.files[0]); //base64 file tranfer to string
			
		}
	}
</script>
<script>
	$(document).ready(function() {
	    // ====Hide the Modal====
	    $("#loging_modal_close").click(function(){
	        $("#myModal").modal("hide");
	    });
		
	    
	    function sign_up() {
	    	var str_serialize = $("#form_sign_up").serialize();
	    	$.ajax({
	            url:   "<%=request.getContextPath()%>/front-end/loginhandler",
				type : "POST",
				data : str_serialize,
				//傳帳號密碼。
				success : function(data, status) {
// 					alert(data);
					var json_data = JSON.parse(data);
					if(json_data.log_result.indexOf("true")!= -1){
						$("#login_Modal_info_window").text("登入成功");
						$("#myModal").modal();	
						setInterval(function(){ 
							window.location.href = "<%=request.getContextPath()%>/front-end/homepage/index.jsp";
						}, 1500);
					}
					if (json_data.log_result.indexOf("false") != -1) {
							$("#login_Modal_info_window").text("帳號錯誤 請重新輸入");
							$("#myModal").modal();
					}
				},
				error : function(data,status, er) {
				}
			});
		}
	    
		// ==== ====		
	    $("#AM_btn_Member").click(function() {
			var str_serialize = $("#AM_LOGIN_from").serialize();
			alert(str_serialize); 
	    	
	    	$.ajax({
	            url:   "<%=request.getContextPath()%>/front-end/loginhandler",
				type : "POST",
				data : str_serialize,
				//傳帳號密碼。
				success : function(data, status) {
// 					alert(data);
					var json_data = JSON.parse(data);
					if(json_data.log_result.indexOf("true")!= -1){
						$("#login_Modal_info_window").text("登入成功");
						$("#myModal").modal();	
						setInterval(function(){ 
							window.location.href = "<%=request.getContextPath()%>/front-end/homepage/index.jsp";
						}, 1500);
					}
					if (json_data.log_result.indexOf("false") != -1) {
							$("#login_Modal_info_window").text("帳號錯誤 請重新輸入");
							$("#myModal").modal();
					}
				},
				error : function(data,status, er) {
				}
			});
		});
	});
</script>

