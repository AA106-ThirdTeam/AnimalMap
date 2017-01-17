<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- 面機算法 -->
    <div id="map-polygon-01"></div>
    <script>
    $("#map-polygon-01").tinyMap( 
		  	{
		        'center': ['24.963848872917676', '121.1986851333304'],
		        'zoom': 14,
		        'marker': [{
		            'addr': ['24.963848872917676', '121.1986851333304'],
		
		            'text': '<iframe width="1000" height="1000" src="/AnimalMap/pet_Group/groupWire.html" frameborder="0" allowfullscreen></iframe>',
		            'newLabel': '可',
		            'newLabelCSS': 'labels test',
		            'icon': {
		                'url': 'https://i.imgur.com/RhTTUS3.png',
		                'scaledSize': [48, 48]
		            },
		            'animation': 'DROP'
		        }],
		        'polygon': [{
		            'coords': [
		                ['24.977969677783978', '121.16358269935427'],
		                ['24.990192524292144', '121.1978331660041'],
		                ['24.968842343373904', '121.24075958128356'],
		                ['24.936676084803928', '121.22562359924291']
		            ],
		            'color': '#000033',
		            'fillcolor': '#0000cc',
		            'width': 1,
		            'text': "hi",
		            'event': function(e) {
		                var s;
		                for (key in e) { // 使用 in 運算子列舉所有成員
		                    s += key + ": " + e[key] + "\n";
		                }
		                console.log('You clicked at: ' + e.latLng.lat() + ', ' + e.latLng.lng());
		            }
		        }]
		    }    		
	    ); 
    
    </script>
