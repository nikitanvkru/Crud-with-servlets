package test.emplmanager.dao;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;
import test.emplmanager.model.ConfigRead;
import test.emplmanager.model.Emp;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.sql.*;

public class Dao {
    private ArrayList<String> positions;
    private ArrayList<String> departments;
    private static final String DRIVER = ConfigRead.getLst().get(0);
    private static final String URL = ConfigRead.getLst().get(1);
    private static final String USER = ConfigRead.getLst().get(2);
    private static final String PASSWORD = ConfigRead.getLst().get(3);

    public static Connection getConnection(){

        Connection con=null;
        try{
            Class.forName(DRIVER);
            con=DriverManager.getConnection(URL,USER,PASSWORD);
        }catch(Exception e){System.out.println(e);}
        return con;
    }

    public ArrayList<String> getPositions(){
        try{
            Connection con= Dao.getConnection();
            Statement stm  = con.createStatement();
            String sql = "Select Pos_name From positions";
            ResultSet rst = stm.executeQuery(sql);
            ArrayList<String> positions = new ArrayList<>();
            while(rst.next()){
                String name = rst.getString("Pos_name");
                positions.add(name);
            }
            return positions;
        }catch(Exception ex){ex.printStackTrace();}
        return null;
    }
    public ArrayList<String> getDepartments(){
        try{
            Connection con= Dao.getConnection();
            Statement stm  = con.createStatement();
            String sql = "Select Dep_name From DEPARTMENTs";
            ResultSet rst = stm.executeQuery(sql);
            ArrayList<String> positions = new ArrayList<>();
            while(rst.next()){
                String name = rst.getString("Dep_name");
                positions.add(name);
            }
            return positions;
        }catch(Exception ex){ex.printStackTrace();}
        return null;
    }


    public static int save(Emp e){
        int status=0;
        try{
            Connection con= Dao.getConnection();
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
    public static int updateDepartment(Emp e){
        int status=0;
        try{
            Connection con= Dao.getConnection();
            PreparedStatement ps=con.prepareStatement(
                    "update department set  Dep_name=?,email=?,phone=? where Dep_id=?");
            ps.setString(1,e.getDep_name());
            ps.setString(2,e.getEmail());
            ps.setString(3,e.getPhone());
            ps.setInt(4,e.getDep_id());

            status=ps.executeUpdate();

            con.close();
        }catch(Exception ex){ex.printStackTrace();}

        return status;
    }
    public static int updatePosition(Emp e){
        int status=0;
        try{
            Connection con= Dao.getConnection();
            PreparedStatement ps=con.prepareStatement(
                    "update position1 set  Pos_name=?,wage=? where Pos_id=?");
            ps.setString(1,e.getPos_name());
            ps.setInt(2,e.getWage());
            ps.setInt(3,e.getPos_id());

            status=ps.executeUpdate();

            con.close();
        }catch(Exception ex){ex.printStackTrace();}

        return status;
    }
    public static Emp getPositionById(int Pos_id){
        Emp e=new Emp();

        try{
            Connection con= Dao.getConnection();
            PreparedStatement ps=con.prepareStatement("SELECT * from position1 where Pos_id=?");
            ps.setInt(1,Pos_id);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                e.setPos_id(rs.getInt(1));
                e.setPos_name(rs.getString(2));
                e.setWage(rs.getInt(3));
            }
            con.close();
        }catch(Exception ex){ex.printStackTrace();}

        return e;
    }
    public static Emp getDepartmentById(int Dep_id){
        Emp e=new Emp();

        try{
            Connection con= Dao.getConnection();
            PreparedStatement ps=con.prepareStatement("SELECT * from department where Dep_id=?");
            ps.setInt(1,Dep_id);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                e.setDep_id(rs.getInt(1));
                e.setDep_name(rs.getString(2));
                e.setEmail(rs.getString(3));
                e.setPhone(rs.getString(4));
            }
            con.close();
        }catch(Exception ex){ex.printStackTrace();}

        return e;
    }
    public static List<Emp> getAllPositionsForEdit(){

        List<Emp> list=new ArrayList<>();

        try{
            Connection con= Dao.getConnection();
            PreparedStatement ps=con.prepareStatement("select * from position1");
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Emp e=new Emp();
                e.setPos_id(rs.getInt(1));
                e.setPos_name(rs.getString(2));
                e.setWage(rs.getInt(3));
                list.add(e);
            }
            con.close();
        }catch(Exception e){e.printStackTrace();}

        return list;
    }
    public static List<Emp> getAllDepartmentForEdit(){

        List<Emp> list=new ArrayList<>();

        try{
            Connection con= Dao.getConnection();
            PreparedStatement ps=con.prepareStatement("select * from department");
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Emp e=new Emp();
                e.setDep_id(rs.getInt(1));
                e.setDep_name(rs.getString(2));
                e.setEmail(rs.getString(3));
                e.setPhone(rs.getString(4));
                list.add(e);
            }
            con.close();
        }catch(Exception e){e.printStackTrace();}

        return list;
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
        List<Emp> list=new ArrayList<>();

        try{
            Connection con= Dao.getConnection();
            PreparedStatement ps=con.prepareStatement("SELECT Emp_id, Emp_name, Dep_name, email, phone, Pos_name, wage FROM employee left JOIN" +
                    " department on department_id = Dep_id left join position1 on position_id = Pos_id");
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