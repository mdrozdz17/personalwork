<%-- 
    Document   : response
    Created on : Oct 20, 2016, 2:30:53 PM
    Author     : apprentice
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    
    </head>
    <div class="container">
    <body style="background-color:powderblue;">
    <center><h1>The Results Are In...</h1>
        <img src="sorry.png" alt="Could Have" height="342" width="342">
        <p></p>
        <h1><a href="LuckySevensServlet">Home</a></h1>
            <p></p>
        <h4>Your starting bet was: $${param.myInput}</h4>
            <p></p>
            <h4>${broke}</h4>
            <p></p>
            <h4>${quit}</h4>
            <p></p>
    </center>
    </div>
    </body>
</html>
