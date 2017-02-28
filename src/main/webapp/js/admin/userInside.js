$(document).ready(function(){ 
	

	var getUrlParam= function(name){
		var reg
		 = new RegExp("(^|&)"+
		 name +"=([^&]*)(&|$)");
		var r
		 = window.location.search.substr(1).match(reg);
		if (r!=null) return unescape(r[2]); return null;
	}

	var getData = function(userId){
		if(userId == null||userId == ''){
			return
		}else{
			$.ajax({
		        type: "POST",
		        url: "./getUserById.action",  
		        data:{
		        	'id' : userId
		        },
		        success: function(data){
		            if(data.status == "false"){
		            	alert('网络错误');
		            }else{
		            	$('#userName').val(data.loginName);
		            	$('#summary').val(data.summary);
		            	$('#authority').val(data.authority);
		            	$('#age').val(data.age);
		            	$('#sex').val(data.sex);
		            	
		            }
		        }

		    });  
		}
		
	}

	var userId = getUrlParam('userId');
	getData(userId);

	 $(".projectfile").fileinput({
	   uploadUrl:'./addPic.action', // you must set a valid URL here else you will get an error
	   allowedFileExtensions: ['jpg', 'gif', 'png'],//接收的文件后缀
	   showUpload: true, //是否显示上传按钮
	   showCaption: false,//是否显示标题
	   browseClass: "btn btn-primary", //按钮样式 
	   //dropZoneEnabled: false,//是否显示拖拽区域
	   //minImageWidth: 50, //图片的最小宽度
	   //minImageHeight: 50,//图片的最小高度
	   //maxImageWidth: 1000,//图片的最大宽度
	   //maxImageHeight: 1000,//图片的最大高度
	   //maxFileSize: 0,//单位为kb，如果为0表示不限制文件大小
	   //minFileCount: 0,
	   maxFileCount: 1, //表示允许同时上传的最大文件个数
	   enctype: 'multipart/form-data',
	   validateInitialCount:true
    }).on("fileuploaded", function(event, data) {
	        if(data.response){
	        	var userName = $("#userName").val();
				var password = $("#password").val();
				var authority = $("#authority").val();
				var summary = $("#summary").val();
				var age = $("#age").val();
				var sex = $("#sex").val();
				// console.log(authority);
       	
	        	var path = data.response.filePath;
	        	if(userId==null||userId==''){
	        		if(userName!=null&&userName!=""&&password!=null
	        			&&password!=""&&age!=null&&age!=""&&sex!=null&&sex!=""){
		        		$.ajax({
					        type: "POST",
					        url: "./addUser.action",  
					        data:{
					        	'loginName' : userName,
					        	'password' : password,
					        	'headSculpture' : path,
					        	'authority' : authority,
					        	'summary' : summary,
					        	'age' : age,
					        	'sex' : sex
					        },
					        success: function(msg){
					            console.log(msg);
					        }
					    });  
		        	}else{
		        		alert("关键信息不能为空");
		        	}
	        	}else{
	        		if(userName!=null&&userName!=""&&password!=null&&password!=""){
	        			$.ajax({
					        type: "POST",
					        url: "./update.action",  
					        data:{
					        	'id' : userId,
					        	'loginName' : userName,
					        	'password' : password,
					        	'headSculpture' : path,
					        	'authority' : authority,
					        	'summary' : summary,
					        	'age' : age,
					        	'sex' : sex
					        },
					        success: function(msg){
					            console.log(msg);
					        }
					    });  
	        		}
	        		
	        	}
	        	
	        }
	        
	    })
});
	