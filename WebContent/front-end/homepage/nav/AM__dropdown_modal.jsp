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

<!--==================================================清     單=====================================================================-->

<%
	OffiMsgService offiMsgSvc2 = new OffiMsgService();
	List<OffiMsgVO> listOffiMsg2 = offiMsgSvc2.getAll();
	request.setAttribute("listOffiMsg2", listOffiMsg2);
%>

<c:forEach var="OffiMsgVO" items="${listOffiMsg2}">

	<div class="modal fade" id="modal-id${OffiMsgVO.offiMsg_Id}">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">

					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>

					${OffiMsgVO.offiMsg_Id}
					<h4 class="modal-title">
						<b>標題：<br>&nbsp&nbsp&nbsp&nbsp${OffiMsgVO.offiMsg_Title}
					</h4>
				</div>
				<div class="modal-body">
					<a>內容：<br>&nbsp&nbsp&nbsp&nbsp${OffiMsgVO.offiMsg_Content}</a>
				</div>

				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">關閉</button>

				</div>

			</div>
		</div>
	</div>
</c:forEach>
