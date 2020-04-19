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
		<h3>All Registered Users</h3>
		<hr>
	</div>

	<table align="center" cellpadding="5" cellspacing="5" border="1">
		<tr bgcolor="#FFAC9A">
			<td><b>Customer ID</b></td>
			<td><b>First Name</b></td>
			<td><b>Surname</b></td>
			<td><b>Full Details and Purchase History</b></td>
		</tr>
		<c:forEach var="cust" items="${sessionScope.allCust}">
			<tr>
				<td><c:out value="${cust.userId}" /></td>
				<td><c:out value="${cust.firstName}" /></td>
				<td><c:out value="${cust.lastName}" /></td>
				<td><form class="form-horizontal" style="text-align:center" method="post" action="viewMore">
						<div class="form-group">
							<input type="hidden" name="userId" value="${cust.userId }" />
							<input type = "submit" value="More Details" />
						</div>
					</form>
				</td>
			</tr>
		</c:forEach>
	</table>

	<script src="static/js/jquery.min.js"></script>
	<script src="static/js/bootstrap.js"></script>
	<script src="static/js/npm.js"></script>
</body>
</html>