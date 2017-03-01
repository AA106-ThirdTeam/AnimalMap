<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ page import="java.util.*"%>
<%@ page import="com.hos.model.*"%>
<%-- 此頁練習採用 EL 的寫法取值 --%>

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
<title>所有動物醫院資料 - listAllHos.jsp</title>
</head>
<body bgcolor='white'>
	<b><font color=red>此頁練習採用 EL 的寫法取值:</font></b>
	<table border='1' cellpadding='5' cellspacing='0' width='800'>
		<tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
			<td>
				<h3>所有動物醫院資料 - listAllHos.jsp</h3> <a href="<%=request.getContextPath()%>/back-end/hos/select_page.jsp"><img
					src="images/back1.gif" width="100" height="32" border="0">回首頁</a>
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

	<%-- 	<c:forEach var="hosVO" items="${list}" > --%>
	<%-- 		${hosVO.hos_name} --%>
	<%-- 	</c:forEach> --%>

	<table border='1' bordercolor='#CCCCFF'>
		<tr>
			<!-- 	 	<th>診所主要顯示圖片</th> -->
			<th>診所編號</th>
			<th>會員編號(負責人)</th>
			<th>診所名稱</th>
			<th>縣/市</th>
			<th>鄉鎮市區村里</th>
			<th>道路街名</th>
			<th>評價</th>
			<th>URL</th>
			<th>開始營業時間</th>
			<th>結束營業時間</th>
			<th>建立時間</th>
			<th>電話</th>
			<th>診所敘述</th>
			<th>診所經度座標</th>
			<th>診所緯度座標</th>
			<th>物件顯示狀態</th>
			<th>修改</th>
			<th>刪除</th>
			<th>編輯相片</th>
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
						<input type="submit" value="修改"> <input type="hidden"
							name="hos_Id" value="${hosVO.hos_Id}"> <input
							type="hidden" name="action" value="getOne_For_Update">
						<input type="hidden" name="requestURL"	value="<%=request.getServletPath()%>">
					</FORM>
				</td>
				<td>
					<FORM METHOD="post"
						ACTION="<%=request.getContextPath()%>/hos/hos.do">
						<input type="submit" value="刪除"> <input type="hidden"
							name="hos_Id" value="${hosVO.hos_Id}"> <input
							type="hidden" name="action" value="delete">
						<input type="hidden" name="requestURL"	value="<%=request.getServletPath()%>">
					</FORM>
				</td>
				<td>
					<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/hos/hos.do">
						<input type="submit" value="編輯相片"> 
						<input type="hidden" name="hos_Id" value="${hosVO.hos_Id}">
						<input type="hidden" name="action" value="listPhotos_ByHosId">
						<input type="hidden" name="whichPage"	value="<%=whichPage%>">
						<input type="hidden" name="requestURL"	value="<%=request.getServletPath()%>"> 
					</FORM>
				</td>
				
				<td>
					<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/hos/hos.do">
						<input type="submit" value="編輯留言"> 
						<input type="hidden" name="hos_Id" value="${hosVO.hos_Id}">
						<input type="hidden" name="action" value="listComments_ByHosId">
						<input type="hidden" name="whichPage"	value="<%=whichPage%>"> 
						<input type="hidden" name="requestURL"	value="<%=request.getServletPath()%>">
					</FORM>
				</td>
				
				<td>
					<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/hos/hos.do">
						<input type="submit" value="查看"> 
						<input type="hidden" name="hos_Id" value="${hosVO.hos_Id}">
						<input type="hidden" name="action" value="getOne_For_Display">
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
