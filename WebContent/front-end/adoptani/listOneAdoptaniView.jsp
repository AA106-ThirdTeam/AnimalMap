<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.adoptani.model.*"%>
<%@ page import="com.chung.tools.Tools"%>
<%@ page import="com.adoptani_sponsor.model.*"%>

<jsp:useBean id="adoptaniVO" scope="request" class="com.adoptani.model.AdoptaniVO" />


<%	
	AdoptaniSponsorService adoptaniSponsorSvc = new AdoptaniSponsorService();
	Integer TotalSponsor = adoptaniSponsorSvc.getOneAllMoney(adoptaniVO.getAdopt_Ani_Id());

    Tools tools = new Tools();
%>


<!DOCTYPE html>
<html lang="">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>送養動物資料 - listOneAdoptani.jsp</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
        <!--[if lt IE 9]>
            <script src="https://cdnjs.cloudflare.com/ajax/libs/html5shiv/3.7.3/html5shiv.min.js"></script>
            <script src="https://cdnjs.cloudflare.com/ajax/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->


    <style type="text/css">
        .profile-card{
            
            margin-top:10%;
            border: solid;
            width: 880px;
            height: 600px;
            
            position: absolute;

        }

/*        .overlay {
            background: #158 url(https://goo.gl/DM5s4f) center no-repeat;
            background-size: cover;
            height: calc(100% + 80px);
            margin: -20px;
            position: relative;
            width: calc(100% + 40px);
            -webkit-filter: blur(10px);
            -moz-filter: blur(10px);
            filter: blur(10px);
        }*/

        .header{
            border: solid ;
            height: 600px;
            background: rgba(0, 97, 145, 0.45);
            color: #FFF;
        }
        .bio{
            /*border: solid red;*/
            height: 600px;
            width:;
            background-color: ;
        }

        .headPhotoDiv{
        	text-align: center;
            width: 100%;
            height: 250px;
            margin: 80px auto;

        }

        #headPhoto{
    		margin: 0 auto; 
            max-width: 250px;
            height: 250px;
            max-height: 250px;
            border:solid 10px #A1DCFF;
            /*object-fit: cover;*/
            -webkit-border-radius: 100%;
            border-radius: 50%;
            -webkit-transition: -webkit-box-shadow 0.3s ease;
            transition: box-shadow 0.3s ease;
            -webkit-box-shadow: 0px 0px 0px 8px rgba(0, 0, 0, 0.06);
            box-shadow: 0px 0px 0px 8px rgba(0, 0, 0, 0.06);
            }

        #headPhoto:hover{
            -webkit-box-shadow: 0px 0px 0px 15px rgba(0, 0, 0, 0.1);
            box-shadow: 0px 0px 0px 15px rgba(0, 0, 0, 0.1);
            }

        h1 {
            font-size: 30px;
            font-weight: 500;
            padding-top: 0px;
            }

        .like{
            height: 50px;
        
        }
        
   
        
        .functionButton{
            margin: 0px auto;
            width:280px ;
        }
        .functionButton >div> img{
            height: 40px;
            

        }
        .functionButton2{
            margin: 20px auto;
            width:280px ;
        }
        .functionButton2 >div> img{
            height: 40px;
            
        }
        .TotalSponsor{
                display: table-cell;
			    color: #f19100;
			    font-size: 40px;
			    width: 100%;
			    padding-left: 10px;
			    text-align: right;
        }
    </style>
    </head>
    <body onload="connect(); loadPhoto();" onunload="disconnect();">
    <div class="container" padding="0px">
        <div class="row">
            <div class="col-xs-12 col-sm-1"></div>
            <div class="col-xs-12 col-sm-10">
                <div class="container profile-card" >
            <div class="row">
                <!-- <div class="overlay"></div> -->
                <div class="col-xs-12 col-sm-5 header" >
                    <div class="headPhotoDiv" id="headPhotoDiv">
                        <img style="max-width:250px ; max-height:250px" src="<%=request.getContextPath()%>/front-end/DBGifReader_AdoptaniPhoto/DBGifReader_AdoptaniPhoto.do?adopt_Ani_Id=<%=adoptaniVO.getAdopt_Ani_Id()%>&ado_Pic_type=0" id="headPhoto">
                    <h1 align="center">
                        <%= adoptaniVO.getAdopt_Ani_name()%>
                    </h1>
                    </div>
                    <div class="row functionButton" align="center">
                    
                    
                        <div class="col-xs-12 col-sm-3 "><img src="icon/heartblue.png" ALT="喜歡" title="喜歡" id="like" onclick="AM_like()" value="unlike"></div>
                        <div class="col-xs-12 col-sm-3"><img src="icon/followers.png"  ALT="收藏" title="收藏"></div>
                        <div class="col-xs-12 col-sm-3"><img src="icon/donation2.png" ALT="贊助" title="贊助" onclick="loadSponsor()"></div>
                        <div class="col-xs-12 col-sm-3"><img src="icon/whistleBlue.png" ALT="檢舉" title="檢舉"></div>
                      
                    </div>
                    <div class="row functionButton2" align="center" padding-top="10px">
                        <div class="col-xs-12 col-sm-3 "><img src="icon/clipboard.png" ALT="詳細資料" title="詳細資料" onclick="loadDetails()"></div>
                        <div class="col-xs-12 col-sm-3"><img src="icon/album.png" ALT="相簿" title="相簿" onclick="loadPhoto()"></div>
                        <div class="col-xs-12 col-sm-3"><img src="icon/chatblue.png" ALT="留言" title="留言" onclick="loadMessage()"></div>
                        <div class="col-xs-12 col-sm-3">1</div>
                      
                    </div>
					<div class="row">
						<div class="col-xs-12 col-sm-2"></div>
						<div class="col-xs-12 col-sm-8">
							<table><tr><div><b>累積贊助金額</b></div>
								<div id="sponsorCount"><%=TotalSponsor %></div>
							</tr></table></div>
						<div class="col-xs-12 col-sm-2"></div>
					</div>

                </div>

                
                <div class="col-xs-12 col-sm-7 bio" id="listInformation" style=" overflow:auto; padding-top: 3px"></div>
            </div>
        </div>
            </div>
            <div class="col-xs-12 col-sm-1"></div>
        </div>
    </div>
        





        
        
        <script src="https://code.jquery.com/jquery.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    	<script>
			    /**
	    		*	websocket:
	    		*		記得body標籤裡要加onload="connect();" onunload="disconnect();"
	    		**/
    			var MyPoint = "/MyEchoServer_adoptani/<%= adoptaniVO.getAdopt_Ani_Id()%>/309";
			    var host = window.location.host;
			    var path = window.location.pathname;
			    var webCtx = path.substring(0, path.indexOf('/', 1));
			    var endPointURL = "ws://" + window.location.host + webCtx + MyPoint;
			    console.log(host);
			    console.log(path);
			    console.log(webCtx);
			    console.log(endPointURL);
				var webSocket;
				
				function connect() {
					// 建立 websocket 物件
					webSocket = new WebSocket(endPointURL);
					
					webSocket.onopen = function(event) {
					};
			
					webSocket.onmessage = function(event) {
						var sponsorCount = document.getElementById("sponsorCount");
				       // var jsonObj = JSON.parse(event.data);
				       // var message = jsonObj.total ;
				       console.log(event.data);
				       
				       
				       sponsorCount.innerHTML = event.data;
					};
			
					webSocket.onclose = function(event) {
					};
				}
				
				
				function disconnect () {
					webSocket.close();
				}
				
				function sendMessage(){
				}
				
		    
		</script>
    	
    	<script>
    	
	    	/**
	    	*	ajax小通道
	    	*	param:action-要轉交Controller的動作。
	    	*	ex. onclick="loadInformation('getOne_For_Display_FromView')"
	    	**/
   		 	function loadInformation(action){
				  var xhttp = new XMLHttpRequest();
				  xhttp.onreadystatechange = function() {
				    if (this.readyState == 4 && this.status == 200) {
				        
				        //List<AdoptaniPhotoVO> list = request.getAttribute("oneAdoptAniPhotoList", oneAdoptAniPhotoList);
				     document.getElementById("listInformation").innerHTML = xhttp.responseText;
				     
				    }else{
				       // alert("xhttp.status:"+ xhttp.status );
				     }
				  //  alert("xhttp.readyState:"+ xhttp.readyState );
				  };
				  var adopt_Ani_Id = "adopt_Ani_Id=<%= adoptaniVO.getAdopt_Ani_Id()%>";
				  var action2 = "action="+action;
				  var url = "<%=request.getContextPath()%>/front-end/adoptani/adoptani.do";
				  xhttp.open("POST", url , true);
				  xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
				  xhttp.send(action2+"&"+adopt_Ani_Id);
			}
    	
			
			
			function loadPhoto(){
			    
				  var xhttp = new XMLHttpRequest();
				  xhttp.onreadystatechange = function() {
				    if (this.readyState == 4 && this.status == 200) {
				        
				     document.getElementById("listInformation").innerHTML = xhttp.responseText;
				     
				    }else{
				     }
				  };
				  var adopt_Ani_Id = "adopt_Ani_Id=<%= adoptaniVO.getAdopt_Ani_Id()%>";
				  var action = "action=getOne_For_Display_From_listOneAdoptani.jsp";
				  var url = "<%=request.getContextPath()%>/front-end/adoptani_photo/adoptani_photo.do";
				  xhttp.open("POST", url , true);
				  xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
				  xhttp.send(action+"&"+adopt_Ani_Id);
				}
			
			function loadMessage(){
				document.getElementById("listInformation").innerHTML = "<iframe   width='100%' height='580' frameborder='0' id='iframeForMessage' src='<%=request.getContextPath()%>/front-end/adoptani_message/listOneAdoptaniAllMessageForView.jsp?adopt_Ani_Id=<%=adoptaniVO.getAdopt_Ani_Id()%>' ></iframe>";
				
			}
			
			function loadSponsor(){
				document.getElementById("listInformation").innerHTML = "<iframe   width='100%' height='580' frameborder='0' id='iframeForSpnsor' src='<%=request.getContextPath()%>/front-end/adoptani_sponsor/listOneAdoptaniAllSponsorForView.jsp?adopt_Ani_Id=<%=adoptaniVO.getAdopt_Ani_Id()%>' ></iframe>";
				
			}
			
			function loadDetails(){
				document.getElementById("listInformation").innerHTML = "<iframe   width='100%' height='580' frameborder='0' id='iframeForDetails' src='<%=request.getContextPath()%>/front-end/adoptani/listOneAdoptani.jsp?adopt_Ani_Id=<%=adoptaniVO.getAdopt_Ani_Id()%>' ></iframe>";
				
			}
			
			function TEST(){alert("test!")}
			
			function addPhotos(){
				document.getElementById("listInformation").innerHTML = "<iframe   width='100%' height='580' frameborder='0' id='iframeForDetails' src='<%=request.getContextPath()%>/front-end/adoptani_photo/addAdoptaniPhotoForView.jsp?adopt_Ani_Id=<%=request.getParameter("adopt_Ani_Id")%>' ></iframe>";
			}
			
			function changeToHead(adopt_Ani_IdX,ado_Ani_Pic_NoX){
				  var xhttp = new XMLHttpRequest();
				  xhttp.onreadystatechange = function() {
				    if (this.readyState == 4 && this.status == 200) {
				        
				    	window.location.reload();
// 				     document.getElementById("listInformation").innerHTML = xhttp.responseText;
				     
				    }else{
				     }
				  };
				  var adopt_Ani_Id = "adopt_Ani_Id="+adopt_Ani_IdX;
				  var ado_Ani_Pic_No = "ado_Ani_Pic_No="+ado_Ani_Pic_NoX;
				  var action = "action=changePhotoToHead";
				  var url = "<%=request.getContextPath()%>/front-end/adoptani_photo/adoptani_photo.do";
				  xhttp.open("POST", url , true);
				  xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
				  xhttp.send(action+"&"+adopt_Ani_Id+"&"+ado_Ani_Pic_No);
			}
			
			
			/**
			*	按讚、取消讚。
			**/
			function AM_like(){
				if($("#like").attr("value")=="unlike"){
					$("#like").attr("src", "images/like.png");
					$("#like").attr("value", "like");
					$.ajax({
						 type:"GET",
						 url:"<%=request.getContextPath()%>/front-end/adoptani/adoptani.do?action=changeLike",
						 data:{action:"changeLike",likeOrNot:"Like",adopt_Ani_Id:<%= adoptaniVO.getAdopt_Ani_Id()%>},
						 dataType:"text",//
						 success:function (data){alert("謝謝!!")}
					   });
					
					
				}else{
					$("#like").attr("src", "images/heartblue.png");
					$("#like").attr("value", "unlike");
					$.ajax({
						 type:"GET",
						 url:"<%=request.getContextPath()%>/front-end/adoptani/adoptani.do?action=changeLike",
						 data:{action:"changeLike",likeOrNot:"unLike",adopt_Ani_Id:<%= adoptaniVO.getAdopt_Ani_Id()%>},
						 dataType:"text",//
						 success:function (data){alert("可惡!!")}
					   });
				}
			}	
			
//		卷軸置底		

// 			$("#like").on('click',function(){
// 				alert("AA");
// 				var iframeForMessage = document.getElementById("iframeForMessage");
// 				iframeForMessage.scrollTop = iframeForMessage.scrollHeight;
//  				$("html").scrollTop(100);
// 				alert("BB");
// 			});
			
// 			function scrollDown(){
// 				alert("AA");
// 				var iframeForMessage = document.getElementById("iframeForMessage");
// 				iframeForMessage.innerHTML="0"
// 				iframeForMessage.scrollTop = iframeForMessage.scrollHeight;
// 				alert("BB");
// 			}
		
		</script>
    </body>
</html>

