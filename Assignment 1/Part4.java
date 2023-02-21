import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.servlet.annotation.*;


public class Part4 extends HttpServlet{
    public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
    throws IOException, ServletException {
      response.setContentType("text/html");
      PrintWriter out = response.getWriter();

      out.println("<!DOCTYPE html>");
      out.println("<html lang='en'>");
      out.println("<head>");
       out.println("   <meta charset='UTF-8'>");
       out.println("   <meta http-equiv='X-UA-Compatible' content='IE=edge'>");
       out.println("   <meta name='viewport' content='width=device-width, initial-scale=1.0'>");
       out.println("   <title>Document</title>");
      out.println("</head>");
      out.println("<body>");
          
      out.println("</body>");
      out.println("</html>");

        

    }
}
