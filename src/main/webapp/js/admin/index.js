$(document).ready(function(){ 
	
	function getData() {
		$.ajax({
	        type: "POST",
	        url: "./login.action",  
	        data:{
	        	'loginName' : user_name,
	        	'password' : password
	        },
	        success: function(data){
	            console.log(data);
	            if(data.status == 'false'){
	            	alert("您的用户名或密码错误");
	            }else{
	            	location.href = "index.jsp";
	            }
	        }
	    });
	}
	 
});
	