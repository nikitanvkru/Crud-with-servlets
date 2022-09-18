package test.emplmanager.model;

public class Emp {
    private int Emp_id, department_id, position_id, Dep_id, Pos_id, wage;
    private String Emp_name,Dep_name,email,phone, Pos_name;

    public int getEmp_id() {
        return Emp_id;
    }

    public void setEmp_id(int emp_id) {
        Emp_id = emp_id;
    }

    public int getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(int department_id) {
        this.department_id = department_id;
    }

    public int getPosition_id() {
        return position_id;
    }

    public void setPosition_id(int position_id) {
        this.position_id = position_id;
    }

    public int getDep_id() {
        return Dep_id;
    }

    public void setDep_id(int dep_id) {
        Dep_id = dep_id;
    }

    public int getPos_id() {
        return Pos_id;
    }

    public void setPos_id(int pos_id) {
        Pos_id = pos_id;
    }

    public int getWage() {
        return wage;
    }

    public void setWage(int wage) {
        this.wage = wage;
    }

    public String getEmp_name() {
        return Emp_name;
    }

    public void setEmp_name(String emp_name) {
        Emp_name = emp_name;
    }

    public String getDep_name() {
        return Dep_name;
    }

    public void setDep_name(String dep_name) {
        Dep_name = dep_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPos_name() {
        return Pos_name;
    }

    public void setPos_name(String pos_name) {
        Pos_name = pos_name;
    }
}
