<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>

<%-- �����m�߱ĥ� EL ���g�k���� --%>

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
	<title>��|�Ӥ� - listPhotos_ByHosId.jsp</title>
</head>
<body bgcolor='white'>

<b><font color=red>�����m�߱ĥ� EL ���g�k����:</font></b>
<table border='1' cellpadding='5' cellspacing='0' width='800'>
	<tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
		<td>
		<h3>��|�Ӥ� - listPhotos_ByHosId.jsp</h3>
		<a href="<%=request.getContextPath()%>/select_page.jsp"><img src="images/back1.gif" width="100" height="32" border="0">�^����</a>
		</td>
	</tr>
</table>

<%-- ���~��C --%>
<c:if test="${not empty errorMsgs}">
	<font color='red'>�Эץ��H�U���~:
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
			    <input type="button" value="�s�W�Ӥ�" onclick="addInput()">
			    <input type="hidden" name="hos_Id" value="<%= request.getParameter("hos_Id") %>">
			    <input type="hidden" name="requestURL"	value="<%=request.getServletPath()%>"><!--�e�X�����������|��Controller-->
			    <input type="hidden" name="action"value="insert">
		</FORM>
			    <td><div id="output"></div></td>
			

<table border='1' bordercolor='#CCCCFF' width='800'>
	<tr>
		<th>�Ӥ��s��</th>
		<th>��|�W��</th>
		<th>�Ӥ�</th>
		<th>�O�_���j�Y�K</th>
		<th>�Ӥ��W��</th>
		<th>���ɦW</th>
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
			    <input type="submit" value="�R��" ${(hosPhotoVO.isDisp_HosPhoto=="1") ? 'disabled':''}>
			    <input type="hidden" name="hosPhoto_Id" value="${hosPhotoVO.hosPhoto_Id}">
			    <input type="hidden" name="hosPhoto_HosId" value="${hosPhotoVO.hosPhoto_HosId}">
			    <input type="hidden" name="isDisp_HosPhoto" value="${hosPhotoVO.isDisp_HosPhoto}">
			    <input type="hidden" name="requestURL"	value="<%=request.getServletPath()%>"><!--�e�X�����������|��Controller-->
			    <input type="hidden" name="action"value="delete"></FORM>
			</td>
			
			<td>
			<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/hos/hosPhoto.do">
			    <input type="submit" value="�]���j�Y�K" ${(hosPhotoVO.isDisp_HosPhoto=="1") ? 'disabled':''}>
			    <input type="hidden" name="hosPhoto_Id" value="${hosPhotoVO.hosPhoto_Id}">
			    <input type="hidden" name="hosPhoto_HosId" value="${hosPhotoVO.hosPhoto_HosId}">
			    <input type="hidden" name="requestURL"	value="<%=request.getServletPath()%>"><!--�e�X�����������|��Controller-->
			    <input type="hidden" name="action"value="setDisplayPhoto"></FORM>
			</td>
		</tr>
					
	</c:forEach>
</table>

<br>�����������|:<br><b>
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
