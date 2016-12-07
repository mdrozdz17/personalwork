<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

    <script src="${pageContext.request.contextPath}/js/jquery-3.1.0.min.js"></script>

    <link href="https://code.jquery.com/ui/1.10.4/themes/ui-lightness/jquery-ui.css" rel="stylesheet">

    <script src="https://code.jquery.com/jquery-1.10.2.js"></script>

    <script src="https://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>

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


    <form class="form-horizontal" action="${pageContext.request.contextPath}/staticpage/update"
          method="POST" id="form">

        <input type="hidden" name="id" id="updateId" value="${page.id}" />

        <div class="form-group">
            <label class="col-sm-2 control-label"></label>
            <div class="col-sm-10">
                <h2>Update Static Page</h2>
            </div>
        </div>

        <div class="form-group">
            <label for="updatetitle" class="col-sm-2 control-label">Static Page Title:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="updatetitle" placeholder="Title" value="${page.title}">
            </div>

            <div class="form-group">
                <label for="updateactive">Is the the page live?</label>
                <select class="form-control" id="updateactive" value="${page.active}">
                    <option>Active</option>
                    <option>Inactive</option>
                </select>
            </div>

            <div class="form-group">
                <label for="mytextarea" class="col-sm-2 control-label">Text Body</label>
                <div class="col-sm-10">
            <textarea id="mytextarea" class="tinymce" rows="1" cols="10" name="qa" form="form"
                      value="${page.body}">${page.body}</textarea>
                </div>
            </div>



            <%--Displays vailidation errors if they occur--%>

            <div id="update-blogpost-validation-errors" style="color:red;"></div>

            <%--This div and script are used to display a home button and updates confirmation if changes are made--%>

            <div class="row">
                <div class="col-sm-4" id="confirmationUpdate"></div>
                <div class="col-sm-4" id="targetElement"></div>
            </div>

            <script id="homeRedirect" language="text">
         <input type="button" class="btn btn-primary" id="backToHome" value="Home" onclick="location.href = '${pageContext.request.contextPath}';" />
    </script>

            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <input type="button" id="updateStaticButton" value="Update Page" class="btn btn-default"/>
                </div>
            </div>
    </form>

</div>
    </div>

<script>
    var contextRoot = "${pageContext.request.contextPath}";
</script>

<script src='https://cdn.tinymce.com/4/tinymce.min.js'></script>
<script src="${pageContext.request.contextPath}/js/addStaticPage.js"></script>
<script src="${pageContext.request.contextPath}/js/updateStaticPage.js"></script>
<script src="${pageContext.request.contextPath}/js/init-tinymce.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

</body>
</html>