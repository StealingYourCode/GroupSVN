<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="/ChocolateStore/resources/css/csLogin.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ChocolateStore Login</title>
</head>
<body>
	<%@ include file="csHeader.jsp"%>

	
		
		<div id="border">
		<h2>Login</h2>
			<form action="process" method="POST" role="form">
				<div class="form-group">
					<label>Email address:</label> 
					<input type="email"class="form-control" name="email"/>
				</div>
				<div class="form-group">
					<label >Password:</label> 
					<input type="password" class="form-control" name="password"/>
				</div>
				<input type="submit" class="btn btn-default" value="Login"/>
			</form>
		</div>
	

	<%@ include file="csFooter.jsp"%>
</body>
</html>

