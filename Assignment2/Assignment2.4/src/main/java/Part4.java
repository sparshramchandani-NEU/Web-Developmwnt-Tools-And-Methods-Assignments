/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author sparshramchandani
 */

@WebServlet(urlPatterns = "/Part4")
public class Part4 extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String fileName = request.getParameter("fileName");
            
            if(!fileName.equals("parking_facilities.csv")){
                 out.println("<!DOCTYPE html>");
out.println("<html lang='en'>");
out.println("<head>");
 out.println("   <meta charset='UTF-8'>");
 out.println("   <meta http-equiv='X-UA-Compatible' content='IE=edge'>");
 out.println("   <meta name='viewport' content='width=device-width, initial-scale=1.0'>");
  out.println("  <title>Document</title>");
out.println("</head>");
out.println("<body>");
 out.println("   <p>Please Enter the valid File Name</p>");
out.println("</body>");
out.println("</html>");
            }
            else{
                try{         
            Class.forName("org.relique.jdbc.csv.CsvDriver");

String url = "jdbc:relique:csv:/Users/sparshramchandani/Documents/Sem_2/Web tools and methods/Assignments/Assignment2/Assignment2.4/csv file";
//String url = "jdbc:relique:csv:../../../csv file";

            Connection con = DriverManager.getConnection(url);
            Statement stmt = con.createStatement();
            


        ResultSet rs = stmt.executeQuery("SELECT * from parking_facilities ");
        
  out.println("  <title>Assignment 2.4</title>");


        out.println("<table border='1'");
        while(rs.next()){
        

            String col1 = rs.getString(1);
            String col2 = rs.getString(2);
            String col3 = rs.getString(3);
            String col4 = rs.getString(4);
            String col5 = rs.getString(5);
            String col6 = rs.getString(6);
            String col7 = rs.getString(7);
            String col8 = rs.getString(8);
            String col9 = rs.getString(9);
            String col10 = rs.getString(10);
            String col11 = rs.getString(11);
            String col12= rs.getString(12);

    
    




  out.println("<tr>");
            out.println("<td>"+ col1 + "</td>");
            out.println("<td>"+ col2 + "</td>");
            out.println("<td>"+ col3 + "</td>");
            out.println("<td>"+ col4 + "</td>");
            out.println("<td>"+ col5 + "</td>");
            out.println("<td>"+ col6 + "</td>");
            out.println("<td>"+ col7 + "</td>");
            out.println("<td>"+ col8 + "</td>");
            out.println("<td>"+ col9 + "</td>");
            out.println("<td>"+ col10 + "</td>");
            out.println("<td>"+ col11+ "</td>");
            out.println("<td>"+ col12+ "</td>");
            
            out.println("</tr>");
            }
            out.println("</table>");
            out.println("</hr>");

            }
            catch (ClassNotFoundException ex) {
            System.out.println("Class not found Exception");
        } catch (SQLException ex) {
            System.out.println("SQL Exception");
            
        }
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
        processRequest(request, response);
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
        processRequest(request, response);
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
