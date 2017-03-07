<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.strayani.model.*"%>
<%@ page import="com.chung.tools.Tools"%>
<%@page import="heibernate_com.mem.model.MemVO"%>

<jsp:useBean id="strayaniVO" scope="request" class="com.strayani.model.StrayaniVO" />

<%	

    Tools tools = new Tools();
    String mem_Id;
    try{
    	MemVO memVO = (MemVO)session.getAttribute("account");
		mem_Id = memVO.getMem_Id();
	}catch(Exception e){
		mem_Id = "1000001";
	};
%>


<!DOCTYPE html>
<html lang="">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>送養動物資料 - listOneStrayani.jsp</title>
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
/*             background: rgba(0, 97, 145, 0.45); */
			background:#fc972a;
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
            border:solid 10px #ffc98e;
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
        
        .functionButton >div> img:hover {
			  transform: scale(1.5);
			  -moz-transform: scale(1.5);
			  -webkit-transform: scale(1.5);
			  -o-transform: scale(1.5);
			  -ms-transform: scale(1.5); /* IE 9 */
		}         
        
        
        .functionButton2 >div> img:hover {
			  transform: scale(1.5);
			  -moz-transform: scale(1.5);
			  -webkit-transform: scale(1.5);
			  -o-transform: scale(1.5);
			  -ms-transform: scale(1.5); /* IE 9 */
		}
		
		#reportButton:hover { 
			  transform: scale(1.5);  			  
			  -moz-transform: scale(1.5); 			  
			  -webkit-transform: scale(1.5); 
 			  -o-transform: scale(1.5); 
 			  -ms-transform: scale(1.5); /* IE 9 */
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
    <body onload="connect(); loadPhotoStrayani();" onunload="disconnect();">
    <div class="container" padding="0px">
        <div class="row">
            <div class="col-xs-12 col-sm-1"></div>
            <div class="col-xs-12 col-sm-10">
                <div class="container profile-card" >
            <div class="row">
                <!-- <div class="overlay"></div> -->
                <div class="col-xs-12 col-sm-5 header" >
                    <div class="headPhotoDiv" id="headPhotoDiv">
                        <img style="max-width:250px ; max-height:250px" src="<%=request.getContextPath()%>/front-end/DBGifReader_StrayaniPhoto/DBGifReader_StrayaniPhoto.do?stray_Ani_Id=<%=strayaniVO.getStray_Ani_Id()%>&stray_Pic_type=0" id="headPhoto">
                    
                    <h1 align="center">
                        	送養動物:<%= strayaniVO.getStray_Ani_name()%>
                    </h1>
                    </div>
                    <div class="row functionButton" align="center">
                    
                    
                        <div class="col-xs-12 col-sm-3 "><img src="<%=request.getContextPath()%>/front-end/strayani/icon/heartblue.png" ALT="喜歡" title="喜歡" id="like" onclick="AM_like()" value="unlike"></div>
                        <div class="col-xs-12 col-sm-3"><img src="<%=request.getContextPath()%>/front-end/strayani/icon/followers.png"  ALT="收藏" title="收藏" onclick="addFavoritStrayani()"></div>
                        <div class="col-xs-12 col-sm-3"><img src="<%=request.getContextPath()%>/front-end/strayani/icon/location.png" ALT="定位" title="定位" onclick="loadLocationStrayani()"></div>
                        <div class="col-xs-12 col-sm-3"><a href='#modal-id' data-toggle="modal" class=""><img id="reportButton" height="40" width="40" src="<%=request.getContextPath()%>/front-end/strayani/icon/whistleBlue.png" ALT="檢舉" title="檢舉"></a></div>
                      
                    </div>
                    <div class="row functionButton2" align="center" padding-top="10px">
                        <div class="col-xs-12 col-sm-3 "><img src="<%=request.getContextPath()%>/front-end/strayani/icon/clipboard.png" ALT="詳細資料" title="詳細資料" onclick="loadDetailsStrayani()"></div>
                        <div class="col-xs-12 col-sm-3"><img src="<%=request.getContextPath()%>/front-end/strayani/icon/album.png" ALT="相簿" title="相簿" onclick="loadPhotoStrayani()"></div>
                        <div class="col-xs-12 col-sm-3"><img src="<%=request.getContextPath()%>/front-end/strayani/icon/chatblue.png" ALT="留言" title="留言" onclick="loadMessageStrayani()"></div>
                        <div class="col-xs-12 col-sm-3"><img style="" src="<%=request.getContextPath()%>/front-end/strayani/icon/adoption.png" ALT="領養" title="領養" onclick="strayAnimalMsg()"></div>
                      
                    </div>

                </div>

                
                <div class="col-xs-12 col-sm-7 bio" id="listInformation" style=" overflow:auto; padding-top: 3px"></div>
            </div>
        </div>
            </div>
            <div class="col-xs-12 col-sm-1"></div>
        </div>
    </div>
        
		<!-- 檢舉的跳出視窗 -->  
	<form id="report">    
	
	
	<div class="modal fade" id="modal-id">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
						<h4 class="modal-title">檢舉標題</h4>
						<input type="text" name="report_name" size="30" style="">
					</div>
					<div class="modal-body">
						檢舉內容<br>
						<textarea rows="4" cols="50" name="report_content" ></textarea>
					</div>
						<input type="hidden" name="report_class" value="ADOPT_ANI">
						<input type="hidden" name="report_class" value="ADOPT_ANI">
						<input type="hidden" name="report_class_No" value="ADOPT_ANI_ID">
						<input type="hidden" name="report_class_No_value" value="<%=strayaniVO.getStray_Ani_Id()%>">
						<input type="hidden" name="report_class_status" value="stray_Ani_status=" >
						<input type="hidden" name="report_status" value="0" >
						<input type="hidden" name="mem_Id_active" value="<%=mem_Id%>" >
						<input type="hidden" name="mem_Id_passive" value="<%=strayaniVO.getMem_Id()%>" >
						<input type="hidden" name="action" value="InsertReport" >
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal" id="closeReportStrayani">關閉</button>
						<button type="button" class="btn btn-primary" onclick="sendReportStrayani()">送出檢舉</button>
					</div>
				</div>
			</div>
	</div>
	</form>  



        




        
        
        <script src="https://code.jquery.com/jquery.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    	<script>
			    /**
	    		*	websocket:
	    		*		記得body標籤裡要加onload="connect();" onunload="disconnect();"
	    		**/
    			var MyPoint = "/MyEchoServer_strayani/<%= strayaniVO.getStray_Ani_Id()%>/309";
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
				  var xhttp = 
					  
					  
					  new XMLHttpRequest();
				  xhttp.onreadystatechange = function() {
				    if (this.readyState == 4 && this.status == 200) {
				        
				        //List<StrayaniPhotoVO> list = request.getAttribute("oneStrayAniPhotoList", oneStrayAniPhotoList);
				     document.getElementById("listInformation").innerHTML = xhttp.responseText;
				     
				    }else{
				       // alert("xhttp.status:"+ xhttp.status );
				     }
				  //  alert("xhttp.readyState:"+ xhttp.readyState );
				  };
				  var stray_Ani_Id = "stray_Ani_Id=<%= strayaniVO.getStray_Ani_Id()%>";
				  var action2 = "action="+action;
				  var url = "<%=request.getContextPath()%>/front-end/strayani/strayani.do";
				  xhttp.open("POST", url , true);
				  xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
				  xhttp.send(action2+"&"+stray_Ani_Id);
			}
    	
			
			
			function loadPhotoStrayani(){
			    
				  var xhttp = new XMLHttpRequest();
				  xhttp.onreadystatechange = function() {
				    if (this.readyState == 4 && this.status == 200) {
				        
				     document.getElementById("listInformation").innerHTML = xhttp.responseText;
				     
				    }else{
				     }
				  };
				  var stray_Ani_Id = "stray_Ani_Id=<%= strayaniVO.getStray_Ani_Id()%>";
				  var action = "action=getOne_For_Display_From_listOneStrayani.jsp";
				  var url = "<%=request.getContextPath()%>/front-end/strayani_photo/strayani_photo.do";
				  xhttp.open("POST", url , true);
				  xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
				  xhttp.send(action+"&"+stray_Ani_Id);
				}
			
			function loadMessageStrayani(){
				document.getElementById("listInformation").innerHTML = "<iframe   width='100%' height='580' frameborder='0' id='iframeForMessage' src='<%=request.getContextPath()%>/front-end/strayani_message/listOneStrayaniAllMessageForView.jsp?stray_Ani_Id=<%=strayaniVO.getStray_Ani_Id()%>' ></iframe>";
				
			}
			
			function loadSponsorStrayani(){
				document.getElementById("listInformation").innerHTML = "<iframe   width='100%' height='580' frameborder='0' id='iframeForSpnsor' src='<%=request.getContextPath()%>/front-end/strayani_sponsor/listOneStrayaniAllSponsorForView.jsp?stray_Ani_Id=<%=strayaniVO.getStray_Ani_Id()%>' ></iframe>";
				
			}
			
			function loadDetailsStrayani(){
				document.getElementById("listInformation").innerHTML = "<iframe   width='100%' height='580' frameborder='0' id='iframeForDetails' src='<%=request.getContextPath()%>/front-end/strayani/listOneStrayani.jsp?stray_Ani_Id=<%=strayaniVO.getStray_Ani_Id()%>' ></iframe>";
				
			}
			
			function addFavoritStrayani(){
				alert("加入收藏");
			}
			
			
			function sendStrayMessage(){
				alert("已通知送養人");
			}
			
			function TEST(){alert("test!")}
			
		
			
//			**寫在listOneStrayaniAllPhoto.jsp			
// 			function addPhotosStrayani(){
<%-- 				document.getElementById("listInformation").innerHTML = "<iframe   width='100%' height='580' frameborder='0' id='iframeForDetails' src='<%=request.getContextPath()%>/front-end/strayani_photo/addStrayaniPhotoForView.jsp?stray_Ani_Id=<%=request.getParameter("stray_Ani_Id")%>' ></iframe>"; --%>
// 			}
		
// 			function changeToHead(stray_Ani_IdX,str_Ani_Pic_NoX){
// 				  var xhttp = new XMLHttpRequest();
// 				  xhttp.onreadystatechange = function() {
// 				    if (this.readyState == 4 && this.status == 200) {
				        
// 				    	window.location.reload();
// // 				     document.getElementById("listInformation").innerHTML = xhttp.responseText;
				     
// 				    }else{
// 				     }
// 				  };
// 				  var stray_Ani_Id = "stray_Ani_Id="+stray_Ani_IdX;
// 				  var str_Ani_Pic_No = "str_Ani_Pic_No="+str_Ani_Pic_NoX;
// 				  var action = "action=changePhotoToHead";
<%-- 				  var url = "<%=request.getContextPath()%>/front-end/strayani_photo/strayani_photo.do"; --%>
// 				  xhttp.open("POST", url , true);
// 				  xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
// 				  xhttp.send(action+"&"+stray_Ani_Id+"&"+str_Ani_Pic_No);
// 			}
	
			
			/**
			*	按讚、取消讚。
			**/
			function AM_like(){
				if($("#like").attr("value")=="unlike"){
					$("#like").attr("src", "<%=request.getContextPath()%>/front-end/strayani/images/like.png");
					$("#like").attr("value", "like");
					$.ajax({
						 type:"GET",
						 url:"<%=request.getContextPath()%>/front-end/strayani/strayani.do?action=changeLike",
						 data:{action:"changeLike",likeOrNot:"Like",stray_Ani_Id:<%= strayaniVO.getStray_Ani_Id()%>},
						 dataType:"text",//
						 success:function (data){alert("謝謝!!")}
					   });
					
					
				}else{
					$("#like").attr("src", "images/heartblue.png");
					$("#like").attr("value", "unlike");
					$.ajax({
						 type:"GET",
						 url:"<%=request.getContextPath()%>/front-end/strayani/strayani.do?action=changeLike",
						 data:{action:"changeLike",likeOrNot:"unLike",stray_Ani_Id:<%= strayaniVO.getStray_Ani_Id()%>},
						 dataType:"text",//
						 success:function (data){alert("可惡!!")}
					   });
				}
			}	
			
			/**
			 *	送出檢舉。
			 **/
			function sendReportStrayani(){
				
				
				  var xhttp = new XMLHttpRequest();
				  xhttp.onreadystatechange = function() {
				    if (this.readyState == 4 && this.status == 200) {
				    
//   				     	document.getElementById("listInformation").innerHTML = xhttp.responseText;
  				  		$("#closeReportStrayani").click();
  				  		alert("送出檢舉，待審核中");
				    	
				    }else{
				    }
				  };
				  var reportInfo = $("#report").serialize();
// 				  alert($("#report").serialize());
				  var url = "<%=request.getContextPath()%>/back-end/report/report.do";
				  xhttp.open("POST", url , true);
				  xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
				  xhttp.send(reportInfo);
				  
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
		
		
		<script>
			
			function changeToHead(stray_Ani_IdX,str_Ani_Pic_NoX){
				  var xhttp = new XMLHttpRequest();
				  xhttp.onreadystatechange = function() {
				    if (this.readyState == 4 && this.status == 200) {
				        
				    	window.location.reload();
// 				     document.getElementById("listInformation").innerHTML = xhttp.responseText;
				     
				    }else{
				     }
				  };
				  var stray_Ani_Id = "stray_Ani_Id="+stray_Ani_IdX;
				  var str_Ani_Pic_No = "str_Ani_Pic_No="+str_Ani_Pic_NoX;
				  var action = "action=changePhotoToHead";
				  var url = "<%=request.getContextPath()%>/front-end/strayani_photo/strayani_photo.do";
				  xhttp.open("POST", url , true);
				  xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
				  xhttp.send(action+"&"+stray_Ani_Id+"&"+str_Ani_Pic_No);
			};
			
			function addPhotosStrayani(){
				
				document.getElementById("listInformation").innerHTML = "<iframe   width='100%' height='580' frameborder='0' id='iframeForDetails' src='<%=request.getContextPath()%>/front-end/strayani_photo/addStrayaniPhotoForView.jsp?stray_Ani_Id=<%=request.getParameter("stray_Ani_Id")%>' ></iframe>";
			};

	</script>
	
	<!-- -領養- -->
	<script>		
			
								
				var MyPoint1 = "/MyEchoServer/"+"notApplicable"+"/"+${strayaniVO.mem_Id}+"/strayMsg";
				//console.log(MyPoint1);
				var host = window.location.host;
				var path = window.location.pathname;
				var webCtx = path.substring(0, path.indexOf('/', 1));
				var endPointURL1 = "ws://" + window.location.host + webCtx + MyPoint1;
				
				var note = $(".numberSysInfo");
				var webSocket1;
				
				function strayAnimalMsg() {
					
					$.ajax({
						url : "<%=request.getContextPath()%>/privMsg/privMsg.do",
						data : "action=insert" +"&mem_Id="+ <%=mem_Id%> +"&privMsgRec_MemId=${strayaniVO.mem_Id}&message=您好，我想要領養<%= strayaniVO.getStray_Ani_name()%>，請與我聯絡，謝謝。",
						type : "POST",
						dataType : 'text',
						success : function(msg) {								
							$(".numberSysInfo").text(msg);
							alert("已通知送養人，請等候送養人與您聯絡。")
						},
						
						error : function(xhr, ajaxOptions, thrownError) {
							alert(xhr.status);
							alert(thrownError);
						}
					})
					
					
				//	console.log(endPointURL1);
				//	console.log(host);
				//	console.log(path);
				//	console.log(webCtx);
				
					// 建立 websocket 物件
					webSocket1 = new WebSocket(endPointURL1);
					
					webSocket1.onopen = function(event) {
				//		updateStatus1("WebSocket 成功連線");
						
					};
				
					webSocket1.onmessage = function(event) {
						         
				//      var jsonObj = JSON.parse(event.data);
				//      var message = jsonObj.userName + ": " + jsonObj.message + "\r\n";
				     console.log("event.data2=  "+event.data);
				     
				     console.log("<%=request.getContextPath()%>/privMsg/privMsg.do");
				     console.log("event.data=  "+event.data);
				     console.log("event.data=  "+event.data);
				     console.log("event.data=  "+event.data);
				//      updateStatus1(message);
				     
				     
						console.log("event.data2=  "+event.data);
				     
					};
				
				}
			
	</script>
	
    </body>
</html>

