<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head><%@include file="../header.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>${bookdetail} update form</title>
</head>
<body>
<form action="UpdateBookDetails" method="post">
		<table align="center"><input type="hidden" value="${bookdetail.bookid}" name="id">
			<tr>
				<td>Book Name:</td>
				<td><input type="text" name="bookname" value="${bookdetail.bookname}"></td>
			</tr>
			<tr>
				<td>Book Description:</td>
				<td><textarea cols="5" rows="3" name="bookdesc">${bookdetail.bookdesc}</textarea></td>
			</tr>
			<tr>
				<td>Quantity:</td>
				<td><input type="text" name="quantity" value="${bookdetail.quantity}"></td>
			</tr>
			<tr>
				<td>Price:</td>
				<td><input type=text name="price" value="${bookdetail.price}"></td>
			</tr>
			<tr>
				<td>Subject:</td>
				<td><select name="subid"><option value="${sub.subid}">${sub.subname }</option> <c:forEach items="${sublist}" var="sl">
							<option value="${sl.subid}">${sl.subname}</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td>Author:</td>
				<td><select name="authid"><option value="${auth.authid}">${auth.authname}</option><c:forEach items="${authlist}" var="al">
							<option value="${al.authid}">${al.authname}</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td><input type="submit"></td>
			</tr>
		</table>
	</form>
</body>
</html>