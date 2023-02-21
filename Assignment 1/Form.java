import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.servlet.annotation.*;

@MultipartConfig(
    location = "/Users/sparshramchandani/Documents/Sem_2",
  fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
  maxFileSize = 1024 * 1024 * 10,      // 10 MB
  maxRequestSize = 1024 * 1024 * 100   // 100 MB
)

public class Form extends HttpServlet {

  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
    throws IOException, ServletException {
      response.setContentType("text/html");
      PrintWriter out = response.getWriter();
      

    //   HTML CODE FOR FORM
      out.println("<!DOCTYPE html>");
     out.println(" <html>");
     out.println(" <head>");
     out.println(" <meta charset='ISO-8859-1'>");
     out.println(" <title>Form</title>");
     out.println(" <!-- Latest compiled and minified CSS -->");
     out.println(" <link rel='stylesheet'");
     out.println("     href='https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css'>");
     out.println(" ");
     out.println(" <!-- jQuery library -->");
     out.println(" <script");
     out.println("     src='https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js'></script>");
     out.println(" ");
     out.println(" <!-- Popper JS -->");
     out.println(" <script");
     out.println("     src='https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js'></script>");
     out.println(" ");
     out.println(" <!-- Latest compiled JavaScript -->");
    out.println("  <script");
    out.println("      src='https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js'></script>");
    out.println("  </head>");
    out.println("  <body class='container-fluid'>");
    out.println("      <div class='card' style='width: 600px; margin: auto; margin-top: 50px'>");
    out.println("          <h2 class='bg-danger text-light card-header'>Registration form</h2>");
     out.println("         <form class='form' action='register' method='post'>");
     out.println("             <table class='table table-hover table-striped'>");
     out.println("                 <tr>");
     out.println("                     <td>Email</td>");
     out.println("                     <td><input type='text' name='email'></td>");
     out.println("                 </tr>");
     out.println("                 <tr>");
     out.println("                     <td>Password</td>");
      out.println("                    <td><input type='password' name='password'></td>");
     out.println("                 </tr>");
     out.println("                 <tr>");
     out.println("                     <td>Confirm Password</td>");
      out.println("                    <td><input type='password' name='passwordf'></td>");
     out.println("                 </tr>");
     out.println("                 <tr>");
     out.println("                     <td>Upload Your Picture</td>");
      out.println("                    <td><input type='file' name='file'></td>");
     out.println("                 </tr>");
      out.println("                <tr>");
      out.println("                    <td>Gender</td>");
      out.println("                    <td><input type='radio' name='gender' value='Male'>Male");
      out.println("                        <input type='radio' name='gender' value='Female'>Female</td>");
      out.println("                </tr>");
      out.println("                <tr>");
      out.println("                    <td>Select Country</td>");
      out.println("                    <td><select name='country'>");
      out.println("                            <option value=' selected='selected'>Select</option>");
      out.println("                            <option value='United Kingdom'>United Kingdom</option>");
      out.println("                            <option value='United States of America'>United States of America</option>");
      out.println("                            <option value='India'>India</option>");
      out.println("                            <option value='Canada'>Canada</option>");
      out.println("                    </select></td>");
      out.println("                </tr>");
      out.println("                <tr>");
      out.println("                    <td>Hobbies</td>");
      out.println("                    <td><input type='checkbox' name='hb' value='reading'>Reading");
      out.println("                        <input type='checkbox' name='hb' value='watching'>Web");
      out.println("                        Series <input type='checkbox' name='hb' value='playing'>Cricket");
      out.println("                        <input type='checkbox' name='hb' value='traveller'>Travel");
       out.println("                   </td>");
      out.println("                </tr>");
      out.println("                 <tr>");
     out.println("                     <td>Address</td>");
     out.println("                     <td><textarea name='address' rows='10' cols='50'></textarea></td>");
     out.println("                 </tr>");
      out.println("                <tr>");
      out.println("                    <td><button type='submit' class='btn btn-outline-success'>Submit</button></td>");
      out.println("                    <td><button type='reset' class='btn btn-outline-danger'>Reset</button></td>");
      out.println("                </tr>");
      out.println("            </table>");
      out.println("        </form>");
      out.println("    </div>");
     out.println(" </body>");
     out.println(" </html>"); 

    
      }

    public void doPost(HttpServletRequest request,
                         HttpServletResponse response)
        throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String email = request.getParameter("email");
             String gender = request.getParameter("gender");
        String address = request.getParameter("address");

        String[] hobbies = request.getParameterValues("hb");
        List hobbyList = Arrays.asList(hobbies); 

        String country = request.getParameter("country");

        String filePath = request.getParameter("file");

        out.println("email: " + email+"<br>");
        out.println("Gender: "+ gender+"<br>");
        out.println("Address: " + address+"<br>");
        out.println("Hobbies: " + hobbyList+"<br>");
        out.println("Country: " + country+"<br>");
        out.println("Image Uploaded: " + filePath+"<br>");

        // Enumeration<String> parameterNames = request.getParameterNames();

        // while (parameterNames.hasMoreElements()) {
        //     String paramName = parameterNames.nextElement();
        //     out.println(paramName + " - " + request.getParameter(paramName) + "<br>");
        // }
  }


}