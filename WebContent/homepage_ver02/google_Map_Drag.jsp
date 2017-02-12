<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<button id="google_Map_Drag"> google_Map_Drag </button>

<!-- JS -->
<script>
	//或是利用 get 方法
	var instance = map.tinyMap('get', 'map');
	alert(instance);
	
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
                            alert(this.position.lat() + ', ' + this.position.lng());
                        }
                    }
                	, 'text': '<strong>110台灣台北市信義區松高路68號</strong>'
                }
            ]
        });   		
	});
</script>











