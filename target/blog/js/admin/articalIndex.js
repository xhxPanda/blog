$(document).ready(function(){ 
	
	var getData = function() {
		$.ajax({
	        type: "POST",
	        url: "../artical/getArticalBack.action",
	        data:{
	        	'pageSize':6,
	        	'pageNum':1
	        },
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
		               		   '<img data-src="' + value.coverImg + '" alt="...">'+
		               		   ' <div class="caption">'+
		               		   '<input id="articalId" type="hidden" value="'+value.id+'">'+
		               		   '<h3>'+value.title+'</h3>'+
		               		   '<p>'+value.summary+'</p>'+
		               		   '<p>'+
				               '<a href="#"  class="btn deleteBtn btn-danger" role="button">删除</a>'+
			                   '</p>'+' </div></div></div>';
		                 
		            });
		           $('.user-box').append(html);
	            }
	        }
	    });
	}

	getData();
	
	$('.deleteBtn').click(function(){
		var id = $('#articalId').val();

		$.ajax({
	        type: "POST",
	        url: "./deleteArtical.action",  
	        data:{
	        	'id' : id
	        },
	        success: function(data){
	            if(data.status == "false"){
	            	alert('网络错误');
	            }else{
	            	$('#deleteBtn').parent().parent().remove();
	            }
	        }

	    });  
	})
});
	