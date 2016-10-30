<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Flooring Calculator</title>
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
                        <li role="presentation"><a href="${pageContext.request.contextPath}/interestcalc">Interest Calculator</a></li>
                        <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/flooringcalc">Flooring Calculator</a></li>
                        <li role="presentation"><a href="${pageContext.request.contextPath}/tipcalc">Tip Calculator</a></li>
                        <li role="presentation"><a href="${pageContext.request.contextPath}/converter">Unit Converter</a></li>

                    </ul>    
                </div>

                <h1>Welcome to the Flooring Calculator!</h1>

                <form action="flooringcalc" class="form-horizontal" method="post">
                    <div class="form-group">
                        <div class="col-md-5 col-md-offset-4">
                            <label class="control-label col-sm-8" for="width">Enter width of floor(feet)</label>
                            <div class="col-sm-10">
                                <input type="number" step="0.001" min="0" class="form-control" name="width" required/>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-5  col-md-offset-4">
                            <label class="control-label col-sm-8" for="length">Enter length of floor(feet)</label>
                            <div class="col-sm-10">
                                <input type="number" step="0.001" class="form-control" min ="0" name="length" required/><br>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-5 col-md-offset-4">
                            <label class="control-label col-sm-9" for="cost">Enter cost of flooring per Sq. Ft.</label>
                            <div class="col-sm-10">
                                <input type="number" step="0.01" class="form-control" min ="0" name="cost" placeholder="$" required/><br>
                            </div>
                        </div>
                    </div>
                    <button type="submit" class="btn btn-primary">Submit</button>

                    </form>
            </center>
        </div>
    </center>

    <!-- Placed at the end of the document so the pages load faster -->
    <script src="${pageContext.request.contextPath}/js/jquery-2.2.4.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

</body>
</html>