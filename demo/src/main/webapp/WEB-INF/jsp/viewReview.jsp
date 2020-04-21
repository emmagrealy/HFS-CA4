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
				<li class="nav-item"><a class="nav-link" href="searchProducts">Search
						Products</a></li>
				<li class="nav-item"><a class="nav-link" href="myCart">My
						Cart</a></li>
			</ul>
			<ul class="navbar-nav ml-auto">
				<li class="nav-item"><a class="nav-link" href="/logout">Logout</a></li>
			</ul>
		</div>
	</nav>

	<div class="container text-center">
		<br>
		<h3>Product Review</h3>
		<hr>
	</div>

	<table>
		<tr>
			<td width="100">&nbsp</td>
			<td width="200"><img src="images/${sessionScope.reviewItem.image}"
				height="200" width="180" /><br> <c:out
					value="${sessionScope.reviewItem.title}" /><br> Manufacturer: <c:out
					value="${sessionScope.reviewItem.manufacturer}" /><br> Category: <c:out
					value="${sessionScope.reviewItem.category}" /><br> Price: €<c:out
					value="${sessionScope.reviewItem.price}" /><br></td>
			<td width="100">&nbsp</td>
		</tr>
	</table>

	<sql:setDataSource var="con" driver="com.mysql.jdbc.Driver"
		url="jdbc:mysql://localhost:3306/storeDb" user="root" password="root" />
	<sql:query dataSource="${con }"
		sql="select * from reviews A inner join stock_item_reviews B on A.id = B.reviews_id 
	where stock_item_item_id = ${sessionScope.reviewItem.itemId }"
		var="review" />
	
	<hr>
	Reviews:
	<hr>

	<table>
		<c:forEach var="r" items="${review.rows}">
			<td width="100">&nbsp</td>
			<td width="200">
				Comment: <c:out value="${r.comment}" /><br> 
				Rating: <c:out value="${r.rating}" /><br> 
			</td>
			<td width="100">&nbsp</td>
		</c:forEach>
	</table>

	<script src="static/js/jquery.min.js"></script>
	<script src="static/js/bootstrap.js"></script>
	<script src="static/js/npm.js"></script>
</body>
</html>