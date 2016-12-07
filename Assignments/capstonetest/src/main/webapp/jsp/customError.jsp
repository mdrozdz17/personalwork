<%-- 
    Document   : Error
    Created on : Nov 15, 2016, 1:46:55 PM
    Author     : apprentice
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Soupa-Stars | Error</title>
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
                    <div class="row">
                        <div class="col-md-4 col-md-offset-6">
                            <form action="" class="search-form">
                                <div class="form-group has-feedback">
                                    <label for="search" class="sr-only">Search</label>
                                    <input type="text" class="form-control" name="search" id="search" placeholder="search">
                                    <span class="glyphicon glyphicon-search form-control-feedback"></span>
                                </div>
                            </form>
                        </div>
                    </div>
                </ul>   
            </div>
            <center><h1>An error has occurred...</h1>
                 <img class="img-responsive" src="https://3.bp.blogspot.com/-ad69Y3hy2yU/UxJS4cpgzKI/AAAAAAAAANM/GFkNMxAWlJ4/s1600/Posters+-+teams+in+the+classroom-3.png" alt="pea" width="334" height="280">
                <h3>${errorMessage}</h3>
        </div>

    </div>
</center>     
            <script src="${pageContext.request.contextPath}/js/jquery-2.2.4.min.js"></script>
            <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
</body>
</html>
