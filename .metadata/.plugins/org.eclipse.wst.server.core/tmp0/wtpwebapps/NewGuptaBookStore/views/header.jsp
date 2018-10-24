<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!-- <<<<<<< HEAD -->
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- =======
>>>>>>> c517d0cbb4490a2fd7979affcd25d0cce5676a49 -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<c:if test="${sessionScope.email!=null }"><h3 align="center">Hi ${sessionScope.email}</h3></c:if>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">Gupta Book Store</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="<c:url value='home.jsp'/>">Home</a></li>
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Author <span class="caret"></span></a>
        <ul class="dropdown-menu">
        <c:forEach items="${sessionScope.listAuthor}" var="auth">
          <li><a href="<c:url value='FetchBookByAuthor?id=${auth.authid}'/>" >${auth.authname}</a></li>
        </c:forEach>        
        </ul>
      </li>
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Subject <span class="caret"></span></a>
        <ul class="dropdown-menu">
        <c:forEach items="${sessionScope.listSubject}" var="sub">
          <li><a href="<c:url value='/FetchBookBySubject?id=${sub.subid}'/>" >${sub.subname}</a></li>
        </c:forEach>        
        </ul>
      </li><c:url value="FetchAllBookServlet" var="url"/>
      <li><a href="${url}">Books</a></li><c:url value="/FetchBookBySearchServlet" var="url"/>
      <li><form class="navbar-form" action="${url }">
        <div class="form-group" style="display:inline;">
          <div class="input-group">
            <input type="text" class="form-control" name="name" placeholder="search by book name">
            <span class="input-group-addon"><button class="glyphicon glyphicon-search"></button></span>
          </div>
        </div>
      </form></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
    <c:if test="${sessionScope.email!=null }">
    <c:if test="${sessionScope.rolename=='ROLE_USER' }">
    <li><a href="<c:url value='/FetchCartServlet'/>"><span class="glyphicon glyphicon-shopping-cart"></span></a></li></c:if>
    <li><a href="<c:url value='/views/logout.jsp'/>"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
    </c:if>
    <c:if test="${sessionScope.email==null }">
      <li><a href="<c:url value='/views/customer/CustRegis.jsp'/>"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
      <li><a href="<c:url value='/views/emp/LoginPage.jsp'/>"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
      </c:if>
    </ul>
  </div>
</nav>
<!-- ======= -->

</head>
<body>
<!-- >>>>>>> c517d0cbb4490a2fd7979affcd25d0cce5676a49 -->

</body>
</html>