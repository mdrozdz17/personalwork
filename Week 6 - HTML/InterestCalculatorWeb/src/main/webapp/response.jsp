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
    <center><img src="money.jpg" alt="Could Have" height="342" width="442">
        <p></p>
        <h1><a href="InterestCalcServlet">Home</a></h1>
        <div class="table-responsive">
            <table class="table">  
                <thead>
                    <tr>
                        <th>Year</th>
                        <th>Start of Year Principal</th>
                        <th>Interest Earned this year</th>
                        <th>End of Year Principal</th>

                    </tr>
                </thead>  

                <tbody>
                    <c:forEach var="i" begin = "0" end="${param.years - 1}">
                        <tr>

                            <td>
                                ${years.get(i)}
                            </td>
                            <td>
                               ${startP.get(i)}                               
                            </td>
                            <td>
                                ${interest.get(i)}
                            </td>
                            <td>
                                ${endP.get(i)}

                            </td>
                        </tr>

                    </c:forEach>
                </tbody>

            </table>

        </div>
    </body>
</html>
