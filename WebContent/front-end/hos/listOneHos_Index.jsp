<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ page import="java.util.*"%>
<%@ page import="com.hos.model.*"%>


<%
	List<HosVO> list = null;

	if (request.getAttribute("listHos_BySearchCondition") == null) {
		list = (List<HosVO>) request.getAttribute("listHos_BySearchCondition");}
	
	if (request.getAttribute("listHos_ByCompositeQuery") == null) {
		list = (List<HosVO>) request.getAttribute("listHos_ByCompositeQuery");}
	
	pageContext.setAttribute("list", list);
	
	heibernate_com.mem.model.MemVO account = (heibernate_com.mem.model.MemVO)session.getAttribute("account");
	String loginMemId = account.getMem_Id();
	session.setAttribute("loginMemId",loginMemId);
%>

<jsp:useBean id="hosSvc" scope="page" class="com.hos.model.HosService" />

<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Title Page</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
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
    
    #photoAlbumButton {
         position: absolute;
        left: 50%;
        transform: translateX(-50%);
    }
    
    #commentButton {
        position: absolute;
        left: 0%;
        transform: translateX(-30%);
    }
    
    
    .evalCounter{
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
    
    #hosName{ 
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
         	<div id="hosName" class="col-xs-12  col-sm-4">${hosVO.hos_name}</div> 
            <div class="col-xs-6 col-xs-push-0 col-sm-1 col-sm-push-5 col-md-1 col-md-push-6" style="height:100%">
                <button type="button" class="btn btn-warning vAlign" id="edit"
                onclick="update()"><i class="glyphicon glyphicon-edit"></i></button>
            </div>
            
            <form METHOD="post" ACTION="<%=request.getContextPath()%>/hos/hos.do" name="updateForm" style="padding:0px;margin:0px;">
            	<input type="hidden" name="hos_Id" value="${hosVO.hos_Id}">
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
                onclick="getInfo()">basicInfo</button>
            </div>
            
            <form METHOD="post" ACTION="<%=request.getContextPath()%>/hos/hos.do" name="hospitalInfo">
            	<input type="hidden" name="hos_Id" value="${hosVO.hos_Id}">
            	<input type="hidden" name="action" value="getOne_For_Display">
            </form>
            
                        
            <div class="hidden-xs col-sm-4" style="height:100%">           
                <button type="button" class="btn btn-primary  " id="photoAlbumButton"
                 onclick="getPhoto()">photoAlbum</button>  
            </div>
            <div class="hidden-xs col-sm-4" style="height:100%">
                <button type="button" class="btn btn-primary " id="commentButton"
                onclick="getComment()">comment</button>
            </div>
        </div>


         <div class="row hidden-sm hidden-md hidden-lg" style="border: 1px solid red; height:12%">
            <div class="col-xs-12 col-sm-12 hidden-xs"  style="height:30%;margin:0px;"></div>
            
            <div class="hidden-sm hidden-md hidden-lg col-xs-4 col-sm-4" style="height:100%">
                <button type="button" class="btn btn-primary vAlign" >basicInfo</button>
            </div>
            <div class="hidden-sm hidden-md hidden-lg col-xs-4 col-sm-4" style="height:100%">           
                <button type="button" class="btn btn-primary  vAlign" >photoAlbum</button>  
            </div>
            <div class="hidden-sm hidden-md hidden-lg col-xs-4 col-sm-4" style="height:100%">
                <button type="button" class="btn btn-primary vAlign" >comment</button>
            </div>
        </div>

	<%  
	Base64.Encoder encoder = Base64.getEncoder();   
	String encodedText="";
	%>
	<c:if test="${empty hosPhotoSet}">
		<c:set var="hosPhotoSet" value="${listPhotos_ByHosId}"/>
	</c:if>
		
	<c:forEach var="hosPhotoVO" items="${hosPhotoSet}" >
		<c:if test="${hosPhotoVO.isDisp_HosPhoto=='1'}">
		<c:set var="hosPhoto" value="${hosPhotoVO.hosPhoto_photo}" scope="request"/>
		<% 
			byte[] imageByte = (byte[])request.getAttribute("hosPhoto");
			
			if(imageByte!=null){
				encodedText = encoder.encodeToString(imageByte);
			}
			  
//   			System.out.println("encodedText"+encodedText);  
		%>		
		</c:if>
		
	</c:forEach>
	
        <div class="row" style="border: 1px solid purple; height:66%; margin-top :3%">
            <div class="col-xs-12 col-sm-4" style="border: 2px solid orange; height:100%">
                <div class="row" style="border: 1px solid purple; height:100%">
                    <div class="col-xs-12 col-sm-12" style="border: 1px solid darkred; height:70%; padding:0px;">
                        <img src="data:image/png;base64,<%= encodedText %>" class="img-responsive" >
                    </div>
                    <div class="col-xs-12 col-sm-12" style="border: 1px solid darkred; height:30%; padding:0px;">
                        <div class="col-xs-4 col-sm-4 col-lg-2 col-lg-push-1" style="height:100%; padding:0px;">
                            <div class="col-xs-2 col-xs-push-3 col-sm-4 col-sm-push-2" style="height:100%; padding:0px;">
                                <button type="button" class="btn btn-primary vAlign" id="evalButton">
                                    <i class="glyphicon glyphicon-thumbs-up"></i>
                                </button>
                                <div class="vAlign evalCounter" style="color: white;">${hosVO.hos_Eval}
                                </div>
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
                              <a  href='#modal-id' data-toggle="modal">  
                              	<button type="button" class="btn btn-primary vAlign" id="reportButton">
                                    <i class=" glyphicon glyphicon-ban-circle"></i>
                                </button>
                              </a>
                            </div>
                        </div>
                        
                        <div class="modal fade" id="modal-id">
							<div class="modal-dialog">
								<div class="modal-content">
				<!-- 					<div class="modal-header"> -->
				<!-- 						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button> -->
				<!-- 						<h4 class="modal-title">標題1</h4> -->
				<!-- 					</div> -->
				<!-- 					<div class="modal-body"> -->
				<!-- 						內容1 -->
				<!-- 					</div> -->
				<!-- 					<div class="modal-footer"> -->
				<!-- 						<button type="button" class="btn btn-default" data-dismiss="modal">關閉</button> -->
				<!-- 						<button type="button" class="btn btn-primary">Save changes</button> -->
				<!-- 					</div> -->
								</div>
							</div>
						</div>	
                        
                    </div>
                </div>
            </div>
            
            <div class="hidden-xs col-sm-8 includePage" style="border: 2px solid yellow;height:100%;">
            
<%
	if (request.getAttribute("includePhoto") != null) {
%>
	<jsp:include page="listPhotos_ByHosId_FrontEnd.jsp" />
<%
	}
%>
	
	
<%
	if (request.getAttribute("includeComment") != null) {
%>
	<jsp:include page="listComments_ByHosId_FrontEnd.jsp" />
<%
	}
%>


<%
	if (request.getAttribute("includeInfo") != null) {
%>
	<jsp:include page="listOneHos_Info.jsp" />
<%
	}
%>
            </div>
            
            
             <div class="col-xs-12 hidden-sm hidden-md hidden-lg includePageXS" style="border: 2px solid yellow;height:100%;">
            
<%
	if (request.getAttribute("includePhotos") != null) {
%>
	<jsp:include page="listPhotos_ByHosId_FrontEnd.jsp" />
<%
	}
%>
	
	
	
<%
	if (request.getAttribute("includeComments") != null) {
%>
	<jsp:include page="listComments_ByHosId_FrontEnd.jsp" />
<%
	}
%>



<%
	if (request.getAttribute("includeInfo") != null) {
%>
	<jsp:include page="listOneHos_Info.jsp" />
<%
	}
%>
	
	
    </div>
    
    </div>
    </div>
    <script src="https://code.jquery.com/jquery.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
	
	<script>
	
 	function getInfo(){
 				$("form[name='hospitalInfo']").submit();
 		}
 	
 	function update(){
			$("form[name='updateForm']").submit();
	}
 	
 	
 	
 	
 	function getPhoto() {
		var URLs = "<%=request.getContextPath()%>/hos/hos.do";
		var sendData="action=listPhotos_ByHosId&" + "hos_Id=" + ${hosVO.hos_Id}+"&requestURL=<%=request.getServletPath()%>";

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
 		var URLs = "<%=request.getContextPath()%>/hos/hos.do";
		var sendData="action=listComments_ByHosId&" + "hos_Id=" + ${hosVO.hos_Id}+"&requestURL=<%=request.getServletPath()%>";

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
 	
 	
 	$(function(){
 		$("#reportButton").click(function(){
 			 		
 			var URLs = "<%=request.getContextPath()%>/hos/hos.do";
			var sendData="action=report&" + "hos_Id=" + ${hosVO.hos_Id}+ "&loginMemId=" +${loginMemId}+
			"&hos_MemId="+${hosVO.hos_MemId}+"&requestURL=<%=request.getServletPath()%>";

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
 		});
 	})
 	
 	
 	
	</script>
	
</body>

</html>
