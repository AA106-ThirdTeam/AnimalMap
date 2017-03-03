<%@ page contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.emp_purview.model.*"%>
<%@ page import="java.util.*"%>

<%
// 		Set<Emp_purviewVO> set= (Set<Emp_purviewVO>)session.getAttribute("set");
// 		System.out.println(set);
// 		Set<String> set2 = new HashSet();
// 		for(Emp_purviewVO vo: set){
// 			vo.getEmp_No();
// 			vo.getPurview_No();
// 			set2.add(vo.getPurview_No());
// 			System.out.print(vo.getEmp_No());
// 			System.out.print(vo.getPurview_No());
// 		}
%>



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
	<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
/* html, body, h1, h2, h3, h4, h5 { */
/* 	font-family: "Raleway", sans-serif */
/* } */


	a{
	color:white;
	}
 


</style>
<!--  ==== ==== -->
</head>


<%
//         if(set2.contains("21000000")){
//         	System.out.print("123");
//         }
%>



<body class="w3-light-grey">


	
	<div class="collapse navbar-collapse navbar-ex1-collapse navbar-fixed-top" style="background: black;">
	<b style='font-size:30px; color:white; font-weight: 700;'>Animal Map</b>
	<img class="img-circle" width="50" height="50" style="margin-bottom: 5px;margin-left: 15px;" src="https://i.imgur.com/rv4YG8U.jpg">				
	
			<!-- 右選單 -->
			<ul class="nav navbar-nav navbar-right" style="color:white;" >
					
						
						<li><a href="#" class="glyphicon glyphicon-user">${empVO.emp_name}　您好</a></li>
						
						<li><a href='#modal-id' data-toggle="modal" class="glyphicon glyphicon-cog" >修改密碼</a><li>
							
							<form id="login_Out_Form" method="post" action="<%=request.getContextPath() %>/login" style="position: absolute;">
								<input type="hidden" name="action" value="login_Out">
							</form>
						<li><a href="#" class="glyphicon glyphicon-log-out" onclick="login_out()">　登出</a></li>
							
							
					</ul>						
				
	</div>
<!-- 	按下修改密碼時  彈跳出來-->
	<div class="modal fade" id="modal-id">
   	<div class="modal-dialog">
   	
   	<form id='PassWordForm'>	
   		<div class="modal-content">
   			<div class="modal-header">
   				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
   				<h4 class="modal-title">密碼修改</h4>
   			</div>
   			
   			<div class="modal-body">	
   			
   				<input type="password" name="emp_Pw" value="" id='emp_Pw'> 
   				
   				<input type="hidden" name="emp_picture" value="123" > 
   				<input type="hidden" name="emp_name" value="${empVO.emp_name}"> 
   				<input type="hidden" name="emp_email" value="${empVO.emp_email}"> 
   				<input type="hidden" name="emp_Id" value="${empVO.emp_Id}"> 
   				<input type="hidden" name="emp_birthday" value="${empVO.emp_birthday}"> 
   				<input type="hidden" name="emp_phone" value="${empVO.emp_phone}"> 
   				<input type="hidden" name="emp_address" value="${empVO.emp_address}"> 
   				<input type="hidden" name="emp_status" value="${empVO.emp_status}"> 
   				<input type="hidden" name="emp_hiredate" value="${empVO.emp_hiredate}"> 
   				<input type="hidden" name="emp_firedate" value="${empVO.emp_firedate}"> 
   				<input type="hidden" name="emp_No" value="${empVO.emp_No}">
   				<input type="hidden" name="requestURL" value="<%=request.getServletPath()%>">
   				
				<input type="hidden" name="action" value="update">
				
   			</div>
   			<div class="modal-footer">
   				<button type="button" class="btn btn-default" data-dismiss="modal" id='close_form'>關閉</button>
   				<button type="button" class="btn btn-primary" data-dismiss="modal" id='ChangesPassWord'>送出</button>
   			</div>
   		</div>
   	</form>	
   	</div>
   </div>
	
	
	
	<!-- Sidenav/menu -->
	<nav class="w3-sidenav w3-collapse w3-white w3-animate-left"
		style="z-index: 3; width: 300px;" id="mySidenav">
		<br>
		<div class="w3-container w3-row" style="margin-top: 50px;">
			<div class="w3-col s4">
				<img src="<%= request.getContextPath()%>/EmpPhotoReader?emp_No=${empVO.emp_No}"
					class="img img-rounded " style="width: 70px">
			</div>
			<div class="w3-col s8">
				<span style='font-size:25px;'>員工: <strong>${empVO.emp_name}</strong></span><br> 
				
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
				value='<%=request.getContextPath()%>/back-end/product/addProduct.jsp'
				onClick="$('#test222').attr('src',this.value);"
				style="width: 97%;text-align: left;padding-right:5px;margin-left: 1.5%;"
			>
				<i class="fa fa-eye fa-fw"></i>商品
			</button>
			<button type="button" class="btn btn-info" 
			/AnimalMap/WebContent
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
				value='<%=request.getContextPath()%>/back-end/emp/select_pageForView.jsp'
				onClick="$('#test222').attr('src',this.value);"
				style="width: 97%;text-align: left;padding-right:5px;margin-left: 1.5%;"
			>
				<i class="fa fa-eye fa-fw"></i>員工管理
			</button>
			<button type="button" class="btn btn-info" 
				value='<%=request.getContextPath()%>/back-end/emp_purview/listAllEmp_purview.jsp'
				onClick="$('#test222').attr('src',this.value);"
				style="width: 97%;text-align: left;padding-right:5px;margin-left: 1.5%;"
			>
				<i class="fa fa-eye fa-fw"></i>員工權限明細
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
				value='<%=request.getContextPath()%>/back-end/report/listAllReport.jsp'
				onClick="$('#test222').attr('src',this.value);"
				style="width: 97%;text-align: left;padding-right:5px;margin-left: 1.5%;"
			>
				<i class="fa fa-eye fa-fw"></i>檢舉
			</button>
			<button type="button" class="btn btn-info" 
				value='<%=request.getContextPath()%>/Heibernate_back-end/rel_list/select_page.jsp'
				onClick="$('#test222').attr('src',this.value);"
				style="width: 97%;text-align: left;padding-right:5px;margin-left: 1.5%;"
			>
				<i class="fa fa-eye fa-fw"></i>關係名單
			</button>
			<button type="button" class="btn btn-info" 
				value='<%=request.getContextPath()%>/Heibernate_back-end/priv_message/select_page.jsp'
				onClick="$('#test222').attr('src',this.value);"
				style="width: 97%;text-align: left;padding-right:5px;margin-left: 1.5%;"
			>
				<i class="fa fa-eye fa-fw"></i>私人訊息
			</button>
			<button type="button" class="btn btn-info" 
				value='<%=request.getContextPath()%>/Heibernate_back-end/shop_comment/select_page.jsp'
				onClick="$('#test222').attr('src',this.value);"
				style="width: 97%;text-align: left;padding-right:5px;margin-left: 1.5%;"
			>
				<i class="fa fa-eye fa-fw"></i>商家留言
			</button>
			<button type="button" class="btn btn-info" 
				value='<%=request.getContextPath()%>/Heibernate_back-end/shop_photo/select_page.jsp'
				onClick="$('#test222').attr('src',this.value);"
				style="width: 97%;text-align: left;padding-right:5px;margin-left: 1.5%;"
			>
				<i class="fa fa-eye fa-fw"></i>商家相片
			</button>
			<button type="button" class="btn btn-info" 
				value='<%=request.getContextPath()%>/Heibernate_back-end/petshop/select_page.jsp'
				onClick="$('#test222').attr('src',this.value);"
				style="width: 97%;text-align: left;padding-right:5px;margin-left: 1.5%;"
			>
				<i class="fa fa-eye fa-fw"></i>寵物商店
			</button>
			<button type="button" class="btn btn-info" 
				value='<%=request.getContextPath()%>/Heibernate_back-end/grp_comment/select_page.jsp'
				onClick="$('#test222').attr('src',this.value);"
				style="width: 97%;text-align: left;padding-right:5px;margin-left: 1.5%;"
			>
				<i class="fa fa-eye fa-fw"></i>揪團留言
			</button>
			<button type="button" class="btn btn-info" 
				value='<%=request.getContextPath()%>/Heibernate_back-end/joinlist/select_page.jsp'
				onClick="$('#test222').attr('src',this.value);"
				style="width: 97%;text-align: left;padding-right:5px;margin-left: 1.5%;"
			>
				<i class="fa fa-eye fa-fw"></i>揪團參加名單
			</button>
			<button type="button" class="btn btn-info" 
				value='<%=request.getContextPath()%>/Heibernate_back-end/petgroup/select_page.jsp'
				onClick="$('#test222').attr('src',this.value);"
				style="width: 97%;text-align: left;padding-right:5px;margin-left: 1.5%;"
			>
				<i class="fa fa-eye fa-fw"></i>揪團
			</button>
			<button type="button" class="btn btn-info" 
				value='<%=request.getContextPath()%>/Heibernate_back-end/hos_photo/select_page.jsp'
				onClick="$('#test222').attr('src',this.value);"
				style="width: 97%;text-align: left;padding-right:5px;margin-left: 1.5%;"
			>
				<i class="fa fa-eye fa-fw"></i>診所相片
			</button>
			<button type="button" class="btn btn-info" 
				value='<%=request.getContextPath()%>/Heibernate_back-end/hos_comment/select_page.jsp'
				onClick="$('#test222').attr('src',this.value);"
				style="width: 97%;text-align: left;padding-right:5px;margin-left: 1.5%;"
			>
				<i class="fa fa-eye fa-fw"></i>診所留言
			</button>
			<button type="button" class="btn btn-info" 
				value='<%=request.getContextPath()%>/Heibernate_back-end/vet_hospital/select_page.jsp'
				onClick="$('#test222').attr('src',this.value);"
				style="width: 97%;text-align: left;padding-right:5px;margin-left: 1.5%;"
			>
				<i class="fa fa-eye fa-fw"></i>診所
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
		
		//員工登出
		function login_out() {
			$( "#login_Out_Form" ).submit();
		}
		
		//送出修改密碼的資訊到controller
		$("#ChangesPassWord").click(function(){
			$.ajax({
				   type:"POST",
				   url:"<%=request.getContextPath()%>/back-end/emp/emp.do",
				   data:$("#PassWordForm").serialize(),
				   
				   success:function(data){
					   console.log(data);
					   alert("更改成功");
					   
					   //把之前在Form表單裡的值清空
					   $("#emp_Pw").val("");
					   $("#close_form").click();
				   },
				   error:function(data){
					   alert("傳送失敗")
				   }				   
			   })
		});
		
		

		
		
	
	</script>
	
</body>
</html>
