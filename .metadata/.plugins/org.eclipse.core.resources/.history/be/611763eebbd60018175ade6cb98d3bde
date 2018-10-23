<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head><%@include file="../header.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modification page</title>
</head>
<body>
<table align="center">
<tr><th>Book Name</th><th>Book Description</th><th>Quantity</th><th>Price</th><th>Modification</th></tr>
<c:forEach items="${booklist}" var="book">
<tr>
<td>${book.bookname}</td>
<td>${book.bookdesc}</td>
<td>${book.quantity}</td>
<td>${book.price}</td>
<td><a href="ApproveBookServlet?id=${book.bookid}" class="btn btn-info">Approve</a>&nbsp;<a class="btn btn-info" href="RejectBookServlet?id=${book.bookid}">Reject</a></td>
</tr>
</c:forEach>
<tr></tr>
</table>
</body>
</html>