<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- HTML -->
<div id="map" class="map"></div>
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
	var map = $('#map'), zoom = 15;
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
	
	// 執行 tinyMap 前可使用 $.tinyMapConfigure 進行 API 的設定。
	$.fn.tinyMapConfigure({
	    // Google Maps API URL
	    'api': 'https://maps.googleapis.com/maps/api/js?key=AIzaSyAU3wRqgGlnt0GWupqnCl1k06ROlNGazQY&signed_in=true&callback=initMap',
	    // Google Maps API Version
	    'v': '3.21',
	    // Google Maps API Key，預設 null
	    'key': 'Google Maps API KEY',
	    // 使用的地圖語言
	    'language': 'zh‐TW',
	    // 載入的函式庫名稱，預設 null
	    'libraries': null,
	    // 使用個人化的地圖，預設 false
	    'signed_in': false,
	    // MarkerClustererPlus.js 路徑
	    // 預設 'https://cdn.essoduke.org/js/tinyMap/markerclusterer.js'
	    // 建議下載至自有主機，避免讀取延遲造成無法使用。
	    'clusterer': 'https://cdn.essoduke.org/js/tinyMap/markerclusterer.js',
	    // MarkerWithLabel.js 路徑
	    // 預設 'https://cdn.essoduke.org/js/tinyMap/markerwithlabel.js'
	    // 建議下載至自有主機，避免讀取延遲造成無法使用。
	    'withLabel': 'https://cdn.essoduke.org/js/tinyMap/markerwithlabel.js'
	});	
	
	
	//==== 地圖初始化 ====
	map.tinyMap({
	    'center': ['25.034516521123315','121.56496524810791']
		// 啟用 MarkerWithLabel
		//,'markerWithLabel': true	
	    ,'zoom': zoom
	    // 啟用 MarkerWithLabel
	    ,'markerWithLabel': true
	    //,'markerCluster': true
// 	    , markerCluster: {
// 	        gridSize: (22),
// 	        maxZoom: (22),
// 	        zoomOnClick: (true),
// 	        averageCenter: (true),
// 	        minimumClusterSize: (22),
// 	        styles: map {
// 	            url: (string)
// 	            height: (number)
// 	            width: (number)
// 	            anchor: (Array)
// 	            textColor: (string)
// 	            textSize: (number)
// 	            backgroundPosition: (string)
// 	        }
// 	    }	    
	    ,'autoLocation': function (loc) {
	        map.tinyMap('modify', {
	            'marker': [{
	            	id: 'AM_autoLocation'
	                ,'addr': [
	                    loc.coords.latitude,
	                    loc.coords.longitude
	                ]
		            ,'icon': {
		            	 // 圖示網址
		                'url': 
		                	'https://maxcdn.icons8.com/Color/PNG/96/Maps/marker-96.png'
	               	// 縮放尺寸
		                ,'scaledSize': [64, 64]
		            }
	            }]
	        });
	    }	    
	    
	    
// 	    ,'event': {
//             // created 事件於標記建立成功時執行。
//             'created': function () {
//                 console.info('Event binding:')
//                 console.info('Marker create finished:');
//                 console.log(this);
//             },
//             // Click 事件
//             'click' : function (e) {
//                 alert('緯度: ' + e.latLng.lat() + ', 經度: ' + e.latLng.lng());
//             },
//             // Mouseover 事件
//             'mouseover': {
//                 'func': function (e) {
//                     alert('我只能執行一次');
//                 },
//                 'once': true // 僅執行一次
//             }
//         }
	});	
	
	
	//或是利用 get 方法		
	var native_map = map.tinyMap('get', 'map');	
</script>
<!-- ****************************【共同功能】************************* -->
<%// ==== 拖拉功能 ====%>
<%@include file="/front-end/google_map/google_Map_Drag.jsp" %> 
<!-- ****************************【各自功能】************************* -->
<%{ %>			
	<%// ==== 鄭群 - ADOPTANI(送養動物) ====%>
	<%@include file="/front-end/google_map/google_Map_adoptani.jsp" %>
<%} %>							
<%{ %>		
	<%// ==== 暐翰 - AniHome(動物之家) ====%>
	<%@include file="/front-end/google_map/google_Map_aniHome.jsp" %>			
<%} %>			
<%{ %>		
	<%// ==== 暐翰 - Park(公園) ====%>
	<%@include file="/front-end/google_map/google_Map_park.jsp" %>			
<%} %>			
<%{ %>		
	<%// ==== 暐翰 - Adp(領養活動) ====%>
	<%@include file="/front-end/google_map/google_Map_adp.jsp" %>			
<%} %>			
