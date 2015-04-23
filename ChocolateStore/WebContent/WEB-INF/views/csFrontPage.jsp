<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="/ChocolateStore/resources/css/csFrontPage.css">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Chocolate Store</title>
</head>
<body>

	<%@ include file="csHeader.jsp" %>
	
	<div class="container">
	<div class="row">
		<ul class="thumbnails">
				<c:forEach var="product" items="${applicationScope.productList}">
					<li class="span4">
						<div class="thumbnail">
							<img src="/ChocolateStore/resources/images/${product.productName}.jpg"
								alt="Snickers">
							<div class="caption">
								<h3>${product.productName}</h3>
								<p>${product.price}</p>
								<p align="center">
									<a href="cart" class="btn btn-primary btn-block">Add To Cart</a>
								</p>
							</div>
						</div>
					</li>
				</c:forEach>
        </ul>
	</div>
</div>
	<%@ include file="csFooter.jsp" %>
	
</body>
</html>