$(document).ready(function(){ 
	
	var getUrlParam= function(name){
		var reg
		 = new RegExp("(^|&)"+
		 name +"=([^&]*)(&|$)");
		var r
		 = window.location.search.substr(1).match(reg);
		if (r!=null) return unescape(r[2]); return null;
	}

	var typeId = getUrlParam('typeId');

	var getData = function() {
		$.ajax({
	        type: "POST",
	        url: "../type/getArticalTypeById.action",
	        data:{
	        	id:typeId
	        },
	        success: function(data){
	            
	            if(data.status == 'false'){
	            	alert("网络错误");
	            }else{
	            	$("#name").val(data.name);
	            }
	        }
	    });
	}

	var update = function() {
		var typeName = $("#name").val();

		$.ajax({
	        type: "POST",
	        url: "../type/update.action",
	        data:{
	        	id:typeId,
	        	name : typeName
	        },
	        success: function(data){
	            
	            if(data.status == 'false'){
	            	alert("网络错误");
	            }else{
	            	alert("修改成功")
	            }
	        }
	    });
	}

	var save = function() {
		var typeName = $("#name").val();

		$.ajax({
	        type: "POST",
	        url: "../type/save.action",
	        data:{
	        	name : typeName
	        },
	        success: function(data){
	            
	            if(data.status == 'false'){
	            	alert("网络错误");
	            }else{
	            	alert("新增成功")
	            }
	        }
	    });
	}

	if(typeId!=null||typeId!=""){
		getData();
	}

	
});

$(".submitBtn").click(function(){
		if(typeId!=null||typeId!=""){
			update();
		}else{
			save();
		}
	})