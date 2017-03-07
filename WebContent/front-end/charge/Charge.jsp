<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.charge.model.*"%>

<%
	
	ChargeVO chargeVO = (ChargeVO) request.getAttribute("chargeVO");
	heibernate_com.mem.model.MemVO account = (heibernate_com.mem.model.MemVO)session.getAttribute("account");
	String mem_Id = account.getMem_Id();
%>
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
        	<h1>儲值</h1>
        		<a href="<%=request.getContextPath()%>/front-end/charge/listCharges.jsp" title="看儲值記錄">
        		<img src="<%=request.getContextPath()%>/front-end/images/file.png" alt="測試圖片" width="50"></a>
				<FORM METHOD="post" ACTION="charge.do" name="charge">
		<table border="0" width="600px">
			<jsp:useBean id="memSvc" scope="page" class="heibernate_com.mem.model.MemService" />
<!-- 			<tr> -->
<!-- 				會員編號 -->
<!-- 				<td>會員編號<font color=red><b>*</b></font></td> -->
<!-- 				<td><select size="1" name="mem_Id"> -->
<%-- 				<c:forEach var="memVO" items="${memSvc.all}"> --%>
<%-- 					<option value="${memVO.mem_Id}" --%>
<%-- 					${(chargeVO.mem_Id==memVO.mem_Id)? 'selected':'' }>${memVO.mem_Id} --%>
<%-- 				</c:forEach></select></td> --%>
<!-- 			</tr> -->
			<tr>
				<!-- 儲值金額 -->
				<td>請選擇儲值金額</td>
				<td><input type="number" name="charge_number"
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
			<!-- 以下全部是假的資料 -->
			<tr>
				<td>信用卡號碼</td>
				<td>	
					<input input type="text" name="xxx" >
				</td>
			</tr>
			<tr>
				<td></td>
			</tr>
			<tr>
				<td>有效期限</td>
				<td>
					<input type="TEXT" name="yyy"  placeholder="請輸入年+月ex:10612"/>
				</td>
			</tr>
			<tr>
				<td>卡片背面後3碼</td>
				<td>
					<input type="number" name="zzz" />
				</td>
			</tr>
		</table>
				
		<input type="hidden" name="action" value="insert">
		<button class="button" style="font-size:24px; font-family:微軟正黑體;">送出</button>
		<img src="<%=request.getContextPath()%>/front-end/images/dog.png"width="20" onClick="c()">
		
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
<script type="text/javascript">
	function c(){
		charge.charge_number.value="9999";
		charge.pay.value="1";
		charge.xxx.value="1523-2541-2145-3221";
		charge.yyy.value="10701";
		charge.zzz.value="567";		
	}
</script>