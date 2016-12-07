<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link href="${pageContext.request.contextPath}/css/bootstrap.min.css"rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/searchForm.css"rel="stylesheet">

</head>
    <body>
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

    <div class="container">
        <table class="table table-responsive" id="staticPageTable" >

            <tr>
                <th>Title</th>
                <th>Status</th>
                <th>Update</th>
                <th>Delete</th>
            </tr>
            <c:forEach items="${staticPageList}" var="pages">
                <tr id="staticpage-row-${pages.id}">
                    <td><a href="${pageContext.request.contextPath}/staticpage/show/${pages.id}">${pages.title}</a></td>
                    <td>${pages.active}</td>
                    <td><a href="${pageContext.request.contextPath}/staticpage/update/${pages.id}">Update</a></td>
                    <td><a data-staticpage-id="${pages.id}" data-toggle="modal" data-target="#deleteStaticPageModal">Delete</a></td>
                </tr>
            </c:forEach>
        </table>
    </div>

        <div class="container">
        <form class="form-horizontal" action="${pageContext.request.contextPath}/staticpage/" method="POST" id="form">

            <div class="col-sm-10">
                <%--<label for="addStaticTitle" class="col-sm-2 control-label">Static Page Title</label>--%>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="addStaticTitle" placeholder="Static Page Title">
                </div>
            </div>

            <div class="col-sm-10">
                <select class="form-control" id="staticactive" path="active">
                    <option>Active</option>
                    <option>Inactive</option>
                </select>
            </div>

            <div class="col-sm-10">
                <textarea id="mytextarea" class="tinymce" rows="1" cols="10" >Body</textarea>
            </div>
            <div class="col-sm-10">
                <input type="button" id="CreateStaticPageButton" value="Add Static Page"/>
            </div>


        </form>
        </div>

    <%--!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!Delete Post Modal!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!--%>

    </div>

    <div class="modal fade" id="deleteStaticPageModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="myModalLabel">Delete Static Page</h4>
                </div>
                <div class="modal-body">

                    <input type="hidden" id="deleteId" />

                    <table>
                        <tr>
                            <th>Title: </th>
                            <td id="deleteTitle" ></td>
                        </tr>
                        <tr>
                            <th>Currently Active: </th>
                            <td id="deleteActive" ></td>
                        </tr>
                    </table>

                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    <button type="button" class="btn btn-primary" id="deleteStaticPageButton">Delete Static Page</button>
                </div>
            </div>
        </div>
    </div>


</body>



<script>
    var contextRoot = "${pageContext.request.contextPath}";
</script>


<script src="${pageContext.request.contextPath}/js/addStaticPage.js"></script>

<script src="${pageContext.request.contextPath}/js/deleteStaticPage.js"></script>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/init-tinymce.js"></script>

<script src="${pageContext.request.contextPath}/js/jquery-2.2.4.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

</body>
</html>
