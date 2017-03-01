$(document).ready(function(){ 
	
	var getData = function() {
		$.ajax({
	        type: "POST",
	        url: "../type/getAllArticalType.action",
	        success: function(data){
	            console.log(data);
	            if(data.status == 'false'){
	            	alert("网络错误");
	            }else{
	            	console.log(data);
	            	var typeData = data.data;
	            	var html = '';
	            	$.each(typeData, function (n, value) {
		               
		               html += '<div class="col-sm-6 col-md-4">'+
		               		   '<div class="thumbnail">'+
		               		   '<div class="caption">'+
		               		   '<h3>'+value.name+'</h3>'+
		               		   '<p>'+
				               '<a href="articalIndex.jsp?typeId='+value.id+'" class="btn btn-default" role="button">查看所属文章</a>'+
				               '<a href="typeInsidePage.jsp?typeId='+value.id+'" class="btn changeBtn btn-info" role="button">修改</a>'+
				               '<button onClick="delateBtu('+value.id+')" class="btn deleteBtn btn-danger" role="button">删除</button>'+
			                   '</p>'+' </div></div></div>';
		                 
		            });
		           $('.user-box').append(html);
	            }
	        }
	    });
	}

	getData();

	

	
});

function delateBtu(id){


	$.ajax({
        type: "POST",
        url: "../type/deleteType.action",  
        data:{
        	'id' : id
        },
        success: function(data){
            if(data.status == "false"){
            	alert('网络错误');
            }else{
            	$('.deleteBtn').parent().parent().remove();
            }
        }

    });  
}