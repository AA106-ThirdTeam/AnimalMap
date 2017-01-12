<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<!-- <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> -->
<!DOCTYPE html>
<html>
<head>
	<title>動物地圖</title>
	<!-- 載入共用CSS、JS -->
	<%@include file="/homepage_ver02/header.jsp" %>
</head>
<body>
	<div>
		<div class="col-md-12" id="AM_nav" >
			<%@include file="/homepage_ver02/nav.jsp" %>	
		</div>
	</div>
	< div>
		<div class="col-md-4 hidden-xs hidden-sm" id="AM_aside">
			<%@include file="/homepage_ver02/aside.jsp" %>
		</div>	
		<div class="col-md-8" data-aos="fade-up" id="AM_section">
			<%@include file="/homepage_ver02/section.jsp" %>
		</div>
	</div>
	<div>
		<div class="col-md-12" id="AM_footer">
			<%@include file="/homepage_ver02/footer.jsp" %>			
		</div>
	</div>
</body>
</html>