<%-- 
    Document   : Home
    Created on : Nov 15, 2016, 1:46:42 PM
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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Soupa-Stars | Home</title>
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
                        <a href="${pageContext.request.contextPath}/">Home</a>
                    </li>

                    <div class="row">
                        <div class="col-md-4 col-md-offset-4">
                            <form action="" class="search-form">
                                <div class="form-group has-feedback">
                                    <label for="search" class="sr-only">Search</label>
                                    <input type="text" class="form-control" name="search" id="search" placeholder="search">
                                    <span class="glyphicon glyphicon-search form-control-feedback"></span>
                                </div>
                            </form>
                        </div>
                    
                        <li role ="presentation">
                            <a href="${pageContext.request.contextPath}/login"><button type="submit" class="btn btn-success">Log In</button></a>
                            <a href="${pageContext.request.contextPath}/j_spring_security_logout"><button type ="submit" class="btn btn-danger">Log Out</button></a>
                        <li>
                      
                    
                    </div>   
                </ul> 

            </div>


            <!-- Page Content -->

            <div class="row">

                <!-- Blog Entries Column -->
                <div class="col-md-8">

                    <h1 class="page-header">
                        <center><img class="img-responsive" src="star.jpg"  alt="star" width="104" height="236" >
                            <h1 style="font-family: initial;">Soupa-Stars Food Blog</h1></center>

                    </h1>
        
                   
                    <div class = table-responsive" id="postTable">
                        <table>
                        <tbody id="postRows"></tbody>
                   

                    </table>
                    </div>
                        

                    <!-- First Blog Post -->
                    <!--                    <h2>
                                            <a href="#">Blog Post Title</a>
                                        </h2>
                                        <p class="lead">
                                            by <a href="index.php">Start Bootstrap</a>
                                        </p>
                                        <p><span class="glyphicon glyphicon-user"></span><a href="#"> Author </a>&nbsp;
                                            <span class="glyphicon glyphicon-time"></span> Posted on August 28, 2013 at 10:00 PM&nbsp;
                                            <span class="glyphicon glyphicon-duplicate"></span><a href="#"> Category </a>&nbsp;
                                            <span class="glyphicon glyphicon-comment"></span><a href="#"> # Comment </a>&nbsp;
                                        </p>
                                        <hr>
                                        <img class="img-responsive" src="http://placehold.it/900x300" alt="">
                                        <hr>
                                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Dolore, veritatis, tempora, necessitatibus inventore nisi quam quia repellat ut tempore laborum possimus eum dicta id animi corrupti debitis ipsum officiis rerum.</p>
                                        <a class="btn btn-primary" href="#">Read More <span class="glyphicon glyphicon-chevron-right"></span></a>
                                        <a class="btn btn-" href="#">Edit <span class="glyphicon glyphicon-chevron-left"></span>
                    
                                        <hr>
                    
                                         Second Blog Post 
                                        <h2>
                                            <a href="#">Blog Post Title</a>
                                        </h2>
                                        <p class="lead">
                                            by <a href="index.php">Start Bootstrap</a>
                                        </p>
                                        <p><span class="glyphicon glyphicon-user"></span><a href="#"> Author </a>&nbsp;
                                            <span class="glyphicon glyphicon-time"></span> Posted on August 28, 2013 at 10:00 PM&nbsp;
                                            <span class="glyphicon glyphicon-duplicate"></span><a href="#"> Category </a>&nbsp;
                                            <span class="glyphicon glyphicon-comment"></span><a href="#"> # Comment </a>&nbsp;
                                        </p>
                                        <hr>
                                        <img class="img-responsive" src="http://placehold.it/900x300" alt="">
                                        <hr>
                                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Quibusdam, quasi, fugiat, asperiores harum voluptatum tenetur a possimus nesciunt quod accusamus saepe tempora ipsam distinctio minima dolorum perferendis labore impedit voluptates!</p>
                                        <a class="btn btn-primary" href="#">Read More <span class="glyphicon glyphicon-chevron-right"></span></a>
                    
                                        <hr>
                    
                                         Third Blog Post 
                                        <h2>
                                            <a href="#">Blog Post Title</a>
                                        </h2>
                                        <p class="lead">
                                            by <a href="index.php">Start Bootstrap</a>
                                        </p>
                                        <p><span class="glyphicon glyphicon-user"></span><a href="#"> Author </a>&nbsp;
                                            <span class="glyphicon glyphicon-time"></span> Posted on August 28, 2013 at 10:00 PM&nbsp;
                                            <span class="glyphicon glyphicon-duplicate"></span><a href="#"> Category </a>&nbsp;
                                            <span class="glyphicon glyphicon-comment"></span><a href="#"> # Comment </a>&nbsp;
                                        </p>
                                        <hr>
                                        <img class="img-responsive" src="http://placehold.it/900x300" alt="">
                                        <hr>
                                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Cupiditate, voluptates, voluptas dolore ipsam cumque quam veniam accusantium laudantium adipisci architecto itaque dicta aperiam maiores provident id incidunt autem. Magni, ratione.</p>
                                        <a class="btn btn-primary" href="#">Read More <span class="glyphicon glyphicon-chevron-right"></span></a>
                    
                                        <hr>-->

                    <!-- Pager -->
                    <ul class="pager">
                        <li class="previous">
                            <a href="#">&larr; Older</a>
                        </li>
                        <li class="next">
                            <a href="#">Newer &rarr;</a>
                        </li>
                    </ul>

                </div>

                <!-- Blog Sidebar Widgets Column -->
                <div class="col-md-4">
                    <p></p>
                    <!-- Blog Search Well -->
                    <div class="well">
                        <h4>Blog Search</h4>
                        <div class="input-group">
                            <input type="text" class="form-control">
                            <span class="input-group-btn">
                                <button class="btn btn-default" type="button">
                                    <span class="glyphicon glyphicon-search"></span>
                                </button>
                            </span>
                        </div>
                        <!-- /.input-group -->
                    </div>

                    <!-- Authors -->
                    <div class="well">
                        <h4>Authors</h4>
                        <div class="row">
                            <div class="col-md-6">
                                <table id="authorTable">
                                    <tablebody id="authorRows"></tablebody>
                                </table>
                            </div>
                            <!-- /.col-md-6 -->
                            <!--                            <div class="col-md-6">
                                                            <ul class="list-unstyled">
                                                                <li><a href="#">Author</a>
                                                                </li>
                                                                <li><a href="#">Author</a>
                                                                </li>
                                                                <li><a href="#">Author</a>
                                                                </li>
                                                                <li><a href="#">Author</a>
                                                                </li>
                                                            </ul>
                                                        </div>-->
                            <!-- /.col-md-6 -->
                        </div>
                        <!-- /.row -->
                    </div>


                    <!-- Blog Categories Well -->
                    <div class="well">
                        <h4>Blog Categories</h4>
                        <div class="row">
                            <div class="col-md-8">
                                <table id="categoryTable">
                                    <tablebody id="categoryRows"></tablebody>
                                </table>
                            </div>
                        </div>
                        <!-- /.row -->
                    </div>

                    <!-- Tags -->
                    <div class="well">
                        <h4>Tags</h4>
                        <table id="tagTable">
                            <tablebody id="tagRows"></tablebody>
                        </table>
                        <!--                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Inventore, perspiciatis adipisci accusamus laudantium odit aliquam repellat tempore quos aspernatur vero.</p>-->
                    </div>

                </div>

            </div>
            <!-- /.row -->

            <hr>

            <!-- Footer -->
            <footer>
                <div class="row">
                    <div class="col-lg-12">
                        <p>Copyright &copy; Soupa-Stars 2016</p>
                    </div>
                    <!-- /.col-lg-12 -->
                </div>
                <!-- /.row -->
            </footer>

        </div>
        <script>
            var today = new Date;
            document.getElementById('date').innerHTML = today.toDateString();
        </script>

        <script src="${pageContext.request.contextPath}/js/jquery-2.2.4.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

        <script src="${pageContext.request.contextPath}/js/mainPage.js"></script>

    </body>
</html>
