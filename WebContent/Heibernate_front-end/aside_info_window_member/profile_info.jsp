<%@page import="heibernate_com.mem.model.*"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.rel_list.model.*"%>

<%

	String str_pk = request.getParameter("mem_Id");
	
	// 【從 session 判斷此user是否登入過】
	MemDAO dao = new MemDAO();
	heibernate_com.mem.model.MemVO memVO = dao.findByPrimaryKey(str_pk);
	
	
	heibernate_com.mem.model.MemVO account = (heibernate_com.mem.model.MemVO)session.getAttribute("account");
	String loginMemId = account.getMem_Id();
	String clickMemId = str_pk;
	
	System.out.println("click_A_member_pk : " + loginMemId);
	System.out.println("click_B_member_pk : " + str_pk);
%>

<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta charset="utf-8">
    <link href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet">
    <style type="text/css">
        
    </style>
    <script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container" style="padding-top: 60px;">
  <h1 class="page-header" style="
	    padding-left: 129px;
	"><%=memVO.getMem_name() %></h1>
  <div class="row">
    <!-- left column -->
    <div class="col-md-4 col-sm-6 col-xs-12">
      <div class="text-center">
        <img src="<%=memVO.getMem_profile() %>" class="avatar img-circle img-thumbnail" alt="avatar">
        <h6><%=memVO.getMem_Intro() %>...</h6>
      </div>
    </div>
    <!-- edit form column -->
    <div class="col-md-8 col-sm-6 col-xs-12 personal-info">
      <div class="alert alert-info alert-dismissable">
        <a class="panel-close close" data-dismiss="alert">Ã</a> 
        <i class="fa fa-coffee"></i>
        This is an <strong>.alert</strong>. Use this to show important messages to the user.
      </div>
      <h3>Personal info</h3>
      <form class="form-horizontal" role="form">
        <div class="form-group">
          <label class="col-lg-3 control-label">First name:</label>
          <div class="col-lg-8">
          	
          </div>
        </div>
        <div class="form-group">
          <label class="col-lg-3 control-label">Last name:</label>
          <div class="col-lg-8">
            <input class="" value="Bishop" type="text">
          </div>
        </div>
        <div class="form-group">
          <label class="col-lg-3 control-label">Company:</label>
          <div class="col-lg-8">
            <input class="" value="" type="text">
          </div>
        </div>
        <div class="form-group">
          <label class="col-lg-3 control-label">Email:</label>
          <div class="col-lg-8">
            <input class="" value="janesemail@gmail.com" type="text">
          </div>
        </div>
        <div class="form-group">
          <label class="col-lg-3 control-label">Time Zone:</label>
          <div class="col-lg-8">
            <div class="ui-select">
              <select id="user_time_zone" class="">
                <option value="Hawaii">(GMT-10:00) Hawaii</option>
                <option value="Alaska">(GMT-09:00) Alaska</option>
                <option value="Pacific Time (US &amp; Canada)">(GMT-08:00) Pacific Time (US &amp; Canada)</option>
                <option value="Arizona">(GMT-07:00) Arizona</option>
                <option value="Mountain Time (US &amp; Canada)">(GMT-07:00) Mountain Time (US &amp; Canada)</option>
                <option value="Central Time (US &amp; Canada)" selected="selected">(GMT-06:00) Central Time (US &amp; Canada)</option>
                <option value="Eastern Time (US &amp; Canada)">(GMT-05:00) Eastern Time (US &amp; Canada)</option>
                <option value="Indiana (East)">(GMT-05:00) Indiana (East)</option>
              </select>
            </div>
          </div>
        </div>
        <div class="form-group">
          <label class="col-md-3 control-label">Username:</label>
          <div class="col-md-8">
            <input class="" value="janeuser" type="text">
          </div>
        </div>
        <div class="form-group">
          <label class="col-md-3 control-label">Password:</label>
          <div class="col-md-8">
            <input class="" value="11111122333" type="password">
          </div>
        </div>
        <div class="form-group">
          <label class="col-md-3 control-label">Confirm password:</label>
          <div class="col-md-8">
            <input class="" value="11111122333" type="password">
          </div>
        </div>
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
						if (aRel_ListVO.getAdded_MemId().equals(memVO.getMem_Id())
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
			<FORM METHOD="post"
				ACTION="<%=request.getContextPath()%>/rel_list/rel_list.do">
				<%
					if(checkRelation == "invite"){
						%>
							<input class="btn btn-primary"  type="submit" value="邀請好友"
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
							<input class="btn btn-primary"  type="submit" value="取消好友"
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
							<input class="btn btn-primary"  type="submit" value="等待好友確認"
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
			</FORM>            
            
            <span></span>
            <input class="btn btn-default" value="Cancel" type="reset">
          </div>
        </div>
      </form>
    </div>
  </div>
</div>
<script type="text/javascript">

</script>
</body>
</html>
