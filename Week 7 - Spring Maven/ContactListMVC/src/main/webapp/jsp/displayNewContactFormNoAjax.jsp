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
        <title>Company Contacts - Home (No Ajax)</title>
        <!-- BootStrap CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
        <!-- SWC ICON -->
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/icon.png">
    </head>
    <body>
        <div class="container">

            <h1>Company Contacts (No Ajax)</h1>
            <hr />
            <h2>New Contact Form</h2>
            <a href="displayContactListNoAjax">Contact List (No Ajax)</a><br />
            <hr />
            <form class ="form-horizontal" role="form" action="addNewContactNoAjax"
                  method="POST">
                <div class="form-group">
                    <label for="add-first-name"
                           class="col-md-4 control-label">First Name:</label>
                    <div class="col-md-8">
                        <input type="text" class="form-control"
                               id="add-first-name" 
                               name="firstName"
                               placeHolder="First name" />
                    </div>
                </div>
                <div class="form-group">
                    <label for="add-last-name"
                           class="col-md-4 control-label">Last Name:</label>
                    <div class="col-md-8">
                        <input type="text" class="form-control"
                               id="add-last-name" 
                               name="lastName"
                               placeHolder="Last name" />
                    </div>
                </div>
                <div class="form-group">
                    <label for="add-company"
                           class="col-md-4 control-label">Company:</label>
                    <div class="col-md-8">
                        <input type="text" class="form-control"
                               id="add-company" 
                               name="company"
                               placeHolder="Company" />
                    </div>
                </div>
                <div class="form-group">
                    <label for="add-email"
                           class="col-md-4 control-label">Email:</label>
                    <div class="col-md-8">
                        <input type="text" class="form-control"
                               id="add-email" 
                               name="email"
                               placeHolder="Email" />
                    </div>
                </div>
                <div class="form-group">
                    <label for="add-phone"
                           class="col-md-4 control-label">Phone:</label>
                    <div class="col-md-8">
                        <input type="text" class="form-control"
                               id="add-phone" 
                               name="phone"
                               placeHolder="Phone" />
                    </div>
                </div>
                <div class="form-group">
                    <div class="cold-md-offset-4-md-8">
                        <button type ="submit" id="add-button"
                                class="btn btn-default">Add New Contact</button>
                    </div>
                </div>
            </form>
        </div>
        <script src="${pageContext.request.contextPath}/js/jquery-2.2.4.min.js"></script>
        <script src = "${pageContext.request.contextPath}/js/bootstrap.min.js" ></script>
    </body>
</htm
