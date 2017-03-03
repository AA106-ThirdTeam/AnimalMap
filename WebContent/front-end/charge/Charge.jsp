<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.charge.model.*"%>
<%
	ChargeVO chargeVO = (ChargeVO) request.getAttribute("chargeVO");
%>
<html>
<head>
<title>Shop.jsp</title>
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<link rel="stylesheet" href="<%=request.getContextPath()%>/front-end/css/layout.css"/>

</head>
<body>
<div id="layout">
	<div id="header">
		<div id="logo"><a href="<%=request.getContextPath() %>/front-end/homepage/index.jsp"><img src="<%=request.getContextPath()%>/front-end/images/1.png" alt="" /></a>
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
		<table border="0">
			<jsp:useBean id="memSvc" scope="page" class="heibernate_com.mem.model.MemService" />
			<tr>
				<!--會員編號 -->
				<td>會員編號<font color=red><b>*</b></font></td>
				<td><select size="1" name="mem_Id">
				<c:forEach var="memVO" items="${memSvc.all}">
					<option value="${memVO.mem_Id}"
					${(chargeVO.mem_Id==memVO.mem_Id)? 'selected':'' }>${memVO.mem_Id}
				</c:forEach></select></td>
			</tr>
			<tr>
				<!-- 儲值金額 -->
				<td>儲值金額</td>
				<td><input type="TEXT" name="charge_number" size="45"
					value="<%=(chargeVO == null) ? "500" : chargeVO.getCharge_number()%>" />
				</td>
			</tr>
			<tr>
				<!-- 付款方式 -->
				<td>付款方式</td>
				<td><select name="pay">
						<option value="<%=(chargeVO == null) ? "1" : chargeVO.getPay()%>">1-ATM</option>>
						<option value="<%=(chargeVO == null) ? "2" : chargeVO.getPay()%>">2-超商</option>>
					</select>
				</td>
			</tr>
			<tr>
				<%
					java.sql.Date date_SQL = new java.sql.Date(System.currentTimeMillis());
				%>
				<!-- 儲值時間 -->
				<td>
					<input type="hidden" name="applytime" value="<%=new java.sql.Date(System.currentTimeMillis())%>">
				</td>
			</tr>		
		</table>
		<input type="hidden" name="action" value="insert">
		<input type="submit" value="送出新增">
	</FORM>
      		</div><!-- END -->
 			<div id="footer">
				<div class="footer_link">
				<ul style="color:#FFf;">
		          
				</ul>
				</div><!-- End div_footer_link-->
			</div><!-- End div_footer-->
		</div><!-- End div_container_row-->
	</div><!-- End div_body_container_inner-->
</div><!-- End div_body_container-->
</div><!-- End layout-->
</body>
</html>