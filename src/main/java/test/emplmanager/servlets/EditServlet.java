package test.emplmanager.servlets;

import test.emplmanager.dao.Dao;
import test.emplmanager.model.Emp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        out.println("<h1>Update Employee</h1>");

        String sid=request.getParameter("Emp_id");
        out.println(sid);

        int Emp_id=Integer.parseInt(sid);
        Emp e= Dao.getEmployeeById(Emp_id);

        out.println("<form action='EditServlet2' method='post'>");
        out.println("<table>");
        out.println("<tr><td></td><td><input type='hidden' name='id' value='"+e.getEmp_id()+"'/></td></tr>");
        out.println("<tr><td>Name:</td><td><input type='text' name='name' value='"+e.getEmp_name()+"'/></td></tr>");
        out.println("<tr><td>Department id:</td><td>");
        out.println("<select name='department_id' style='width:150px'>");
        out.println("<option>1-Bugalters</option>");
        out.println("<option>2-Financial</option>");
        out.println("</select>");
        out.println("</td></tr>");

        out.println("<tr><td>Position id:</td><td>");
        out.println("<select name='position_id' style='width:150px'>");
        out.println("<option>1-Admin</option>");
        out.println("<option>2-Engeneer</option>");
        out.println("<option>3-Boss</option>");
        out.println("<option>4-Intern</option>");
        out.println("<option>5-Cleaner</option>");
        out.println("</select>");
        out.println("</td></tr>");

        out.println("<tr><td colspan='2'><input type='submit' value='Edit & Save '/></td></tr>");
        out.println("</table>");
        out.println("</form>");

        out.close();
    }
}
