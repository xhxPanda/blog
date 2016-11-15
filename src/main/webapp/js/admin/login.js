$(document).ready(function(){ 
	
	$(".submitButton").click(function(){
	 	var user_name = $("#userName").val();
		var password = $("#password").val();
		// console.log(password);
		var user = {userName:user_name,password:password};

		// console.log(user.password);
		$.ajax({
	        type: "POST",
	        url: "./login.action",  
	        data:{
	        	'userName' : user_name,
	        	'password' : password
	        },
	        success: function(msg){
	            console.log(msg);
	        }
	    });  
	});
});
	