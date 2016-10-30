<%-- 
    Document   : stats
    Created on : Oct 26, 2016, 8:18:41 AM
    Author     : parallels
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>DVD Library | Add</title>
        <!-- Bootstrap CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet" />
        <!-- SWC Icon -->
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/icon.png">
    </head>
    <body style="background-color:dodgerblue;" >
        <div class="container">
            <center><h1 style="font-family: cursive;">Add New DVD</h1></center>
            <hr />
            <div class ="navbar-inverse">
                <ul class ="nav nav-tabs">
                    <li role="presentation">
                        <a href="${pageContext.request.contextPath}/home">Home</a>
                    </li>
                    <li role="presentation">
                        <a href="${pageContext.request.contextPath}/search">Search</a>
                    </li>
                    <li role="presentation">
                        <a href="${pageContext.request.contextPath}/stats">Stats</a>
                    </li>
                    <li role="presentation">
                        <a href="${pageContext.request.contextPath}/displayDVDLibrary">View DVD Library</a>
                    </li>
                     <li role="presentation"class = "active">
                        <a href="${pageContext.request.contextPath}/displayNewDVDForm">Add New DVD</a>
                    </li>
                </ul>
            </div>
            <hr />
            <form class="form-horizontal" role="form" 
                  action="addNewDvd"
                  method="POST">
                <div class="form-group">
                    <label for="add-title" 
                           class="col-md-4 control-label">Title:</label>
                    <div class="col-md-8">
                        <input type="text" required class ="form-control"
                               id="add-title" 
                               name="title"
                               placeholder="Title" />
                    </div>
                </div>

                <div class="form-group">
                    <label for="add-release-date" 
                           class="col-md-4 control-label">Release Date:</label>
                    <div class="col-md-8">
                        <input type="number" required class="form-control"
                               id="add-release-date" 
                               name="releaseDate"
                               placeholder="Release Date (i.e. 2016)" />
                    </div>
                </div>

                <div class="form-group">
                    <label for="add-mpaa-rating" 
                           class="col-md-4 control-label">MPAA Rating:</label>
                    <div class="col-md-8">
                        <input type="text" required class="form-control"
                               id="add-mpaa-rating" 
                               name="mpaaRating"
                               placeholder="MPAA Rating(i.e. G, PG, PG-13 and R)" />
                    </div>
                </div>

                <div class="form-group">
                    <label for="add-directors-name" 
                           class="col-md-4 control-label">Director's Name:</label>
                    <div class="col-md-8">
                        <input type="text" required class="form-control"
                               id="add-directors-name" 
                               name="directorsName"
                               placeholder="Director's Name" />
                    </div>
                </div>

                <div class="form-group">
                    <label for="add-studio" 
                           class="col-md-4 control-label">Studio:</label>
                    <div class="col-md-8">
                        <input type="text" required class="form-control"
                               id="add-studio" 
                               name="studio"
                               placeholder="Studio" />
                    </div>
                </div>
                <div class="form-group">
                    <label for="add-user-rating" 
                           class="col-md-4 control-label">User Notes:</label>
                    <div class="col-md-8">
                        <input type="text" required class="form-control"
                               id="add-user-rating" 
                               name="userRating"
                               placeholder="User Rating" />
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-offset-4 col-md-8">
                        <button type="submit" id="add-button"
                                class="btn btn-primary">Add New DVD</button>
                    </div>
                </div>
            </form>
        </div>
        <script src="${pageContext.request.contextPath}/js/jquery-2.2.4.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    </body>
</html>
