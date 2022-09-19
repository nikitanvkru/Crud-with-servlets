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
import java.util.List;


@WebServlet("/ViewDepartmentServlet")
public class ViewDepartmentServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        out.println("<a href='/Testfor1_war_exploded/'>Add New Employee</a>");
        out.println("<h1>Department edit</h1>");

        List<Emp> list= Dao.getAllDepartmentForEdit();

        out.print("<table border='1' width='100%'");
        out.print("<tr><th>Department id</th><th>Department Name</th><th>Email</th><th>Phone</th> <th>Edit</th></tr>");
        for(Emp e:list){
            out.print("<tr><td>"+e.getDep_id()+"</td><td>"+e.getDep_name()+"</td><td>"+e.getEmail()+"</td><td>"+e.getPhone()+"</td><td><a href='EditDepartmentServlet?Dep_id="+e.getDep_id()+"'>edit</a></td> </tr>");
        }
        out.print("</table>");

        out.close();
    }
}
