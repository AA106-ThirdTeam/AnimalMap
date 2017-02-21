<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="java.util.*"%>

<%-- 此頁練習採用 EL 的寫法取值 --%>

<jsp:useBean id="listRel_ByRel_MemId" scope="request" type="java.util.Set" />
<jsp:useBean id="MemSvc" scope="page" class="com.mem.model.MemService" />
<html>
<head>
	<style>
	  
    </style>
    
    
	<script src="http://code.jquery.com/jquery-1.10.1.min.js">  </script>
	<title>關係名單 - listRel_ByRel_MemId.jsp</title>
	
</head>
<body bgcolor='white'>

<b><font color=red>此頁練習採用 EL 的寫法取值:</font></b>
<table border='1' cellpadding='5' cellspacing='0' width='800'>
	<tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
		<td>
		<h3>關係名單 - listRel_ByRel_MemId.jsp</h3>
		<a href="<%=request.getContextPath()%>/select_page.jsp"><img src="images/back1.gif" width="100" height="32" border="0">回首頁</a>
		</td>
	</tr>
</table>

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

		<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/hos/hosComm.do" name="form1">
			<textarea style="height:2em" rows="2" cols="100" 
			id="text"  maxlength="300" name="hosComment_content" placeholder="leave a message..."></textarea>

		    <input type="submit" value="新增留言">
			<input type="hidden" name="hos_Id" value="<%= request.getParameter("hos_Id") %>">
			<input type="hidden" name="requestURL"	value="<%=request.getServletPath()%>"><!--送出本網頁的路徑給Controller-->
			<input type="hidden" name="action"value="insert">
		</FORM>
			
			

<table border='1' bordercolor='#CCCCFF' width='800'>
	<tr>
		<th>留言編號</th>
		<th>醫院編號-醫院名稱</th>
		<th>發送會員編號</th>
		
		${(param.updateComment=='') ? '<th>修改內容</th>' : '<th>發送內容</th>'} 
		
		<th>發送時間</th>
	</tr>
	
	<c:forEach var="hosCommVO" items="${listComments_ByHosId}" varStatus="s">
		
		<tr align='center' valign='middle'>
			<td>${hosCommVO.hosComment_Id}</td>
			
			<td>
				<c:forEach var="hosVO" items="${HosSvc.all}">
                    <c:if test="${hosCommVO.hosComment_HosId==hosVO.hos_Id}">
	                    ${hosCommVO.hosComment_HosId}-${hosVO.hos_name}
                    </c:if>
                </c:forEach>
			</td>
			 
			<td>${hosCommVO.hosComment_MemId}</td>
			
			<c:if test="${hosComment_content!=''&&(hosCommVO.hosComment_Id!=param.hosComment_Id)}" var="showComment">
				<td>${hosCommVO.hosComment_content}</td>
			</c:if>
			
			<c:if test="${!showComment}">
				<td>
				<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/hos/hosComm.do" name="confirmUpdateComment${s.index}">
					<textarea style="height:2em" rows="2" cols="50" 
					id="text"  maxlength="300" name="hosComment_content" placeholder="change your comment...">${hosCommVO.hosComment_content}</textarea>
					<input type="hidden" name="forUpdateHosComment_Id" value="${hosCommVO.hosComment_Id}">
			  		<input type="hidden" name="hosComment_HosId" value="${hosCommVO.hosComment_HosId}">
					<input type="hidden" name="requestURL"	value="<%=request.getServletPath()%>"><!--送出本網頁的路徑給Controller-->
					<input type="hidden" name="action" value="confirmUpdateComment">
				</FORM>
				</td>
			</c:if>
			
			<td>
			    <fmt:formatDate type="both" dateStyle="medium" timeStyle="medium" 
	            value="${hosCommVO.hosComment_SendTime}" />
			</td>			
						
			<td>
			  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/hos/hosComm.do">
			    <input type="submit" value="刪除">
			    <input type="hidden" name="hosComment_Id" value="${hosCommVO.hosComment_Id}">
			    <input type="hidden" name="hosComment_HosId" value="${hosCommVO.hosComment_HosId}">
			    <input type="hidden" name="requestURL"	value="<%=request.getServletPath()%>"><!--送出本網頁的路徑給Controller-->
			    <input type="hidden" name="action" value="delete"></FORM>
			</td>
			
			<td>
			
			<c:if test="${showComment}">
				<button onclick="changeComment${s.index}()">修改留言</button>
			</c:if>
			
			<c:if test="${!showComment}">
				<input type="button" value="確認修改留言" onclick="confirmChangeComment${s.index}()">
			</c:if>
			
			<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/hos/hosComm.do" name="updateComment${s.index}">
			    <input type="hidden" name="hosComment_Id" value="${hosCommVO.hosComment_Id}">
			    <input type="hidden" name="hosComment_HosId" value="${hosCommVO.hosComment_HosId}">
			    <input type="hidden" name="requestURL"	value="<%=request.getServletPath()%>"><!--送出本網頁的路徑給Controller-->
			    <input type="hidden" name="action" value="updateComment"></FORM>
			</td>
		</tr>
		
					
	</c:forEach>
</table>

<br>本網頁的路徑:<br><b>
   <font color=blue>request.getServletPath():</font> <%= request.getServletPath()%><br>
   <font color=blue>request.getRequestURI(): </font> <%= request.getRequestURI()%> </b>
</body>

	

</html>
