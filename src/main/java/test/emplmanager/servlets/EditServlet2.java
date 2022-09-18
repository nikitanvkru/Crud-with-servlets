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
@WebServlet("/EditServlet2")
public class EditServlet2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();

        String sid=request.getParameter("Emp_id");
        int id=Integer.parseInt(sid);
        String name=request.getParameter("Emp_name");
        String department_id=request.getParameter("department_id");
        String position_id=request.getParameter("position_id");

        Emp e=new Emp();
        e.setEmp_id(id);
        e.setEmp_name(name);
        e.setDepartment_id(Integer.parseInt(department_id.substring(0,1)));
        e.setPosition_id(Integer.parseInt(position_id.substring(0,1)));

        int status=Dao.update(e);
        if(status>0){
            response.sendRedirect("ViewServlet");
        }else{
            out.println("Sorry! unable to update record");
        }

        out.close();
    }

}