<%-- 
    Document   : index.jsp
    Created on : Feb 14, 2023, 6:46:50 PM
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
        <h1>Welcome to Our Movie Store</h1>
        <h3>Please make your selection below</h3>
     <form action="MovieController" method="post">
         <select name='selection'>
             <option value ='Browse Movies'>Browse Movies</option>
             <option value ='Add New Movies to Database'>Add New Movies to Database</option>
         </select>
      <input type="submit" value="Submit">
    </form>
    </body>
</html>
