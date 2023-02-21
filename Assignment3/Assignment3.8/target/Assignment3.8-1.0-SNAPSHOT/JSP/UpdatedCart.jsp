<%-- 
    Document   : UpdatedCart
    Created on : Feb 20, 2023, 7:58:59 PM
    Author     : sparshramchandani
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:forEach items="${sessionScope.booksList1}" var="i">
            <p>${i.title}</p>
        </c:forEach>
    </body>
</html>
