<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>

<%-- 此頁練習採用 EL 的寫法取值 --%>

<jsp:useBean id="listPhotos_ByHosId" scope="request" type="java.util.Set" />
<jsp:useBean id="HosSvc" scope="page" class="com.hos.model.HosService" />
<html>
<head>
	<style>
	    #forUpload{
	    	height:200px;
	    	width:200px;
	    	border-radius:10px;
	    }
	    
	    .dispPhoto{
	    	height:200px;
	    	width:215px;
	    }
	    
	     .enlarge{
	    	height:300px;
	    	width:350px;
	    	z-index: 50;
	    	position:absolute;
	    }
	   
    </style>
	<script src="http://code.jquery.com/jquery-1.10.1.min.js">  </script>
	<title>醫院照片 - listPhotos_ByHosId.jsp</title>
</head>
<body bgcolor='white'>

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

		


<%-- 		<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/hos/hosPhoto.do" --%>
<!-- 		 name="form1" enctype="multipart/form-data" style="margin-bottom:0px"> -->
<!-- 				<input type="file" onchange="loadFile(event)" name="upfile1" multiple> -->
<!-- 			    <input type="button" value="新增照片" onclick="addInput()"> -->
<%-- 			    <input type="hidden" name="hos_Id" value="<%= request.getParameter("hos_Id") %>"> --%>
<%-- 			    <input type="hidden" name="requestURL"	value="<%=request.getServletPath()%>"><!--送出本網頁的路徑給Controller--> --%>
<!-- 			    <input type="hidden" name="action"value="insert"> -->
<!-- 		</FORM> -->
<!-- <div class="row"> -->
<!-- 	<div class="col-xs-12 col-sm-4" style="margin-top: 10px"> -->
<%-- 		<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/hos/hosPhoto.do" --%>
<!-- 			 name="form1" enctype="multipart/form-data" style="margin-bottom:0px"> -->
<!-- 			<div class="input-group"> -->
<!-- 				<input type="file" class="form-control" onchange="loadFile(event)"  name="upfile1" multiple>  -->
<!-- 				<span class="input-group-btn"> -->
<!-- 					<button class="btn btn-info" type="button" onclick="addInput()">上傳相片</button> -->
<!-- 				</span> -->
<!-- 			</div> -->
<%-- 			<input type="hidden" name="hos_Id" value="<%= request.getParameter("hos_Id") %>"> --%>
<%-- 			<input type="hidden" name="requestURL"	value="<%=request.getServletPath()%>"><!--送出本網頁的路徑給Controller--> --%>
<!-- 			<input type="hidden" name="action"value="insert"> -->
<!-- 		</FORM> -->
<!-- 			<div id="output"></div> -->
<!-- 	</div> -->
<!-- </div>			 -->
	<%  
	Base64.Encoder encoder = Base64.getEncoder();   
	%>
	
	
	<div class="container" style="width: 700px;padding:0px">
		<div class="row">
			
			<div class="col-xs-12 col-sm-12" style="margin-top: 10px">
				<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/hos/hosPhoto.do"
					 name="form1" enctype="multipart/form-data" style="margin-bottom:0px">
					<div class="input-group">
						<input type="file" class="form-control" onchange="loadFile(event)"  name="upfile1" multiple> 
						<span class="input-group-btn">
							<button class="btn btn-info" type="button" onclick="addInput()">上傳相片</button>
						</span>
					</div>
					<input type="hidden" name="hos_Id" value="<%= request.getParameter("hos_Id") %>">
					<input type="hidden" name="requestURL"	value="<%=request.getServletPath()%>"><!--送出本網頁的路徑給Controller-->
					<input type="hidden" name="action"value="insert">
				</FORM>
					<div id="output"></div>
			</div>
			
	<c:forEach var="hosPhotoVO" items="${listPhotos_ByHosId}" varStatus="s">
		<c:set var="hosPhoto" value="${hosPhotoVO.hosPhoto_photo}" scope="request"/>
		<% 
			byte[] imageByte = (byte[])request.getAttribute("hosPhoto");
			String encodedText="";
			if(imageByte!=null){
				encodedText = encoder.encodeToString(imageByte);
			}
			  
// 			System.out.println(encodedText);  
		%>		
		
			
			<div class="col-xs-12 col-sm-4" style="margin-top: 10px">
				
				<img src="data:image/png;base64, <%= encodedText %>" alt="Red dot" class="dispPhoto">
				<div class="row">
					<div class="col-xs-12 col-sm-6">
						<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/hos/hosPhoto.do">
						<button type="submit" class="btn-xs btn-info btn-block" id="dispPhoto" 
							${(hosPhotoVO.isDisp_HosPhoto=="1") ? 'disabled':''}style="margin-right: 5px">設為封面照片</button>
						<input type="hidden" name="hosPhoto_Id" value="${hosPhotoVO.hosPhoto_Id}">
						<input type="hidden" name="hosPhoto_HosId" value="${hosPhotoVO.hosPhoto_HosId}">
						<input type="hidden" name="requestURL"	value="<%=request.getServletPath()%>"><!--送出本網頁的路徑給Controller-->
						<input type="hidden" name="action"value="setDisplayPhoto"></FORM>
					</div>
					<div class="col-xs-12 col-sm-6">
						<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/hos/hosPhoto.do">
						<button type="submit" class="btn-xs btn-danger btn-block" id="deletePhoto"
						  	${(hosPhotoVO.isDisp_HosPhoto=="1") ? 'disabled':''} style="margin-right: 5px">刪除</button>
						<input type="hidden" name="hosPhoto_Id" value="${hosPhotoVO.hosPhoto_Id}">
						<input type="hidden" name="hosPhoto_HosId" value="${hosPhotoVO.hosPhoto_HosId}">
						<input type="hidden" name="isDisp_HosPhoto" value="${hosPhotoVO.isDisp_HosPhoto}">
						<input type="hidden" name="requestURL"	value="<%=request.getServletPath()%>"><!--送出本網頁的路徑給Controller-->
						<input type="hidden" name="action"value="delete"></FORM>
					</div>			
				</div>
			</div>		
	</c:forEach>
		</div>
	</div>


<br>本網頁的路徑:<br><b>
   <font color=blue>request.getServletPath():</font> <%= request.getServletPath()%><br>
   <font color=blue>request.getRequestURI(): </font> <%= request.getRequestURI()%> </b>
</body>


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
	
	$(".dispPhoto").click(function(){
		$(this).toggleClass("enlarge");
	});
	
</script>

</html>
