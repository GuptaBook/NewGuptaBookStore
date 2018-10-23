<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:url value="CommentServlet" var="url" />
	<a href="<c:url value = "views/comment/comment.jsp"/>"></a> ${url }
<h1>Comment Details</h1>
<table border="1">
<thead>
<tr>
<td>Customer Name</td>
<td>Content</td>
</tr>
</thead>

<tbody>
<c:forEach items="${commentList}" var="commentList"><tr>
<td>${commentList.customerName}</td>
<td>${commentList.content}</td>
</c:forEach>
</tbody>

</table>
</body>
</html>