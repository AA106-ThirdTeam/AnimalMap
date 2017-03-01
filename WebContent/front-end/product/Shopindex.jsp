<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>

<!DOCTYPE html>
<html>
<head>
<title>Shop.jsp</title>
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<link rel="stylesheet" href="<%=request.getContextPath()%>/front-end/css/layout.css"/>
<script src="<%=request.getContextPath()%>/front-end/js/sweetalert.min.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1.0"> 
<meta name="description" content="3D Gallery with CSS3 and jQuery" />
<meta name="keywords" content="3d, gallery, jquery, css3, auto, slideshow, navigate, mouse scroll, perspective" />
<meta name="author" content="Codrops" />
<link rel="shortcut icon" href="../favicon.ico">
<%-- <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/front-end/css/demo.css" /> --%>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/front-end/css/style.css" />
<script type="text/javascript" src="<%=request.getContextPath()%>/front-end/js/modernizr.custom.53451.js"></script>
</head>
<body>
<div id="layout">
	<div id="header">
		<div id="logo"><a href="#"><img src="<%=request.getContextPath()%>/front-end/images/1.png" alt="" /></a>
		</div><!-- End div_logo-->
<!--     	<DIV CLASS="MEMBER_LOGIN"> -->
<!--       		<DIV CLASS="LOGIN_BOX"> -->
<!--         		<FORM ACTION="" METHOD="GET"> -->
<!--           			<FIELDSET> -->
<!--           			<DIV CLASS="COLUMN_1"> -->
<!--             			<LABEL>USERNAME :</LABEL> -->
<!--             			<LABEL>PASSWORD :</LABEL> -->
<!--           			</DIV>END DIV_COLUMN_1 -->
<!--           			<DIV CLASS="COLUMN_2"> -->
<!--             			<INPUT TYPE="TEXT" NAME="" VALUE="" /> -->
<!--             			<INPUT TYPE="TEXT" NAME="" VALUE="" /> -->
<!--           			</DIV>END DIV_COLUMN_2 -->
<!--           			<DIV CLASS="COLUMN_3"> -->
<%--             			<INPUT TYPE="IMAGE" SRC="<%=REQUEST.GETCONTEXTPATH()%>/FRONT-END/IMAGES/LOGIN_BTN.GIF" CLASS="LOGIN"/> --%>
<!--           			</DIV>END DIV_COLUMN_3 -->
<!--           			<DIV CLASS="COLUMN_4"> -->
<!--             			<LABEL CLASS="PASSWORD"><A HREF="#">FORGOT <BR /> -->
<!--             			PASSWORD</A></LABEL> -->
<!--           			</DIV>END DIV_COLUMN_4 -->
<!-- 					</FIELDSET> -->
<!--         		</FORM> -->
<!--       		</DIV>END DIV_LOGIN_BOX -->
<!--     	</DIV>END DIV_NUMBER_LOGIN -->
	</div><!-- End div_header-->
<div id="body_container">
	<div id="body_container_inner">
		<div id="menu">
	        <ul>
	          <li><a class="current">home</a></li> 
	          <li><a href="<%=request.getContextPath()%>/front-end/product/Shop.jsp">Product</a></li>
	          <li><a href="<%=request.getContextPath()%>/front-end/orders/listMyOrders.jsp">Orders</a></li>
	          <li><a href="<%=request.getContextPath()%>/front-end/product/Charge.jsp">Charge</a></li>
	          <li><a href="<%=request.getContextPath()%>/front-end/product/Cart.jsp">ShoppingCart</a></li>
	          <li><a href="<%=request.getContextPath()%>/front-end/product/shopQ&A.jsp">Q&A</a></li>
	        </ul>
		</div><!-- EndMenu -->
		<div class="banner"><a href="#">
			<img src="<%=request.getContextPath()%>/front-end/images/banner2.jpg" /></a>
		</div><!-- End div_banner-->
		<div class="container_row">
        	<div class="welcomezone"><!-- 內容START-->
				<section id="dg-container" class="dg-container">
					<div class="dg-wrapper">
						<a href="#"><img src="<%=request.getContextPath()%>/front-end/images/100.jpg" alt="image01"></a>
						<a href="#"><img src="<%=request.getContextPath()%>/front-end/images/101.jpg" alt="image02"></a>
						<a href="#"><img src="<%=request.getContextPath()%>/front-end/images/102.png" alt="image03"></a>
						<a href="#"><img src="<%=request.getContextPath()%>/front-end/images/103.jpg" alt="image04"></a>
					</div>
					<nav>	
						<span class="dg-prev">&lt;</span>
						<span class="dg-next">&gt;</span>
					</nav>
				</section>
      		</div><!-- END -->
 			<div id="footer">
				<div class="footer_link">
				<ul style="color:#FFf;">
		          SSSSSSSSSSSSSS
				</ul>
				</div><!-- End div_footer_link-->
			</div><!-- End div_footer-->
		</div><!-- End div_container_row-->
	</div><!-- End div_body_container_inner-->
</div><!-- End div_body_container-->
</div><!-- End layout-->
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/front-end/js/jquery.gallery.js"></script>
		<script type="text/javascript">
			$(function() {
				$('#dg-container').gallery();
			});
</script>
</body>
</html>