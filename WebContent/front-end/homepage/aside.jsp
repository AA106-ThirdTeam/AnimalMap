<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
{
	boolean tem_isCompositeQuery = false;
	{
		String tem_CompositeQuery = request.getParameter("CompositeQuery");
		if(tem_CompositeQuery!=null){
			tem_isCompositeQuery = true;
		}
	}
	if(((heibernate_com.mem.model.MemVO)session.getAttribute("account"))!=null){
%>
<div id="AM_aside_memInfo" <%=(tem_isCompositeQuery)?"hidden":"" %> >
	<%@include file="/Heibernate_front-end/aside_info_window_member/one_member_info_window.jsp" %>
</div>
<div id="AM_aside_mapInfo"  <%=(tem_isCompositeQuery)?"":"hidden" %>>	
	<%@include file="/front-end/mapInfo/AM_MapInfo.jsp" %>
</div>
<div id="AM_aside_friendInfo"  hidden>	
	<%@include file="/front-end/mem_dream/listRelation_ByMemId.jsp" %>
</div>
<%
	}else{
		
		%>	
<div id="AM_aside_memInfo" <%=(tem_isCompositeQuery)?"hidden":"" %> >
	<%@include file="/Heibernate_front-end/aside_info_window_member/one_member_info_window.jsp" %>
</div>
<div id="AM_aside_mapInfo"  <%=(tem_isCompositeQuery)?"":"hidden" %> >	
	<%@include file="/front-end/mapInfo/AM_MapInfo.jsp" %>
</div>
		<%		
	}
}
%>