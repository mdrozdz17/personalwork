<%-- 
    Document   : home
    Created on : Oct 26, 2016, 11:17:03 AM
    Author     : apprentice
--%>
<%@taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix ="s" uri="http://www.springframework.org/tags" %>
<%@taglib prefix ="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add New Address - Home</title>
        <!-- BootStrap CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
        <!-- SWC ICON -->
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/icon.png">
    </head>
        <body style="background-color:powderblue;" >
        <div class="container">

            <center><h1>Address Book</h1>
            <hr />
            <h2>New Address Form</h2>
            <a href="displayAddressBook">Address Book</a><br />
            <hr />
            <sf:form class="form-horizontal" role="form" modelAttribute="address"
                     action="editAddress"
                     method="POST">
                <div class="form-group">
                    <label for="add-first-name" 
                           class="col-md-4 control-label">First Name:</label>
                    <div class="col-md-8">
                        <sf:input type="text" class="form-control" required ="true" maxlength = "50"
                                  id="add-first-name" 
                                  path="firstName"
                                  placeholder="First Name" />
                        <!-- cssClass = "name-of-css-class" on the front should be:
                        class="name-of-css-class" -->
                        <sf:errors path="firstName" cssClass="error"></sf:errors>
                        </div>
                    </div>
                <div class="form-group">
                    <label for="add-last-name"
                           class="col-md-4 control-label">Last Name:</label>
                    <div class="col-md-8">
                        <sf:input type="text" class="form-control" required ="true" maxlength = "50"
                               id="add-last-name" 
                               path="lastName"
                               placeHolder= "Last Name" />
                                <sf:errors path="lastName" cssClass="error"></sf:errors>
                    </div>
                </div>
                <div class="form-group">
                    <label for="add-street"
                           class="col-md-4 control-label">Street:</label>
                    <div class="col-md-8">
                       <sf:input type="text" class="form-control" required ="true" maxlength = "50"
                               id="add-street" 
                               path="street"
                               placeHolder= "Street" />
                                <sf:errors path="street" cssClass="error"></sf:errors>
                    </div>
                </div>
                <div class="form-group">
                    <label for="add-city"
                           class="col-md-4 control-label">City:</label>
                    <div class="col-md-8">
                        <sf:input type="text" class="form-control" required ="true" maxlength = "50"
                               id="add-city" 
                               path="city"
                               placeHolder= "City" />
                               <sf:errors path="city" cssClass="error"></sf:errors>
                    </div>
                </div>
                <div class="form-group">
                    <label for="add-state"
                           class="col-md-4 control-label">State:</label>
                    <div class="col-md-8">
                        <sf:input type="text" class="form-control" required ="true" maxlength = "50"
                               id="add-state" 
                               path="state"
                               placeHolder= "State" />
                               <sf:errors path="state" cssClass="error"></sf:errors>
                    </div>
                </div>
                  <div class="form-group">
                    <label for="add-zip"
                           class="col-md-4 control-label">Zip:</label>
                    <div class="col-md-8">
                        <sf:input type="number" class="form-control" required ="true" maxlength = "5"
                               id="add-zip" 
                               path="zip"
                               placeHolder= "Zip Code" />
                                <sf:errors path="zip" cssClass="error"></sf:errors>
                    </div>
                </div>
            </center>
              <div class="form-group">
                    <div class="col-md-offset-4 col-md-8">
                        <sf:hidden path="addressId" />
                        <button type="submit" id="add-button"
                                class="btn btn-primary">Add New Contact</button>
                    </div>
                </div>
            </sf:form>
        </div>
        <script src="${pageContext.request.contextPath}/js/jquery-2.2.4.min.js"></script>
        <script src = "${pageContext.request.contextPath}/js/bootstrap.min.js" ></script>
    </body>
</html
