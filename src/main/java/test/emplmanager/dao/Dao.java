package test.emplmanager.dao;

import test.emplmanager.model.Emp;

import java.util.*;
import java.sql.*;

public class Dao {

    public static Connection getConnection(){
        Connection con=null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/testbase","root","root");
        }catch(Exception e){System.out.println(e);}
        return con;
    }
    public static int save(Emp e){
        int status=0;
        try{
            Connection con= Dao.getConnection();
            PreparedStatement check1=con.prepareStatement(
                    "select count(department_id) as total from employee where position_id=3 and department_id=1");
            PreparedStatement check2=con.prepareStatement(
                    "select count(department_id) as total from employee where position_id=3 and department_id=2");
            ResultSet rs1=check1.executeQuery();
            ResultSet rs2=check2.executeQuery();
            if (rs1.getInt("total") == 1 && rs2.getInt("total") == 1){con.close();}
            PreparedStatement ps=con.prepareStatement(
                    "insert into employee(Emp_name,department_id,position_id) values (?,?,?)");
            ps.setString(1,e.getEmp_name());
            ps.setInt(2,e.getDepartment_id());
            ps.setInt(3,e.getPosition_id());

            status=ps.executeUpdate();

            con.close();
        }catch(Exception ex){ex.printStackTrace();}

        return status;
    }
    public static int update(Emp e){
        int status=0;
        try{
            Connection con= Dao.getConnection();
            PreparedStatement check1=con.prepareStatement(
                    "select count(department_id) as total from employee where position_id=3 and department_id=1");
            PreparedStatement check2=con.prepareStatement(
                    "select count(department_id) as total from employee where position_id=3 and department_id=2");
            ResultSet rs1=check1.executeQuery();
            ResultSet rs2=check2.executeQuery();
            if (rs1.getInt("total") == 1 && rs2.getInt("total") == 1){con.close();}
            PreparedStatement ps=con.prepareStatement(
                    "update employee set  Emp_name=?,department_id=?,position_id=? where Emp_id=?");
            ps.setString(1,e.getEmp_name());
            ps.setInt(2,e.getDepartment_id());
            ps.setInt(3,e.getPosition_id());
            ps.setInt(4,e.getEmp_id());

            status=ps.executeUpdate();

            con.close();
        }catch(Exception ex){ex.printStackTrace();}

        return status;
    }
    public static int delete(int Emp_id){
        int status=0;
        try{
            Connection con= Dao.getConnection();
            PreparedStatement ps=con.prepareStatement("delete from employee where Emp_id=?");
            ps.setInt(1,Emp_id);
            status=ps.executeUpdate();

            con.close();
        }catch(Exception e){e.printStackTrace();}

        return status;
    }
    public static Emp getEmployeeById(int Emp_id){
        Emp e=new Emp();

        try{
            Connection con= Dao.getConnection();
            PreparedStatement ps=con.prepareStatement("SELECT * from employee where Emp_id=?");
            ps.setInt(1,Emp_id);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                e.setEmp_id(rs.getInt(1));
                e.setEmp_name(rs.getString(2));
                e.setDepartment_id(rs.getInt(3));
                e.setPosition_id(rs.getInt(4));
            }
            con.close();
        }catch(Exception ex){ex.printStackTrace();}

        return e;
    }
    public static List<Emp> getAllEmployees(){
        List<Emp> list=new ArrayList<Emp>();

        try{
            Connection con= Dao.getConnection();
            PreparedStatement ps=con.prepareStatement("SELECT Emp_id, Emp_name, Dep_name, email, phone, Pos_name, wage FROM employee left JOIN" +
                    " department on department_id = Dep_id left join position on position_id = Pos_id");
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Emp e=new Emp();
                e.setEmp_id(rs.getInt(1));
                e.setEmp_name(rs.getString(2));
                e.setDep_name(rs.getString(3));
                e.setEmail(rs.getString(4));
                e.setPhone(rs.getString(5));
                e.setPos_name(rs.getString(6));
                e.setWage(rs.getInt(7));
                list.add(e);
            }
            con.close();
        }catch(Exception e){e.printStackTrace();}

        return list;
    }
    public static List<Emp> getAllEmployeesForEdit(){

        List<Emp> list=new ArrayList<Emp>();

        try{
            Connection con= Dao.getConnection();
            PreparedStatement ps=con.prepareStatement("select * from employee");
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Emp e=new Emp();
                e.setEmp_id(rs.getInt(1));
                e.setEmp_name(rs.getString(2));
                e.setDepartment_id(rs.getInt(3));
                e.setPosition_id(rs.getInt(4));
                list.add(e);
            }
            con.close();
        }catch(Exception e){e.printStackTrace();}

        return list;
    }
}