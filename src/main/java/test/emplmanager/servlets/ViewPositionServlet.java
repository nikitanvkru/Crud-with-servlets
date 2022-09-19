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

@WebServlet("/ViewPositionServlet")
public class ViewPositionServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        out.println("<a href='/Testfor1_war_exploded/'>Add New Employee</a>");
        out.println("<h1>Position edit</h1>");

        List<Emp> list= Dao.getAllPositionsForEdit();

        out.print("<table border='1' width='100%'");
        out.print("<tr><th>Position id</th><th>Position Name</th><th>wage</th> <th>Edit</th></tr>");
        for(Emp e:list){
            out.print("<tr><td>"+e.getPos_id()+"</td><td>"+e.getPos_name()+"</td><td>"+e.getWage()+"</td><td><a href='EditPositionServlet?Pos_id="+e.getPos_id()+"'>edit</a></td> </tr>");
        }
        out.print("</table>");

        out.close();
    }
}
