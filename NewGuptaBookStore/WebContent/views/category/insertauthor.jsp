<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head><%@ include file="../header.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert Author</title>
</head>
<body>
	<c:url value="/AuthorServlet" var="url" />
	<form action="${url}" method="post">
		Author Name<input type="text" name="authname"><br> Author
		Description<input type="text" name="authdesc"><br> <input
			type="submit" value="submit">
	</form>
		<table border="2" align="center">
		<thead>
			<tr>
				<th>id</th>
				<th>name</th>
				<th>description</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${listAuthor}" var="list">
				<tr>
					<td>${list.authid}</td>
					<td>${list.authname}</td>
					<td>${list.authdesc}</td>
				</tr>
			</c:forEach>
		</tbody>

	</table>
</body>
</html>