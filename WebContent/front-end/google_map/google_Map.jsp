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
	
	
	var isautoBoolean =true;
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
	    	
	    	if(isautoBoolean){
	    		isautoBoolean = false;
//	 	    	setTimeout(function(){ updateDisplay2(); return null},20);
		        map.tinyMap('modify', {
		            'marker': [{
		            	id: 'AM_autoLocation'
	            		,'draggable': true
	                    ,'event': {
	                        'dragend': function () {
//	                         	if (map_distance_Circle_boolean) {
		                        	updateDisplay2();
//	 							}
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
		        
		        updateDisplay2();	    		
	    	}
	    	

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
	<%// ==== 鄭群 - ADOPTANI(社區動物) ====%>
	<%@include file="/front-end/google_map/google_Map_strayani.jsp" %>
<%} %>						
<%{ %>		
	<%// ==== 暐翰 - AniHome(動物之家) ====%>
	<%@include file="/front-end/google_map/hibernate_marker/index.jsp" %>			
<%} %>			
<%{ %>		
	<%// ==== 志鈞 - Emg_Help(緊急求救) ====%>
	<%@include file="/front-end/google_map/google_Map_emg_H.jsp" %>			
<%} %>	
<%{ %>		
	<%// ==== 夢塵 - 診所 揪團 ====%>
	<%@include file="/front-end/google_map/google_Map_pet_group.jsp" %>		
	<%@include file="/front-end/google_map/google_Map_vet_hospital.jsp" %>			
<%} %>	

<script>
	AM_markers.forEach(function (marker, key, mapObj) {
		//console.log(marker);
		
		
		if (marker.hasOwnProperty('text_html')) { 
			marker.infoWindow = new google.maps.InfoWindow({
			    content: $("#"+marker.text_html).html()
			  });
	        marker.text = $("#"+marker.text_html).html();
		}
	}); 
</script>

