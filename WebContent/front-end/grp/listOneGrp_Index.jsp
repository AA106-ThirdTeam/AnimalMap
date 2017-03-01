<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ page import="java.util.*"%>
<%@ page import="com.grp.model.*"%>

<% 
	session.setAttribute("Mem_Id_1", "1000000");
	session.setAttribute("Mem_Id_2", "1000001");
	session.setAttribute("Mem_Id_3", "1000002");
%>

<%
	List<GrpVO> list = null;

	if (request.getAttribute("listGrp_BySearchCondition") == null) {
		list = (List<GrpVO>) request.getAttribute("listGrp_BySearchCondition");}
	
	if (request.getAttribute("listGrp_ByCompositeQuery") == null) {
		list = (List<GrpVO>) request.getAttribute("listGrp_ByCompositeQuery");}
	
	pageContext.setAttribute("list", list);
%>

<jsp:useBean id="grpSvc" scope="page" class="com.grp.model.GrpService" />
<jsp:useBean id="joinListSvc" scope="page" class="com.joinlist.model.JoinListService" />

<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Title Page</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <!--[if lt IE 9]>
			<script src="https://cdnjs.cloudflare.com/ajax/libs/html5shiv/3.7.3/html5shiv.min.js"></script>
			<script src="https://cdnjs.cloudflare.com/ajax/libs/respond.js/1.4.2/respond.min.js"></script>
		<![endif]-->
    <style>
    .vAlign {
        position: absolute;
        top: 50%;
        transform: translateY(-50%);
    }
    
    #edit {
        right: 0%;
/*         padding-bottom: 0px; */
    }
    
    #cancel {
/*         padding-bottom: 0px; */
    }
    
    .glyphicon {
        font-size: 25px;
    }
    /*.verAlignDiv{
				display: inline-block;
				vertical-align: middle;
				width:0px;
				height: 100%;
			}*/
			
   #basicInfoButton {
         position: absolute;
        left: 100%;
        transform: translateX(-70%);
    }
    
    #joinListBtn {
         position: absolute;
        left: 50%;
        transform: translateX(-50%);
    }
    
    #commentButton {
        position: absolute;
        left: 0%;
        transform: translateX(-30%);
    }
    
    
    .counter{
    	background-color:darkred ;
    	margin-left: 35px;
    	margin-top: 15px; 
    	height:20px;
    	width:20px;"
    	
     	font-size:15px;  
      	text-align:center;  
    	border-radius: 5px;
    }
    
    .img-responsive{
       max-height: 36vh;
       position: absolute;
        left: 50%;
        transform: translateX(-50%);
       
    }
    
    #grpName{ 
     	font-size:40px; 
     	font-weight:900; 
     	display:inline;
     	left:0;
     } 

	.includePage{
		width:auto;
 		overflow-y:y; 
 		overflow:auto;
	}
	
	
	.includePageXS{
		width:auto;
		visible
	}
    </style>
</head>

<body>

    <div class="container" style="height:80vh;border: 1px solid green; margin-top :10vh">
        <div class="row" style="border: 1px solid blue; height:12%">
        
         	<div id="grpName" class="col-xs-12  col-sm-4">${grpVO.grp_name}</div> 
         	
            <div class="col-xs-6 col-xs-push-0 col-sm-1 col-sm-push-5 col-md-1 col-md-push-6" style="height:100%">
                <button type="button" class="btn btn-warning vAlign" id="edit"
                onclick="update()"><i class="glyphicon glyphicon-edit"></i></button>
            </div>
            
            <form METHOD="post" ACTION="<%=request.getContextPath()%>/grp/grp.do" name="updateForm" style="padding:0px;margin:0px;">
            	<input type="hidden" name="grp_Id" value="${grpVO.grp_Id}">
            	<input type="hidden" name="action" value="getOne_For_Update">
            	<input type="hidden" name="requestURL"	value="<%=request.getServletPath()%>">
            </form>
            
            <div class="col-xs-6 col-xs-push-0 col-sm-1 col-sm-push-5  col-md-1 col-md-push-6" style="height:100%">
                <button type="button" class="btn btn-danger vAlign" id="cancel"><i class="glyphicon glyphicon-remove"></i></button>
            </div>
        </div>
        
        <div class="row hidden-xs" style="border: 1px solid red; height:12%">
            <div class="col-xs-12 col-sm-12"  style="height:30%;margin:0px;"></div>
            
            <div class="hidden-xs col-sm-4" style="height:100%">
                <button type="button" class="btn btn-primary " id="basicInfoButton"
                >basicInfo</button>
            </div>
            
            <form METHOD="post" ACTION="<%=request.getContextPath()%>/grp/grp.do" name="grpInfo">
            	<input type="hidden" name="grp_Id" value="${grpVO.grp_Id}">
            	<input type="hidden" name="action" value="getOne_For_Display">
            </form>
            
                        
            <div class="hidden-xs col-sm-4" style="height:100%">           
                <button type="button" class="btn btn-primary  " id="joinListBtn"
                >JoinList</button>  
            </div>
            <div class="hidden-xs col-sm-4" style="height:100%">
                <button type="button" class="btn btn-primary " id="commentButton"
                >comment</button>
            </div>
        </div>


         <div class="row hidden-sm hidden-md hidden-lg" style="border: 1px solid red; height:12%">
            <div class="col-xs-12 col-sm-12 hidden-xs"  style="height:30%;margin:0px;"></div>
            
            <div class="hidden-sm hidden-md hidden-lg col-xs-4 col-sm-4" style="height:100%">
                <button type="button" class="btn btn-primary vAlign" id="basicInfoButton">basicInfo</button>
            </div>
            <div class="hidden-sm hidden-md hidden-lg col-xs-4 col-sm-4" style="height:100%">           
                <button type="button" class="btn btn-primary  vAlign" id="joinListBtn">JoinList</button>  
            </div>
            <div class="hidden-sm hidden-md hidden-lg col-xs-4 col-sm-4" style="height:100%">
                <button type="button" class="btn btn-primary vAlign"  id="commentButton">comment</button>
            </div>
        </div>

	<%  
	Base64.Encoder encoder = Base64.getEncoder();   
	String encodedText="";
	%>
			
		<c:set var="grpPhoto" value="${grpVO.grp_photo}" scope="request"/>
		<% 
			byte[] imageByte = (byte[])request.getAttribute("grpPhoto");
			
			if(imageByte!=null){
				encodedText = encoder.encodeToString(imageByte);
			}
			  
//   			System.out.println("encodedText"+encodedText);  
		%>		
		
	
        <div class="row" style="border: 1px solid purple; height:66%; margin-top :3%">
            <div class="col-xs-12 col-sm-4" style="border: 2px solid orange; height:100%">
                <div class="row" style="border: 1px solid purple; height:100%">
                    <div class="col-xs-12 col-sm-12" style="border: 1px solid darkred; height:70%; padding:0px;">
                        <img src="data:image/png;base64,<%= encodedText %>" class="img-responsive" >
                    </div>
                    <div class="col-xs-12 col-sm-12" style="border: 1px solid darkred; height:30%; padding:0px;">
                        <div class="col-xs-4 col-sm-4 col-lg-2 col-lg-push-1" style="height:100%; padding:0px;">
                            <div class="col-xs-2 col-xs-push-3 col-sm-4 col-sm-push-2" style="height:100%; padding:0px;" id="joinDiv">
                                <c:set var="isInJoinList" value="false"/>
                                <c:forEach var="joinListVO" items="${grpSvc.getJoinListByGrpId(grpVO.grp_Id)}" varStatus="s">
                                	<c:if test="${joinListVO.joinList_MemId==loginMemId}">
	                                	<c:if test="${joinListVO.joinList_isInvited=='0'}">
	                                		<c:set var="isInJoinList" value="true"/>
	                                	</c:if>
                                	</c:if>
                                </c:forEach>
                                <c:if test="${!isInJoinList}">
	                                <button type="button" class="btn btn-primary vAlign" id="joinGrpBtn">
	                                    <i class="glyphicon glyphicon-plus"></i>
	                                </button>
	                                
	                                <script>
	                                	$(function(){
	                               		 	document.getElementById("joinGrpBtn").addEventListener("click",joinGrp,false);	                               		
	                                	});
									</script>
										                                
                                </c:if>
                                <c:if test="${isInJoinList}">
	                                <button type="button" class="btn btn-primary vAlign" id="cancelJoinGrpBtn">
	                                    <i class="glyphicon glyphicon-minus"></i>
	                                </button>
	                                
	                                <script>
		                                $(function(){
		                                	document.getElementById("cancelJoinGrpBtn").addEventListener("click",cancelJoinGrp,false);	                                	
		                                });
									</script>
	                                
                                </c:if>
                                
                                
                                <div class="vAlign counter" style="color: white;">${grpSvc.getCount(grpVO.grp_Id)}</div>
                            </div>
                        </div>
                        <div class="col-xs-4 col-sm-4 col-lg-2 col-lg-push-3" style="height:100%; padding:0px;">
                            <div class="col-xs-2 col-xs-push-3 col-sm-4 col-sm-push-2" style="height:100%; padding:0px;">
                                <button type="button" class="btn btn-primary vAlign " id="collectionButton">
                                    <i class="glyphicon glyphicon-heart-empty"></i>
                                </button>
                            </div>
                        </div>
                        <div class="col-xs-4 col-sm-4 col-lg-2 col-lg-push-5" style="height:100%; padding:0px;">
                            <div class="col-xs-2 col-xs-push-3 col-sm-4 col-sm-push-2" style="height:100%; padding:0px;">
                                <button type="button" class="btn btn-primary vAlign" id="reportButton">
                                    <i class=" glyphicon glyphicon-ban-circle"></i>
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            
            <div class="hidden-xs col-sm-8 includePage" style="border: 2px solid yellow;height:100%;">
            
<%
	if (request.getAttribute("includePhoto") != null) {
%>
<%-- 	<jsp:include page="listPhotos_ByGrpId_FrontEnd.jsp" /> --%>
<%
	}
%>
	
	
<%
	if (request.getAttribute("includeComment") != null) {
%>
	<jsp:include page="listComments_ByGrpId_FrontEnd.jsp" />
<%
	}
%>


<%
	if (request.getAttribute("includeInfo") != null) {
%>
	<jsp:include page="listOneGrp_Info.jsp" />
<%
	}
%>
            </div>
            
            
             <div class="col-xs-12 hidden-sm hidden-md hidden-lg includePageXS" style="border: 2px solid yellow;height:100%;">
            
<%
	if (request.getAttribute("includeJoinList") != null) {
%>
	<jsp:include page="listJoinMem_ByGrpId_FrontEnd.jsp" />
<%
	}
%>
	
	
	
<%
	if (request.getAttribute("includeComments") != null) {
%>
	<jsp:include page="listComments_ByGrpId_FrontEnd.jsp" />
<%
	}
%>



<%
	if (request.getAttribute("includeInfo") != null) {
%>
	<jsp:include page="listOneGrp_Info.jsp" />
<%
	}
%>
	
	
    </div>
    
    </div>
    </div>
    
	
	<script>
	
	$(function(){
		
		$("#basicInfoButton").click(function(){
			getInfo();
		});
		$("#joinListBtn").click(function(){
			getJoinList();
		});
		$("#commentButton").click(function(){
			getComment();
		});

	});
		
 	function getInfo(){
 				$("form[name='grpInfo']").submit();
 		}
 	
 	function update(){
			$("form[name='updateForm']").submit();
	}
 	
 	
 	function getJoinList() {
		var URLs = "<%=request.getContextPath()%>/grp/grp.do";
		var sendData="action=listJoinMem_ByGrpId&" + "grp_Id=" + ${grpVO.grp_Id}+"&requestURL=<%=request.getServletPath()%>";

		$.ajax({
			url : URLs,
			data : sendData,
			type : "POST",
			dataType : 'text',

			success : function(msg) {
				$(".includePage").html(msg)
			},

			error : function(xhr, ajaxOptions, thrownError) {
				alert(xhr.status);
				alert(thrownError);
			}
		});

	}

 	function getComment(){
 		var URLs = "<%=request.getContextPath()%>/grp/grp.do";
		var sendData="action=listComments_ByGrpId&" + "grp_Id=" + ${grpVO.grp_Id}+"&requestURL=<%=request.getServletPath()%>";

		$.ajax({
			url : URLs,
			data : sendData,
			type : "POST",
			dataType : 'text',

			success : function(msg) {

				$(".includePage").html(msg)
			},

			error : function(xhr, ajaxOptions, thrownError) {
				alert(xhr.status);
				alert(thrownError);
			}
		});
 	}
 	
 	function joinGrp(){
 		var URLs = "<%=request.getContextPath()%>/joinlist/joinlist.do";
		var sendData="action=joinGrp&" + "grp_Id=" + ${grpVO.grp_Id}+"&joinList_MemId="+${loginMemId}+"&requestURL=<%=request.getServletPath()%>";

		$.ajax({
			url : URLs,
			data : sendData,
			type : "POST",
			dataType : 'text',

			success : function(msg) {
				$("#joinGrpBtn").remove();
				$("#joinDiv").prepend(
						"<button type='button' class='btn btn-primary vAlign' id='cancelJoinGrpBtn'>"+
                        "<i class='glyphicon glyphicon-minus'></i>"+
                    "</button>");
				
				
				document.getElementById("cancelJoinGrpBtn").addEventListener("click",cancelJoinGrp,false);
				
					$(".counter").text(msg);
					getJoinList();

			},

			error : function(xhr, ajaxOptions, thrownError) {
				alert(xhr.status);
				alert(thrownError);
				
			}
			
			
		});
 	}
 	
 	
 	function cancelJoinGrp(){
 		var URLs = "<%=request.getContextPath()%>/joinlist/joinlist.do";
		var sendData="action=cancelJoinGrp&" + "grp_Id=" + ${grpVO.grp_Id}+"&joinList_MemId="+${loginMemId}+"&requestURL=<%=request.getServletPath()%>";

		$.ajax({
			url : URLs,
			data : sendData,
			type : "POST",
			dataType : 'text',

			success : function(msg) {
				$("#cancelJoinGrpBtn").remove();
				$("#joinDiv").prepend(
						"<button type='button' class='btn btn-primary vAlign' id='joinGrpBtn'>"+
                        "<i class='glyphicon glyphicon-plus'></i>"+
                    "</button>");
				
				document.getElementById("joinGrpBtn").addEventListener("click",joinGrp,false);
					
					$(".counter").text(msg);
					getJoinList();
				
			},

			error : function(xhr, ajaxOptions, thrownError) {
				alert(xhr.status);
				alert(thrownError);
			}
		});
 	}
 	 	
	</script>
	
</body>

</html>
