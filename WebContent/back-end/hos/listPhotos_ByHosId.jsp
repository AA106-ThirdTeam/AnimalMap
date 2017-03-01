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
	    	height:100px;
	    	width:100px;
	    }
	    
	    .dispPhoto{
	    	height:200px;
	    	width:200px;
	    }
	    
	     .enlarge{
	    	height:400px;
	    	width:400px;
	    	z-index: 50;
	    }
	   
    </style>
	<script src="http://code.jquery.com/jquery-1.10.1.min.js">  </script>
	<title>醫院照片 - listPhotos_ByHosId.jsp</title>
</head>
<body bgcolor='white'>

<b><font color=red>此頁練習採用 EL 的寫法取值:</font></b>
<table border='1' cellpadding='5' cellspacing='0' width='800'>
	<tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
		<td>
		<h3>醫院照片 - listPhotos_ByHosId.jsp</h3>
		<a href="<%=request.getContextPath()%>/select_page.jsp"><img src="images/back1.gif" width="100" height="32" border="0">回首頁</a>
		</td>
	</tr>
</table>

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



<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/hos/hosPhoto.do"
		 name="form1" enctype="multipart/form-data" >
				<input type="file" onchange="loadFile(event)" name="upfile1" multiple>
			    <input type="button" value="新增照片" onclick="addInput()">
			    <input type="hidden" name="hos_Id" value="<%= request.getParameter("hos_Id") %>">
			    <input type="hidden" name="requestURL"	value="<%=request.getServletPath()%>"><!--送出本網頁的路徑給Controller-->
			    <input type="hidden" name="action"value="insert">
		</FORM>
			    <td><div id="output"></div></td>
			

<table border='1' bordercolor='#CCCCFF' width='800'>
	<tr>
		<th>照片編號</th>
		<th>醫院名稱</th>
		<th>照片</th>
		<th>是否為大頭貼</th>
		<th>照片名稱</th>
		<th>副檔名</th>
	</tr>
	
	
	
	<%  
	Base64.Encoder encoder = Base64.getEncoder();   
	%>
	
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
		<tr align='center' valign='middle'>
			<td>${hosPhotoVO.hosPhoto_Id}</td>
			
			<td>
				<c:forEach var="hosVO" items="${HosSvc.all}">
                    <c:if test="${hosPhotoVO.hosPhoto_HosId==hosVO.hos_Id}">
	                    ${hosVO.hos_name}
                    </c:if>
                </c:forEach>
			</td>
			
			<td><img src="data:image/png;base64, <%= encodedText %>" alt="Red dot" class="dispPhoto"></td>
			<td>${hosPhotoVO.isDisp_HosPhoto}</td>
			<td>${hosPhotoVO.hosPhoto_name}</td>
			<td>${hosPhotoVO.hosPhoto_extention}</td>			
						
			<td>
			  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/hos/hosPhoto.do">
			    <input type="submit" value="刪除" ${(hosPhotoVO.isDisp_HosPhoto=="1") ? 'disabled':''}>
			    <input type="hidden" name="hosPhoto_Id" value="${hosPhotoVO.hosPhoto_Id}">
			    <input type="hidden" name="hosPhoto_HosId" value="${hosPhotoVO.hosPhoto_HosId}">
			    <input type="hidden" name="isDisp_HosPhoto" value="${hosPhotoVO.isDisp_HosPhoto}">
			    <input type="hidden" name="requestURL"	value="<%=request.getServletPath()%>"><!--送出本網頁的路徑給Controller-->
			    <input type="hidden" name="action"value="delete"></FORM>
			</td>
			
			<td>
			<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/hos/hosPhoto.do">
			    <input type="submit" value="設為大頭貼" ${(hosPhotoVO.isDisp_HosPhoto=="1") ? 'disabled':''}>
			    <input type="hidden" name="hosPhoto_Id" value="${hosPhotoVO.hosPhoto_Id}">
			    <input type="hidden" name="hosPhoto_HosId" value="${hosPhotoVO.hosPhoto_HosId}">
			    <input type="hidden" name="requestURL"	value="<%=request.getServletPath()%>"><!--送出本網頁的路徑給Controller-->
			    <input type="hidden" name="action"value="setDisplayPhoto"></FORM>
			</td>
		</tr>
					
	</c:forEach>
</table>

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
