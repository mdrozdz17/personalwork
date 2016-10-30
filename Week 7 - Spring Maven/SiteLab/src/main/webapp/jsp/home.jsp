<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Home Page</title>
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
                 <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/home">Home</a></li>
                 <li role="presentation"><a href="${pageContext.request.contextPath}/luckyseven">Lucky Sevens</a></li>
                 <li role="presentation"><a href="${pageContext.request.contextPath}/factorizor">Factorizor</a></li>
                 <li role="presentation"><a href="${pageContext.request.contextPath}/interestcalc">Interest Calculator</a></li>
                 <li role="presentation"><a href="${pageContext.request.contextPath}/flooringcalc">Flooring Calculator</a></li>
                 <li role="presentation"><a href="${pageContext.request.contextPath}/tipcalc">Tip Calculator</a></li>
                 <li role="presentation"><a href="${pageContext.request.contextPath}/converter">Unit Converter</a></li>
                 
                </ul>    
            </div>
            <center><img src="homepage.jpg" height="242" width="542" alt="Home">   
        </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-2.2.4.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
        <p></p>
<div class="container">
  <div class="panel panel-default">
      <center><div class="panel-default">Created By: Matt Drozdz > 2016 <br />
           Powered By Java and Bootstrap </div>
  </div>
</div>
    
  </div>
</div>
    </body>
</html>