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

@WebServlet("/EditPositionServlet2")
public class EditPositionServlet2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();

        String sid=request.getParameter("Pos_id");
        int id=Integer.parseInt(sid);
        String name=request.getParameter("Pos_name");
        String wageR=request.getParameter("wage");
        int wage =Integer.parseInt(wageR);


        Emp e=new Emp();
        e.setPos_id(id);
        e.setPos_name(name);
        e.setWage(wage);

        int status= Dao.updatePosition(e);
        if(status>0){
            response.sendRedirect("ViewPositionServlet");
        }else{
            out.println("Sorry! unable to update record");
        }

        out.close();
    }

}