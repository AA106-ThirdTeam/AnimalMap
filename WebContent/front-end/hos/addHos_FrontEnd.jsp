<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page import="com.hos.model.*"%>

<%
HosVO hosVO = (HosVO) request.getAttribute("hosVO");

//**************************************************�H�U���ե�
session.setAttribute("loginMemId","1000001");
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
	<style>
	    .selected {
	        border: 2px dotted red;
	        height:200px !important;
	    	width:200px !important;
	    }
	    
	    
	    #forUpload{
	    	height:100px;
	    	width:100px;
	   		border-radius:10px;
	    }
	    
	 
	    
   
    </style>
		
		

	</head>
	<body>
	
<c:if test="${not empty errorMsgs}">
	<font color='red'>�Эץ��H�U���~:
	<p>
		<c:forEach var="message" items="${errorMsgs}">
			<li>${message}</li>
		</c:forEach>
	</p>
	</font>
</c:if>
	
	
	
		<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/hos/hos.do" name="form1" enctype="multipart/form-data">
		<div class="container">
			<div class="row">
			    <div class="form-group col-xs-12 col-sm-12">
			      <label for="usr">��|�W��:</label>
			       <div class="input-group">
				      <span class="input-group-addon"><i class="glyphicon glyphicon-home"></i></span>
				      <input type="text" class="form-control" id="usr" name="hos_name" value="<%= (hosVO==null)? "JAVA�ʪ���|" : hosVO.getHos_name()%>">
				    </div>
			    </div>
			  </div>
			  <div class="row">
			    <div class="form-group col-xs-12 col-sm-12">
			      <label for="usr">��:</label>
			       <div class="input-group">
				      <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
				      <input type="text" class="form-control" id="usr" name="hos_city" size="45"
			value="<%= (hosVO==null)? "��饫" : hosVO.getHos_city()%>">
				    </div>
			    </div>
			  </div>
			  <div class="row">
			    <div class="form-group col-xs-12 col-sm-12">
			      <label for="usr">��:</label>
			      <div class="input-group">
				      <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
				      <input type="text" class="form-control" id="usr" name="hos_town" size="45" value="<%= (hosVO==null)? "���c��" : hosVO.getHos_town()%>"> 
				    </div>
			    </div>
			  </div>
			  <div class="row">
			    <div class="form-group col-xs-12 col-sm-12">
			      <label for="usr">��:</label>
			       <div class="input-group">
				      <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
				      <input type="text" class="form-control" id="usr" name="hos_road" size="45"
			value="<%= (hosVO==null)? "���j��" : hosVO.getHos_road()%>">
				    </div>
			    </div>
			  </div>
			  <div class="row">
			    <div class="form-group col-xs-12 col-sm-12">
			      <label for="usr">�}�l��~�ɶ�:</label>
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
			      <label for="usr">������~�ɶ�:</label>
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
			      <label for="usr">�p���q��:</label>
			       <div class="input-group">
				      <span class="input-group-addon"><i class="glyphicon glyphicon-phone-alt"></i></span>
				      <input type="text" class="form-control" id="usr" name="hos_Tel" size="200" value=" <%= (hosVO==null)? "" : hosVO.getHos_Tel()%>">
				    </div>
			    </div>
			  </div>

			  <div class="row">
			    <div class="form-group col-xs-12 col-sm-12">
			    <label for="usr">��|���}:</label>
				    <div class="input-group">
				      <span class="input-group-addon"><i class="glyphicon glyphicon-globe"></i></span>
				      <input type="text" class="form-control" id="usr" name="hos_URL" size="200" value=" <%= (hosVO==null)? "" : hosVO.getHos_URL()%>">
				    </div>
			    </div>
			  </div>

			  <div class="row">
			    <div class="form-group col-xs-12 col-sm-12 ">
			      <label for="comment">�E�ұԭz:</label>
			      <textarea class="form-control" rows="5" id="comment" maxlength="300" name="hos_Desc" 
		><%= (hosVO==null)? "" : hosVO.getHos_Desc()%></textarea>
			    </div>
 			 </div>
 			 
 			<div class="col-xs-12 col-sm-12" style="margin-top: 10px">
				
					<div class="input-group">
					<label class="btn btn-primary" for="my-file-selector">
					    <input id="my-file-selector" type="file" style="display:none;" onchange="loadFile(event);" class="form-control"  name="upfile1" multiple>
					    	�W�Ǭۤ�
					</label>
					<span class='label label-info' id="upload-file-info"></span>		
					</div>
					
					<div id="output" style="margin-top: 10px"></div>
			</div>
			<div class="col-xs-12 col-sm-12" style="margin-top: 10px">
		<button type="submit" class="btn btn-primary btn-block"  onclick="addInput()"> �e�X�s�W</button>
              </div>
		</div>
		
  		<input type="hidden" name="hos_MemId" value="${loginMemId}">
  		<input type="hidden" name="action" value="insert">
		<input type="hidden" name="requestURL" value="<%=request.getServletPath()%>"><!--������e�X�ק諸�ӷ��������|��,�A�e��Controller�ǳ���椧��-->
		</FORM>
		
		<script>
// var length;
	var output = document.getElementById("output");
	
	var loadFile = function(e) {
	
	    while (output.hasChildNodes()) {
	        output.removeChild(output.childNodes[0]);
	    }
	    
	    var evt = e ? e.target : e.srcElement;
	    var file = evt.files
	    length = file.length;
	
	    
	    for (var i = 0; i < length; i++) {
	        var img = document.createElement("img");
	        
	        document.getElementById("output").appendChild(img);
			
	
	        $("#output img").attr("id","forUpload");
	        
	        document.querySelectorAll("#forUpload")[i].addEventListener("click", function(e) {
	            var evt = e ? e.target : e.srcElement;
	                      
	            if (!evt.hasAttribute("class")) {
	            	
	            	$("#output img").removeAttr("class");
	            	
	                evt.setAttribute("class", "selected");
	            } else {
	                evt.removeAttribute("class");
	            }
	            
	        }, false);
	    
	        document.querySelectorAll("#forUpload")[i].src = URL.createObjectURL(file[i]);
	
	//         console.log(length);
	//         console.log(URL.createObjectURL(file[i]));
	
	//         document.getElementsByTagName("img")[i].onload = function() {
	//             window.URL.revokeObjectURL(this.src);
	//         }
	    }
        
	};

	function addInput(){
		var forUpload = document.querySelectorAll("#forUpload");
		
		for(var i =0;i <forUpload.length ; i++){
			if(forUpload[i].hasAttribute("class")&&!(forUpload[i].hasAttribute("name"))){
				var input = document.createElement("input");
				forUpload[i].appendChild(input).setAttribute("name", "isDisplayPhoto");
				$("[name='isDisplayPhoto']").attr("value",i);
				$("[name='isDisplayPhoto']").attr("type","hidden");
			}
		}
		
		$("[name='form1']").submit();
	}

</script>
		
		
		<script src="https://code.jquery.com/jquery.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
	</body>
</html>