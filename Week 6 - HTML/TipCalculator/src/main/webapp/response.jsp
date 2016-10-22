<%-- 
    Document   : response
    Created on : Oct 20, 2016, 2:30:53 PM
    Author     : apprentice
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Bootstrap core CSS -->
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <title>Response</title>
    </head>

    <body style="background-color:powderblue;">
        <!-- <h1>The Answer is</h1> -->
         <h3><a href="TipCalcServlet">Home</a></h3>
    <center><img src="thanks.png" alt="Could Have" height="342" width="442">
        <p></p>
        
        <h4>Amount of Bill: $${total}</h4>
                <h4>Your Tip Percentage: ${tip}%</h4>
                <h4>Tip Amount: $${tipAmount}</h4>
                <h4>Total Bill: $${totalCost}</h4>
                <p></p>
               


    </body>
</html>
