<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>管理员登录</title>

		<!-- 新 Bootstrap 核心 CSS 文件 -->
		<link rel="stylesheet" href="../css/bootstrap.min.css">
		<script src="../js/jquery.min.js"></script>
		<script src="../js/bootstrap.min.js"></script>


		<link rel="stylesheet" href="../css/admin/login.css">		
		<script src="../js/admin/login.js"></script>

		
	</head>
	<body>
		
		<div class="container">
			<div class="panelLogin panel panel-default">
			  <div class="panel-heading">
			    <h3 class="panel-title">登录</h3>
			  </div>
			  <div class="panel-body">
			    <form role="form">
				  <div class="form-group">
				    <label for="exampleInputEmail1">USERNAME</label>
				    <input type="email" class="form-control" id="exampleInputEmail1">
				  </div>
				  <div class="form-group">
				    <label for="exampleInputPassword1">PASSWORD</label>
				    <input type="password" class="form-control" id="exampleInputPassword1">
				  </div>
				   <button type="submit" class="btn btn-default">Submit</button>
				</form>
			  </div>
			</div>
		</div>
			
	</body>
</html>