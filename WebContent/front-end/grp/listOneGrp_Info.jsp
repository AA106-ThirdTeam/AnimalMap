<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ page import="java.util.*"%>
<%@ page import="com.grp.model.*"%>
<%-- 此頁練習採用 EL 的寫法取值 --%>

<% 
	session.setAttribute("Mem_Id_1", "1000000");
	session.setAttribute("Mem_Id_2", "1000001");
	session.setAttribute("Mem_Id_3", "1000002");
%>

<%
// 	List<HosVO> list = null;

// 	if (request.getAttribute("listHos_BySearchCondition") == null) {
// 		HosService grpSvc = new HosService();
// 		list = grpSvc.getAll();
// 	} else {
// 		list = (List<HosVO>) request.getAttribute("listHos_BySearchCondition");
// 	}

// 	pageContext.setAttribute("list", list);
%>
<html lang="">

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
            
                 <div class="row">
                    <div class="col-xs-12 col-sm-12 col-md-3 title">
                       <span class="glyphicon glyphicon-map-marker"></span>&nbsp&nbsp
                       地址
                   </div>
                   <div class="col-xs-12 col-sm-12 col-md-8 underLine">
                    ${grpVO.grp_city}${grpVO.grp_town}${grpVO.grp_road}
                   </div>
               </div>


                <div class="row">
    
                    <div class="col-xs-12 col-sm-12 col-md-3 title">
                        <span class="glyphicon glyphicon-time" style="color:green"></span>&nbsp&nbsp
                        揪團開始時間
                    </div>
                    <div class="col-xs-12 col-sm-12 col-md-8 underLine">
                         <fmt:formatDate value="${grpVO.grp_StartTime}" type="both" timeStyle="short"/>
                    </div>
                </div>

              <div class="row">
                   <div class="col-xs-12 col-sm-12 col-md-3 title">
                       <span class="glyphicon glyphicon-time" style="color:red"></span>&nbsp&nbsp
                       揪團結束時間
                   </div>
                   <div class="col-xs-12 col-sm-12 col-md-8 underLine">
                      <fmt:formatDate value="${grpVO.grp_EndTime}" type="both" timeStyle="short"/>
                   </div>
              </div>
                       
                <div class="row">
                    <div class="col-xs-12 col-sm-12 col-md-3 title">
                        <span class="glyphicon glyphicon-user"></span>&nbsp&nbsp
                         揪團連絡人
                    </div>
                      <div class="col-xs-12 col-sm-12 col-md-8 underLine">
                         ${grpVO.grp_MemId}
                    </div>
                </div>

                <div class="row"><div class="col-xs-12 col-sm-12 col-md-3 title">
                <span class="glyphicon glyphicon-info-sign"></span>&nbsp&nbsp
                          揪團敘述
                    </div>
                    <div class="col-xs-12 col-sm-12 col-md-8 underLine">
                         ${grpVO.grp_Desc}
                    </div>
                 </div>
            
        </div>
    </div>

    <script src="https://code.jquery.com/jquery.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>

</html>