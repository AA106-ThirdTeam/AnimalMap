<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 載入 fmt: formatDate 的標籤 --%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="com.emg_H_Msg.model.*"%>
<%@ page import="com.emg_H.model.*"%>
<%@ page import="java.util.*"%>

	<jsp:useBean id="emg_HSvc" scope="page"	class="com.emg_H.model.Emg_HService" />

<%



String emg_H_Id=(String)request.getParameter("emg_H_Id");
String emg_H_Msg_Id=(String)request.getParameter("emg_H_Msg_Id");

Emg_H_MsgVO emg_H_MsgVO = new Emg_H_MsgVO();

 Emg_HVO emg_HVO =new Emg_HVO();

Set<Emg_H_MsgVO> set = emg_HSvc.getEmg_H_MsgByEmg_H_Id(emg_H_Id);
pageContext.setAttribute("set",set);


%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css">

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>listEmg_H_Msg_ByEmg_H_Id.jsp</title>


<style>

	.panel-time{
	margin-left:320px;
	}
	
	.MemBtn{
	margin-left: 380px;
	}

</style>


</head>
<body>

	

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
<br>

	
	<c:forEach var="emg_H_MsgVO" items="${set}">
				
	
	<div class="panel panel-info">
		  <div class="panel-heading">
		  
		  <jsp:useBean id="memSvc" scope="page"	class="heibernate_com.mem.model.MemService" />
	 		  <h3 class="panel-title" > 
<!-- 	 		  利用留言表格裡的會員外來鍵 來找會員getOne的方法  join tomcat 7.0 以上  -->
			  	 會員 ${memSvc.getOneMem(emg_H_MsgVO.mem_Id).mem_name}
		    	</h3> 
					
		    
		    <%--如果留言是該會員新增時才會有修改，刪除的按鈕，其餘隱藏 --%>	
		    <div class="MemBtn  ${emg_H_MsgVO.mem_Id==account.mem_Id?'':'Mem_btn'} ">
		    
		    		<FORM METHOD="post"	ACTION="<%=request.getContextPath()%>/front-end/emg_H_Msg/emg_H_Msg.do">
						<input type="submit" value="修改" class="btn btn-warning">  
						<input type="hidden" name="emg_H_Msg_Id" value="${emg_H_MsgVO.emg_H_Msg_Id}">
						<input type="hidden" name="emg_H_Id" value="${emg_H_MsgVO.emg_H_Id}">
						<input type="hidden" name="requestURL" value="<%=request.getServletPath()%>">
<!-- 						送出本網頁的路徑給Controller -->
						<input type="hidden" name="action" value="getOne_For_UpdateforView">
					</FORM>
			
					<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/front-end/emg_H_Msg/emg_H_Msg.do">
						<input type="submit" value="刪除" class="btn btn-danger"> 
						<input type="hidden" name="emg_H_Msg_Id" value="${emg_H_MsgVO.emg_H_Msg_Id}">
						<input type="hidden" name="emg_H_Id" value="${emg_H_MsgVO.emg_H_Id}">
						<input type="hidden" name="requestURL" value="<%=request.getServletPath()%>">
<!-- 						送出本網頁的路徑給Controller -->
						<input type="hidden" name="action" value="delete">
					</FORM>
		    
		    </div>
		    <!-- 			 利用fmt 標籤 把時間 format -->
		    <div  class="panel-time"><fmt:formatDate value="${emg_H_MsgVO.emg_H_Msg_start}" pattern="yyyy-MM-dd HH:mm"/></div>
		  </div>
		  <div class="panel-body " style="${(emg_H_MsgVO.emg_H_Msg_Id==param.emg_H_Msg_Id) ? 'background-color:	#FFFF77 ;':''}" >
		    ${emg_H_MsgVO.emg_H_Msg_content}
		  </div>
		</div>

		
		</c:forEach>
	
	
	<br>
	<br>
<!-- 新增留言 -->
	<div>
	
	<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/front-end/emg_H_Msg/emg_H_Msg.do" name="form1">
		<table border="0">
		
			<tr >
				<td>會員:
				<%--SESSION 綁定memVO.Id --%>
				${account.mem_name}
				<input type="hidden" name="mem_Id" size="30"
					value="${account.mem_Id}" /></td>
			</tr>
			<tr>
				<td> 
<!-- 				test -->
				        緊急編號 : <%=emg_H_Id %>
				<input type="hidden" name="emg_H_Id" value="<%=emg_H_Id %>">
				</td>
			</tr>

		</table>

		<br> 內容 <br>

		<textarea type="textarea" name="emg_H_Msg_content" cols="40" rows="5" maxlength="100"
			value=""></textarea>

		<br> <input type="hidden" name="action" value="insertForView"> 
			<input type="submit" value="留言" class="btn btn-success">
			<input type="hidden" name="requestURL" value="<%=request.getServletPath()%>">
			
	</FORM>
	
	</div>

<script>

$(".Mem_btn").hide();


</script>



</body>
</html>