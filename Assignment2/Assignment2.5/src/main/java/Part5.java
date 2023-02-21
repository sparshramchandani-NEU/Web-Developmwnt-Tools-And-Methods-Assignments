
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.HttpMethodConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

@WebServlet(urlPatterns = "/Part5.xls")
@ServletSecurity(
        value = @HttpConstraint(
                rolesAllowed = {
                        "sparsh"
                }),
        httpMethodConstraints = {
                @HttpMethodConstraint(value = "GET", rolesAllowed = {
                        "sparsh"
                })
        })

public class Part5 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        InputStream inputStream = new FileInputStream("//Users/sparshramchandani/Downloads/HW2Documents/store.xls");
        Workbook workbook = new HSSFWorkbook(inputStream);

        for (Sheet sheet : workbook) {
            out.println("<h3>SheetName: </h3>"+ sheet.getSheetName() );
            out.println("<table border= '1'>");
            for (Row row : sheet) {
                out.println("<tr>");
                for (Cell cell : row) {
                    String c = String.valueOf(cell.getCellType());
                    if (c.equals("STRING")) {
                        out.println("<td>" + cell.getStringCellValue() + "</td>");
                    } else {
                        out.println("<td>" + cell.getNumericCellValue() + "</td>");
                    }

                }
                out.println("</tr>");
            }

            out.println("</table>");
        }
    }

}
