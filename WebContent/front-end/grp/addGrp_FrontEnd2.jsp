<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page import="heibernate_com.mem.model.MemVO"%>
<%@ page import="com.grp.model.*"%>
<%@ page import="java.text.*"%>
<%@ page import="java.util.*"%>

<%
GrpVO grpVO = (GrpVO) request.getAttribute("grpVO");

//**************************************************以下測試用
	MemVO memVO = (MemVO)session.getAttribute("account");
	String mem_Id = memVO.getMem_Id();
	
	session.setAttribute("loginMemId",mem_Id);

String lat = request.getParameter("grp_Lat");
String lon = request.getParameter("grp_Long");

System.out.println(lat);
System.out.println(lon);

%>

<html>
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>Title Page</title>
		
		<link rel="stylesheet" href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" />
		<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
		<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
		<link href="js/jquery-ui-timepicker-addon.css" rel="stylesheet"></link>
		<script src="js/jquery-ui-timepicker-addon.js" type="text/javascript"></script>
		<script src="js/jquery-ui-sliderAccess.js" type="text/javascript"></script>
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
		<!--[if lt IE 9]>
			<script src="https://cdnjs.cloudflare.com/ajax/libs/html5shiv/3.7.3/html5shiv.min.js"></script>
			<script src="https://cdnjs.cloudflare.com/ajax/libs/respond.js/1.4.2/respond.min.js"></script>
		<![endif]-->
	
		

	</head>
	<body>
	
<c:if test="${not empty errorMsgs}">
	<font color='red'>請修正以下錯誤:
	<p>
		<c:forEach var="message" items="${errorMsgs}">
			<li>${message}</li>
		</c:forEach>
	</p>
	</font>
</c:if>
	
		<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/grp/grp.do" name="form1" enctype="multipart/form-data">
		<div class="container">
		
			<div class="row">
			    <div class="form-group col-xs-12 col-sm-12">
			      <label for="usr">揪團名稱:</label>
			       <div class="input-group">
				      <span class="input-group-addon"><i class="glyphicon glyphicon-home"></i></span>
				      <input type="text" name="grp_name" class="form-control"
					value="<%=(grpVO == null) ? "JAVA動物團" : grpVO.getGrp_name()%>" />
				    </div>
			    </div>
			  </div>
			  
			  <div class="row">
			    <div class="form-group col-xs-12 col-sm-12">
			      <label for="usr">市:</label>
			       <div class="input-group">
				      <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
				      <input type="TEXT" name="grp_city" class="form-control"
					value="<%=(grpVO == null) ? "桃園市" : grpVO.getGrp_city()%>" />
				    </div>
			    </div>
			  </div>
			  
			  <div class="row">
			    <div class="form-group col-xs-12 col-sm-12">
			      <label for="usr">區:</label>
			      <div class="input-group">
				      <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
				      				<input type="TEXT" name="grp_town" class="form-control"
					value="<%=(grpVO == null) ? "中壢區" : grpVO.getGrp_town()%>" />
				    </div>
			    </div>
			  </div>
			  
			  <div class="row">
			    <div class="form-group col-xs-12 col-sm-12">
			      <label for="usr">路:</label>
			       <div class="input-group">
				      <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
				      <input type="TEXT" name="grp_road" class="form-control"
					value="<%=(grpVO == null) ? "中大路" : grpVO.getGrp_road()%>" />
				    </div>
			    </div>
			  </div>
			  
			  
			  <%
				String startStr = null;
				String endStr = null;

				if (grpVO != null) {
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
					startStr = sdf.format(grpVO.getGrp_StartTime());
					endStr = sdf.format(grpVO.getGrp_EndTime());
				}

				String now = new SimpleDateFormat("yyyy-MM-dd HH:mm")
						.format(new Date(System.currentTimeMillis()));
			%>
			  
			  <div class="row">
			    <div class="form-group col-xs-12 col-sm-12">
			      <label for="usr">揪團開始時間:</label>
			       <div class="input-group">
				      <span class="input-group-addon"><i class="glyphicon glyphicon-time"
				       style="color:green"></i></span>
<!-- 				       <input type="hidden" class="form-control" id="usr"> -->
					  <input id="datetimepicker1" type="text" class="form-control"
					name="grp_StartTime" value="<%=(grpVO == null) ? now : startStr%>" />
				    </div>
			    </div>
			  </div>
			  
			  <div class="row">
			    <div class="form-group col-xs-12 col-sm-12">
			      <label for="usr">揪團結束時間:</label>
			      <div class="input-group">
				      <span class="input-group-addon"><i class="glyphicon glyphicon-time"
				       style="color:red"></i></span>
<!--  					  <input type="hidden" class="form-control" id="usr"> -->
				     <input id="datetimepicker2" type="text" name="grp_EndTime" class="form-control"
					value="<%=(grpVO == null) ? now : endStr%>" />
				    </div>
			    </div>
			  </div>
			  
			  <div class="row">
			    <div class="form-group col-xs-12 col-sm-12 ">
			      <label for="comment">揪團簡介:</label>
			      <textarea class="form-control" rows="5" id="comment" maxlength="300" name="grp_Desc" id="grpDesc"><%=(grpVO == null) ? "" : grpVO.getGrp_Desc()%></textarea>
			    </div>
 			 </div>
 			 
 			<div class="col-xs-12 col-sm-12" style="margin-top: 10px">
				
					<div class="input-group">
					<label class="btn btn-primary" for="my-file-selector">
					    <input id="my-file-selector" type="file" style="display:none;" class="form-control  imgInp" name="grp_photo" >
					    	上傳相片
					</label>
					<span class='label label-info' id="upload-file-info"></span>		
					</div>
					
					<img id="blah" style="max-width: 100px; max-height: 100px">
			</div>
			<div class="col-xs-12 col-sm-12" style="margin-top: 10px">
		<button type="submit" class="btn btn-primary btn-block"> 送出新增</button>
              </div>
		</div>
		<input type="hidden" name="grp_Lat" value="<%=lat%>">
		<input type="hidden" name="grp_Long" value="<%=lon%>">
  		<input type="hidden" name="grp_MemId" value="${loginMemId}">
  		<input type="hidden" name="action" value="insert">
		<input type="hidden" name="requestURL" value="<%=request.getServletPath()%>"><!--接收原送出修改的來源網頁路徑後,再送給Controller準備轉交之用-->
		</FORM>
		<button type="button" id="mBtn">mBtn</button>
		<script>
	function readURL(input) {

		if (input.files && input.files[0]) {
			var reader = new FileReader();

			reader.onload = function(e) {

				$('#blah').attr('src', e.target.result);
			}

			reader.readAsDataURL(input.files[0]);
		}
	}

	$(".imgInp").click(function() {
		$('#blah').attr('src', '');
	});

	$(".imgInp").change(function() {
		readURL(this);
	});

	var opt = {
		dateFormat : 'yy-mm-dd',
		showSecond : false,
		timeFormat : 'HH:mm'
	};
	$('#datetimepicker1').datetimepicker(opt);
	$('#datetimepicker2').datetimepicker(opt);
	
	$('#datetimepicker1').focus(function(){
	    $(this).attr('readonly', true);
	});
	
	$('#datetimepicker2').focus(function(){
	    $(this).attr('readonly', true);
	});
	
	
	
</script>
<script type="text/javascript"
	  src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAzie-Spi1NZQ8nEuj_oCbsN5X2B7DZkGI&libraries=geometry&signed_in=true&callback=initMap">
</script> 
<script>
	
	$("#mBtn").click(function(){
		$("#grpDesc").val("慶祝收養成功，一起出遊去~~~~~");
	})
	
	var geocoder = new google.maps.Geocoder();
	// google.maps.LatLng 物件
	var coord = new google.maps.LatLng(<%= (grpVO==null)? lat : grpVO.getGrp_Lat()%>,<%= (grpVO==null)? lon : grpVO.getGrp_Long()%>);
	// 傳入 latLng 資訊至 geocoder.geocode
	geocoder.geocode({'latLng': coord }, function(results, status) {
	  if (status === google.maps.GeocoderStatus.OK) {
	    // 如果有資料就會回傳
	    if (results) {
	      console.log(results[0]);
	      console.log(results[0].formatted_address);
	      console.log(results[0].formatted_address.split("市"));
	      console.log(results[0].address_components[0].long_name);
	      var address = results[0].formatted_address;
	      var address2 = results[0].address_components;
	      var countNumber = address2.length;
	      var countNumber2 = address2.length-4;
	      
	      
// 	      $('input[name="Adopt_Ani_city"]').val(address2[countNumber-1].long_name+address2[countNumber-2].long_name+address2[countNumber-3].long_name);
	      $('input[name="grp_city"]').val(address2[countNumber-3].long_name);
	      $('input[name="grp_town"]').val(address2[countNumber-4].long_name);
	      var add="";
	      
	      for(i=countNumber2-1; i>=0;i--){
	     		add +=  address2[i].long_name;
	      }
	      
	      $('input[name="grp_road]').val(add);
	      
	    
	 	 }
	  // 經緯度資訊錯誤
	  else {
	    alert("Reverse Geocoding failed because: " + status);
	  }
	  }
	});
	
	
</script>

	</body>
</html>