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
<!-- style -->
	<style>
	#map-marker-01 {
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

	<div id="map-marker-01"></div>
	<script>
		$('#map-marker-01').tinyMap({
				'center' : [ '25.039065815333753', '121.56097412109375' ],
				'zoom' : 14,
				'marker' : [ 
					{
						'addr' : [ '25.039065815333753', '121.56097412109375' ],
						'text' : '<strong><img src="https://i.imgur.com/Qac3iIX.png"/></strong>',
						'newLabel' : '可',
						'newLabelCSS' : 'labels',
						'icon' : {
							'url' : 'https://i.imgur.com/7Bm6WTj.png',
							'scaledSize' : [ 48, 48 ]
						},
						'animation' : 'DROP'
					}
				]
		});
	</script>
