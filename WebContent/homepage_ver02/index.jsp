<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> -->
<!DOCTYPE html>
<html>
<head>
	<title>動物地圖</title><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	
	<!-- 載入共用CSS、JS -->
		<%@include file="/homepage_ver02/header.jsp" %>
</head>
<body>
	<div class="row" style="height: 50%;">
		<div class="col-md-12" id="AM_nav" >
			<%@include file="/homepage_ver02/nav.jsp" %>	
		</div>
	</div>
	<div class="row" style="box-shadow: 3px 3px 3px 5px #cccccc;height: 70%;">
		<div class="col-md-4" id="AM_aside">
			<%@include file="/homepage_ver02/aside.jsp" %>
		</div>	
		<div class="col-md-8" data-aos="fade-up" id="AM_section">
			<%@include file="/homepage_ver02/section.jsp" %>
		</div>
	
	</div>
	<div class="row">
		<div class="col-md-12" id="AM_footer"
			style="padding: 0; ">
			<%@include file="/homepage_ver02/footer.jsp" %>			
		</div>
		<div class="col-md-12"></div>
	</div>
</body>
</html>