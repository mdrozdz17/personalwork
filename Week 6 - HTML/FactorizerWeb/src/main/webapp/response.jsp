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
        <title>Response</title>
    </head>
    <div class="container">
    <body style="background-color:powderblue;">
   <!-- <h1>The Answer is</h1> -->
    <center><img src="answer.jpg" alt="Could Have" height="342" width="342">
        <p></p>
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
    </body>
</html>
