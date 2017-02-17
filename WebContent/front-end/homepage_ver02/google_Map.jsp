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
	var map = $('#map'), zoom = 13;

	map.tinyMap({
	    'mapTypeControlOptions': {
	        'style'    : 'google.maps.MapTypeControlStyle.DROPDOWN_MENU',
	        'position' : 'google.maps.ControlPosition.TOP_LEFT',
	    }		
		,'center': ['25.039065815333753', '121.56097412109375']
		,'zoom' : zoom
	});

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
</script>



<jsp:include page="/front-end/homepage_ver02/google_Map_Drag.jsp"/>







