<%-- 
    Document   : home
    Created on : Oct 26, 2016, 11:17:03 AM
    Author     : apprentice
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Vending Machine | Home</title>
        <!-- BootStrap CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
        <!-- SWC ICON -->
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/icon.png">
    </head>
        <body style="background-color:powderblue;" >
        <div class="container">
            
            <center><h1 style="font-family: initial;">Welcome To My Vending Machine</h1>
                 <hr />
                <div class ="navbar-inverse">
                    <ul class ="nav nav-tabs">
                        <li role="presentation" class="active">
                            <a href="${pageContext.request.contextPath}/home">Home</a>
                        </li>
                    </ul>

                </div> 
                        <p></p>
         Please input your money<input type="text" class="form-control" id="item" placeholder="Insert $" />
         <p></p>
          <p></p>
                <button type="submit" class="btn btn-primary">Submit</button>
         </center>
        </div>

                    <div class-container>
                    <div class="navbar- navbar-fixed-bottom"> &COPY; 2016 - Matt Drozdz</div>
                    </div>
                    
                    
        <script src="${pageContext.request.contextPath}/js/jquery-2.2.4.min.js"></script>
        <script src = "${pageContext.request.contextPath}/js/bootstrap.min.js" ></script>
    </body>
</html
