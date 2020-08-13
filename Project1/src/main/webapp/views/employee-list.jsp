<%-- 
    Document   : employee-list
    Created on : Jul 16, 2020, 12:42:12 PM
    Author     : Madushan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix ="c" %>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.1/css/bootstrap.min.css" integrity="sha384-VCmXjywReHh4PwowAiWNagnWcLhlEJLA5buUprzK8rxFgeH0kww/aWY76TfkUoSX" crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/bs4/dt-1.10.21/datatables.min.css"/>


        <title>Employees</title>
    </head>
    <body>
         <jsp:include page="../header.jsp" />
        
        <%  
          String email = (String)session.getAttribute("email");
          
          if(email == null){
              response.sendRedirect("index.jsp");
          }    
        %>
        
        <a href="${pageContext.request.contextPath}/logout.jsp">Logout</a>
        
        <div class="container">
            <p>${msg}</p>
            <button class="btn btn-primary" onclick="window.location.href='views/employee-add.jsp'">Add Employee</button>
            <table border="1" class="table table-striped table" id="datatable">
            <thead>
                <tr class="thead-dark">
                <th>Name</th>
                <th>Department</th>
                <th>Date Of Birth</th>
                <th>Actions</th>
            </tr>
            </thead>
            <tbody>
                <c:forEach items="${list}" var="employee">
                <tr>
                    <td>${employee.name}</td>
                    <td>${employee.department}</td>
                    <td>${employee.dob}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/EmployeeController?action=EDIT&id=${employee.id}">Edit</a>
                        |
                        <a href="${pageContext.request.contextPath}/EmployeeController?action=DELETE&id=${employee.id}">Delete</a>
                    </td>
                        
                </tr>
            </c:forEach>
            </tbody>
        </table>
        </div>
    </body>
            <script src="https://unpkg.com/jquery@3.3.1/dist/jquery.min.js"></script>
             <script type="text/javascript" src="https://cdn.datatables.net/v/bs4/dt-1.10.21/datatables.min.js"></script>
    <script>
        $(document).ready(function(){
            $("#datatable").DataTable();
        });
        
        </script>
    

