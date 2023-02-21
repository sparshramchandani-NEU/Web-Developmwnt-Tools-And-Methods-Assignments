<%-- 
    Document   : login
    Created on : Feb 19, 2023, 4:51:02 PM
    Author     : sparshramchandani
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <form action="j_security_check" method="post">
            Username<input type ='text' name='j_username'>
            Password <input type="password" name ="j_password">
            <input type="submit" value="Submit">
        </form>

    </body>
</html>
