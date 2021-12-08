<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">

<title>Save Cutomer Details</title>
</head>

<body>

	<div class="container">

		<h3>Add or Update Customer Details</h3>
		<hr>

		<p class="h4 mb-4">Customer Details</p>

		<form action="/CRM/customer/save" method="POST">

			<!-- Add hidden form field to handle update -->
			<input type="hidden" name="id" value="${Customers.id}" />

			<div class="form-inline">
				<input type="text" name="firstname" value="${Customers.firstName}"
					class="form-control mb-4 col-4" placeholder="First Name">



			</div>

			<div class="form-inline">

				<input type="text" name="lastname" value="${Customers.lastName}"
					class="form-control mb-4 col-4" placeholder="Last Name">



			</div>

			<div class="form-inline">

				<input type="text" name="email" value="${Customers.email}"
					class="form-control mb-4 col-4" placeholder="Email">



			</div>

			<button type="submit" class="btn btn-info col-2">Save</button>

		</form>

		<hr>
		<a href="/CRM/customer/list">Back to Customer Details List</a>

	</div>
</body>

</html>










