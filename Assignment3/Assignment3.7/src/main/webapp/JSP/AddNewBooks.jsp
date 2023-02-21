<%-- 
    Document   : AddNewBooks
    Created on : Feb 15, 2023, 4:38:50 PM
    Author     : sparshramchandani
--%>

<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>AddNewBooks</title>
    </head>
    <body>
        <form action="BooksController" method="post">
            <table border="1">
                <tr>
                    <th>ISBN</th>
                    <th>Book Title</th>
                    <th>Authors</th>
                    <th>Price</th>
                </tr>


                <%--<c:forEach var = "i" begin = "1" end = "${requestScope.numberOfBooks}">--%>

                <c:forEach var = "j" begin = "1" end = "${requestScope.numberOfBooks}">
                    <tr>
                        <td><input type="text" name="ISBN" ></td>
                        <td><input type="text" name="bookTitle" ></td>
                        <td><input type="text" name="authors" ></td>
                        <td><input type="number" name="price" ></td>
                    </tr>
                </c:forEach>

                <%--</c:forEach>--%>

                    
            </table>
                <input type="submit" value="Submit" style="margin-top: 1%; margin-left: 20%" >
                
        </form>
    </body>
</html>
