<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    <title>Tip Calculator</title>
    <!-- Bootstrap core CSS -->
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">

    <!-- SWC Icon -->
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/icon.png">

</head>
<body style="background-color:powderblue;" >
<body>
    <div class="container">
        <center><h2>Software Craftmanship Guild Java Cohort</h2>
            <h3> JSP Site Lab </h3>
            <hr/>
            <div class="navbar">
                <ul class="nav nav-tabs">
                    <li role="presentation"><a href="${pageContext.request.contextPath}/home">Home</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/luckyseven">Lucky Sevens</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/factorizor">Factorizor</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/interestcalc">Interest Calculator</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/flooringcalc">Flooring Calculator</a></li>
                    <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/tipcalc">Tip Calculator</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/converter">Unit Converter</a></li>

                </ul>    
            </div>
            <h1>Welcome to Tip Calculator!</h1>
            <form action="tipcalc" method="post">
                Enter the total $<input type="number" step="0.01" name="total" required/><br>
                <p></p>
                Enter the Tip % <input type="number" name="tip" required/><br>
                <p></p>
                <button type="submit" class="btn btn-primary">Submit</button>
        </center>
    </form>
</div>
<!-- Placed at the end of the document so the pages load faster -->
<script src="${pageContext.request.contextPath}/js/jquery-2.2.4.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

</body>
</html>