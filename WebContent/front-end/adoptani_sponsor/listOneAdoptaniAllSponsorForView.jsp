
<%@page import="heibernate_com.mem.model.Mem_interface"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.adoptani_sponsor.model.*"%>
<%@ page import="com.chung.tools.Tools"%>
<%@page import="heibernate_com.mem.model.*"%>

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
<%
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


</div><h1>累積贊助金額:<div id="sponsorCount"><%=TotalSponsor%></div></h1>
<table border='1' bordercolor='#CCCCFF' width='400'>


	<tr>
<!-- 		<th>送養動物留言編號</th> -->
<!-- 		<th>送養動物編號</th> -->
		<th>贊助會員</th>
		<th>贊助金額</th>
		<th>贊助物資</th>
		<th>贊助時間</th>
	</tr>
	
	<%for(AdoptaniSponsorVO adoptaniSponsorVO2:list){ %>
		
		<tr align='center' valign='middle' >
			<td><%=memSvc.getOneMem(adoptaniSponsorVO2.getMem_Id()).getMem_nick_name()%></td>
			<td><%=adoptaniSponsorVO2.getAdo_Ani_Spo_money()%></td>
			<td><%=adoptaniSponsorVO2.getAdo_Ani_Spo_thing()%></td>
			<td><%=adoptaniSponsorVO2.getAdo_Ani_Spo_time()%></td>
		</tr>
		
	<%} %>
	
	
<%--  **JSTL寫法，沒有用hibernate會取不到會員物件** --%>	
<%-- 	<c:forEach var="adoptaniSponsorVO" items="${list}" > --%>
<%-- 		<tr align='center' valign='middle' ${(adoptaniSponsorVO.ado_Ani_Spo_No==param.ado_Ani_Spo_No) ? 'bgcolor=#CCCCFF':''}> --%>
<%-- 			<td>${adoptaniSponsorVO.mem_Id}</td> --%>
<%-- 			<td>${adoptaniSponsorVO.ado_Ani_Spo_money}</td> --%>
<%-- 			<td>${adoptaniSponsorVO.ado_Ani_Spo_thing}</td> --%>
<%-- 			<td>${adoptaniSponsorVO.ado_Ani_Spo_time}</td> --%>
<!-- 		</tr> -->
<%-- 	</c:forEach> --%>
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
	
	</div><h1>您的帳戶餘額:<div id="sponsorCount" style="font-size:20px; color:red;"><%=(memVO==null)?"您的身分為訪客，請先登入。":memVO.getMem_balance()%></div></h1>
	<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/front-end/adoptani_sponsor/AdoptaniSponsorServlet.do" name="form1">
	<table border="0">
	
		<tr><td><input type="hidden" name="adopt_Ani_Id" size="30" 	value="<%=adopt_Ani_Id%>" /></td></tr>
		<tr><td><input type="hidden" name="mem_Id" size="30" 	value="<%=(mem_Id==null)?"未登入": mem_Id %>" /></td></tr>
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
				/**
				*	websocket:
				*		記得body標籤裡要加onload="connect();" onunload="disconnect();"
				**/
    			
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
						var url = "<%=request.getContextPath()%>/front-end/adoptani_sponsor/listOneAdoptaniAllSponsorForView.jsp?adopt_Ani_Id=<%=adopt_Ani_Id%>"
						window.location.assign(url);
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