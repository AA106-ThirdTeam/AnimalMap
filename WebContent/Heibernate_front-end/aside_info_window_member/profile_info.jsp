<%@page import="heibernate_com.rel_list.controller.*"%>
<%@page import="heibernate_com.rel_list.model.*"%>
<%@page import="heibernate_com.mem.model.*"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>

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
	
	Rel_ListVO loginMem_rel_vo = null;
	if(!loginMemId.equals(clickMemId)){
		Rel_ListService service = new Rel_ListService();
		Map<String, String[]> tem_map = new HashMap<String, String[]>();
		tem_map.put("rel_MemId", new String[]{loginMemId});
		tem_map.put("added_MemId", new String[]{clickMemId});
        try{
        	System.out.println("--------------");
        	System.out.println("查到幾筆資料 : " +service.getAll(tem_map,true).size());
            loginMem_rel_vo = (Rel_ListVO)(service.getAll(tem_map,true).get(0));
        }
        catch (Exception e){
        	loginMem_rel_vo = null;
            System.err.println("loginMem_rel_vo = null");
        }
	}
	
	
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
      <h3>會員資料 : </h3>
      <div class="alert alert-info alert-dismissable">
        <strong>信箱:</strong><%=memVO.getMem_email() %>
      </div>      
      <br>
      <br>
      <br>
      <br>
      <br>
      <hr>
      <form id="profile_info_form" class="form-horizontal" role="form">
      	<%if(loginMem_rel_vo==null){
   		%>
			<input class="btn btn-primary" id="profile_info_freind_check" onclick="profile_info_freind_invite();" type="button" value="邀請好友">
		<%
      		}else if("1".equals(loginMem_rel_vo.getIsInvited())){
      			%>
			<input class="btn btn-primary" id="profile_info_freind_check" type="button" value="等待好友確認" disabled>
      			<% 
      		}
    	%>
    		<input type="hidden" name="action" value="invite">
			<input type="hidden" name="rel_MemId" value="<%=loginMemId%>">
			<input type="hidden" name="added_MemId" value="<%=clickMemId%>">
			<input type="hidden" name="requestURL"
				value="<%=request.getServletPath()%>">    	
      </form>
    </div>
  </div>
</div>
<script>
	    // ====Hide the Modal====
	    function profile_info_freind_invite() {
	    		$("#profile_info_freind_check").attr("value","等待好友確認").attr("disabled","disabled");
				var str_serialize = $("#profile_info_form").serialize();
		    	$.ajax({
		            url:   "<%=request.getContextPath()%>/rel_list/rel_list.do",
					type : "POST",
					data : str_serialize,
				//傳帳號密碼。
				success : function(data, status) {
					alert(data);
					var json_data = JSON.parse(data);
					if(json_data.log_result.indexOf("true")!= -1){
					}
				},
				error : function(data, status, er) {
					console(data + "_" + status + "_" + er);
				}
			});
		}
</script>
</body>
</html>
