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
<%-- <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/Cart.css"/> --%>
<link rel="stylesheet" href="<%=request.getContextPath()%>/front-end/css/layout.css"/>

<script src="<%=request.getContextPath()%>/resources/js/jquery.min.js"></script>
</head>
</head>
<body>
<div id="layout">
  <div id="header">
    <div id="logo"><a href="#"><img src="<%=request.getContextPath()%>/front-end/images/logo_2.gif" alt="" /></a>
	</div><!-- End div_logo-->
    <div class="member_login">
      <div class="login_box">
        <form action="" method="get">
          <fieldset>
          <div class="column_1">
            <label>username :</label>
            <label>password :</label>
          </div><!-- End div_column_1-->
          <div class="column_2">
            <input type="text" name="" value="" />
            <input type="text" name="" value="" />
          </div><!-- End div_column_2-->
          <div class="column_3">
            <input type="image" src="<%=request.getContextPath()%>/front-end/images/login_btn.gif" class="login"/>
          </div><!-- End div_column_3-->
          <div class="column_4">
            <label class="password"><a href="#">Forgot <br />
            password</a></label>
          </div>
          </fieldset>
        </form>
      </div><!-- End div_login_box-->
    </div><!-- End div_number_login-->
  </div><!-- End div_header-->
  <div id="body_container">
    <div id="body_container_inner">
      <div id="menu">
        <ul>
          <li class="first"><a href="index.html">home</a></li>
          <li><a href="<%=request.getContextPath()%>/front-end/product/Shop.jsp">Product</a></li>
          <li><a href="#">Orders</a></li>
          <li><a href="#">Charge</a></li>
          <li><a class="current">ShoppingCart</a></li>
          <li><a href="#">Q&A</a></li>
        </ul>
      </div>
      <div class="banner"><a href="#">
		  <img src="<%=request.getContextPath()%>/front-end/images/banner_Ani.gif" /></a>
		</div><!-- End div_banner-->
<!--
      <div class="find_more">
        <p>Shop.jsp<br />
          <span></span></p>
      </div> End div_find_more
-->
      <div class="container_row">
        <div class="welcomezone"><!-- 內容START-->
			<div class="cart">
		<div class="container">
			<div class="cart-items">
				<% if(buylist==null || buylist.size()==0){ %>
                <br><br><br><h1>目前購物車是空的</h1>
				<% }else{%>
					<h2 align="left">我的購物車</h2>
					<form method="post" action="<%=request.getContextPath()%>/front-end/shopping/shopping.do" id="checkout" name="checkout">
                 	    <c:forEach var="cartVO" items="${shoppingcart}" varStatus="s">
					       <div class="cart-header"> 
								    <button type="button" id="${cartVO.product_no}" class="close1">X</button>
						     <div class="cart-sec">
							    <div class="cart-item">

									
									<c:forEach var="CartVO" items="${ShoppingSvc.all}">
										<c:if test="${productVO.product_no==cartVO.product_no}">【${productVO.product_picture_small}】
										</c:if>
									</c:forEach>
			
									
									
							    <div class="cart-item-info">
								    <h3>${cartVO.product_name}<span>Model No: ${cartVO.product_no}</span></h3>
								    <h4><span>$ </span>${cartVO.product_price}</h4>
								    <p class="qty">數量 :</p>
								       <input min="1" max="10" type="number" id="quantity" name="quantity${cartVO.product_no}" value="${cartVO.quantity}" class="form-control" >
							    </div>
							 
							    <div class="delivery">
								    <span>需要2-3個工作天</span>
								    <div class="clearfix"></div>
							    </div>
						     </div>
					       </div>
					       </div>
                       </c:forEach>
                       <input type="hidden" name="action" value="CHECKOUT">
                       <input type="submit" value="結帳去" class="checkout">
                    </form>
                            
                    <c:forEach var="cartVO" items="${shoppingcart}" varStatus="s">
                         <form method="post" action="<%=request.getContextPath()%>/front-end/shopping/shopping.do" id="a${cartVO.product_no}">
							<input type="hidden" name="del" value="${s.index}">
							<input type="hidden" name="action" value="DELETE">
						 </form>
					</c:forEach>
                  <%}%>
				</div>
		</div>
	</div>

      </div>
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