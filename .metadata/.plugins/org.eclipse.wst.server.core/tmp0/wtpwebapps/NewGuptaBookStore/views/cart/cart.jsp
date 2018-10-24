<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cart Page</title><%@ include file="../header.jsp" %>
</head>
<body>
	<c:url value="" var="url" />
	<a href="<c:url value = "views/cart/cart.jsp"/>"></a> ${url }
	<h1>Cart Details</h1>
	<table border="2" align="center">
		<thead>
			<tr>
				<td>Cart Id</td>
				<td>Book Id</td>
				<td>Book Name</td>
				<td>Quantity</td>
				<td>Price</td>
				<td>Modification</td>
			</tr>
		</thead>
<a href="DeleteAllCartServlet" class="btn btn-info">Clear All</a>
		<tbody>
			<c:forEach items="${cartList}" var="cart">
				<tr>
					<td>${cart.cartId}</td>
					<td>${cart.bookId}</td>
					<td>${cart.bookName}</td>
					<td>${cart.quantity}</td>
					<td>${cart.price}</td>
					<td><a class="btn btn-info" href="DeleteCartServlet?id=${cart.cartId }"><span align="center" class="glyphicon glyphicon-trash"></span></a></td>
					<c:set var="currentPrice" value="${cart.price+currentPrice }"/> 
				</tr>
			</c:forEach>
			<tr><td colspan="4" align="center">TotalPrice</td><td colspan="2">${currentPrice}</td></tr>
		</tbody>
		<tfoot>
			<!-- <td>Total no of records: 1</td>
 </tfoot>-->
	</table>
</body>
</html>