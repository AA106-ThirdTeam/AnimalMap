<%-- <%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%> --%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head><title>IBM Product: Home</title></head>
<link rel="stylesheet" type="text/css" href="js/calendar.css">
<script language="JavaScript" src="js/calendarcode.js"></script>
<div id="popupcalendar" class="text"></div>
<body bgcolor='white'>

<table border="1" cellpadding='5' cellspacing='0' width='1600'>
	<tr>
　		<td colspan="2">MVC</td>
　	</tr>
	<tr>
　		<td colspan="2">
		<h1>錯誤提示區</h1>
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
		</td>
　	</tr>
	<tr>
　		<td>Product+Product_kind</td>
　		<td>Charge+Mem</td>
　	</tr>
	<tr>
		<td>
			<h3>資料查詢:</h3>
			

<ul>
  <li><a href='<%=request.getContextPath()%>/back-end/product/listAllProduct.jsp'>List</a> all Products. </li> <br><br>
  
  <li>
    <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/back-end/product/product.do" >
        <b>輸入商品編號 (如1):</b>
        <input type="text" name="product_no">
        <input type="submit" value="送出">
        <input type="hidden" name="action" value="getOne_For_Display">
    </FORM>
  </li>

  <jsp:useBean id="productSvc" scope="page" class="com.product.model.ProductService" />
   
  <li>
     <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/back-end/product/product.do" >
       <b>選擇編號:</b>
       <select size="1" name="product_no">
         <c:forEach var="productVO" items="${productSvc.all}" > 
          <option value="${productVO.product_no}">${productVO.product_no}
         </c:forEach>   
       </select>
       <input type="submit" value="送出">
       <input type="hidden" name="action" value="getOne_For_Display">
    </FORM>
  </li>
  
  <li>
     <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/back-end/product/product.do" >
       <b>選擇商品名稱:</b>
       <select size="1" name="product_no">
         <c:forEach var="productVO" items="${productSvc.all}" > 
          <option value="${productVO.product_no}">${productVO.product_name}
         </c:forEach>   
       </select>
       <input type="submit" value="送出">
       <input type="hidden" name="action" value="getOne_For_Display">
     </FORM>
  </li>
  
   <jsp:useBean id="product_kindSvc" scope="page" class="com.product_kind.model.Product_kindService" />
  
  <li>
     <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/back-end/product_kind/product_kind.do" >
       <b><font color=orange>選擇商品類別:</font></b>
       <select size="1" name="product_kind_no">
         <c:forEach var="product_kindVO" items="${product_kindSvc.all}" > 
          <option value="${product_kindVO.product_kind_no}">${product_kindVO.product_kind_name}
         </c:forEach>   
       </select>
       <input type="submit" value="送出">
       <input type="hidden" name="action" value="listProducts_ByProduct_kind_no_A">
     </FORM>
  </li>
</ul>

<%-- 萬用複合查詢-以下欄位-可隨意增減 --%>
<ul>  
  <li>   
    <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/back-end/product/product.do" name="form1">
        <b><font color=blue>萬用複合查詢:</font></b> <br>
        <b>輸入編號:</b>
        <input type="text" name="product_no" value=""><br>
           
       <b>輸入名稱:</b>
       <input type="text" name="product_name" value=""><br>
       
       <b>輸入資訊:</b>
       <input type="text" name="product_info" value=""><br>
    
       <b>選擇商品類別:</b>
       <select size="1" name="product_kind_no" >
          <option value="">
         <c:forEach var="product_kindVO" items="${product_kindSvc.all}" > 
          <option value="${product_kindVO.product_kind_no}">${product_kindVO.product_kind_name}
         </c:forEach>   
       </select><br>
           
       <b>新增日期:</b>
		    <input class="cal-TextBox"
			onFocus="this.blur()" size="9" readonly type="text" name="product_create_date" value="2017-1-1">
			<a class="so-BtnLink"
			href="javascript:calClick();return false;"
			onmouseover="calSwapImg('BTN_date', 'img_Date_OVER',true);"
			onmouseout="calSwapImg('BTN_date', 'img_Date_UP',true);"
			onclick="calSwapImg('BTN_date', 'img_Date_DOWN');showCalendar('form1','product_create_date','BTN_date');return false;">
		    <img align="middle" border="0" name="BTN_date"	src="images/btn_date_up.gif" width="22" height="17" alt="開始日期"></a>
		        
        <input type="submit" value="送出">
        <input type="hidden" name="action" value="listProducts_ByCompositeQuery">
     </FORM>
  </li>
</ul>


<h3><font color=pink>商品管理</font></h3>

<ul>
  <li><a href='<%=request.getContextPath()%>/back-end/product/addProduct.jsp'>Add</a> a new Product.</li>
</ul>

<h3><font color=orange>商品類別管理</font></h3>

<ul>
  <li><a href='<%=request.getContextPath()%>/back-end/product_kind/listAllProduct_kind.jsp'>List</a> all Product_kind. </li>
</ul>
		</td>
		<td>
	<h3>資料查詢:</h3>


	<ul>
	  <li><a href='<%=request.getContextPath()%>/back-end/charge/listAllCharge.jsp'>List</a> AllCharge. </li> <br><br>
	</ul>

	<ul>
		<li>
		<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/back-end/charge/charge.do" >
	        <b>輸入儲值編號(如1):</b>
	        <input type="text" name="charge_no">
	        <input type="submit" value="送出">
	        <input type="hidden" name="action" value="getOne_For_Display">
   		 </FORM>
 		 </li>
 		 <jsp:useBean id="chargeSvc" scope="page" class="com.charge.model.ChargeService" />
		 <li>
	     <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/back-end/charge/charge.do" >
	       <b>選擇儲值編號:</b>
	       <select size="1" name="charge_no">
	         <c:forEach var="chargeVO" items="${chargeSvc.all}" > 
	          <option value="${chargeVO.charge_no}">${chargeVO.charge_no}
	         </c:forEach>   
	       </select>
	       <input type="submit" value="送出">
	       <input type="hidden" name="action" value="getOne_For_Display">
	    </FORM>
  		</li>
  		
    </ul>
	<h3><font color=pink>儲值管理</font></h3>
	<ul>
  		<li><a href='<%=request.getContextPath()%>/back-end/charge/addCharge.jsp'>Add</a> a new Charge.</li>
	</ul>		
		
		</td>
	</tr>
</table>



</body>

</html>
