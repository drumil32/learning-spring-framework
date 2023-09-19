<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<h1>Login</h1>
		<pre>${error}</pre>
		<form method="post">
			Name: <input type="text" name="name" /> Password: <input
				type="password" name="password" /> <input type="submit" />
		</form>
	</div>
</body>
</html>