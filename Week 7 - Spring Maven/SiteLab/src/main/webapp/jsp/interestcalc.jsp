<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
            <title>Interest Calculator</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">

        <!-- SWC Icon -->
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/icon.png">

    </head>
    <body style="background-color:powderblue;" >
        <div class="container">
             <center><h2>Software Craftmanship Guild Java Cohort</h2>
                <h3> JSP Site Lab </h3>
            <hr/>
            <div class="navbar">
                 <ul class="nav nav-tabs">
                 <li role="presentation"><a href="${pageContext.request.contextPath}/home">Home</a></li>
                 <li role="presentation"><a href="${pageContext.request.contextPath}/luckyseven">Lucky Sevens</a></li>
                 <li role="presentation"><a href="${pageContext.request.contextPath}/factorizor">Factorizor</a></li>
                 <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/interestcalc">Interest Calculator</a></li>
                 <li role="presentation"><a href="${pageContext.request.contextPath}/flooringcalc">Flooring Calculator</a></li>
                 <li role="presentation"><a href="${pageContext.request.contextPath}/tipcalc">Tip Calculator</a></li>
                 <li role="presentation"><a href="${pageContext.request.contextPath}/converter">Unit Converter</a></li>
                 
                </ul>    
            </div>
             <h1>Welcome to Interest Calculator!</h1>
                    <form action="interestcalc" method="post">
                        Enter annual interest rate <input type="number" step="0.01" value="rate" name="intRate" required/><br>

                        How would you like to compound interest: 
                        Daily <input type="radio" value="d" name="compound"/>
                        Monthly <input type="radio" value="m" name="compound"/>
                        Quarterly <input type="radio" value ="q" name="compound"/><br>

                        What is the initial amount of the principal? $<input type="number" step="0.01" value="amount" name="principalAmt" required/><br>

                        How many years should the money stay in the account? <input type="number" value ="year" name="years" required/><br>
                        <button type="submit" class="btn btn-primary">Show Me The Money!</button>
                </center>
        </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-2.2.4.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

    </body>
</html>