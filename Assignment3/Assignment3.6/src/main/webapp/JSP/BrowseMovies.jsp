<%-- 
    Document   : BrowseMovies.jsp
    Created on : Feb 14, 2023, 7:03:53 PM
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
        <h1>Serching Movies</h1>
        <form method='post' action='MovieController'>
        <div style="display: flex">
            <p style='padding-right: 5%'>Keyword :</p>
            <input style='height: 20px; margin-top: 0.75%' type='text' name='keyWord'>
        </div>
            <input type='radio' name='selectionKey' value="title">Search By Title <br>
            <input type='radio' name='selectionKey' value="actor">Search By Actor <br>
            <input type='radio' name='selectionKey' value="actress">Search By Actress <br>
            
            <input type='radio' name='selectionKey' value="all">Show All Movies <br>
            
            <input type="submit" value="Search Movies">
         </form>
    </body>
</html>
