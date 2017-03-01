<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
{
	if(((heibernate_com.mem.model.MemVO)session.getAttribute("account"))!=null){
%>
<div id="AM_aside_memInfo" >
	<%@include file="/Heibernate_front-end/aside_info_window_member/one_member_info_window.jsp" %>
</div>
<div id="AM_aside_mapInfo"  hidden>	
	<%@include file="/front-end/mapInfo/AM_MapInfo.jsp" %>
</div>
<%
	}else{
		%>	
<div id="AM_aside_memInfo" >
	<%@include file="/Heibernate_front-end/aside_info_window_member/one_member_info_window.jsp" %>
</div>
<div id="AM_aside_mapInfo"  hidden>	
	<%@include file="/front-end/mapInfo/AM_MapInfo.jsp" %>
</div>
		<%		
	}
}
%>