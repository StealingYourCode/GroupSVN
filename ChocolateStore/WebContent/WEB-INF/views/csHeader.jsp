<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="/ChocolateStore/resources/css/csHeader.css" >
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Header</title>
</head>
<body>
	<header id="csHeader">
		<a id="logo" href="csFrontPage"><img alt="CS_LOGO"
			src="/ChocolateStore/resources/images/logo.jpg" /> </a>
				<div id="topButtons">
				<c:choose>
					<c:when test="${sessionScope.loggedIn != null}">
						<form action="Login" method="get">
						${sessionScope.loggedIn.email}
							<a href="logout"><button id="logoutBtn" type="submit"><div class="insideBtn">Logout</div></button></a>
						</form>
					</c:when>
					<c:otherwise>
						<a href="csLogin"><button id="leftBtn"><div class="insideBtn">Login</div></button></a>
						<a href="csRegister"><button id="rightBtn"><div class="insideBtn">Register</div></button></a>
					</c:otherwise>
				</c:choose>
			</div>
		<a id="cart" href="csCartReview" class="btn btn-info btn-lg"> 
		<span class="glyphicon glyphicon-shopping-cart"></span> Shopping Cart  ${cartQty}
		</a>
		
	</header>

</body>
</html> 