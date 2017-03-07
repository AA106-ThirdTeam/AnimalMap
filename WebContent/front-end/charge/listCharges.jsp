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
<title>listCharge.jsp</title>
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<link rel="stylesheet" href="<%=request.getContextPath()%>/front-end/css/layout.css"/>
<style>
.wrapper {
  text-align: center;
  border-bottom: 3px solid #343436;
  background-color: #333;
}
table{
  margin: auto;
  padding: 20px;
  border-collapse: separate;
  border-spacing: 0;
}
tr{
  border: 1px solid #E0607E;
}
td{

  padding: 10px 30px;
  background-color:#e4edf5;
  color: #000;
}
th{

  padding: 10px 30px;
  background-color:	#d1cbee;
  color: #000;
}
/*第一欄第一列：左上*/
tr:first-child th:first-child{
  border-top-left-radius: 10px;
}
/*第一欄最後列：左下*/
tr:last-child td:first-child{
  border-bottom-left-radius: 10px;
}
/*最後欄第一列：右上*/
tr:first-child th:last-child{
  border-top-right-radius: 10px;
}
/*最後欄第一列：右下*/
tr:last-child td:last-child{
  border-bottom-right-radius: 10px;
}
</style>

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
		<table  width='800';>		
		<tr>
			<th style="font-family:Microsoft JhengHei ;font-size:x-large">儲值編號</th>
<!-- 			<th style="font-family:Microsoft JhengHei ;font-size:x-large">會員編號</th> -->
			<th style="font-family:Microsoft JhengHei ;font-size:x-large">儲值金額</th>
			<th style="font-family:Microsoft JhengHei ;font-size:x-large">儲值日期</th>
			<th style="font-family:Microsoft JhengHei ;font-size:x-large">儲值狀態</th>
		</tr>
		<c:forEach var="chargeVO" items="${list}" >
		<tr align='center' valign='middle' ${(chargeVO.charge_no==param.charge_no) ? 'bgcolor=#CCCCFF':''}><!--將修改的那一筆加入對比色而已-->
			<td style="font-family:monospace;font-size:large">${chargeVO.charge_no}</td><!-- 儲值編號 -->
			<td style="font-family:monospace;font-size:large">${chargeVO.charge_number}</td><!-- 儲值金額 -->
			<td style="font-family:monospace;font-size:large">${chargeVO.applytime}</td><!-- 儲值日期 -->
			<td><img src="<%=request.getContextPath()%>/front-end/images/checked.png " width=20 height=20/></td>
		</tr>
	</c:forEach>
	</table>
	</FORM>
      		</div><!-- END -->
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