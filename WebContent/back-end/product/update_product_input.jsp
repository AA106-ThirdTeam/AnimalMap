<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.product.model.*"%>
<%
	ProductVO productVO = (ProductVO) request.getAttribute("productVO"); //ProductServlet.java (Concroller), 存入req的productVO物件 (包括幫忙取出的productVO, 也包括輸入資料錯誤時的productVO物件)
%>
<html>
<head>
<title>資料修改 - update_product_input.jsp</title>
<link rel="stylesheet" type="text/css" href="js/calendar.css">
<script language="JavaScript" src="js/calendarcode.js"></script>
<script src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
<div id="popupcalendar" class="text"></div>
</head>
<body>
	<h1>update_product_input.jsp</h1>
	<table border='1' cellpadding='5' cellspacing='0' width='400'>
		<tr bgcolor='#ccffff' align='center' valign='middle' height='20'>
			<td>
				<h3>資料修改 - update_product_input.jsp</h3> <a
				href="<%=request.getContextPath()%>/back-end/select_page.jsp"> <img
					src="images/back1.gif">回首頁
			</a>
		</tr>
	</table>

	<h3>資料修改：</h3>
	<%--錯誤表列 --%>
	<c:if test="${not empty errorMsgs}">
		<font color='red'>請修正以下錯誤：
			<ul>
				<c:forEach var="messages" items="${errorMsgs}">
					<li>${message}</li>
				</c:forEach>
			</ul>
		</font>
	</c:if>

	<FORM METHOD="post" ACTION="product.do" name="form1">
		<table border="0">
			<tr>	<!-- 商品編號 -->
				<td>商品編號：<font color=red><b>*</b></font></td>
				<td><%=productVO.getProduct_no()%></td>
			</tr>
			<tr>	<!-- 商品名稱 -->
				<td>商品名稱：</td>
				<td><input type="TEXT" name="product_name" size="45"
					value="<%=productVO.getProduct_name()%>" /></td>
			</tr>
			<tr>	<!-- 商品簡介 -->
				<td>商品簡介：</td>
				<td><input type="TEXT" name="product_introduction" size="45"
					value="<%=productVO.getProduct_introduction()%>" /></td>
			</tr>
			<tr>	<!-- 商品價格 -->
				<td>商品價格：</td>
				<td><input type="TEXT" name="product_price" size="45"
					value="<%=productVO.getProduct_price()%>" /></td>
			</tr>
			<tr>	<!-- 商品庫存量 -->
				<td>商品庫存量：</td>
				<td><input type="TEXT" name="product_stock" size="45"
					value="<%=productVO.getProduct_stock()%>" /></td>
			</tr>
			<tr>	<!-- 圖 -->
				<td>商品大圖:</td>
				<td><input type="file" name="pic_big" size="36" id="pic_big" />
				</a><input type="hidden" name="product_picture_large" id="product_picture_large" value="<%=productVO.getProduct_picture_large()%>" /></td>
				<td><img id="imgB" src="<%=productVO.getProduct_picture_large()%>"></td>
			</tr>
			<tr>
				<!-- 縮圖 -->
				<td>商品小圖:</td>
				<td><input type="file" name="pic_small" size="36" id="pic_small" />
				<input type="hidden" name="product_picture_small" id="product_picture_small" value="<%=productVO.getProduct_picture_small()%>" /></td>
				<td><img id="imgS" src="<%=productVO.getProduct_picture_small()%>"></td>
			</tr>
			<tr>
				<!-- 上下架狀態 -->
				<td>商品上下架狀態：</td>
				<td><input type="TEXT" name="product_status" size="45"
					value="<%=productVO.getProduct_status()%>" /></td>
			</tr>
			<tr>
				<!-- 建立日期 -->
				<td>商品建立日期：</td>
				<td bgcolor="#ccccff"><input class="cal-TextBox"
					onFocus="this.blur()" size="9" readonly type="text"
					name="product_create_date"
					value="<%=productVO.getProduct_create_date()%>"> <a
					class="so-BtnLink" href="javascript:calClick();return false;"
					onmouseover="calSwapImg('BTN_date', 'img_Date_OVER',true);"
					onmouseout="calSwapImg('BTN_date', 'img_Date_UP',true);"
					onclick="calSwapImg('BTN_date', 'img_Date_DOWN');showCalendar('form1','product_create_date','BTN_date');return false;">
						<img align="middle" border="0" name="BTN_date"
						src="images/btn_date_up.gif" width="22" height="17" alt="開始日期">
				</a></td>
			</tr>
			<tr>
				<!-- 商品資訊 -->
				<td>商品資訊：</td>
				<td><input type="TEXT" name="product_info" size="45"
					value="<%=productVO.getProduct_info()%>" /></td>
			</tr>

			<jsp:useBean id="product_kindSvc" scope="page"
				class="com.product_kind.model.Product_kindService" />
			<tr>
				<!-- 商品類別 -->
				<td>商品類別：<font color=red><b>*</b></font></td>
				<td><select size="1" name="product_kind_no">
						<c:forEach var="product_kindVO" items="${product_kindSvc.all}">
							<option value="${product_kindVO.product_kind_no}"
								${(productVO.product_kind_no==product_kindVO.product_kind_no)? 'selected':'' }>${product_kindVO.product_kind_name}
						</c:forEach>
				</select></td>
			</tr>
		</table>
		<input type="hidden" name="action" value="update">
		<input type="hidden" name="product_no"	value="<%=productVO.getProduct_no()%>">
		<input type="hidden" name="requestURL" value="<%=request.getParameter("requestURL")%>">	<!--接收原送出修改的來源網頁路徑後,再送給Controller準備轉交之用-->
		<input type="hidden" name="whichPage" value="<%=request.getParameter("whichPage")%>"><!--用於:istAllEmp.jsp 與 複合查詢 listEmps_ByCompositeQuery.jsp-->
		<input type="submit" value="送出修改">
	</FORM>

	<br>送出修改的來源網頁路徑:
	<br>
	<b> <font color=blue>request.getParameter("requestURL"):</font> <%=request.getParameter("requestURL")%><br>
		<font color=blue>request.getParameter("whichPage"):</font> <%=request.getParameter("whichPage")%>
		(此範例目前用於:istAllProduct.jsp 與 複合查詢 listProducts_ByCompositeQuery.jsp)
	</b>
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
				alert(pic);
				$("#imgB").attr("src", pic);
				$("#product_picture_large").attr("value", pic);
				alert($("#product_picture_large").val());
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
				alert(pic);
				$("#imgS").attr("src", pic);
				$("#product_picture_small").attr("value", pic);
				alert($("#product_picture_small").val());
			};
			picFile.readAsDataURL(input.files[0]); //base64 file tranfer to string
		}
	}
</script>