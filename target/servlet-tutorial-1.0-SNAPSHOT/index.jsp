<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Insert title here</title>
</head>
<body>

<h1>Add New Employee</h1>
<form action="SaveServlet" method="post">
    <table>
        <tr><td>ID:</td><td><input type="text" name="Emp_id"/></td></tr>
        <tr><td>Name:</td><td><input type="text" name="Emp_name"/></td></tr>
        <tr><td>Department:</td><td>
            <select name="department_id" style="width:150px">
                <option>1-Bugaltery</option>
                <option>2-Financial</option>
            </select>
        </td></tr>
        <tr><td>Position:</td><td>
            <select name="position_id" style="width:150px">
                <option>1-Admin</option>
                <option>2-Engeneer</option>
                <option>3-Boss</option>
                <option>4-Intern</option>
                <option>5-Cleaner</option>
            </select>
        </td></tr>
        <tr><td colspan="2"><input type="submit" value="Save Employee"/></td></tr>
    </table>
</form>

<br/>
<a href="ViewServlet">edit employees table</a>
<br>
<br/>
<a href="ViewAllServlet">view employees</a>
<br>

</body>
</html>