<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head><title>表格 JoinList: Home</title></head>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/js/calendar.css">
<%@include file="/js/calendarcode.jsp"%>
<div id="popupcalendar" class="text"></div>
<body bgcolor='white'>

<table border='1' cellpadding='5' cellspacing='0' width='400'>
  <tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
    <td>
    <h3>表格 JoinList: Home</h3><font color=red>( MVC )</font>
        <a href="<%=request.getContextPath()%>/select_page.jsp"><img src="<%=request.getContextPath()%>/images/back1.gif" width="100" height="32" border="0">回首頁</a>
    </td>
  </tr>
</table>

<p>This is the Home page for JoinList: Home</p>

<hr>

<h3>揪團參加名單資料查詢:</h3>
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
  <li><a href='<%=request.getContextPath()%>/joinlist/listAllJoinList.jsp'>List</a> all JoinLists. </li> <br><br>
  
  <li>
    <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/joinlist/joinlist.do" >
        <b>輸入揪團參加名單編號 (如7001):</b>
        <input type="text" name="{PK英文名稱}">
        <input type="submit" value="送出">
        <input type="hidden" name="action" value="getOne_For_Display">
    </FORM>
  </li>

  <jsp:useBean id="joinlistSvc" scope="page" class="com.joinlist.model.JoinListService" />

  <li>
     <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/joinlist/joinlist.do" >
       <b>選擇揪團參加名單編號:</b>
       <select size="1" name="{PK英文名稱}">
         <c:forEach var="joinlistVO" items="${joinlistSvc.all}" > 
          <option value="${joinlistVO.{PK英文名稱}}">${joinlistVO.{PK英文名稱}}
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
    <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/joinlist/joinlist.do" name="form1">
      <b><font color=blue>萬用複合查詢:</font></b> <br>
        









        










      <input type="submit" value="送出">
      <input type="hidden" name="action" value="listEmps_ByCompositeQuery">
    </FORM>
  </li>
</ul>

<hr>

<!--  -->
<h3>揪團參加名單管理</h3>

<ul>
  <li><a href='<%=request.getContextPath()%>/joinlist/addJoinList.jsp'>Add</a> a new JoinList.</li>
</ul>

<!--  -->


    <hr>

    <h3><font color=orange>揪團管理</font></h3>

    <ul>
      <li><a href='<%=request.getContextPath()%>/pet_group/listAllPet_group.jsp'>List</a> all Pet_groups. </li>
    </ul>

    <hr>

    <h3><font color=orange>一般會員管理</font></h3>

    <ul>
      <li><a href='<%=request.getContextPath()%>/mem/listAllMem.jsp'>List</a> all Mems. </li>
    </ul>



<!--  -->

</body>

</html>
