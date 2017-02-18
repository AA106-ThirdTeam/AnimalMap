<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head><title>AnimalMAP AdoptAni: Home</title></head>
<body bgcolor='white'>

	<table border='1' cellpadding='5' cellspacing='0' width='400'>
		<tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
			<td><h3>AnimalMAP AdoptAni: Home</h3>	<font color=red>( MVC )</font></td></tr></table>

<p>This is the Home page for AnimalMAP AdoptAni: Home</p>

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
  <li><a href='listAllAdoptani.jsp'>List</a> all Adopt Animals. </li> <br><br>
  
  <li>
    <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/front-end/adoptani/adoptani.do" >
        <b>輸入送養動物編號 (如10000001):</b>
        <input type="text" name="adopt_Ani_Id">
        <input type="submit" value="送出">
        <input type="hidden" name="action" value="getOne_For_Display">
    </FORM>
  </li>

  <jsp:useBean id="adoptaniSvc" scope="page" class="com.adoptani.model.AdoptaniService" />
   
  <li>
     <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/front-end/adoptani/adoptani.do" >
       <b>選擇送養動物編號:</b>
       <select size="1" name="adopt_Ani_Id">
         <c:forEach var="adoptaniVO" items="${adoptaniSvc.all}" > 
          <option value="${adoptaniVO.adopt_Ani_Id}">${adoptaniVO.adopt_Ani_Id}
         </c:forEach>   
       </select>
       <input type="submit" value="送出">
       <input type="hidden" name="action" value="getOne_For_Display">
    </FORM>
  </li>
  
  <li>
     <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/front-end/adoptani/adoptani.do" >
       <b>選擇送養動物名字:</b>
       <select size="1" name="adopt_Ani_Id">
         <c:forEach var="adoptaniVO" items="${adoptaniSvc.all}" > 
          <option value="${adoptaniVO.adopt_Ani_Id}">${adoptaniVO.adopt_Ani_name}
         </c:forEach>   
       </select>
       <input type="submit" value="送出">
       <input type="hidden" name="action" value="getOne_For_Display">
     </FORM>
  </li>
</ul>


<h3>送養動物管理</h3>

<ul>
  <li><a href='addAdoptani.jsp'>Add</a> a new Adoptani.</li>
</ul>

</body>

</html>