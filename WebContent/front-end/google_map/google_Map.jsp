<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="util.compareVO.CompareVO"%>
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
	    //'center': ['25.034516521123315','121.56496524810791']
		// 啟用 MarkerWithLabel
		'markerWithLabel': true	
	    ,'zoom': zoom
	    // 啟用 MarkerWithLabel
	    ,'markerWithLabel': true
	    , disableDefaultUI: true
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
	    ,'autoLocation': function (loc) {
	        map.tinyMap('modify', {
	            'marker': [{
	            	id: 'AM_autoLocation'
            		,'draggable': true
                    ,'event': {
                        'dragend': function () {
                        	if (map_distance_Circle_boolean) {
                        		updateDisplay2();
							}
                        }
                    }            		
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
	});	
	//==== 取得原生MAP物件 ====	
	var native_map = map.tinyMap('get', 'map');	
	//==== 解決中心點偏移問題 ====
  	var overlayWidth = $('#AM_aside').outerWidth()/2;
  	var overlayHeight = ($('#AM_nav').outerHeight()/2) + ($('#AM_footer').outerHeight()/2);
  	native_map.panBy(overlayWidth, overlayHeight);
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
<%{ %>		
	<%// ==== Emg_Help(緊急求救) ====%>
	<%@include file="/front-end/google_map/google_Map_emg_Help.jsp" %>			
<%} %>	
<script>
	AM_markers.forEach(function (marker, key, mapObj) {
		if (marker.hasOwnProperty('text_html')) { 
			marker.infoWindow = new google.maps.InfoWindow({
			    content: $("#"+marker.text_html).html()
			  });
	        marker.text = $("#"+marker.text_html).html();
		}
	}); 
</script>
