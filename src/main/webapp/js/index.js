$(document).ready(function(){ 
	var scannerHeight = $(window).height();
	var scannerHeightNinety = scannerHeight*0.9;
	$(".headImage").css('height',scannerHeightNinety);

	$('.loadMore').click(function(){
		this.remove();
		$('.loading').css('display','block');
		
	})



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
	            	if(data.recordList.length!=0){

	            		var html = '';
		            	$.each(data.recordList, function (n, value) {
			               // console.log(value);
			               html += '<div class="artical-box col-md-4">'+
			               		   '<div class="artical-box-head-img">'+
			               		   '<img src="' + value.coverImg + '">'+
			               		   '</div>'+
			               		   '<div class="artical-box-font-all"><div class="artical-box-type">'+
			               		   +value.type.name+
			               		   '</div><h3 class="artical-box-title">'+
			               		  value.title+
					        	   '</h3><div class="artical-box-summary">'+
					               value.summary+
				                   '</div></div></div>';
			                 
			            });
		            	$('.artical-total-box').append(html);


	            		$('.loadMore').css('display','block');
	            		$('.loading').css('display','none');
	            	}else{
	            		$('.loadMore').css('display','none');
	            		$('.loading').css('display','none');
	            	}
	            	
	            }
	        }

	    });  
	}

	var pageSizeA = 6;
    var pageNumA = 1;
	getData(pageSizeA,pageNumA);
	

	$('.loadMore').click(function(){
		$('.loadMore').css('display','none');
		$('.loading').css('display','block');
		
		pageNumA=pageNumA+1;
		getData(pageSizeA,pageNumA);

	})
});
	