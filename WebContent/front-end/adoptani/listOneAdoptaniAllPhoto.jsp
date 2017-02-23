<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.adoptani_photo.model.*"%>
<%

 	List<AdoptaniPhotoVO> list = (List) request.getAttribute("oneAdoptAniPhotoList");
	pageContext.setAttribute("list",list);	//如果沒有setAttribute，JLTS的for each就沒辦法跑。
	
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
		    <c:forEach var="adoptaniPhotoVO" items="${list}" >
		        <div class="item <%= firstTime%>">
		            <img src="<%=request.getContextPath()%>/front-end/DBGifReader_AdoptaniPhoto/DBGifReader_AdoptaniPhoto.do?ado_Ani_Pic_No=${adoptaniPhotoVO.ado_Ani_Pic_No}" alt="" max-height="">
		            <div class="container">
		                <div class="carousel-caption">
<!-- 		                    <h1>CSS可樂好喝超爽快</h1> -->
<!-- 		                    <p>你喝過了嗎？</p> -->
		                    <p><a class="btn btn-lg btn-primary" href="#" role="button" onclick="changeToHead(${adoptaniPhotoVO.adopt_Ani_Id},${adoptaniPhotoVO.ado_Ani_Pic_No});">設為大頭照</a></p>
		                </div>
		            </div>
		        </div>
		        <%firstTime = ""; %>
		     </c:forEach>

<!-- 	        <div class="item active" > -->
<!-- 	            <img src="https://api.fnkr.net/testimg/2800x700/aaaaaa" alt=""> -->
<!-- 	            <div class="container"> -->
<!-- 	                <div class="carousel-caption"> -->
<!-- 	                    <h1>我是標題喔～自己改文案吧</h1> -->
<!-- 	                    <p>我是內文喔，你可以把字打在這裡呦</p> -->
<!-- 	                    <p><a class="btn btn-lg btn-primary" href="#" role="button">詳細內容</a></p> -->
<!-- 	                </div> -->
<!-- 	        </div> -->
<!-- 	        </div> -->
	    </div>
	    <!-- 上下頁控制區 -->
	    <a class="left carousel-control" href="#carousel-id" data-slide="prev"><span class="glyphicon glyphicon-chevron-left"></span></a>
	    <a class="right carousel-control" href="#carousel-id" data-slide="next"><span class="glyphicon glyphicon-chevron-right"></span></a>
</div>
<%-- 			<c:forEach var="adoptaniPhotoVO" items="${list}" > --%>
				
				
<!-- 				<tr align='center' valign='middle'> -->

<%-- 				<td height=200px width=200px style="table-layout:fixed"><div><img style="table-layout:fixed; max-height:200px; max-width:200px" src="<%=request.getContextPath()%>/DBGifReader_AdoptaniPhoto/DBGifReader_AdoptaniPhoto.do?ado_Ani_Pic_No=${adoptaniPhotoVO.ado_Ani_Pic_No}"></div></td> --%>


   
<!-- 				</tr> -->
<%-- 			</c:forEach> --%>
</table>
<div ><img src="images/plus.png" id="div_right_bottom" onclick="addPhotos()" ></div>
</body>
</html>

