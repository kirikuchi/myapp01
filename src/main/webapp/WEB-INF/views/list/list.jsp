<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<head>
<meta charset="utf-8">
<title>社員情報検索</title>
<style type="text/css">
<!--
-->
</style>

<link rel="stylesheet"
	href="/css/bootstrap-5.1.3-dist/css/bootstrap.min.css">
<script src="/css/bootstrap-5.1.3-dist/js/bootstrap.bundle.js"></script>
<script src="/js/jquery-3.6.0.min.js"></script>

<link rel="stylesheet" type="text/css" href="/css/bootstrap-datepicker-1.9.0-dist/css/bootstrap-datepicker.min.css">
<script type="text/javascript" src="/css/bootstrap-datepicker-1.9.0-dist/js/bootstrap-datepicker.min.js"></script>
<script type="text/javascript" src="/css/bootstrap-datepicker-1.9.0-dist/locales/bootstrap-datepicker.ja.min.js"></script>

<script type="text/javascript">
	$(function() {
		$(document).ready(function() {
			console.log($("#list").scrollTop);
			$("#list").scrollTop(${employeeListForm.hdnScrollTop});
		});
		
		$("#logout").on("click", function() {
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
		
		$('#birthday').datepicker({
			format: 'yyyy/mm/dd',
			autoclose: true
		});
		
		$("[id^=edit]").on("click", function() {
			var hdnEmpId = $(this).closest('tr').find('input[id=hdnEmpId]').val();
			var hdnScrollTop = $("#list").scrollTop();
			$("#hdnSelectedEmpId").val(hdnEmpId);
			$("#hdnScrollTop").val(hdnScrollTop);
			$("form").attr("action", "/edit/init");
			$("form").attr("method", "post");
			$("form").attr("target", "_self");
			$("form").submit();
		});
		
		$("input").keypress(function (e) {
			if (e.keyCode != 13) {
				return; 
			}
			$("form").attr("action", "/list/search");
			$("form").attr("method", "post");
			$("form").attr("target", "_self");
			$("form").submit();
		});
	});
</script>
</head>
<body>
<form:form method="post" modelAttribute="employeeListForm" autocomplete="off">
	<nav class="navbar navbar-dark bg-primary">
		<div class="p-2 bg-primary text-white">社員管理システム / 社員情報検索</div>
		<input type="button" id="logout" value="ログアウト" class="btn btn-primary" />
	</nav>

<div class="container" style="display: table;width:1000px;">
	<br>
	<table class="table table-bordered" style="border:1px solid #aaa;width:915px;">
		<tr>
			<th class="table-primary align-middle text-center">
				<spring:message code="label.empId" />
			</th>
			<td colspan="7">
				<form:input path="empId" class="form-control" style="width:100px;" maxlength="5"/>
			</td>
		</tr>
		<tr>
			<th class="table-primary align-middle text-center">
				<spring:message code="label.lastName" />
			</th>
			<td>
				<form:input path="lastName" class="form-control" style="width:100px;" maxlength="5"/>
			</td>
			<th class="table-primary align-middle text-center">
				<spring:message code="label.firstName" />
			</th>
			<td>
				<form:input path="firstName" class="form-control" style="width:100px;" maxlength="5"/>
			</td>
			<th class="table-primary align-middle text-center">
				<spring:message code="label.lastNameKana" />
			</th>
			<td>
				<form:input path="lastNameKana" class="form-control" style="width:100px;" maxlength="5"/>
			</td>
			<th class="table-primary align-middle text-center">
				<spring:message code="label.firstNameKana" />
			</th>
			<td>
				<form:input path="firstNameKana" class="form-control" style="width:100px;" maxlength="5"/>
			</td>
		</tr>
		<tr>
			<th class="table-primary align-middle text-center">
				<spring:message code="label.gender" />
			</th>
			<td>
				<form:select path="gender" class="form-select">
					<option value="">
					<c:forEach var="gender" items="${genderList}" varStatus="status">
						<option value="${gender}" <c:if test="${gender == employeeListForm.gender}">selected</c:if>>${gender}</option>
					</c:forEach>
				</form:select>
			</td>
			<th class="table-primary align-middle text-center">
				<spring:message code="label.birthday" />
			</th>
			<td>
				<form:input path="birthday" class="form-control" id="birthday" style="width:115px;" maxlength="5"/>
			</td>
			<th class="table-primary align-middle text-center">
				<spring:message code="label.bloodType" />
			</th>
			<td colspan="3">
				<form:select path="bloodType" class="form-select" style="width:100px;">
					<option value="">
					<c:forEach var="bloodType" items="${bloodTypeList}" varStatus="status">
						<option value="${bloodType}" <c:if test="${bloodType == employeeListForm.bloodType}">selected</c:if>>${bloodType}</option>
					</c:forEach>
				</form:select>
			</td>
		</tr>
		<tr>
			<td colspan="8" class="align-middle text-end">
				<input type="button" id="search" value="検索" class="btn btn-primary" />
				<input type="button" id="download" value="全社員情報をPDF化する" class="btn btn-primary" />
			</td>
		</tr>
	</table>
<c:if test="${employeeListForm.employeeList.size() lt 1}">
検索条件に該当するデータがありませんでした。
</c:if>
<c:if test="${employeeListForm.employeeList.size() gt 0}">
	<table class="table table-bordered" style="width:900px;">
		<thead>
			<tr class="table-primary">
				<th class="align-middle text-center" style="width:100px;"><spring:message code="label.empId" /></th>
				<th class="align-middle text-center" style="width:100px;"><spring:message code="label.lastName" /></th>
				<th class="align-middle text-center" style="width:100px;"><spring:message code="label.firstName" /></th>
				<th class="align-middle text-center" style="width:100px;"><spring:message code="label.lastNameKana" /></th>
				<th class="align-middle text-center" style="width:100px;"><spring:message code="label.firstNameKana" /></th>
				<th class="align-middle text-center" style="width:100px;"><spring:message code="label.gender" /></th>
				<th class="align-middle text-center" style="width:100px;"><spring:message code="label.birthday" /></th>
				<th class="align-middle text-center" style="width:100px;"><spring:message code="label.bloodType" /></th>
				<th class="align-middle text-center" style="width:100px;"></th>
			</tr>
		</thead>
	</table>
<div id="list" style="height:385px;width:918px;overflow-y:scroll;border: 0;position: relative;top:-18px;">
	<table class="table table-bordered table-striped" style="width:900px;">
		<c:forEach var="employee" items="${employeeListForm.employeeList}" varStatus="status">
			<tr>
				<td class="align-middle text-center" style="width:100px;">${employee.empId}</td>
				<td class="align-middle text-center" style="width:100px;">${employee.lastName}</td>
				<td class="align-middle text-center" style="width:100px;">${employee.firstName}</td>
				<td class="align-middle text-center" style="width:100px;">${employee.lastNameKana}</td>
				<td class="align-middle text-center" style="width:100px;">${employee.firstNameKana}</td>
				<td class="align-middle text-center" style="width:100px;">${employee.gender}</td>
				<td class="align-middle text-center" style="width:100px;">${employee.birthday}</td>
				<td class="align-middle text-center" style="width:100px;">${employee.bloodType}</td>
				<td class="align-middle text-center" style="width:100px;">
					<input type="hidden" id="hdnEmpId" value="${employee.empId}" />
					<input type="button" id="edit_${status.index}" value="編集" class="btn btn-primary" />
				</td>
			</tr>
		</c:forEach>
	</table>
</div>
</c:if>

</div>

<input type="hidden" id="hdnSelectedEmpId" name="hdnSelectedEmpId" value="" />
<input type="hidden" id="hdnScrollTop" name="hdnScrollTop" value="" />
</form:form>

</body>
