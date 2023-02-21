
<%@page import="java.security.Principal"%>
<%--
Document   : Books
    Created on : Feb 5, 2023, 6:30:16 PM
    Author     : sparshramchandani
--%>

<%@page import="java.util.List"%>
<%@page import="java.util.Arrays"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="Includes/head.jsp"%> 
        <title>Books Page</title>
    </head>
    <body>
        <%@include file="Includes/navbar.jsp" %>
        <%@include file="Includes/navbar1.jsp" %>
        
        <%
            HttpSession session1 = request.getSession(false);
    if (session1 == null || session1.getAttribute("user") == null) {
      response.sendRedirect("/Assignment2.7/login");
      return;
    }
//    String userInRole = session.getAttribute("username").toString();
//    Principal principal = request.getUserPrincipal();
//    if (!request.isUserInRole(userInRole)) {
//      response.sendError(HttpServletResponse.SC_FORBIDDEN);
//      return;
//    }
        %>
        <form method="post" action="Books.jsp">

            <div class="container" style="display: flex; justify-content: space-between; margin-top: 5%">


                <div class="card" style="width: 18rem;">

                    <div class="card-body">
                        <input type='checkbox' name='books' value='Java Servlet Programming' /><br/>
                        <h5 class="card-title">Java Servlet Programming</h5>
                        <p class="card-text">$29.95</p>
                    </div>
                </div>
                <div class="card" style="width: 18rem;">
                    <div class="card-body">
                        <input type='checkbox' name='books' value='Oracle Database Programming' /><br/>
                        <h5 class="card-title">Oracle Database Programming</h5>
                        <p class="card-text">$48.95</p>
                    </div>
                </div>
                <div class="card" style="width: 18rem;">
                    <div class="card-body">
                        <input type='checkbox' name='books' value='System Analysis and Design with UML' /><br/>
                        <h5 class="card-title">System Analysis and Design with UML</h5>
                        <p class="card-text">$14.95</p>
                    </div>
                </div>
            </div>
            <div class="container" style="display: flex;  margin-top: 5%">
                <div class="card" style="width: 18rem;margin-right:12%;">
                    <div class="card-body">
                        <input type='checkbox' name='books' value='Object Oriented Software Engineering' /><br/>
                        <h5 class="card-title">Object Oriented Software Engineering</h5>
                        <p class="card-text">$35.99</p>
                    </div>
                </div>
                <div class="card" style="width: 18rem;">

                    <div class="card-body">
                        <input type='checkbox' name='books' value='Java Web Services' /><br/>
                        <h5 class="card-title">Java Web Services</h5>
                        <p class="card-text">$27.99</p>
                    </div>
                </div>
            </div>
            <div style="display: flex; justify-content: center; margin-top: 5%">                         
                <button name="cart" type="submit" class="btn btn-primary">Add To Cart </button>              
            </div>

        </form>
        
        <%@include file="Includes/footer.jsp"%> 
    </body>
</html>

<%
    String[] books = request.getParameterValues("books");
    if(books!=null){
//    out.println("Books is Empty");
    List booksList = Arrays.asList(books);
    session.setAttribute("Books", booksList);
    }else{
        
    }  
%>

