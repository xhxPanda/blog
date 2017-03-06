$(document).ready(function(){ 
	
	$(".submitButton").click(function(){
	 	var user_name = $("#userName").val();
		var password = $("#password").val();
		
		console.log(password);
		if(user_name!=null&&password!=null){
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
		}else{
			alert("用户名或密码不能为空");
		}
		  
	});
		
		
});
	