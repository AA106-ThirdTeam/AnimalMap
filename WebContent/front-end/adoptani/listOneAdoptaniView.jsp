<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.adoptani.model.*"%>
<%@ page import="com.chung.tools.Tools"%>

<%
    Tools tools = new Tools();
%>

<jsp:useBean id="adoptaniVO" scope="request" class="com.adoptani.model.AdoptaniVO" />

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
        .EE{
            height: 100px;
            background-color: #000;
        }
    </style>
    </head>
    <body>
    <div class="container" padding="0px">
        <div class="row">
            <div class="col-xs-12 col-sm-1"></div>
            <div class="col-xs-12 col-sm-10">
                <div class="container profile-card" >
            <div class="row">
                <!-- <div class="overlay"></div> -->
                <div class="col-xs-12 col-sm-5 header" >
                    <div class="headPhotoDiv">
                        <img src="<%=request.getContextPath()%>/front-end/DBGifReader_AdoptaniPhoto/DBGifReader_AdoptaniPhoto.do?adopt_Ani_Id=<%= adoptaniVO.getAdopt_Ani_Id()%>&ado_Pic_type=0" id="headPhoto">
                    <h1 align="center">
                        <%= adoptaniVO.getAdopt_Ani_name()%>
                    </h1>
                    </div>
                    <div class="row functionButton" align="center">
                        <div class="col-xs-12 col-sm-3 "><img src="icon/heartblue.png" ALT="喜歡" title="喜歡" id="like"></div>
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
    	
	    	
	
			function loadDetails(){
			    
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
			  var action = "action=getOne_For_Display_FromView";
			  var url = "<%=request.getContextPath()%>/front-end/adoptani/adoptani.do";
			  xhttp.open("POST", url , true);
			  xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
			  xhttp.send(action+"&"+adopt_Ani_Id);
			//  xhttp.send(adopt_Ani_Id);
			}
			
			
			function loadPhoto(){
			    
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
				  var action = "action=getOne_For_Display_From_listOneAdoptani.jsp";
				  var url = "<%=request.getContextPath()%>/front-end/adoptani_photo/adoptani_photo.do";
				  xhttp.open("POST", url , true);
				  xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
				  xhttp.send(action+"&"+adopt_Ani_Id);
				//  xhttp.send(adopt_Ani_Id);
				}
			
			function loadMessage(){
				document.getElementById("listInformation").innerHTML = "<iframe   width='100%' height='580' frameborder='0' id='iframeForMessage' src='<%=request.getContextPath()%>/front-end/adoptani_message/listOneAdoptaniAllMessageForView.jsp?adopt_Ani_Id=<%=adoptaniVO.getAdopt_Ani_Id()%>' ></iframe>";
				
			}
			
			function loadSponsor(){
				document.getElementById("listInformation").innerHTML = "<iframe   width='100%' height='580' frameborder='0' id='iframeForSpnsor' src='<%=request.getContextPath()%>/front-end/adoptani_sponsor/listOneAdoptaniAllSponsorForView.jsp?adopt_Ani_Id=<%=adoptaniVO.getAdopt_Ani_Id()%>' ></iframe>";
				
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

