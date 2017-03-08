<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.strayani_message.model.*"%>
<%@ page import="com.chung.tools.Tools"%>
<%@page import="heibernate_com.mem.model.*"%>


<%-- 取得Service物件，調用DAO裡面的getAll()，取資料庫此Table的每筆資料。 --%>
<%
// 	 List<StrayaniMessageVO> list = (List<StrayaniMessageVO>) request.getAttribute("strayaniMessagelist");
//    pageContext.setAttribute("list",list);	//要放到scope裡面才找得到。
//    String stray_Ani_Id = (String) request.getAttribute("stray_Ani_Id");
%> 
<%	//會員VO
	MemVO memVO = (MemVO)session.getAttribute("account");

	String mem_Id;
	String mem_nickName;

	if (memVO != null) {
		mem_Id = memVO.getMem_Id();
		mem_nickName = memVO.getMem_nick_name();
	}else{
		mem_Id = "1000000";
		mem_nickName = "訪客";
	}
		

	
	
	MemService memSvc = new MemService();
	
%>
<%	
	String stray_Ani_Id = (String) request.getParameter("stray_Ani_Id");
	System.out.println(stray_Ani_Id);
	StrayaniMessageService strayaniMessageSvc = new StrayaniMessageService();
	List<StrayaniMessageVO> list = strayaniMessageSvc.getOneStrayaniAllMessage(stray_Ani_Id);
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
	connectStrayMessage();
}
window.unonload = function ()
{	
	scroll(0, 9999999);
	disconnectStrayMessage();
}
</script>

<table border="1" bordercolor="#CCCCFF" width="400">
	<tr>
		<th width="100">發布者</th>
		<th width="300">送養動物留言內容</th>
		
	</tr>

	<c:forEach var="strayaniMessageVO" items="${list}" >
		<tr align='center' valign='middle' >
			<td>${strayaniMessageVO.mem_Id}</td>
			<td align="left">${strayaniMessageVO.str_Ani_Mes}</td>
		<tr>
			<td></td>
			<td align="right">${strayaniMessageVO.str_Ani_Mes_time}</td>
<!-- 			<td> -->
<%-- 			  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/front-end/strayani_message/StrayaniMessageServlet.do"> --%>
<!-- 			     <input type="submit" value="修改"> -->
<%-- 			     <input type="hidden" name="str_Ani_Mes_No" value="${strayaniMessageVO.str_Ani_Mes_No}"> --%>
<%-- 			     <input type="hidden" name="requestURL"	value="<%=request.getServletPath()%>"><!--送出本網頁的路徑給Controller--> --%>
<!-- 			     <input type="hidden" name="action"	value="getOne_For_Update"></FORM> -->
<!-- 			</td> -->
<!-- 			<td> -->
<%-- 			  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/front-end/strayani_message/StrayaniMessageServlet.do"> --%>
<!-- 			    <input type="submit" value="刪除"> -->
<%-- 			    <input type="hidden" name="str_Ani_Mes_No" value="${strayaniMessageVO.str_Ani_Mes_No}"> --%>
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
	
	<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/front-end/strayani_message/StrayaniMessageServlet.do" name="form1">
	<table border="1" width="400" >
	
		<tr >
			<td >送養動物編號:</td>
			<td ><input type="hidden" name="stray_Ani_Id" size="30" 	
				value="<%=stray_Ani_Id %>" /><%=stray_Ani_Id %></td>
		</tr>
		<tr>
			<td>發布者會員:</td>
			<td><input type="hidden" name="mem_Id" size="30" 	
				value="<%=(mem_Id==null)?"1000000":mem_Id%>" /><%=(mem_nickName==null)?"瞎皮":mem_nickName%></td>
		</td>
		</tr>  
		
		<tr>
			<td>留言內容:</td>
			<td>
				<textarea cols="30" rows="5" name="str_Ani_Mes" ></textarea>
			
<!-- 			<input type="TEXT" name="Mem_Id" size="20" placeholder="8碼" -->
<%-- 				value="<%= (strayaniVO==null)? "" : strayaniVO.getMem_Id()%>" /></td> --%>
		</tr>
		


	</table>
	<br>
	<input type="hidden" name="action" value="insert_From_listOneStrayaniAllMessageForView.jsp">
	<input type="submit" value="留言" onclick="sendWSforStrayMsg()">
	</FORM>
	


			

</body>
</html>
<script>			
				/**
				*	websocket:
				*		記得body標籤裡要加onload="connect();" onunload="disconnect();"
				**/
    			
			    var MyPoint = "/MyEchoServer_forAniMessage/<%=stray_Ani_Id%>/123";
			    var host = window.location.host;
			    var path = window.location.pathname;
			    var webCtx = path.substring(0, path.indexOf('/', 1));
			    var endPointURL = "ws://" + window.location.host + webCtx + MyPoint;
			    console.log(host);
			    console.log(path);
			    console.log(webCtx);
			    console.log(endPointURL);
				var webSocket;
				
				
				
				function connectStrayMessage() {
					// 建立 websocket 物件
					webSocket = new WebSocket(endPointURL);
					
					webSocket.onopen = function(event) {
					};
			
					webSocket.onmessage = function(event) {
						var url = "<%=request.getContextPath()%>/front-end/strayani_message/listOneStrayaniAllMessageForView.jsp?stray_Ani_Id=<%=stray_Ani_Id%>"
						window.location.assign(url);
						
// 				        var jsonObj = JSON.parse(event.data);
// 				        var message = jsonObj.total ;
// 				        messagesArea.scrollTop = messagesArea.scrollHeight;
					};
			
					webSocket.onclose = function(event) {
					};
				}
				
				
				function disconnectStrayMessage() {
					webSocket.close();
				}
				
				function sendWSforStrayMsg(){
					webSocket.send(<%=stray_Ani_Id%>)
				}
				
		    
		</script>
