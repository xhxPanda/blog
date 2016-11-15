$(document).ready(function(){ 
	
	$(".submitButton").click(function(){
	 	var user_name = $("#userName").val();
		var password = $("#password").val();

		$.ajax({
	        type: "POST",
	        url: "./login.action",  
	        data:{
	        	'userName' : user_name,
	        	'password' : password
	        },
	        success: function(msg){
	            // $("#span_content").text("两个数的和为： " + msg);
	        }
	    });  
	});
});
	