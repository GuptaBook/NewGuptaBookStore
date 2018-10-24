<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head><%@include file="../header.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert Book</title>
</head>
<body>
	<form action="InsertBookServlet"  method="post" enctype="multipart/form-data">
		<table align="center">
			<tr>
				<td>Book Name:</td>
				<td><input type="text" name="bookname"></td>
			</tr>
			<tr>
				<td>Book Description:</td>
				<td><textarea cols="5" rows="3" name="bookdesc"></textarea></td>
			</tr>
			<tr>
				<td>Quantity:</td>
				<td><input type="text" name="quantity"></td>
			</tr>
			<tr>
				<td>Price:</td>
				<td><input type="text" name="price"></td>
			</tr>
			<tr>
				<td>Subject:</td>
				<td><select name="subid"> <c:forEach items="${sublist}" var="sl">
							<option value="${sl.subid}">${sl.subname}</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td>Author:</td>
				<td><select name="authid"><c:forEach items="${authlist}" var="al">
							<option value="${al.authid}">${al.authname}</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td>Image:</td>
				<td><input type="file" name="file"></td>
			</tr>
			<tr>
				<td><input type="submit"></td>
			</tr>
		</table>
	</form>
	<form>
	<table align="center">
	<tr><th>Book Id</th><th>Book Name</th><th>Book Description</th><th>Modification</th></tr>
	<tbody>
	<c:forEach items="${booklist}" var="bl">
	<tr>
	<td>${bl.bookid}</td>
	<td>${bl.bookname}</td>
	<td>${bl.bookdesc}</td>
	<td><a href="FetchBookByIdUpdateServlet?id=${bl.bookid}">Update</a></td>
	</tr></c:forEach>
	</tbody>
	
	</table>
	
	</form>
</body>
</html>