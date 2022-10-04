package test.emplmanager.servlets;

import test.emplmanager.dao.Dao;
import test.emplmanager.model.Emp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;

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
        Dao dao = new Dao();
        LinkedHashMap<String, Integer> lhmPos = new LinkedHashMap<>();
        for (int i = 0; i < dao.getPositions().size(); i++) {
            lhmPos.put(dao.getPositions().get(i), i+1);
        }
        LinkedHashMap<String, Integer> lhmDep = new LinkedHashMap<>();
        for (int i = 0; i < dao.getDepartments().size(); i++) {
            lhmDep.put(dao.getDepartments().get(i), i+1);
        }
        e.setEmp_name(Emp_name);
        e.setDepartment_id(lhmDep.get(department_id));
        e.setPosition_id(lhmPos.get(position_id));
        int status=Dao.save(e);
        if(status>0){
            out.println("<a href='/Testfor1_war_exploded/'>Add New Employee</a>");
            out.println("<p>Record saved successfully!</p>");
            request.getRequestDispatcher("index.html").include(request, response);
        }
        else{
            out.println("Sorry! unable to save record");
        }

        out.close();
    }

}
