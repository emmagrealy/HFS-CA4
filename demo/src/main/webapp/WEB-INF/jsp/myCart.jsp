<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Health Food Store</title>
</head>
<link href=static/css/journal/bootstrap.min.css rel="stylesheet">
<body>

	<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
		<a class="navbar-brand" href="/successPage">Health Food Store</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarColor01" aria-controls="navbarColor01"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarColor01">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item"><a class="nav-link" href="searchProducts">Search Products</a></li>
				<li class="nav-item"><a class="nav-link" href="myCart">My Cart</a></li>
			</ul>
			<ul class="navbar-nav ml-auto">
				<li class="nav-item"><a class="nav-link" href="/logout">Logout</a></li>
			</ul>
		</div>
	</nav>

	<div class="container text-center">
		<br>
		<h3>${sessionScope.customer.firstName }'s Cart</h3>
		<hr>
		Cart Quantity: ${sessionScope.quantity } Items<br>
		Total Cost: €${sessionScope.totalPrice } <br>
		<form class="form-horizontal" method="post" action="purchase">
			<input type="submit" class="btn btn-secondary" value="Purchase Items" />
		</form>
		<hr>
	</div>

	<table>
		<c:forEach var="cartObj" items="${sessionScope.list}" varStatus="status">
			<c:if test="${not status.first and status.index % 4 == 0}">
				<tr>
			</c:if>
			<td width="100">&nbsp</td>
			<td width="200">
				<img src="images/${cartObj.image}" height="200" width="180" /><br> 
				<c:out value="${cartObj.title}" /><br>
				Manufacturer: <c:out value="${cartObj.manufacturer}" /><br>
				Category: <c:out value="${cartObj.category}" /><br> 
				Price: €<c:out value="${cartObj.price}" /><br> 
				<br><br>
			</td>
			<td width="100">&nbsp</td>
			<c:if test="${status.first and status.index % 4 == 4 or status.last}">
				</tr>
			</c:if>
		</c:forEach>
	</table>

	<script src="static/js/jquery.min.js"></script>
	<script src="static/js/bootstrap.js"></script>
	<script src="static/js/npm.js"></script>
</body>
</html>