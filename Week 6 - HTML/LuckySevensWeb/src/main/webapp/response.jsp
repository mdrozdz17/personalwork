<%-- 
    Document   : response
    Created on : Oct 20, 2016, 2:30:53 PM
    Author     : apprentice
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Response</title>
    </head>
    <div class="container">
    <body style="background-color:powderblue;">
    <center><h1>The Results Are In...</h1>
        <img src="sorry.png" alt="Could Have" height="342" width="342">
        <p></p>
        <h1><a href="LuckySevensServlet">Home</a></h1>
            <p></p>
        <h4>Your starting bet was: $${param.dollar}</h4>
            <p></p>
            <h4>${message1}</h4>
            <p></p>
            <h4>${message2}</h4>
            <p></p>
    </center>
    </div>
    </body>
</html>
