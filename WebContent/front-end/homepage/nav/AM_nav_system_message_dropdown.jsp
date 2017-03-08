<%@page import="util.time.Timestamp_util"%>
<%@page import="com.joinlist.model.JoinListVO"%>
<%@page import="com.grp.model.GrpService"%>
<%@page import="com.priv_message.model.Priv_messageVO"%>
<%@page import="com.priv_message.model.Priv_messageService"%>
<%@page import="com.rel_list.model.Rel_ListVO"%>
<%@page import="heibernate_com.mem.model.MemVO"%>
<%@page import="heibernate_com.mem.model.MemService"%>
<%@page import="com.rel_list.model.Rel_ListService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- <%@ page import="java.util.*"%>	 --%>
<%-- <%@page import="heibernate_com.mem.model.MemVO"%> --%>
<%@ page import="java.util.*"%>
<%@ page import="com.post.model.*"%>
<%@ page import="com.post_Response.model.*"%>
<%@ page import="com.offiMsg.model.*"%>
<%@ page import="com.offiMsg.controller.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<ul class="dropdown-menu offiMsg001"  style="width: 300px;">



<%
	OffiMsgService offiMsgSvc = new OffiMsgService();
	List<OffiMsgVO> listOffiMsg = offiMsgSvc.getAll();
	request.setAttribute("listOffiMsg", listOffiMsg);
%>

<c:forEach var="OffiMsgVO" items="${listOffiMsg}">
	<div class="row" style="width: 100px;">
		<li>
			<a href="#modal-id${OffiMsgVO.offiMsg_Id}"
				data-toggle="modal" class="btn" style="padding-left: 20px;">標題：${OffiMsgVO.offiMsg_Title}
			</a>
		</li>
	</div>
</c:forEach>


</ul>

