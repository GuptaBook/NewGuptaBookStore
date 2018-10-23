<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert Subject</title>
</head>
<body>
	<c:url value="/SubjectServlet" var="url" />
	<form action="${url}" method="post">
		Subject Name<input type="text" name="subname"><br>
		Subject Description<input type="text" name="subdesc"><br> <input
			type="submit" value="submit">
	</form>
	<table>

		<thead>
			<tr>
				<th>id</th>
				<th>name</th>
				<th>description</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${listSubject}" var="list">
				<tr>
					<td>${list.subid}</td>
					<td>${list.subname}</td>
					<td>${list.subdescription}</td>
				</tr>
			</c:forEach>
		</tbody>

	</table>

</body>
</html>