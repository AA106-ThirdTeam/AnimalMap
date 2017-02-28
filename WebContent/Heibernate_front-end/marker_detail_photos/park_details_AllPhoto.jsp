<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.adoptani_photo.model.*"%>
<%
    List<AdoptaniPhotoVO> list = (List) request.getAttribute("oneAdoptAniPhotoList");
    pageContext.setAttribute("list",list);  //如果沒有setAttribute，JLTS的for each就沒辦法跑。
%>
<html>
<head>
<title>所有送養動物照片 - listOneAdoptani.jsp</title>
</head>
<body bgcolor='white'>
<script>
</script>
<style type="text/css">
    #div_right_bottom {
    width:60px;
    height:60px;
    float:right;
    position:absolute;
    right:8%;
    bottom:8%;
    z-index:20;
    border:2px solid #69c;
    _position:absolute; /* position fixed for IE6 */
    }
</style>
<table border='1' bordercolor='#CCCCFF' >
<div id="carousel-id" class="carousel slide" data-ride="carousel">
        <!-- 幻燈片小圓點區 -->
        <ol class="carousel-indicators">
            <%for(int i=0 ; i<=list.size();i++){ 
                if(i == list.size()){%>
                    <li data-target="#carousel-id" data-slide-to="<%=i %>" class="active"></li>
                <%}else{ %>
                    <li data-target="#carousel-id" data-slide-to="<%=i %>" class=""></li>
                <%} %>
            <%} %>
        </ol>
        <%String firstTime = "active"; %>
        <!-- 幻燈片主圖區 -->
        <div class="carousel-inner " style="height: 580px;">
            <c:forEach var="adoptaniPhotoVO" items="" >
                <div class="item <%= firstTime%>">
                    <img src="<%=request.getContextPath()%>/front-end/DBGifReader_AdoptaniPhoto/DBGifReader_AdoptaniPhoto.do?ado_Ani_Pic_No=" alt="" max-height="">
                    <div class="container">
                        <div class="carousel-caption">
                            <p><a class="btn btn-lg btn-primary"  padding-up="100" href="#" role="button" onclick="changeToHead(,);">設為大頭照</a></p>
                        </div>
                    </div>
                </div>
                <%firstTime = ""; %>
             </c:forEach>
        </div>
        <!-- 上下頁控制區 -->
        <a class="left carousel-control" href="#carousel-id" data-slide="prev"><span class="glyphicon glyphicon-chevron-left"></span></a>
        <a class="right carousel-control" href="#carousel-id" data-slide="next"><span class="glyphicon glyphicon-chevron-right"></span></a>
</div>
</table>
<div ><img src="images/plus.png" id="div_right_bottom" onclick="addPhotos()" ></div>
</body>
</html>
