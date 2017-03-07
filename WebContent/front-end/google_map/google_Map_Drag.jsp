<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>



<!-- JS -->
<script>

// 	alert(native_map);
	
	
	
	
	function addObjectIntoMap(i){	
		/**		1.用object陣列儲存各個新增頁面，再用傳入的i來綁定。
		*		2.lat_parameter_name[]存緯度參數名稱。
		*		3.lat_parameter_name[]存經度參數名稱。
		*		4.[0.送養動物、]
		*
		**/
		var object = ['/AnimalMap/front-end/adoptani/addAdoptani_fromMap.jsp?',
					  '/AnimalMap/front-end/strayani/addStrayani_fromMap.jsp?',
					  '各功能新增頁面',
					  '各功能新增頁面',
					  '/AnimalMap/front-end/grp/addGrp_FrontEnd.jsp?',
					  '/AnimalMap/front-end/hos/addHos_FrontEnd.jsp?',
					  '/AnimalMap/front-end/emg_H/addEmg_HforView.jsp?',
					  '各功能新增頁面'];
		var lat_parameter_name = ['Adopt_Ani_FinLat=',
								  'Stray_Ani_FinLat=',
								  '=',
								  '=',
								  'grp_Lat=',
								  'hos_Lat=',
								  'emg_H_Lat=',
								  '='];
		
		var lon_parameter_name = ['Adopt_Ani_FinLon=',
								  'Stray_Ani_FinLon=',
								  '=',
								  '=',
								  'grp_Long=',
								  'hos_Long=',
								  'emg_H_Lon=',
								  '='];
		
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
                        	var lat=lat_parameter_name[i]+this.position.lat();
                        	var lon=lon_parameter_name[i]+this.position.lng();
                    		var src=object[i]+lat+'&'+lon; 
                    		$('#details_page_iframe').attr('src',src);
                    		
                    		var obj = this;
                    		this.setMap(null);
                    		map.tinyMap('modify',{
                    		    'marker': [
                    		        {
                    		            'addr': obj.getPosition(),
                    		            // 自訂外部圖示
                    		            'icon': {
                    		                'url': '<%=request.getContextPath()%>/front-end/homepage/imgs/map_adoptani_icon2.gif',
                    		                'scaledSize': [48, 48]
                    		            },
                    		            // 動畫效果
                    		            'animation': 'DROP'
                    		        }
                    		    ]
                    		});                    		
                        }
                    }
                }
            ]
        });   
		
	};
	
	
	
	//google_Map_Drag按鈕已隱藏。
	
// 	$("#google_Map_Drag").click(function(){
//         map.tinyMap('modify', {
//         	'marker': [
//                 {
//                     'addr': [
//                     	native_map.getCenter().lat(),
//                     	native_map.getCenter().lng()
//                     ],
                    
//                     'draggable': true,
//                     'event': {
//                         'dragend': function () {
//                         	show_details_page();
//                         	var lat="Adopt_Ani_FinLat="+this.position.lat();
//                         	var lon="Adopt_Ani_FinLon="+this.position.lng();
//                     		var src='/AnimalMap/front-end/adoptani/addAdoptani_fromMap.jsp?'+lat+'&'+lon; 
//                     		console.log(src);
//                     		$('#details_page_iframe').attr('src',src);
// //                             alert(this.position.lat() + ', ' + this.position.lng());
//                         }
//                     }
//                 	, 'text': '<strong>110台灣台北市信義區松高路68號</strong>'
//                 }
//             ]
//         });   		
// 	});
	
	
	
</script>











