<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.adoptani_message.model.*"%>
<%@ page import="com.chung.tools.Tools"%>


<%-- 取得Service物件，調用DAO裡面的getAll()，取資料庫此Table的每筆資料。 --%>
<%
// 	 List<AdoptaniMessageVO> list = (List<AdoptaniMessageVO>) request.getAttribute("adoptaniMessagelist");
//    pageContext.setAttribute("list",list);	//要放到scope裡面才找得到。
//    String adopt_Ani_Id = (String) request.getAttribute("adopt_Ani_Id");
%> 

<%	
	String adopt_Ani_Id = (String) request.getParameter("adopt_Ani_Id");
	System.out.println(adopt_Ani_Id);
	AdoptaniMessageService adoptaniMessageSvc = new AdoptaniMessageService();
	List<AdoptaniMessageVO> list = adoptaniMessageSvc.getOneAdoptaniAllMessage(adopt_Ani_Id);
    pageContext.setAttribute("list",list);	//要放到scope裡面才找得到。
    
%>

<html id="html">
<head>

</head>
<body bgcolor="white" >
	
	
<script>
/**載入時卷軸置底**/
window.onload = function ()
{	
	scroll(0, 9999999);
}
</script>

<table border="1" bordercolor="#CCCCFF" width="400">
	<tr>
		<th width="100">發布者</th>
		<th width="300">送養動物留言內容</th>
		
	</tr>

	<c:forEach var="adoptaniMessageVO" items="${list}" >
		<tr align='center' valign='middle' >
			<td>${adoptaniMessageVO.mem_Id}</td>
			<td align="left">${adoptaniMessageVO.ado_Ani_Mes}</td>
		<tr>
			<td></td>
			<td align="right">${adoptaniMessageVO.ado_Ani_Mes_time}</td>
<!-- 			<td> -->
<%-- 			  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/front-end/adoptani_message/AdoptaniMessageServlet.do"> --%>
<!-- 			     <input type="submit" value="修改"> -->
<%-- 			     <input type="hidden" name="ado_Ani_Mes_No" value="${adoptaniMessageVO.ado_Ani_Mes_No}"> --%>
<%-- 			     <input type="hidden" name="requestURL"	value="<%=request.getServletPath()%>"><!--送出本網頁的路徑給Controller--> --%>
<!-- 			     <input type="hidden" name="action"	value="getOne_For_Update"></FORM> -->
<!-- 			</td> -->
<!-- 			<td> -->
<%-- 			  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/front-end/adoptani_message/AdoptaniMessageServlet.do"> --%>
<!-- 			    <input type="submit" value="刪除"> -->
<%-- 			    <input type="hidden" name="ado_Ani_Mes_No" value="${adoptaniMessageVO.ado_Ani_Mes_No}"> --%>
<%-- 			     <input type="hidden" name="requestURL"	value="<%=request.getServletPath()%>"><!--送出本網頁的路徑給Controller--> --%>
<!-- 			    <input type="hidden" name="action"value="delete"></FORM> -->
<!-- 			</td> -->
		</tr>	     
		</tr>
	</c:forEach>
</table>
<br>
<br>
<br>
	<div>
		<c:if test="${not empty errorMsgs}">
			<font color='red'>請修正以下錯誤:
			<ul>
				<c:forEach var="message" items="${errorMsgs}">
					<li>${message}</li>
				</c:forEach>
			</ul>
			</font>
		</c:if>
	</div>
	
	<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/front-end/adoptani_message/AdoptaniMessageServlet.do" name="form1">
	<table border="1" width="400" >
	
		<tr >
			<td >送養動物編號:</td>
			<td ><input type="hidden" name="adopt_Ani_Id" size="30" 	
				value="<%=adopt_Ani_Id %>" /><%=adopt_Ani_Id %></td>
		</tr>
		<tr>
			<td>發布者會員編號:</td>
			<td><input type="hidden" name="mem_Id" size="30" 	
				value="<%=10000001%>" /><%=10000001%></td>
		</td>
		</tr>  
		
		<tr>
			<td>留言內容:</td>
			<td>
				<textarea cols="30" rows="5" name="ado_Ani_Mes" ></textarea>
			
<!-- 			<input type="TEXT" name="Mem_Id" size="20" placeholder="8碼" -->
<%-- 				value="<%= (adoptaniVO==null)? "" : adoptaniVO.getMem_Id()%>" /></td> --%>
		</tr>
		


	</table>
	<br>
	<input type="hidden" name="action" value="insert_From_listOneAdoptaniAllMessageForView.jsp">
	<input type="submit" value="留言">
	</FORM>
	


			

</body>
</html>

