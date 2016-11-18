<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en-US">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>修改页面</title>

		<!-- 新 Bootstrap 核心 CSS 文件 -->
		<link rel="stylesheet" href="../css/bootstrap.min.css">
		<script src="../js/jquery.min.js"></script>
		<script src="../js/bootstrap.min.js"></script>

		<!-- fileLoad文件 -->
		<link href="../css/fileLoadCSS/fileinput.min.css" media="all" rel="stylesheet" type="text/css" />
		<!-- <script src="../js/fileLoadJs/plugins/canvas-to-blob.min.js" type="text/javascript"></script> -->
		<!-- sortable.min.js is only needed if you wish to sort / rearrange files in initial preview.
		     This must be loaded before fileinput.min.js -->
		<!-- <script src="../js/fileLoadJs/plugins/sortable.min.js" type="text/javascript"></script> -->
		<!-- purify.min.js is only needed if you wish to purify HTML content in your preview for HTML files.
		     This must be loaded before fileinput.min.js -->
		<!-- <script src="../js/fileLoadJs/plugins/purify.min.js" type="text/javascript"></script> -->
		<!-- the main fileinput plugin file -->
		<script src="../js/fileLoadJs/fileinput.min.js"></script>
		<!-- optionally if you need a theme like font awesome theme you can include it as mentioned below -->
		<!-- <script src="../themes/fa/theme.js"></script> -->

		<script type="text/javascript" src="../js/admin/userInside.js"></script>
	</head>
	<body>

		<div class="title-box col-md-3">
			<div class="panel panel-default">
				<ul class="nav nav-pills nav-stacked" role="tablist">
				 	<li role="presentation" class="active"><a href="#">用户管理</a></li>
				 	<li role="presentation"><a href="#">文章管理</a></li>
				 	<li role="presentation"><a href="#">分类管理</a></li>
				</ul>
			</div>
		</div>
		
		<div class="main-box col-md-9">
			<div class="panel panel-default">
			  <div class="panel-heading">用户</div>
			  <div class="panel-body">
			   	 <form>
			   	 	<div class="form-group">
					   <label for="username">USERNAME</label>
					   <input type="text" class="form-control" id="userName">
					</div>
				    <div class="form-group">
				    	<label for="exampleInputPassword1">PASSWORD</label>
				    	<input type="text" class="form-control" id="password">
				    </div>
				    <div class="form-group">
				    	<label for="exampleInputPassword1">COVER IMG</label>
				    	<input id="input-id" type="file" class="projectfile" data-preview-file-type="text" >
				    </div>
				    
			   	 </form>
			  </div>
			</div>
		</div>
		

	</body>
</html>