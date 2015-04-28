<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="/ChocolateStore/resources/css/csCartReview.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="csHeader.jsp"%>
		<table class="table">
		<thead>
			<tr>
				<th>Product</th>
				<th>Quantity</th>
				<th>Remove</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="product" items="${sessionScope.saleList}">
				<tr>
				
					<td>${product.product.productName}</td>
					<td>${product.quantity}</td>
					<td><form action="remove" method="GET">	
				<input name="candy" value="${product.product.productName}" hidden="true" /><button class="btn">Remove</button></form></td>
				
				</tr>
			</c:forEach>

		</tbody>
	</table>

	<div id="checkout"><a href="purchase"><button class="btn btn-info" >Checkout!</button></a></div>
		
	<div class="jumbotron">
    <h1>${success} </h1> 
    <p>${zero}</p>     
    
  </div>	
			

	<%@ include file="csFooter.jsp"%>
</body>
</html>