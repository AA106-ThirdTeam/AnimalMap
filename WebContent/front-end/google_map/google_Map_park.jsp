<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.InputStreamReader"%>
<%@page import="java.io.FileReader"%>
<%@page import="java.io.BufferedReader"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>    
<%@ page import="heibernate_com.park.model.*"%>	
<%
    ParkService parkSvc = new ParkService();
    List<ParkVO> list_park = parkSvc.getAll();
    pageContext.setAttribute("list",list_park);
    
    
    int park_map_icon_size = 24;
%>

<script>
	map.tinyMap('modify',{
		'marker': [	
	<%
	int tem_int = 0;
	
	
	for(ParkVO vo:list_park){
		if(tem_int>0){
			%>
			,
			<%
		}
	%>	
			{'addr': ['<%=vo.getPark_lon()%>', '<%=vo.getPark_lat()%>']
				, 'text':
					'<div class="container-fluid well span6"> <div class="row-fluid"> <div class="span2" > <img src="https://secure.gravatar.com/avatar/de9b11d0f9c0569ba917393ed5e5b3ab?s=140&r=g&d=mm" class="img-circle"> </div> <div class="span8"> <h3>User Name</h3> <h6>Email: MyEmail@servidor.com</h6> <h6>Ubication: Colombia</h6> <h6>Old: 1 Year</h6> <h6><a href="#">More... </a></h6> </div> <div class="span2"> <div class="btn-group"> <a class="btn dropdown-toggle btn-info" data-toggle="dropdown" href="#"> Action <span class="icon-cog icon-white"></span><span class="caret"></span> </a> <ul class="dropdown-menu"> <li><a href="#"><span class="icon-wrench"></span> Modify</a></li> <li><a href="#"><span class="icon-trash"></span> Delete</a></li> </ul> </div> </div> </div> </div>'
	            ,'icon': {
	                'url': 'https://maxcdn.icons8.com/Color/PNG/24/City/dog_park-24.png'
	                ,'scaledSize': [<%=park_map_icon_size%>, <%=park_map_icon_size%>]
	            }
			},
	<%}%>
		]/* marker結尾  */
	});
</script>





