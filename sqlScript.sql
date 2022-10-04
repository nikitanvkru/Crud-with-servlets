create database CRUDMANAGER;
use CRUDMANAGER;
CREATE TABLE departments
(
    Dep_id   INT primary KEY NOT NULL auto_increment,
    Dep_name VARCHAR(20) NOT NULL,
    email    VARCHAR(20) NOT NULL,
    phone    varchar(11) NOT NULL,
    boss_id int
);
CREATE TABLE positions
(
 Pos_id INT primary KEY NOT NULL auto_increment,
 Pos_name VARCHAR(20) NOT NULL ,
 wage INT NOT NULL,
 boss_dep_id INT
);
CREATE TABLE employee
(
    Emp_id INT primary KEY NOT NULL auto_increment,
    Emp_name VARCHAR(20) NOT NULL,
    department_id INTEGER NOT NULL,
    position_id INTEGER NOT NULL,
    FOREIGN KEY (department_id)  REFERENCES departments (Dep_id),
    FOREIGN KEY (position_id)  REFERENCES positions (Pos_id)
);
insert into positions (Pos_name, wage) values ('Admin', 10000,0);
insert into positions (Pos_name, wage) values ('Engeneer', 60000,0);
insert into positions (Pos_name, wage) values ('Intern', 20000,0);
insert into positions (Pos_name, wage) values ('Cleaner', 45000,0);
insert into positions (Pos_name, wage) values ('Boss', 65000,1);
insert into positions (Pos_name, wage) values ('New_Boss', 55000,1);
set global sql_mode="NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION";
alter table positions add column boss_dep_id int;
update positions set boss_dep_id = 2 where Pos_id = 6;
update positions set boss_dep_id = 1 where Pos_id = 5;
update positions set boss_dep_id = 0 where Pos_id = 4;
update positions set boss_dep_id = 0 where Pos_id = 3;
update positions set boss_dep_id = 0 where Pos_id = 2;
update positions set boss_dep_id = 0 where Pos_id = 1;
insert into departments (Dep_name, email, phone) values ('Bugaltery','bugalters@bk.ru','89040123123');
insert into departments (Dep_name, email, phone) values ('Financial','financial@bk.ru','89040121212');
insert into employee(Emp_name,department_id,position_id) values ('Vasya',2,1);
insert into employee(emp_name,department_id,position_id) values ('nikita',1,5);
truncate table employee;
drop trigger Add_Boss;

CREATE TRIGGER Add_Boss AFTER INSERT ON crudmanager.employee
FOR EACH ROW 
    update departments set boss_id =new.Emp_id
    where departments.Dep_id = new.department_id and new.position_id = (select Pos_id from positions where boss_dep_id=new.department_id) and  departments.boss_id is null;
       
    
    
