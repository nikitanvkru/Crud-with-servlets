<%@ page import="test.emplmanager.model.Emp" %>
<%@ page import="test.emplmanager.dao.Dao" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
  <meta charset="ISO-8859-1">
  <title>Edit</title>
</head>
<body>
<%
  String sid=request.getParameter("Emp_id");
  int id=Integer.parseInt(sid);

  Emp e= Dao.getEmployeeById(id);
%>
<h1>Edit Employee</h1>
<form action="EditServlet2" method="post">
  <table>
    <tr><td></td><td><input type='hidden' name='Emp_id' value='e.getEmp_id()'/></td></tr>
    <tr><td>Name:</td><td><input type="text" name="Emp_name"/></td></tr>
    <tr><td>Department:</td><td>
      <jsp:useBean id="obj" class="test.emplmanager.dao.Dao" scope="page"/>
      <select>
        <c:forEach var="aff" items="${obj.departments}">
          <option value="${aff}">${aff}</option>
        </c:forEach>
      </select>
    </td></tr>
    <tr><td>Position:</td><td>
      <jsp:useBean id="objc" class="test.emplmanager.dao.Dao" scope="page"/>
      <select>
        <c:forEach var="position_id" items="${objc.positions}">
          <option name="${position_id}">${position_id}</option>
        </c:forEach>
      </select>
    </td></tr>
    <tr><td colspan="2"><input type="submit" value="Edit Employee"/></td></tr>
  </table>
</form>


</body>
</html>