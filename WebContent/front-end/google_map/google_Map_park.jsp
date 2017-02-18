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
		tem_int++;
	%>	
			{'addr': ['<%=vo.getPark_lon()%>', '<%=vo.getPark_lat()%>']
				, 'text': '標題 :<%=vo.getPark_title()%> <br>內容 : <%=vo.getPark_content()%>'	
	            ,'icon': {
	                'url': 'https://maxcdn.icons8.com/Color/PNG/24/City/dog_park-24.png'
	                ,'scaledSize': [<%=park_map_icon_size%>, <%=park_map_icon_size%>]
	            }				
			},    
	<%}%>
		]/* marker結尾  */
	});
</script>