$(document).ready(function(){ 
	
	var getData = function() {
		$.ajax({
	        type: "POST",
	        url: "./getAllUsers.action",
	        success: function(data){
	            console.log(data);
	            if(data.status == 'false'){
	            	alert("网络错误");
	            }else{
	            	var userData = data.data;
	            	var html = '';
	            	$.each(userData, function (n, value) {
		               console.log(value);
		               html += '<div class="col-sm-6 col-md-4">'+
		               		   '<div class="thumbnail">'+
		               		   '<img data-src="' + value.headSculpture + '" alt="...">'+
		               		   ' <div class="caption">'+
		               		   '<input id="userId" type="hidden" value="'+value.id+'">'+
		               		   '<h3>'+value.loginName+'</h3>'+
		               		   '<p>'+value.summary+'</p>'+
		               		   '<p>'+
				        	   '<a href="userInsidePage.jsp?userId='+value.id+'" class="btn btn-primary" role="button">修改</a> '+
				               '<a href="#" class="btn deleteBtn btn-default" role="button">删除</a>'+
			                   '</p>'+' </div></div></div>';
		                 
		            });
		           $('.user-box').append(html);
	            }
	        }
	    });
	}

	getData();
	
	$('#deleteBtn').click(function(){
		var id = $('#userId').val();

		$.ajax({
	        type: "POST",
	        url: "./deleteUser.action",  
	        data:{
	        	'id' : userId
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
	