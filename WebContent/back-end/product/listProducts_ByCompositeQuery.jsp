<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%-- �U�νƦX�d��-�i�ѫȤ��select_page.jsp�H�N�W�����Q�d�ߪ���� --%>
<%-- �����u�@���ƦX�d�߮ɤ����G�m�ߡA�i���ݭn�A�W�[�����B�e�X�ק�B�R�����\��--%>

<jsp:useBean id="listProducts_ByCompositeQuery" scope="request" type="java.util.List" />
<jsp:useBean id="product_kindSvc" scope="page" class="com.product_kind.model.Product_kindService" />
<html>
<head>
<title>�ƦX�d��listProducts_ByCompositeQuery.jsp</title>
</head>
<body>
	<h1>listProducts_ByCompositeQuery.jsp</h1>
	<b><font color=blue>

<table border='1' cellpadding='5' cellspacing='0' width='1200'>
	<tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
		<td>
		<h3><font color=red>�ƦX�d��</font> - listProducts_ByCompositeQuery.jsp</h3>
		<a href="<%=request.getContextPath()%>/back-end/select_page.jsp"><img src="images/back1.gif" width="100" height="32" border="0">�^����</a>
		</td>
	</tr>
</table>


<table border='1' bordercolor='#ccccff' width='1200'>
	<tr>
		<th>�ӫ~�s��</th>
		<th>�ӫ~�W��</th>
		<th>�ӫ~²��</th>
		<th>�ӫ~����</th>
		<th>�ӫ~�w�s�q</th>
		<th>�ӫ~�Ϥ�</th>
		<th>�ӫ~�Y��</th>
		<th>�W�U�[���A</th>
		<th>�إߤ��</th>
		<th>�ӫ~��T</th>
		<th>�ӫ~���O</th>
		<th>�ק�</th>
		<th>�R��</th>
	</tr>
	<%@ include file="pages/page1_ByCompositeQuery.file" %>
	<c:forEach var="productVO" items="${listProducts_ByCompositeQuery}" begin="<%=pageIndex%>" end="<%=pageIndex+rowsPerPage-1%>" >
		<tr align='center' valign='middle' ${(productVO.product_kind_no==product_kindVO.product_kind_no) ? 'bgcolor=#CCCCFF':''}><!--�N�ק諸���@���[�J����Ӥw-->
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
	                    ${product_kindVO.product_kind_no}�i${product_kindVO.product_kind_name}�j
                    </c:if>
        </c:forEach>

			</td>
			<td>
			  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/back-end/product/product.do">
			    <input type="submit" value="�ק�"> 
			    <input type="hidden" name="product_no"value="${productVO.product_no}">
			    <input type="hidden" name="requestURL"	value="<%=request.getServletPath()%>"><!--�e�X�����������|��Controller-->
			    <input type="hidden" name="action"	value="getOne_For_Update"></FORM>
			</td>
			<td>
			  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/back-end/product/product.do">
			    <input type="submit" value="�R��">
			    <input type="hidden" name="product_no" value="${productVO.product_no}">
			    <input type="hidden" name="requestURL"	value="<%=request.getServletPath()%>"><!--�e�X�����������|��Controller-->
			    <input type="hidden" name="action"value="delete"></FORM>
			</td>
		</tr>
	</c:forEach>
</table>
<%@ include file="pages/page2_ByCompositeQuery.file" %>

<!-- <br>�����������|:<br><b> -->
<%--    <font color=blue>request.getServletPath():</font> <%= request.getServletPath()%><br> --%>
<%--    <font color=blue>request.getRequestURI(): </font> <%= request.getRequestURI()%> </b> --%>
</body>

</html>