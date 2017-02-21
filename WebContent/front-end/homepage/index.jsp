<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%
	boolean isLogin = false;
	// 【從 session 判斷此user是否登入過】
	Object account = session.getAttribute("account");
	if (account == null) {
		isLogin = true;
	}
%>
<!DOCTYPE html>
<html>
<head>
<title>動物地圖</title>
<!-- 載入共用CSS、JS -->
<%@include file="/front-end/assets/header.jsp"%>
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
		">
	 
	 
	 	<div style="padding-left: 85%;">
	 		<img onclick="close_details_page();" style="cursor:pointer" src="https://maxcdn.icons8.com/Color/PNG/24/User_Interface/close_window-24.png" alt="Close" width="42" height="42">
	 	</div>
		<iframe frameborder="0" src="<%=request.getContextPath()%>/front-end/adoptani/select_page.jsp" 
			style="	    
			    left: 0px;
			    top: 0px;
			    width: 75vw;
			    height: 75vh;
			    z-index: 10000;	    
		    "
		></iframe>
	</div>

    <script type="text/javascript">
        function close_details_page(argument) {
            $("#details_page").hide();
        }
        function show_details_page(argument) {
            $("#details_page").show();
        }        
    </script>


    <script>
	<!-- login畫面 -->

	<div id="AM_Login"
		style="background-color: rgba(38, 35, 35, 0.83); position: fixed; width: 100%; z-index: 10000;">
		<%
			if (isLogin) {
		%>
		<%@include file="/front-end/login/index.jsp"%>
		<%
			}
			;
		%>		
	</div>

	<div id="AM_body">
		<div>
			<div class="col-md-12" id="AM_nav" style="z-index: 5;">
				<%@include file="/front-end/homepage/nav.jsp"%>
			</div>
		</div>
		<div class="col-md-4 hidden-xs hidden-sm" id="AM_aside">
			<%@include file="/front-end/homepage/aside.jsp"%>
		</div>
		<div class="col-md-8" data-aos="fade-up" id="AM_section">
			<%@include file="/front-end/homepage/section.jsp"%>
		</div>
		<div>
			<div class="col-md-12" id="AM_footer">
				<%@include file="/front-end/assets/footer.jsp"%>
			</div>
		</div>
	</div>
</body>
</html>