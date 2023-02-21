<%-- 
    Document   : cart
    Created on : Feb 5, 2023, 4:43:10 PM
    Author     : sparshramchandani
--%>



<%@page import="javax.sound.midi.Instrument"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Arrays"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="Includes/head.jsp"%> 
        <title>Cart Page</title>
    </head>
    <body>
        <%@include file="Includes/navbar.jsp" %>
        <%@include file="Includes/navbar1.jsp" %>

        <%
            out.println("<form method='post' action='cart.jsp' >");
            out.println("<h1>Item in your Cart</h1>");
            if (session.getAttribute("Books") != null) {
                String BL = (session.getAttribute("Books")).toString();
                String BLF = BL.substring(1, BL.length() - 1);
                String[] BooksList = BLF.split(",");
                out.println("<h3 style='padding-left:5%; margin-top:3%;' >Books</h3><br>");
                out.println("<div class='container' style='display: flex; margin-top: 2%'>");
                for (int i = 0; i < BooksList.length; i++) {

                    out.println("<div class='card' style='width: 18rem; margin-right:12%;'>");
                    out.println("<div class='card-body'>");
                    out.println("<input type='checkbox' name='booksr' value = " + "'" + BooksList[i] + "'" + "/><br/>");
                    out.println("<h5 class='card-title'>" + BooksList[i] + "</h5>");
                    out.println("</div>");
                    out.println("</div>");

                }
            } else {

            }
            out.println("</div>");

            if (session.getAttribute("Songs") != null) {
                String SL = (session.getAttribute("Songs")).toString();
                String SLF = SL.substring(1, SL.length() - 1);
                String[] SongsList = SLF.split(",");
                out.println("<h3 style='padding-left:5%; margin-top:3%;' >Songs</h3><br>");

                out.println("<div class='container' style='display: flex; margin-top: 2%'>");
                for (int i = 0; i < SongsList.length; i++) {
                    out.println("<div class='card' style='width: 18rem; margin-right:12%;'>");
                    out.println("<div class='card-body'>");
                    out.println("<input type='checkbox' name='songsr' value=" + "'" + SongsList[i] + "'" + " /><br/>");
                    out.println("<h5 class='card-title'>" + SongsList[i] + "</h5>");
                    out.println("</div>");
                    out.println("</div>");
                }
            } else {

            }
            out.println("</div>");

            if (session.getAttribute("Computers") != null) {
                String CL = (session.getAttribute("Computers")).toString();
                String CLF = CL.substring(1, CL.length() - 1);
                String[] ComputersList = CLF.split(",");
                out.println("<h3 style='padding-left:5%; margin-top:3%;'>Computers</h3><br>");

                out.println("<div class='container' style='display: flex; margin-top: 2%'>");
                for (int i = 0; i < ComputersList.length; i++) {
                    out.println("<div class='card' style='width: 18rem; margin-right:12%;'>");
                    out.println("<div class='card-body'>");
                    out.println("<input type='checkbox' name='computersr' value=" + "'" + ComputersList[i] + "'" + " /><br/>");
                    out.println("<h5 class='card-title'>" + ComputersList[i] + "</h5>");
                    out.println("</div>");
                    out.println("</div>");
                }
            } else {

            }
            out.println("</div>");

            out.println("<div style='display: flex; justify-content: center; margin: 5%'>");

            out.println("<button type='submit' class='btn btn-primary'>Remove Selected Item From Cart </button>");
            out.println("</div>");
            out.println("</form>");

//           
        %>

        <%@include file="Includes/footer.jsp"%> 
    </body>
</html>

<%    String[] booksr = request.getParameterValues("booksr");
    String[] songsr = request.getParameterValues("songsr");
    String[] computersr = request.getParameterValues("computersr");

    if (booksr != null) {
        List booksList1 = Arrays.asList(booksr);
        String BL1 = booksList1.toString();
        String BLF1 = BL1.substring(1, BL1.length() - 1);
        String [] BookList1 = BLF1.split(",");
        List<String> BookList1Final = new ArrayList(Arrays.asList(BookList1));
        out.println(BookList1Final);
        if (session.getAttribute("Books") != null) {
            
            List booksListFinal = Arrays.asList(session.getAttribute("Books"));
            
                    String BL = (session.getAttribute("Books")).toString();
                    String BLF = BL.substring(1, BL.length() - 1);
                    String[] BooksList = BLF.split(",");
                    List<String> stringList = new ArrayList(Arrays.asList(BooksList));
                    stringList.removeAll(BookList1Final);
                    session.removeAttribute("Books");
                    session.setAttribute("Books", stringList);
                    response.sendRedirect("/Assignment2.7/cart.jsp");
                    out.println(stringList);

        } else {

        }

    } else {

    }
    
if (songsr != null) {
        List songsList1 = Arrays.asList(songsr);
        String SL1 = songsList1.toString();
        String SLF1 = SL1.substring(1, SL1.length() - 1);
        String [] SongList1 = SLF1.split(",");
        List<String> SongList1Final = new ArrayList(Arrays.asList(SongList1));
        out.println(SongList1Final);
        if (session.getAttribute("Songs") != null) {
            
            List booksListFinal = Arrays.asList(session.getAttribute("Songs"));
            
                    String SL = (session.getAttribute("Songs")).toString();
                    String SLF = SL.substring(1, SL.length() - 1);
                    String[] SongssList = SLF.split(",");
                    List<String> sstringList = new ArrayList(Arrays.asList(SongssList));
                    sstringList.removeAll(SongList1Final);
                    session.removeAttribute("Songs");
                    session.setAttribute("Songs", sstringList);
                    response.sendRedirect("/Assignment2.7/cart.jsp");
                    out.println(sstringList);

        } else {

        }

    } else {

    }
    
if (computersr != null) {
        List comsList1 = Arrays.asList(computersr);
        String CL1 = comsList1.toString();
        String CLF1 = CL1.substring(1, CL1.length() - 1);
        String [] ComList1 = CLF1.split(",");
        List<String> ComList1Final = new ArrayList(Arrays.asList(ComList1));
        out.println(ComList1Final);
        if (session.getAttribute("Computers") != null) {
            
            List comsListFinal = Arrays.asList(session.getAttribute("Computers"));
            
                    String CL = (session.getAttribute("Computers")).toString();
                    String CLF = CL.substring(1, CL.length() - 1);
                    String[] ComssList = CLF.split(",");
                    List<String> cstringList = new ArrayList(Arrays.asList(ComssList));
                    cstringList.removeAll(ComList1Final);
                    session.removeAttribute("Computers");
                    session.setAttribute("Computers", cstringList);
                    response.sendRedirect("/Assignment2.7/cart.jsp");
                    out.println(cstringList);

        } else {

        }

    } else {

    }
%>
