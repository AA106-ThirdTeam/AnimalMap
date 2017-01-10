<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
    
    
<!-- Myself -->
	<script src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
	<script src="assets/js/jquery.min.js"></script>
	<script src="assets/bootstrap/js/bootstrap.min.js"></script>
	<script src="assets/js/bs-animation.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/aos/2.1.1/aos.js"></script>
	<script src="assets/js/jquery.tinyMap.js"></script>
	<script src="assets/js/jquery.tinyMap.min.js"></script>
		<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAU3wRqgGlnt0GWupqnCl1k06ROlNGazQY&signed_in=true&callback=initMap"></script>
	<!-- 		<script -->
	<!-- 		  src="https://maps.googleapis.com/maps/api/js?callback=initMap&signed_in=true&key=AIzaSyAU3wRqgGlnt0GWupqnCl1k06ROlNGazQY" async defer> -->
	<!-- 		</script>	  -->
<!-- 	<script -->
<!-- 	  src="https://maps.googleapis.com/maps/api/js?callback=initMap&signed_in=true&key=AIzaSyAU3wRqgGlnt0GWupqnCl1k06ROlNGazQY" async defer> -->
<!-- 	</script>	 -->
<!-- style -->
	<style>
	#map-marker-01 {
		width: 1043px;
		height: 622px;
	}
	#map-polygon-01 {
		width: 1043px;
		height: 622px;
	}
	.labels {
		background-color: rgba(0, 0, 0, 0.5);
		border-radius: 4px;
		color: white;
		padding: 4px
	}
	</style>

	<!-- 面機算法 -->
	<div id="map-polygon-01"></div>
	<script>
		$('#map-polygon-01').tinyMap({
		    'center': ['25.05425179688806', '121.52795111083981'],
		    'zoom': 14,
			'marker' : [ 
				{
					'addr' : [ '25.058466466042745', '121.52703774027759' ],
				
					'text' : '<iframe src="index.jsp" style="height:1200px; wight:700px;"></iframe>',
					'newLabel' : '可',
					'newLabelCSS' : 'labels test',
					'icon' : {
						'url' : 'https://i.imgur.com/7Bm6WTj.png',
						'scaledSize' : [ 48, 48 ]
					},
					'animation' : 'DROP'
				}
			],		    
		    'polygon': [
		        {
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
		            'text' : "hi",
		            'event': function (e) {
		            	var s;
						for( key in e ) { // 使用 in 運算子列舉所有成員
							s += key + ": " + e[key] + "\n";
						}
		                console.log('You clicked at: ' + e.latLng.lat() + ', ' + e.latLng.lng());
		            }
		        }
		    ]
		});	
	</script>
	
	<!-- 0110 tooltip -->
	<div class="container">
	  <h3>Tooltip Options</h3>
	  <p>The <strong>html</strong> option specifies whether to accept HTML tags in the tooltip.</p>
	  <button class="btn btn-success btn-md test">Hover over me</button>
	</div>
	
	<script>
		$(document).ready(function(){
		    $('.test').tooltip({title: "<img src=\"https://i.imgur.com/qztHSNn.png\" height=\"40px\" width=\"40px\">", html: true, placement: "right"}); 
		});
	</script>
		
