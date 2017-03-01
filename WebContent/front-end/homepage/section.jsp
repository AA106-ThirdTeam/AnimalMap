<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <div id="AM_bookmark" class="btn-group-vertical hidden-xs hidden-sm">
		<%@include file="/front-end/homepage/aside_bookmark.jsp" %>
	</div>
    <div id="AM_map_menu" class="btn-group btn-group-sm" role="group">
    	<a type="button" class="btn btn-warning" href="<%=request.getContextPath()%>/front-end/shop/index.htm">商城</a>
		<button type="button" id="AM_MapInfo" class="btn btn-success">動物圖鑑</button>
		<a type="button" class="btn btn-primary" href="<%=request.getContextPath()%>/front-end/aboutUs/index.html">討論版</a>
<!-- 		<button type="button" id="AM_Friend" class="btn btn-primary">討論版</button> -->

        <a href="#" class="btn btn-danger btn-lg" onclick="switchAddBar();">
          <span class="glyphicon glyphicon-ok-circle"></span> 發文
          <div class="container" id="addbar"style="background-color: rgba(38, 35, 35, 0); height:480px; width:40px; position:relative; padding-top:0px; padding-left:0px;padding-right:0px" hidden>
          	<div class="row"><img id="" src="<%=request.getContextPath()%>/front-end/homepage/imgs/map_adoptani_icon2.gif" width="50" height="50" padding-left="0" onclick="addObjectIntoMap(0)"> </div>
          	<div class="row"><img id="" src="https://maxcdn.icons8.com/Color/PNG/24/Animals/dog_house-24.png" width="50" height="50" padding-left="0" onclick="addObjectIntoMap(1)"> </div>
          	<div class="row"><img id="" src="https://maxcdn.icons8.com/Color/PNG/24/City/dog_park-24.png" width="50" height="50" padding-left="0" onclick="addObjectIntoMap(2)"> </div>
          	<div class="row"><img id="" src="<%=request.getContextPath()%>/front-end/homepage/imgs/map_adoptani_icon2.gif" width="60" height="60" padding-left="0" onclick="addObjectIntoMap(3)"> </div>
          	<div class="row"><img id="" src="<%=request.getContextPath()%>/front-end/homepage/imgs/map_adoptani_icon2.gif" width="60" height="60" padding-left="0" onclick="addObjectIntoMap(4)"> </div>
          	<div class="row"><img id="" src="<%=request.getContextPath()%>/front-end/homepage/imgs/map_adoptani_icon2.gif" width="60" height="60" padding-left="0" onclick="addObjectIntoMap(5)"> </div>
          	<div class="row"><img id="" src="<%=request.getContextPath()%>/front-end/homepage/imgs/map_adoptani_icon2.gif" width="60" height="60" padding-left="0" onclick="addObjectIntoMap(6)"> </div>
          	<div class="row"><img id="" src="<%=request.getContextPath()%>/front-end/homepage/imgs/map_adoptani_icon2.gif" width="60" height="60" padding-left="0" onclick="addObjectIntoMap(7)"> </div>
          </div>
        </a>
        	
    </div>
    
    <div id="AM_issue" class="btn-group-vertical btn-group-sm">
    	<div style="height:40px;"></div>
    </div>
    <div id="AM_google_Map">
        <%@include file="/front-end/google_map/google_Map.jsp"%>
    </div>
    <script>
    $(document).ready(function() {
        $(".am_bookmark").click(function() {
            $.post("testControl/control.jsp", {
                    btnName: $(this).attr('id') //bad
                },
                function(data, status) {
                    //應該可以直接作成load路徑
                    $("#AM_aside").load(data, function(responseTxt, statusTxt, xhr) {
                        if (statusTxt == "success")
                            console.log("External content loaded successfully!");
                        if (statusTxt == "error")
                            console.log("Error: " + xhr.status + ": " + xhr.statusText);
                    });
                });
        });
    });
    
    
    function switchAddBar(){
    	$("#addbar").toggle(1000);
    };
    

    
    </script>
