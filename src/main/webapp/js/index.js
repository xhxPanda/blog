$(document).ready(function(){ 
	var scannerHeight = $(window).height();
	var scannerHeightNinety = scannerHeight*0.9;
	$(".headImage").css('height',scannerHeightNinety);

	$('.loadMore').click(function(){
		this.remove();
		$('.loading').css('display','block');
		
	})

    var pageSizeA = 6;
    var pageNumA = 1;

	var getData = function(pageSize,pageNum){
		$.ajax({
	        type: "POST",
	        url: "artical/getArticalShow.action",  
	        data:{
	        	'pageSize':pageSize,
	        	'pageNum':pageNum
	        },
	        success: function(data){
	            if(data.status == "false"){
	            	alert('网络错误');
	            }else{
	            	console.log(data.data);
	            }
	        }

	    });  
	}

	getData(pageSizeA,pageNumA);
	
});
	