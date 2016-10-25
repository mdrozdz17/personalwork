<%-- 
    Document   : response
    Created on : Oct 20, 2016, 2:30:53 PM
    Author     : apprentice
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" 
           uri="http://java.sun.com/jsp/jstl/fmt" %>
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
        <div class="container">
            <div class="navbar navbar-inverse navbar-fixed-top" role="navigation">

                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>

                    <a class="navbar-brand" href="UnitConvertServlet">Home</a>
                    <p></p>
                </div>
            </div>
            <p></p>
            <center><img src="answer.jpg" alt="Could Have" height="242" width="342">
                <p></p>

                <c:if test="${not empty(result)}" >
                    <h4> The conversion you choose is: <c:out value="${result.conversionType}"/></h4>
                    <h4>You are converting from: <c:out value="${result.fromUnit}"/></h4>
                    <h4>You are converting to: <c:out value="${result.toUnit}"/></h4>
                    <h4>The result is: <fmt:formatNumber pattern="0.00" value = "${result.toValue}" /></h4>
                </c:if>
        </div>      
    </body>
</html>
