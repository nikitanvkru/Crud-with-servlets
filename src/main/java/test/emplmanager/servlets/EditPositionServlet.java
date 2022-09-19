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
@WebServlet("/EditPositionServlet")
public class EditPositionServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        out.println("<h1>Update position</h1>");
        String sid=request.getParameter("Pos_id");
        int id=Integer.parseInt(sid);

        Emp e=Dao.getPositionById(id);

        out.print("<form action='EditPositionServlet2' method='post'>");
        out.print("<table>");
        out.print("<tr><td></td><td><input type='hidden' name='Pos_id' value='"+e.getPos_id()+"'/></td></tr>");
        out.print("<tr><td></td><td><input type='hidden' name='Pos_name' value='"+e.getPos_name()+"'/></td></tr>");
        out.print("<tr><td>Wage:</td><td><input type='text' name='wage' value='"+e.getWage()+"'/></td></tr>");
        out.print("<tr><td colspan='2'><input type='submit' value='Edit &amp; Save '/></td></tr>");
        out.print("</table>");
        out.print("</form>");

        out.close();
    }
}
