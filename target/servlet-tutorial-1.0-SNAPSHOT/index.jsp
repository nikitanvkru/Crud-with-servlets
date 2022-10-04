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

        <tr><td>Name:</td><td><input type="text" name="Emp_name"/></td></tr>
        <tr><td>Department:</td><td>
            <jsp:useBean id="obj" class="test.emplmanager.dao.Dao" scope="page"/>
            <select name="department_id" style="width:150px">
                <c:forEach var="var" items="${obj.departments}">
                    <option value="${var}">${var}</option>
                </c:forEach>
            </select>
        </td></tr>
        <tr><td>Position:</td><td>
            <jsp:useBean id="objc" class="test.emplmanager.dao.Dao" scope="page"/>
            <select name="position_id" style="width:150px">
                <c:forEach var="var" items="${objc.positions}">
                    <option value="${var}">${var}</option>
                </c:forEach>
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
<br/>
<a href="ViewPositionServlet">edit position table</a>
<br>
<br/>
<a href="ViewDepartmentServlet">edit department table</a>
<br>

</body>
</html>