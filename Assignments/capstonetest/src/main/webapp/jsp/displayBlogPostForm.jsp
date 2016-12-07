<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Soupa-Stars  | Add Blog Post</title>
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css"rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/searchForm.css"rel="stylesheet">
        <!-- SOUPA-STARS ICON -->
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/soup.jpg">
        <!-- Used for Text Editing -->
        <script src="//cdn.tinymce.com/4/tinymce.min.js"></script>
        <script>tinymce.init({
                selector: "textarea", // change this value according to your HTML
                plugins: [
                   
                    "paste",
                    "advlist autolink lists link image charmap print preview anchor",
                    "searchreplace visualblocks code fullscreen",
                    "insertdatetime media table contextmenu paste",
                    'emoticons template paste textcolor colorpicker textpattern imagetools codesample',
                   
                ],
              width : 600,
         height : 90,
         theme_advanced_resizing_min_height : 90,
         theme_advanced_resizing_max_height : 180,
                toolbar: "paste",
                paste_data_images: true,
                force_p_newlines : false,
                forced_root_block : '',
                toolbar1: 'insertfile undo redo | styleselect | bold italic | alignleft aligncenter alignright alignjustify | bullist numlist outdent indent | link image |print preview media | forecolor backcolor emoticons | codesample',
            });
        </script>
    </head>
    <body style="background-color:powderblue;" >
        <div class="container">
            <center><h1 style="font-family: initial;">Add New Blog Post</h1></center>
            <hr />
            <body style ="background-color:powderblue;">
                <div class="container">
                    <div class ="navbar-inverse">
                        <ul class ="nav nav-tabs">
                            <li role="presentation" class="active">
                                <a href="${pageContext.request.contextPath}/mainPage">Home</a>
                            </li>

                            <div class="row">
                                <div class="col-md-4 col-md-offset-5">
                                    <form action="" class="search-form">
                                        <div class="form-group has-feedback">
                                            <label for="search" class="sr-only">Search</label>
                                            <input type="text" class="form-control" name="search" id="search" placeholder="search">
                                            <span class="glyphicon glyphicon-search form-control-feedback"></span>
                                        </div>
                                    </form>
                                </div>
                                <li role ="presenation">
                                    <a href="${pageContext.request.contextPath}/login"><button type="submit" class="btn btn-success">Log In</button></a>
                                    <a href="${pageContext.request.contextPath}/j_spring_security_logout"><button type ="submit" class="btn btn-danger">Log Out</button></a>
                                <li>
                            </div>   
                        </ul> 

                    </div>

                    <hr />
                    <sf:form class="form-horizontal" role="form" modelAttribute="post"
                             action="addNewBlogPost"
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
                                <label for="add-Category" 
                                       class="col-md-4 control-label">Categories:</label>
                                <div class="col-md-5">
                                <sf:input type="text" class ="form-control"  required ="true" max = "100"
                                          id="add-Category" 
                                          path="Category"
                                          placeholder="Category" />
                                <sf:errors path="category" cssClass="error"></sf:errors>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="add-body"
                                       class="col-md-4 control-label">Body of Post:</label>
                                <div class="col-md-7">

                                <sf:textarea rows = "8" type="text" class="form-control" max = "10000"
                                             id="add-body" 
                                             path="body"
                                             placeholder="Text Goes Here" />
                                </textarea>
                                <sf:errors path="body" cssClass="error"></sf:errors>
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="add-tagList" 
                                       class="col-md-4 control-label">Tags</label>
                                <div class="col-md-5">
                                <sf:input type="text" class ="form-control"  required ="true" max = "300"
                                          id="add-tagList" 
                                          path="tagList"
                                          placeholder="Tags" />
                                <sf:errors path="tagList" cssClass="error"></sf:errors>
                                </div>
                            </div>


                            <div class="form-group">
                                <div class="col-md-offset-4 col-md-8">
                                <sf:hidden path="postId" />
                                
                                <button type="submit" id="add-button"
                                        class="btn btn-primary">Add New Post</button>
                            </div>
                        </div>
                    </div>

                </sf:form>
        </div>
        <script src="${pageContext.request.contextPath}/js/jquery-2.2.4.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    </body>
</html>
