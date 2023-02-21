/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.webtools.booksController;

import com.webtools.booksModel.Books;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author sparshramchandani
 */
@WebServlet(name = "BooksController", urlPatterns = {"/BooksController"})
public class BooksController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private Connection conn;

    protected void databaseConnection() throws ServletException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/Assignment3";
            String username = "root";
            String password = "sysadmin";
            conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            throw new ServletException("Unable to connect to database", e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BooksController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    protected ArrayList<Books> setBooksAttribute(String[] ISBN, String[] bookTitle, String[] author, String[] price, int numberOfBooks, HttpServletResponse response) throws IOException {
         ArrayList<Books> result = new ArrayList<>();
        for (int i = 0; i<numberOfBooks;i++){
            Books book = new Books(ISBN[i],bookTitle[i], author[i],price[i]);
            result.add(book);
        }
        return result;
    }

    protected void addBooksToDatabse(ArrayList<Books> books, int numberOfBooks, HttpServletRequest request, HttpServletResponse response) throws ServletException, SQLException, IOException {
        databaseConnection();
//        Statement stmt = conn.createStatement();
//        for (int i = 0; i < books.size(); i++) {
//            stmt.executeUpdate("insert into books values('" + books.get(i).getISBN() + "', '" + books.get(i).getBookTitle() + "', '" + books.get(i).getAuthors() + "', " + books.get(i).getPrice() + ");");
//        }
        String query = "insert into books (ISBN, bookTitle, authors, price) values(?, ?, ?, ?);";
        PreparedStatement stmt = conn.prepareStatement(query);
        
        for (int i = 0; i < books.size(); i++) {
            int x = Integer.parseInt(books.get(i).getPrice());
            
            
            stmt.setString(1, String.valueOf(books.get(i).getISBN()));
            stmt.setString(2, String.valueOf(books.get(i).getBookTitle()));
            stmt.setString(3, String.valueOf(books.get(i).getAuthors()));
            stmt.setInt(4, x);
            
            stmt.executeUpdate();     
        }
        request.setAttribute("numberOfBooks", numberOfBooks);

        RequestDispatcher rd = request.getRequestDispatcher("/JSP/BooksAdded.jsp");
        rd.forward(request, response);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            HttpSession session = request.getSession();

            Integer numberOfBooks = 0;

            if (String.valueOf(session.getAttribute("numberOfBooks")).equals("null")) {
                numberOfBooks = Integer.valueOf(request.getParameter("numberOfBooks"));
                session.setAttribute("numberOfBooks", numberOfBooks);
                session.setAttribute("newNumberOfBooks", session.getAttribute("numberOfBooks"));
            }

            if (String.valueOf(session.getAttribute("step")).equals("null")) {
                session.setAttribute("step", "step1");
                request.setAttribute("numberOfBooks", numberOfBooks);
                RequestDispatcher rd = request.getRequestDispatcher("/JSP/AddNewBooks.jsp");
                rd.forward(request, response);
            } else if (String.valueOf(session.getAttribute("step")).equals("step1")) {
                String[] ISBN = request.getParameterValues("ISBN");
                String[] bookTitle = request.getParameterValues("bookTitle");
                String[] author = request.getParameterValues("authors");
                String[] price = request.getParameterValues("price");
                int newNumberOfBooks = Integer.parseInt(session.getAttribute("newNumberOfBooks").toString()); 
                ArrayList<Books> books = setBooksAttribute(ISBN, bookTitle, author, price, newNumberOfBooks, response);

                addBooksToDatabse(books, newNumberOfBooks, request, response);
            }

        } catch (Exception e) {
            PrintWriter out = response.getWriter();
            out.println(e);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(BooksController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(BooksController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
