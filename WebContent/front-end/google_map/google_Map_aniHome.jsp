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
<script>
		map.tinyMap('modify',{
			'marker': [	
		<%
		int tem_int = 0;
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
					    ,text: '<div class="bs-calltoaction bs-calltoaction-info" style=" padding: 5px; "> <div class="row" style=" "> <div class="col-md-9" style=" padding: 0; "> <img src="https://secure.gravatar.com/avatar/de9b11d0f9c0569ba917393ed5e5b3ab?s=140&r=g&d=mm" style="width: 50px; height: 50px;"> <b style="border-left: solid #9E9E9E;">.....<%=vo.getAniHome_title()%></b> <b style="border-left: solid #9E9E9E;">.....<%=vo.getAniHome_content()%></b> </div> <div class="col-md-3 cta-button" style=""> <a href="#" class="btn .btn-md btn-block btn-info">詳細資料!</a> </div> </div> </div>'
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
			                'url': 'https://maxcdn.icons8.com/Color/PNG/24/City/dog_park-24.png'
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
					        },
					        // 自訂 mouseover
					        mouseover: {
					            func: function () {
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
</script>
