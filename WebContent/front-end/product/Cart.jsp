<%@ page contentType="text/html; charset=BIG5" pageEncoding="BIG5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@page import="com.shopping.model.CartVO"%>
<%@page import="com.product.model.*"%>
<%
	Vector<CartVO> buylist = (Vector<CartVO>) session.getAttribute("shoppingcart");
%>
<!doctype html>
<html>
<head>
<title>Cart.jsp</title>
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<link rel="stylesheet" href="<%=request.getContextPath()%>/front-end/css/layout.css"/>
<script src="<%=request.getContextPath()%>/front-end/js/jquery.min.js"></script>
<style>
	.button {
	    background-color: #4CAF50; /* Green */
	    border: none;
	    color: white;
	    padding: 16px 32px;
	    text-align: center;
	    text-decoration: none;
	    display: inline-block;
	    font-size: 16px;
	    margin: 4px 2px;
	    -webkit-transition-duration: 0.4s; /* Safari */
	    transition-duration: 0.4s;
	    cursor: pointer;
	    border-radius: 10px;
	}
	
	
	.button {
	    background-color: white; 
	    color: black; 
	    border: 2px solid #008CBA;
	}
	
	.button:hover {
	    background-color: #008CBA;
	    color: white;
	}
</style>
</head>
</head>
<body>
<div id="layout">
	<div id="header">
	<div id="logo"><a href="<%=request.getContextPath() %>/front-end/homepage/index.jsp"><img src="<%=request.getContextPath()%>/front-end/images/1.png" alt="" /></a>
	</div><!-- End div_logo-->
<!--     	<div class="member_login"> -->
<!-- 			<div class="login_box"> -->
<!-- 				<form action="" method="get"> -->
<!-- 				<fieldset> -->
<!-- 		          <div class="column_1"> -->
<!-- 					<label>username :</label> -->
<!-- 		            <label>password :</label> -->
<!-- 		          </div>End div_column_1 -->
<!-- 		          <div class="column_2"> -->
<!-- 		            <input type="text" name="" value="" /> -->
<!-- 		            <input type="text" name="" value="" /> -->
<!-- 		          </div>End div_column_2 -->
<!-- 		          <div class="column_3"> -->
<%-- 		            <input type="image" src="<%=request.getContextPath()%>/front-end/images/login_btn.gif" class="login"/> --%>
<!-- 		          </div>End div_column_3 -->
<!-- 		          <div class="column_4"> -->
<!-- 		            <label class="password"><a href="#">Forgot <br /> -->
<!-- 		            password</a></label> -->
<!-- 		          </div> -->
<!-- 	          	</fieldset> -->
<!-- 	        	</form> -->
<!--       		</div>End div_login_box -->
<!-- 		</div>End div_number_login -->
  </div><!-- End div_header-->
<div id="body_container">
	<div id="body_container_inner">
		<div id="menu">
	        <ul>
				<li class="first"><a href="<%=request.getContextPath()%>/front-end/product/Shopindex.jsp">home</a></li>
				<li><a href="<%=request.getContextPath()%>/front-end/product/Shop.jsp">Product</a></li>
				<li><a href="<%=request.getContextPath()%>/front-end/orders/listMyOrders.jsp">Orders</a></li>
				<li><a href="<%=request.getContextPath()%>/front-end/charge/Charge.jsp">Charge</a></li>
				<li><a class="current">ShoppingCart</a></li>
				<li><a href="<%=request.getContextPath()%>/front-end/product/shopQ&A.jsp">Q&A</a></li>
	        </ul>
		</div><!-- End div_menu -->
		<div class="banner"><a href="#">
			<img src="<%=request.getContextPath()%>/front-end/images/banner_cart.jpg" /></a>
		</div><!-- End div_banner-->
      	<div class="container_row">
        	<div class="welcomezone"><!-- 內容START-->
				<div class="cart">
					<div class="container">
						<div class="cart-items">
						<% if(buylist==null || buylist.size()==0){ %>
		                <br><br><br>
		                <div align="center">
						<img src="<%=request.getContextPath()%>/front-end/images/cart_img.jpg"/></a>
						<h1>目前購物車是空的喔!趕快去購物吧!!!</h1>
						</div>
						<% }else{%>
							<h1 align="left">購物車</h1>
							<table width="820" style="border:3px #cdecff dashed;" cellpadding="10" >
								<tr>
								<td colspan="5" align="center">購物清單</td>
								</tr>
								<tr>
									<td>商品編號</td>
									<td>商品名稱</td>
									<td>價格</td>
									<td>數量</td>
									<td>刪除</td>
								</tr>
								<form method="post" action="<%=request.getContextPath()%>/front-end/shopping/shopping.do" id="checkout" name="checkout">
								<c:forEach var="cartVO" items="${shoppingcart}" varStatus="s">
                 	    		<tr>			     
								    <td><h3><span>${cartVO.product_no}</span></h3></td><!-- 商品編號 -->
								    <td><h3>${cartVO.product_name}</h3></td><!-- 商品名稱 -->
								    <td><h4><span>$ </span>${cartVO.product_price}</h4></td><!-- 商品價格 -->
								    <td><input min="1" max="10" type="number" id="quantity" name="quantity${cartVO.product_no}" value="${cartVO.quantity}" class="form-control" ></td><!-- 商品數量 -->
								    <td><button type="button" id="${cartVO.product_no}" class="close1">X</button></td><!-- 刪除 -->
								</tr>
								</c:forEach>
								</table>
								   <input type="hidden" name="action" value="CHECKOUT">
			                       <button class="button" "checkout" style="font-size:24px; font-family:微軟正黑體;">結帳</button>
								</form>                 
			                    <c:forEach var="cartVO" items="${shoppingcart}" varStatus="s">
			                         <form method="post" action="<%=request.getContextPath()%>/front-end/shopping/shopping.do" id="a${cartVO.product_no}">
										<input type="hidden" name="del" value="${s.index}">
										<input type="hidden" name="action" value="DELETE">
									 </form>
								</c:forEach>
             			<%}%>
						</div><!-- End div_cart-items -->
					</div><!-- End div_container -->
				</div><!-- End div cart -->
			</div><!-- End div_welcomezone -->
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
<script type="text/javascript">
	$(function(){
		<c:forEach var="cartVO" items="${shoppingcart}" varStatus="s">
		$("#${cartVO.product_no}").click(function() {
			$("#a${cartVO.product_no}").submit();
		});
		</c:forEach>
	})
</script>	
</body>
</html>