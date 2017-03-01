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

	if(typeId!=null||typeId!=""){
		getData();
	}
	

	// $(".submitBtn").click(function(){
	// 	$.ajax({
	//         type: "POST",
	//         url: "../type/getArticalTypeById.action",
	//         data:{
	//         	id:typeId
	//         },
	//         success: function(data){
	//             console.log(data);
	//             if(data.status == 'false'){
	//             	alert("网络错误");
	//             }else{
	            	
	//             }
	//         }
	//     });
	// })
	
});
	