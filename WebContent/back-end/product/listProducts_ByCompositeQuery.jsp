<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%-- 萬用複合查詢-可由客戶端select_page.jsp隨意增減任何想查詢的欄位 --%>
<%-- 此頁只作為複合查詢時之結果練習，可視需要再增加分頁、送出修改、刪除之功能--%>

<jsp:useBean id="listProducts_ByCompositeQuery" scope="request" type="java.util.List" />
<jsp:useBean id="product_kindSvc" scope="page" class="com.product_kind.model.Product_kindService" />
<html>
<head>
<title>複合查詢listProducts_ByCompositeQuery.jsp</title>
</head>
<body>
	<h1>listProducts_ByCompositeQuery.jsp</h1>
	<b><font color=blue>

<table border='1' cellpadding='5' cellspacing='0' width='1200'>
	<tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
		<td>
		<h3><font color=red>複合查詢</font> - listProducts_ByCompositeQuery.jsp</h3>
		<a href="<%=request.getContextPath()%>/back-end/select_page.jsp"><img src="images/back1.gif" width="100" height="32" border="0">回首頁</a>
		</td>
	</tr>
</table>


<table border='1' bordercolor='#ccccff' width='1200'>
	<tr>
		<th>商品編號</th>
		<th>商品名稱</th>
		<th>商品簡介</th>
		<th>商品價格</th>
		<th>商品庫存量</th>
		<th>商品圖片</th>
		<th>商品縮圖</th>
		<th>上下架狀態</th>
		<th>建立日期</th>
		<th>商品資訊</th>
		<th>商品類別</th>
		<th>修改</th>
		<th>刪除</th>
	</tr>
	<%@ include file="pages/page1_ByCompositeQuery.file" %>
	<c:forEach var="productVO" items="${listProducts_ByCompositeQuery}" begin="<%=pageIndex%>" end="<%=pageIndex+rowsPerPage-1%>" >
		<tr align='center' valign='middle' ${(productVO.product_kind_no==product_kindVO.product_kind_no) ? 'bgcolor=#CCCCFF':''}><!--將修改的那一筆加入對比色而已-->
			<td>${productVO.product_no}</td>
			<td>${productVO.product_name}</td>
			<td>${productVO.product_introduction}</td>
			<td>${productVO.product_price}</td>
			<td>${productVO.product_stock}</td>
			<td><img src="${productVO.product_picture_large}" width="auto" height="100"></td>
  			<td><img src="${productVO.product_picture_small}" width="auto" height="100"></td>
<%-- 			<td>${productVO.product_picture_large}</td> --%>
<%-- 			<td>${productVO.product_picture_small}</td> --%>
			<td>${productVO.product_status}</td>
			<td>${productVO.product_create_date}</td>
			<td>${productVO.product_info}</td>			
			<td><c:forEach var="product_kindVO" items="${product_kindSvc.all}">
                    <c:if test="${productVO.product_kind_no==product_kindVO.product_kind_no}">
	                    ${product_kindVO.product_kind_no}【${product_kindVO.product_kind_name}】
                    </c:if>
        </c:forEach>

			</td>
			<td>
			  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/back-end/product/product.do">
			    <input type="submit" value="修改"> 
			    <input type="hidden" name="product_no"value="${productVO.product_no}">
			    <input type="hidden" name="requestURL"	value="<%=request.getServletPath()%>"><!--送出本網頁的路徑給Controller-->
			    <input type="hidden" name="action"	value="getOne_For_Update"></FORM>
			</td>
			<td>
			  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/back-end/product/product.do">
			    <input type="submit" value="刪除">
			    <input type="hidden" name="product_no" value="${productVO.product_no}">
			    <input type="hidden" name="requestURL"	value="<%=request.getServletPath()%>"><!--送出本網頁的路徑給Controller-->
			    <input type="hidden" name="action"value="delete"></FORM>
			</td>
		</tr>
	</c:forEach>
</table>
<%@ include file="pages/page2_ByCompositeQuery.file" %>

<!-- <br>本網頁的路徑:<br><b> -->
<%--    <font color=blue>request.getServletPath():</font> <%= request.getServletPath()%><br> --%>
<%--    <font color=blue>request.getRequestURI(): </font> <%= request.getRequestURI()%> </b> --%>
</body>

</html>