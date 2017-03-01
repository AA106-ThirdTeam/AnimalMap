<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.charge.model.*"%>
<%
	ChargeService chargeSvc = new ChargeService();
	List<ChargeVO> list = chargeSvc.getAll();
	pageContext.setAttribute("list",list);
%>
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
				<FORM METHOD="post" ACTION="charge.do" name="form1">
		<table border='1' bordercolor='#ccccff' width='1400'>
		<tr>
			<th>儲值編號</th>
			<th>會員編號</th>
			<th>儲值金額</th>
			<th>付款方式</th>
			<th>儲值日期</th>

		</tr>
		<%@ include file="pages/page1.file" %>
		<c:forEach var="chargeVO" items="${list}" begin="<%=pageIndex%>" end="<%=pageIndex+rowsPerPage-1%>">
		
		<tr align='center' valign='middle' ${(chargeVO.charge_no==param.charge_no) ? 'bgcolor=#CCCCFF':''}><!--將修改的那一筆加入對比色而已-->
			<td>${chargeVO.charge_no}</td>
			<td>${chargeVO.mem_Id}
				<c:forEach var="memVO" items="${memSvc.all}">
					<c:if test="${chargeVO.mem_Id==memVO.mem_Id}">
					</c:if>
				</c:forEach>
			</td>
			<td>${chargeVO.charge_number}</td>
			<td>${chargeVO.pay}</td>
			<td>${chargeVO.applytime}</td>
		</tr>
	</c:forEach>
	</table>
		<input type="hidden" name="action" value="insert">
		<input type="submit" value="送出新增">
	</FORM>
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