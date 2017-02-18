<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>    
<%@ page import="heibernate_com.park.model.*"%>	
<%
    ParkService parkSvc = new ParkService();
    List<ParkVO> list_park = parkSvc.getAll();
    pageContext.setAttribute("list",list_park);
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
		tem_int++;
	%>	
			{'addr': ['<%=vo.getPark_lon()%>', '<%=vo.getPark_lat()%>']
				, 'text': '標題 :<%=vo.getPark_title()%> <br>內容 : <%=vo.getPark_content()%>'	
	            ,'icon': {
	                'url': 'https://icons8.com/web-app/19845/Dog-Park'
	                ,'scaledSize': [24, 24]
	            }				
			},    
	<%}%>
		]/* marker結尾  */
	});
</script>