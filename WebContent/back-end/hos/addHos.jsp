<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page import="com.hos.model.*"%>

<%
HosVO hosVO = (HosVO) request.getAttribute("hosVO");
%>

<html>
<head>

<style>
    .selected {
        border: 2px dotted red;
    }
    
    
    #forUpload{
    	height:100px;
    	width:100px;
    }
   
    </style>
<script src="http://code.jquery.com/jquery-1.10.1.min.js">  </script>
<title>�ʪ���|��Ʒs�W - addHos.jsp</title>


</head>



<body bgcolor='white'>

<table border='1' cellpadding='5' cellspacing='0' width='400'>
	<tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
		<td>
		<h3>�ʪ���|��Ʒs�W - addHos.jsp</h3>
		</td>
		<td>
		   <a href="select_page.jsp"><img src="js/avatar.jpg" width="100" height="100" border="1">�^����</a>
	    </td>
	</tr>
</table>

<h3>�s�W��|���:</h3>
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

<FORM method=post ACTION="<%=request.getContextPath()%>/hos/hos.do" name="form1" enctype="multipart/form-data"  >
<table border="0">

	<tr>
		<td>�E�ҦW��:</td>
		<td><input type="TEXT" name="hos_name" size="45" 
			value="<%= (hosVO==null)? "JAVA�ʪ���|" : hosVO.getHos_name()%>" /></td>
	</tr>
	<tr>
		<td>�t�d�H:</td>
		<td><input type="TEXT" name="hos_MemId" size="45"
			value="<%= (hosVO==null)? "�d�ç�" : hosVO.getHos_MemId()%>" /></td>
	</tr>
	<tr>
<%-- 		<%java.sql.Date date_SQL = new java.sql.Date(System.currentTimeMillis());%> --%>
		
		<td>
		<div id="basicExample">
		�}�l��~�ɶ�:
		<input type="text" class="date start" hidden/>		
		<input type="text" class="time start" name="hos_StartTime" 
		value="<%= (hosVO==null)? "07:30 AM" : hosVO.getHos_StartTime()%>" /> to<br/>
		������~�ɶ�:
		<input type="text" class="date end" hidden/>
		<input type="text" class="time end" name="hos_EndTime" value="<%= (hosVO==null)? "07:30 PM" : hosVO.getHos_EndTime()%>" />
		</div>
		</td>
	</tr>
	
	<tr>
		<td>�a�}</td>
		<td></td>
	</tr>
	
	
	<tr>
		<td>��:</td>
		<td><input type="TEXT" name="hos_city" size="45"
			value="<%= (hosVO==null)? "��饫" : hosVO.getHos_city()%>" /></td>
	</tr>
	<tr>
		<td>��:</td>
		<td><input type="TEXT" name="hos_town" size="45"
			value="<%= (hosVO==null)? "���c��" : hosVO.getHos_town()%>" /></td>
	</tr>
	<tr>
		<td>��:</td>
		<td><input type="TEXT" name="hos_road" size="45"
			value="<%= (hosVO==null)? "���j��" : hosVO.getHos_road()%>" /></td>
	</tr>
	
	<tr>
		<td>��|²��:</td>
		<td>
		<textarea style="height:2em" rows="1" cols="20" 
		id="text"  maxlength="300" name="hos_Desc" 
		><%= (hosVO==null)? "" : hosVO.getHos_Desc()%></textarea>
		</td>
	</tr>
	
	<tr>
		<td>�g��:</td>
		<td>
		<input type="text" name="hos_Long" size="100" value=" <%= (hosVO==null)? "" : hosVO.getHos_Long()%>"/>
		</td>
	</tr>
	<tr>
		<td>�n��:</td>
		<td>
		<input type="text" name="hos_Lat" size="100" value=" <%= (hosVO==null)? "" : hosVO.getHos_Lat()%>"/>
		</td>
	</tr>
	
	<tr>
		<td>�a�ϤW���:<font color=red><b>?</b></font></td>
		<td><select size="1" name="hos_visible">
			<option value="0" ${(hosVO.hos_visible==0)? 'selected':'' } >No
			<option value="1" ${(hosVO.hos_visible==1)? 'selected':'' } >Yes
		</select>
		</td>
	</tr>
	
	
	<tr>
		<td>����:</td>
		<td>
		<input type="text" name="hos_Eval" size="100" value=" <%= (hosVO==null)? "" : hosVO.getHos_Eval()%>"/>
		</td>
	</tr>
	<tr>
		<td>���}:</td>
		<td>
		<input type="text" name="hos_URL" size="200" value=" <%= (hosVO==null)? "" : hosVO.getHos_URL()%>"/>
		</td>
	</tr>
	<tr>
		<td>�q��:</td>
		<td>
		<input type="text" name="hos_Tel" size="45" value=" <%= (hosVO==null)? "" : hosVO.getHos_Tel()%>"/>
		</td>
	</tr>

	<tr>
		<td><input type="file" onchange="loadFile(event)" name="upfile1" multiple></td>
       <td><div id="output"></div></td>
	</tr>
	 

</table>
<br>
<input type="hidden" name="action" value="insert">
<input type="button" value=�e�X�s�W onclick="addInput()"/>
</FORM>
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

</script>





</html>
