<%@page import="heibernate_com.anihome_photos.model.*"%>
<%@page import="heibernate_com.anihome.model.*"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%
	AniHomeDAO anihomeDAO = new AniHomeDAO();
    String tem_pk = (String)request.getParameter("aniHome_Id");
    AniHomeVO anihomeVO = anihomeDAO.findByPrimaryKey(tem_pk);
    Set<AniHome_PhotosVO> set = anihomeVO.getAniHome_Photoss();	
    boolean isUser = true;
	boolean isLogin = false;
	// 【從 session 判斷此user是否登入過】
	heibernate_com.mem.model.MemVO account = (heibernate_com.mem.model.MemVO)session.getAttribute("account");
	try{
		if (account != null ) {
			isLogin = true;
		}    
		if(anihomeVO.getMemVO().getMem_Id().equals(account.getMem_Id()) && isLogin){
			isUser = true;
		}else{
			isUser = false;
		}  
	}catch(Exception e){
		isUser = false;
		System.err.println(e.getMessage());
	}		  
%>
<html>
<head>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
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
</head>
<body bgcolor='white'>
	<div id="carousel-id" class="carousel slide" data-ride="carousel">
	    <!-- 幻燈片小圓點區 -->
        <ol class="carousel-indicators">
            <%for(int i=0 ; i<=set.size();i++){ 
                if(i == set.size()){%>
                    <li data-target="#carousel-id" data-slide-to="<%=i %>" class="active"></li>
                <%}else{ %>
                    <li data-target="#carousel-id" data-slide-to="<%=i %>" class=""></li>
                <%} %>
            <%} %>
        </ol>
        <%String firstTime = "active"; %>
        <!-- 幻燈片主圖區 -->
        <div class="carousel-inner " style="height: 580px;">
            <%for(AniHome_PhotosVO vo :set ) {%>
                <div class="item <%= firstTime%>">
   		            <img src=
                    "
                    <%=
                    	vo
                    	.getAniHome_Photos_pic()
                    %>
                    " 
                    alt="" style="
					    padding-top: 20%;
					    width: 100%;
					    height: 80%;
					">
					<%if(isUser){ %>
                    <div class="container">
                        <div class="carousel-caption">
                            <p><a class="btn btn-lg btn-primary"  padding-up="100" href="#" role="button" 
                            onclick="changeToHead(
                    <%=
                    	tem_pk
                    %>
                            )">設為大頭照</a></p>
                        </div>
                    </div>
                    <%} %>
                </div>
                <%firstTime = ""; %>
            <%} %>
        </div>
        <!-- 上下頁控制區 -->
        <a class="left carousel-control" href="#carousel-id" role="button"  data-slide="prev">
        	<span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
        	<span class="sr-only">Previous</span>
        </a>
        <a class="right carousel-control" href="#carousel-id" role="button"  data-slide="next">
        	<span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
        	<span class="sr-only">Next</span>
        </a>
	</div>
	<%if(isUser){ %>
		<div ><img src="https://i.imgur.com/BiVkd9n.png" id="div_right_bottom" onclick="addPhotos()" ></div>
	<%} %>
</body>
</html>
