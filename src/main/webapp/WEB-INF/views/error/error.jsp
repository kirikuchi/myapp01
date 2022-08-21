<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>不正なリクエスト</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/bootstrap-5.1.3-dist/css/bootstrap.min.css">
<script src="<%=request.getContextPath()%>/css/bootstrap-5.1.3-dist/js/bootstrap.bundle.js"></script>
<script src="<%=request.getContextPath()%>/js/jquery-3.6.0.min.js"></script>

<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/bootstrap-datepicker-1.9.0-dist/css/bootstrap-datepicker.min.css">
<script type="text/javascript" src="<%=request.getContextPath()%>/css/bootstrap-datepicker-1.9.0-dist/js/bootstrap-datepicker.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/css/bootstrap-datepicker-1.9.0-dist/locales/bootstrap-datepicker.ja.min.js"></script>

<script type="text/javascript">
	$(function() {
		$("#back").on("click", function() {
			$("form").attr("action", "<%=request.getContextPath()%>/login");
			$("form").attr("method", "get");
			$("form").submit();
		});
	});
</script>
</head>

<body>
<form>
不正なリクエストです。ボタンを押して画面遷移してください。<br>
<input type="button" id="back" value="ログイン画面に戻る">
</form>
</body>
</html>