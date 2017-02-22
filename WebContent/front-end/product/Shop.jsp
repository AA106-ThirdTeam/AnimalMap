<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.product.model.*"%>
<%@ page import="com.shopping.model.*"%>

<%
	ProductService productSvc = new ProductService();
	List<ProductVO> productList = productSvc.getAll();
	pageContext.setAttribute("productList",productList);
%>
<%
	CartVO cartVO = (CartVO) request.getAttribute("cartVO");
%>
<!DOCTYPE html>
<html>
<head>
<title>Shop.jsp</title>
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<%-- <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/Shop.css"/> --%>
<link rel="stylesheet" href="<%=request.getContextPath()%>/front-end/css/layout.css"/>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/sweetalert.css"/>
																	<!-- 加入購物車↑ -->
<script src="<%=request.getContextPath()%>/resources/js/sweetalert.min.js"></script>
<style type="text/css" media="screen">

</style>
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
          <li><a class="current">Product</a></li>
          <li><a href="#">Orders</a></li>
          <li><a href="#">Charge</a></li>
          <li><a href="<%=request.getContextPath()%>/front-end/product/Cart.jsp">ShoppingCart</a></li>
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
        <table>
			<c:forEach var="productVO" items="${productList}">
	<div class="part-sec"><br><br>
		    <div class="product-default">
<%--                 <jsp:useBean id="product_kindSvc" scope="page" class="com.product_kind.model.Product_kindService" /> --%>
<%-- 			    <c:forEach var="product_kindVO" items="${product_kindSvc.all}"> --%>
<%--                     <c:if test="${productVO.product_kind_no==product_kindVO.product_kind_no}"> --%>
<%-- 	                    <b>${product_kindVO.product_kind_name}</b> --%>
<%--                     </c:if> --%>
<%--                 </c:forEach> --%>
                <img src="${productVO.product_picture_small}" width="auto" height="100">
			<div><b>${productVO.product_name}</b></div>
			<div>NT$${productVO.product_price}</div>
			
			<form method="post"	action="<%=request.getContextPath()%>/front-end/shopping/shopping.do" name="form1" id="form${productVO.product_no}">
				<input type="hidden" name="product_no" value="${productVO.product_no}">
                <input type="hidden" name="product_name" value="${productVO.product_name}">
                <input type="hidden" name="product_price" value="${productVO.product_price}">
<%-- 				<input type="hidden" name="product_kind_no" value="${productVO.product_kind_no}"> --%>
                <input type="hidden" name="quantity" value="1">
				<input type="hidden" name="action" value="ADD">
				
				
				
<!-- 待研究 -->
<!-- 				<select> -->
<%-- 				<option value="<%=(cartVO == null) ? "1" : cartVO.getQuantity()%>">1</option> --%>
<%-- 				<option value="<%=(cartVO == null) ? "2" : cartVO.getQuantity()%>">2</option> --%>
<!-- 				</select> -->

                <input type="button" class="myButton" value="BUY" width="20px" onclick="calert(${productVO.product_no})">
			</form>
			</div>
		</div>
	</c:forEach>
	</table>
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
</body>
</html>
<script>
   var formId = '';
   function calert(n) {
	  formId = 'form'+n;
	  swal({   title: "已成功加入購物車",   type:"success",   timer: 1500,   showConfirmButton: false });
	  setTimeout("submitForm()", 1600); 
   }
   function submitForm() { 
	 document.getElementById(formId).submit()
   }
</script>
