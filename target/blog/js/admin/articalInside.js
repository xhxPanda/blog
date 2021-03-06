$(document).ready(function(){ 

	var getUrlParam= function(name){
		var reg
		 = new RegExp("(^|&)"+
		 name +"=([^&]*)(&|$)");
		var r
		 = window.location.search.substr(1).match(reg);
		if (r!=null) return unescape(r[2]); return null;
	}

	var articalId = getUrlParam('articalId');
	

	var getData = function(articalId){
		if(articalId == null||articalId == ''){
			return
		}else{
			$.ajax({
		        type: "POST",
		        url: "../artical/getArticalById.action",  
		        data:{
		        	'articalId' : articalId
		        },
		        success: function(data){
		            if(data.status == "false"){
		            	alert('网络错误');
		            }else{
		            	$('#title').val(data.title);
		            	$('#summary').val(data.summary);
		            	$('#type').val(data.type);
		            	if(data.content != null){
		            		UE.getEditor('container').setContent(data.content);
		            	}
		            	
		            }
		        }

		    });  
		}
		
	}

	getData(articalId);

	
	var getTypeData = function(){
		$.ajax({
	        type: "POST",
	        url: "../type/getAllArticalType.action",
	        success: function(data){
	        	
	           var html = '';
	            $.each(data.data, function (n, value) {
	               // console.log(value);
	               html += '<option value="'+value.id+'">'
	            	+value.name+'</option>'
	            });
	            $('#type').append(html);
	        }

	    });  
	}

	getTypeData();

	$('#submitBtn').click(function(){
		
	})

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
	        	var title = $('#title').val();
				var summary = $('#summary').val();
				var type = $('#type').val();
				var tag = $('#tag').val();
				var content = UE.getEditor('container').getContent();

				console.log(content);

				var path = data.response.filePath;

				if(title!=null&&type!=null||content!=null){
					$.ajax({
				        type: "POST",
				        url: "../artical/save.action",
				         data:{
				        	'title' : title,
				        	'summary' : summary,
				        	'typeId' : type,
				        	'content' : content,
				        	'coverImg' : path,
				        	'tag' : tag
				        },
				        success: function(data){
				            if(data.status=='true'){
				            	alert("添加成功");
				            }
				        }

				    });  
				}
			        	
	        }
	        
	    })
	 
});
	