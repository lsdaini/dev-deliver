<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<%@ include file="/common/common.jsp"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome Page</title>
</head>
<body>
	<nav class="navbar navbar-inverse" role="navigation">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#example-navbar-collapse">
					<span class="sr-only">切换导航</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#"><img src="${basePath}/resources/images/Home.png" height="100%"/></a>
			</div>
			<div class="collapse navbar-collapse" id="example-navbar-collapse">
				<ul class="nav navbar-nav">
					<li class="active"><a class="icon-bar" href="#">网站设置</a></li>
					<li><a href="#">分类管理</a></li>
					<li><a href="#">城市管理</a></li>
					<li><a href="#">商品管理</a></li>
					<li><a href="#">订单管理</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a>欢迎您,admin</a></li>
					<li><a href="#">安全退出</a></li>
				</ul>
			</div>
		</div>
	</nav>

	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-2">
				<a href="#" class="list-group-item active">商品管理</a>
				<a href="#" class="list-group-item"><i class="icon-upload-alt icon-large"></i> 文件上传</a>
				<a href="#" class="list-group-item"><i class="icon-upload-alt icon-large"></i> 邮件发送</a>
				<a href="#" class="list-group-item"><i class="icon-reorder icon-large"></i> 商品列表</a>
			</div>
			<div class="col-sm-10">
				<ol class="breadcrumb">
					<li class="active">商品管理</li>
					<li class="active">商品列表</li>
				</ol>

				<div class="panel panel-default">
					<div class="panel-heading">搜索</div>
					<div class="panel-body">
						<form role="form" class="form-inline">
							<div class="form-group">
								<label for="name">名称</label> <input type="text" class="form-control" id="name" placeholder="请输入名称">
							</div>
							<div class="form-group">
								<label for="name">状态</label> <select class="form-control">
									<option>上架</option>
									<option>下架</option>
								</select>
							</div>
							<div class="form-group">
								<button type="submit" class="btn btn-default">开始搜索</button>
							</div>
						</form>
					</div>
				</div>
				<!-- 列表展示 -->
				<div class="table-responsive">
					<table class="table table-striped ">
						<thead>
							<tr>
								<th>编号</th>
								<th>图标</th>
								<th>名称</th>
								<th>价格</th>
								<th>邮费</th>
								<th>状态</th>
								<th>操作</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>15</td>
								<td><i class="icon-reorder icon-large"></i></td>
								<td>超人气无花果</td>
								<td>18.00￥</td>
								<td>18.00￥</td>
								<td>上架</td>
								<td>
									<div class="btn-group">
										<a href="" class="btn btn-default">修改</a>
										<a href="" class="btn btn-default">下架</a>
										<a href="" class="btn btn-danger">删除</a>
									</div>
								</td>
							</tr>
						</tbody>
					</table>
				</div>
				<ul class="pagination" style="float: right;">
					<li><a href="#">&laquo;</a></li>
					<li class="active"><a href="#">1</a></li>
					<li class="disabled"><a href="#">2</a></li>
					<li><a href="#">3</a></li>
					<li><a href="#">4</a></li>
					<li><a href="#">5</a></li>
					<li><a href="#">&raquo;</a></li>
				</ul>
			</div>
		</div>
	</div>
</body>
</html>