<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>    
<%@ page import="heibernate_com.anihome.model.*"%>	
<%
    AniHomeService anihomeSvc = new AniHomeService();
    List<AniHomeVO> list_anihome = anihomeSvc.getAll();
    pageContext.setAttribute("list_anihome",list_anihome);
    int anihome_map_icon_size = 24;
%>
<script src="http://googlemapapitutorial.com/js/infobubble.js"></script>
<!-- <script src="http://maps.googleapis.com/maps/api/js?sensor=false&extension=.js"></script>	 -->

<%
int tem_int = 0;
for(AniHomeVO vo:list_anihome){
	tem_int++;
%>	
<div id=ex_animal_map_<%=tem_int%> hidden>
	<img src="<%=vo.getAniHome_pic()%>" alt="Smiley face" height="42" width="42">
   	<button onclick="show_aniHome_details_page(this.value)"
   		class="btn .btn-md btn-block btn-info" >
   		詳細資料!
 	</button>
</div>
<%} %>

<script>
var myLatlng = new google.maps.LatLng(37.286172, -121.80929);
var marker = new google.maps.Marker({
    position: myLatlng,
    map: map,
    title: 'A Customized InfoWindow Marker'
});

var  infoBubble = new InfoBubble({
  maxWidth: 300
});

var div = document.createElement('DIV');
div.innerHTML = 'Hello';

infoBubble.addTab('Tab 1', div);
infoBubble.addTab('Tab 2', "<B>This is tab 2</B>");

google.maps.event.addListener(marker, 'click', function() {
  if (!infoBubble.isOpen()) {
    infoBubble.open(map, marker);
  }
});


		//======================
		<%
		tem_int = 0;
		for(AniHomeVO vo:list_anihome){
			tem_int++;
		%>			
			var infowindow_aniHome_<%=tem_int%> = null;
	    	//$("#div_aniHome_<%=tem_int%>").text($("#ex_animal_map_<%=tem_int%>").html());
	    	//$("#div_aniHome_<%=tem_int%>").text("dsjfjosdjfpsdjpfjdspfjpsdjp");
	    	//$("body").text($("#ex_animal_map_<%=tem_int%>").html());
	    	//console.log($("#ex_animal_map_<%=tem_int%>").html())
	    	//console.log($("#div_aniHome_<%=tem_int%>_<%=tem_int%>").text())
	    	//console.log("div_aniHome_<%=tem_int%>_<%=tem_int%>")
    	<%}%>	
	


		map.tinyMap('modify',{
			'marker': [	
		<%
		tem_int = 0;
		for(AniHomeVO vo:list_anihome){
			if(tem_int>0){
				out.print(",");
			}
			tem_int++;
		%>	
					,{
// 					    // 標記 ID
// 					    // Custom ID
					    id: 'marker_anihome_<%=tem_int%>'
// 					    // 標記的位置
// 					    // Marker location
					    ,addr: ['<%=vo.getAniHome_lon()%>', '<%=vo.getAniHome_lat()%>']
// 					    // 標記抬頭文字（markerControl 使用此屬性建立清單）
// 					    // Marker title (for `markerControl` to create list)
// 					    title: 'string',
// 					    // 點擊標記時顯示於資訊視窗的文字（支援 HTML）
// 					    // Content of infoWindow
					    ,text: '<div id="div_aniHome_<%=tem_int%>_<%=tem_int%>">xcvxcvxcv</div>'
// 					    // 標籤文字層，顯示於標記底下
// 					    // Text label of the Marker which will display below.
					    ,newLabel: 'string'
// 					    // 標籤文字層套用的 CSS 樣式名稱
// 					    // CSS class name of this text label.
// 					    newLabelCSS: 'string',
// 					    // 是否顯示 Label（預設 true）
// 					    // Show label or not. (Default to `true`)
					   	,showLabel: true
					    // 使用 modify 方法時，若標記 id 不存在，是否強制新增至地圖
					    // Force create the marker if custom id was not found.
					    ,forceInsert : true
// 					    // 標記圖示，可使用 string 指定圖示網址
// 					    // Icon URL of Marker.
// 					    icon: '圖示網址'
// 					    // 或是 Object 定義更詳細的圖示
			            ,'icon': {
			            	 // 圖示網址
			                'url': 'https://maxcdn.icons8.com/Color/PNG/24/Animals/dog_house-24.png'
		                	// 縮放尺寸
			                ,'scaledSize': [<%=anihome_map_icon_size%>, <%=anihome_map_icon_size%>]
			            }
// 					    // 是否將此標記加入叢集（markerCluster 必須不為 null 或 false）
// 					    // Append this marker to cluster. `markerCluster` must not be `null` or `false`.
// 					    cluster: true|false,
// 					    // 設定 infoWindow
					    ,infoWindowOptions: {
					        disableAutoPan: true
					        ,maxWidth: 200
// 					        ,pixelOffset: [X, Y],
// 					        zIndex: number
					    }
// 					    // 自訂任意名稱屬性
// 					    // You can create own properties. Just give it a name/value.
					    ,class: 'smile'
// 					    // 定義 Click 事件
// 					    event       : function () {
// 					        console.log(this);
// 					    },
					    // 或是定義多個事件
					    ,event       : {
					        // 自訂 Click
					        mousedown: function () {
					        	//console.log($("#div_aniHome_<%=tem_int%>_<%=tem_int%>").text())
					        },
					        // 自訂 mouseover
					        mouseover: function () {
					        	//console.log($("#div_aniHome_<%=tem_int%>_<%=tem_int%>").text())
					        },
					        'click': {
					            func: function () {
					            	if(infowindow_aniHome_<%=tem_int%>==null){
										console.log($("#ex_animal_map_<%=tem_int%>").html());					            		
					            		infowindow_aniHome_<%=tem_int%> = new google.maps.InfoWindow({
							                content:$("#ex_animal_map_<%=tem_int%>").html()
						              	});					            	
					            	} 
					            	infowindow_aniHome_<%=tem_int%>.open(map,this);
					            }
					        },	
					        mouseout: {
					            func: function () {
					            	if(infowindow_aniHome_<%=tem_int%>!=null){
					            		//infowindow_aniHome_<%=tem_int%>.close(map,this);
					            	}
// 						            var infowindow = new google.maps.InfoWindow({
// 						                content:"Hello World!"
// 					              	});					            	
// 					            	infowindow.open(map,this);
// 					                console.log('我只能執行一次 Run Once!');
					            }
					        }	
					    }
					    // 啟用 MarkerWithLabel
// 			            ,'labelContent': '<strong>Hello World</strong><div><img src="/images/_111.jpg" alt="" /></div>'
// 			            ,'labelClass'  : 'box'
// 			            ,'icon': {
// 			                'path': 'M 0 0'
// 			            }					    
					}		
		<%}%>
			]/* marker結尾  */
		});
		setTimeout(function(){ console.log($("#div_aniHome_<%=tem_int%>_<%=tem_int%>").text()); }, 3000);
</script>
<script type="text/javascript">
    function show_aniHome_details_page(argument) {
		var parameter_Id = argument[0];
		var path_parameter = 'action=getOne_For_Display&adopt_Ani_Id=' + parameter_Id;
		var src='/AnimalMap/front-end/adoptani/adoptani.do?'+path_parameter 
		$('#details_page_iframe').attr('src',src);        	
        $("#details_page").show();
    }        
</script>



