<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:url value="SubjectServlet" var="url"/>

          <c:forEach items="${booksList}" var="book">
  <a href="<c:url value="FetchBookByIdServlet?id=${book.getBookid()}"/>" class="btn btn-info"><img src="<c:url value="resources/images/${book.getBookid()}.png"/>" alt="noimg"/>
		       
		       ${book.bookname}
		       ${book.bookdesc}</a><br>
          </c:forEach> 

</body>
</html>