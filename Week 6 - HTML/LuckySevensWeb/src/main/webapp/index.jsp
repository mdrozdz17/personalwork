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

        <title>Lucky Sevens</title>
        <!-- Bootstrap core CSS -->
        <link href="css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="css/starter-template.css" rel="stylesheet">
        
   <script>
        <!--
            function letsPlay() {
               alert("Good Luck!")
            }
         //-->
        </script>

    </head>
    <body style="background-color:powderblue;" onload=alert(today)>
        <div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand">Lucky Sevens</a>
                </div>
                <div class="collapse navbar-collapse">
                    <ul class="nav navbar-nav">
                    </ul>
                </div><!--/.nav-collapse -->
            </div>
        </div>

        <div class="container">

            <div class="starter-template">
               <div id="animation"></div>
                <center><img src="Lucky7.png" height="342" width="742" alt="Lucky">         
                 <h1>Welcome to Lucky Sevens!</h1>
                 <h4>How much money would you like to bet?</h4>
                <form action="LuckySevensServlet" method="post">
                    <b>Input Money:</b>
                    <input type="number" min= "0" max="10000000" name="myInput" required/><br/>
                    <p></p>
                    <button type="submit" onclick="letsPlay()" class="btn btn-primary">Roll Dice</button>
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
