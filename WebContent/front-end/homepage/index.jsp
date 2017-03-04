<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@page import="heibernate_com.mem.model.MemVO"%>
<%
	boolean isLogin = false;
	// 【從 session 判斷此user是否登入過】
	heibernate_com.mem.model.MemVO account = (heibernate_com.mem.model.MemVO)session.getAttribute("account");
	
	
	if (account != null) {
		isLogin = true;
	}
	request.setAttribute("isLogin", isLogin);
%>

<style>
	.modal-backdrop.fade.in{
/*  		z-index: -1;  */
/* 		background: rgba(255, 0, 0, 0); */
		z-index: 999;
	}
	.modal-backdrop.fade.out{
/*  		z-index: -1;  */
/* 		background: rgba(255, 0, 0, 0); */
	}
</style>

<!DOCTYPE html>
<html>
<head>
<title>動物地圖</title>
<!-- 載入共用CSS、JS -->
<%@include file="/front-end/assets/header.jsp"%>


<!-- 獲取所有圖標物件 -->
<%@include file="/front-end/google_map/google_map_marker_list.jsp"%>

</head>
<body style="overflow: hidden;">

	<!-- 詳細資料頁面 -->
	<div id="details_page" style=
		"
			position: absolute;
		    z-index: 9999;
		    background-color: rgba(38, 35, 35, 0.83);
		    width: 100%;
		    height: 100vh;
		    padding-left: 15%;
		    padding-top: 5%;
		    border: 0;	
		" >
	 
	 
	 	<div style="padding-left: 85%;">
	 		<img onclick="close_details_page();" style="cursor:pointer" src="https://maxcdn.icons8.com/Color/PNG/24/User_Interface/close_window-24.png" alt="Close" width="42" height="42">
	 	</div>
	 	<!--  http://localhost:8081/AnimalMap/hos/hos.do?hos_Id=13000000&action=listHos_ByCompositeQuery-->
<%-- 		<iframe frameborder="0" src="<%=request.getContextPath()%>/front-end/adoptani/select_page.jsp"  --%>
		<iframe id="details_page_iframe" frameborder="0" src="" 
			style="	    
			    left: 0px;
			    top: 0px;
			    width: 75vw;
			    height: 80vh;
			    z-index: 10000;	    
		    "
		></iframe>
	</div>

    <script type="text/javascript">
    	//init
    	$("#details_page").hide();
    
        function close_details_page(argument) {
        	$("#details_page_iframe").attr('src', '');
            $("#details_page").hide();
        }
        function show_details_page(argument) {
// 			var parameter_Id = argument[0];
// 			var path_parameter = 'action=getOne_For_Display&adopt_Ani_Id=' + parameter_Id;
// 			var src='/AnimalMap/front-end/adoptani/adoptani.do?'+path_parameter 
// 			$('#details_page_iframe').attr('src',src);        	
            $("#details_page").show();
        }        
    </script>
	<div id="container">
		<div id="AM_body">
			<div class="row">
				<div>
					<div class="col-md-12" id="AM_nav" style="
/* 						z-index: 1000;  */
						height:50px;background-color: #1B9CB0 ;">
						<%@include file="/front-end/homepage/nav.jsp"%>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-4 hidden-xs hidden-sm" id="AM_aside">
					<%@include file="/front-end/homepage/aside.jsp"%>
				</div>
				<div class="col-md-8" data-aos="fade-up" id="AM_section">
					<%@include file="/front-end/homepage/section.jsp"%>
				</div>
			</div>
			<div class="row">
					<div class="col-md-12" id="AM_footer">
						<%@include file="/front-end/assets/footer.jsp"%>
					</div>
				</div>
		</div>
	</div>
</body>
</html>


