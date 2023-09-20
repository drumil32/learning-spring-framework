<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Todo page</title>
<link href="/webjars/bootstrap/5.1.3/css/bootstrap.min.css"
	rel="stylesheet" />
<link
	href="/webjars/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.standalone.min.css"
	rel="stylesheet" />
</head>
<body>
	<div class="container">
		<h1>Enter Todo Details</h1>
		<form:form method="post" modelAttribute="todo">
			<fieldset class="mb-4">
				<form:label path="description">Description</form:label>
				<form:input type="text" path="description" required="required" />
				<form:errors path="description" cssClass="text-warning" />
			</fieldset>

			<fieldset class="mb-4">
				<form:label path="targetDate">Target Date</form:label>
				<form:input type="text" path="targetDate" required="required" />
				<form:errors path="targetDate" cssClass="text-warning" />
			</fieldset>

			<form:input type="hidden" path="isCompleted" />
			<input type="submit" class="btn btn-success" />
		</form:form>
	</div>
	<script src="/webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
	<script src="/webjars/jquery/3.7.1/jquery.min.js"></script>
	<script
		src="/webjars/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js"></script>
	<script type="text/javascript">
		$('#targetDate').datepicker({
			format : 'yyyy-mm-dd',
		});
	</script>
</body>
</html>