<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="heibernate_com.anihome.model.*"%>	
<%
    AniHomeService anihomeSvc = new AniHomeService();
    List<AniHomeVO> list = anihomeSvc.getAll();
    pageContext.setAttribute("list",list);
%>

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
		,'marker': [	
	        {
	            'addr': ['25.039065815333753', '121.56097412109375'],
	            'text': '<strong>110台灣台北市信義區逸仙路288號</strong>',
	            'newLabel': '文字標籤',
	            'newLabelCSS': 'labels'
	            // 自訂外部圖示
	            ,'icon': {
	                'url': '/images/big.png',
	                'scaledSize': [48, 48]
	            }
	        },			
<%
	for(AniHomeVO vo:list){
%>	
			,{'addr': ['<%=vo.getAniHome_lon()%>', '<%=vo.getAniHome_lat()%>']
				, 'text': '標題 :<%=vo.getAniHome_title()%> <br>內容 : <%=vo.getAniHome_content()%>'	
	            ,'labelContent': '<strong>Hello World</strong><div><img src="https://i.imgur.com/NfpZ9TX.png" alt="" /></div>',
			},    
<%}%>

		]/* marker結尾  */
		
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



<jsp:include page="/front-end/google_map/google_Map_Drag.jsp"/>







