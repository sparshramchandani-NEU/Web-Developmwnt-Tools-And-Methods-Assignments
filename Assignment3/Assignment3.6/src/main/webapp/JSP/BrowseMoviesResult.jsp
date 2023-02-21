<%-- 
    Document   : BrowseMoviesResult
    Created on : Feb 15, 2023, 10:49:44 AM
    Author     : sparshramchandani
--%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Movie Results</title>
    </head>
    <body>
        <table border="1px solid black">
            <tr> 
                <th>
                    <h2>Search Results</h2>
                </th>
            </tr>
            <tr>
                <td>Title</td>
                <td>Actor</td>
                <td>Actress</td>
                <td>Genre</td>
                <td>Year</td>
                
            </tr>
            <tr> 
            <td>
            <c:forEach items="${requestScope.titleArray}" var="item">
                ${item} <br/> 
            </c:forEach>
            </td>
            <td> 
            <c:forEach items="${requestScope.actorArray}" var="item">
                ${item} <br/> 
            </c:forEach>
            </td>
            <td> 
            <c:forEach items="${requestScope.actressArray}" var="item">
                ${item} <br/> 
            </c:forEach>
            </td>
            <td> 
            <c:forEach items="${requestScope.genreArray}" var="item">
                ${item} <br/> 
            </c:forEach>
            </td>
            <td> 
            <c:forEach items="${requestScope.yearArray}" var="item">
                ${item} <br/> 
            </c:forEach>
            </td>
            </tr>
</table>
        <a href="index.jsp">Click here to go to the Home Page</a>
    </body>
</html>
