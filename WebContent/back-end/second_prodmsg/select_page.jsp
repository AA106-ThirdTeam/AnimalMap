<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<title>表格 Second_ProdMsg: Home</title>
	
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
    <h3>表格 Second_ProdMsg: Home</h3><font color=red>( MVC )</font>
    </td>
  </tr>
</table>

<hr>

<h2>二手商品留言資料查詢:</h2>
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
  <li><a href='<%=request.getContextPath()%>/back-end/second_prodmsg/listAllSecond_ProdMsg.jsp'>List</a> all Second_ProdMsgs. </li> <br><br>
  
  <li>
    <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/back-end/second_prodmsg/second_prodmsg.do" >
        <b>輸入二手商品留言編號 (如7001):</b>
        <input type="text" name="second_ProdMsg_Id">
        <input type="submit" value="送出">
        <input type="hidden" name="action" value="getOne_For_Display">
    </FORM>
  </li>

  <jsp:useBean id="second_prodmsgSvc" scope="page" class="com.second_prodmsg.model.Second_ProdMsgService" />

  <li>
     <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/back-end/second_prodmsg/second_prodmsg.do" >
       <b>選擇二手商品留言編號:</b>
       <select size="1" name="second_ProdMsg_Id">
         <c:forEach var="second_prodmsgVO" items="${second_prodmsgSvc.all}" > 
          <option value="${second_prodmsgVO.second_ProdMsg_Id}">${second_prodmsgVO.second_ProdMsg_Id}
         </c:forEach>   
       </select>
       <input type="submit" value="送出">
       <input type="hidden" name="action" value="getOne_For_Display">
    </FORM>
  </li>


   <jsp:useBean id="second_prodSvc" scope="page" class="com.second_prod.model.Second_ProdService" />

  <li>
     <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/back-end/second_prodmsg/second_prodmsg.do" >
     	<div class="form-group">
	       <b><font color=orange>選擇二手商品編號:</font></b>
	       <select size="1" name="second_Prod_Id">
	         <c:forEach var="second_prodVO" items="${second_prodSvc.all}" > 
	          <option value="${second_prodVO.second_Prod_Id}">${second_prodVO.second_Prod_Id}
	         </c:forEach>   
	       </select>
	       <input type="submit" value="送出">
	       <input type="hidden" name="action" value="listSecond_ProdMsgs_BySecond_Prod_Id_A">
       	</div>
     </FORM>
  </li>

   <jsp:useBean id="memSvc" scope="page" class="com.mem.model.MemService" />

  <li>
     <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/back-end/second_prodmsg/second_prodmsg.do" >
     	<div class="form-group">
	       <b><font color=orange>選擇留言會員編號:</font></b>
	       <select size="1" name="mem_Id">
	         <c:forEach var="memVO" items="${memSvc.all}" > 
	          <option value="${memVO.mem_Id}">${memVO.mem_Id}
	         </c:forEach>   
	       </select>
	       <input type="submit" value="送出">
	       <input type="hidden" name="action" value="listSecond_ProdMsgs_ByMem_Id_A">
       	</div>
     </FORM>
  </li>


</ul>



<%-- 萬用複合查詢-以下欄位-可隨意增減 --%>
<ul>  
  <li>   
    <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/back-end/second_prodmsg/second_prodmsg.do" name="form1">
      <b><font color=blue>萬用複合查詢:</font></b> <br>

       <b>選擇二手商品留言編號編號:</b>
       <select size="1" name="second_ProdMsg_Id">
            <option value=""/>
         <c:forEach var="second_prodmsgVO" items="${second_prodmsgSvc.all}" > 
          <option value="${second_prodmsgVO.second_ProdMsg_Id}">${second_prodmsgVO.second_ProdMsg_Id}
         </c:forEach>   
       </select>   
       <br>  

       <b>選擇二手商品編號編號:</b>
       <select size="1" name="second_Prod_Id">
         <c:forEach var="second_ProdVO" items="${second_ProdSvc.all}" > 
          <option value="${second_ProdVO.second_Prod_Id}">${second_ProdVO.second_Prod_Id}
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

        <b>留言發布日期:</b>
        <input class="cal-TextBox" onFocus="this.blur()" size="9" readonly type="text" name="second_ProdMsg_DATE" value="">
        <a class="so-BtnLink" href="javascript:calClick();return false;" 
        	onmouseover="calSwapImg('BTN_date', 'img_Date_OVER',true);" 
        	onmouseout="calSwapImg('BTN_date', 'img_Date_UP',true);" 
        	onclick="calSwapImg('BTN_date', 'img_Date_DOWN');showCalendar('form1','second_ProdMsg_DATE','BTN_date');return false;"
        >
            <img align="middle" border="0" name="BTN_date"  src="<%=request.getContextPath()%>/back-end/images/btn_date_up.gif" width="22" height="17" alt="留言發布日期">
        </a>
        <br>

        <b>留言更新日期:</b>
        <input class="cal-TextBox" onFocus="this.blur()" size="9" readonly type="text" name="second_ProdMsg_adp_upDate" value="">
        <a class="so-BtnLink" href="javascript:calClick();return false;" 
        	onmouseover="calSwapImg('BTN_date', 'img_Date_OVER',true);" 
        	onmouseout="calSwapImg('BTN_date', 'img_Date_UP',true);" 
        	onclick="calSwapImg('BTN_date', 'img_Date_DOWN');showCalendar('form1','second_ProdMsg_adp_upDate','BTN_date');return false;"
        >
            <img align="middle" border="0" name="BTN_date"  src="<%=request.getContextPath()%>/back-end/images/btn_date_up.gif" width="22" height="17" alt="留言更新日期">
        </a>
        <br>

      <input type="submit" value="送出">
      <input type="hidden" name="action" value="listSecond_ProdMsgs_ByCompositeQuery">
    </FORM>
  </li>
</ul>

<hr>

<!--  -->
<h3>二手商品留言管理</h3>

<ul>
  <li><a href='<%=request.getContextPath()%>/back-end/second_prodmsg/addSecond_ProdMsg.jsp'>Add</a> a new Second_ProdMsg.</li>
</ul>

<!--  -->

	    <hr>

	    <h3><font color=orange>Second_Prod管理</font></h3>

	    <ul>
	      <li><a href='<%=request.getContextPath()%>/back-end/second_prod/listAllSecond_Prod.jsp'>List</a> all Second_Prods. </li>
	    </ul>

	    <hr>

	    <h3><font color=orange>Mem管理</font></h3>

	    <ul>
	      <li><a href='<%=request.getContextPath()%>/back-end/mem/listAllMem.jsp'>List</a> all Mems. </li>
	    </ul>
	    		

<!--  -->

</body>

</html>
