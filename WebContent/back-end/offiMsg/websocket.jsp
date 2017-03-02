<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="heibernate_com.mem.model.MemVO"%>
<%@ page import="java.util.*"%>
<%@ page import="com.post.model.*"%>
<%@ page import="com.post_Response.model.*"%>
<%@ page import="com.offiMsg.model.*" %>
<%@ page import="com.offiMsg.controller.*" %>

<%
	boolean isLogin = false;
	// 【從 session 判斷此user是否登入過】
	heibernate_com.mem.model.MemVO account = (heibernate_com.mem.model.MemVO)session.getAttribute("account");
	
	
	if (account != null) {
		isLogin = true;
	}
	request.setAttribute("isLogin", isLogin);
%>

<!-- ==================================下面是HEAD部分=============================== -->

<!DOCTYPE html>
<html>
<head>
   
       <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
        <link rel="stylesheet" href="css/styles.css" type="text/css"/>
   
<link rel="stylesheet" href="https://www.w3schools.com/lib/w3.css">
<link rel="stylesheet" href="https://www.w3schools.com/lib/w3-theme-black.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"> 
</head>
<style>
html,body,h1,h2,h3,h4,h5,h6 {font-family: "Roboto", sans-serif}
.w3-sidenav a,.w3-sidenav h4 {padding: 12px;}
.w3-bar a {
    padding-top: 12px;
    padding-bottom: 12px;
}
 .container{
     text-align:center;
    }
    #messagesArea{
    width: 700px;
    height: 300px;
    }
    
</style>
<body>

<!-- Navbar -->
<div class="w3-top">
  <div class="w3-bar w3-theme w3-top w3-left-align w3-large">
    <a class="w3-bar-item w3-button w3-opennav w3-right w3-hide-large w3-hover-white w3-large w3-theme-l1" href="javascript:void(0)" onclick="w3_open()"><i class="fa fa-bars"></i></a>
  
    <a href="<%=request.getContextPath()%>/front-end/homepage/index.jsp" class="w3-bar-item w3-button w3-hide-small w3-hover-white">AnimalMap</a>
    <a href="<%=request.getContextPath()%>/front-end/aboutUs/index.html" class="w3-bar-item w3-button w3-hide-small w3-hover-white">About</a>
 
  </div>
</div>

<!-- Sidenav -->
<nav class="w3-sidenav w3-collapse w3-theme-l5 w3-animate-left" style="z-index:3;width:250px;margin-top:51px;" id="mySidenav">
 
  </a>
  <h4><b>Menu</b></h4>
  <% 
				{
					if((Boolean)request.getAttribute("isLogin")){
						String tem_str = ((heibernate_com.mem.model.MemVO)session.getAttribute("account")).getMem_name();
						%>	
						<li><a href="#" class="glyphicon glyphicon-user">　<%=tem_str %>　您好</a></li>
						<%
					}else{
						%>
						<li><a href="#" class="glyphicon glyphicon-user">　訪客 您好</a></li>	
						<%
					}
				}
				%>
				<% 
				{
					if((Boolean)request.getAttribute("isLogin")){
						String tem_str = ((heibernate_com.mem.model.MemVO)session.getAttribute("account")).getMem_Id();
						%>	
							<FORM id="am_log_out" METHOD="post" ACTION="<%=request.getContextPath()%>/weihan_controller.do" style="position: absolute;">
								<input type="hidden" name="action" value="set_account_null">
								<input type="hidden" name="requestURL" value="<%=request.getContextPath() %>/front-end/homepage/index.jsp">
							</FORM>
							<li><a href="#" class="glyphicon glyphicon-log-out" onclick="log_out()">　登出</a></li>
							<script type="text/javascript">
								function log_out() {
									$( "#am_log_out" ).submit();
								}
							</script>
						<%
					}else{
						%>
							<FORM id="am_log_in" METHOD="post" ACTION="<%=request.getContextPath() %>/front-end/login/index.jsp" style="position: absolute;">
								<input type="hidden" name="action" value="login_in">
								<input type="hidden" name="requestURL" value="<%=request.getContextPath() %>/front-end/homepage/index.jsp">
							</FORM>	
							<li><a href="#" class="glyphicon glyphicon-log-out" onclick="log_in()">　登入</a></li>
							<script type="text/javascript">
								function log_in() {
									$( "#am_log_in" ).submit();
								}
							</script>												
<!-- 							<li> -->
<%-- 								<a style="cursor: pointer;" 　href="<%=request.getContextPath() %>/front-end/login/index.jsp">　登入</a> --%>
<!-- 							</li>						 -->
						<%
					}
				}
				%>					
				<% 
				{
					if((Boolean)request.getAttribute("isLogin")){
						String tem_str = ((heibernate_com.mem.model.MemVO)session.getAttribute("account")).getMem_Id();
						%>	
						<li>
							<a  class="glyphicon glyphicon-cog"  href="<%=request.getContextPath() %>/Heibernate_back-end/mem/mem.do?action=getOne_For_Update&mem_Id=<%=tem_str%>">　個人設定</a>
						</li>
						<%
					}else{
						%>
						<%
					}
				}
				%>			
 
</nav>

<!-- Overlay effect when opening sidenav on small screens -->

<!-- Main content: shift it to the right by 250 pixels when the sidenav is visible -->
<div class="w3-main" style="margin-left:250px">



  <div class="w3-row w3-padding-64">
    <div class="w3-twothird w3-container">
      <h1 class="w3-text-teal">WebSocket</h1>
     
    <div class="w3-third w3-container">
     <div class="row">
    <body onload="connect();" onunload="disconnect();">
        <h4>WebSocket訊息視窗 </h4>
        
	    <h3 id="statusOutput" class="statusOutput"></h3>
	    <div><table>
	   
	    <textarea id="messagesArea" class=" message-area" readonly ></textarea></table></div>
        
        <div class="panel input-area" >
    
       	員工編號:<input id="userId" class="text-field" type="text" placeholder="員工標號" style="padding-left: 20px;width: 700"/><br>
       	訊息標題:<input id="title" class="text-field" type="text" placeholder="標題" style="padding-left: 20px;width: 700px;"/><br>
       訊息內容:<input id="message"  class="text-field" type="text" placeholder="系統通知訊息" onkeydown="if (event.keyCode == 13) sendMessage();" style="height: 50px;width: 700px;"/>
          <br><br><input type="submit" id="sendMessage" class="button" value="送出" onclick="sendMessage();"/>
		 <input type="button" id="connect"  class="button" value="連線" onclick="connect();"/>
		    <input type="button" id="disconnect"  class="button" value="離線" onclick="disconnect();"/>
	    </div>
    </body>
      </div>
    </div>
  </div>
  </div>

 

 

 

  <!-- Pagination -->
  

<!-- END MAIN -->
</div>

<script>
// Get the Sidenav
var mySidenav = document.getElementById("mySidenav");

// Get the DIV with overlay effect
var overlayBg = document.getElementById("myOverlay");

// Toggle between showing and hiding the sidenav, and add overlay effect
function w3_open() {
    if (mySidenav.style.display === 'block') {
        mySidenav.style.display = 'none';
        overlayBg.style.display = "none";
    } else {
        mySidenav.style.display = 'block';
        overlayBg.style.display = "block";
    }
}

// Close the sidenav with the close button
function w3_close() {
    mySidenav.style.display = "none";
    overlayBg.style.display = "none";
}
</script>

</body>
</html>