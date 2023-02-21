/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.webtools.moviesController;

import com.webtools.moviesModel.Movie;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
@WebServlet(urlPatterns = {"/MovieController"})
public class MovieController extends HttpServlet {

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
            Logger.getLogger(MovieController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    protected void addNewMoviesToDatabase(Movie movie, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            databaseConnection();
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("insert into movies values('" + movie.getTitle() + "','" + movie.getLeadActor() + "','" + movie.getLeadActress() + "','" + movie.getGenre() + "'," + movie.getYear() + ");");
            RequestDispatcher rd = request.getRequestDispatcher("/JSP/MovieAdded.jsp");
            rd.forward(request, response);
        } catch (SQLException e) {
            throw new ServletException("Error in SQL query", e);
        }

    }

    protected void browseMoviesFromDatabase(String keyWord, String selectionKey,HttpServletRequest request,HttpServletResponse response) throws ServletException, SQLException, IOException {
        databaseConnection();
        Statement stmt = conn.createStatement();
        ArrayList<String> titleArray = new ArrayList<String>();
        ArrayList<String> actorArray = new ArrayList<String>();
        ArrayList<String> actressArray = new ArrayList<String>();
        ArrayList<String> genreArray = new ArrayList<String>();
        ArrayList<Integer> yearArray = new ArrayList<Integer>();
        
        if (selectionKey.equals("title")) {
                    ResultSet rs = stmt.executeQuery("SELECT * FROM movies where title='" + keyWord + "'");
                    
                    while (rs.next()) {
                        titleArray.add(rs.getString("title"));
                        actorArray.add(rs.getString("actor"));
                        actressArray.add(rs.getString("actress"));
                        genreArray.add(rs.getString("genre"));
                        yearArray.add(rs.getInt("year"));         
                    }
                    
                }
         else if (selectionKey.equals("actor")) {
                    ResultSet rs = stmt.executeQuery("SELECT * FROM movies where actor='" + keyWord + "'");
                    
                    
                    while (rs.next()) {
                        
                        titleArray.add(rs.getString("title"));
                        actorArray.add(rs.getString("actor"));
                        actressArray.add(rs.getString("actress"));
                        genreArray.add(rs.getString("genre"));
                        yearArray.add(rs.getInt("year"));
                    }
    
                }
        else if (selectionKey.equals("actress")) {
                    ResultSet rs = stmt.executeQuery("SELECT * FROM movies where actress='" + keyWord + "'");
                    
                    while (rs.next()) {
                        
                        titleArray.add(rs.getString("title"));
                        actorArray.add(rs.getString("actor"));
                        actressArray.add(rs.getString("actress"));
                        genreArray.add(rs.getString("genre"));
                        yearArray.add(rs.getInt("year"));
                    }
                    
                }
        else if (selectionKey.equals("all")) {
                    ResultSet rs = stmt.executeQuery("SELECT * FROM movies");
                    
                    
                    
                    while (rs.next()) {
                        titleArray.add(rs.getString("title"));
                        actorArray.add(rs.getString("actor"));
                        actressArray.add(rs.getString("actress"));
                        genreArray.add(rs.getString("genre"));
                        yearArray.add(rs.getInt("year"));
                    }
                   
                 }
                    request.setAttribute("titleArray", titleArray);
                    request.setAttribute("actorArray", actorArray);
                    request.setAttribute("actressArray", actressArray);
                    request.setAttribute("genreArray", genreArray);
                    request.setAttribute("yearArray", yearArray);
                    
                    RequestDispatcher rd = request.getRequestDispatcher("/JSP/BrowseMoviesResult.jsp");
                    rd.forward(request, response);
    }


    protected void navigation(String s, HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {

        if (s.equals("Add New Movies to Database")) {
            session.setAttribute("selection", "addMovies");
            RequestDispatcher rd = request.getRequestDispatcher("/JSP/AddNewMovies.jsp");
            rd.forward(request, response);
        } else {
            session.setAttribute("selection", "browseMovies");
            RequestDispatcher rd = request.getRequestDispatcher("/JSP/BrowseMovies.jsp");
            rd.forward(request, response);
        }

    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            HttpSession session = request.getSession();
            String s = request.getParameter("selection");

            if (String.valueOf(session.getAttribute("selection")).equals("null")) {
                navigation(s, request, response, session);
            } else if (String.valueOf(session.getAttribute("selection")).equals("addMovies")) {

                String title = request.getParameter("movieTitle");
                String leadActor = request.getParameter("leadActor");
                String leadActress = request.getParameter("leadActress");
                String genre = request.getParameter("genre");
                int year = Integer.parseInt(request.getParameter("year"));
                  Movie movie = new Movie(title, leadActor, leadActress, genre, year);
                addNewMoviesToDatabase(movie, request, response);
            } else if (session.getAttribute("selection").equals("browseMovies")) {
                String keyWord = request.getParameter("keyWord");
                String selectionKey = request.getParameter("selectionKey");
                
                browseMoviesFromDatabase(keyWord, selectionKey, request, response);

            }

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
            Logger.getLogger(MovieController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(MovieController.class.getName()).log(Level.SEVERE, null, ex);
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
