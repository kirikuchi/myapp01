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

<link rel="stylesheet" type="text/css" href="/css/bootstrap-datepicker-1.9.0-dist/css/bootstrap-datepicker.min.css">
<script type="text/javascript" src="/css/bootstrap-datepicker-1.9.0-dist/js/bootstrap-datepicker.min.js"></script>
<script type="text/javascript" src="/css/bootstrap-datepicker-1.9.0-dist/locales/bootstrap-datepicker.ja.min.js"></script>

<script type="text/javascript">
	$(function() {
		$("#back").on("click", function() {
			$("form").attr("action", "/list/back");
			$("form").attr("method", "post");
			$("form").attr("target", "_self");
			$("form").submit();
		});
		
		$("#update").on("click", function() {
			$("form").attr("action", "/edit/update");
			$("form").attr("method", "post");
			$("form").attr("target", "_self");
			$("form").submit();
		});

		$('#birthday').datepicker({
			format: 'yyyy/mm/dd',
			autoclose: true
		});
	});
</script>
</head>
<body>
<form:form method="post" modelAttribute="employeeEditForm" autocomplete="off">
	<c:if test="${errors.size() gt 0}">
		<table class="table table-bordered">
			<tr>
				<th class="table-danger">入力エラーがあります。</th>
			</tr>
			<tr>
				<td>
					<div style="height:100;overflow-y:scroll;">
						<c:forEach var="obj" items="${errors}" varStatus="status">
							<c:out value="${obj.defaultMessage}" /><br>
						</c:forEach>
					</div>
				</td>
			</tr>
		</table>
	</c:if>
	<br>
	<table class="table table-bordered" style="width:400px;border:1px solid #aaa;">
		<tr>
			<th class="table-primary" style="width:100px;">
				<spring:message code="label.empId" />
			</th>
			<td style="width:300px;">
				<form:input path="empId" class="form-control" style="width:100px;" maxlength="5" readonly="true"/>
			</td>
		</tr>
		<tr>
			<th class="table-primary">
				<spring:message code="label.lastName" />
			</th>
			<td>
				<form:input path="lastName" class="form-control" style="width:100px;" maxlength="5"/>
			</td>
		</tr>
		<tr>
			<th class="table-primary">
				<spring:message code="label.fastName" />
			</th>
			<td>
				<form:input path="fastName" class="form-control" style="width:100px;" maxlength="5"/>
			</td>
		</tr>
		<tr>
			<th class="table-primary">
				<spring:message code="label.lastNameKana" />
			</th>
			<td>
				<form:input path="lastNameKana" class="form-control" style="width:100px;" maxlength="5"/>
			</td>
		</tr>
		<tr>
			<th class="table-primary">
				<spring:message code="label.fastNameKana" />
			</th>
			<td>
				<form:input path="fastNameKana" class="form-control" style="width:100px;" maxlength="5"/>
			</td>
		</tr>
		<tr>
			<th class="table-primary">
				<spring:message code="label.gender" />
			</th>
			<td>
				<form:select path="gender" class="form-select" style="width:100px;">
					<option value="">
					<c:forEach var="gender" items="${genderList}" varStatus="status">
						<option value="${gender}" <c:if test="${gender == employeeEditForm.gender}">selected</c:if>>${gender}</option>
					</c:forEach>
				</form:select>
			</td>
		</tr>
		<tr>
			<th class="table-primary">
				<spring:message code="label.birthday" />
			</th>
			<td>
				<form:input path="birthday" class="form-control" id="birthday" style="width:120px;" maxlength="5"/>
			</td>
		</tr>
		<tr>
			<th class="table-primary">
				<spring:message code="label.bloodType" />
			</th>
			<td>
				<form:select path="bloodType" class="form-select" style="width:100px;">
					<option value="">
					<c:forEach var="bloodType" items="${bloodTypeList}" varStatus="status">
						<option value="${bloodType}" <c:if test="${bloodType == employeeEditForm.bloodType}">selected</c:if>>${bloodType}</option>
					</c:forEach>
				</form:select>
			</td>
		</tr>
	</table>

	<input type="button" id="back" value="戻る" class="btn btn-primary" />
	<input type="button" id="update" value="更新" class="btn btn-success" />
</form:form>

</body>
