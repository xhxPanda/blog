$(document).ready(function(){ 
	
	var getData = function() {
		$.ajax({
	        type: "POST",
	        url: "../artical/getArticalBack.action",
	        success: function(data){
	            console.log(data);
	            if(data.status == 'false'){
	            	alert("网络错误");
	            }else{
	            	var articalData = data.recordList;
	            	var html = '';
	            	$.each(articalData, function (n, value) {
		               // console.log(value);
		               html += '<div class="col-sm-6 col-md-4">'+
		               		   '<div class="thumbnail">'+
		               		   '<div class="caption">'+
		               		   '<h3>'+value.name+'</h3>'+
		               		   '<p>'+
				               '<a href="#" class="btn btn-default" role="button">查看所属文章</a>'+
			                   '</p>'+' </div></div></div>';
		                 
		            });
		           $('.user-box').append(html);
	            }
	        }
	    });
	}

});
	