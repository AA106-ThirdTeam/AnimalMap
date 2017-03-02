<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>;-
<%@ page import="java.util.*"%>
<%@ page import="heibernate_com.emg_help.model.*"%>
<%@ page import="com.adoptani_sponsor.model.*"%>
<%  
    Emg_HelpService emg_helpSvc = new Emg_HelpService();
    String str_action = request.getParameter("action");
    String tem_Id = request.getParameter("Id"); 
    Emg_HelpVO vo  = emg_helpSvc.getOneEmg_Help(tem_Id);   
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
                        <img style="max-width:250px ; max-height:250px" 
                        	src="<%= vo.getEmg_H_Pic()%>" id="headPhoto"
                       	>                    
                    <h1 align="center">
                        <%= vo.getEmg_H_title()%>
                    </h1>
                    </div>
                    <div class="row functionButton" align="center">
                        <div class="col-xs-12 col-sm-3 am_image_btn " style="cursor:pointer"><img src="https://i.imgur.com/lbVHrvj.png" ALT="喜歡" title="喜歡" id="like" onclick="AM_like()" value="unlike"></div>
                        <div class="col-xs-12 col-sm-3 am_image_btn " style="cursor:pointer"><img src="https://i.imgur.com/HSHzONs.png"  ALT="收藏" title="收藏"></div>
                        <div class="col-xs-12 col-sm-3 am_image_btn " style="cursor:pointer"><img src="https://i.imgur.com/UIK0Jp0.png" ALT="贊助" title="贊助" onclick="loadSponsor()"></div>
                        <div class="col-xs-12 col-sm-3 am_image_btn " style="cursor:pointer"><img src="https://i.imgur.com/jlxiTkb.png" ALT="檢舉" title="檢舉"></div>
                    </div>
                    <div class="row functionButton2" align="center" padding-top="10px">
                        <div class="col-xs-12 col-sm-3 am_image_btn " style="cursor:pointer"><img src="https://i.imgur.com/9cSyePC.png" ALT="詳細資料" title="詳細資料" onclick="loadDetails()"></div>
                        <div class="col-xs-12 col-sm-3 am_image_btn " style="cursor:pointer"><img src="https://i.imgur.com/bxL8DNo.png" ALT="相簿" title="相簿" onclick="loadPhoto()"></div>
                        <div class="col-xs-12 col-sm-3 am_image_btn " style="cursor:pointer"><img src="https://i.imgur.com/PvWn5cH.png" ALT="留言" title="留言" onclick="loadMessage()"></div>
                    </div>
                    <div class="row">
                        <div class="col-xs-12 col-sm-2"></div>
                        <div class="col-xs-12 col-sm-8"></div>
                        <div class="col-xs-12 col-sm-2"></div>
                    </div>
                </div>
                <div class="col-xs-12 col-sm-7 bio" id="listInformation" style=" overflow:auto; padding-top: 3px">
                	<iframe   width='100%' height='580' frameborder='0' id='iframeForDetails' 
                		src='<%=request.getContextPath()%>/Heibernate_front-end/marker_detail_photos/emg_Help_details_AllPhoto.jsp?=<%=tem_Id%>' >
                	</iframe>                
                </div>
            </div>
        </div>
            </div>
            <div class="col-xs-12 col-sm-1"></div>
        </div>
    </div>
    </body>
</html>
