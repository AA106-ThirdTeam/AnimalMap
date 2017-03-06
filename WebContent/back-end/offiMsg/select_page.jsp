 <%@ page contentType="text/html; charset=UTF-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.offiMsg.model.*" %>
<%@ page import="com.offiMsg.controller.*" %>


<html>
<head><title>IBM offiMsg: Home</title></head>
<body bgcolor='white'>

<table border='1' cellpadding='5' cellspacing='0' width='400'>
  <tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
  
    <td><h3>IBM offiMsg : Home</h3><font color=red>( MVC )</font></td>
  </tr>
</table>

<p>This is the Home page for IBM offiMsg: Home</p>

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
  <li><a href='<%=request.getContextPath()%>/back-end/offiMsg/listAllOffiMsg.jsp'>List</a> all offiMsg. </li> 
  <br>
<jsp:useBean id="offiMsgSvc" scope="page" class="com.offiMsg.model.OffiMsgService"/>
 <br>
  <br> 
  <li>
    <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/back-end/offiMsg/offiMsg.do" >
        <b>輸入系統訊息編號 (如22000000):</b>
        <input type="text" name="offiMsg_Id">
        <input type="submit" value="送出">
        <input type="hidden" name="action" value="getOne_For_Display">
    </FORM>
  </li>`

   
  <li>
     <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/back-end/offiMsg/offiMsg.do" >
       <b>選擇系統訊息編號:</b>
       <select size="1" name="offiMsg_Id">
         <c:forEach var="offiMsgVO" items="${offiMsgSvc.all}" > 
          <option value="${offiMsgVO.offiMsg_Id}">${offiMsgVO.offiMsg_Id}
         </c:forEach>   
       </select>
       <input type="submit" value="送出">
       <input type="hidden" name="action" value="getOne_For_Display">
    </FORM>
  </li>
</ul>

 

<!-- <h3><font color=orange>系統訊息管理</font></h3> -->

<!-- <ul> -->
<%--   <li><a href='<%=request.getContextPath()%>/back-end/offiMsg/listAllOffiMsg.jsp'>List</a> all OffiMsgs. </li> --%>
<!-- </ul> -->

</body>

</html>
