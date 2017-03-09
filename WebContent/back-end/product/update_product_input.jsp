<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.product.model.*"%>
<%
	ProductVO productVO = (ProductVO) request.getAttribute("productVO"); //ProductServlet.java (Concroller), �s�Jreq��productVO���� (�]�A�������X��productVO, �]�]�A��J��ƿ��~�ɪ�productVO����)
%>
<html>
<head>
<title>��ƭק� - update_product_input.jsp</title>
<link rel="stylesheet" type="text/css" href="js/calendar.css">
<script language="JavaScript" src="js/calendarcode.js"></script>
<script src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
<div id="popupcalendar" class="text"></div>
<style>
	input[type=text], select {
	    width: 80%;
	    padding: 12px 20px;
	    margin: 8px 0;
	    display: inline-block;
	    border: 1px solid #ccc;
	    border-radius: 4px;
	    box-sizing: border-box;
	}
	input[type=number], select {
	    width:	235px;
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
		width: 1000px;
		height: 1000px;
		border-radius:50px;
  margin: 100px 100px 0px 400px;	
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

<body background="<%=request.getContextPath() %>/back-end/images/bgp.jpg">
<div id="add_box" align="center">
	<h1 style="color:#000000 ;font-family:Microsoft JhengHei;">�ק�ӫ~</h1>
	<%--���~��C --%>
	<c:if test="${not empty errorMsgs}">
		<font color='red'>�Эץ��H�U���~�G
			<ul>
				<c:forEach var="messages" items="${errorMsgs}">
					<li>${message}</li>
				</c:forEach>
			</ul>
		</font>
	</c:if>

	<FORM METHOD="post" ACTION="product.do" name="form1">
		<table border="0">
			<br/>
			<tr>	<!-- �ӫ~�s�� -->
				<td>�ӫ~�s���G</td>
				<td><%=productVO.getProduct_no()%></td>
			</tr>
			<tr>	<!-- �ӫ~�W�� -->
				<td>�ӫ~�W�١G</td>
				<td><input type="TEXT" name="product_name" size="45"
					value="<%=productVO.getProduct_name()%>" /></td>
			</tr>
			<tr>	<!-- �ӫ~²�� -->
				<td>�ӫ~²���G</td>
				<td><input type="TEXT" name="product_introduction" size="45"
					value="<%=productVO.getProduct_introduction()%>" /></td>
			</tr>
			<tr>	<!-- �ӫ~���� -->
				<td>�ӫ~����G</td>
				
				<td>NT &nbsp &nbsp<input type="number" name="product_price" size="45"
					value="<%=productVO.getProduct_price()%>" /> &nbsp &nbsp��</td>
				
			</tr>
			<tr>	<!-- �ӫ~�w�s�q -->
				<td>�ӫ~�w�s�q�G</td>
				<td> &nbsp &nbsp &nbsp &nbsp &nbsp<input type="number" name="product_stock" size="45"
					value="<%=productVO.getProduct_stock()%>" /> &nbsp &nbsp��</td>
			</tr>
			<tr>	<!-- �� -->
				<td><input type="hidden" name="pic_big" size="36" id="pic_big" />
				</a><input type="hidden" name="product_picture_large" id="product_picture_large" value="<%=productVO.getProduct_picture_large()%>" /></td>
<%-- 				<td><img id="imgB" src="<%=productVO.getProduct_picture_large()%>"></td> --%>
			</tr>
			<tr>
				<!-- �Y�� -->
				<td>�ӫ~�p��:</td>
				<td><input type="file" name="pic_small" size="36" id="pic_small" />
				<input type="hidden" name="product_picture_small" id="product_picture_small" value="<%=productVO.getProduct_picture_small()%>" /></td>
				<td><img id="imgS" src="<%=productVO.getProduct_picture_small()%>"></td>
			</tr>
			<tr>
				<!-- �W�U�[���A -->
<!-- 				<td>�ӫ~�W�U�[���A�G</td> -->
				<td><input type="hidden" name="product_status" size="45"
					value="1" /></td>
			</tr>
			<tr>
				<!-- �إߤ�� -->
				<td>�ӫ~�إߤ���G</td>
				<td><input class="cal-TextBox"
					onFocus="this.blur()" size="9" readonly type="text"
					name="product_create_date"
					value="<%=productVO.getProduct_create_date()%>"> 
<!-- 					<a -->
<!-- 					class="so-BtnLink" href="javascript:calClick();return false;" -->
<!-- 					onmouseover="calSwapImg('BTN_date', 'img_Date_OVER',true);" -->
<!-- 					onmouseout="calSwapImg('BTN_date', 'img_Date_UP',true);" -->
<!-- 					onclick="calSwapImg('BTN_date', 'img_Date_DOWN');showCalendar('form1','product_create_date','BTN_date');return false;"> -->
<!-- 						<img align="middle" border="0" name="BTN_date" -->
<!-- 						src="images/btn_date_up.gif" width="22" height="17" alt="�}�l���"> -->
<!-- 				</a> -->
				</td>
			</tr>
			<tr>
				<!-- �ӫ~��T -->
				<td>�ӫ~��T�G</td>
				<td><input type="TEXT" name="product_info" size="45"
					value="<%=productVO.getProduct_info()%>" /></td>
			</tr>
			<jsp:useBean id="product_kindSvc" scope="page"
				class="com.product_kind.model.Product_kindService" />
			<tr>
				<!-- �ӫ~���O -->
				<td>�ӫ~���O�G<font color=red><b>*</b></font></td>
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
		<input type="hidden" name="requestURL" value="<%=request.getParameter("requestURL")%>">	<!--������e�X�ק諸�ӷ��������|��,�A�e��Controller�ǳ���椧��-->
		<input type="hidden" name="whichPage" value="<%=request.getParameter("whichPage")%>"><!--�Ω�:istAllEmp.jsp �P �ƦX�d�� listEmps_ByCompositeQuery.jsp-->
		<button class="button" style="font-size:24px; font-family:�L�n������;">Update</button>

	</FORM>
</div>	
</div>
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