import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.servlet.annotation.*;

@WebServlet("/submit")

public class WaiverForm extends HttpServlet {

    public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException{
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String academicTerm = request.getParameter("AcademicTerm");
        String academicYear = request.getParameter("AcademicYear");
        String[] employeeStatus = request.getParameterValues("EmployeeStatus");
        String studentName = request.getParameter("inputstudentName");
        String employeeRelationship = request.getParameter("inputemployeeRelationship");
        String studentNUID = request.getParameter("inputstudentsNUId");
        String employeeName = request.getParameter("inputemployeeName");
        String employeeNUID = request.getParameter("inputemployeeNUId");
        String department = request.getParameter("inputdepartment");
        String campusLocation = request.getParameter("inputcampusLocation");
        String phoneNumber = request.getParameter("inputphoneNumber");
        String supervisorName = request.getParameter("supervisorName");
        String[] program = request.getParameter("program");
        String course1 = request.getParameter("inputcourseNo1");
        String course2 = request.getParameter("inputcourseNo2");
        String course3 = request.getParameter("inputcourseNo3");
        String courseName1 = request.getParameter("inputcourseName2");
        String courseName2 = request.getParameter("inputcourseName3");
        String courseName3 = request.getParameter("inputcourseName4");
        String supervisorSignature1 = request.getParameter("inputsupervisorSignature1");
        String supervisorSignature2 = request.getParameter("inputsupervisorSignature2");
        String supervisorSignature3 = request.getParameter("inputsupervisorSignature3");
        String creditHr1 = request.getParameter("inputcreditHrs1");
        String creditHr2 = request.getParameter("inputcreditHrs2");
        String creditHr3 = request.getParameter("inputcreditHrs3");
        String days1 = request.getParameter("inputdays1");
        String days2 = request.getParameter("inputdays2");
        String days3 = request.getParameter("inputdays3");
        String time1 = request.getParameter("time1");
        String time2 = request.getParameter("time2");
        String time3 = request.getParameter("time3");
        String employeeSignature = request.getParameter("employeeSignature");
        String date1 = request.getParameter("date1");
        String date2 = request.getParameter("date2");
        String hrmApproval = request.getParameter("HRMapproval");

        out.println(academicTerm);
        out.println(academicYear);
        out.println(employeeStatus);
        out.println(studentName);
        out.println(employeeRelationship);
        out.println(studentNUID);
        out.println(employeeName);
        out.println(employeeNUID);
        out.println(department);
        out.println(campusLocation);
        out.println(phoneNumber);
        out.println(supervisorName);
        out.println(program);
        out.println(course1);
        out.println(course2);
        out.println(course3);
        out.println(courseName1);
        out.println(courseName2);
        out.println(courseName3);
        out.println(supervisorSignature1);
        out.println(supervisorSignature2);
        out.println(supervisorSignature3);
        out.println(creditHr1);
        out.println(creditHr2);
        out.println(creditHr3);
        out.println(days1);
        out.println(days2);
        out.println(days3);
        out.println(time1);
        out.println(time2);
        out.println(time3);
        out.println(employeeSignature);
        out.println(date1);
        out.println(date2);
        out.println(hrmApproval);
    }
}
