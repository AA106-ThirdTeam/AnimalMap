<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.adoptani.model.*"%>
<%@ page import="com.adoptani_photo.model.*"%>
<%@ page import="com.chung.tools.Tools"%>
<%-- 此頁練習採用 EL 的寫法取值 --%>

<%
	AdoptaniService adoptaniSvc = new AdoptaniService();
    List<AdoptaniVO> list = adoptaniSvc.getAll();
    pageContext.setAttribute("list",list);	//要放到scope裡面才找得到。
    
    Tools tools = new Tools();
%>
<%-- <jsp:useBean id="tools" scope="request" class="com.chung.tools.Tools" /> --%>
<html>
<head>
<title>所有送養動物資料 - listAllAdoptani.jsp</title>
</head>
<body bgcolor='white'>
<b><font color=red>此頁練習採用 EL 的寫法取值:</font></b>
<table border='1' cellpadding='5' cellspacing='0' width='800'>
	<tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
		<td>
		<h3>所有送養動物資料 - listAllAdoptani.jsp</h3>
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

<table border='1' bordercolor='#CCCCFF' width='800'>
	<tr>
		<th>送養動物編號</th>
		<th>發布者會員編號</th>
		<th>送養動物名字</th>
		<th>送養動物動物種類</th>
		<th>送養動物性別</th>
		<th>送養動物健康狀況</th>
		<th>送養動物疫苗接踵</th>
		<th>送養動物毛色</th>
		<th>送養動物體型</th>
		<th>送養動物年齡</th>
		<th>送養動物節育</th>
		<th>送養動物晶片編號</th>
		<th>送養時間</th>
		<th>送養動物物件狀態</th>
		<th>送養動物建立時間</th>
		<th>送養地點經度</th>
		<th>送養地點緯度</th>
		<th>縣/市</th>
		<th>鄉鎮市區</th>
		<th>道路街名村里</th>
		<th>Like數</th>
	</tr>
	<%@ include file="page1.file" %> 
	<c:forEach var="adoptaniVO" items="${list}" begin="<%=pageIndex%>" end="<%=pageIndex+rowsPerPage-1%>">
		<tr align='center' valign='middle' ${(adoptaniVO.adopt_Ani_Id==param.adopt_Ani_Id) ? 'bgcolor=#CCCCFF':''}>
			<td>${adoptaniVO.adopt_Ani_Id}</td> 
			<td>${adoptaniVO.mem_Id}</td>
			<td>${adoptaniVO.adopt_Ani_name}</td>
			<td>${adoptaniVO.adopt_Ani_type}</td>
			<c:set var="adopt_Ani_gender" value="${adoptaniVO.adopt_Ani_gender}" scope="request"></c:set>
			<td><%=tools.genderExchange((String) request.getAttribute("adopt_Ani_gender"))%></td>
			<td>${adoptaniVO.adopt_Ani_heal}</td>
			<td>${adoptaniVO.adopt_Ani_Vac}</td>
			<td>${adoptaniVO.adopt_Ani_color}</td>
			
			<td>${adoptaniVO.adopt_Ani_body}</td>
			<td>${adoptaniVO.adopt_Ani_age}</td>
			<c:set var="adopt_Ani_Neu" value="${adoptaniVO.adopt_Ani_Neu}" scope="request"></c:set>
			<td><%=tools.neuterExchange((String) request.getAttribute("adopt_Ani_Neu"))%></td>
			<td>${adoptaniVO.adopt_Ani_chip}</td>
			<td>${adoptaniVO.adopt_Ani_date}</td>
			<c:set var="adopt_Ani_status" value="${adoptaniVO.adopt_Ani_status}" scope="request"></c:set>
			<td><%=tools.statusExchange((String) request.getAttribute("adopt_Ani_status"))%></td>
			<td>${adoptaniVO.adopt_Ani_CreDate}</td>
			<td>${adoptaniVO.adopt_Ani_FinLat}</td>
			<td>${adoptaniVO.adopt_Ani_FinLon}</td>
			<td>${adoptaniVO.adopt_Ani_city}</td>
			<td>${adoptaniVO.adopt_Ani_town}</td>
			<td>${adoptaniVO.adopt_Ani_road}</td>
			<td>${adoptaniVO.adopt_Ani_like}</td>         
			<td>
			  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/front-end/adoptani/adoptani.do">
			     <input type="submit" value="修改">
			     <input type="hidden" name="adopt_Ani_Id" value="${adoptaniVO.adopt_Ani_Id}">
			     <input type="hidden" name="requestURL"	value="<%=request.getServletPath()%>"><!--送出本網頁的路徑給Controller-->
			     <input type="hidden" name="whichPage"	value="<%=whichPage%>">               <!--送出當前是第幾頁給Controller-->
			     <input type="hidden" name="action"	value="getOne_For_Update"></FORM>
			</td>
			<td>
			  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/front-end/adoptani/adoptani.do">
			    <input type="submit" value="刪除">
			    <input type="hidden" name="adopt_Ani_Id" value="${adoptaniVO.adopt_Ani_Id}">
			     <input type="hidden" name="requestURL"	value="<%=request.getServletPath()%>"><!--送出本網頁的路徑給Controller-->
			     <input type="hidden" name="whichPage"	value="<%=whichPage%>">               <!--送出當前是第幾頁給Controller-->
			    <input type="hidden" name="action"value="delete"></FORM>
			</td>
			<td>
			  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/front-end/adoptani_photo/adoptani_photo.do">
			    <input type="submit" value="顯示照片">
			    <input type="hidden" name="adopt_Ani_Id" value="${adoptaniVO.adopt_Ani_Id}">
			     <input type="hidden" name="requestURL"	value="<%=request.getServletPath()%>"><!--送出本網頁的路徑給Controller-->
			     <input type="hidden" name="whichPage"	value="<%=whichPage%>">               <!--送出當前是第幾頁給Controller-->
			    <input type="hidden" name="action"value="getOne_For_Display_From_listAllAdoptani.jsp"></FORM>
			</td>
			     
		</tr>
	</c:forEach>
</table>
<%@ include file="page2.file" %>


<br>本網頁的路徑:<br><b>
   <font color=blue>request.getServletPath():</font> <%= request.getServletPath()%><br>
   <font color=blue>request.getRequestURI(): </font> <%= request.getRequestURI()%> </b>
<br>




</body>
</html>