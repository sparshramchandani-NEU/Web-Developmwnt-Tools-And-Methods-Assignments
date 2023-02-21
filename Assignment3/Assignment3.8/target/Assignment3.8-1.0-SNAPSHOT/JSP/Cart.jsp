
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
            <div class="container" style="justify-content: space-between; margin-top: 5%">
                <h1>Books</h1>
                <div class="container" style="display: flex; margin-top: 2%; margin-bottom: 3%">
                    <c:forEach items="${sessionScope.booksList}" var="i" >

                        <div class="card" style="width: 18rem; margin-right: 3%;">

                            <div class="card-body">
                                <input type='checkbox' name='booksItems' value='${i.title},${i.price}' /><br/>
                                <h5 class="card-title">${i.title}</h5>
                                <p class="card-text">$${i.price}</p>
                            </div>
                            <input type="hidden" value="Books" name="itemsToRemove">
                        </div>
                    </c:forEach>
                </div>


                <h1>Music</h1>
                <div class="container" style="display: flex; margin-top: 2%; margin-bottom: 3%">
                    <c:forEach items="${sessionScope.musicList}" var="i" >
                        <div class="card" style="width: 18rem; margin-right: 3%;">

                            <div class="card-body">
                                <input type='checkbox' name='musicItems' value='${i.title},${i.price}' /><br/>
                                <h5 class="card-title">${i.title}</h5>
                                <p class="card-text">$${i.price}</p>
                            </div>
                            <input type="hidden" value="Music" name="itemsToRemove">
                        </div>
                    </c:forEach>
                </div>


                <h1>Computers</h1>
                <div class="container" style="display: flex; margin-top: 2%; margin-bottom: 3%">
                    <c:forEach items="${sessionScope.computerList}" var="i" >
                        <div class="card" style="width: 18rem; margin-right: 3%;">

                            <div class="card-body">
                                <input type='checkbox' name='computerItems' value='${i.title},${i.price}' /><br/>
                                <h5 class="card-title">${i.title}</h5>
                                <p class="card-text">$${i.price}</p>
                            </div>
                            <input type="hidden" value="Computer" name="itemsToRemove">
                        </div>
                    </c:forEach>

                </div>
            </div>
            <input type="hidden" value="${requestScope.item}" name="item">
            

            <div style="display: flex; justify-content: center; margin-top: 5%; margin-bottom: 5%">                         
                <button name="cart" type="submit" class="btn btn-primary">Remove Selected Items </button>              
            </div>
        </form>

        <%@include file="../Includes/footer.jsp"%> 
    </body>
</html>



