<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.strayani_photo.model.*"%>
<%-- 此頁練習採用 EL 的寫法取值 --%>

<%

 	List<StrayaniPhotoVO> list = (List) request.getAttribute("oneStrayAniPhotoList");
	pageContext.setAttribute("list",list);	//如果沒有setAttribute，JLTS的for each就沒辦法跑。
%>

<html>
<head>
<title>所有送養動物照片 - listOneStrayani.jsp</title>
</head>
<body bgcolor='white'>
<b><font color=red>此頁練習採用 EL 的寫法取值:</font></b>
<table border='1' cellpadding='5' cellspacing='0' width='800'>
	<tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
		<td>
		<h3>所有送養動物照片 - listAllStrayaniPhoto.jsp</h3>
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
		<th>送養動物照片編號</th>
		<th>送養動物編號</th>
		<th>發布者會員編號</th>
		<th>送養動物照片</th>
		<th>送養動物照片名稱</th>
		<th>送養動物照片副檔名</th>
		<th>送養動物照片上傳時間</th>
		<th>送養動物照片類型</th>
		

	</tr>
	<%@ include file="page1.file" %> 
	<c:forEach var="strayaniPhotoVO" items="${list}" begin="<%=pageIndex%>" end="<%=pageIndex+rowsPerPage-1%>">
		<tr align='center' valign='middle'>
			
			<td>${strayaniPhotoVO.str_Ani_Pic_No}</td> 
			<td>${strayaniPhotoVO.stray_Ani_Id}</td>
			<td>${strayaniPhotoVO.mem_Id}</td>
			<td height=200px width=200px style="table-layout:fixed"><div><img onload="javascript:this.resized=true;this.style.width=300;" src="<%=request.getContextPath()%>/front-end/DBGifReader_StrayaniPhoto/DBGifReader_StrayaniPhoto.do?str_Ani_Pic_No=${strayaniPhotoVO.str_Ani_Pic_No}"></div></td>
			<td>${strayaniPhotoVO.stray_Pic_name}</td>
			<td>${strayaniPhotoVO.stray_Pic_nameEX}</td>
			<td>${strayaniPhotoVO.stray_Pic_time}</td>
			<td>${strayaniPhotoVO.stray_Pic_type}</td>

   
			<td>
			  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/front-end/strayani_photo/strayani_photo.do">
			     <input type="submit" value="修改">
			     <input type="hidden" name="str_Ani_Pic_No" value="${strayaniPhotoVO.str_Ani_Pic_No}">
			     <input type="hidden" name="action"	value="getOne_For_Update"></FORM>
			     
			</td>
			<td>
			  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/front-end/strayani_photo/strayani_photo.do">
			    <input type="submit" value="刪除">
			    <input type="hidden" name="str_Ani_Pic_No" value="${strayaniPhotoVO.str_Ani_Pic_No}">
			    <input type="hidden" name="action"value="delete"></FORM>
			</td>
		</tr>
	</c:forEach>
</table>
<%@ include file="page2.file" %>

</body>
</html>