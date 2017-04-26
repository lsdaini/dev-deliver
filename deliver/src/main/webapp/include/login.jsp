<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<%@ include file="/common/common.jsp"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Login Page</title>
	<LINK title="default" rel="stylesheet" type="text/css" href="${basePath}/resources/css/login.css">
	<LINK rel="stylesheet" type="text/css" href="//cdnjs.cloudflare.com/ajax/libs/font-awesome/4.2.0/css/font-awesome.css" />
</head>
<body>
<div id="mainWrapper">
	<div class="login-container">
		<div class="login-card">
			<div class="login-form">
			<img alt="logo" src="${basePath}/resources/images/Login-logo.gif">
			<h3 align="center">欢迎来到登录</h3>
				<c:url var="loginUrl" value="/login!doLogin.action" />
				<form action="${loginUrl}" method="post" class="form-horizontal">
					<c:if test="${param.error != null}">
						<div class="alert alert-danger">
							<p>用户名和密码无效,请核查！</p>
						</div>
					</c:if>
					<c:if test="${param.logout != null}">
						<div class="alert alert-success">
							<p>您已成功登出！</p>
						</div>
					</c:if>
					<div class="input-group input-sm">
						<label class="input-group-addon" for="username"><i class="fa fa-user"></i></label>
						<input type="text" class="form-control" id="username" name="username" placeholder="Enter Username" required>
					</div>
					<div class="input-group input-sm">
						<label class="input-group-addon" for="password"><i class="fa fa-lock"></i></label> 
						<input type="password" class="form-control" id="password" name="password" placeholder="Enter Password" required>
					</div>
					<input type="hidden" name="${_csrf.parameterName}"  value="${_csrf.token}" />
						
					<div class="form-actions">
						<input type="submit" class="btn btn-block btn-primary btn-default" value="Log in">
					</div>
				</form>
			</div>
		</div>
	</div>
</div>
</body>
</html>