<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<%@ include file="/common/common.jsp"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome Page</title>
  <style type="text/css">
      body {
        padding-top: 60px;
        padding-bottom: 40px;
      }
  </style>
</head>
<body>
	
	<%@ include file="top.jsp"%>
	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-2"><%@ include file="left.jsp"%></div>
			<div class="col-sm-10"><%@ include file="main.jsp"%></div>
		</div>
	</div>
</body>
</html>