<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.product.model.*"%>
<%
	ProductVO productVO = (ProductVO) request.getAttribute("productVO");
%>

<html>
<head>
<title>ADD_Product</title>
<style>
	input[type=text], select {
	    width: 100%;
	    padding: 12px 20px;
	    margin: 8px 0;
	    display: inline-block;
	    border: 1px solid #ccc;
	    border-radius: 4px;
	    box-sizing: border-box;
	}
	input[type=number], select {
	    width: 100%;
	    padding: 12px 20px;
	    margin: 8px 0;
	    display: inline-block;
	    border: 1px solid #ccc;
	    border-radius: 4px;
	    box-sizing: border-box;
	}
	input[type=button] {
	    width: 100%;
	    background-color: #4c94c1;
	    color: white;
	    padding: 14px 20px;
	    margin: 8px 0;
	    border: none;
	    border-radius: 4px;
	    cursor: pointer;
	}
	input[type=button]:hover {
	    background-color: #194f80;
	}
	#add_box{
		border:5px solid #f1feff;
		background-color: #fff;
		opacity:0.8;
		width: 800px;
		height: 1000px;
		border-radius:50px;
 		 margin: 50px 200px 0px 500px;	
  	}
  	.button {
	    background-color: #F9C900; 
	    border: none;
	    color: white;
	    padding: 16px 32px;
	    text-align: center;
	    text-decoration: none;
	    display: inline-block;
	    font-size: 12px;
	    margin: 4px 2px;
	    -webkit-transition-duration: 0.4s; 
	    transition-duration: 0.4s;
	    cursor: pointer;
	    border-radius: 10px;
	}
	.button {
	    background-color: white; 
	    color: black; 
	    border: 2px solid #F9C900;
	}
	
	.button:hover {
	    background-color: #fdf4cc;
	    color: black;
	}
</style>

</head>
<link rel="stylesheet" type="text/css" href="js/calendar.css">
<script language="JavaScript" src="js/calendarcode.js"></script>
<script src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
<div id="popupcalendar" class="text"></div>
<body background="<%=request.getContextPath() %>/back-end/images/bgp.jpg">
<div id="add_box" align="center">
<h1 style="color:#000000 ;font-family:Microsoft JhengHei;">新增商品</h1>
	<%-- 錯誤表列 --%>
	<c:if test="${not empty errorMsgs}">
		<font color='red'>請修正以下錯誤:
			<ul>
				<c:forEach var="message" items="${errorMsgs}">
					<li>${message}</li>
				</c:forEach>
			</ul>
		</font>
	</c:if>
	<FORM METHOD="post" ACTION="product.do" name="addProd">
		<table border="0">
			<tr>
				<!-- 商品名稱 -->
				<td>商品名稱：</td>
				<td><input type="TEXT" name="product_name" size="45"
					value="<%=(productVO == null) ? "" : productVO.getProduct_name()%>" />
				</td>
			</tr>
			<tr>
				<!-- 商品簡介 -->
				<td>商品簡介：</td>
				<td><input type="TEXT" name="product_introduction" size="45"
					value="<%=(productVO == null) ? "" : productVO.getProduct_introduction()%>" />
				</td>
			</tr>
			<tr>
				<!-- 商品價格 -->
				<td>商品價格：</td>
				<td><input type="TEXT" name="product_price" size="45"
					value="<%=(productVO == null) ? "" : productVO.getProduct_price()%>" />
				</td>
			</tr>
			<tr>
				<!-- 商品庫存量 -->
				<td>商品庫存量：</td>
				<td><input type="TEXT" name="product_stock" size="45"
					value="<%=(productVO == null) ? "" : productVO.getProduct_stock()%>" />
				</td>
			</tr>
			<tr>
				<!-- 商品圖片 -->
<!-- 				<td>商品大圖:</td> -->
				<td><input type="hidden" name="pic_big" size="36" id="pic_big" />
				<input type="hidden"  name="product_picture_large" id="product_picture_large" /></td>
				<td><img id="imgB"></td>
			</tr>
			<tr>
				<!-- 縮圖 -->
				<td>商品小圖:</td>
				<td><input type="file" name="pic_small" size="36" id="pic_small" />
				<input type="hidden" name="product_picture_small" id="product_picture_small" /></td>
				<td><img id="imgS"></td>
			</tr>
<!-- 			<tr> -->
<!-- 				商品上下架狀態 -->
<!-- 				<td>商品上下架狀態：</td> -->
<!-- 				<td><input type="TEXT" name="product_status" size="45" -->
<%-- 					value="<%=(productVO == null) ? "1" : productVO.getProduct_status()%>" /> --%>
<!-- 				</td> -->
<!-- 			</tr> -->
			<tr>
				
				<td>
					<input type="hidden" name="product_status" value="1"/>	
				</td>
			</tr>
<!-- 			<tr> -->
<!-- 				上下架狀態-----待研究 -->
<!-- 				<td>商品上下架狀態：</td> -->
<!-- 				<td><select name="product_status"> -->
<!-- 						<option value="1">1</option> -->
<!-- 						<option value="2">2</option> -->

<!-- 				</select> -->
<!-- 			</tr> -->
			<tr>
				<%
					java.sql.Date date_SQL = new java.sql.Date(System.currentTimeMillis());
				%>
				<!-- 建立日期 -->
				<td>商品建立日期：</td>
				<td><input class="cal-TextBox"
					onFocus="this.blur()" size="9" readonly type="text"
					name="product_create_date"
					value="<%=(productVO == null) ? date_SQL : productVO.getProduct_create_date()%>">
<!-- 					<a class="so-BtnLink" href="javascript:calClick();return false;" -->
<!-- 					onmouseover="calSwapImg('BTN_date', 'img_Date_OVER',true);" -->
<!-- 					onmouseout="calSwapImg('BTN_date', 'img_Date_UP',true);" -->
<!-- 					onclick="calSwapImg('BTN_date', 'img_Date_DOWN');showCalendar('form1','product_create_date','BTN_date');return false;"> -->
<!-- 						<img align="middle" border="0" name="BTN_date" -->
<!-- 						src="images/btn_date_up.gif" width="22" height="17" alt="開始日期"> -->
<!-- 				</a> -->
				</td>
			</tr>
			<tr>
				<!-- 商品資訊 -->
				<td>商品資訊：</td>
				<td><input type="TEXT" name="product_info" size="45"
					value="<%= (productVO==null)? "": productVO.getProduct_info()%>" /></td>
			</tr>
			
			<jsp:useBean id="product_kindSvc" scope="page" class="com.product_kind.model.Product_kindService" />
			<tr>
				<!-- 商品類別 -->
				<td>商品類別</td>
				<td><select size="1" name="product_kind_no">
					<c:forEach var="product_kindVO" items="${product_kindSvc.all}">
						<option value="${product_kindVO.product_kind_no}"
								${(productVO.product_kind_no==product_kindVO.product_kind_no)? 'selected':'' }>${product_kindVO.product_kind_name}
					</c:forEach>
				</select>
				</td>
			</tr>
		</table>
		<input type="hidden" name="action" value="insert">
		<button class="button" style="font-size:24px; font-family:微軟正黑體;">Insert</button>
		<img src="<%=request.getContextPath()%>/back-end/images/dog.png" width="20" onClick="magical()">
	</FORM>
</div><!-- End_Div add_box -->

</body>
</html>
<script>
	$("#pic_big").change(function() {
		readImage1(this);
	});

	function readImage1(input) {
		if (input.files && input.files[0]) {
			var picFile = new FileReader();
			picFile.onload = function(e) {
				var pic = e.target.result; //string
// 				alert(pic);
				$("#imgB").attr("src", pic);
				$("#product_picture_large").attr("value", pic);
// 				alert($("#product_picture_large").val());
			};
			picFile.readAsDataURL(input.files[0]); //base64 file tranfer to string
		}
	}

	$("#pic_small").change(function() {
		readImage(this);
	});

	function readImage(input) {
		if (input.files && input.files[0]) {
			var picFile = new FileReader();
			picFile.onload = function(e) {
				var pic = e.target.result; //string
// 				alert(pic);
				$("#imgS").attr("src", pic);
				$("#product_picture_small").attr("value", pic);
// 				alert($("#product_picture_small").val());
			};
			picFile.readAsDataURL(input.files[0]); //base64 file tranfer to string
		}
	}
</script>
<script>
	function magical(){
		addProd.product_name.value="狗飼料";
		addProd.product_introduction.value="嚴選鮮嫩豬肉製成";
		addProd.product_price.value="600";
		addProd.product_stock.value="9";
		addProd.product_info.value="狗食";
		addProd.product_kind_no.value="11300001";
	}
</script>