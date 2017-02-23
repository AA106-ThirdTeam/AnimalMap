<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<title>表格 JoinList: Home</title>
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
    <h3>表格 JoinList: Home</h3><font color=red>( MVC )</font>
    </td>
  </tr>
</table>
<hr>
<h2>揪團參加名單資料查詢:</h2>
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
  <li><a href='<%=request.getContextPath()%>/Heibernate_back-end/joinlist/listAllJoinList.jsp'>List</a> all JoinLists. </li> <br><br>
  <li>
    <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/Heibernate_back-end/joinlist/joinlist.do" >
        <b>輸入揪團參加名單編號 (如7001):</b>
        <input type="text" name="joinList_GrpId">
        <input type="submit" value="送出">
        <input type="hidden" name="action" value="getOne_For_Display">
    </FORM>
  </li>
  <jsp:useBean id="joinlistSvc" scope="page" class="heibernate_com.joinlist.model.JoinListService" />
  <li>
     <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/Heibernate_back-end/joinlist/joinlist.do" >
       <b>選擇揪團參加名單編號:</b>
       <select size="1" name="joinList_GrpId">
         <c:forEach var="joinlistVO" items="${joinlistSvc.all}" > 
          <option value="${joinlistVO.joinList_GrpId}">${joinlistVO.joinList_GrpId}
         </c:forEach>   
       </select>
       <input type="submit" value="送出">
       <input type="hidden" name="action" value="getOne_For_Display">
    </FORM>
  </li>
   <jsp:useBean id="pet_groupSvc" scope="page" class="heibernate_com.pet_group.model.Pet_groupService" />
  <li>
     <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/Heibernate_back-end/joinlist/joinlist.do" >
     	<div class="form-group">
	       <b><font color=orange>選擇活動編號:</font></b>
	       <select size="1" name="joinList_GrpId">
	         <c:forEach var="pet_groupVO" items="${pet_groupSvc.all}" > 
	          <option value="${pet_groupVO.grp_Id}">${pet_groupVO.grp_Id}
	         </c:forEach>   
	       </select>
	       <input type="submit" value="送出">
	       <input type="hidden" name="action" value="listJoinLists_ByGrp_Id_A">
       	</div>
     </FORM>
  </li>
   <jsp:useBean id="memSvc" scope="page" class="heibernate_com.mem.model.MemService" />
  <li>
     <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/Heibernate_back-end/joinlist/joinlist.do" >
     	<div class="form-group">
	       <b><font color=orange>選擇會員編號(參加者):</font></b>
	       <select size="1" name="joinList_MemId">
	         <c:forEach var="memVO" items="${memSvc.all}" > 
	          <option value="${memVO.mem_Id}">${memVO.mem_Id}
	         </c:forEach>   
	       </select>
	       <input type="submit" value="送出">
	       <input type="hidden" name="action" value="listJoinLists_ByMem_Id_A">
       	</div>
     </FORM>
  </li>
</ul>
<%-- 萬用複合查詢-以下欄位-可隨意增減 --%>
<ul>  
  <li>   
    <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/Heibernate_back-end/joinlist/joinlist.do" name="form1">
      <b><font color=blue>萬用複合查詢:</font></b> <br>
       <b>選擇活動編號編號:</b>
       <select size="1" name="joinList_GrpId">
         <c:forEach var="pet_groupVO" items="${pet_groupSvc.all}" > 
          <option value="${pet_groupVO.grp_Id}">${pet_groupVO.grp_Id}
         </c:forEach>   
       </select>
       <br> 
       <b>選擇會員編號(參加者)編號:</b>
       <select size="1" name="joinList_MemId">
         <c:forEach var="memVO" items="${memSvc.all}" > 
          <option value="${memVO.mem_Id}">${memVO.mem_Id}
         </c:forEach>   
       </select>
       <br> 
      <input type="submit" value="送出">
      <input type="hidden" name="action" value="list_ByCompositeQuery">
    </FORM>
  </li>
</ul>
<hr>
<!--  -->
<h3>揪團參加名單管理</h3>
<ul>
  <li><a href='<%=request.getContextPath()%>/Heibernate_back-end/joinlist/addJoinList.jsp'>Add</a> a new JoinList.</li>
</ul>
<!--  -->
	    <hr>
	    <h3><font color=orange>Pet_group管理</font></h3>
	    <ul>
	      <li><a href='<%=request.getContextPath()%>/Heibernate_back-end/pet_group/listAllPet_group.jsp'>List</a> all Pet_groups. </li>
	    </ul>
	    <hr>
	    <h3><font color=orange>Mem管理</font></h3>
	    <ul>
	      <li><a href='<%=request.getContextPath()%>/Heibernate_back-end/mem/listAllMem.jsp'>List</a> all Mems. </li>
	    </ul>
<!--  -->
</body>
</html>
