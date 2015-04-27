<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="/ChocolateStore/resources/css/csRegister.css">
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script src="/ChocolateStore/resources/javaScript/csRegister.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
</head>
<body>

	<%@ include file="csHeader.jsp"%>

	
	<div id="border">
	<h2>Register</h2>
		<sf:form role="form" method="post" modelAttribute="user" action="registerUser">
			<div class="form-group">
				<label>EMAIL</label>
				<sf:input type="email" path="email" class="form-control" placeholder="email address" />
			</div>
			<div class="form-group">
				<label>Street Address</label>
				<sf:input type="text" class="form-control" path="address" placeholder="password" />
			</div>
			<div class="form-group">
				<label>Password</label>
				<sf:input id="pwd" type="password" class="form-control" path="password" placeholder="password" />
			</div>
			<div class="form-group">
				<label>Confirm Password</label>
				<input id="confPwd" type="password" class="form-control" placeholder="confirmPassword" />
			</div>
			<input id="submitBtn" type="submit" class="btn btn-default" value="Register" />
		</sf:form>
	</div>

	<%@ include file="csFooter.jsp"%>

</body>
</html>