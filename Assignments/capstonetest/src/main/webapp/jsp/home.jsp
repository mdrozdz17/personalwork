<%-- 
    Document   : home
    Created on : Nov 28, 2016, 11:25:06 AM
    Author     : apprentice
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Soupa-Stars</title>
        

        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css"rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/searchForm.css"rel="stylesheet">
        <!-- SOUPA-STARS ICON -->
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/soup.jpg">
    </head>
    <body style ="background-color:powderblue;">
        <div class="container">
           <div class ="navbar-inverse">
                <ul class ="nav nav-tabs">
                    <li role="presentation" class="active">
                        <a href="${pageContext.request.contextPath}/mainPage">Home</a>
                    </li>
                      <li role="presentation">
                        <a href="${pageContext.request.contextPath}/j_spring_security_logout">Log Out</a>
                    </li> 
                    <li role ="presentation">
                        <a href="${pageContext.request.contextPath}/login">Log In</a>
                    </li>
                        <div class="col-md-4 col-md-offset-5">
                            <form action="" class="search-form">
                                <div class="form-group has-feedback">
                                    <label for="search" class="sr-only">Search</label>
                                    <input type="text" class="form-control" name="search" id="search" placeholder="search">
                                    <span class="glyphicon glyphicon-search form-control-feedback"></span>
                                </div>
                            </form>
                        </div>
                   
                </ul>   
            </div>
        </div>
        <div class="container">
            <p><a href="${pageContext.request.contextPath}/login">Log In</a></p>

            <p>
                Welcome to the Soupa-Stars Food Blog.
            </p>
        </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-2.2.4.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    </body>
</html>
