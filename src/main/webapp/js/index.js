$(document).ready(function(){ 
	var scannerHeight = $(window).height();
	var scannerHeightNinety = scannerHeight*0.9;
	$(".headImage").css('height',scannerHeightNinety);

	$('.loadMore').click(function(){
		this.remove();
		$('.loading').css('display','block');
		
	})
	
});
	