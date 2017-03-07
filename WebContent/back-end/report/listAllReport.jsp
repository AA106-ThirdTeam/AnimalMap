<%@page import="com.adoptani.model.AdoptaniVO"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.report.model.*"%>
<%@ page import="com.emg_H.model.*"%>
<%-- 此頁練習採用 EL 的寫法取值 --%>

<%
		//Emg_HVO emg_HVO= (Emg_HVO)request.getAttribute("emg_HVO");
		

    ReportService reportSvc = new ReportService();
    List<ReportVO> list = reportSvc.getAll();
    pageContext.setAttribute("list",list);
%>

<!DOCTYPE html>
<html lang="">
	<head>
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>Title Page</title>
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
		<script src="https://code.jquery.com/jquery.js"></script>
		<script src="https://cdnjs. cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
		
	<style>
	
	.a_1 {
	 margin:0 20px;
	}
	
	.status_0{
	background-color:#ffbf80;
	}
	</style>	
		
		
		
		
	</head>
	<body>
		<div><H1>審核檢舉</H1></div>
		
		<a href="#" id="agree">已審核</a>
		<a href="#" id="NoAgree">未審核</a>
		
		
		<br>
		<table class="table table-hover">
			
			<thead>
				<tr>
					<th>檢舉編號</th>
					<th>檢舉類別</th>
<!-- 					<th>檢舉類別編號</th> -->
					<th>檢舉名稱</th>
					<th>檢舉內容</th>
					<th>檢舉會員</th>
					<th>被檢舉會員</th>
					<th>檢舉時間</th>
					<th>檢舉狀態</th>
					
					<%--TEST用 --%>
<!-- 					<th>被檢舉的PK</th> -->
					<th></th>
					<th></th> 
					<th></th> 

				</tr>
			</thead>
			<tbody>
	
		<c:forEach var="reportVO" items="${list}" >
											<!-- 狀態為 尚未審核時 呈現顏色 -->
			<tr class="${reportVO.report_status==1?'status_1':'status_0'} "	> 
					
					<td>${reportVO.report_No}</td>
<!-- 					檢舉類別分類 -->
				<c:choose>	
					<c:when test="${(reportVO.report_class) eq 'emg_Help' }">	
						<td>緊急求救</td>
					</c:when>
					<c:when test="${(reportVO.report_class) eq 'ADOPT_ANI' }">	
						<td>領養動物</td>
					</c:when>
					<c:when test="${(reportVO.report_class) eq 'vet_hospital' }">	
						<td>動物醫院</td>
					</c:when>
					<c:when test="${(reportVO.report_class) eq 'post' }">	
						<td>討論區文章</td>
					</c:when>
				
				</c:choose>	
				
<%-- 					<td>${reportVO.report_class_No}</td> --%>
					<td>${reportVO.report_name}</td>
					<td>${reportVO.report_content}</td>
					
					 <jsp:useBean id="memSvc" scope="page"	class="heibernate_com.mem.model.MemService" />	
<!-- 	 		利用表格裡的外來鍵 來找會員getOne的方法  join tomcat 7.0 以上  -->
					<td>${memSvc.getOneMem(reportVO.mem_Id_active).mem_name}</td>
					<td>${memSvc.getOneMem(reportVO.mem_Id_passive).mem_name}</td>	
									
					<td>${reportVO.report_time}</td>
					<td>${reportVO.report_status==1?'已審核':'尚未審核'}</td>
					
					<%--TEST用 --%>
<%-- 					<td>${reportVO.report_class_No_value}</td> --%>
					
					
															
					<td class="${reportVO.report_status==1?'Pass':''}" >
						<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/back-end/report/report.do">
							<input type="submit" class="btn btn-success" value="通過" onclick="sendMessage(${reportVO.report_class_No_value})" >
							

							<input type="hidden" name="report_No" value="${reportVO.report_No}"> 
							<input type="hidden" name="report_status" value="${reportVO.report_status}"> 
							
							<%-- 接收其他TABLE名稱  PK名稱  PK值 檢舉status的值  --%>
							<input type="hidden" name="report_class" value="${reportVO.report_class}"> 
							<input type="hidden" name="report_class_No" value="${reportVO.report_class_No}"> 
							<input type="hidden" name="report_class_No_value" value="${reportVO.report_class_No_value}"> 
							<input type="hidden" name="report_class_status" value="${reportVO.report_class_status}"> 
							<input type="hidden" name="action" value="Update&Update_front_status">
						</FORM>
						
					</td>
					
					<td class="${reportVO.report_status==1?'Pass':''} ">
						<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/back-end/report/report.do">
							<input type="submit" class="btn btn-danger" value="不通過">
							<input type="hidden" name="report_No" value="${reportVO.report_No}"> 
							<input type="hidden" name="action" value="Delete_Report_No">
						</FORM>
					</td>
					
					<td class="${reportVO.report_status==1?'Pass':''} ">
						<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/back-end/report/report.do">
							<input type="submit" class="btn btn-info" value="查看" >
							<input type="hidden" name="report_class" value="${reportVO.report_class}"> 
							<input type="hidden" name="report_class_No_value" value="${reportVO.report_class_No_value}"> 
							<input type="hidden" name="action" value="Check_ReportData">
						</FORM>
					</td>

				</tr>
			</c:forEach>	
			
			
			
			</tbody>
		
	</table>
	
			<div id="checkView">
			
			     <%if (request.getAttribute("emg_HVO")!=null){%>
				<jsp:include page="/front-end/emg_H/emg_H_detail_page.jsp" />
					<%} %>
					
					 <%if (request.getAttribute("adoptaniVO")!=null){%>
				<jsp:include page="/front-end/adoptani/listOneAdoptaniView.jsp" />
					<%} %>
					
					 <%if (request.getAttribute("hosVO")!=null){%>
				<jsp:include page="/front-end/hos/listOneHos_Index.jsp" />
					<%} %>
					
			</div>
	
			<script>
				
				//一開始先隱藏已審核的欄位
				$(".status_1").hide();
			
				// 已審核狀態把按鈕隱藏起來
				$(".Pass").hide();
			
				//按下已審核時  未審核欄位的隱藏
				$("#agree").click(function(){
					$(".status_0").hide();
					$(".status_1").show();	
					$("#checkView").hide();
				});
				
				//按下未審核時  已審核欄位的隱藏
				$("#NoAgree").click(function(){
					$(".status_1").hide();
					$(".status_0").show();
					$("#checkView").hide();
				});
				
				
				
				window.onload = function ()
				{	
					connect();
				}
				
				window.disonload = function (){
					disconnect ();
				}
				
				
				var MyPoint_report = "/MyEchoServer/"+"back-end_report"+"/"+"index"+"/report";
				//console.log(MyPoint1);
				var host = window.location.host;
				var path = window.location.pathname;
				var webCtx = path.substring(0, path.indexOf('/', 1));
				var endPointURL = "ws://" + window.location.host + webCtx + MyPoint_report;

				
				var webSocket;
				
				
				
				function connect() {
					// 建立 websocket 物件
					webSocket = new WebSocket(endPointURL);
					
					webSocket.onopen = function(event) {
					
					};
			
					webSocket.onmessage = function(event) {
						
					};
			
					webSocket.onclose = function(event) {
						
					};
				}
				
				
				function disconnect () {
					webSocket.close();
				}
				
				function sendMessage(report_No){
					webSocket.send(report_No);
				}
				
				
				
				
				
				
					
				
			
			</script>
	
	
	
				
	</body>
	

	
	
</html>