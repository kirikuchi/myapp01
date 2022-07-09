<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<head>

<style type="text/css">
<!--
table.st-tbl1 {
	text-align: left;
	position: relative;
	border-collapse: collapse; 
	width:100%;
}
table.st-tbl1 th,
table.st-tbl1 td{
	padding: 1rem;
	border: solid 1px #ddd;
}
table.st-tbl1 th {
	background: white;
	position: sticky;
	top: 0;
}
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
			$("#hdnSelectedEmpId").val(hdnEmpId);
			$("form").attr("action", "/edit/init");
			$("form").attr("method", "post");
			$("form").attr("target", "_self");
			$("form").submit();			 
		});
	});
</script>
</head>
<body>
<form:form method="post" modelAttribute="employeeListForm" autocomplete="off">
<div class="input-group mb-1" style="width:600px;">
	<span class="input-group-text" id="basic-addon2" style="width:100px;"><spring:message code="label.empId" /></span>
	<form:input path="empId" class="form-control" style="width:100px;" maxlength="5"/>
	<span class="input-group-text" id="basic-addon2" style="width:100px;"><spring:message code="label.lastName" /></span>
	<form:input path="lastName" class="form-control" style="width:100px;" maxlength="5"/><br>
	<span class="input-group-text" id="basic-addon2" style="width:100px;"><spring:message code="label.fastName" /></span>
	<form:input path="fastName" class="form-control" style="width:100px;" maxlength="5"/><br>
	<span class="input-group-text" id="basic-addon2" style="width:100px;"><spring:message code="label.lastNameKana" /></span>
	<form:input path="lastNameKana" class="form-control" style="width:100px;" maxlength="5"/><br>
	<span class="input-group-text" id="basic-addon2" style="width:100px;"><spring:message code="label.fastNameKana" /></span>
	<form:input path="fastNameKana" class="form-control" style="width:100px;" maxlength="5"/><br>
	
	<span class="input-group-text" id="basic-addon2" style="width:100px;"><spring:message code="label.gender" /></span>
	<form:select path="gender" class="form-select">
		<option value="">
		<c:forEach var="gender" items="${genderList}" varStatus="status">
			<option value="${gender}" <c:if test="${gender == employeeListForm.gender}">selected</c:if>>${gender}</option>
		</c:forEach>
	</form:select>
	
	<span class="input-group-text" id="basic-addon2" style="width:100px;"><spring:message code="label.birthday" /></span>
	<form:input path="birthday" class="form-control" id="birthday" style="width:100px;" maxlength="5"/><br>
	
	<span class="input-group-text" id="basic-addon2" style="width:100px;"><spring:message code="label.bloodType" /></span>
	<form:select path="bloodType" class="form-select">
		<option value="">
		<c:forEach var="bloodType" items="${bloodTypeList}" varStatus="status">
			<option value="${bloodType}" <c:if test="${bloodType == employeeListForm.bloodType}">selected</c:if>>${bloodType}</option>
		</c:forEach>
	</form:select>
</div>

	<input type="button" id="search" value="検索" class="btn btn-primary" />
	<input type="button" id="logout" value="ログアウト" class="btn btn-success" />
	<input type="button" id="download" value="ダウンロード" class="btn btn-success" />

<c:if test="${employeeListForm.employeeList.size() gt 0}">
	<table class="table table-bordered" style="width:900px;">
		<thead>
			<tr class="table-info">
				<th class="align-middle text-center" style="width:100px;"><spring:message code="label.empId" /></th>
				<th class="align-middle text-center" style="width:100px;"><spring:message code="label.lastName" /></th>
				<th class="align-middle text-center" style="width:100px;"><spring:message code="label.fastName" /></th>
				<th class="align-middle text-center" style="width:100px;"><spring:message code="label.lastNameKana" /></th>
				<th class="align-middle text-center" style="width:100px;"><spring:message code="label.fastNameKana" /></th>
				<th class="align-middle text-center" style="width:100px;"><spring:message code="label.gender" /></th>
				<th class="align-middle text-center" style="width:100px;"><spring:message code="label.birthday" /></th>
				<th class="align-middle text-center" style="width:100px;"><spring:message code="label.bloodType" /></th>
				<th class="align-middle text-center" style="width:100px;"></th>
			</tr>
		</thead>
	</table>
<div style="height:350px;width:920px;overflow-y:scroll;border: 1px solid #ddd;position: relative;top:-18px;">
	<table class="table table-bordered" style="width:900px;">
		<c:forEach var="employee" items="${employeeListForm.employeeList}" varStatus="status">
			<tr>
				<td class="align-middle text-center" style="width:100px;">${employee.empId}</td>
				<td class="align-middle text-center" style="width:100px;">${employee.lastName}</td>
				<td class="align-middle text-center" style="width:100px;">${employee.fastName}</td>
				<td class="align-middle text-center" style="width:100px;">${employee.lastNameKana}</td>
				<td class="align-middle text-center" style="width:100px;">${employee.fastNameKana}</td>
				<td class="align-middle text-center" style="width:100px;">${employee.gender}</td>
				<td class="align-middle text-center" style="width:100px;">${employee.birthday}</td>
				<td class="align-middle text-center" style="width:100px;">${employee.bloodType}</td>
				<td class="align-middle text-center" style="width:100px;">
					<input type="hidden" id="hdnEmpId" value="${employee.empId}" />
					<input type="button" id="edit_${status.index}" value="編集" class="btn btn-success" />
				</td>
			</tr>
		</c:forEach>
	</table>
</div>
</c:if>

<input type="hidden" id="hdnSelectedEmpId" name="hdnSelectedEmpId" value="" />
</form:form>

</body>
