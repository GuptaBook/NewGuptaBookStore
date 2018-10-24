<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>comment form</title>

</head>

<body>
	<c:url value="" var="url" />
	<a href="<c:url value = "/views/comment/commentform.jsp"/>"></a> ${url }
	<div class="container">
	<h1>Comments</h1>
	</div>
	<form action="../../CommentServlet" method="post">
	<div class="container">
		<div class="row">
			<div class="col-md-4"></div>
			<div class="col-md-4"></div>
		</div>
		</div>
		<div class="container">
		<div class="form-group">
			<label for="content">Content:</label> <input type="text"
				class="form-control" id="content" name="content">
		</div>
</div>
<div class="container">
		<div class="form-group">
			<label for="customername">Customer Name:</label> <input type="text"
				class="form-control" id="customername" name="customername">
		</div>
		</div>
		<div class="container">
		<button type="submit" class="btn btn-default">Submit</button>
		<div class="col-md-4"></div>
		</div>
	</form>
</body>

</html>