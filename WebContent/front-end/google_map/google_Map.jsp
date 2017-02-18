<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- HTML -->
<div id="map" class="map"></div>
<button type="button" class="zoom" data-zoom="in">Zoom In</button>
<button type="button" class="zoom" data-zoom="out">Zoom Out</button>

<!-- CSS -->
<style>
.map {
	width: 100vw;
	height: 88vh;
}
</style>

<!-- JS -->
<script>
	//****************************【共同功能】*************************
	var map = $('#map'), zoom = 13;
	
	//==== Zoom功能 ====
	$(document).on(
			'click',
			'.zoom',
			function(e) {

				var btn = $(this), type = btn.data('zoom'), m = map.tinyMap(
						'get', 'map');

				console.dir(type);

				switch (type) {
				case 'in':
					m.setZoom(zoom += 1);
					break;
				case 'out':
					m.setZoom(zoom -= 1);
					break;
				}
			});
	
	//==== 地圖初始化 ====
	map.tinyMap({
	    'center': ['25.034516521123315','121.56496524810791'],
	    'zoom': zoom,
	    // 啟用 MarkerWithLabel
	    'markerWithLabel': true,
	    'marker': [
	        {
	            'addr': ['25.034516521123315','121.56496524810791'],
	            'labelContent': '<strong>Hello World</strong><div><img src="/images/_111.jpg" alt="" /></div>',
	            'labelClass'  : 'box',
	            'icon': {
	                'path': 'M 0 0'
	            }
	        }
	    ]
	});	
</script>
<!-- ****************************【共同功能】************************* -->
<%// ==== 拖拉功能 ====%>
<%-- <%@include file="/front-end/google_map/google_Map_Drag.jsp" %> --%>
<!-- ****************************【各自功能】************************* -->
<%// ==== 暐翰 - AniHome(動物之家) ====%>
	<%@include file="/front-end/google_map/google_Map_aniHome.jsp" %>
<%// ==== 暐翰 - park(公園) ====%>
<%-- 	<%@include file="/front-end/google_map/google_Map_park.jsp" %> --%>








