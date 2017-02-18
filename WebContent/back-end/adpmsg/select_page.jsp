<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<title>表格 AdpMsg: Home</title>
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
    <h3>表格 AdpMsg: Home</h3><font color=red>( MVC )</font>
    </td>
  </tr>
</table>
<hr>
<h2>領養活動留言資料查詢:</h2>
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
  <li><a href='<%=request.getContextPath()%>/back-end/adpmsg/listAllAdpMsg.jsp'>List</a> all AdpMsgs. </li> <br><br>
  <li>
    <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/back-end/adpmsg/adpmsg.do" >
        <b>輸入領養活動留言編號 (如7001):</b>
        <input type="text" name="adpMsg_Id">
        <input type="submit" value="送出">
        <input type="hidden" name="action" value="getOne_For_Display">
    </FORM>
  </li>
  <jsp:useBean id="adpmsgSvc" scope="page" class="heibernate_com.adpmsg.model.AdpMsgService" />
  <li>
     <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/back-end/adpmsg/adpmsg.do" >
       <b>選擇領養活動留言編號:</b>
       <select size="1" name="adpMsg_Id">
         <c:forEach var="adpmsgVO" items="${adpmsgSvc.all}" > 
          <option value="${adpmsgVO.adpMsg_Id}">${adpmsgVO.adpMsg_Id}
         </c:forEach>   
       </select>
       <input type="submit" value="送出">
       <input type="hidden" name="action" value="getOne_For_Display">
    </FORM>
  </li>
   <jsp:useBean id="adpSvc" scope="page" class="heibernate_com.adp.model.AdpService" />
  <li>
     <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/back-end/adpmsg/adpmsg.do" >
     	<div class="form-group">
	       <b><font color=orange>選擇領養活動編號:</font></b>
	       <select size="1" name="adp_Id">
	         <c:forEach var="adpVO" items="${adpSvc.all}" > 
	          <option value="${adpVO.adp_Id}">${adpVO.adp_Id}
	         </c:forEach>   
	       </select>
	       <input type="submit" value="送出">
	       <input type="hidden" name="action" value="listAdpMsgs_ByAdp_Id_A">
       	</div>
     </FORM>
  </li>
   <jsp:useBean id="memSvc" scope="page" class="heibernate_com.mem.model.MemService" />
  <li>
     <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/back-end/adpmsg/adpmsg.do" >
     	<div class="form-group">
	       <b><font color=orange>選擇留言會員編號:</font></b>
	       <select size="1" name="mem_Id">
	         <c:forEach var="memVO" items="${memSvc.all}" > 
	          <option value="${memVO.mem_Id}">${memVO.mem_Id}
	         </c:forEach>   
	       </select>
	       <input type="submit" value="送出">
	       <input type="hidden" name="action" value="listAdpMsgs_ByMem_Id_A">
       	</div>
     </FORM>
  </li>
</ul>
<hr>
<!--  -->
<h3>領養活動留言管理</h3>
<ul>
  <li><a href='<%=request.getContextPath()%>/back-end/adpmsg/addAdpMsg.jsp'>Add</a> a new AdpMsg.</li>
</ul>
<!--  -->
	    <hr>
	    <h3><font color=orange>Adp管理</font></h3>
	    <ul>
	      <li><a href='<%=request.getContextPath()%>/back-end/adp/listAllAdp.jsp'>List</a> all Adps. </li>
	    </ul>
	    <hr>
	    <h3><font color=orange>Mem管理</font></h3>
	    <ul>
	      <li><a href='<%=request.getContextPath()%>/back-end/mem/listAllMem.jsp'>List</a> all Mems. </li>
	    </ul>
<!--  -->
</body>
</html>
