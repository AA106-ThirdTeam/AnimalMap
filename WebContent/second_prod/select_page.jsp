<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head><title>表格 Second_Prod: Home</title></head>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/js/calendar.css">
<%@include file="/js/calendarcode.jsp"%>
<div id="popupcalendar" class="text"></div>
<body bgcolor='white'>

<table border='1' cellpadding='5' cellspacing='0' width='400'>
  <tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
    <td><h3>表格 Second_Prod: Home</h3><font color=red>( MVC )</font></td>
  </tr>
</table>

<p>This is the Home page for Second_Prod: Home</p>

<hr>

<h3>二手商品資料查詢:</h3>
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
  <li><a href='<%=request.getContextPath()%>/second_prod/listAllSecond_Prod.jsp'>List</a> all Second_Prods. </li> <br><br>
  
  <li>
    <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/second_prod/second_prod.do" >
        <b>輸入二手商品編號 (如7001):</b>
        <input type="text" name="second_Prod_Id">
        <input type="submit" value="送出">
        <input type="hidden" name="action" value="getOne_For_Display">
    </FORM>
  </li>

  <jsp:useBean id="second_prodSvc" scope="page" class="com.second_prod.model.Second_ProdService" />

  <li>
     <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/second_prod/second_prod.do" >
       <b>選擇二手商品編號:</b>
       <select size="1" name="second_Prod_Id">
         <c:forEach var="second_prodVO" items="${second_prodSvc.all}" > 
          <option value="${second_prodVO.second_Prod_Id}">${second_prodVO.second_Prod_Id}
         </c:forEach>   
       </select>
       <input type="submit" value="送出">
       <input type="hidden" name="action" value="getOne_For_Display">
    </FORM>
  </li>

</ul>

<hr>

<!--  -->
<h3>二手商品管理</h3>

<ul>
  <li><a href='<%=request.getContextPath()%>/second_prod/addSecond_Prod.jsp'>Add</a> a new Second_Prod.</li>
</ul>

<!--  -->

</body>

</html>
