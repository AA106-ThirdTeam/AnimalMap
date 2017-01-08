$(document).ready(function($){
	//---web左方案鈕:隱藏/顯示----
	$('.cd-filter-trigger').on('click',function(){
		triggerFilter(true);
	})
	
	$('.cd-filter .cd-close').on('click',function(){
		triggerFilter(false);
	})
	
	function triggerFilter(bool) {
		var elementsToTrigger = $([$('.cd-filter-trigger'),$('.cd-filter'),$('.cd-tab-filter'),$('.cd-gallery')]);
		elementsToTrigger.each(function() {
			$(this).toggleClass('filter-is-visible',bool);
		})
	}
	//後面四行:展開左方資訊欗
	var elementsToTrigger = $([$('.cd-filter-trigger'),$('.cd-filter'),$('.cd-tab-filter'),$('.cd-gallery')]);
	elementsToTrigger.each(function() {
		$(this).toggleClass('filter-is-visible',true);
	})
	
})