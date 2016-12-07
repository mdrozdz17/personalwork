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

    <table class="container">
        <tr>
            <%--<th>Body:</th>--%>
            <td>${page.body}</td>
        </tr>

    </table>

</body>
</html>
