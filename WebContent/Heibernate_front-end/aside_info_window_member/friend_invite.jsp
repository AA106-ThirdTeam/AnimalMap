<%@page import="heibernate_com.mem.model.*"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%
%>

        <div class="form-group">
          <label class="col-md-3 control-label"></label>
          <div class="col-md-8">
            
            
            <!-- 邀請好友 -->
            <%
            	String checkRelation = null;
           	 	Rel_ListService relSvc = new Rel_ListService();
				Set<Rel_ListVO> relList = relSvc.getRel_ListByRel_MemId(account.getMem_Id());
				
				boolean isInRelationList = false;
				
				if ((relList.size() != 0)) {
					for (Rel_ListVO aRel_ListVO : relList) {

//					有在關係名單裡且不為好友，為黑名單或是無關係，且未邀請。
						if (loginMemId.equals(clickMemId)
								&& aRel_ListVO.getIsInvited().equals("0") && (aRel_ListVO.getIsBlackList().equals("1")
										|| aRel_ListVO.getIsBlackList().equals("2"))) {
							checkRelation = "invite";
						}
//					有在關係名單裡且為好友
						if (aRel_ListVO.getAdded_MemId().equals(memVO.getMem_Id())
								&& aRel_ListVO.getIsBlackList().equals("0")) {
							checkRelation = "cancelFriend";
						}
//					有在關係名單裡但且沒接受邀請
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
				
				System.out.println("checkRelation : " + checkRelation);
            %>
				<%
					if(checkRelation == "invite"){
						%>
							<input class="btn btn-primary" id="profile_info_freind_check" onclick="profile_info_freind_invite();" type="button" value="邀請好友"
							<%
								if(clickMemId==loginMemId){
									out.print(" hidden ");
								}
							%>
							>
							<input type="hidden" name="action" value="invite">
						<%
					}
				%>
				<%
					if(checkRelation == "cancelFriend"){
						%>
							<input class="btn btn-primary" id="profile_info_freind_check" type="button" value="取消好友"
							<%
								if(clickMemId==loginMemId){
									out.print(" hidden ");
								}
							%>
							>
							<input type="hidden" name="action" value="cancelFriend">
						<%
					}
				%>
				<%
					if(checkRelation == "waitingForConfirmation"){
						%>
							<input class="btn btn-primary" id="profile_info_freind_check" type="button" value="等待好友確認"
							<%
								if(clickMemId==loginMemId){
									out.print(" hidden ");
								}
							%>
							 disabled >
							<input type="hidden" name="action" value="cancelFriend">
						<%
					}
				%>									
				<input type="hidden" name="rel_MemId" value="<%=loginMemId%>">
				<input type="hidden" name="added_MemId" value="<%=clickMemId%>">
				<input type="hidden" name="requestURL"
					value="<%=request.getServletPath()%>">
            
            <span></span>
            <input class="btn btn-default" value="Cancel" type="reset">
          </div>
        </div>