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

		<script src="../js/admin/typeInsidePage.js"></script>

	</head>
	<body>

		<div class="title-box col-md-3">
			<div class="panel panel-default">
				<ul class="nav nav-pills nav-stacked" role="tablist">
				 	<li role="presentation"><a href="index.jsp">用户管理</a></li>
				 	<li role="presentation"><a href="articalIndex.jsp">文章管理</a></li>
				 	<li role="presentation" class="active"><a href="typeIndex.jsp">分类管理</a></li>
				</ul>
			</div>
		</div>
		
		<div class="main-box col-md-9">
			<div class="panel panel-default">
			  <div class="panel-heading">分类详情</div>
			  <div class="panel-body">
			   	 <form>
			   	 	<div class="form-group">
					   <label for="name">名称</label>
					   <input type="text" class="form-control" id="name">
					</div>
				  	<div>
				  		<button class="btn submitBtn btn-info">提交</button>
				  	</div>
			   	 </form>
			  </div>
			</div>
		</div>
		

	</body>
</html>