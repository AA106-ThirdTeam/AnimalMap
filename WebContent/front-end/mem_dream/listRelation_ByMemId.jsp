<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="java.util.*"%>
<%@ page import="com.mem_dream.model.*"%>

<%@ page import="com.rel_list.model.*"%>

<%-- 此頁練習採用 EL 的寫法取值 --%>

<%-- <jsp:useBean id="listRelation_ByMemId2" scope="request" type="java.util.Set" /> --%>
<%-- <jsp:useBean id="listRelation_ByAddedMemId2" scope="request" type="java.util.Set" /> --%>
<%-- <jsp:useBean id="memSvc2" scope="request" class="com.mem_dream.model.MemService"/> --%>
<%-- <jsp:useBean id="rel_list_memVO2" scope="request" type="com.mem_dream.model.MemVO" /> --%>

<%	
	heibernate_com.mem.model.MemVO memVO2 = ((heibernate_com.mem.model.MemVO)session.getAttribute("account"));	
	com.mem_dream.model.MemService	memSvc2 = new com.mem_dream.model.MemService();
	com.mem_dream.model.MemVO rel_list_memVO2 = memSvc2.getOneMem(memVO2.getMem_Id());
	session.setAttribute("loginMemId",memVO2.getMem_Id());
	
	Rel_ListService relSvc1 = new Rel_ListService();
	Set<Rel_ListVO> addedMemIdSet = relSvc1.getRel_ListByAdded_MemId(memVO2.getMem_Id());
	Set<Rel_ListVO> relMemIdSet = relSvc1.getRel_ListByRel_MemId(memVO2.getMem_Id());
	System.out.print("memVO2.getMem_Id(): "+memVO2.getMem_Id());
	request.setAttribute("memVO2", memVO2);
	request.setAttribute("listRelation_ByAddedMemId2", addedMemIdSet);
	request.setAttribute("listRelation_ByMemId2", relMemIdSet);   
%>



<html>
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>Title Page</title>
		
		<!--[if lt IE 9]>
			<script src="https://cdnjs.cloudflare.com/ajax/libs/html5shiv/3.7.3/html5shiv.min.js"></script>
			<script src="https://cdnjs.cloudflare.com/ajax/libs/respond.js/1.4.2/respond.min.js"></script>
		<![endif]-->
		

	</head>
	<body>
		

<div class="container col-xs-12  col-sm-12" style="margin-top:10px">
    
    <div class="row">
        <div class="col-xs-12  col-sm-12">
            <div class="panel panel-default">
                <div class="panel-heading c-list">
                    <span class="title">Contacts</span>

                </div>
                <ul class="list-group" id="contact-list">
                
                <c:forEach var="Rel_ListVO" items="${listRelation_ByMemId2}">
                	<c:if test="${(Rel_ListVO.isBlackList==0)}">
                		<c:set var="hasFriend" value="true"/>
                	</c:if>       	
                </c:forEach>
               
                <c:if test="${!hasFriend}">
					你沒朋友
				</c:if>   
                
                
                <c:forEach var="Rel_ListVO" items="${listRelation_ByMemId2}"  varStatus="s">
                    <c:if test="${(Rel_ListVO.isBlackList==0)&&(Rel_ListVO.isInvited!=1)}">
                 
		                 <li class="list-group-item">
		                     <div class="col-xs-12 col-sm-6">
		                         <img src="http://api.randomuser.me/portraits/men/49.jpg" alt="Scott Stevens" class="img-responsive img-circle" />
		                     </div>
		                     <div class="col-xs-12 col-sm-6">
		                     
		                     		<c:set var="isOnline" value="false"/>
								<c:forEach var="seeLoginMemId" items="${loginMemIdList}">
									<c:if test="${seeLoginMemId==Rel_ListVO.added_MemId}">
										<c:set var="isOnline" value="true"/>
									</c:if>
								</c:forEach>
									<c:if test="${isOnline eq true}">
										<span><i class="glyphicon glyphicon-user" style="color:green"></i></span>
									</c:if>
									<c:if test="${isOnline eq false}">
										<span><i class="glyphicon glyphicon-user" style="color:red"></i></span>
									</c:if>                  
		                     
		                     
		                     
		                         <span class="name">${memSvc2.getOneMem(Rel_ListVO.added_MemId).mem_name}</span><br/>
<!-- 		                         <span class="glyphicon glyphicon-map-marker text-muted c-info" data-toggle="tooltip" title="5842 Hillcrest Rd"></span> -->
<!-- 		                         <span class="visible-xs"> <span class="text-muted">5842 Hillcrest Rd</span><br/></span> -->
<!-- 		                         <span class="glyphicon glyphicon-earphone text-muted c-info" data-toggle="tooltip" title="(870) 288-4149"></span> -->
<!-- 		                         <span class="visible-xs"></span> -->
									

								<button type="button" class="btn btn-success"
								 ${(memVO2.mem_Id==loginMemId) ? 'hidden':''} id="openChatBtn${Rel_ListVO.added_MemId}"> 傳送訊息</button>
		                       
						         <script>
// 						        怕跟LISTALL裡的BUTTON衝到
							 		var b${s.index} = document.getElementById("openChatBtn${Rel_ListVO.added_MemId}");
									
							 		$(function(){
							 			 b${s.index}.addEventListener("click",function(){
												openChat(${Rel_ListVO.added_MemId});
	 											b${s.index}.disabled = true;
											},false);
							 		})							 									 		
						      </script>              
						         
		                       <c:set var="rel_ListVO" value="${Rel_ListVO}" scope="request"/>   
		                          
	<%	
			Rel_ListVO rel_ListVO = (Rel_ListVO)request.getAttribute("rel_ListVO");
	
      		String checkRelation = null;
      	
      		if(rel_ListVO==null){
      			checkRelation="invite";		
      		}else if("1".equals(rel_ListVO.getIsInvited())){
      			checkRelation = "waitingForConfirmation";
      		}else if("0".equals(rel_ListVO.getIsBlackList())){
      			checkRelation="cancelFriend";
      		}else if(rel_ListVO.getIsInvited().equals("0")&&rel_ListVO.getIsBlackList().equals("1")
      				|| rel_ListVO.getIsBlackList().equals("2")){
      			checkRelation = "invite";
      		}
      		
      		request.setAttribute("checkRelation",checkRelation);
      		System.out.println("rel_ListVO.getAdded_MemId"+rel_ListVO.getAdded_MemId());
    	%>	
    	<form id="cancel_form${s.index}" class="form-horizontal" role="form">
					    	<c:set var="clickMemId" value="${Rel_ListVO.added_MemId}"/>	                          
							   
								<c:if test="${checkRelation == 'cancelFriend'}">
								<c:if test="${loginMemId!=clickMemId}">
									<input type="button" class="btn btn-primary" value="取消好友" 
									id="friend_cancel${s.index}"/>
									<input type="hidden" name="action" value="cancelFriend">
								</c:if>
								</c:if>
								
								
		     <input type="hidden" name="rel_MemId" value="${loginMemId}">
			<input type="hidden" name="added_MemId" value="${clickMemId}">
			<input type="hidden" name="requestURL"
				value="<%=request.getServletPath()%>">    	
      	</form> 

		                	</div>
		                      <div class="clearfix"></div>
		                    </li>
                    </c:if>       
                    
                   <script>
                   
                   
                   		$("friend_cancel${s.index}").click(function(){
                   			alert("abc");
                   		
<%--                    			$.post( "<%=request.getContextPath()%>/rel_list/rel_list.do" , $("#cancel_form${s.index}").serialize() , function(){ --%>
//                    			$(this).attr("hidden","hidden");	
//                    			} )
	
                   		})
                   </script>
	    	
                 </c:forEach>   
                </ul>
            </div>
        </div>
	</div>
   
</div>
		
		
   
		
	</body>
</html>