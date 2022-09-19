package test.emplmanager.servlets;

import test.emplmanager.dao.Dao;
import test.emplmanager.model.Emp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/EditDepartmentServlet")
public class EditDepartmentServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        out.println("<h1>Update department</h1>");
        String sid=request.getParameter("Dep_id");
        int id=Integer.parseInt(sid);

        Emp e= Dao.getDepartmentById(id);

        out.print("<form action='EditDepartmentServlet2' method='post'>");
        out.print("<table>");
        out.print("<tr><td></td><td><input type='hidden' name='Dep_id' value='"+e.getDep_id()+"'/></td></tr>");
        out.print("<tr><td>Department name:</td><td><input type='text' name='Dep_name' value='"+e.getDep_name()+"'/></td></tr>");
        out.print("<tr><td>Email:</td><td><input type='text' name='email' value='"+e.getEmail()+"'/></td></tr>");
        out.print("<tr><td>Phone:</td><td><input type='text' name='phone' value='"+e.getPhone()+"'/></td></tr>");
        out.print("<tr><td colspan='2'><input type='submit' value='Edit &amp; Save '/></td></tr>");
        out.print("</table>");
        out.print("</form>");

        out.close();
    }
}
