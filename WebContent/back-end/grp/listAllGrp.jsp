<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page import="java.util.*"%>
<%@ page import="com.grp.model.*"%>
<%-- �����m�߱ĥ� EL ���g�k���� --%>

<% 
	session.setAttribute("Mem_Id_1", "1000000");
	session.setAttribute("Mem_Id_2", "1000001");
	session.setAttribute("Mem_Id_3", "1000002");
%>

<%
    GrpService grpSvc = new GrpService();
    List<GrpVO> list = grpSvc.getAll();
    pageContext.setAttribute("list",list);
%>

<html>
<head>
<title>�Ҧ����u��� - listAllHos.jsp</title>
</head>
<body bgcolor='white'>
<b><font color=red>�����m�߱ĥ� EL ���g�k����:</font></b>

<table border='1' cellpadding='5' cellspacing='0' width='800'>
	<tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
		<td>
		<h3>�Ҧ����u��� - ListAllHos.jsp</h3>
		<a href="select_page.jsp"><img src="images/back1.gif" width="100" height="32" border="0">�^����</a>
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



<table border='1' bordercolor='#CCCCFF'>
	 <tr>
		<th>���νs��</th>
		<th>�|���s��(�D�ȤH)</th>
		<th>���ΦW��</th>
		<th>��/��</th>
		<th>�m���ϧ���</th>
		<th>�D����W</th>
		<th>���ζ}�l�ɶ�</th>
		<th>���ε����ɶ�</th>
		<th>�إ߮ɶ�</th>
		<th>���αԭz</th>
		<th>���θg�׮y��</th>
		<th>���νn�׮y��</th>
		<th>������ܪ��A</th>
		<th>������ܷӤ�</th>
		<th>�ק�</th>
		<th>�R��</th>
	</tr>
	
	
	<%  
		Base64.Encoder encoder = Base64.getEncoder();   
	%>
		
	<%@ include file="page1.file" %> 
	<c:forEach var="grpVO" items="${list}" begin="<%=pageIndex%>" end="<%=pageIndex+rowsPerPage-1%>">
		<c:set var="grp_photo" value="${grpVO.grp_photo}" scope="request"/>
		<% 
			byte[] imageByte = (byte[])request.getAttribute("grp_photo");
			String encodedText = encoder.encodeToString(imageByte);  
// 			System.out.println(encodedText);  
		%>
 	
		<tr align='center' valign='middle'>
 			<td>${grpVO.grp_Id}</td>
			<td>${grpVO.grp_MemId}</td>
			<td>${grpVO.grp_name}</td>
			<td>${grpVO.grp_city}</td>
			<td>${grpVO.grp_town}</td>
			<td>${grpVO.grp_road}</td>
			<td><fmt:formatDate value="${grpVO.grp_StartTime}" type="time"/></td>
			<td><fmt:formatDate value="${grpVO.grp_EndTime}" pattern="hh:mm a"/></td>
			<td><fmt:formatDate value="${grpVO.grp_CreateTime}" type="date"/></td>
			<td>${grpVO.grp_Desc}</td>
			<td>${grpVO.grp_Long}</td>
			<td>${grpVO.grp_Lat}</td>
			<td>${grpVO.grp_visible}</td>
			<td><img src="data:image/png;base64, <%= encodedText %>" alt="Red dot"></td>	 		
			<td>
			<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/grp/grp.do">
			     <input type="submit" value="�ק�">
			     <input type="hidden" name="grp_Id" value="${grpVO.grp_Id}">
			     <input type="hidden" name="whichPage"	value="<%=whichPage%>"> 
			     <input type="hidden" name="action"	value="getOne_For_Update"></FORM>
			</td>
			<td>
			  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/grp/grp.do">
			    <input type="submit" value="�R��">
			    <input type="hidden" name="grp_Id" value="${grpVO.grp_Id}">
			    <input type="hidden" name="whichPage"	value="<%=whichPage%>">
			    <input type="hidden" name="action"value="delete"></FORM>
			</td>
			
			<td>
				<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/grp/grp.do">
					<input type="submit" value="�s��d��"> 
					<input type="hidden" name="grp_Id" value="${grpVO.grp_Id}">
					<input type="hidden" name="action" value="listComments_ByGrpId">
					<input type="hidden" name="whichPage"	value="<%=whichPage%>"> 
				</FORM>
			</td>
			
			<td>
				<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/grp/grp.do">
					<input type="submit" value="�[�J����"> 
					<input type="hidden" name="grp_Id" value="${grpVO.grp_Id}">
					<input type="hidden" name="action" value="listComments_ByGrpId">
					<input type="hidden" name="whichPage"	value="<%=whichPage%>"> 
				</FORM>
			</td>
			
		</tr>
	</c:forEach>
</table>
<%@ include file="page2.file" %>

</body>

<%
		if (request.getAttribute("listComments_ByGrpId") != null) {
	%>
	<jsp:include page="listComments_ByGrpId.jsp" />
	<%
		}
	%>

</html>
