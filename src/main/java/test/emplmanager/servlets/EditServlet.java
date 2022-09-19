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
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        out.println("<h1>Update Employee</h1>");
        String sid=request.getParameter("Emp_id");
        int id=Integer.parseInt(sid);

        Emp e=Dao.getEmployeeById(id);

        out.print("<form action='EditServlet2' method='post'>");
        out.print("<table>");
        out.print("<tr><td></td><td><input type='hidden' name='Emp_id' value='"+e.getEmp_id()+"'/></td></tr>");
        out.print("<tr><td>Employee Name:</td><td><input type='text' name='Emp_name' value='"+e.getEmp_name()+"'/></td></tr>");
        out.print("<tr><td>Department:</td><td>");
        out.print("<select name=department_id style=width:150px>");
        out.print("<option>1-Bugaltery</option>");
        out.print("<option>2-Financial</option>");
        out.print("</select>");
        out.print("</td></tr>");
        out.print("<tr><td>Position:</td><td>");
        out.print("<select name='position_id' style='width:150px'>");
        out.print("<option>1-Admin</option>");
        out.print("<option>2-Engeneer</option>");
        out.print("<option>3-Boss</option>");
        out.print("<option>4-Intern</option>");
        out.print("<option>5-Cleaner</option>");
        out.print("</select>");
        out.print("</td></tr>");
        out.print("<tr><td colspan='2'><input type='submit' value='Edit &amp; Save '/></td></tr>");
        out.print("</table>");
        out.print("</form>");
        out.close();
    }
}