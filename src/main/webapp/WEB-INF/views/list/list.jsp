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
		$("#logout").on("click", function() {
//			location.href = '/logout';
			$("form").attr("action", "/logout");
			$("form").attr("method", "post");
			$("form").attr("target", "_self");
			$("form").submit();
		});
		
		$("#search").on("click", function() {
			$("form").attr("action", "/list/search");
			$("form").attr("method", "post");
			$("form").attr("target", "_self");
			$("form").submit();
		});
		
		$("#download").on("click", function() {
			$("form").attr("action", "/list/download");
			$("form").attr("method", "post");
			$("form").attr("target", "_blank");
			$("form").submit();
		});
	});
</script>
</head>
<body>
<form:form method="post" modelAttribute="userForm">

	<c:forEach var="obj" items="${errors}" varStatus="status">
		<c:out value="${obj.defaultMessage}" />, field = <c:out
			value="${obj.field}" />
		<br>
	</c:forEach>
	<br>

<div class="input-group mb-1" style="width:300px;">
<span class="input-group-text" id="basic-addon2" style="width:100px;"><spring:message code="label.name" /></span>
<form:input path="name" class="form-control" />
</div>

<div class="input-group mb-1" style="width:300px;">
<span class="input-group-text" id="basic-addon2" style="width:100px;"><spring:message code="label.email" /></span>
<form:input path="email" class="form-control" />
</div>

<div class="input-group mb-1" style="width:300px;">
<span class="input-group-text" id="basic-addon2" style="width:100px;"><spring:message code="label.age" /></span>
<form:input path="age" class="form-control" />
</div>
	
	<input type="button" id="search" value="検索" class="btn btn-primary" />
	<input type="button" id="logout" value="ログアウト" class="btn btn-success" />
	<input type="button" id="download" value="ダウンロード" class="btn btn-success" />
</form:form>

</body>
