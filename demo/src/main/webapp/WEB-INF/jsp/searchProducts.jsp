<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
				<li class="nav-item"><a class="nav-link" href="searchProducts">Search
						Products</a></li>
				<li class="nav-item"><a class="nav-link" href="#">My Cart</a></li>
				<li class="nav-item"><a class="nav-link" href="#">About</a></li>
			</ul>
			<ul class="navbar-nav ml-auto">
				<li class="nav-item"><a class="nav-link" href="/logout">Logout</a></li>
			</ul>
		</div>
	</nav>

	<form class="form-horizontal" method="post" action="search"
		style="text-align: center;">
		<br>
		<b>What would you like to Search by?</b><br>
		<input type="checkbox" name="category" value="Category"><b>Category</b> 
		<input type="checkbox" name="manufacturer" value="Manufacturer"><b>Manufacturer</b>
		<input type="checkbox" name="title" value="Title"><b>Title</b>
		
		<div class="form-group">
			<div class="col-md-offset-4">
				<br> <label class="col-md-2 control-label"><b>Enter
						Search Query</b></label><br>
				<div class="col-md-3 container">
					<input type="text" class="form-control" name="searchQ" />
				</div>
			</div>
		</div>
		<div class="form-group">
			<input type="submit" class="btn btn-secondary" value="Search" />
		</div>
	</form>

	<script src="static/js/jquery.min.js"></script>
	<script src="static/js/bootstrap.js"></script>
	<script src="static/js/npm.js"></script>
</body>
</html>