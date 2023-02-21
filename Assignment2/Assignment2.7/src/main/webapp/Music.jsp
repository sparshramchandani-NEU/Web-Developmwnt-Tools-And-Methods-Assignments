<%--
    Document   : Music
    Created on : Feb 5, 2023, 6:30:23 PM
    Author     : sparshramchandani
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.util.Arrays"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>



<!DOCTYPE html>
<html>
    <head>
        <%@include file="Includes/head.jsp"%> 
        <title>Musics Page</title>
    </head>
    <body>
        <%@include file="Includes/navbar.jsp" %>
        <%@include file="Includes/navbar1.jsp" %>
        <form method="post" action="Music.jsp">

            <div class="container" style="display: flex; justify-content: space-between; margin-top: 5%">


                <div class="card" style="width: 18rem;">

                    <div class="card-body">
                        <input type='checkbox' name='songs' value='I am going to Tell You a Secret by Madonna' /><br/>
                        <h5 class="card-title">I'm going to Tell You a Secret by Madonna</h5>
                        <p class="card-text">$26.99</p>
                    </div>
                </div>
                <div class="card" style="width: 18rem;">
                    <div class="card-body">
                        <input type='checkbox' name='songs' value='Baby One More Time by Britney Spears' /><br/>
                        <h5 class="card-title">Baby One More Time by Britney Spears</h5>
                        <p class="card-text">$10.95</p>
                    </div>
                </div>
                <div class="card" style="width: 18rem;">
                    <div class="card-body">
                        <input type='checkbox' name='songs' value='Justified by Justin Timberlake' /><br/>
                        <h5 class="card-title">Justified by Justin Timberlake</h5>
                        <p class="card-text">$9.97</p>
                    </div>
                </div>
            </div>
            <div class="container" style="display: flex;  margin-top: 5%">
                <div class="card" style="width: 18rem;margin-right:12%;">
                    <div class="card-body">
                        <input type='checkbox' name='songs' value='Loose by Nelly Furtado' /><br/>
                        <h5 class="card-title">Loose by Nelly Furtado</h5>
                        <p class="card-text">$13.98</p>
                    </div>
                </div>
                <div class="card" style="width: 18rem;">

                    <div class="card-body">
                        <input type='checkbox' name='songs' value='Gold Digger by Kayne West' /><br/>
                        <h5 class="card-title">Gold Digger by Kayne West</h5>
                        <p class="card-text">$27.99</p>
                    </div>
                </div>
            </div>
            <div style="display: flex; justify-content: center; margin-top: 5%">                         
                <button name="cart" type="submit" class="btn btn-primary">Add To Cart</button>           
            </div>
        </form>Ï
        <%@include file="Includes/footer.jsp"%> 
    </body>
</body>
</html>
<%
    String[] songs = request.getParameterValues("songs");
    if(songs!=null){
    List songsList = Arrays.asList(songs);
    session.setAttribute("Songs", songsList);
    }
    else{
    
    }
%>