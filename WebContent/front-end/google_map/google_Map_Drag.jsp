<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<button id="google_Map_Drag"> google_Map_Drag </button>

<!-- JS -->
<script>
	//或是利用 get 方法
	var instance = map.tinyMap('get', 'map');
// 	alert(instance);
	
	function addObjectIntoMap(i){
		
		var object = ['/AnimalMap/front-end/adoptani/addAdoptani_fromMap.jsp?',
					  '/AnimalMap/front-end/adoptani/addAdoptani_fromMap.jsp?',
					  "Blue"];
		
		map.tinyMap('modify', {
        	'marker': [
                {
                    'addr': [
                    	instance.getCenter().lat(),
                    	instance.getCenter().lng()
                    ],
                    'id':'markerrrrrrr',
                    'draggable': true,
                    'event': {
                        'dragend': function () {
                        	show_details_page();
                        	var lat="Adopt_Ani_FinLat="+this.position.lat();
                        	var lon="Adopt_Ani_FinLon="+this.position.lng();
                    		var src=object[i]+lat+'&'+lon; 
                    		console.log(src);
                    		$('#details_page_iframe').attr('src',src);
//                             alert(this.position.lat() + ', ' + this.position.lng());
                        }
                    }
                	, 'text': "<strong>110台灣台北市信義區松高路68號</strong><button onclick='deleteMarker()'>放棄新增</button>"
                }
            ]
        });   
		
	};
	
	
	
	$("#google_Map_Drag").click(function(){
        map.tinyMap('modify', {
        	'marker': [
                {
                    'addr': [
                    	instance.getCenter().lat(),
                    	instance.getCenter().lng()
                    ],
                    
                    'draggable': true,
                    'event': {
                        'dragend': function () {
                        	show_details_page();
                        	var lat="Adopt_Ani_FinLat="+this.position.lat();
                        	var lon="Adopt_Ani_FinLon="+this.position.lng();
                    		var src='/AnimalMap/front-end/adoptani/addAdoptani_fromMap.jsp?'+lat+'&'+lon; 
                    		console.log(src);
                    		$('#details_page_iframe').attr('src',src);
//                             alert(this.position.lat() + ', ' + this.position.lng());
                        }
                    }
                	, 'text': '<strong>110台灣台北市信義區松高路68號</strong>'
                }
            ]
        });   		
	});
	
	
	
</script>











