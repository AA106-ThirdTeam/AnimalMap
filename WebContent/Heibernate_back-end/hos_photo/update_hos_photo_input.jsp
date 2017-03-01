<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="heibernate_com.hos_photo.model.*"%>
<%
    Hos_photoVO hos_photoVO = (Hos_photoVO) request.getAttribute("hos_photoVO"); //Hos_photoServlet.java (Concroller), 存入req的hos_photoVO物件 (包括幫忙取出的hos_photoVO, 也包括輸入資料錯誤時的hos_photoVO物件)
%>
<!--  -->
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
<html>
<head>
	<!-- 共用HEAD -->
	<!-- BS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script src="https://code.jquery.com/jquery.js"></script>
	<title>診所相片資料修改 - update_hos_photo_input.jsp</title>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/Heibernate_back-end/css/calendar.css">
	<%@include file="/Heibernate_back-end/js/calendarcode.jsp"%>
	<div id="popupcalendar" class="text"></div>
</head>
<body bgcolor='white'>
<table border='1' cellpadding='5' cellspacing='0' width='800'>
    <tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
        <td>
        <h3>診所相片資料 - ListOneHos_photo.jsp</h3>
        <a href="<%=request.getContextPath()%>/Heibernate_back-end/hos_photo/select_page.jsp">
        	<img src="<%=request.getContextPath()%>/Heibernate_back-end/images/back1.gif" width="100" height="32" border="0">
        	回首頁
        </a>
        </td>
    </tr>
</table>
<h3>資料修改:</h3>
<FORM METHOD="post" ACTION="hos_photo.do" name="form1">
    <table border="0">
    <!--  -->
    <tr>
        <td>相片編號編號:<font color=red><b>*</b></font></td>
        <td><%=hos_photoVO.getHosPhoto_Id()%></td>
    </tr>
<jsp:useBean id="vet_hospitalSvc" scope="page" class="heibernate_com.vet_hospital.model.Vet_hospitalService" />
	<tr>
		<td>診所編號(相片擁有診所):<font color=red><b>*</b></font></td>
		<td>
	       <select size="1" name="hosPhoto_HosId">
	         <c:forEach var="vet_hospitalVO" items="${vet_hospitalSvc.all}" > 
				<option value="${vet_hospitalVO.hos_Id}" ${(hos_photoVO.vet_hospitalVO.hos_Id==vet_hospitalVO.hos_Id)?'selected':'' } >
${vet_hospitalVO.hos_Id}				
	         </c:forEach>   
	       </select>			
		</td>
	</tr>
	<tr>
		<td>相片:</td>
		<td><input type="file" name="hosPhoto_photo" size=45></td>
	</tr>	
    <tr>
        <td>是否為大頭貼相片:</td>
        <td><input type="TEXT" name="isDisp_HosPhoto" size="45" value="<%=hos_photoVO.getIsDisp_HosPhoto()%>" /></td>
    </tr>
    <tr>
        <td>相片名稱:</td>
        <td><input type="TEXT" name="hosPhoto_name" size="45" value="<%=hos_photoVO.getHosPhoto_name()%>" /></td>
    </tr>
    <tr>
        <td>相片副檔名:</td>
        <td><input type="TEXT" name="HOSPHOTO_EXTENTION" size="45" value="<%=hos_photoVO.getHOSPHOTO_EXTENTION()%>" /></td>
    </tr>
    <!--  -->
    </table>
    <br>
    <input type="hidden" name="action" value="update">
			<input type="hidden" name="hosPhoto_Id" value="<%=hos_photoVO.getHosPhoto_Id()%>">	
    <input type="hidden" name="requestURL" value="<%=request.getParameter("requestURL")%>"><!--接收原送出修改的來源網頁path後,再送給Controller準備轉交之用-->
    <input type="hidden" name="whichPage" value="<%=request.getParameter("whichPage")%>">  <!--用於:istAllHos_photo.jsp 與 複合查詢 listHos_photos_ByCompositeQuery.jsp-->
    <input type="submit" value="送出修改">
</FORM>
<br>送出修改的來源網頁path:<br><b>
   <font color=blue>request.getParameter("requestURL"):</font> <%= request.getParameter("requestURL")%><br>
</body>
</html>
