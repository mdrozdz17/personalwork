<%-- 
    Document   : home
    Created on : Oct 26, 2016, 11:17:03 AM
    Author     : apprentice
--%>
<%@taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix ="s" uri="http://www.springframework.org/tags" %>
<%@taglib prefix ="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>DVD Library | View</title>
        <!-- BootStrap CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
        <!-- SWC ICON -->
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/icon.png">
    </head>
    <body style="background-color:dodgerblue;" >
        <div class="container">

            <center><h1 style="font-family: cursive;">My DVD Library</h1></center>
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
                    <li role="presentation" class ="active">
                        <a href="${pageContext.request.contextPath}/displayDVDLibrary">View DVD Library</a>
                    </li>
                    <li role="presentation">
                        <a href="${pageContext.request.contextPath}/displayNewDVDForm">Add New DVD</a>
                    </li>
                </ul>
            </div>
            <p></p>
            <center><img src="movie.jpg" height="280" width="442" alt="movie"> 
                <div class="table-responsive">
                    <table class="table table-bordered">
                        <thead>
                            <tr>
                                <th>Delete</th>
                                <th>Edit</th>
                                <th>Title</th>
                                <th>Release Date</th>
                                <th>MPAA Rating</th>
                                <th>Directors Name</th>
                                <th>Studio</th>
                                <th>User Notes</th>

                            </tr>
                        </thead>
                        <tbody>
                            <!-- interate through our DVDs and show information -->
                            <c:forEach var="dvd" items="${dvdLibrary}">
                                <!-- For each contact:
                                1. First Name & Last Name
                                2. Edit Link
                                3. Delete Link
                                -->

                                <s:url value="deleteDVD" var="deleteDVD_url">
                                    <s:param name="dvdId" value="${dvd.dvdId}" />
                                </s:url>

                                <s:url value="displayEditDVDForm" var="editDVD_url">
                                    <s:param name="dvdId" value="${dvd.dvdId}" />
                                </s:url>

                                <tr>
                                    <td><a style="color:red" href="${deleteDVD_url}">Delete</a></td>
                                    <td><a style="color:lemonchiffon" href="${editDVD_url}">Edit</a><br /></td>
                                    <td>${dvd.title}</td><br />
                            <td>${dvd.releaseDate}</td>
                            <td>${dvd.mpaaRating}</td>
                            <td>${dvd.directorsName}</td>
                            <td>${dvd.studio}</td>
                            <td> ${dvd.userRating}</td>
                            </tr>

                        </c:forEach>
                        </tbody>
                    </table>

                </div>
        </div>
        <script src="${pageContext.request.contextPath}/js/jquery-2.2.4.min.js"></script>
        <script src = "${pageContext.request.contextPath}/js/bootstrap.min.js" ></script>
    </body>
</html
