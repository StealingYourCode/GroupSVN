<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%@ include file="csHeader.jsp"%>

	<h2>Request</h2>
	<div id='border'>
		<sf:form role="form" method="post" modelAttribute="user" action="/register">
			<div class="form-group">
				<sf:label path="email">EMAIL</sf:label>
				<sf:input type="email" path="email" class="form-control" placeholder="PRICE" />
			</div>
			<div class="form-group">
				<sf:label path="password">Password</sf:label>
				<sf:input type="password" class="form-control" path="password" placeholder="password" />
			</div>
			<div class="form-group">
				<sf:label path="confirmPassword">Confirm Password</sf:label>
				<sf:input type="passowrd" class="form-control" path="confirmPassword" placeholder="confirmPassword" />
			</div>
			<input type="submit" class="btn btn-default" value="Register" />
		</sf:form>
	</div>

	<%@ include file="csFooter.jsp"%>

</body>
</html>