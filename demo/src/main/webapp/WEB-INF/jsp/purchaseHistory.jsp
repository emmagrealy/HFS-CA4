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
				<li class="nav-item"><a class="nav-link" href="addProduct">Add
						Products</a></li>
				<li class="nav-item"><a class="nav-link" href="#">Search
						Products</a></li>
				<li class="nav-item"><a class="nav-link" href="customerDetails">All
						Customers Registered</a></li>
			</ul>
			<ul class="navbar-nav ml-auto">
				<li class="nav-item"><a class="nav-link" href="/logout">Logout</a></li>
			</ul>
		</div>
	</nav>

	<div class="container text-center">
		<br>
		<h3>Customer Details</h3>
		<hr>
	</div>

	<table align="center" cellpadding="5" cellspacing="5" border="1">
		<tr bgcolor="#FFAC9A">
			<td><b>Customer ID</b></td>
			<td><b>First Name</b></td>
			<td><b>Surname</b></td>
			<td><b>Date Of Birth</b></td>
			<td><b>Username</b></td>
			<td><b>Shipping Address</b></td>
			<td><b>Chosen Payment Method</b></td>
			<td><b>Loyalty Card Type</b></td>
		</tr>
		<tr>
			<td>${sessionScope.viewCust.userId }</td>
			<td>${sessionScope.viewCust.firstName }</td>
			<td>${sessionScope.viewCust.lastName }</td>
			<td>${sessionScope.viewCust.dob }</td>
			<td>${sessionScope.viewCust.username }</td>
			<td>${sessionScope.viewCust.shippingAddress }</td>
			<td>${sessionScope.viewCust.paymentMethod }</td>
			<td>${sessionScope.viewCust.loyaltyCard }</td>
		</tr>
	</table>

	<div class="container text-center">
		<hr>
		<h3>Purchase History</h3>
		<hr>
	</div>

	<table align="center" cellpadding="5" cellspacing="5" border="1">
		<c:forEach var="hist" items="${sessionScope.purchHist}">
			<tr bgcolor="#FFAC9A">
				<td><b>Order Number</b></td>
				<td><b>Total Price</b></td>
			</tr>
			<tr>
				<td><c:out value="${hist.orderId }" /></td>
				<td><c:out value="${hist.totalPrice }" /></td>
			</tr>
			<tr>
				<td><b>Product Name</b></td>
				<td><b>Manufacturer</b></td>
				<td><b>Price</b></td>
				<td><b>Category</b></td>
				<td><b>Image</b></td>
			</tr>
			<c:forEach var="histItem" items="${hist.products }">
				<tr>
					<td><c:out value="${histItem.title }" /></td>
					<td><c:out value="${histItem.manufacturer }" /></td>
					<td><c:out value="${histItem.price }" /> Euro</td>
					<td><c:out value="${histItem.category }" /></td>
					<td><img src="images/${histItem.image }" height="50"
						width="40" /></td>
				</tr>
			</c:forEach>

		</c:forEach>
	</table>


	<script src="static/js/jquery.min.js"></script>
	<script src="static/js/bootstrap.js"></script>
	<script src="static/js/npm.js"></script>
</body>
</html>