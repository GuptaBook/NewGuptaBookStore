<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Books</title>
</head>
<body><c:url value="AuthorServlet" var="url"/>

          <c:forEach items="${booksList}" var="book">
  <a href="<c:url value="FetchBookByIdServlet?id=${book.getBookid()}"/>" class="btn btn-info"><img src="<c:url value="resources/images/${book.getBookid()}.png"/>" alt="noimg"/>
		       
		       ${book.bookname}
		       ${book.bookdesc}</a><br>
          </c:forEach>    
          
          
  
</body>
</html>