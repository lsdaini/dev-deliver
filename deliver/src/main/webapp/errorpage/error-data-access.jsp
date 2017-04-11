<%@ page language="java" errorPage="/error.jsp" pageEncoding="UTF-8"
	contentType="text/html;charset=utf-8"%>
<%@ include file="/common/taglibs.jsp"%>
<%@ include file="/common/common.jsp"%>
<!DOCTYPE html>

<html>

<head>
<title>error-data-access</title>
</head>

<body>
	<p><c:out value="${requestScope.exception.message}" /></p>

	<%
		Exception ex = (Exception) request.getAttribute("exception");
		ex.printStackTrace(new java.io.PrintWriter(out));
	%>

	<a href="#" onclick="history.back();return false">&#171; Back</a>
</body>
</html>