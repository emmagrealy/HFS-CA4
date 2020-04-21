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
		<a class="navbar-brand" href="/adminSuccess">Health Food Store</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarColor01" aria-controls="navbarColor01"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarColor01">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item"><a class="nav-link" href="addProduct">Add
						Products</a></li>
				<li class="nav-item"><a class="nav-link" href="adminSearch">Search
						Products</a></li>
				<li class="nav-item"><a class="nav-link" href="customerDetails">All
						Customers Registered</a></li>
			</ul>
			<ul class="navbar-nav ml-auto">
				<li class="nav-item"><a class="nav-link" href="/logout">Logout</a></li>
			</ul>
		</div>
	</nav>
	<br>
	<div class="container text-center">
		<h2>Enter Card Details:</h2>
		<br>
		<form class="form-horizontal" method="post" action="stockPurchase"
			style="text-align: center;">
			<c:if test="${not empty error}">
				<div class="alert alert-primary col-md-4 container">
					<c:out value="${error}"></c:out>
				</div>
			</c:if>
			<div class="form-group">
				<div class="col-md-4 container">
					<input type="text" name="cardType" class="form-control"
						autocomplete="off" placeholder="Payment Method" list="payments" />
					<datalist id="payments">
						<option value="Visa Card">
						<option value="MasterCard">
						<option value="American Express">
					</datalist>
				</div>
			</div>
			<div class="form-group">
				<div class="col-md-4 container">
					<input type="text" name="cardName" class="form-control"
						placeholder="Name on Card" />
				</div>
			</div>
			<div class="form-group">
				<div class="col-md-4 container">
					<input type="number" name="cardNumber" class="form-control"
						placeholder="Card Number" />
				</div>
			</div>
			<div class="row">
				<div class="col-xs-12 col-sm-6 col-md-4"></div>
				<div class="col-xs-3 col-sm-2">
					<div class="form-group">
						<input type="number" name="expiryDateMonth" class="form-control"
							placeholder="Month" />
					</div>
				</div>
				<div class="col-xs-3 col-sm-2">
					<div class="form-group">
						<input type="number" name="expiryDateYear" class="form-control"
							placeholder="Year" />
					</div>
				</div>
			</div>
			<div class="form-group">
				<div class="col-md-4 container">
					<input type="number" name="cvv" class="form-control"
						placeholder="CVV" />
				</div>
			</div>

			<div class="form-group">
				<div class="col-md-4 container">
					<input type="text" name="quantity" placeholder="Enter Quantity"
						class="form-control"  />
				</div>
			</div>
			<div class="form-group">
				<input type="submit" class="btn btn-secondary"
					value="Complete Purchase" />
			</div>
		</form>
	</div>

	<script src="static/js/jquery.min.js"></script>
	<script src="static/js/bootstrap.js"></script>
	<script src="static/js/npm.js"></script>
</body>
</html>