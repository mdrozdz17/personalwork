<%-- 
    Document   : search
    Created on : Oct 26, 2016, 11:18:14 AM
    Author     : apprentice
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>DVD Library | Search</title>
        <!-- BootStrap CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
        <!-- SWC ICON -->
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/icon.png">
    </head>
    <body style="background-color:powderblue;" >
        <div class="container">

            <center><h1 style="font-family: initial;">Search</h1>
            <hr />
            <div class ="navbar-inverse">
                <ul class ="nav nav-tabs">
                    <li role="presentation">
                        <a href="${pageContext.request.contextPath}/home">Home</a>
                    </li>
                    <li role="presentation" class="active">
                        <a href="${pageContext.request.contextPath}/search">Search</a>
                    </li>
                    <li role="presentation">
                        <a href="${pageContext.request.contextPath}/stats">Stats</a>
                    </li>
                    <li role="presentation">
                        <a href="${pageContext.request.contextPath}/displayDVDLibrary">View DVD Library</a>
                    </li>
                    <li role="presentation">
                        <a href="${pageContext.request.contextPath}/displayNewDVDForm">Add New DVD</a>
                    </li>
                </ul>
            </div>
                    <div class="row">
                <div class="col-md-6 col-lg-6 col-xs-6">
                    <!-- Our list of contacts -->
                    <center><h2>My DVD's</h2></center>
                    <table id="dvdTable" class="table table-hover table-striped">
                        <tr>
                            <th width="40%">Title</th>
                            <th width="30%">Release Date</th>
                            <th width="15%"></th>
                            <th width="15%"></th>
                        </tr>
                        <!-- This is where our contacts will be.  We will populate this with JS -->
                        <tbody id="contentRows"></tbody>
                    </table>
                </div>
                <div class="col-md-6 col-lg-6 col-xs-6">
                    <h2>Search for DVD</h2>
                    <form class="form-horizontal" role="form">
                        <div class="form-group">
                            <label for="search-title" 
                                   class="col-md-4 control-label">Title:</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" id="search-title" placeholder="Title" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="search-release-date" 
                                   class="col-md-4 control-label">Release Date:</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" id="search-release-date" placeholder="Release Date (i.e. 2016)" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="search-mpaa-rating" 
                                   class="col-md-4 control-label">MPAA Rating:</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" id="search-mpaa-rating" placeholder="MPAA Rating(i.e. G, PG, PG-13 and R)" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="search-directors-name" 
                                   class="col-md-4 control-label">Director's Name:</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" id="search-directors-name" placeholder="Director's Name" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="search-studio" 
                                   class="col-md-4 control-label">Studio:</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" id="search-studio" placeholder="Studio" />
                            </div>
                        </div>
                          <div class="form-group">
                            <label for="search-user-rating" 
                                   class="col-md-4 control-label">User Rating: </label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" id="search-user-rating" placeholder="User Rating" />
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-offset-4 col-md-8">
                                <button type="submit"
                                        id="search-button"
                                        class="btn btn-primary">
                                    Search for DVD's
                                </button>
                            </div>
                        </div>
                    </form>
                     <div class="modal fade" id="editModal" tabindex="-1" role="dialog"
                 aria-labelledby="editDetailsModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal">
                                <span aria-hidden="true">&times;</span>
                                <span class="sr-only">Close</span>
                            </button>
                            <h4 class="modal-title" id="editDetailsModalLabel"s>Edit Dvd</h4>
                        </div>
                        <div class="modal-body">
                            <h2>Edit Dvd</h2>
                            <form class="form-horizontal" role="form">
                                <div class="form-group">
                                    <label for="edit-title" 
                                           class="col-md-4 control-label">Title:</label>
                                    <div class="col-md-8">
                                        <input type="text" class="form-control" id="edit-title" placeholder="Title" />
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="edit-release-date" 
                                           class="col-md-4 control-label">Release Date:</label>
                                    <div class="col-md-8">
                                        <input type="text" class="form-control" id="edit-release-date" placeholder="Release Date (i.e. 2016)" />
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="edit-mpaa-rating" 
                                           class="col-md-4 control-label">MPAA Rating:</label>
                                    <div class="col-md-8">
                                        <input type="text" class="form-control" id="edit-mpaa-rating" placeholder="MPAA Rating(i.e. G, PG, PG-13 and R)" />
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="edit-directors-name" 
                                           class="col-md-4 control-label">Director's Name:</label>
                                    <div class="col-md-8">
                                        <input type="text" class="form-control" id="edit-directors-name" placeholder="Director's Name" />
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="edit-studio" 
                                           class="col-md-4 control-label">Studio:</label>
                                    <div class="col-md-8">
                                        <input type="text" class="form-control" id="edit-studio" placeholder="Studio" />
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="edit-user-rating" 
                                           class="col-md-4 control-label">User Rating:</label>
                                    <div class="col-md-8">
                                        <input type="text" class="form-control" id="edit-user-rating" placeholder="User Rating" />
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-md-offset-4 col-md-8">
                                        <button type="submit"
                                                id="edit-button"
                                                class="btn btn-primary" data-dismiss="modal">
                                            Edit Dvd
                                        </button>
                                        <button type="button" class="btn btn-primary" data-dismiss="modal">Cancel</button>

                                        <input type="hidden" id="edit-dvd-id" />
                                       
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>             
        </div>
                        <div class="modal fade" id="detailsModal" tabindex="-1" role="dialog"
                 aria-labelledby="detailsModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal">
                                <span aria-hidden="true">&times;</span>
                                <span class="sr-only">Close</span>
                            </button>
                            <h4 class="modal-title" id="detailsModalLabel">DVD Details</h4>
                        </div>
                        <div class="modal-body">
                            <h3 id="dvdId"></h3>
                            <table class="table table-bordered">
                                <tr>
                                    <th>Title:</th>
                                    <td id="dvd-title"></td>
                                </tr>
                                <tr>
                                    <th>Release Date:</th>
                                    <td id="dvd-releaseDate"></td>
                                </tr>
                                <tr>
                                    <th>MPAA Rating:</th>
                                    <td id="dvd-mpaaRating"></td>
                                </tr>
                                <tr>
                                    <th>Director's Name:</th>
                                    <td id="dvd-directorsName"></td>
                                </tr>
                                <tr>
                                    <th>Studio:</th>
                                    <td id="dvd-studio"></td>
                                </tr>
                                   <tr>
                                    <th>User Rating:</th>
                                    <td id="dvd-userRating"></td>
                                </tr>
                            </table>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-primary" data-dismiss="modal">Close</button>
                        </div>
                    </div>
                </div>
            </div>
            </center>
        <script src="${pageContext.request.contextPath}/js/jquery-2.2.4.min.js"></script>
        <script src = "${pageContext.request.contextPath}/js/bootstrap.min.js" ></script>
        <script src="${pageContext.request.contextPath}/js/dvdLibrary.js"></script>

    </body>
</html>
