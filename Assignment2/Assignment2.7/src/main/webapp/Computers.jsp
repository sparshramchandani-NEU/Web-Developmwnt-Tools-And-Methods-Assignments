<%--
    Document   : Computers
    Created on : Feb 5, 2023, 6:30:31 PM
    Author     : sparshramchandani
--%>

<%@page import="java.util.List"%>
<%@page import="java.util.Arrays"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
    <head>
        <%@include file="Includes/head.jsp"%> 
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="Includes/navbar.jsp" %>
        <%@include file="Includes/navbar1.jsp" %>
        <form method="post" action="Computers.jsp">

            <div class="container" style="display: flex; justify-content: space-between; margin-top: 5%">


                <div class="card" style="width: 18rem;">

                    <div class="card-body">
                        <input type='checkbox' name='computers' value='Apple MAcBook Pro with 13.3" Display' /><br/>
                        <h5 class="card-title">Apple MAcBook Pro with 13.3" Display</h5>
                        <p class="card-text">$1299.99</p>
                    </div>
                </div>
                <div class="card" style="width: 18rem;">
                    <div class="card-body">
                        <input type='checkbox' name='computers' value='Asus Laptop with Centimo 2 Black' /><br/>
                        <h5 class="card-title">Asus Laptop with Centimo 2 Black</h5>
                        <p class="card-text">$949.95</p>
                    </div>
                </div>
                <div class="card" style="width: 18rem;">
                    <div class="card-body">
                        <input type='checkbox' name='computers' value='HP Pavilion Laptop' /><br/>
                        <h5 class="card-title">HP Pavilion Laptop</h5>
                        <p class="card-text">$1199.95</p>
                    </div>
                </div>
            </div>
            <div class="container" style="display: flex;  margin-top: 5%">
                <div class="card" style="width: 18rem;margin-right:12%;">
                    <div class="card-body">
                        <input type='checkbox' name='computers' value='Toshiba Satellite Laptop' /><br/>
                        <h5 class="card-title">Toshiba Satellite Laptop</h5>
                        <p class="card-text">$899.99</p>
                    </div>
                </div>
                <div class="card" style="width: 18rem;">

                    <div class="card-body">
                        <input type='checkbox' name='computers' value='Sony VAIO Laptop' /><br/>
                        <h5 class="card-title">Sony VAIO Laptop</h5>
                        <p class="card-text">$779.99</p>
                    </div>
                </div>
            </div>
            <div style="display: flex; justify-content: center; margin-top: 5%">                         
                <button name="cart" type="submit" class="btn btn-primary">Add To Cart </button>           
            </div>
        </form>Ï
        <%@include file="Includes/footer.jsp"%> 
    </body>
</body>
</html>
<%
    String[] computers = request.getParameterValues("computers");
            if(computers!=null){
            List computersList = Arrays.asList(computers);
             session.setAttribute("Computers", computersList);
            }else{
            
            }
%>