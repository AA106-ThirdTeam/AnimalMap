<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><html>

<jsp:useBean id="listCharge_ByCompositeQuery" scope="request" type="java.util.List" />
<jsp:useBean id="product_kindSvc" scope="page" class="com.mem_hua.model.MemService" />
<head>
<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
<title>listCharge_ByCompositeQuery</title>
</head>

<body>
	<h1>listCharge_ByCompositeQuery.jsp</h1>
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
			<th>�x�Ƚs��</th>
			<th>�|���s��</th>
			<th>�x�Ȫ��B</th>
			<th>�I�ڤ覡</th>
			<th>�x�Ȥ��</th>
			<th>�ק�</th>
			<th>�R��</th>
		</tr>
<%@ include file="pages/page1_ByCompositeQuery.file" %>
	<c:forEach var="chargeVO" items="${list}" begin="<%=pageIndex%>" end="<%=pageIndex+rowsPerPage-1%>">
		<tr align='center' valign='middle' ${(chargeVO.charge_no==param.charge_no) ? 'bgcolor=#CCCCFF':''}><!--�N�ק諸���@���[�J����Ӥw-->
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
			<td>
				<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/back-end/charge/charge.do">
			    	<input type="submit" value="�ק�">
			     	<input type="hidden" name="product_no" value="${chargetVO.charge_no}">
			     	<input type="hidden" name="requestURL"	value="<%=request.getServletPath()%>"><!--�e�X�����������|��Controller-->
			     	<input type="hidden" name="whichPage"	value="<%=whichPage%>">               <!--�e�X��e�O�ĴX����Controller-->
			    	<input type="hidden" name="action"	value="getOne_For_Update">
				</FORM>
			</td>
			<td>
			  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/back-end/charge/charge.do">
			    <input type="submit" value="�R��">
			    <input type="hidden" name="product_no" value="${chargetVO.charge_no}">
			    <input type="hidden" name="requestURL"	value="<%=request.getServletPath()%>"><!--�e�X�����������|��Controller-->
			    <input type="hidden" name="whichPage"	value="<%=whichPage%>">               <!--�e�X��e�O�ĴX����Controller-->
			    <input type="hidden" name="action"value="delete"></FORM>
			</td>
		</tr>
	</c:forEach>
</table>
<%@ include file="pages/page2_ByCompositeQuery.file" %>
</body>
</html>