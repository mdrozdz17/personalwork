<%-- 
    Document   : home
    Created on : Oct 26, 2016, 11:17:03 AM
    Author     : apprentice
--%>
<%@taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix ="s" uri="http://www.springframework.org/tags" %>
<%@taglib prefix ="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <style>
            .carousel-inner > .item > img,
            .carousel-inner > .item > a > img {
                width: 25%;
                display: block;
                margin: auto;
                height: 250px !important;
            }
        </style>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>DVD Library | View</title>
        <!-- BootStrap CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
        <!-- SWC ICON -->
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/icon.png">
    </head>
    <body style="background-color:powderblue;" >
        <div class="container">

            <div id="myCarousel" class="carousel slide" data-ride="carousel">
                <!-- Indicators -->
                <ol class="carousel-indicators">
                    <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                    <li data-target="#myCarousel" data-slide-to="1"></li>
                    <li data-target="#myCarousel" data-slide-to="2"></li>
                    <li data-target="#myCarousel" data-slide-to="3"></li>
                    <li data-target="#myCarousel" data-slide-to="4"></li>
                </ol>

                <!-- Wrapper for slides -->
                <div class="carousel-inner" role="listbox">
                    <div class="item active">
                        <img class="img-responsive center-block" src="dvd1.jpg"  alt="dvd" >
                    </div>

                    <div class="item">
                        <img class="img-responsive center-block" src="space.jpg" alt="Space Jam" >
                    </div>

                    <div class="item">
                        <img class="img-responsive center-block" src="rush1.jpg"  alt="Rush Hour">
                    </div>

                    <div class="item">
                        <img class="img-responsive center-block" src="rush2.jpg" alt="Rush Hour 2">
                    </div>

                    <div class="item">
                        <img class="img-responsive center-block" src="Home.jpg" alt="Home Alone">
                    </div>
                </div>

                <!-- Left and right controls -->
                <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
                    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                    <span class="sr-only">Previous</span>
                </a>
                <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
                    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                    <span class="sr-only">Next</span>
                </a>
            </div>


            <center><h1 style="font-family:initial;">My DVD Library</h1></center>
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
            </div><br />
            <p></p>
            <center>
                <div class="table-responsive">
                    <table class="table table-bordered table-striped">
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
                                <!-- For each DVD
                            
                                -->

                                <s:url value="deleteDVD" var="deleteDVD_url">
                                    <s:param name="dvdId" value="${dvd.dvdId}" />
                                </s:url>

                                <s:url value="displayEditDVDForm" var="editDVD_url">
                                    <s:param name="dvdId" value="${dvd.dvdId}" />
                                </s:url>

                                <tr>
                                    <td><a style="color:red" input type="button" Onclick="return ConfirmDelete();" name="actiondelete" value="1" href="${deleteDVD_url}">Delete</a></td>
                                    <td><a style="color:dodgerblue" href="${editDVD_url}">Edit</a><br /></td>
                                    <td>${dvd.title}</td><br />
                            <td>${dvd.releaseDate}</td>
                            <td>${dvd.mpaaRating}</td>
                            <td>${dvd.directorsName}</td>
                            <td>${dvd.studio}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>

                </div>
                <c:if test="${fn:length(dvd) lt 1}">
                    <form action="loadDVDS" method="POST">
                        <button type="submit" class="btn btn-primary btn-lg">Load DVDs</button>
                    </form>
                </c:if> 
        </div>
    </center>
    <script>
        function ConfirmDelete()
        {
            var x = confirm("Are you sure you want to delete?");
            if (x)
                return true;
            else
                return false;
        }
    </script>
    <script src="${pageContext.request.contextPath}/js/jquery-2.2.4.min.js"></script>
    <script src = "${pageContext.request.contextPath}/js/bootstrap.min.js" ></script>
</body>
</html
