<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ page import="com.product.model.*"%>
<%@ page import="com.product_kind.model.*"%>
<%-- �����m�߱ĥ� Script ���g�k���� --%>

<%-- ���X Concroller EmpServlet.java�w�s�Jrequest��EmpVO����--%>
<%ProductVO productVO = (ProductVO) request.getAttribute("productVO"); %>

<%--���X����product_kind���� --%>
<%
	Product_kindService product_kindSvc = new Product_kindService();
	Product_kindVO product_kindVO = product_kindSvc.getOneProduct_kind(productVO.getProduct_kind_no());
%>
<html>
<head>
<title>�ӫ~���~~~listOneProduct</title>
</head>
<body>
	<h1>listOneProduct.jsp</h1>
	<b><font color=red>��Script�g�k����</font></b>
	<table border='1' cellpadding='5' cellspacing='0' width='1200'>
		<tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
			<td>
			<h3>�ӫ~���-listOneProduct</h3>
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
			<th>�ӫ~�Ϥ��]�Y��</th>
			<th>�ӫ~�W�U�[���A</th>
			<th>�ӫ~�إߤ��</th>
			<th>�ӫ~��T</th>
			<th>�ӫ~���O�s��</th>
		</tr>
		<tr align='center' valign='middle'>
			<td><%=productVO.getProduct_no()%></td>
			<td><%=productVO.getProduct_name()%></td>
			<td><%=productVO.getProduct_introduction()%></td>
			<td><%=productVO.getProduct_price()%></td>
			<td><%=productVO.getProduct_stock()%></td>
			<td><img src="${productVO.product_picture_large}" width="auto" height="100"></td>
   			<td><img src="${productVO.product_picture_small}" width="auto" height="100"></td>
			<td><%=productVO.getProduct_status()%></td>
			<td><%=productVO.getProduct_create_date()%></td>
			<td><%=productVO.getProduct_info()%></td>
			<td><%=productVO.getProduct_kind_no()%>�i<%=product_kindVO.getProduct_kind_name()%>�j</td>
		</tr>
	
	</table>
</body>
</html>