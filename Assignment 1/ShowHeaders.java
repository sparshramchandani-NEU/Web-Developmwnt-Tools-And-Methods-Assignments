import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

public class ShowHeaders extends HttpServlet {

  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
    throws IOException, ServletException {
      response.setContentType("text/html");
      PrintWriter out = response.getWriter();
      
      out.println("<p>HTTP headers sent by your client:</p>");
      
	Enumeration enums = request.getHeaderNames();
        while (enums.hasMoreElements()) {
        String headerName = (String) enums.nextElement();
        String headerValue = request.getHeader(headerName);
        out.print("<b>"+headerName + "</b>: ");
        out.println(headerValue + "<br>");
      }
      
      }
}
