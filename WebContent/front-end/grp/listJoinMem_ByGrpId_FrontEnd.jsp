<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="java.util.*"%>
<%@ page import="com.grpComm.model.*"  %>
<%-- �����m�߱ĥ� EL ���g�k���� --%>

<jsp:useBean id="listJoinMem_ByGrpId" scope="request" type="java.util.Set" />
<jsp:useBean id="GrpSvc" scope="page" class="com.grp.model.GrpService" />
<jsp:useBean id="memSvc" scope="page" class="com.mem_dream.model.MemService" />


<html>
<head>
	<style>
	
    </style>

	<script src="http://code.jquery.com/jquery-1.10.1.min.js">  </script>
	
</head>
<body bgcolor='white'>

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
				
	<div class="container" style="width: 700px;padding:20px">
		<div class="row">
			<div class="col-xs-12 col-sm-12 text-center">
<%-- 				<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/grp/grpComm.do" name="form1"> --%>
<!-- 	                <div class="input-group text msgBtnDiv">                     -->
<%-- 	                    <input type="hidden" name="grp_Id" value="${grpVO.grp_Id}"> --%>
<%-- 	                    <input type="hidden" name="requestURL"	value="<%=request.getServletPath()%>"> --%>
<!-- 	                    <input type="hidden" name="action"value="insert"> -->
<!-- 	                    <span class="input-group-btn"> -->
						<a  href='#modal-id' data-toggle="modal">
							<button class="btn btn-info " type="button" id="inviteFriend">�ܽЦn�ͥ[�J����</button>
						</a>
<!-- 						</span> -->
<!-- 	                 </div> -->
<!--                  </FORM> -->
             </div>
			
       </div>
		<div class="modal fade" id="modal-id">
			<div class="modal-dialog">
				<div class="modal-content">
<!-- 					<div class="modal-header"> -->
<!-- 						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button> -->
<!-- 						<h4 class="modal-title">���D1</h4> -->
<!-- 					</div> -->
<!-- 					<div class="modal-body"> -->
<!-- 						���e1 -->
<!-- 					</div> -->
<!-- 					<div class="modal-footer"> -->
<!-- 						<button type="button" class="btn btn-default" data-dismiss="modal">����</button> -->
<!-- 						<button type="button" class="btn btn-primary">Save changes</button> -->
<!-- 					</div> -->
				</div>
			</div>
		</div>	  
	  
	<%  
		Base64.Encoder encoder = Base64.getEncoder();   
	%>
	  
	<c:forEach var="JoinListVO" items="${listJoinMem_ByGrpId}" varStatus="s">
		<c:if test="${!(JoinListVO.joinList_isInvited=='1')}">
		<c:set var="oneMem" value="${memSvc.getOneMem(JoinListVO.joinList_MemId)}" scope="request"/>
		<c:set var="mem_photo" value="${oneMem.mem_profile}" scope="request"/>
		<% 
			String encodedText = (String)request.getAttribute("mem_photo");
// 			byte[] imageByte = (byte[])request.getAttribute("mem_photo");
// 			if(imageByte!=null){
// 				encodedText = encoder.encodeToString(imageByte);
// 			}
			  
		%>
				 
    
        
             <div class="col-xs-6 col-sm-4" style="margin-top:20px">
                <img src="<%= encodedText %>" alt="Red dot" 
                style="width:100px;height:100px;transform: translateX(50%);">
                <p style="width:100px;text-align:center;transform: translateX(50%);">${oneMem.mem_name}</p>
             </div>
             
         </c:if>   
	</c:forEach>
	</div>


<!-- <br>�����������|:<br><b> -->
<%--    <font color=blue>request.getServletPath():</font> <%= request.getServletPath()%><br> --%>
<%--    <font color=blue>request.getRequestURI(): </font> <%= request.getRequestURI()%> </b> --%>
</body>

<script>
	$(function(){
		$("#inviteFriend").click(function(){
			var URLs = "<%=request.getContextPath()%>/joinList/joinList.do";
			var sendData="action=listRelation_forInviteGrp&" + "grp_Id=" + ${grpVO.grp_Id}+
			"&grp_MemId="+${grpVO.grp_MemId}+"&requestURL=<%=request.getServletPath()%>";

			$.ajax({
				url : URLs,
				data : sendData,
				type : "POST",
				dataType : 'text',

				success : function(msg) {
					$(".modal-content").html(msg);
				},

				error : function(xhr, ajaxOptions, thrownError) {
					alert(xhr.status);
					alert(thrownError);
				}
			});
		})
	});
</script>
	

</html>
