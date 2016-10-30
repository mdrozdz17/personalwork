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
        <title>Results</title>
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
                        <li role="presentation"class="active"><a href="${pageContext.request.contextPath}/factorizor">Factorizor</a></li>
                        <li role="presentation"><a href="${pageContext.request.contextPath}/interestcalc">Interest Calculator</a></li>
                        <li role="presentation"><a href="${pageContext.request.contextPath}/flooringcalc">Flooring Calculator</a></li>
                        <li role="presentation"><a href="${pageContext.request.contextPath}/tipcalc">Tip Calculator</a></li>
                        <li role="presentation"><a href="${pageContext.request.contextPath}/converter">Unit Converter</a></li>

                    </ul>    
                </div>
                <h1><a href="FactorizerServlet">Home</a></h1>
                <p></p>
                <h4>The number you put in was: ${param.myInput}</h4>
                <h4>The factors of ${param.myInput} are:
                    <c:forEach var="factor" items="${factors}" varStatus="status">
                        <c:out value="${factor}"/> 
                        <c:if test="${!status.last}">,</c:if>
                    </c:forEach></h4>

                <h4>${prime}</h4>
                <h4>${perfect}</h4>
                <p></p>
            </center>
        </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-2.2.4.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    </body>
</html>
