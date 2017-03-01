<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page import="java.util.*"%>
<%@ page import="com.grp.model.*"%>
<%-- 此頁練習採用 EL 的寫法取值 --%>

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
<title>listAllGrp.jsp</title>
</head>
<body bgcolor='white'>
<b><font color=red>此頁練習採用 EL 的寫法取值:</font></b>

<table border='1' cellpadding='5' cellspacing='0' width='800'>
	<tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
		<td>
		<h3>所有揪團資料 - ListAllGGrp.jsp</h3>
		<a href="select_page.jsp"><img src="images/back1.gif" width="100" height="32" border="0">回首頁</a>
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



<table border='1' bordercolor='#CCCCFF'>
	 <tr>
		<th>揪團編號</th>
		<th>會員編號(主糾人)</th>
		<th>揪團名稱</th>
		<th>縣/市</th>
		<th>鄉鎮市區村里</th>
		<th>道路街名</th>
		<th>揪團開始時間</th>
		<th>揪團結束時間</th>
		<th>建立時間</th>
		<th>揪團敘述</th>
		<th>揪團經度座標</th>
		<th>揪團緯度座標</th>
		<th>物件顯示狀態</th>
		<th>揪團顯示照片</th>
		<th>修改</th>
		<th>刪除</th>
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
			<td><img src="data:image/png;base64, <%= encodedText %>" alt="Red dot" style="width:300px;height:300px"></td>	 		
			<td>
			<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/grp/grp.do">
			     <input type="submit" value="修改">
			     <input type="hidden" name="grp_Id" value="${grpVO.grp_Id}">
			     <input type="hidden" name="whichPage"	value="<%=whichPage%>"> 
			     <input type="hidden" name="action"	value="getOne_For_Update"></FORM>
			</td>
			<td>
			  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/grp/grp.do">
			    <input type="submit" value="刪除">
			    <input type="hidden" name="grp_Id" value="${grpVO.grp_Id}">
			    <input type="hidden" name="whichPage"	value="<%=whichPage%>">
			    <input type="hidden" name="action"value="delete"></FORM>
			</td>
			
			<td>
				<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/grp/grp.do">
					<input type="submit" value="編輯留言"> 
					<input type="hidden" name="grp_Id" value="${grpVO.grp_Id}">
					<input type="hidden" name="action" value="listComments_ByGrpId">
					<input type="hidden" name="whichPage"	value="<%=whichPage%>"> 
				</FORM>
			</td>
			
			<td>
				<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/grp/grp.do">
					<input type="submit" value="查看"> 
					<input type="hidden" name="grp_Id" value="${grpVO.grp_Id}">
					<input type="hidden" name="action" value="getOne_For_Display">
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
