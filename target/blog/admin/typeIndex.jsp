<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>分类管理</title>

		<!-- 新 Bootstrap 核心 CSS 文件 -->
		<link rel="stylesheet" href="../css/bootstrap.min.css">
		<script src="../js/jquery.min.js"></script>
		<script src="../js/bootstrap.min.js"></script>

		<link rel="stylesheet" href="../css/admin/index.css">
		
		<script src="../js/admin/typeIndex.js"></script>
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

		<!--主体部分-->
		<div class="user-box col-md-9">

			<!-- <div class="col-sm-6 col-md-4">
			    <div class="thumbnail">
			      <div class="caption">
			        <h3>Thumbnail label</h3>
			        <p>
				        <a href="#" class="btn btn-primary" role="button">修改</a> 
				        <a href="#" class="btn btn-default" role="button">查看所属文章</a>
			        </p>
			      </div>
			    </div>
			  </div> -->
		</div>

		<div class="col-md-9 add-artical-button">
			<a href="articalInsidePage.jsp"><button type="button" class="btn btn-info">添加分类</button></a>
		</div>

	</body>
</html>