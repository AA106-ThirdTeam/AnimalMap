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
	int cartCount = 0; //購物車有多少東西
	//判斷session裡面有無購物車
	if (session.getAttribute("shoppingcart") != null) {
	 Vector<CartVO> buylist = (Vector<CartVO>) session.getAttribute("shoppingcart");
	 cartCount=buylist.size();
	}
%>
<!DOCTYPE html>
<html>
<head>
<title>Shop.jsp</title>
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<%-- <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/Shop.css"/> --%>
<link rel="stylesheet" href="<%=request.getContextPath()%>/front-end/css/layout.css"/>
<link rel="stylesheet" href="<%=request.getContextPath()%>/front-end/css/sweetalert.css"/>
																	<!-- 加入購物車↑ -->
<script src="<%=request.getContextPath()%>/front-end/js/sweetalert.min.js"></script>
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
	.myButton {
	    background-color: white; 
	    color: black; 
	    border: 2px solid #4CAF50;
	}
	.myButton:hover {
	    background-color: #4CAF50;
	    color: white;
	}
	
</style>
	
</head>
<body>
<div id="layout">
	<div id="header">
		<div id="logo"><a href="<%=request.getContextPath() %>/front-end/homepage/index.jsp"><img src="<%=request.getContextPath()%>/front-end/images/1.png" alt="" /></a>
		</div><!-- End div_logo-->
		<div class="cart">
			<div class="cart_box">
				
			</div><!--End div_login_box -->
		</div><!--End div_number_login -->
	</div><!-- End div_header-->
<div id="body_container">
	<div id="body_container_inner">
		<div id="menu">
			<ul>
				<li class="first"><a href="<%=request.getContextPath()%>/front-end/product/Shopindex.jsp">home</a></li>
				<li><a class="current">Product</a></li>
				<li><a href="<%=request.getContextPath()%>/front-end/orders/listMyOrders.jsp">Orders</a></li>
	          	<li><a href="<%=request.getContextPath()%>/front-end/charge/Charge.jsp">Charge</a></li>
				<li><a href="<%=request.getContextPath()%>/front-end/product/Cart.jsp">ShoppingCart</a></li>
				<li><a href="<%=request.getContextPath()%>/front-end/product/shopQ&A.jsp">Q&A</a></li>
			</ul>
		</div><!-- End_menu -->
 		<div class="banner"><a href="#">
			<img src="<%=request.getContextPath()%>/front-end/images/banner2.jpg" /></a>
		</div><!-- End div_banner-->
		<div class="container_row">
			<div class="welcomezone"><!-- 內容START-->
				<!-- 浮動購物車 開始 -->
					   <div id="tomeet" style="position:absolute; width:50px; height:80px; z-index:20; visibility:visible">
					    <div style="width:50px; height:50px;">
					     <a href="<%=request.getContextPath()%>/front-end/product/Cart.jsp">
					      <span id="cart-Count" style="position:absolute; width:20px; height:70px; z-index:26; top:7px; left:28px; color:#ffa700 ;font-size:large;"><%=cartCount %></span>
					<!--       <span id="cart-Count" style="position:absolute; width:20px; height:70px; z-index:25; top:2px; left:23px; color:#FFF;">0</span> -->
					      <span id="cart-Count" style="position:absolute; width:25px; height:70px; z-index:24; top:1px; left:15px">
					       <img src="<%=request.getContextPath()%>/front-end/images/circle.png" width="35">
					      </span>
					      <span style="width:70px; height:70px; z-index:23;">
					<!--        <img src="images/shopping-cart.png" width="40px"> -->
					       <img src="<%=request.getContextPath()%>/front-end/images/cart.png" width="60px" height="60px">
					      </span>      
					     </a>
					    </div>
					   </div><br><br><br><br><br><br>
  				<!-- 浮動購物車 結束 -->
				<table width="820" style="border:3px #cdecff dashed;" cellpadding="10" >
	        		<tr>
	        			<th><span style="font-family:DFKai-sb;font-size:16px;">商品圖片</span></th>
	        			<th><span style="font-family:DFKai-sb;font-size:16px;">商品名稱</span></th>
	        			<th><span style="font-family:DFKai-sb;font-size:16px;">商品價格</span></th>
	        			<th><span style="font-family:DFKai-sb;font-size:16px;">商品資訊</span></th>
	        			<th><span style="font-family:DFKai-sb;font-size:16px;">選購</span></th>
	        		</tr>
	        		<c:forEach var="productVO" items="${productList}">
	        		<tr>
	        			
	        			<td><!-- 商品圖片 -->
	        				<span style="font-family:Microsoft JhengHei;font-size:14px;">
	        					<img src="${productVO.product_picture_small}" width="auto" height="100">
	        				</span>
	        			</td>
	           			<td><!-- 商品名稱 -->
	        				<span style="font-family:Microsoft JhengHei;font-size:14px;">
	           					<b>${productVO.product_name}</b>
	        				</span>
	        			</td>
	        			<td><!-- 商品價格 -->
	        				<span style="font-family:Microsoft JhengHei;font-size:14px;">
								NT$${productVO.product_price}
	        				</span>
	        			</td><!-- 商品資訊 -->
	        			<td>
	        				<span style="font-family:Microsoft JhengHei;font-size:14px;">       			
	        					${productVO.product_info}
	        				</span>
	        			</td>
						<td>
							<form method="post"	action="<%=request.getContextPath()%>/front-end/shopping/shopping.do" name="form1" id="form${productVO.product_no}">
								<input type="hidden" name="product_no" value="${productVO.product_no}">
								<input type="hidden" name="product_name" value="${productVO.product_name}">
								<input type="hidden" name="product_price" value="${productVO.product_price}">
								<input type="hidden" name="quantity" value="1">
								<input type="hidden" name="action" value="ADD">
								<input type="button" class="myButton" value="BUY" width="20px" onclick="calert(${productVO.product_no})">
							</form>
						</td>
					</tr>
					
					</c:forEach>
	        	</table>
	        	
      		</div>
		<div id="footer">
			<div class="footer_link">
			<ul style="color:#FFf;">
				©2017_AnimalMap
			</ul>
			</div><!-- End div_footer_link-->
		</div><!-- End div_footer-->
	</div><!-- End div_container_row-->
  	</div><!-- End div_body_container_inner-->
</div><!-- End div_body_container-->
</div><!-- End layout-->

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
