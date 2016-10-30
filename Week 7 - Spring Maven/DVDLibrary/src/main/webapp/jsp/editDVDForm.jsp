<%-- 
    Document   : stats
    Created on : Oct 26, 2016, 8:18:41 AM
    Author     : parallels
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>DVD Library|Edit </title>
        <!-- Bootstrap CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet" />
        <!-- SWC Icon -->
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/icon.png">
    </head>
    <body style="background-color:dodgerblue;" >
        <div class="container">
            <center><h1 style="font-family: cursive;">Edit DVD</h1></center>
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
                     <li role="presentation"class>
                        <a href="${pageContext.request.contextPath}/displayNewDVDForm">Add New DVD</a>
                    </li>
                </ul>
            </div>
            <hr />
            <sf:form class="form-horizontal" role="form" modelAttribute="dvd"
                     action="editDVD"
                     method="POST">
                <div class="form-group">
                    <label for="edit-title" 
                           class="col-md-4 control-label">Title:</label>
                    <div class="col-md-8">
                        <sf:input type="text" class="form-control" required="true"
                                  id="add-title" 
                                  path="title"
                                  placeholder="Title" />
                        <!-- cssClass = "name-of-css-class" on the front should be:
                        class="name-of-css-class" -->
                        <sf:errors path="title" cssClass="error"></sf:errors>
                        </div>
                    </div>
                <div class="form-group">
                    <label for="edit-release-date"
                           class="col-md-4 control-label">Release Date:</label>
                    <div class="col-md-8">
                        <sf:input type="number" class="form-control" required="true"
                               id="add-release-date" 
                               path="releaseDate"
                               placeholder="Release Date (i.e. 2016)" />
                                <sf:errors path="releaseDate" cssClass="error"></sf:errors>
                    </div>
                </div>
                <div class="form-group">
                    <label for="edit-mpaa-rating"
                           class="col-md-4 control-label">MPAA Rating:</label>
                    <div class="col-md-8">
                       <sf:input type="text" class="form-control" required="true"
                               id="add-mpaa-rating" 
                               path="mpaaRating"
                               placeHolder= "MPAA Rating(i.e. G, PG, PG-13 and R)" />
                                <sf:errors path="mpaaRating" cssClass="error"></sf:errors>
                    </div>
                </div>
                <div class="form-group">
                    <label for="edit-directors-name"
                           class="col-md-4 control-label">Director's Name:</label>
                    <div class="col-md-8">
                        <sf:input type="text" class="form-control" required="true"
                               id="add-directors-name" 
                               path="directorsName"
                               placeHolder= "Director's Name" />
                               <sf:errors path="directorsName" cssClass="error"></sf:errors>
                    </div>
                </div>
                <div class="form-group">
                    <label for="edit-studio"
                           class="col-md-4 control-label">Studio:</label>
                    <div class="col-md-8">
                        <sf:input type="text" class="form-control" required="true"
                               id="add-studio" 
                               path="studio"
                               placeHolder= "Studio" />
                               <sf:errors path="studio" cssClass="error"></sf:errors>
                    </div>
                </div>
                  <div class="form-group">
                    <label for="edit-user-rating"
                           class="col-md-4 control-label">User Notes:</label>
                    <div class="col-md-8">
                        <sf:input type="text" class="form-control" required="true"
                               id="add-user-rating" 
                               path="userRating"
                               placeHolder= "User Notes" />
                                <sf:errors path="userRating" cssClass="error"></sf:errors>
                    </div>
                </div>
              <div class="form-group">
                    <div class="col-md-offset-4 col-md-8">
                        <sf:hidden path="dvdId" />
                        <button type="submit" id="add-button"
                                class="btn btn-primary">Edit DVD</button>
                    </div>
                </div>
            </sf:form>
        </div>
        <script src="${pageContext.request.contextPath}/js/jquery-2.2.4.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    </body>
</html>