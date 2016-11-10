<%-- 
    Document   : stats
    Created on : Oct 26, 2016, 11:18:34 AM
    Author     : apprentice
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>DVD Library | Stats</title>
        <!-- BootStrap CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
        <!-- SWC ICON -->
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/icon.png">
    </head>
    <body style="background-color:powderblue;" >
        <div class="container">

            <center><h1 style="font-family: initial;">Stats</h1></center>
            <hr />
            <div class ="navbar-inverse">
                <ul class ="nav nav-tabs">
                    <li role="presentation">
                        <a href="${pageContext.request.contextPath}/home">Home</a>
                    </li>
                    <li role="presentation">
                        <a href="${pageContext.request.contextPath}/search">Search</a>
                    </li>
                    <li role="presentation" class="active">
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
                    <center><div class="row">
                <!-- #1: Contacts Per Company Chart -->
                <div class="col-md-12">
                    <h2>Statistics</h2>
                    <!-- #2: this is where we'll render the bar chart -->
                    <div id="chart_div"></div>
                </div>
            </div> 
        </div>
    </div>
</div> 
</center>
<!-- Placed at the end of the document so the pages load faster -->
<!-- #1: Include and load Google Charts - both steps are required -->
<script type="text/javascript" src="http://www.google.com/jsapi"></script>
<script>
    google.load('visualization', '1.0', {'packages': ['corechart']});
</script>


<script src="${pageContext.request.contextPath}/js/jquery-2.2.4.min.js"></script>
<script src = "${pageContext.request.contextPath}/js/bootstrap.min.js" ></script>
<script src="${pageContext.request.contextPath}/js/stats.js"></script> 

</body>
</html>
