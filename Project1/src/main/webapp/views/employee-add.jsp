<%-- 
    Document   : employee-add
    Created on : Aug 5, 2020, 4:59:28 PM
    Author     : Madushan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix ="c" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.1/css/bootstrap.min.css" integrity="sha384-VCmXjywReHh4PwowAiWNagnWcLhlEJLA5buUprzK8rxFgeH0kww/aWY76TfkUoSX" crossorigin="anonymous">
        <title>Add Employee</title>
    </head>
    <body>
        <jsp:include page="../header.jsp" />
        <%  
          String email = (String)session.getAttribute("email");
          
          if(email == null){
              response.sendRedirect("../index.jsp");
          }    
        %>
        
        <a href="${pageContext.request.contextPath}/logout.jsp">Logout</a>
        <div class="container">
            <form action="${pageContext.request.contextPath}/EmployeeController" method="POST">
            Enter Name: <input type="text" name="name" value="${employee.name}"/><br>
            Enter date of birth: <input type="date" name="dob" value="${employee.dob}"/><br>
            Enter department: <input type="text" name="department" value="${employee.department}" /><br>
            <input type="hidden" name="id" value="${employee.id}" />
            <button class="btn btn-success" type="submit" />Add Employee</button>
            </form>
    </body>
</html>
