var map = $('#map');

// 完整事件名稱請參閱
// For all events name visit:
// https://developers.google.com/maps/documentation/javascript/reference?hl=zh-tw#Map
// 若不指定事件，預設為 Click
// Default event is Click.
/**
 * 點擊事件
 */
map.tinyMap({
    event: function (map) {
        console.log('點擊地圖');
        // 回傳 Map 物件
//        console.log(map.getCenter().lat());
    }
});