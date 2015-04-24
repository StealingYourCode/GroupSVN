<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ChocolateStore Login</title>
</head>
<body>
	<%@ include file="csHeader.jsp"%>

	<div id='main'>
		<h2>Login</h2>
		<div id='border'>
			<sf:form action="process" method="POST" modelAttribute="user" role="form">
				<div class="form-group">
					<sf:label path="email">Email address:</sf:label> 
					<sf:input type="email"	class="form-control" path="email"/>
				</div>
				<div class="form-group">
					<sf:label path="pwd">Password:</sf:label> 
					<sf:input type="password" class="form-control" path="pwd"/>
				</div>
				<input type="submit" class="btn btn-default" value="Login" />
			</sf:form>
		</div>
	</div>

	<%@ include file="csFooter.jsp"%>
</body>
</html>

<sf:form action="process" method="POST" modelAttribute="user">
	<sf:label path="username"> Username </sf:label>
	<sf:input type="text" path="username" />
	<sf:label path="password"> Password </sf:label>
	<sf:input type="password" path="password" />
	<input type="submit" value="Submit Registration" />
</sf:form>