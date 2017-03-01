<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<jsp:useBean id="AdoptaniMessageSvc" scope="page" class="com.adoptani_message.model.AdoptaniMessageService" />


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head><title>AnimalMAP AdoptAni Message: Home</title></head>
<body bgcolor='white'>

	<table border='1' cellpadding='5' cellspacing='0' width='400'>
		<tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
			<td><h3>AnimalMAP AdoptAni: Home</h3>	<font color=red>( MVC )</font></td></tr></table>

<p>This is the Home page for AnimalMAP AdoptAni Message: Home</p>

<h3>資料查詢:</h3>
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

<ul>
  <li><a href='listAllAdoptaniMessage.jsp'>List</a> all Adopt Animal's Message. </li> <br><br>
  
  <li>
    <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/front-end/adoptani_message/AdoptaniMessageServlet.do" >
        <b>輸入送養動物留言編號 (如42000001):</b>
        <input type="text" name="ado_Ani_Mes_No">
        <input type="submit" value="送出">
        <input type="hidden" name="action" value="getOne_For_Display">
    </FORM>
  </li>

  
   
  <li>
     <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/front-end/adoptani_message/AdoptaniMessageServlet.do" >
       <b>選擇送養動物留言編號:</b>
       <select size="1" name="ado_Ani_Mes_No">
         <c:forEach var="adoptaniMessageVO" items="${AdoptaniMessageSvc.allMessage}" > 
          <option value="${adoptaniMessageVO.ado_Ani_Mes_No}">${adoptaniMessageVO.ado_Ani_Mes_No}
         </c:forEach>   
       </select>
       <input type="submit" value="送出">
       <input type="hidden" name="action" value="getOne_For_Display">
    </FORM>
  </li>
  
    <li>
     <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/front-end/adoptani_message/AdoptaniMessageServlet.do" >
       <b>選擇送養動物編號:</b>
       <select size="1" name="adopt_Ani_Id">
         <c:forEach var="adoptaniMessageVO" items="${AdoptaniMessageSvc.allMessage}" > 
          <option value="${adoptaniMessageVO.adopt_Ani_Id}">${adoptaniMessageVO.adopt_Ani_Id}
         </c:forEach>   
       </select>
       <input type="submit" value="送出">
       <input type="hidden" name="action" value="getOneAni_For_DisplayAll">
    </FORM>
  </li>
  


<h3>送養動物管理</h3>

<ul>
  <li><a href='addAdoptaniMessage.jsp'>Add</a> a new Adoptani.</li>
</ul>

</body>

</html>