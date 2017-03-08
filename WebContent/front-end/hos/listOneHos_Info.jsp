<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ page import="java.util.*"%>
<%@ page import="com.hos.model.*"%>
<%-- �����m�߱ĥ� EL ���g�k���� --%>
<jsp:useBean id="memSvc" scope="request" class="com.mem_dream.model.MemService"/>


<%
// 	List<HosVO> list = null;

// 	if (request.getAttribute("listHos_BySearchCondition") == null) {
// 		HosService hosSvc = new HosService();
// 		list = hosSvc.getAll();
// 	} else {
// 		list = (List<HosVO>) request.getAttribute("listHos_BySearchCondition");
// 	}

// 	pageContext.setAttribute("list", list);
%>
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
    <style type="text/css" media="screen">
     .underLine {
        border-bottom: 1px solid darkgray; 
         padding-bottom: 5px; 
         padding-left: 0px; 
        margin-top: 15px;
     } 
     .title{
    	font-weight: 900;
    	font-size: 17px;
    	margin-top: 5px; 
    } 


    </style>
</head>

<body>

    <div class="container" style="width: 700px; margin-top:15px" >
        <div class="row">
            

              <!--   <div class="col-xs-12 col-sm-3">${hosVO.hos_name}</h1> -->

                 <div class="row">
                    <div class="col-xs-12 col-sm-6 col-md-3 title">
                       <span class="glyphicon glyphicon-map-marker"></span>&nbsp&nbsp
                       �a�}
                   </div>
                   <div class="col-xs-12 col-sm-6 col-md-6 underLine">
                    ${hosVO.hos_city}${hosVO.hos_town}${hosVO.hos_road}
                   </div>
               </div>


                <div class="row">
    
                    <div class="col-xs-12 col-sm-12 col-md-3 title">
                        <span class="glyphicon glyphicon-time" style="color:green"></span>&nbsp&nbsp
                        �}�l��~�ɶ�
                    </div>
                    <div class="col-xs-12 col-sm-12 col-md-6 underLine">
                         ${hosVO.hos_StartTime}
                    </div>
                </div>

              <div class="row">
                   <div class="col-xs-12 col-sm-12 col-md-3 title">
                       <span class="glyphicon glyphicon-time" style="color:red"></span>&nbsp&nbsp
                       ������~�ɶ�
                   </div>
                   <div class="col-xs-12 col-sm-12 col-md-6 underLine">
                        ${hosVO.hos_EndTime}
                   </div>
              </div>

                <div class="row">
                    <div class="col-xs-12 col-sm-12 col-md-3 title">
                        <span class="glyphicon glyphicon-phone-alt"></span>&nbsp&nbsp
                        �p���q��
                     </div>
                     <div class="col-xs-12 col-sm-12 col-md-6 underLine">
                         ${hosVO.hos_Tel}
                    </div>
                </div>

                <div class="row">
                    <div class="col-xs-12 col-sm-12 col-md-3 title">
                        <span class="glyphicon glyphicon-globe"></span>&nbsp&nbsp
                        ��|���}
                    </div>
                    <div class="col-xs-12 col-sm-12 col-md-6 underLine">
                         ${hosVO.hos_URL}
                    </div>
                </div>

                <div class="row">
                    <div class="col-xs-12 col-sm-12 col-md-3 title">
                        <span class="glyphicon glyphicon-user"></span>&nbsp&nbsp
                        ��|�s���H
                    </div>
                       <div class="col-xs-12 col-sm-12 col-md-6 underLine">
                         ${memSvc.getOneMem(hosVO.hos_MemId).mem_name}
                    </div>
                </div>

                <div class="row"><div class="col-xs-12 col-sm-12 col-md-3 title">
                <span class="glyphicon glyphicon-info-sign"></span>&nbsp&nbsp
                    �E�ұԭz
                    </div>
                    <div class="col-xs-12 col-sm-12 col-md-6 underLine">
                         ${hosVO.hos_Desc}
                    </div>
                 </div>
            
        </div>
    </div>

    <script src="https://code.jquery.com/jquery.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>

</html>