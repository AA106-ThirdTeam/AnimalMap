<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- <%@ page import="java.util.*"%>	 --%>
<%-- <%@page import="heibernate_com.mem.model.MemVO"%> --%>
<%@ page import="java.util.*"%>
<%@ page import="com.post.model.*"%>
<%@ page import="com.offiMsg.model.*" %>
<%@ page import="com.offiMsg.controller.*" %>
<style>
	
	.navbar-inverse .navbar-nav>li>a {
		color: rgba(1,1, 1, 1);
	
	}
	</style>
	<nav class="navbar navbar-inverse " role="navigation" style="background-color: rgba(27, 156, 176, 1);border-color:rgba(27, 156, 176, 1);">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
				<span class="sr-only">選單切換</span>
				<span class="icon-bar"></span>
				<!-- <span class="icon-bar"></span> -->
				<span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="<%=request.getContextPath()%>/front-end/homepage/index.jsp" style="color:black; font-size:30px;"><b>Animal Map</b></a>
		</div>
	
		<!-- 手機隱藏選單區 -->
		<div class="collapse navbar-collapse navbar-ex1-collapse">
			<!-- 左選單 -->
			<ul class="nav navbar-nav">
				<li class="active" ><a href="#" style="padding-top: 0 ;padding-bottom:0; background-color:rgba(27, 156, 176, 1)"><img class="img-circle" width="50" height="50" style="padding-top: 0" src="https://i.imgur.com/rv4YG8U.jpg"></a></li>
				<li><a href="<%=request.getContextPath()%>/front-end/aboutUs/index.html" style="">關於我們</a></li>
			</ul>
	
			<!-- 搜尋表單 -->
			<form class="navbar-form navbar-right" role="search">
				<div class="form-group">
					<input type="text" class="form-control" placeholder="請輸入關鍵字">
				</div>
				<button type="submit" class="btn btn-default">搜尋</button>
			</form>
	
			<!-- 右選單 -->
			<ul class="nav navbar-nav navbar-right">
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
				<li class="dropdown">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown">系統訊息 <b class="caret"></b></a>
						<ul class="dropdown-menu" style="width: 300px;">
						
						<%
						OffiMsgService offiMsgSvc = new OffiMsgService();
						List<OffiMsgVO> listOffiMsg = offiMsgSvc.getAll();
						request.setAttribute("listOffiMsg", listOffiMsg);
						%>
						
						<c:forEach var="OffiMsgVO" items="${listOffiMsg}">
							<div class="row" style="width: 100px;">
					<li><a href="#modal-id${OffiMsgVO.offiMsg_Id}" data-toggle="modal" class="btn" style="padding-left: 20px;">標題:${OffiMsgVO.offiMsg_Title}</a></li>

							
						</div>
						</c:forEach>
							
						</ul>
					</li>
			
			</ul>
		</div>
		<!-- 手機隱藏選單區結束 -->
	</nav>


<!--==================================================清     單=====================================================================-->
	
				
	<c:forEach var="OffiMsgVO" items="${listOffiMsg}">
					
			<div class="modal fade" id="modal-id${OffiMsgVO.offiMsg_Id}">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
					
							<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
						
							${OffiMsgVO.offiMsg_Id}<h4 class="modal-title"><b>標題${OffiMsgVO.offiMsg_Title}</h4>
						</div>
						<div class="modal-body">
							<a>內容:${OffiMsgVO.offiMsg_Content}</a>
						</div>
					
						<div class="modal-footer">
							<button type="button" class="btn btn-default" data-dismiss="modal">關閉</button>
						
						</div>
				
				</div>
			</div>
		</div>
		</c:forEach>
		
		
<!-- 		<script src="https://code.jquery.com/jquery.js"></script> -->
<!-- 		<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script> -->
<!-- 	</body> -->
<!-- </html> -->