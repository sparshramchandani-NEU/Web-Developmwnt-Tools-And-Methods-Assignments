<%-- 
    Document   : index
    Created on : Feb 15, 2023, 2:13:08 PM
    Author     : sparshramchandani
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>How Many Books do you want to add?</h1>
        <form action="BooksController" method="post">
            <input type="number" name="numberOfBooks">
            <input type="submit" value="Submit">
        </form>
    </body>
</html>
