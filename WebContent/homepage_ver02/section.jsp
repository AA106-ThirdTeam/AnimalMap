<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <div id="AM_bookmark" class="btn-group-vertical hidden-xs hidden-sm">
		<%@include file="/homepage_ver02/aside_bookmark.jsp" %>
	</div>
    <div id="AM_map_menu" class="btn-group btn-group-sm" role="group">
    	<a type="button" class="btn btn-warning" href="<%=request.getContextPath()%>/shop/index.htm">商城</a>
		<button type="button" id="AM_MapInfo" class="btn btn-success">動物圖鑑</button>
		<a type="button" class="btn btn-primary" href="<%=request.getContextPath()%>/aboutUs/index.html">討論版</a>
<!-- 		<button type="button" id="AM_Friend" class="btn btn-primary">討論版</button> -->

        <a href="#" class="btn btn-danger btn-lg">
          <span class="glyphicon glyphicon-ok-circle"></span> 發文
        </a>	
    </div>
    <div id="AM_issue" class="btn-group-vertical btn-group-sm">
    	<div style="height:40px;"></div>
    </div>
    <div id="AM_google_Map">
        <%@include file="/homepage_ver02/google_Map.jsp"%>
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
    </script>
