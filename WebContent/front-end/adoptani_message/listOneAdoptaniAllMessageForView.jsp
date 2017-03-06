<%@page import="com.mem.model.MemService"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.adoptani_message.model.*"%>
<%@ page import="com.chung.tools.Tools"%>
<%@page import="heibernate_com.mem.model.MemVO"%>

<%	//會員VO
	MemVO memVO = (MemVO)session.getAttribute("account");

	String mem_Id;
	String mem_nickName;

	if (memVO != null) {
		mem_Id = memVO.getMem_Id();
		mem_nickName = memVO.getMem_nick_name();
	}else{
		mem_Id = "0000000";
		mem_nickName = "訪客";
	}
		

	
	
	MemService memSvc = new MemService();
	
%>

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

<html id="html" >
<head>

</head>
<body bgcolor="white" >
	
	
<script>
/**載入時卷軸置底**/
window.onload = function ()
{	
	scroll(0, 9999999);
	connectAdoptMessage();
}
window.unonload = function ()
{	
	scroll(0, 9999999);
	disconnectAdoptMessage();
}
</script>

<table border="1" bordercolor="#CCCCFF" width="400" >
	<tr>
		<th width="100">發布者</th>
		<th width="300">送養動物留言內容</th>
		
	</tr>
	<%for(AdoptaniMessageVO adoptaniMessageVO:list){ %>
			<tr align='center' valign='middle' >
				<td><%=memSvc.getOneMem(adoptaniMessageVO.getMem_Id()).getMem_nick_name()%></td>
				<td align="left"><%=adoptaniMessageVO.getAdo_Ani_Mes()%></td>
			</tr>
			<tr>
				<td></td>
				<td align="right"><%=adoptaniMessageVO.getAdo_Ani_Mes_time()%></td>

			</tr>	     
	
	<%} %>
	
<%--  **JSTL寫法，沒有用hibernate會取不到會員物件** --%>	
<%-- 	<c:forEach var="adoptaniMessageVO" items="${list}" > --%>
<!-- 		<tr align='center' valign='middle' > -->
<%-- 			<td>${adoptaniMessageVO.mem_Id}</td> --%>
<%-- 			<td align="left">${adoptaniMessageVO.ado_Ani_Mes}</td> --%>
<!-- 		<tr> -->
<!-- 			<td></td> -->
<%-- 			<td align="right">${adoptaniMessageVO.ado_Ani_Mes_time}</td> --%>

<!-- 		</tr>	      -->
<!-- 		</tr> -->
<%-- 	</c:forEach> --%>
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
				value="<%=(mem_Id==null)?"1000001":mem_Id%>" /><%=(mem_nickName==null)?"瞎皮":mem_nickName%></td>
		</td>
		</tr>  
		
		<tr>
			<td>留言內容:</td>
			<td>
				<textarea cols="30" rows="5" name="ado_Ani_Mes" id="Mes" ></textarea>
			
<!-- 			<input type="TEXT" name="Mem_Id" size="20" placeholder="8碼" -->
<%-- 				value="<%= (adoptaniVO==null)? "" : adoptaniVO.getMem_Id()%>" /></td> --%>
		</tr>
		


	</table>
	<br>
	<input type="hidden" name="action" value="insert_From_listOneAdoptaniAllMessageForView.jsp">
	<input type="submit" value="留言" onclick="sendWSforAdoptMsg()">
	</FORM>
	


			

</body>  
</html>

<script>			
				/**
				*	websocket:
				*		記得body標籤裡要加onload="connect();" onunload="disconnect();"
				**/
    			
			    var MyPoint = "/MyEchoServer_forAniMessage/<%=adopt_Ani_Id%>/123";
			    var host = window.location.host;
			    var path = window.location.pathname;
			    var webCtx = path.substring(0, path.indexOf('/', 1));
			    var endPointURL = "ws://" + window.location.host + webCtx + MyPoint;
			    console.log(host);
			    console.log(path);
			    console.log(webCtx);
			    console.log(endPointURL);
				var webSocket;
				
				
				
				function connectAdoptMessage() {
					// 建立 websocket 物件
					webSocket = new WebSocket(endPointURL);
					
					webSocket.onopen = function(event) {
					};
			
					webSocket.onmessage = function(event) {
						var url = "<%=request.getContextPath()%>/front-end/adoptani_message/listOneAdoptaniAllMessageForView.jsp?adopt_Ani_Id=<%=adopt_Ani_Id%>"
						window.location.assign(url);
						
// 				        var jsonObj = JSON.parse(event.data);
// 				        var message = jsonObj.total ;
// 				        messagesArea.scrollTop = messagesArea.scrollHeight;
					};
			
					webSocket.onclose = function(event) {
					};
				}
				
				
				function disconnectAdoptMessage() {
					webSocket.close();
				}
				
				function sendWSforAdoptMsg(){
					webSocket.send(<%=adopt_Ani_Id%>)
				}
				
		    
		</script>

