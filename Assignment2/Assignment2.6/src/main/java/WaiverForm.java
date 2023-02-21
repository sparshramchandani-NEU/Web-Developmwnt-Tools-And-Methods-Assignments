import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.servlet.annotation.*;

@WebServlet("/WaiverForm")
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

public class WaiverForm extends HttpServlet {

    public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException{
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String academicTerm = request.getParameter("AcademicTerm");
        String academicYear = request.getParameter("AcademicYear");

       
        // List employeeStatusList = Arrays.asList(employeeStatus);
        String studentName = request.getParameter("inputstudentName");
        String employeeRelationship = request.getParameter("inputemployeeRelationship");
        String studentNUID = request.getParameter("inputstudentsNUId");
        String employeeName = request.getParameter("inputemployeeName");
        String employeeNUID = request.getParameter("inputemployeeNUId");
        String department = request.getParameter("inputdepartment");
        String campusLocation = request.getParameter("inputcampusLocation");
        String phoneNumber = request.getParameter("inputphoneNumber");
        String supervisorName = request.getParameter("supervisorName");
        String[] program = request.getParameterValues("Program");
        List programList = Arrays.asList(program);
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




        out.println("Academic Term: "+academicTerm+"<br>");
        out.println("Academic Year: "+academicYear+"<br>");
        String employeeStatus = request.getParameter("EmployeeStatus");
        String employeeStatusOthers = request.getParameter("employeeStatusOthers");
        if(employeeStatus == "Others"){
            String e = request.getParameter("employeeStatusOthers");
            out.println("Employee Status: "+ e +"<br>");
        }
        else{
            String e = request.getParameter("EmployeeStatus");
                out.println("Employee Status: "+ e +"<br>");
        }


        out.println("Student Name: "+studentName+"<br>");
        out.println("Employee Relationship: "+employeeRelationship+"<br>");
        out.println("Student NUID: "+studentNUID+"<br>");
        out.println("Employee Name: "+employeeName+"<br>");
        out.println("Employee NUID: "+employeeNUID+"<br>");
        out.println("Department: "+department+"<br>");
        out.println("Campus Location: "+campusLocation+"<br>");
        out.println("Phone Number: "+phoneNumber+"<br>");
        out.println("Supervisor Name: "+supervisorName+"<br>");
        out.println("School Program"+programList+"<br>");
        out.println("Course No. 1: "+course1+"<br>");
        out.println("Course No. 2: "+course2+"<br>");
        out.println("Course No. 3: "+course3+"<br>");
        out.println("Course Name 1: "+courseName1+"<br>");
        out.println("Course Name 2: "+courseName2+"<br>");
        out.println("Course Name 3: "+courseName3+"<br>");
        out.println("Supervisor Signature 1: "+supervisorSignature1+"<br>");
        out.println("Supervisor Signature 2: "+supervisorSignature2+"<br>");
        out.println("Supervisor Signature 3: "+supervisorSignature3+"<br>");
        out.println("Credit Hours for Course 1: "+creditHr1+"<br>");
        out.println("Credit Hours for Course 2: "+creditHr2+"<br>");
        out.println("Credit Hours for Course 3: "+creditHr3+"<br>");
        out.println("Days for Course 1: "+days1+"<br>");
        out.println("Days for Course 2: "+days2+"<br>");
        out.println("Days for Course 3: "+days3+"<br>");
        out.println("Timings for Course 1: "+time1+"<br>");
        out.println("Timings for Course 2: "+time2+"<br>");
        out.println("Timings for Course 3: "+time3+"<br>");
        out.println("Employee Signature: "+employeeSignature+"<br>");
        out.println("Date:"+date1+"<br>");
        out.println("HRM Approval: "+hrmApproval+"<br>");
        out.println("Date: "+date2+"<br>");
    }
}
