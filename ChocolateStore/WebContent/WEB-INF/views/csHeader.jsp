<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<header id="csHeader">
		<a href="csFrontPage"><img alt="CS_LOGO"
			src="/ChocolateStore/resources/images/logo.jpg" /></a>
<%-- 		<c:if test="${sessionScope.user != null}"> --%>
<%-- 			<span id="welcome">Welcome ${sessionScope.user.firstName}!</span> --%>
<%-- 		</c:if> --%>
<!-- 		<div id="top_right"> -->
<!-- 			<div id="call"> -->
<!-- 				<a href="#" id="callColor"> <span -->
<!-- 					class="glyphicon glyphicon-earphone"></span> Call TP 800 800 8000 -->
<!-- 				</a> -->
<!-- 			</div> -->

<!-- 			<div id="topButtons"> -->
<%-- 				<c:choose> --%>
<%-- 					<c:when test="${sessionScope.user != null}"> --%>
<!-- 						<form action="Login" method="get"> -->
<!-- 							<button id="logoutBtn" type="submit"><div class="insideBtn">Logout</div></button> -->
<!-- 						</form> -->
<%-- 					</c:when> --%>
<%-- 					<c:otherwise> --%>
<!-- 						<a href="/TradingPlatformWeb/LoginJSP"><button id="leftBtn"><div class="insideBtn">Login</div></button></a> -->
<!-- 						<a href="/TradingPlatformWeb/RegisterJSP"><button id="rightBtn"><div class="insideBtn">Register</div></button></a> -->
<%-- 					</c:otherwise> --%>
<%-- 				</c:choose> --%>
<!-- 			</div> -->
<!-- 		</div> -->

	</header>

</body>
</html>