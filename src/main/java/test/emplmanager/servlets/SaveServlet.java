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
@WebServlet("/SaveServlet")
public class SaveServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out=response.getWriter();

        String Emp_name=request.getParameter("Emp_name");
        String department_id=request.getParameter("department_id");
        String position_id=request.getParameter("position_id");


        Emp e=new Emp();
        e.setEmp_name(Emp_name);
        e.setDepartment_id(Integer.parseInt(department_id.substring(0,1)));
        e.setPosition_id(Integer.parseInt(position_id.substring(0,1)));

        int status=Dao.save(e);
        if(status>0){
            out.print("<p>Record saved successfully!</p>");
            request.getRequestDispatcher("index.html").include(request, response);
        }else{
            out.println("Sorry! unable to save record");

        }
        out.close();
    }

}
