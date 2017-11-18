<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
	<div class="container-fluid"  style="margin: 0px 16px;">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#example-navbar-collapse">
				<span class="sr-only">切换导航</span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#"><%-- <img src="${basePath}/resources/images/Home.png" height="100%" /> --%></a>
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
				<!-- <li><a>欢迎您,admin</a></li> -->
				<li class="dropdown">
		          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">欢迎您,admin <span class="caret"></span></a>
		          <ul class="dropdown-menu">
		            <li><a href="#"><i class="icon-user icon-large"></i>&nbsp;个人中心</a></li>
		            <li><a href="#"><i class="icon-pencil icon-large"></i>&nbsp;修改密码</a></li>
		            <li role="separator" class="divider"></li>
		            <li><a href="#"><i class="icon-signout icon-large"></i>&nbsp;安全退出</a></li>
		          </ul>
		        </li>
				<!-- <li><a href="#">安全退出</a></li> -->
			</ul>
		</div>
	</div>
</nav>