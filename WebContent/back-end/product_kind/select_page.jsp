<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<title>表格 Product_kind: Home</title>
	
	<!-- 共用HEAD -->
	
	<!-- BS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script src="https://code.jquery.com/jquery.js"></script>
	
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/back-end/css/calendar.css">
	<%@include file="/back-end/js/calendarcode.jsp"%>
</head>

<body bgcolor='white'>
<div id="popupcalendar" class="text"></div>

<table class="table"  border='1' cellpadding='5' cellspacing='0' width='400'>
  <tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
    <td>
    <h3>表格 Product_kind: Home</h3><font color=red>( MVC )</font>
    </td>
  </tr>
</table>

<hr>

<h2>商品類別資料查詢:</h2>
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
<!--  -->
<ul>
  <li><a href='<%=request.getContextPath()%>/back-end/product_kind/listAllProduct_kind.jsp'>List</a> all Product_kinds. </li> <br><br>
  
  <li>
    <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/back-end/product_kind/product_kind.do" >
        <b>輸入商品類別編號 (如7001):</b>
        <input type="text" name="product_kind_no">
        <input type="submit" value="送出">
        <input type="hidden" name="action" value="getOne_For_Display">
    </FORM>
  </li>

  <jsp:useBean id="product_kindSvc" scope="page" class="com.product_kind.model.Product_kindService" />

  <li>
     <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/back-end/product_kind/product_kind.do" >
       <b>選擇商品類別編號:</b>
       <select size="1" name="product_kind_no">
         <c:forEach var="product_kindVO" items="${product_kindSvc.all}" > 
          <option value="${product_kindVO.product_kind_no}">${product_kindVO.product_kind_no}
         </c:forEach>   
       </select>
       <input type="submit" value="送出">
       <input type="hidden" name="action" value="getOne_For_Display">
    </FORM>
  </li>



</ul>



<%-- 萬用複合查詢-以下欄位-可隨意增減 --%>
<ul>  
  <li>   
    <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/back-end/product_kind/product_kind.do" name="form1">
      <b><font color=blue>萬用複合查詢:</font></b> <br>

       <b>選擇商品類別編號編號:</b>
       <select size="1" name="product_kind_no">
            <option value=""/>
         <c:forEach var="product_kindVO" items="${product_kindSvc.all}" > 
          <option value="${product_kindVO.product_kind_no}">${product_kindVO.product_kind_no}
         </c:forEach>   
       </select>   
       <br>  

      <input type="submit" value="送出">
      <input type="hidden" name="action" value="listProduct_kinds_ByCompositeQuery">
    </FORM>
  </li>
</ul>

<hr>

<!--  -->
<h3>商品類別管理</h3>

<ul>
  <li><a href='<%=request.getContextPath()%>/back-end/product_kind/addProduct_kind.jsp'>Add</a> a new Product_kind.</li>
</ul>

<!--  -->
	    		

<!--  -->

</body>

</html>
