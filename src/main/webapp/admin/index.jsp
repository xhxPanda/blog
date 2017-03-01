<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>主页</title>

		<!-- 新 Bootstrap 核心 CSS 文件 -->
		<link rel="stylesheet" href="../css/bootstrap.min.css">
		<script src="../js/jquery.min.js"></script>
		<script src="../js/bootstrap.min.js"></script>

		<link rel="stylesheet" href="../css/admin/index.css">
		<script src="../js/admin/index.js"></script>
		
	</head>
	<body>
		
		<div class="title-box col-md-3">
			<div class="panel panel-default">
				<ul class="nav nav-pills nav-stacked" role="tablist">
				 	<li role="presentation" class="active"><a href="index.jsp">用户管理</a></li>
				 	<li role="presentation"><a href="articalIndex.jsp">文章管理</a></li>
				 	<li role="presentation"><a href="typeIndex.jsp">分类管理</a></li>
				</ul>
			</div>
		</div>
		
		<!--主体部分-->
		<div class="user-box col-md-9">

			<!-- <div class="panelLogin panel panel-default"> -->
			 <!--  <div class="col-sm-6 col-md-4">
			    <div class="thumbnail">
			      <img data-src="holder.js/300x300" alt="...">
			      <div class="caption">
			        <h3>Thumbnail label</h3>
			        <p>...</p>
			        <p>
				        <a href="#" class="btn btn-primary" role="button">修改</a> 
				        <a href="#" class="btn btn-default" role="button">删除</a>
			        </p>
			      </div>
			    </div>
			  </div>
			  <div class="col-sm-6 col-md-4">
			    <div class="thumbnail">
			      <img data-src="holder.js/300x300" alt="...">
			      <div class="caption">
			        <h3>Thumbnail label</h3>
			        <p>...</p>
			        <p>
				        <a href="#" class="btn btn-primary" role="button">修改</a> 
				        <a href="#" class="btn btn-default" role="button">删除</a>
			        </p>
			      </div>
			    </div>
			  </div>
			  <div class="col-sm-6 col-md-4">
			    <div class="thumbnail">
			      <img data-src="holder.js/300x300" alt="...">
			      <div class="caption">
			        <h3>Thumbnail label</h3>
			        <p>...</p>
			        <p>
				        <a href="#" class="btn btn-primary" role="button">修改</a> 
				        <a href="#" class="btn btn-default" role="button">删除</a>
			        </p>
			      </div>
			    </div>
			  </div>
			  <div class="col-sm-6 col-md-4">
			    <div class="thumbnail">
			      <img data-src="holder.js/300x300" alt="...">
			      <div class="caption">
			        <h3>Thumbnail label</h3>
			        <p>...</p>
			        <p>
				        <a href="#" class="btn btn-primary" role="button">修改</a> 
				        <a href="#" class="btn btn-default" role="button">删除</a>
			        </p>
			      </div>
			    </div>
			  </div>
			  <div class="col-sm-6 col-md-4">
			    <div class="thumbnail">
			      <img data-src="holder.js/300x300" alt="...">
			      <div class="caption">
			        <h3>Thumbnail label</h3>
			        <p>...</p>
			        <p>
				        <a href="#" class="btn btn-primary" role="button">修改</a> 
				        <a href="#" class="btn btn-default" role="button">删除</a>
			        </p>
			      </div>
			    </div>
			  </div>

			  <s:iterator value="data" var="x">  
				  <s:property value="#x.id"/>  
			  </s:iterator>   -->
			<!-- </div> -->

		</div>

	</body>
</html>