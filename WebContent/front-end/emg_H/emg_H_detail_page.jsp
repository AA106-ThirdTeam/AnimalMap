<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>;-
<%@ page import="java.util.*"%>
<%@ page import="com.emg_H.model.*"%>


<%  
    Emg_HService emg_HSvc = new Emg_HService();
   	Emg_HVO emg_HVO =new Emg_HVO ();
   	
   	//從後端要include 這頁面時
   	if(request.getAttribute("emg_HVO")!=null){
	    emg_HVO  = (Emg_HVO)request.getAttribute("emg_HVO");
    }else {
    	//從前端頁面來時
    	String tem_Id = request.getParameter("Id"); 
        emg_HVO  = emg_HSvc.getOneEmg_H(tem_Id);  
    }
    
%>
<!DOCTYPE html>
<html lang="">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>緊急求救</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://code.jquery.com/jquery.js"></script>
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
       /*---- ----  */ 
.am_image_btn:hover {
  transform: scale(1.5);
  -moz-transform: scale(1.5);
  -webkit-transform: scale(1.5);
  -o-transform: scale(1.5);
  -ms-transform: scale(1.5); /* IE 9 */
}         
    </style>
    </head>
    <body onload="" onunload="">
    <div class="container" padding="0px">
        <div class="row">
            <div class="col-xs-12 col-sm-1"></div>
            <div class="col-xs-12 col-sm-10">
                <div class="container profile-card" >
            <div class="row">
                <!-- <div class="overlay"></div> -->
                <div class="col-xs-12 col-sm-5 header" >
                    <div class="headPhotoDiv" id="headPhotoDiv">
                        <img style="max-width:250px ; max-height:250px" 
                        	src="<%=request.getContextPath()%>/Emg_H_PicReader?emg_H_Id= <%=emg_HVO.getEmg_H_Id() %>" id="headPhoto"
                       	>                    
                    <h1 align="center">
                        <%= emg_HVO.getEmg_H_title()%>
                    </h1>
                    </div>
                    <div class="row functionButton" align="center">
                         <div class="col-xs-12 col-sm-3 am_image_btn " style="cursor:pointer" ><img src="https://i.imgur.com/jlxiTkb.png" ALT="檢舉" title="檢舉" onclick="emg_H_Report()"> </div>
                          <div class="col-xs-12 col-sm-3 am_image_btn " style="cursor:pointer"><img src="https://i.imgur.com/9cSyePC.png" ALT="詳細資料" title="詳細資料" onclick="emg_H_Details()"></div>
                        <div class="col-xs-12 col-sm-3 am_image_btn " style="cursor:pointer"><img src="https://i.imgur.com/PvWn5cH.png" ALT="留言" title="留言" onclick="emgH_Message()"></div>
                 
                    </div>
                   
                </div>
                <div class="col-xs-12 col-sm-7 bio" id="listInformation" style=" overflow:auto; padding-top: 3px">
                	<iframe   width='100%' height='580' frameborder='0' id='iframeForDetails' 
                		src='<%=request.getContextPath()%>/front-end/emg_H/listOneEmg_HforView.jsp?emg_H_Id=<%=emg_HVO.getEmg_H_Id() %>' >
                	</iframe>                
                </div>
            </div>
        </div>
            </div>
            <div class="col-xs-12 col-sm-1">
             
        </div>
    </div>
    
    </body>
</html>

<script>

//點擊後看Details 
function emg_H_Details(){
	document.getElementById("listInformation").innerHTML = "<iframe   width='100%' height='580' frameborder='0' id='iframeForDetails' src='<%=request.getContextPath()%>/front-end/emg_H/listOneEmg_HforView.jsp?emg_H_Id=<%=emg_HVO.getEmg_H_Id() %>' ></iframe>";
	
}
//點擊後看留言 與新增留言
function emgH_Message(){
	document.getElementById("listInformation").innerHTML = "<iframe   width='100%' height='580' frameborder='0' id='iframeForDetails' src='<%=request.getContextPath()%>/front-end/emg_H/listEmg_H_Msg_ByEmg_H_IdForView.jsp?emg_H_Id=<%=emg_HVO.getEmg_H_Id() %>' ></iframe>";
}
// 點擊後檢舉的頁面
function emg_H_Report(){
	document.getElementById("listInformation").innerHTML = "<iframe   width='100%' height='580' frameborder='0' id='iframeForDetails' src='<%=request.getContextPath()%>/front-end/emg_H/listOneEmg_HforView2(Report).jsp?emg_H_Id=<%=emg_HVO.getEmg_H_Id() %>' ></iframe>";

}


</script>
