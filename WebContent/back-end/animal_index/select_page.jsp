<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<title>表格 Animal_index: Home</title>
	
	<!-- 共用HEAD -->
	
	<!-- BS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script src="https://code.jquery.com/jquery.js"></script>
	
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/back-end/css/calendar.css">
	<%@include file="/back-end/js/calendarcode.jsp"%>
</head>

<body bgcolor='white'>
<div id="popupcalendar" class="text"></div>

<table class="table"  border='1' cellpadding='5' cellspacing='0' width='400'>
  <tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
    <td>
    <h3>表格 Animal_index: Home</h3><font color=red>( MVC )</font>
    </td>
  </tr>
</table>

<hr>

<h2>動物圖鑑資料查詢:</h2>
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
<!--  -->
<ul>
  <li><a href='<%=request.getContextPath()%>/back-end/animal_index/listAllAnimal_index.jsp'>List</a> all Animal_indexs. </li> <br><br>
  
  <li>
    <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/back-end/animal_index/animal_index.do" >
        <b>輸入動物圖鑑編號 (如7001):</b>
        <input type="text" name="animal_No">
        <input type="submit" value="送出">
        <input type="hidden" name="action" value="getOne_For_Display">
    </FORM>
  </li>

  <jsp:useBean id="animal_indexSvc" scope="page" class="com.animal_index.model.Animal_indexService" />

  <li>
     <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/back-end/animal_index/animal_index.do" >
       <b>選擇動物圖鑑編號:</b>
       <select size="1" name="animal_No">
         <c:forEach var="animal_indexVO" items="${animal_indexSvc.all}" > 
          <option value="${animal_indexVO.animal_No}">${animal_indexVO.animal_No}
         </c:forEach>   
       </select>
       <input type="submit" value="送出">
       <input type="hidden" name="action" value="getOne_For_Display">
    </FORM>
  </li>



</ul>



<%-- 萬用複合查詢-以下欄位-可隨意增減 --%>
<ul>  
  <li>   
    <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/back-end/animal_index/animal_index.do" name="form1">
      <b><font color=blue>萬用複合查詢:</font></b> <br>

       <b>選擇圖鑑編號編號:</b>
       <select size="1" name="animal_No">
            <option value=""/>
         <c:forEach var="animal_indexVO" items="${animal_indexSvc.all}" > 
          <option value="${animal_indexVO.animal_No}">${animal_indexVO.animal_No}
         </c:forEach>   
       </select>   
       <br>  

      <input type="submit" value="送出">
      <input type="hidden" name="action" value="listAnimal_indexs_ByCompositeQuery">
    </FORM>
  </li>
</ul>

<hr>

<!--  -->
<h3>動物圖鑑管理</h3>

<ul>
  <li><a href='<%=request.getContextPath()%>/back-end/animal_index/addAnimal_index.jsp'>Add</a> a new Animal_index.</li>
</ul>

<!--  -->
	    		

<!--  -->

</body>

</html>
