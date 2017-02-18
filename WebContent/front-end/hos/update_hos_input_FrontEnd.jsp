<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page import="com.hos.model.*"%>

<%
HosVO hosVO = (HosVO) request.getAttribute("hosVO");
%>

<html lang="">
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>Title Page</title>
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
		<!--[if lt IE 9]>
			<script src="https://cdnjs.cloudflare.com/ajax/libs/html5shiv/3.7.3/html5shiv.min.js"></script>
			<script src="https://cdnjs.cloudflare.com/ajax/libs/respond.js/1.4.2/respond.min.js"></script>
		<![endif]-->

	</head>
	<body>
		<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/hos/hos.do">
		<div class="container">
			<div class="row">
			    <div class="form-group col-xs-12 col-sm-12">
			      <label for="usr">醫院名稱:</label>
			       <div class="input-group">
				      <span class="input-group-addon"><i class="glyphicon glyphicon-home"></i></span>
				      <input type="text" class="form-control" id="usr" name="hos_name" value="<%= (hosVO==null)? "JAVA動物醫院" : hosVO.getHos_name()%>">
				    </div>
			    </div>
			  </div>
			  <div class="row">
			    <div class="form-group col-xs-12 col-sm-12">
			      <label for="usr">市:</label>
			       <div class="input-group">
				      <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
				      <input type="text" class="form-control" id="usr" name="hos_city" size="45"
			value="<%= (hosVO==null)? "桃園市" : hosVO.getHos_city()%>">
				    </div>
			    </div>
			  </div>
			  <div class="row">
			    <div class="form-group col-xs-12 col-sm-12">
			      <label for="usr">區:</label>
			      <div class="input-group">
				      <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
				      <input type="text" class="form-control" id="usr" name="hos_town" size="45" value="<%= (hosVO==null)? "中壢區" : hosVO.getHos_town()%>"> 
				    </div>
			    </div>
			  </div>
			  <div class="row">
			    <div class="form-group col-xs-12 col-sm-12">
			      <label for="usr">路:</label>
			       <div class="input-group">
				      <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
				      <input type="text" class="form-control" id="usr" name="hos_road" size="45"
			value="<%= (hosVO==null)? "中大路" : hosVO.getHos_road()%>">
				    </div>
			    </div>
			  </div>
			  <div class="row">
			    <div class="form-group col-xs-12 col-sm-12">
			      <label for="usr">開始營業時間:</label>
			       <div class="input-group">
				      <span class="input-group-addon"><i class="glyphicon glyphicon-time"
				       style="color:green"></i></span>
					  <input type="hidden" class="form-control date start" id="usr">
				      <input type="text" class="form-control time start" id="usr" name="hos_StartTime" 
				      value="<%= (hosVO==null)? "07:30 AM" : hosVO.getHos_StartTime()%>">
				    </div>
			    </div>
			  </div>
			  <div class="row">
			    <div class="form-group col-xs-12 col-sm-12">
			      <label for="usr">結束營業時間:</label>
			      <div class="input-group">
				      <span class="input-group-addon"><i class="glyphicon glyphicon-time"
				       style="color:red"></i></span>
 					  <input type="hidden" class="form-control date end" id="usr">
				      <input type="text" class="form-control time end" id="usr" name="hos_EndTime" 
				      value="<%= (hosVO==null)? "07:30 PM" : hosVO.getHos_EndTime()%>">
				    </div>
			    </div>
			  </div>
			  <div class="row">
			    <div class="form-group col-xs-12 col-sm-12">
			      <label for="usr">聯絡電話:</label>
			       <div class="input-group">
				      <span class="input-group-addon"><i class="glyphicon glyphicon-phone-alt"></i></span>
				      <input type="text" class="form-control" id="usr" name="hos_Tel" size="200" value=" <%= (hosVO==null)? "" : hosVO.getHos_Tel()%>">
				    </div>
			    </div>
			  </div>

			  <div class="row">
			    <div class="form-group col-xs-12 col-sm-12">
			    <label for="usr">醫院網址:</label>
				    <div class="input-group">
				      <span class="input-group-addon"><i class="glyphicon glyphicon-globe"></i></span>
				      <input type="text" class="form-control" id="usr" name="hos_URL" size="200" value=" <%= (hosVO==null)? "" : hosVO.getHos_URL()%>">
				    </div>
			    </div>
			  </div>

			  <div class="row">
			    <div class="form-group col-xs-12 col-sm-12 ">
			      <label for="comment">診所敘述:</label>
			      <textarea class="form-control" rows="5" id="comment" maxlength="300" name="hos_Desc" 
		><%= (hosVO==null)? "" : hosVO.getHos_Desc()%></textarea>
			    </div>
 			 </div>
		</div>
		
		
		
  		<input type="hidden" name="action" value="update">
		<input type="hidden" name="hos_Id" value="<%=hosVO.getHos_Id()%>">
		<input type="hidden" name="requestURL" value="<%=request.getParameter("requestURL")%>"><!--接收原送出修改的來源網頁路徑後,再送給Controller準備轉交之用-->
		<input type="hidden" name="whichPage" value="<%=request.getParameter("whichPage")%>">  <!--用於:istAllEmp.jsp 與 複合查詢 listEmps_ByCompositeQuery.jsp-->
		<input type="submit" value="送出新增">
		</FORM>

		
		<script src="https://code.jquery.com/jquery.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
	</body>
</html>