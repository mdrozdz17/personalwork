<%-- 
    Document   : index
    Created on : Oct 20, 2016, 2:22:30 PM
    Author     : apprentice
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">
        <link rel="shortcut icon" href="http://getbootstrap.com/assets/ico/favicon.ico">

        <title>Factorizer</title>
        <!-- Bootstrap core CSS -->
        <link href="css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="css/starter-template.css" rel="stylesheet">

    </head>
    <body style="background-color:powderblue;">
        <div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="http://getbootstrap.com/examples/starter-template/#">Factorizer</a>
                </div>
                <div class="collapse navbar-collapse">
                    <ul class="nav navbar-nav">
                    </ul>
                </div><!--/.nav-collapse -->
            </div>
        </div>

        <div class="container">

            <div class="starter-template">
               
                <center><img src="factor.png" height="200" width="442" alt="Lucky">         
                 <h1>Welcome to Factorizer!</h1>
                 <h4>Please type in the number you would like to factor?</h4>
                <form action="FactorizerServlet" method="post">
                    <b>Input Number:</b>
                     <input type="number" min ="1" max ="10000000" name="myInput"/><br/>
                    <p></p>
                    <button type="submit" class="btn btn-primary">Factor Me</button>
                </center>
                </form>
            </div>
        </div>
        
             <!-- Bootstrap core JavaScript
        ================================================== -->
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="js/jquery-1.11.0.min.js"></script>
        <script src="js/bootstrap.min.js"></script>

    </body>
</html>
