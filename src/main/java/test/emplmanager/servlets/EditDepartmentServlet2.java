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

@WebServlet("/EditDepartmentServlet2")
public class EditDepartmentServlet2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();

        String sid=request.getParameter("Dep_id");
        int id=Integer.parseInt(sid);
        String Dep_name=request.getParameter("Dep_name");
        String email=request.getParameter("email");
        String phone=request.getParameter("phone");


        Emp e=new Emp();
        e.setDep_id(id);
        e.setDep_name(Dep_name);
        e.setEmail(email);
        e.setPhone(phone);

        int status= Dao.updateDepartment(e);
        if(status>0){
            response.sendRedirect("ViewDepartmentServlet");
        }else{
            out.println("Sorry! unable to update record");
        }

        out.close();
    }

}
