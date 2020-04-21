<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
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
		<h2>Add a Product to Stock</h2>
	</div>
	<form class="form-horizontal" method="post" action="addStockItem"
		style="text-align: center;">
		<%-- <input type="hidden" name="id" value="${customer.userId}" /> --%>
		<div class="form-group">
			<div class="col-md-offset-4">
				<div class="col-md-3 container">
					<input type="text" class="form-control" name="title"
						placeholder="Product Title" autocomplete="off"
						value="${stockItem.title}" />
				</div>
			</div>
		</div>
		<div class="form-group">
			<div class="col-md-offset-4">
				<div class="col-md-3 container">
					<input type="text" class="form-control" name="manufacturer"
						placeholder="Product Manufacturer" autocomplete="off"
						value="${stockItem.manufacturer}" />
				</div>
			</div>
		</div>
		<div class="form-group">
			<div class="col-md-offset-4">
				<div class="col-md-3 container">
					<input type="text" class="form-control" name="price"
						placeholder="Product Price" autocomplete="off"
						value="${stockItem.price}" />
				</div>
			</div>
		</div>
		<div class="form-group">
			<div class="col-md-offset-4">
				<div class="col-md-3 container">
					<input type="text" class="form-control" name="category"
						placeholder="Product Category" autocomplete="off"
						value="${stockItem.category}" />
				</div>
			</div>
		</div>
		<div class="form-group">
			<div class="col-md-offset-4">
				<div class="col-md-3 container">
					<input type="text" class="form-control" name="quantity"
						placeholder="Product Quantity" autocomplete="off"
						value="${stockItem.quantity}" />
				</div>
			</div>
		</div>
		<div class="form-group">
			<div class="col-md-offset-4">
				<div class="col-md-3 container">
					<input type="file" class="form-control" name="image"
						value="${stockItem.image}" />
				</div>
			</div>
		</div>
		<div class="form-group">
			<input type="submit" class="btn btn-secondary" value="Add Product" />
		</div>
	</form>


	<script src="static/js/jquery.min.js"></script>
	<script src="static/js/bootstrap.js"></script>
	<script src="static/js/npm.js"></script>

</body>
</html>