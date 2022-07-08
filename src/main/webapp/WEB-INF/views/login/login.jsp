<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<head>
<link rel="stylesheet"
	href="/css/bootstrap-5.1.3-dist/css/bootstrap.min.css">
<script src="/css/bootstrap-5.1.3-dist/js/bootstrap.bundle.js"></script>
<script src="/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
	$(function() {
	});
</script>
</head>
<body>
	<form method="post" action="/signin">
		<input type="text" name="username" value="001">user_name<br/> 
		<input type="password" name="password" value="001pass">password<br/>
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
		<input type="submit" value="Login">
	</form>
</body>
