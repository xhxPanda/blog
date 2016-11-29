$(document).ready(function(){ 
	
	var getTypeData = function(){
		$.ajax({
	        type: "POST",
	        url: "../type/getAllArticalType.action",
	        success: function(data){
	        	
	           var html = '';
	            $.each(data.data, function (n, value) {
	               console.log(value);
	               html += '<option value="'+value.id+'">'
	            	+value.name+'</option>'
	            });
	            $('#type').append(html);
	        }

	    });  
	}

	getTypeData();

	$('#submitBtn').click(function(){
		var title = $('#title').val();
		var summary = $('#summary').val();
		var type = $('#type').val();
		var content = $('#content').val();

		$.ajax({
	        type: "POST",
	        url: "./artical/save.action",
	         data:{
	        	'title' : title,
	        	'summary' : summary,
	        	'type' : type,
	        	'content' : content,
	        },
	        success: function(data){
	            console.log(data);
	        }

	    });  
	})
	 
});
	