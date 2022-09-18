create database employees;
use employees;
CREATE TABLE employee
(
    Emp_id INT(11) PRIMARY KEY NOT NULL,
    Emp_name VARCHAR(20) NOT NULL,
    department_id int NOT NULL,
    position_id int NOT NULL,
    FOREIGN KEY (department_id)  REFERENCES department (Dep_id),
    FOREIGN KEY (position_id)  REFERENCES position (Pos_id)
);

CREATE TABLE department
(
    Dep_id INT(11) PRIMARY KEY NOT NULL,
    Dep_name VARCHAR(20) NOT NULL,
    email VARCHAR(20) NOT NULL,
    phone varchar(11) NOT NULL
);
CREATE TABLE position
(
    Pos_id INT(11) PRIMARY KEY NOT NULL,
    Pos_name VARCHAR(20) NOT NULL,
    wage int NOT NULL
);
insert into position (Pos_id,Pos_name, wage) values (1,'Cleaner', 45000);
insert into position (Pos_id,Pos_name, wage) values (2,'Boss', 85000);
insert into position (Pos_id,Pos_name, wage) values (3,'Intern', 20000);
insert into position (Pos_id,Pos_name, wage) values (4,'Engeneer', 60000);
insert into position (Pos_id,Pos_name, wage) values (5,'Economist', 10000);
insert into department (Dep_id, Dep_name, email, phone) values (1,'Financial','financial@bk.ru','89040121212');
insert into department (Dep_id, Dep_name, email, phone) values (2,'Personal','personall@bk.ru','89040123123');