<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ page import="java.util.*"%>
<%@ page import="com.hos.model.*"%>
<%-- �����m�߱ĥ� EL ���g�k���� --%>

<% 
	session.setAttribute("Mem_Id_1", "1000000");
	session.setAttribute("Mem_Id_2", "1000001");
	session.setAttribute("Mem_Id_3", "1000002");
%>

<%
	List<HosVO> list = null;

	if (request.getAttribute("listHos_BySearchCondition") == null) {
		HosService hosSvc = new HosService();
		list = hosSvc.getAll();
	} else {
		list = (List<HosVO>) request.getAttribute("listHos_BySearchCondition");
	}

	pageContext.setAttribute("list", list);
%>


<html>
<head>
<title>�Ҧ��ʪ���|��� - listAllHos.jsp</title>
</head>
<body bgcolor='white'>
	<b><font color=red>�����m�߱ĥ� EL ���g�k����:</font></b>
	<table border='1' cellpadding='5' cellspacing='0' width='800'>
		<tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
			<td>
				<h3>�Ҧ��ʪ���|��� - listAllHos.jsp</h3> <a href="<%=request.getContextPath()%>/back-end/hos/select_page.jsp"><img
					src="images/back1.gif" width="100" height="32" border="0">�^����</a>
			</td>
		</tr>
	</table>

	<%-- ���~��C --%>
	<c:if test="${not empty errorMsgs}">
		<font color='red'>�Эץ��H�U���~:
			<ul>
				<c:forEach var="message" items="${errorMsgs}">
					<li>${message}</li>
				</c:forEach>
			</ul>
		</font>
	</c:if>

	<%-- 	<c:forEach var="hosVO" items="${list}" > --%>
	<%-- 		${hosVO.hos_name} --%>
	<%-- 	</c:forEach> --%>

	<table border='1' bordercolor='#CCCCFF'>
		<tr>
			<!-- 	 	<th>�E�ҥD�n��ܹϤ�</th> -->
			<th>�E�ҽs��</th>
			<th>�|���s��(�t�d�H)</th>
			<th>�E�ҦW��</th>
			<th>��/��</th>
			<th>�m���ϧ���</th>
			<th>�D����W</th>
			<th>����</th>
			<th>URL</th>
			<th>�}�l��~�ɶ�</th>
			<th>������~�ɶ�</th>
			<th>�إ߮ɶ�</th>
			<th>�q��</th>
			<th>�E�ұԭz</th>
			<th>�E�Ҹg�׮y��</th>
			<th>�E�ҽn�׮y��</th>
			<th>������ܪ��A</th>
			<th>�ק�</th>
			<th>�R��</th>
			<th>�s��ۤ�</th>
		</tr>


		<%@ include file="/back-end/hos/page1.file"%>
		<c:forEach var="hosVO" items="${list}" begin="<%=pageIndex%>"
			end="<%=pageIndex+rowsPerPage-1%>">
			<tr align='center' valign='middle'>
				<td>${hosVO.hos_Id}</td>
				<td>${hosVO.hos_MemId}</td>
				<td>${hosVO.hos_name}</td>
				<td>${hosVO.hos_city}</td>
				<td>${hosVO.hos_town}</td>
				<td>${hosVO.hos_road}</td>
				<td>${hosVO.hos_Eval}</td>
				<td>${hosVO.hos_URL}</td>
				<td>${hosVO.hos_StartTime}</td>
				<td>${hosVO.hos_EndTime}</td>
				<td><fmt:formatDate value="${hosVO.hos_CreateTime}" type="date" /></td>
				<td>${hosVO.hos_Tel}</td>
				<td>${hosVO.hos_Desc}</td>
				<td>${hosVO.hos_Long}</td>
				<td>${hosVO.hos_Lat}</td>
				<td>${hosVO.hos_visible}</td>



				<td>
					<FORM METHOD="post"
						ACTION="<%=request.getContextPath()%>/hos/hos.do">
						<input type="submit" value="�ק�"> <input type="hidden"
							name="hos_Id" value="${hosVO.hos_Id}"> <input
							type="hidden" name="action" value="getOne_For_Update">
						<input type="hidden" name="requestURL"	value="<%=request.getServletPath()%>">
					</FORM>
				</td>
				<td>
					<FORM METHOD="post"
						ACTION="<%=request.getContextPath()%>/hos/hos.do">
						<input type="submit" value="�R��"> <input type="hidden"
							name="hos_Id" value="${hosVO.hos_Id}"> <input
							type="hidden" name="action" value="delete">
						<input type="hidden" name="requestURL"	value="<%=request.getServletPath()%>">
					</FORM>
				</td>
				<td>
					<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/hos/hos.do">
						<input type="submit" value="�s��ۤ�"> 
						<input type="hidden" name="hos_Id" value="${hosVO.hos_Id}">
						<input type="hidden" name="action" value="listPhotos_ByHosId">
						<input type="hidden" name="whichPage"	value="<%=whichPage%>">
						<input type="hidden" name="requestURL"	value="<%=request.getServletPath()%>"> 
					</FORM>
				</td>
				
				<td>
					<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/hos/hos.do">
						<input type="submit" value="�s��d��"> 
						<input type="hidden" name="hos_Id" value="${hosVO.hos_Id}">
						<input type="hidden" name="action" value="listComments_ByHosId">
						<input type="hidden" name="whichPage"	value="<%=whichPage%>"> 
						<input type="hidden" name="requestURL"	value="<%=request.getServletPath()%>">
					</FORM>
				</td>
			</tr>

		</c:forEach>
	</table>
	<%@ include file="/back-end/hos/page2.file"%>

	<%
		if (request.getAttribute("listPhotos_ByHosId") != null) {
	%>
	<jsp:include page="listPhotos_ByHosId.jsp" />
	<%
		}
	%>
	
	<%
		if (request.getAttribute("listComments_ByHosId") != null) {
	%>
	<jsp:include page="listComments_ByHosId.jsp" />
	<%
		}
	%>
	



</body>
</html>
