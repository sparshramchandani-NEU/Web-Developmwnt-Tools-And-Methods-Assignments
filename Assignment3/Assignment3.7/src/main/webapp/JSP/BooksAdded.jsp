<%-- 
    Document   : BooksAdded
    Created on : Feb 15, 2023, 8:11:06 PM
    Author     : sparshramchandani
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1><c:out value="${requestScope.numberOfBooks} Books added Successfully"/></h1>
        <a href="index.jsp">Click Here to go to Home Page</a>
    </body>
</html>
