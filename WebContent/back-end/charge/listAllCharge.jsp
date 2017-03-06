<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.charge.model.*"%>

<%
	ChargeService chargeSvc = new ChargeService();
	List<ChargeVO> list = chargeSvc.getAll();
	pageContext.setAttribute("list",list);
%>
<jsp:useBean id="memSvc" scope="page" class="heibernate_com.mem.model.MemService" />

<html>
<head>
<title>listAllCharge.jsp</title>
</head>
<body>
	<h1>listAllCharge.jsp</h1>
	<b><font color=red>此頁練習採用 EL 的寫法取值:</font></b>
	<table  border='1' cellpadding='5' cellspacing='0' width='1400'>
		<tr bgcolor='#ccccff' align='center' valign='middle' height='20'>
			<td>
			<h3>所有儲值資料</h3>
			<a href="<%=request.getContextPath()%>/back-end/select_page.jsp">
			<img src="<%=request.getContextPath()%>/back-end/images/back1.gif" width="100" height="32" border="0">回首頁</a>
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
	<table border='1' bordercolor='#ccccff' width='1400'>
		<tr>
			<th>儲值編號</th>
			<th>會員編號</th>
			<th>儲值金額</th>
			<th>付款方式</th>
			<th>儲值日期</th>
			<th>修改</th>
			<th>刪除</th>
		</tr>
		<%@ include file="pages/page1.file" %> 
		<c:forEach var="chargeVO" items="${list}" begin="<%=pageIndex%>" end="<%=pageIndex+rowsPerPage-1%>">
		<tr align='center' valign='middle' ${(chargeVO.charge_no==param.charge_no) ? 'bgcolor=#CCCCFF':''}><!--將修改的那一筆加入對比色而已-->
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
			    	<input type="submit" value="修改" de>
			     	<input type="hidden" name="product_no" value="${chargetVO.charge_no}">
			     	<input type="hidden" name="requestURL"	value="<%=request.getServletPath()%>"><!--送出本網頁的路徑給Controller-->
			     	<input type="hidden" name="whichPage"	value="<%=whichPage%>">               <!--送出當前是第幾頁給Controller-->
			    	<input type="hidden" name="action"	value="getOne_For_Update">
				</FORM>
			</td>
			<td>
			  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/back-end/charge/charge.do">
			    <input type="submit" value="刪除">
			    <input type="hidden" name="product_no" value="${chargetVO.charge_no}">
			    <input type="hidden" name="requestURL"	value="<%=request.getServletPath()%>"><!--送出本網頁的路徑給Controller-->
			    <input type="hidden" name="whichPage"	value="<%=whichPage%>">               <!--送出當前是第幾頁給Controller-->
			    <input type="hidden" name="action"value="delete"></FORM>
			</td>
		</tr>
	</c:forEach>
			
	</table>
<%@ include file="pages/page2.file" %>	
</body>
</html>