<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head><%@include file="../header.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Book All</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<c:forEach items="${booklist}" var="lb">
				<div class="col-md-4">
					<c:if test="${booklist == null}">
						<p>No match found</p>
					</c:if>
					<div class="thumbnail">

						<a href="FetchBookByIdServlet?id=${lb.bookid}"> 
						<img src="<c:url value='/resources/images/uploadDir/${lb.getBookid()}.png'/>"
							alt="Lights" style="width: 350px; height: 250px">
							<div class="caption"><div class="pull-right">price ${lb.price}</div>
								<p>${lb.bookname}</p>
							</div>
						</a>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
</body>
</html>