<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="test.css">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.1/css/bootstrap.min.css" integrity="sha384-VCmXjywReHh4PwowAiWNagnWcLhlEJLA5buUprzK8rxFgeH0kww/aWY76TfkUoSX" crossorigin="anonymous">
        <title>Admin Login</title>
    <body>
        <%  
          String email = (String)session.getAttribute("email");
          
          if(email != null){
              response.sendRedirect("EmployeeController?action=LIST");
          } 

        %>
        
   
        
   <div class="loginbox">
    <img src="admin.jpg" class="avatar">
    <h1>Admin Login</h1>
    <form action="LoginProcess" method="POST">
  <div class="form-group">
    <label for="exampleInputEmail1">Email address</label>
    <input type="email" class="form-control" id="exampleInputEmail1" name="email" aria-describedby="emailHelp" placeholder="Enter email">
   
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">Password</label>
    <input type="password" class="form-control" id="exampleInputPassword1" name="password" placeholder="Password">
  <small id="emailHelp" class="form-text text-danger"> <% String status = request.getParameter("status");
        if(status != null){
            if(status.equals("false")){
                out.print("Incorrect username or password");
            }else if(status.equals("error")){
                out.print("something went wrong");
            }
        } %> </small>
  </div>
  
  <button type="submit" class="btn btn-dark btn-block">Sign In</button>
</div>
    </body>
    </head>
        