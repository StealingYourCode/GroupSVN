<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="csHeader.jsp"%>


	<div class="container">

		<table class="table">
			<thead>
				<tr>
					<th>Product</th>
					<th>Quantity</th>
					<th>Remove</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<c:forEach var="product" items="${sessionScope.saleList}">
						<td>${product.product.productName}</td>
						<td>${product.quantity}</td>
						<td>Remove</td>
					</c:forEach>
				</tr>

			</tbody>
		</table>
	</div>



	<%@ include file="csFooter.jsp"%>
</body>
</html>