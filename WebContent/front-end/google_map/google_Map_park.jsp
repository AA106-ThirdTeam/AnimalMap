<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>    
<%@ page import="heibernate_com.park.model.*"%>	
<%
    ParkService parkSvc = new ParkService();
    List<ParkVO> list = parkSvc.getAll();
    pageContext.setAttribute("list",list);
%>

<script>
	map.tinyMap('modify',{
		'marker': [	
	<%
	int tem_int = 0;
	for(ParkVO vo:list){
		if(tem_int>0){
			%>
			,
			<%
		}
		tem_int++;
	%>	
			{'addr': ['<%=vo.getPark_lon()%>', '<%=vo.getPark_lat()%>']
				, 'text': '標題 :<%=vo.getPark_title()%> <br>內容 : <%=vo.getPark_content()%>'	
			},    
	<%}%>
		]/* marker結尾  */
	});
</script>