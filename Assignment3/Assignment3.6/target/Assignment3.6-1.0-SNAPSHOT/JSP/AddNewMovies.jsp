<%-- 
    Document   : AddNewMovies
    Created on : Feb 14, 2023, 7:04:19 PM
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
        <h1>Please Enter the Details Below</h1>
        <form method="post" action="MovieController" >
            <div style="display:flex" >
                <p style="padding-right: 2%; width: 10% ">Movie Title :</p>
                <input style='height: 20px; margin-top: 0.75%' type='text' name='movieTitle'>
            </div>
            <div style="display:flex" >
                <p style="padding-right: 2%; width: 10% ">Lead Actor :</p>
                <input style='height: 20px; margin-top: 0.75%' type='text' name='leadActor'>
            </div>
            <div style="display:flex" >
                <p style="padding-right: 2%; width: 10% ">Lead Actress :</p>
                <input style='height: 20px; margin-top: 0.75%' type='text' name='leadActress'>
            </div>
            <div style="display:flex" >
                <p style="padding-right: 2%; width: 10% ">Genre :</p>
                <input style='height: 20px; margin-top: 0.75%' type='text' name='genre'>
            </div>
            <div style="display:flex" >
                <p style="padding-right: 2%; width: 10% ">Year :</p>
                <input style='height: 20px; margin-top: 0.75%' type='number' name='year'>
            </div>
            <input type="submit" value="Submit">
            
            
        </form>
    </body>
</html>
