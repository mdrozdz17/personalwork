<%-- 
    Document   : stats
    Created on : Oct 26, 2016, 8:18:41 AM
    Author     : parallels
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
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
    <body style="background-color:powderblue;" >
        <div class="container">
            <center><h1 style="font-family: initial;">Add New DVD</h1></center>
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
            <sf:form class="form-horizontal" role="form" modelAttribute="dvd"
                     action="addNewDvd"
                     method="POST">
                <div class="form-group">
                    <label for="add-title" 
                           class="col-md-4 control-label">Title:</label>
                    <div class="col-md-5">
                        <sf:input type="text" class ="form-control"  required ="true" max = "50"
                                  id="add-title" 
                                  path="title"
                                  placeholder="Title" />
                        <sf:errors path="title" cssClass="error"></sf:errors>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="add-release-date" 
                               class="col-md-4 control-label">Release Date:</label>
                        <div class="col-md-5">
                        <sf:input type="number" class="form-control" min = "1900" max = "2017" maxlength = "4" required ="true"
                                  id="add-release-date" 
                                  path="releaseDate"
                                  placeholder="Release Date (i.e. 2016)" />
                        <sf:errors path="releaseDate" cssClass="error"></sf:errors>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="add-mpaa-rating" 
                               class="col-md-4 control-label">MPAA Rating:</label>
                        <div class="col-md-5">
                        <sf:select id="add-mpaa-rating" path="mpaaRating" style="width: 373px;">
<option disabled ="disabled" selected="selected" value="default">Please Select An Option</option>
                            <sf:option value="G">G</sf:option>
                            <sf:option value="PG">PG</sf:option>
                            <sf:option value="PG-13">PG-13</sf:option>
                            <sf:option value="R">R</sf:option>
                            <sf:option value="NC-17">NC-17</sf:option>
                            <sf:option value="NR">NR</sf:option>
                             </sf:select>
                     <sf:errors path="mpaaRating" cssClass="error"></sf:errors>
                    </div>
                </div>

                <div class="form-group">
                    <label for="add-directors-name" 
                           class="col-md-4 control-label">Director's Name:</label>
                    <div class="col-md-5">
                        <sf:input type="text" class="form-control" required = "true" max = "50"
                                  id="add-directors-name" 
                                  path="directorsName"
                                  placeholder="Director's Name" />
                        <sf:errors path="directorsName" cssClass="error"></sf:errors>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="add-studio" 
                               class="col-md-4 control-label">Studio:</label>
                        <div class="col-md-5">
                        <sf:input type="text" class="form-control" required = "true" max = "50"
                                  id="add-studio" 
                                  path="studio"
                                  placeholder="Studio" />
                        <sf:errors path="studio" cssClass="error"></sf:errors>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="add-user-rating" 
                               class="col-md-4 control-label">User Notes:</label>
                        <div class="col-md-5">
                        <sf:input type="text" class="form-control" required = "true" max = "100"
                                  id="add-user-rating" 
                                  path="userRating"
                                  placeholder="User Rating" />
                        <sf:errors path="userRating" cssClass="error"></sf:errors>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-offset-4 col-md-8">
                        <sf:hidden path="dvdId" />
                    <button type="submit" id="add-button"
                                class="btn btn-primary">Add New DVD</button>
                    </div>
                </div>
            </sf:form>
        </div>
        <script src="${pageContext.request.contextPath}/js/jquery-2.2.4.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    </body>
</html>
