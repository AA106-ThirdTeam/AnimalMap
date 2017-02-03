<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head><title>表格 Second_ProdPhotos: Home</title></head>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/js/calendar.css">
<%@include file="/js/calendarcode.jsp"%>
<div id="popupcalendar" class="text"></div>
<body bgcolor='white'>

<table border='1' cellpadding='5' cellspacing='0' width='400'>
  <tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
    <td>
    <h3>表格 Second_ProdPhotos: Home</h3><font color=red>( MVC )</font>
        <a href="<%=request.getContextPath()%>/select_page.jsp"><img src="<%=request.getContextPath()%>/images/back1.gif" width="100" height="32" border="0">回首頁</a>
    </td>
  </tr>
</table>

<p>This is the Home page for Second_ProdPhotos: Home</p>

<hr>

<h3>二手商品相簿資料查詢:</h3>
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
  <li><a href='<%=request.getContextPath()%>/second_prodphotos/listAllSecond_ProdPhotos.jsp'>List</a> all Second_ProdPhotoss. </li> <br><br>
  
  <li>
    <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/second_prodphotos/second_prodphotos.do" >
        <b>輸入二手商品相簿編號 (如7001):</b>
        <input type="text" name="second_ProdPhotos_Id">
        <input type="submit" value="送出">
        <input type="hidden" name="action" value="getOne_For_Display">
    </FORM>
  </li>

  <jsp:useBean id="second_prodphotosSvc" scope="page" class="com.second_prodphotos.model.Second_ProdPhotosService" />

  <li>
     <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/second_prodphotos/second_prodphotos.do" >
       <b>選擇二手商品相簿編號:</b>
       <select size="1" name="second_ProdPhotos_Id">
         <c:forEach var="second_prodphotosVO" items="${second_prodphotosSvc.all}" > 
          <option value="${second_prodphotosVO.second_ProdPhotos_Id}">${second_prodphotosVO.second_ProdPhotos_Id}
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
    <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/second_prodphotos/second_prodphotos.do" name="form1">
      <b><font color=blue>萬用複合查詢:</font></b> <br>
       <b>選擇二手商品相簿編號編號:</b>
       <select size="1" name="second_ProdPhotos_Id">
         <c:forEach var="second_prodphotosVO" items="${second_prodphotosSvc.all}" > 
          <option value="${second_prodphotosVO.second_ProdPhotos_Id}">${second_prodphotosVO.second_ProdPhotos_Id}
         </c:forEach>   
       </select>   
       <br>     
        










      <input type="submit" value="送出">
      <input type="hidden" name="action" value="listEmps_ByCompositeQuery">
    </FORM>
  </li>
</ul>

<hr>

<!--  -->
<h3>二手商品相簿管理</h3>

<ul>
  <li><a href='<%=request.getContextPath()%>/second_prodphotos/addSecond_ProdPhotos.jsp'>Add</a> a new Second_ProdPhotos.</li>
</ul>

<!--  -->


    <hr>

    <h3><font color=orange>二手商品管理</font></h3>

    <ul>
      <li><a href='<%=request.getContextPath()%>/second_prod/listAllSecond_Prod.jsp'>List</a> all Second_Prods. </li>
    </ul>



<!--  -->

</body>

</html>
