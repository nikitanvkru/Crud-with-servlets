package test.emplmanager.servlets;

import test.emplmanager.dao.Dao;
import test.emplmanager.model.Emp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        out.println("<a href='/Testfor1_war_exploded/'>Add New Employee</a>");
        out.println("<h1>Employees edit</h1>");

        List<Emp> list= Dao.getAllEmployeesForEdit();

        out.print("<table border='1' width='100%'");
        out.print("<tr><th>Employee id</th><th>Employee Name</th><th>Department id</th><th>Position id</th> <th>Edit</th><th>Delete</th></tr>");
        for(Emp e:list){
            out.print("<tr><td>"+e.getEmp_id()+"</td><td>"+e.getEmp_name()+"</td><td>"+e.getDepartment_id()+"</td> <td>"+e.getPosition_id()+"</td><td><a href='EditServlet?Emp_id="+e.getEmp_id()+"'>edit</a></td> <td><a href='DeleteServlet?Emp_id="+e.getEmp_id()+"'>delete</a></td></tr>");
        }
        out.print("</table>");

        out.close();
    }
}
