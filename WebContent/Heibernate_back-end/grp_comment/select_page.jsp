<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<title>表格 Grp_comment: Home</title>
	<!-- 共用HEAD -->
	<!-- BS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script src="https://code.jquery.com/jquery.js"></script>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/Heibernate_back-end/css/calendar.css">
	<%@include file="/Heibernate_back-end/js/calendarcode.jsp"%>
</head>
<body bgcolor='white'>
<div id="popupcalendar" class="text"></div>
<table class="table"  border='1' cellpadding='5' cellspacing='0' width='400'>
  <tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
    <td>
    <h3>表格 Grp_comment: Home</h3><font color=red>( MVC )</font>
    </td>
  </tr>
</table>
<hr>
<h2>揪團留言資料查詢:</h2>
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
  <li><a href='<%=request.getContextPath()%>/Heibernate_back-end/grp_comment/listAllGrp_comment.jsp'>List</a> all Grp_comments. </li> <br><br>
  <li>
    <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/Heibernate_back-end/grp_comment/grp_comment.do" >
        <b>輸入揪團留言編號 (如7001):</b>
        <input type="text" name="grpComment_Id">
        <input type="submit" value="送出">
        <input type="hidden" name="action" value="getOne_For_Display">
    </FORM>
  </li>
  <jsp:useBean id="grp_commentSvc" scope="page" class="heibernate_com.grp_comment.model.Grp_commentService" />
  <li>
     <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/Heibernate_back-end/grp_comment/grp_comment.do" >
       <b>選擇揪團留言編號:</b>
       <select size="1" name="grpComment_Id">
         <c:forEach var="grp_commentVO" items="${grp_commentSvc.all}" > 
          <option value="${grp_commentVO.grpComment_Id}">${grp_commentVO.grpComment_Id}
         </c:forEach>   
       </select>
       <input type="submit" value="送出">
       <input type="hidden" name="action" value="getOne_For_Display">
    </FORM>
  </li>
   <jsp:useBean id="memSvc" scope="page" class="heibernate_com.mem.model.MemService" />
  <li>
     <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/Heibernate_back-end/grp_comment/grp_comment.do" >
     	<div class="form-group">
	       <b><font color=orange>選擇發送會員編號:</font></b>
	       <select size="1" name="grpComment_MemId">
	         <c:forEach var="memVO" items="${memSvc.all}" > 
	          <option value="${memVO.mem_Id}">${memVO.mem_Id}
	         </c:forEach>   
	       </select>
	       <input type="submit" value="送出">
	       <input type="hidden" name="action" value="listGrp_comments_ByMem_Id_A">
       	</div>
     </FORM>
  </li>
   <jsp:useBean id="petgroupSvc" scope="page" class="heibernate_com.petgroup.model.PetGroupService" />
  <li>
     <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/Heibernate_back-end/grp_comment/grp_comment.do" >
     	<div class="form-group">
	       <b><font color=orange>選擇揪團編號:</font></b>
	       <select size="1" name="grpComment_GrpId">
	         <c:forEach var="petgroupVO" items="${petgroupSvc.all}" > 
	          <option value="${petgroupVO.grp_Id}">${petgroupVO.grp_Id}
	         </c:forEach>   
	       </select>
	       <input type="submit" value="送出">
	       <input type="hidden" name="action" value="listGrp_comments_ByGrp_Id_A">
       	</div>
     </FORM>
  </li>
</ul>
<%-- 萬用複合查詢-以下欄位-可隨意增減 --%>
<ul>  
  <li>   
    <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/Heibernate_back-end/grp_comment/grp_comment.do" name="form1">
      <b><font color=blue>萬用複合查詢:</font></b> <br>
       <b>選擇揪團留言編號編號:</b>
       <select size="1" name="grpComment_Id">
            <option value=""/>
         <c:forEach var="grp_commentVO" items="${grp_commentSvc.all}" > 
          <option value="${grp_commentVO.grpComment_Id}">${grp_commentVO.grpComment_Id}
         </c:forEach>   
       </select>   
       <br>  
       <b>選擇發送會員編號編號:</b>
       <select size="1" name="grpComment_MemId">
         <c:forEach var="memVO" items="${memSvc.all}" > 
          <option value="${memVO.mem_Id}">${memVO.mem_Id}
         </c:forEach>   
       </select>
       <br> 
       <b>選擇揪團編號編號:</b>
       <select size="1" name="grpComment_GrpId">
         <c:forEach var="petGroupVO" items="${petGroupSvc.all}" > 
          <option value="${petGroupVO.grp_Id}">${petGroupVO.grp_Id}
         </c:forEach>   
       </select>
       <br> 
        <b>發送時間:</b>
        <input class="cal-TextBox" onFocus="this.blur()" size="9" readonly type="text" name="grpComment_SendTime" value="">
        <a class="so-BtnLink" href="javascript:calClick();return false;" 
        	onmouseover="calSwapImg('BTN_date', 'img_Date_OVER',true);" 
        	onmouseout="calSwapImg('BTN_date', 'img_Date_UP',true);" 
        	onclick="calSwapImg('BTN_date', 'img_Date_DOWN');showCalendar('form1','grpComment_SendTime','BTN_date');return false;"
        >
            <img align="middle" border="0" name="BTN_date"  src="<%=request.getContextPath()%>/Heibernate_back-end/images/btn_date_up.gif" width="22" height="17" alt="發送時間">
        </a>
        <br>
      <input type="submit" value="送出">
      <input type="hidden" name="action" value="list_ByCompositeQuery">
    </FORM>
  </li>
</ul>
<hr>
<!--  -->
<h3>揪團留言管理</h3>
<ul>
  <li><a href='<%=request.getContextPath()%>/Heibernate_back-end/grp_comment/addGrp_comment.jsp'>Add</a> a new Grp_comment.</li>
</ul>
<!--  -->
	    <hr>
	    <h3><font color=orange>Mem管理</font></h3>
	    <ul>
	      <li><a href='<%=request.getContextPath()%>/Heibernate_back-end/mem/listAllMem.jsp'>List</a> all Mems. </li>
	    </ul>
	    <hr>
	    <h3><font color=orange>PetGroup管理</font></h3>
	    <ul>
	      <li><a href='<%=request.getContextPath()%>/Heibernate_back-end/petgroup/listAllPetGroup.jsp'>List</a> all PetGroups. </li>
	    </ul>
<!--  -->
</body>
</html>
