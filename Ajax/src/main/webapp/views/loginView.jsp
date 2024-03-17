<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<p style="color: red;">${errors}</p>
	<form method="POST" action="login">
		Tai khoan: <input type="text" name="userName" value="${loginForm.username}"/>
		Mat Khau: <input type="password" name="password" value="${loginForm.password}"/>
		<input type="submit" value="Dang nhap"/>
		<a href="">Bo qua</a>
	</form>
</body>
</html>