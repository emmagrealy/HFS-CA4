<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Health Food Store</title>
</head>
<link href=static/css/journal/bootstrap.min.css rel="stylesheet">
<body style="background-color: #f8f9fa;;">

	<form class="form-horizontal" method="post" action="login"
		style="text-align: center;"><br>
		<c:if test="${not empty error}">
			<div class="alert alert-primary col-md-4 container">
				<c:out value="${error}"></c:out>
			</div>
		</c:if>
		<h2>Login</h2>
		<div class="form-group">
			<div class="col-md-3 container">
				<input type="text" class="form-control" name="username"
					placeholder="Username" autocomplete="off"
					value="${customer.username}" />
			</div>
		</div>
		<div class="form-group">
			<div class="col-md-3 container">
				<input type="password" class="form-control" name="password"
					placeholder="Password" value="${customer.password}" />
			</div>
		</div>
		<div class="form-group">
			<input type="submit" class="btn btn-secondary" value="Login" />
		</div>
	</form>
	<hr>

	<h2>Create an Account</h2>
	<form class="form-horizontal" method="post" action="addUser"
		style="text-align: left;">
		<%-- <input type="hidden" name="id" value="${customer.userId}" /> --%>
		<div class="form-group">
			<input type="text" class="form-control col-md-2" name="firstName"
				placeholder="First Name" autocomplete="off"
				value="${customer.firstName}" />
		</div>
		<div class="form-group">
			<input type="text" class="form-control col-md-2" name="lastName"
				placeholder="Surname" autocomplete="off"
				value="${customer.lastName}" />
		</div>
		<div class="form-group">
			<input type="text" class="form-control col-md-2" name="dob"
				placeholder="Date of Birth" autocomplete="off"
				value="${customer.dob}" />
		</div>
		<div class="form-group">
			<input type="text" class="form-control col-md-2" name="username"
				placeholder="Create a Username" autocomplete="off"
				value="${customer.username}" />
		</div>
		<div class="form-group">
			<input type="password" class="form-control col-md-2" name="password"
				placeholder="Create a Password" value="${customer.password}" />
		</div>
		<div class="form-group">
			<input type="text" class="form-control col-md-2"
				name="shippingAddress" placeholder="Shipping Address"
				value="${customer.shippingAddress}" />
		</div>
		<div class="form-group">
			<input type="text" class="form-control col-md-2" name="paymentMethod" autocomplete="off"
				placeholder="Payment Method" value="${customer.paymentMethod}" list="payments"/>
				<datalist id="payments">
					<option value="Visa Card">
					<option value="MasterCard">
					<option value="American Express">
 				</datalist>
		</div>
		<div class="form-group">
			<input type="text" class="form-control col-md-2" name="lc" autocomplete="off"
				placeholder="Loyalty Card" value="${customer.loyaltyCard}" list="lcs"/>
				<datalist id="lcs">
					<option value="No Loyalty Card">
					<option value="Basic">
					<option value="Premium">
 				</datalist>
		</div>
		<div class="form-group">
			<input type="submit" class="btn btn-secondary" value="Register" />
		</div>
	</form>

	<script src="static/js/jquery.min.js"></script>
	<script src="static/js/bootstrap.js"></script>
	<script src="static/js/npm.js"></script>

</body>
</html>