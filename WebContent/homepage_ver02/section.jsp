<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div id="AM_bookmark" class="btn-group-vertical"
	style="z-index: 1; box-shadow: 2px 5px 5px #888889; opacity: 1; position: absolute; top: 0px; left: 0;">
	<button class="btn btn-default" id="AM_Mem" type="button" style="padding: 5px;">會員中心
	</button>
	<button class="btn btn-default" id="AM_Friend" type="button">朋友</button>
	<button class="btn btn-default" id="AM_MapInfo" type="button">地圖資訊</button>
	<button class="btn btn-default" type="button">參加的活動</button>
	<button class="btn btn-default" type="button">店家管理</button>
</div>
<div class="btn-group btn-group-sm" role="group" id="AM_Map_Button"
	style="padding-top: 10px; padding-right: 30px; position: absolute; top: 0px; right: 0; z-index: 1;">
	<a class="btn btn-default action-button" role="button" href="#"
		style="">動物圖鑑 </a><a class="btn btn-default action-button"
		role="button" href="#">發文 </a><a class="btn btn-default action-button"
		role="button" href="#">商城 </a> <a
		class="btn btn-default action-button" role="button" href="#">討論版 
	</a>
</div>
<div id="AM_google_Map">
	<!-- 				<iframe> -->
	<%@include file="/homepage_ver02/google_Map.jsp"%>
	<!-- 				</iframe> -->
</div>


<script>
$(document).ready(function(){
    $("button").click(function(){
        $.post("testControl/control.jsp",
        {
        	btnName: $(this).attr('id')//bad
        },
        function(data,status){
 			//應該可以直接作成load路徑
   	        $("#AM_aside").load(data, function(responseTxt, statusTxt, xhr){
   	            if(statusTxt == "success")
   	                console.log("External content loaded successfully!");
   	            if(statusTxt == "error")
   	                console.log("Error: " + xhr.status + ": " + xhr.statusText);
   	        });       	
        });
    });    
});
</script>