<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<head>
<meta charset="utf-8">
<title>ログイン</title>
<style type="text/css">
<!--
-->
</style>

<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/bootstrap-5.1.3-dist/css/bootstrap.min.css">
<script src="<%=request.getContextPath()%>/css/bootstrap-5.1.3-dist/js/bootstrap.bundle.js"></script>
<script src="<%=request.getContextPath()%>/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
	$(function() {
	});
</script>
</head>
<body>
<form method="post" action="<%=request.getContextPath()%>/signin" autocomplete="off">
	<nav class="navbar navbar-dark bg-primary">
		<div class="p-2 bg-primary text-white">社員管理システム / ログイン</div>
	</nav>
	
	<c:if test="${not empty errorMessage}">
		<table class="table table-bordered">
			<tr>
				<th class="table-danger align-middle text-center">
					${errorMessage}
				</th>
			</tr>
		</table>
	</c:if>
	
	<div class="container" style="display: table;height:300px;width:500px;">
	<div class="container" style="display: table-cell;vertical-align: middle;">
	
	<table class="table table-bordered" style="border:1px solid #aaa;">
		<tr>
			<th class="table-primary align-middle text-center" style="width:200px;">
				<spring:message code="label.username" />
			</th>
			<td style="width:300px;">
				<input type="text" class="form-control" style="width:100px;" name="username" value="001">
			</td>
		</tr>
		<tr>
			<th class="table-primary align-middle text-center">
				<spring:message code="label.password" />
			</th>
			<td>
				<input type="password" class="form-control" style="width:100px;" name="password" value="001pass">
			</td>
		</tr>
		<tr>
			<td class="align-middle text-end" colspan="2">
				<input type="submit" value="ログイン" class="btn btn-primary">
			</td>
		</tr>
	</table>
	
	</div>
	</div>
	
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
</body>
