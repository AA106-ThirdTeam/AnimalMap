<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- 面機算法 -->
    <div id="map-polygon-01"></div>
    <script>
    $("#map-polygon-01").tinyMap( 
		  	{
		        'center': ['25.05425179688806', '121.52795111083981'],
		        'zoom': 14,
		        'marker': [{
		            'addr': ['25.058466466042745', '121.52703774027759'],
		
		            'text': '<img src=\"https://i.imgur.com/KlnsIgi.png\"></img>',
		            'newLabel': '可',
		            'newLabelCSS': 'labels test',
		            'icon': {
		                'url': 'https://i.imgur.com/7Bm6WTj.png',
		                'scaledSize': [48, 48]
		            },
		            'animation': 'DROP'
		        }],
		        'polygon': [{
		            'coords': [
		                ['25.05922799282222', '121.52348791503903'],
		                ['25.05580687982226', '121.52331625366207'],
		                ['25.05425179688806', '121.52795111083981'],
		                ['25.05751744826025', '121.53378759765621'],
		                ['25.064048489938642', '121.52915274047848'],
		                ['25.05922799282222', '121.52348791503903']
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
