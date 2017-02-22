<%@ page contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> 
<%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<!-- ==== ==== -->
	<title>動物地圖 後台首頁</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<!-- w3 -->
	<link rel="stylesheet" href="http://www.w3schools.com/lib/w3.css">
	<link rel="stylesheet"
		href="https://fonts.googleapis.com/css?family=Raleway">
	<link rel="stylesheet"
		href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<!-- 共用HEAD -->
	<!-- BS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script src="https://code.jquery.com/jquery.js"></script>
<style>
/* html, body, h1, h2, h3, h4, h5 { */
/* 	font-family: "Raleway", sans-serif */
/* } */
</style>
<!--  ==== ==== -->
</head>
<body class="w3-light-grey">
	<!-- Top container -->
	<div class="w3-container w3-top w3-black w3-large w3-padding"
		style="z-index: 4">
		<button class="w3-btn w3-hide-large w3-padding-0 w3-hover-text-grey"
			onclick="w3_open();">
			<i class="fa fa-bars"></i>  Menu
		</button>
		<span class="w3-right"> <img
			src="https://i.imgur.com/rv4YG8U.jpg"
			class="w3-circle w3-margin-right" style="width: 46px"></span>
	</div>
	<!-- Sidenav/menu -->
	<nav class="w3-sidenav w3-collapse w3-white w3-animate-left"
		style="z-index: 3; width: 300px;" id="mySidenav">
		<br>
		<div class="w3-container w3-row">
			<div class="w3-col s4">
				<img src="https://i.imgur.com/GHxVCXl.png"
					class="w3-circle w3-margin-right" style="width: 46px">
			</div>
			<div class="w3-col s8">
				<span>員工: <strong>魯夫</strong></span><br> <a href="#"
					class="w3-hover-none w3-hover-text-red w3-show-inline-block"><i
					class="fa fa-envelope"></i> </a> <a href="#"
					class="w3-hover-none w3-hover-text-green w3-show-inline-block"><i
					class="fa fa-user"></i> </a> <a href="#"
					class="w3-hover-none w3-hover-text-blue w3-show-inline-block"><i
					class="fa fa-cog"></i> </a>
			</div>
		</div>
		<hr>
		<div class="w3-container">
		</div>
		<a href="#"
			class="w3-padding-16 w3-hide-large w3-dark-grey w3-hover-black"
			onclick="w3_close()" title="close menu"><i
			class="fa fa-remove fa-fw"></i>  關閉清單</a>
			<button type="button" class="btn btn-primary" 
							style="width: 97%;margin-left: 1.5%;"
			>
				<i class="fa fa-users fa-fw"></i>【表格管理】
			</button>
			<button type="button" class="btn btn-info" 
				value='<%=request.getContextPath()%>/Heibernate_back-end/charge/select_page.jsp'
				onClick="$('#test222').attr('src',this.value);"
				style="width: 97%;text-align: left;padding-right:5px;margin-left: 1.5%;"
			>
				<i class="fa fa-eye fa-fw"></i>儲值
			</button>
			<button type="button" class="btn btn-info" 
				value='<%=request.getContextPath()%>/Heibernate_back-end/product_kind/select_page.jsp'
				onClick="$('#test222').attr('src',this.value);"
				style="width: 97%;text-align: left;padding-right:5px;margin-left: 1.5%;"
			>
				<i class="fa fa-eye fa-fw"></i>商品類別
			</button>
			<button type="button" class="btn btn-info" 
				value='<%=request.getContextPath()%>/Heibernate_back-end/orders_item/select_page.jsp'
				onClick="$('#test222').attr('src',this.value);"
				style="width: 97%;text-align: left;padding-right:5px;margin-left: 1.5%;"
			>
				<i class="fa fa-eye fa-fw"></i>訂單明細
			</button>
			<button type="button" class="btn btn-info" 
				value='<%=request.getContextPath()%>/Heibernate_back-end/second_prodphotos/select_page.jsp'
				onClick="$('#test222').attr('src',this.value);"
				style="width: 97%;text-align: left;padding-right:5px;margin-left: 1.5%;"
			>
				<i class="fa fa-eye fa-fw"></i>二手商品相簿
			</button>
			<button type="button" class="btn btn-info" 
				value='<%=request.getContextPath()%>/Heibernate_back-end/second_prodmsg/select_page.jsp'
				onClick="$('#test222').attr('src',this.value);"
				style="width: 97%;text-align: left;padding-right:5px;margin-left: 1.5%;"
			>
				<i class="fa fa-eye fa-fw"></i>二手商品留言
			</button>
			<button type="button" class="btn btn-info" 
				value='<%=request.getContextPath()%>/Heibernate_back-end/product/select_page.jsp'
				onClick="$('#test222').attr('src',this.value);"
				style="width: 97%;text-align: left;padding-right:5px;margin-left: 1.5%;"
			>
				<i class="fa fa-eye fa-fw"></i>商品
			</button>
			<button type="button" class="btn btn-info" 
				value='<%=request.getContextPath()%>/Heibernate_back-end/second_prod/select_page.jsp'
				onClick="$('#test222').attr('src',this.value);"
				style="width: 97%;text-align: left;padding-right:5px;margin-left: 1.5%;"
			>
				<i class="fa fa-eye fa-fw"></i>二手商品
			</button>
			<button type="button" class="btn btn-info" 
				value='<%=request.getContextPath()%>/Heibernate_back-end/orders/select_page.jsp'
				onClick="$('#test222').attr('src',this.value);"
				style="width: 97%;text-align: left;padding-right:5px;margin-left: 1.5%;"
			>
				<i class="fa fa-eye fa-fw"></i>訂單
			</button>
			<button type="button" class="btn btn-info" 
				value='<%=request.getContextPath()%>/Heibernate_back-end/emp_purview/select_page.jsp'
				onClick="$('#test222').attr('src',this.value);"
				style="width: 97%;text-align: left;padding-right:5px;margin-left: 1.5%;"
			>
				<i class="fa fa-eye fa-fw"></i>員工權限
			</button>
			<button type="button" class="btn btn-info" 
				value='<%=request.getContextPath()%>/Heibernate_back-end/purview/select_page.jsp'
				onClick="$('#test222').attr('src',this.value);"
				style="width: 97%;text-align: left;padding-right:5px;margin-left: 1.5%;"
			>
				<i class="fa fa-eye fa-fw"></i>權限
			</button>
			<button type="button" class="btn btn-info" 
				value='<%=request.getContextPath()%>/Heibernate_back-end/animal_index/select_page.jsp'
				onClick="$('#test222').attr('src',this.value);"
				style="width: 97%;text-align: left;padding-right:5px;margin-left: 1.5%;"
			>
				<i class="fa fa-eye fa-fw"></i>動物圖鑑
			</button>
			<button type="button" class="btn btn-info" 
				value='<%=request.getContextPath()%>/Heibernate_back-end/emg_h_msg/select_page.jsp'
				onClick="$('#test222').attr('src',this.value);"
				style="width: 97%;text-align: left;padding-right:5px;margin-left: 1.5%;"
			>
				<i class="fa fa-eye fa-fw"></i>緊急求救留言
			</button>
			<button type="button" class="btn btn-info" 
				value='<%=request.getContextPath()%>/Heibernate_back-end/emg_help/select_page.jsp'
				onClick="$('#test222').attr('src',this.value);"
				style="width: 97%;text-align: left;padding-right:5px;margin-left: 1.5%;"
			>
				<i class="fa fa-eye fa-fw"></i>緊急求救
			</button>
			<button type="button" class="btn btn-info" 
				value='<%=request.getContextPath()%>/Heibernate_back-end/report/select_page.jsp'
				onClick="$('#test222').attr('src',this.value);"
				style="width: 97%;text-align: left;padding-right:5px;margin-left: 1.5%;"
			>
				<i class="fa fa-eye fa-fw"></i>檢舉
			</button>
			<button type="button" class="btn btn-info" 
				value='<%=request.getContextPath()%>/Heibernate_back-end/stray_ani_photos/select_page.jsp'
				onClick="$('#test222').attr('src',this.value);"
				style="width: 97%;text-align: left;padding-right:5px;margin-left: 1.5%;"
			>
				<i class="fa fa-eye fa-fw"></i>社區流浪動物相簿
			</button>
			<button type="button" class="btn btn-info" 
				value='<%=request.getContextPath()%>/Heibernate_back-end/stray_ani_message/select_page.jsp'
				onClick="$('#test222').attr('src',this.value);"
				style="width: 97%;text-align: left;padding-right:5px;margin-left: 1.5%;"
			>
				<i class="fa fa-eye fa-fw"></i>社區流浪動物留言
			</button>
			<button type="button" class="btn btn-info" 
				value='<%=request.getContextPath()%>/Heibernate_back-end/stray_ani_loc/select_page.jsp'
				onClick="$('#test222').attr('src',this.value);"
				style="width: 97%;text-align: left;padding-right:5px;margin-left: 1.5%;"
			>
				<i class="fa fa-eye fa-fw"></i>社區流浪動物出沒範圍
			</button>
			<button type="button" class="btn btn-info" 
				value='<%=request.getContextPath()%>/Heibernate_back-end/stray_ani/select_page.jsp'
				onClick="$('#test222').attr('src',this.value);"
				style="width: 97%;text-align: left;padding-right:5px;margin-left: 1.5%;"
			>
				<i class="fa fa-eye fa-fw"></i>社區流浪動物
			</button>
			<button type="button" class="btn btn-info" 
				value='<%=request.getContextPath()%>/Heibernate_back-end/pet_photos/select_page.jsp'
				onClick="$('#test222').attr('src',this.value);"
				style="width: 97%;text-align: left;padding-right:5px;margin-left: 1.5%;"
			>
				<i class="fa fa-eye fa-fw"></i>自家寵物相簿
			</button>
			<button type="button" class="btn btn-info" 
				value='<%=request.getContextPath()%>/Heibernate_back-end/pet_message/select_page.jsp'
				onClick="$('#test222').attr('src',this.value);"
				style="width: 97%;text-align: left;padding-right:5px;margin-left: 1.5%;"
			>
				<i class="fa fa-eye fa-fw"></i>自家寵物留言
			</button>
			<button type="button" class="btn btn-info" 
				value='<%=request.getContextPath()%>/Heibernate_back-end/pet/select_page.jsp'
				onClick="$('#test222').attr('src',this.value);"
				style="width: 97%;text-align: left;padding-right:5px;margin-left: 1.5%;"
			>
				<i class="fa fa-eye fa-fw"></i>自家寵物
			</button>
			<button type="button" class="btn btn-info" 
				value='<%=request.getContextPath()%>/Heibernate_back-end/adopt_ani_photos/select_page.jsp'
				onClick="$('#test222').attr('src',this.value);"
				style="width: 97%;text-align: left;padding-right:5px;margin-left: 1.5%;"
			>
				<i class="fa fa-eye fa-fw"></i>送養動物相簿
			</button>
			<button type="button" class="btn btn-info" 
				value='<%=request.getContextPath()%>/Heibernate_back-end/adopt_ani_message/select_page.jsp'
				onClick="$('#test222').attr('src',this.value);"
				style="width: 97%;text-align: left;padding-right:5px;margin-left: 1.5%;"
			>
				<i class="fa fa-eye fa-fw"></i>送養動物留言
			</button>
			<button type="button" class="btn btn-info" 
				value='<%=request.getContextPath()%>/Heibernate_back-end/adopt_ani_sponsor/select_page.jsp'
				onClick="$('#test222').attr('src',this.value);"
				style="width: 97%;text-align: left;padding-right:5px;margin-left: 1.5%;"
			>
				<i class="fa fa-eye fa-fw"></i>送養動物贊助
			</button>
			<button type="button" class="btn btn-info" 
				value='<%=request.getContextPath()%>/Heibernate_back-end/adoanispo/select_page.jsp'
				onClick="$('#test222').attr('src',this.value);"
				style="width: 97%;text-align: left;padding-right:5px;margin-left: 1.5%;"
			>
				<i class="fa fa-eye fa-fw"></i>送養動物領養人
			</button>
			<button type="button" class="btn btn-info" 
				value='<%=request.getContextPath()%>/Heibernate_back-end/adopt_ani/select_page.jsp'
				onClick="$('#test222').attr('src',this.value);"
				style="width: 97%;text-align: left;padding-right:5px;margin-left: 1.5%;"
			>
				<i class="fa fa-eye fa-fw"></i>送養動物
			</button>
			<button type="button" class="btn btn-info" 
				value='<%=request.getContextPath()%>/Heibernate_back-end/post_response/select_page.jsp'
				onClick="$('#test222').attr('src',this.value);"
				style="width: 97%;text-align: left;padding-right:5px;margin-left: 1.5%;"
			>
				<i class="fa fa-eye fa-fw"></i>討論區留言
			</button>
			<button type="button" class="btn btn-info" 
				value='<%=request.getContextPath()%>/Heibernate_back-end/post/select_page.jsp'
				onClick="$('#test222').attr('src',this.value);"
				style="width: 97%;text-align: left;padding-right:5px;margin-left: 1.5%;"
			>
				<i class="fa fa-eye fa-fw"></i>討論區
			</button>
			<button type="button" class="btn btn-info" 
				value='<%=request.getContextPath()%>/Heibernate_back-end/offimsg/select_page.jsp'
				onClick="$('#test222').attr('src',this.value);"
				style="width: 97%;text-align: left;padding-right:5px;margin-left: 1.5%;"
			>
				<i class="fa fa-eye fa-fw"></i>系統訊息
			</button>
			<button type="button" class="btn btn-info" 
				value='<%=request.getContextPath()%>/Heibernate_back-end/track/select_page.jsp'
				onClick="$('#test222').attr('src',this.value);"
				style="width: 97%;text-align: left;padding-right:5px;margin-left: 1.5%;"
			>
				<i class="fa fa-eye fa-fw"></i>追蹤收藏
			</button>
			<button type="button" class="btn btn-info" 
				value='<%=request.getContextPath()%>/Heibernate_back-end/adpphotos/select_page.jsp'
				onClick="$('#test222').attr('src',this.value);"
				style="width: 97%;text-align: left;padding-right:5px;margin-left: 1.5%;"
			>
				<i class="fa fa-eye fa-fw"></i>領養活動相簿
			</button>
			<button type="button" class="btn btn-info" 
				value='<%=request.getContextPath()%>/Heibernate_back-end/adpmsg/select_page.jsp'
				onClick="$('#test222').attr('src',this.value);"
				style="width: 97%;text-align: left;padding-right:5px;margin-left: 1.5%;"
			>
				<i class="fa fa-eye fa-fw"></i>領養活動留言
			</button>
			<button type="button" class="btn btn-info" 
				value='<%=request.getContextPath()%>/Heibernate_back-end/adp/select_page.jsp'
				onClick="$('#test222').attr('src',this.value);"
				style="width: 97%;text-align: left;padding-right:5px;margin-left: 1.5%;"
			>
				<i class="fa fa-eye fa-fw"></i>領養活動
			</button>
			<button type="button" class="btn btn-info" 
				value='<%=request.getContextPath()%>/Heibernate_back-end/park/select_page.jsp'
				onClick="$('#test222').attr('src',this.value);"
				style="width: 97%;text-align: left;padding-right:5px;margin-left: 1.5%;"
			>
				<i class="fa fa-eye fa-fw"></i>公園
			</button>
			<button type="button" class="btn btn-info" 
				value='<%=request.getContextPath()%>/Heibernate_back-end/anihome_photos/select_page.jsp'
				onClick="$('#test222').attr('src',this.value);"
				style="width: 97%;text-align: left;padding-right:5px;margin-left: 1.5%;"
			>
				<i class="fa fa-eye fa-fw"></i>動物之家相簿
			</button>
			<button type="button" class="btn btn-info" 
				value='<%=request.getContextPath()%>/Heibernate_back-end/anihome_msg/select_page.jsp'
				onClick="$('#test222').attr('src',this.value);"
				style="width: 97%;text-align: left;padding-right:5px;margin-left: 1.5%;"
			>
				<i class="fa fa-eye fa-fw"></i>動物之家留言
			</button>
			<button type="button" class="btn btn-info" 
				value='<%=request.getContextPath()%>/Heibernate_back-end/anihome/select_page.jsp'
				onClick="$('#test222').attr('src',this.value);"
				style="width: 97%;text-align: left;padding-right:5px;margin-left: 1.5%;"
			>
				<i class="fa fa-eye fa-fw"></i>動物之家
			</button>
			<button type="button" class="btn btn-info" 
				value='<%=request.getContextPath()%>/Heibernate_back-end/mem/select_page.jsp'
				onClick="$('#test222').attr('src',this.value);"
				style="width: 97%;text-align: left;padding-right:5px;margin-left: 1.5%;"
			>
				<i class="fa fa-eye fa-fw"></i>一般會員
			</button>
			<button type="button" class="btn btn-info" 
				value='<%=request.getContextPath()%>/Heibernate_back-end/emp/select_page.jsp'
				onClick="$('#test222').attr('src',this.value);"
				style="width: 97%;text-align: left;padding-right:5px;margin-left: 1.5%;"
			>
				<i class="fa fa-eye fa-fw"></i>員工
			</button>
	</nav>
	<script>
// 		$(document).ready(function() {
// 			$("a").click(function() {
// 				alert($(this).val);
// 				$('#test222').load("/Excel2MVC/back-end/emp/select_page.jsp");
// 			})
// 		})
	</script>
	<!-- ==== ==== -->
	<!-- Overlay effect when opening sidenav on small screens -->
	<div class="w3-overlay w3-hide-large w3-animate-opacity"
		onclick="w3_close()" style="cursor: pointer" title="close side menu"
		id="myOverlay"></div>
	<div class="w3-main" style="margin-left: 300px; margin-top: 43px;">
		<!-- Header -->
		<header class="w3-container" style="padding-top: 22px"> </header>
		<div class="w3-container w3-section" >
			<iframe 
					id="test222" 
					style="
				    height: 100vh;
				    width: 77vw;" 
				    scrolling="Auto"
			>
			</iframe>
		</div>
		<hr>
		<!-- End page content -->
	</div>
	<script>
		// Get the Sidenav
		var mySidenav = document.getElementById("mySidenav");
		// Get the DIV with overlay effect
		var overlayBg = document.getElementById("myOverlay");
		// Toggle between showing and hiding the sidenav, and add overlay effect
		function w3_open() {
			if (mySidenav.style.display === 'block') {
				mySidenav.style.display = 'none';
				overlayBg.style.display = "none";
			} else {
				mySidenav.style.display = 'block';
				overlayBg.style.display = "block";
			}
		}
		// Close the sidenav with the close button
		function w3_close() {
			mySidenav.style.display = "none";
			overlayBg.style.display = "none";
		}
	</script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>
