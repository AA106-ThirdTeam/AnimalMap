<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.adoptani_sponsor.model.*"%>
<%@ page import="com.chung.tools.Tools"%>
<%	
	String mem_Id = (String)session.getAttribute("account");

	AdoptaniSponsorVO adoptaniSponsorVO = (AdoptaniSponsorVO) request.getAttribute("adoptaniSponsorVO");	
	//預防錯誤輸入，而保留user所輸入的所有內容，送出後若錯誤不用全部重打。

	String adopt_Ani_Id = (String) request.getParameter("adopt_Ani_Id");
	AdoptaniSponsorService adoptaniSponsorSvc = new AdoptaniSponsorService();
	List<AdoptaniSponsorVO> list = adoptaniSponsorSvc.getOneAdoptaniAllSponsor(adopt_Ani_Id);
    pageContext.setAttribute("list",list);	//要放到scope裡面才找得到。
    Integer TotalSponsor = adoptaniSponsorSvc.getOneAllMoney(adopt_Ani_Id);
%>

<html>
<head>
<title>贊助</title>
</head>
<body bgcolor='white'>

<script>
/**載入時卷軸置底**/
window.onload = function ()
{	
	scroll(0, 9999999);
	connect();
}
window.onunload = function(){
	disconnect();
}
</script>



<table border='1' bordercolor='#CCCCFF' width='400'>


	<tr>
<!-- 		<th>送養動物留言編號</th> -->
<!-- 		<th>送養動物編號</th> -->
		<th>贊助會員</th>
		<th>贊助金額</th>
		<th>贊助物資</th>
		<th>贊助時間</th>
	</tr>
	<c:forEach var="adoptaniSponsorVO" items="${list}" >
		<tr align='center' valign='middle' ${(adoptaniSponsorVO.ado_Ani_Spo_No==param.ado_Ani_Spo_No) ? 'bgcolor=#CCCCFF':''}>
<%-- 			<td>${adoptaniSponsorVO.ado_Ani_Spo_No}</td>  --%>
<%-- 			<td>${adoptaniSponsorVO.adopt_Ani_Id}</td> --%>
			<td>${adoptaniSponsorVO.mem_Id}</td>
			<td>${adoptaniSponsorVO.ado_Ani_Spo_money}</td>
			<td>${adoptaniSponsorVO.ado_Ani_Spo_thing}</td>
			<td>${adoptaniSponsorVO.ado_Ani_Spo_time}</td>
<!-- 			<td> -->
<%-- 			 <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/front-end/adoptani_sponsor/AdoptaniSponsorServlet.do"> --%>
<!-- 			     <input type="submit" value="修改"> -->
<%-- 			     <input type="hidden" name="ado_Ani_Spo_No" value="${adoptaniSponsorVO.ado_Ani_Spo_No}"> --%>
<%-- 			     <input type="hidden" name="requestURL"	value="<%=request.getServletPath()%>"><!--送出本網頁的路徑給Controller--> --%>
<!-- 			     <input type="hidden" name="action"	value="getOne_For_Update"></FORM> -->
<!-- 			</td> -->
<!-- 			<td> -->
<%-- 			  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/front-end/adoptani_sponsor/AdoptaniSponsorServlet.do"> --%>
<!-- 			    <input type="submit" value="刪除"> -->
<%-- 			    <input type="hidden" name="ado_Ani_Spo_No" value="${AdoptaniSponsorVO.ado_Ani_Spo_No}"> --%>
<%-- 			    <input type="hidden" name="requestURL"	value="<%=request.getServletPath()%>"><!--送出本網頁的路徑給Controller--> --%>
<!-- 			    <input type="hidden" name="action"value="delete"></FORM> -->
<!-- 			</td> -->
			     
		</tr>
	</c:forEach>
</table>
	<h3>送養動物資料:</h3>
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
	</div><h1>累積贊助金額:<div id="sponsorCount"><%=TotalSponsor%></div></h1>
	
	<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/front-end/adoptani_sponsor/AdoptaniSponsorServlet.do" name="form1">
	<table border="0">
	
		<tr><td><input type="hidden" name="adopt_Ani_Id" size="30" 	value="<%=adopt_Ani_Id%>" /></td></tr>
		<tr><td><input type="hidden" name="mem_Id" size="30" 	value="<%=(mem_Id==null)?"1000001":mem_Id %>" /></td></tr>
		<tr><td>贊助金額:</td>
			<td><input type="TEXT" name="ado_Ani_Spo_money" size="30" 	placeholder="金額"
				value="<%= (adoptaniSponsorVO==null)? "" : adoptaniSponsorVO.getAdo_Ani_Spo_money() %>" /></td>
			</tr>
		<tr><td>贊助物資:</td>
			<td><input type="TEXT" name="ado_Ani_Spo_thing" size="30" 	placeholder="物資"
				value="<%= (adoptaniSponsorVO==null)? "" : adoptaniSponsorVO.getAdo_Ani_Spo_thing() %>" /></td>
			</td>
		</tr>  

		


	</table>
	<br>
	<input type="hidden" name="action" value="insert_From_listOneAdoptaniAllSponsorForView.jsp">
	<input type="submit" value="送出新增" onclick="sendMessage()">
	</FORM>

	<script>
    			
			    var MyPoint = "/MyEchoServer_adoptani/<%=adopt_Ani_Id%>/30";
			    var host = window.location.host;
			    var path = window.location.pathname;
			    var webCtx = path.substring(0, path.indexOf('/', 1));
			    var endPointURL = "ws://" + window.location.host + webCtx + MyPoint;
			    console.log(host);
			    console.log(path);
			    console.log(webCtx);
			    console.log(endPointURL);
				var webSocket;
				
				function connect() {
					// 建立 websocket 物件
					webSocket = new WebSocket(endPointURL);
					
					webSocket.onopen = function(event) {
					};
			
					webSocket.onmessage = function(event) {
						var sponsorCount = document.getElementById("sponsorCount");
						sponsorCount.innerHTML = event.data;
// 				        var jsonObj = JSON.parse(event.data);
// 				        var message = jsonObj.total ;
// 				        sponsorCount.innerHTML = message;
// 				        messagesArea.scrollTop = messagesArea.scrollHeight;
					};
			
					webSocket.onclose = function(event) {
					};
				}
				
				
				function disconnect () {
					webSocket.close();
				}
				
				function sendMessage(){
					webSocket.send(<%=adopt_Ani_Id%>)
				}
				
		    
		</script>



</body>
</html>