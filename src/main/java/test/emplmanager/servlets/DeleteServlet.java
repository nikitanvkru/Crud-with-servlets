package test.emplmanager.servlets;

import test.emplmanager.dao.Dao;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String sid=request.getParameter("Emp_id");
        int id=Integer.parseInt(sid);
        Dao.delete(id);
        response.sendRedirect("ViewServlet");
    }
}
