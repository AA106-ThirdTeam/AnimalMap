<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<title>表格 Emg_H_Msg: Home</title>
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
    <h3>表格 Emg_H_Msg: Home</h3><font color=red>( MVC )</font>
    </td>
  </tr>
</table>
<hr>
<h2>緊急求救留言資料查詢:</h2>
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
  <li><a href='<%=request.getContextPath()%>/Heibernate_back-end/emg_h_msg/listAllEmg_H_Msg.jsp'>List</a> all Emg_H_Msgs. </li> <br><br>
  <li>
    <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/Heibernate_back-end/emg_h_msg/emg_h_msg.do" >
        <b>輸入緊急求救留言編號 (如7001):</b>
        <input type="text" name="emg_H_Msg_Id">
        <input type="submit" value="送出">
        <input type="hidden" name="action" value="getOne_For_Display">
    </FORM>
  </li>
  <jsp:useBean id="emg_h_msgSvc" scope="page" class="heibernate_com.emg_h_msg.model.Emg_H_MsgService" />
  <li>
     <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/Heibernate_back-end/emg_h_msg/emg_h_msg.do" >
       <b>選擇緊急求救留言編號:</b>
       <select size="1" name="emg_H_Msg_Id">
         <c:forEach var="emg_h_msgVO" items="${emg_h_msgSvc.all}" > 
          <option value="${emg_h_msgVO.emg_H_Msg_Id}">${emg_h_msgVO.emg_H_Msg_Id}
         </c:forEach>   
       </select>
       <input type="submit" value="送出">
       <input type="hidden" name="action" value="getOne_For_Display">
    </FORM>
  </li>
   <jsp:useBean id="memSvc" scope="page" class="heibernate_com.mem.model.MemService" />
  <li>
     <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/Heibernate_back-end/emg_h_msg/emg_h_msg.do" >
     	<div class="form-group">
	       <b><font color=orange>選擇留言會員編號:</font></b>
	       <select size="1" name="mem_Id">
	         <c:forEach var="memVO" items="${memSvc.all}" > 
	          <option value="${memVO.mem_Id}">${memVO.mem_Id}
	         </c:forEach>   
	       </select>
	       <input type="submit" value="送出">
	       <input type="hidden" name="action" value="listEmg_H_Msgs_ByMem_Id_A">
       	</div>
     </FORM>
  </li>
   <jsp:useBean id="emg_helpSvc" scope="page" class="heibernate_com.emg_help.model.Emg_HelpService" />
  <li>
     <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/Heibernate_back-end/emg_h_msg/emg_h_msg.do" >
     	<div class="form-group">
	       <b><font color=orange>選擇求救編號:</font></b>
	       <select size="1" name="emg_H_Id">
	         <c:forEach var="emg_helpVO" items="${emg_helpSvc.all}" > 
	          <option value="${emg_helpVO.emg_H_Id}">${emg_helpVO.emg_H_Id}
	         </c:forEach>   
	       </select>
	       <input type="submit" value="送出">
	       <input type="hidden" name="action" value="listEmg_H_Msgs_ByEmg_H_Id_A">
       	</div>
     </FORM>
  </li>
</ul>
<%-- 萬用複合查詢-以下欄位-可隨意增減 --%>
<ul>  
  <li>   
    <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/Heibernate_back-end/emg_h_msg/emg_h_msg.do" name="form1">
      <b><font color=blue>萬用複合查詢:</font></b> <br>
       <b>選擇緊急求救留言編號編號:</b>
       <select size="1" name="emg_H_Msg_Id">
            <option value=""/>
         <c:forEach var="emg_h_msgVO" items="${emg_h_msgSvc.all}" > 
          <option value="${emg_h_msgVO.emg_H_Msg_Id}">${emg_h_msgVO.emg_H_Msg_Id}
         </c:forEach>   
       </select>   
       <br>  
       <b>選擇留言會員編號編號:</b>
       <select size="1" name="mem_Id">
         <c:forEach var="memVO" items="${memSvc.all}" > 
          <option value="${memVO.mem_Id}">${memVO.mem_Id}
         </c:forEach>   
       </select>
       <br> 
       <b>選擇求救編號編號:</b>
       <select size="1" name="emg_H_Id">
         <c:forEach var="emg_HelpVO" items="${emg_HelpSvc.all}" > 
          <option value="${emg_HelpVO.emg_H_Id}">${emg_HelpVO.emg_H_Id}
         </c:forEach>   
       </select>
       <br> 
        <b>發布時間:</b>
        <input class="cal-TextBox" onFocus="this.blur()" size="9" readonly type="text" name="emg_H_Msg_start" value="">
        <a class="so-BtnLink" href="javascript:calClick();return false;" 
        	onmouseover="calSwapImg('BTN_date', 'img_Date_OVER',true);" 
        	onmouseout="calSwapImg('BTN_date', 'img_Date_UP',true);" 
        	onclick="calSwapImg('BTN_date', 'img_Date_DOWN');showCalendar('form1','emg_H_Msg_start','BTN_date');return false;"
        >
            <img align="middle" border="0" name="BTN_date"  src="<%=request.getContextPath()%>/Heibernate_back-end/images/btn_date_up.gif" width="22" height="17" alt="發布時間">
        </a>
        <br>
      <input type="submit" value="送出">
      <input type="hidden" name="action" value="list_ByCompositeQuery">
    </FORM>
  </li>
</ul>
<hr>
<!--  -->
<h3>緊急求救留言管理</h3>
<ul>
  <li><a href='<%=request.getContextPath()%>/Heibernate_back-end/emg_h_msg/addEmg_H_Msg.jsp'>Add</a> a new Emg_H_Msg.</li>
</ul>
<!--  -->
	    <hr>
	    <h3><font color=orange>Mem管理</font></h3>
	    <ul>
	      <li><a href='<%=request.getContextPath()%>/Heibernate_back-end/mem/listAllMem.jsp'>List</a> all Mems. </li>
	    </ul>
	    <hr>
	    <h3><font color=orange>Emg_Help管理</font></h3>
	    <ul>
	      <li><a href='<%=request.getContextPath()%>/Heibernate_back-end/emg_help/listAllEmg_Help.jsp'>List</a> all Emg_Helps. </li>
	    </ul>
<!--  -->
</body>
</html>
