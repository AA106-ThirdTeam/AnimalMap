<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="java.util.*"%>
<%@ page import="com.mem_dream.model.*"%>

<%@ page import="com.rel_list.model.*"%>

<%-- �����m�߱ĥ� EL ���g�k���� --%>

<%-- <jsp:useBean id="listRelation_ByMemId" scope="request" type="java.util.Set" /> --%>
<%-- <jsp:useBean id="listRelation_ByAddedMemId" scope="request" type="java.util.Set" /> --%>
<%-- <jsp:useBean id="memSvc" scope="request" class="com.mem_dream.model.MemService"/> --%>
<%-- <jsp:useBean id="rel_list_memVO" scope="request" type="com.mem_dream.model.MemVO" /> --%>

<%	
	heibernate_com.mem.model.MemVO memVO = ((heibernate_com.mem.model.MemVO)session.getAttribute("account"));	
	com.mem_dream.model.MemService	memSvc = new com.mem_dream.model.MemService();
	com.mem_dream.model.MemVO rel_list_memVO = memSvc.getOneMem(memVO.getMem_Id());
	session.setAttribute("loginMemId",memVO.getMem_Id());
	
	Rel_ListService relSvc1 = new Rel_ListService();
	Set<Rel_ListVO> addedMemIdSet = relSvc1.getRel_ListByAdded_MemId(memVO.getMem_Id());
	Set<Rel_ListVO> relMemIdSet = relSvc1.getRel_ListByRel_MemId(memVO.getMem_Id());
	System.out.print("memVO.getMem_Id(): "+memVO.getMem_Id());
	request.setAttribute("memVO", memVO);
	request.setAttribute("listRelation_ByAddedMemId", addedMemIdSet);
	request.setAttribute("listRelation_ByMemId", relMemIdSet);   
%>



<html>
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>Title Page</title>
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
		<link rel="stylesheet" href="relListcss/relList.css">
		<!--[if lt IE 9]>
			<script src="https://cdnjs.cloudflare.com/ajax/libs/html5shiv/3.7.3/html5shiv.min.js"></script>
			<script src="https://cdnjs.cloudflare.com/ajax/libs/respond.js/1.4.2/respond.min.js"></script>
		<![endif]-->
		

	</head>
	<body>
		

<div class="container col-xs-12  col-sm-12">
    
    <div class="row">
        <div class="col-xs-12  col-sm-12">
            <div class="panel panel-default">
                <div class="panel-heading c-list">
                    <span class="title">Contacts</span>
<!--                     <ul class="pull-right c-controls"> -->
<!--                         <li><a href="#cant-do-all-the-work-for-you" data-toggle="tooltip" data-placement="top" title="Add Contact"><i class="glyphicon glyphicon-plus"></i></a></li> -->
<!--                         <li><a href="#" class="hide-search" data-command="toggle-search" data-toggle="tooltip" data-placement="top" title="Toggle Search"><i class="glyphicon glyphicon-search"></i></a></li> -->
<!--                     </ul> -->
                </div>
                
<!--                 <div class="row" style="display: none;"> -->
<!--                     <div class="col-xs-12"> -->
<!--                         <div class="input-group c-search"> -->
<!--                             <input type="text" class="form-control" id="contact-list-search"> -->
<!--                             <span class="input-group-btn"> -->
<!--                                 <button class="btn btn-default" type="button"><span class="glyphicon glyphicon-user"></span></button> -->
<!--                             </span> -->
<!--                         </div> -->
<!--                     </div> -->
<!--                 </div> -->
                
                <ul class="list-group" id="contact-list">
                
                <c:forEach var="Rel_ListVO" items="${listRelation_ByMemId}">
                	<c:if test="${(Rel_ListVO.isBlackList==0)}">
                		<c:set var="hasFriend" value="true"/>
                	</c:if>       	
                </c:forEach>
               
                <c:if test="${!hasFriend}">
					�A�S�B��
				</c:if>   
                
                
                <c:forEach var="Rel_ListVO" items="${listRelation_ByMemId}"  varStatus="s">
                    <c:if test="${(Rel_ListVO.isBlackList==0)&&(Rel_ListVO.isInvited!=1)}">
                 
		                 <li class="list-group-item">
		                     <div class="col-xs-12 col-sm-12">
		                         <img src="http://api.randomuser.me/portraits/men/49.jpg" alt="Scott Stevens" class="img-responsive img-circle" />
		                     </div>
		                     <div class="col-xs-12 col-sm-12">
		                     
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
		                     
		                     
		                     
		                         <span class="name">${memSvc.getOneMem(Rel_ListVO.added_MemId).mem_name}</span><br/>
<!-- 		                         <span class="glyphicon glyphicon-map-marker text-muted c-info" data-toggle="tooltip" title="5842 Hillcrest Rd"></span> -->
<!-- 		                         <span class="visible-xs"> <span class="text-muted">5842 Hillcrest Rd</span><br/></span> -->
<!-- 		                         <span class="glyphicon glyphicon-earphone text-muted c-info" data-toggle="tooltip" title="(870) 288-4149"></span> -->
<!-- 		                         <span class="visible-xs"></span> -->

									

								<button type="button" class="btn btn-success"
								 ${(memVO.mem_Id==loginMemId) ? 'hidden':''} id="openChatBtn${Rel_ListVO.added_MemId}"> �ǰe�T��</button>
		                       
						         <script>
// 						        �ȸ�LISTALL�̪�BUTTON�Ĩ�
							 		var b${s.index} = document.getElementById("openChatBtn${Rel_ListVO.added_MemId}");
									
							 		$(function(){
							 			 b${s.index}.addEventListener("click",function(){
												openChat(${Rel_ListVO.added_MemId});
	 											b${s.index}.disabled = true;
											},false);
							 		})
							 									 		
						      </script>              
						         
		                       <c:set var="memVO" value="${memSvc.getOneMem(Rel_ListVO.added_MemId)}" scope="request"/>   
		                          
<%
		                                                  
						String checkRelation = null;

						Rel_ListService relSvc = new Rel_ListService();						
						
						String loginMemId = (String)session.getAttribute("loginMemId");
						
						Set<Rel_ListVO> relList = relSvc.getRel_ListByRel_MemId(loginMemId);
						
						boolean isInRelationList = false;
						
						if ((relList.size() != 0)) {
							
							for (Rel_ListVO aRel_ListVO : relList) {

// 						���b���Y�W��̥B�����n�͡A���¦W��άO�L���Y�A�B���ܽСC
								if (aRel_ListVO.getAdded_MemId().equals(memVO.getMem_Id())
										&& aRel_ListVO.getIsInvited().equals("0") && (aRel_ListVO.getIsBlackList().equals("1")
												|| aRel_ListVO.getIsBlackList().equals("2"))) {
									checkRelation = "invite";
								}
// 						���b���Y�W��̥B���n��
								if (aRel_ListVO.getAdded_MemId().equals(memVO.getMem_Id())
										&& aRel_ListVO.getIsBlackList().equals("0")) {
									checkRelation = "cancelFriend";
								}
// 						���b���Y�W��̦��B�S�����ܽ�
								if (aRel_ListVO.getAdded_MemId().equals(memVO.getMem_Id())
										&& aRel_ListVO.getIsInvited().equals("1")) {
									checkRelation = "waitingForConfirmation";
								}
								
								if (aRel_ListVO.getAdded_MemId().equals(memVO.getMem_Id())){
									isInRelationList=true;
								}
								
							}
						} else {
							checkRelation = "invite";
						}
						
						if(!isInRelationList){
							checkRelation = "invite";
						}
					
						request.setAttribute("checkRelation", checkRelation);

						// 				System.out.print("memVO.getMem_Id()="+memVO.getMem_Id());

						// 				System.out.println("loginMemId= "+loginMemId);
 				
// 						System.out.print("LISTREL memVO.getMem_Id()="+memVO.getMem_Id());

						// 				System.out.println("loginMemId= "+loginMemId);
						System.out.println("LISTREL ALL MEM checkRelation= " + checkRelation);
%>
		                          
		        <div>
		        ${checkRelation}
					<FORM METHOD="post"
						ACTION="<%=request.getContextPath()%>/rel_list/rel_list.do">
						<c:if test="${checkRelation == 'cancelFriend'}">
						<button  class="btn btn-danger" type=""submit"">�����n��</button><br/>							
							<input type="hidden" name="action" value="cancelFriend">
						</c:if>
						<input type="hidden" name="rel_MemId" value="${loginMemId}">
						<input type="hidden" name="added_MemId" value="${memVO.mem_Id}">
						<input type="hidden" name="requestURL" value="<%=request.getServletPath()%>">
					</FORM>
				</div>
		                          
<!-- 		                         <span class="fa fa-comments text-muted c-info" data-toggle="tooltip" title="scott.stevens@example.com"></span> -->
<!-- 		                         <span class="visible-xs"> <span class="text-muted">scott.stevens@example.com</span><br/></span> -->
		                      </div>
		                      <div class="clearfix"></div>
		                    </li>
                    </c:if>
                 </c:forEach>   
                </ul>
                
       
                
            </div>
        </div>
	</div>
   
<!--     <div id="cant-do-all-the-work-for-you" class="modal fade bs-example-modal-sm" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true"> -->
<!--         <div class="modal-dialog modal-sm"> -->
<!--             <div class="modal-content"> -->
<!--                 <div class="modal-header"> -->
<!--                     <button type="button" class="close" data-dismiss="modal" aria-hidden="true">��</button> -->
<!--                     <h4 class="modal-title" id="mySmallModalLabel">Ooops!!!</h4> -->
<!--                 </div> -->
<!--                 <div class="modal-body"> -->
<!--                     <p>I am being lazy and do not want to program an "Add User" section into this snippet... So it looks like you'll have to do that for yourself.</p><br/> -->
<!--                     <p><strong>Sorry<br/> -->
<!--                     ~ Mouse0270</strong></p> -->
<!--                 </div> -->
<!--             </div> -->
<!--         </div> -->
<!--     </div> -->
    
    <!-- JavaScrip Search Plugin -->
    
</div>
		
		
    <script src="//rawgithub.com/stidges/jquery-searchable/master/dist/jquery.searchable-1.0.0.min.js"></script>
	<script src="https://code.jquery.com/jquery.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
		
	</body>
</html>