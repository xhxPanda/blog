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


		<!-- 配置文件 -->
   		 <script type="text/javascript" src="../js/utf8-jsp/ueditor.config.js"></script>
   		 <!-- 编辑器源码文件 -->
    	<script type="text/javascript" src="../js/utf8-jsp/ueditor.all.js"></script>
	    <script type="text/javascript" charset="utf-8" src="../js/utf8-jsp/lang/zh-cn/zh-cn.js"></script>

    	<script type="text/javascript">
	        var ue = UE.getEditor('container');
	    </script>

		<link rel="stylesheet" href="../css/admin/articalInsidePage.css">
		
	</head>
	<body>

		<div class="title-box col-md-3">
			<div class="panel panel-default">
				<ul class="nav nav-pills nav-stacked" role="tablist">
				 	<li role="presentation"><a href="#">用户管理</a></li>
				 	<li role="presentation" class="active"><a href="#">文章管理</a></li>
				 	<li role="presentation"><a href="#">分类管理</a></li>
				</ul>
			</div>
		</div>
		
		<div class="main-box col-md-9">
			<div class="panel panel-default">
			  <div class="panel-heading">文章</div>
			  <div class="panel-body">
			   	 <form>
			   	 	<div class="form-group">
					   <label for="exampleInputEmail1">TITLE</label>
					   <input type="email" class="form-control" id="exampleInputEmail1">
					</div>
				  	<div class="form-group">
				    	<label for="exampleInputPassword1">SUMMARY<span class="tips">(30字以内)</span></label>
				    	<textarea class="form-control"></textarea>
				    </div>
				    <div class="form-group">
				    	<label for="exampleInputPassword1">TYPE</label>
				    	<select class="form-control">
				    		<option>请选择</option>
				    	</select>
				    </div>
				     <div class="form-group">
				    	<label for="exampleInputPassword1">COMMENT</label>
				    	 <script id="container" name="content" type="text/plain" style="height: 1500px;">
					    </script>
				    </div>
				     <button type="submit" class="btn btn-default">Submit</button>
			   	 </form>
			  </div>
			</div>
		</div>
		

	</body>
</html>