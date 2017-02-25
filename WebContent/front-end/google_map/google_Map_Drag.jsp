<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>



<!-- JS -->
<script>

// 	alert(native_map);
	
	
	
	
	function addObjectIntoMap(i){	
		//用陣列儲存各個新增頁面，再用傳入的i來綁定。
		var object = ['/AnimalMap/front-end/adoptani/addAdoptani_fromMap.jsp?',
					  '/AnimalMap/front-end/adoptani/addAdoptani_fromMap.jsp?',
					  "Blue"];
		if(AM_markers.get("AM_add_new_maker")!=null){
			//AM_markers.get("AM_add_new_maker").tinyMap('destroy');;
			//AM_markers.get("AM_add_new_maker") = null;
			
			AM_markers.get("AM_add_new_maker").setMap(native_map);
		}
		
		map.tinyMap('modify', {
        	'marker': [
                {
                    'addr': [
                    	native_map.getCenter().lat(),
                    	native_map.getCenter().lng()
                    ],
                    'id':'AM_add_new_maker',
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
							AM_markers.get("AM_add_new_maker").setMap(null);
							//AM_markers.get("AM_add_new_maker") = null;
                        }
                    }
                	, 'text': "<strong>110台灣台北市信義區松高路68號</strong><button onclick=''>放棄新增</button>"
                }
            ]
        });   
		
	};
	
	
	
	$("#google_Map_Drag").click(function(){
        map.tinyMap('modify', {
        	'marker': [
                {
                    'addr': [
                    	native_map.getCenter().lat(),
                    	native_map.getCenter().lng()
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











