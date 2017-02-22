<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.product.model.*"%>
<%-- 此頁練習採用 EL 的寫法取值 --%>

<%  
// EmpService empSvc = new EmpService();
// List<EmpVO> list = empSvc.getAll();
// pageContext.setAttribute("list",list);
%>
<jsp:useBean id="product_kindSvc" scope="page" class="com.product_kind.model.Product_kindService" />

<html>
<head>
<title>所有部門 - listAllProduct_kind.jsp</title>
</head>
<body bgcolor='white'>
<b><font color=red>此頁練習採用 EL 的寫法取值:</font></b>
<table border='1' cellpadding='5' cellspacing='0' width='800'>
	<tr bgcolor='orange' align='center' valign='middle' height='20'>
		<td>
		<h3>所有部門 - ListAllProduct_kind.jsp</h3>
		<a href="<%=request.getContextPath()%>/back-end/select_page.jsp">
		<img src="images/home1.png" width="50" height="32" border="0">回首頁</a>
		</td>
	</tr>
</table>

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

<table border='1' bordercolor='#CCCCFF' width='800'>
	<tr>
		<th>部門編號</th>
		<th>部門名稱</th>
		<th>部門基地</th>
		<th>修改</th>
		<th>刪除<font color=red>(關聯測試與交易-小心)</font></th>
		<th>查詢部門員工</th>
	</tr>
	
	<c:forEach var="product_kindVO" items="${product_kindSvc.all}">
		<tr align='center' valign='middle'>
			<td>${product_kindVO.product_kind_no}</td>
			<td>${product_kindVO.product_kind_name}</td>
			<td>${product_kindVO.product_kind_name}</td>
			<td>
			  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/back-end/product_kind/product_kind.do">
			    <input type="submit" value="修改" disabled="true"> 
			    <input type="hidden" name="product_kind_no" value="${product_kindVO.product_kind_no}">
			    <input type="hidden" name="action" value="getOne_For_Update_Product_kind">
			</td></FORM>
			<td>
			  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/back-end/product_kind/product_kind.do">
			    <input type="submit" value="刪除">
			    <input type="hidden" name="product_kind_no" value="${product_kindVO.product_kind_no}">
			    <input type="hidden" name="action" value="delete_Product_kind">
			</td></FORM>
			<td>
			  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/back-end/product_kind/product_kind.do">
			    <input type="submit" value="送出查詢"> 
			    <input type="hidden" name="product_kind_no" value="${product_kindVO.product_kind_no}">
			    <input type="hidden" name="action" value="listProducts_ByProduct_kind_no_B">
			</td></FORM>
		</tr>
	</c:forEach>
</table>

<%if (request.getAttribute("listProducts_ByProduct_kind_no")!=null){%>
       <jsp:include page="listProducts_ByProduct_kind_no.jsp" />
<%} %>

</body>
</html>
