<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 面機算法 -->
<div id="map-polygon-01"></div>
<script>
	$("#map-polygon-01")
		.tinyMap(
			{
				'center' : [ '24.963848872917676', '121.1986851333304' ],
				'zoom' : 14,
				'marker' : [ 
                    {
    					'addr' : [ '24.963848872917676',
    							'121.1986851333304' ],

    					'text' : '<iframe width="1000" height="1000" src="/AnimalMap/pet_Group/groupWire.html" frameborder="0" allowfullscreen></iframe>',
    					'newLabel' : '可',
    					'newLabelCSS' : 'labels test',
    					'icon' : {
    						'url' : 'https://i.imgur.com/RhTTUS3.png',
    						'scaledSize' : [ 48, 48 ]
    					},
    					'animation' : 'DROP',
                        'event': {
                            // created 事件於標記建立成功時執行。
                            'created': function () {
                                console.info('Event binding:')
                                console.info('Marker create finished:');
                                console.log(this);
                            },
                            // Click 事件
                            'click' : function (e) {
                                console.log('緯度: ' + e.latLng.lat() + ', 經度: ' + e.latLng.lng());
                                console.log($("#AM_Login"));
                                $.post("testControl/control.jsp", {
                                        // btnName: e.attr('id') //bad
                                    },
                                    function(data, status) {
                                        console.log(data);
                                        //應該可以直接作成load路徑
                                        $("#AM_Login").load(data, function(responseTxt, statusTxt, xhr) {
                                            if (statusTxt == "success")
                                                console.log("External content loaded successfully!");
                                            if (statusTxt == "error")
                                                console.log("Error: " + xhr.status + ": " + xhr.statusText);
                                        });
                                    }
                                );                                
                            },
                            // Mouseover 事件
                            'mouseover': {
                                'func': function (e) {
                                    console.log('我只能執行一次');
                                },
                                'once': true // 僅執行一次
                            }
                        }                        
				    } 
                ]
			});
</script>
