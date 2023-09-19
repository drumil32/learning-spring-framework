<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Todo page</title>
<link href="/webjars/bootstrap/5.1.3/css/bootstrap.min.css"
	rel="stylesheet" />
</head>
<body>
	<div class="container">
		<h1>Enter Todo Details</h1>
		<form method="post">
			Description: <input type="text" name="description" /> TargetDate: <input
				type="date" name="targetDate" /> <input type="submit"
				class="btn btn-success" />
		</form>
	</div>
	<script src="/webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
	<script src="/webjars/jquery/3.7.1/jquery.min.js"></script>
</body>
</html>