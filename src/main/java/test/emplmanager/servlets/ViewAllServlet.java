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
@WebServlet("/ViewAllServlet")
public class ViewAllServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        out.println("<a href='index.html'>Add New Employee</a>");
        out.println("<h1>Employees List</h1>");

        List<Emp> list= Dao.getAllEmployees();

        out.print("<table border='1' width='100%'");
        out.print("<tr><th>Employee id</th><th>Employee name</th><th>Department name</th><th>Work email</th><th>Work phone</th><th>Position name</th><th>Wage</th>");
        for(Emp e:list){
            out.print("<tr><td>"+e.getEmp_id()+"</td><td>"+e.getEmp_name()+"</td><td>"+e.getDep_name()+"</td><td>"+e.getEmail()+"</td><td>"+e.getPhone()+"</td><td>"+e.getPos_name()+"</td><td>"+e.getWage()+"</td>");
        }
        out.print("</table>");

        out.close();
    }
}
