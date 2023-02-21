
<%@page import="java.security.Principal"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="java.util.List"%>
<%@page import="java.util.Arrays"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <%@include file="../Includes/head.jsp"%> 
        <title>${requestScope.item} Page</title>
    </head>
    <body>
        <%@include file="../Includes/navbar.jsp" %>


        <form method="post" action="CartController">
            <div class="container" style="display: flex; justify-content: space-between; margin-top: 5%">
                <c:forEach items="${requestScope.list}" var="i" >
                    <div class="card" style="width: 18rem;">

                    <div class="card-body">
                        <input type='checkbox' name='items' value='${i.title},${i.price}' /><br/>
                        <h5 class="card-title">${i.title}</h5>
                        <p class="card-text">$${i.price}</p>
                    </div>
                </div>
                    
                </c:forEach>
                
                <input type="hidden" value="${requestScope.item}" name="item">
            </div>
            <div style="display: flex; justify-content: center; margin-top: 5%">                         
                <button name="cart" type="submit" class="btn btn-primary">Add To Cart </button>              
            </div>
        </form>

        <%@include file="../Includes/footer.jsp"%> 
    </body>
</html>



