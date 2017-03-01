<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>

<!DOCTYPE html>
<html>
<head>
<title>Shop.jsp</title>
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<link rel="stylesheet" href="<%=request.getContextPath()%>/front-end/css/layout.css"/>


</head>
<body>
<div id="layout">
	<div id="header">
		<div id="logo"><a href="#"><img src="<%=request.getContextPath()%>/front-end/images/1.png" alt="" /></a>
		</div><!-- End div_logo-->
<!--     	<div class="member_login"> -->
<!--       		<div class="login_box"> -->
<!--         		<form action="" method="get"> -->
<!--           			<fieldset> -->
<!--           			<div class="column_1"> -->
<!--             			<label>username :</label> -->
<!--             			<label>password :</label> -->
<!--           			</div>End div_column_1 -->
<!--           			<div class="column_2"> -->
<!--             			<input type="text" name="" value="" /> -->
<!--             			<input type="text" name="" value="" /> -->
<!--           			</div>End div_column_2 -->
<!--           			<div class="column_3"> -->
<%--             			<input type="image" src="<%=request.getContextPath()%>/front-end/images/login_btn.gif" class="login"/> --%>
<!--           			</div>End div_column_3 -->
<!--           			<div class="column_4"> -->
<!--             			<label class="password"><a href="#">Forgot <br /> -->
<!--             			password</a></label> -->
<!--           			</div>End div_column_4 -->
<!-- 					</fieldset> -->
<!--         		</form> -->
<!--       		</div>End div_login_box -->
<!--     	</div>End div_number_login -->
	</div><!-- End div_header-->
<div id="body_container">
	<div id="body_container_inner">
		<div id="menu">
	        <ul>
	          <li><a href="<%=request.getContextPath()%>/front-end/product/Shopindex.jsp">home</a></li> 
	          <li><a href="<%=request.getContextPath()%>/front-end/product/Shop.jsp">Product</a></li>
	          <li><a href="<%=request.getContextPath()%>/front-end/orders/listMyOrders.jsp">Orders</a></li>
	          <li><a class="current">Charge</a></li>
	          <li><a href="<%=request.getContextPath()%>/front-end/product/Cart.jsp">ShoppingCart</a></li>
	          <li><a href="<%=request.getContextPath()%>/front-end/product/shopQ&A.jsp">Q&A</a></li>
	        </ul>
		</div><!-- EndMenu -->
		<div class="banner"><a href="#">
			<img src="<%=request.getContextPath()%>/front-end/images/charge.jpg" /></a>
		</div><!-- End div_banner-->
		<div class="container_row">
        	<div class="welcomezone"><!-- 內容START-->
				<table width="820" style="border:3px #cdecff dashed;" cellpadding="10" >
					<tr>
						<th></th>
						<th></th>
						<th></th>
						<th></th>
					</tr>
					<tr>
						<td>
							<img src="<%=request.getContextPath()%>/front-end/images/1.jpg" width="auto" height="100">
						</td>
						<td>
							<img src="<%=request.getContextPath()%>/front-end/images/1.jpg" width="auto" height="100">
						</td>
						<td>
							<img src="<%=request.getContextPath()%>/front-end/images/1.jpg" width="auto" height="100">
						</td>
						<td>
							<img src="<%=request.getContextPath()%>/front-end/images/1.jpg" width="auto" height="100">
						</td>
					</tr>
					<tr>
						<td>
							<span style="font-family:Microsoft JhengHei;font-size:20px;">
								NT100
							</span>		
						</td>
						<td>
							<span style="font-family:Microsoft JhengHei;font-size:20px;">
								NT200
							</span>
						</td>
						<td>
							<span style="font-family:Microsoft JhengHei;font-size:20px;">
								NT500
							</span>
						</td>
						<td>
							<span style="font-family:Microsoft JhengHei;font-size:20px;">
								NT1000
							</span>
						</td>
					</tr>
					<tr>
						<td>
							<form method="post"	action="<%=request.getContextPath()%>/front-end/shopping/shopping.do" name="form1" id="form${memVO.MEM_BALANCE}">
								<input type="hidden" name="price" value="100">
								<input type="hidden" name="quantity" value="1">
								<input type="hidden" name="action" value="ADD">
								<input type="button" class="myButton" value="BUY" width="20px" onclick="calert(${product_no})">
							</form>
						</td>
						<td></td>
						<td></td>
						<td></td>
					</tr>
				</table>
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

</body>
</html>