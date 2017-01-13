var map = $('#map');

// 完整事件名稱請參閱
// For all events name visit:
// https://developers.google.com/maps/documentation/javascript/reference?hl=zh-tw#Map
// 若不指定事件，預設為 Click
// Default event is Click.

map.tinyMap({
	/**
	 * 是否要自動偵測使用者位置。預設值false。
	 */
	autoLocation: true,//自動獲取
	/**
	 * 如果瀏覽器不支援地理定位 使用預設位置 
	 */	
	center : [ 25.08, 121.45 ],
	/**
	 * 點擊事件
	 */	
	event : function(map) {
		console.log('點擊地圖');
		map.forEach(myFunction);
	}
});


var btn_test = $("#btn_test");
$(btn_test).click(function(){
	map.tinyMap('modify',{
		'marker': [
		   {'addr': ['25.042152', '121.535398'],'text': '台北科大正門'}
		],//'marker'
		'marker': [
		   {'addr': ['25.0383270525352', '121.57045841217041'],'text': '正門'}
		]//'marker'
	});//map.tinyMap
});//$(btn_test).click(function(){
