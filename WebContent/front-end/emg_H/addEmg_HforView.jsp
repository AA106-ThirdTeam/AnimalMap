<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.emg_H.model.*"%>

<%
Emg_HVO emg_HVO = (Emg_HVO) request.getAttribute("emg_HVO");

//從地圖Maker得來的  經緯度
String lat = request.getParameter("emg_H_Lat"); 
String lon = request.getParameter("emg_H_Lon");

%>



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css">

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>add emg_H</title>
</head>
<body>
	

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
	<br>
	<br>
	<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/front-end/emg_H/emg_H.do" name="form1"
		enctype="multipart/form-data" >
		<table border="0" >

			<tr >
				<td>上傳圖:</td>
				<td><input type="file" name="emg_H_pic" /></td>
			</tr>

 		<jsp:useBean id="memSvc" scope="page"	class="heibernate_com.mem.model.MemService" />
			<tr>
			<!--  利用留言表格裡的會員外來鍵 來找會員getOne的方法  join tomcat 7.0 以上 -->
				<td>
			  	 會員 : ${memSvc.getOneMem(emg_H_MsgVO.mem_Id).mem_name} 
				</td>
				<td><input type="TEXT" name="mem_Id" size="30" value="${account.mem_Id}" ></td>
			</tr>
			<tr>
				<td>求救標題:</td>
				<td><input type="TEXT" name="emg_H_title" size="30" id="emg_H_title"
<%-- 					value="<%= (emg_HVO==null)? "緊急求救需要幫忙!" : emg_HVO.getEmg_H_title() %>"  --%>
					></td>
			</tr>
			<tr>
				<td>縣市:</td>
				<td><input type="text" name="emg_H_city" size="30" id="emg_H_city"
<%-- 					value="<%= (emg_HVO==null)? "桃園市" : emg_HVO.getEmg_H_city() %>"  --%>
					>
				</td>
			</tr>
			<tr>
				<td>鄉鎮:</td>
				<td><input type="text" name="emg_H_town" size="30" id="emg_H_town"
<%-- 					value="<%= (emg_HVO==null)? "中壢區" : emg_HVO.getEmg_H_town() %>"  --%>
					>
				</td>
			</tr>

			<tr>
				<td>道路街道:</td>
				<td><input type="text" name="emg_H_road" size="30" id="emg_H_road"
<%-- 					value="<%= (emg_HVO==null)? "中央路185號" : emg_HVO.getEmg_H_road() %>"  --%>
					>
				</td>
			</tr>


			<tr>
				<td>經度:</td>
				<td><input type="text" name="emg_H_Lon" size="30" value="<%= (emg_HVO==null)? lat : emg_HVO.getEmg_H_Lon() %>" />
				</td>
			</tr>


			<tr>
				<td>緯度:</td>
				<td><input type="text" name="emg_H_Lat" size="30" value="<%= (emg_HVO==null)? lon : emg_HVO.getEmg_H_Lat() %>" />
				</td>
			</tr>

		</table>
		<br> 求救內容 <br>
		<textarea name="emg_H_content" cols="40" rows="5" maxlength="100" id="emg_H_content"
<%-- 			value="<%= (emg_HVO==null)? "" : emg_HVO.getEmg_H_content() %>" --%>
			>
		</textarea>

		<br> 
		<input type="hidden" name="action" value="insert_forView"> 
		<input type="submit" value="送出新增" class="btn btn-success" >
		
	
	</FORM>
	 	
	<button onclick="btn_magic()"></button>


	<script>
	 //神奇小按鈕
	function btn_magic(){
		
		$("#emg_H_title").val("這裡有緊急事件");
		$("#emg_H_city").val("桃園市");
		$("#emg_H_town").val("中壢區");
		$("#emg_H_road").val("中央路");
		$("#emg_H_content").val("這裡有隻小狗被困住了，需要有人來幫忙!!!");
		
	}
	
	</script>

</body>
</html>