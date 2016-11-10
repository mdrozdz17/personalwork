<%-- 
    Document   : stats
    Created on : Oct 26, 2016, 8:18:41 AM
    Author     : parallels
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Address Book - Edit </title>
        <!-- Bootstrap CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet" />
        <!-- SWC Icon -->
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/icon.png">
    </head>
    <body style="background-color:powderblue;" >
        <div class="container">
            <center><h1>Edit Address</h1>
            <hr />
            <h2>Edit Address Form</h2>
            <a href="displayAddressBook">Edit Contact</a><br />
            <hr />
            <sf:form class="form-horizontal" role="form" modelAttribute="address"
                     action="editAddress"
                     method="POST">
                <div class="form-group">
                    <label for="edit-first-name" 
                           class="col-md-4 control-label">First Name:</label>
                    <div class="col-md-8">
                        <sf:input type="text" class="form-control" required ="true" maxlength = "50"
                                  id="edit-first-name" 
                                  path="firstName"
                                  placeholder="First Name" />
                        <!-- cssClass = "name-of-css-class" on the front should be:
                        class="name-of-css-class" -->
                        <sf:errors path="firstName" cssClass="error"></sf:errors>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="edit-last-name" 
                               class="col-md-4 control-label">Last Name:</label>
                        <div class="col-md-8">
                        <sf:input type="text" class="form-control" required ="true" maxlength = "50"
                                  id="edit-last-name" 
                                  path="lastName"
                                  placeholder="Last Name" />
                        <sf:errors path="lastName" cssClass="error"></sf:errors>

                        </div>
                    </div>

                    <div class="form-group">
                        <label for="edit-street" 
                               class="col-md-4 control-label">Street:</label>
                        <div class="col-md-8">
                        <sf:input type="text" class="form-control" required ="true" maxlength = "50"
                                  id="edit-street" 
                                  path="street"
                                  placeholder="Street" />
                        <sf:errors path="street" cssClass="error"></sf:errors>

                        </div>
                    </div>

                    <div class="form-group">
                        <label for="edit-city" 
                               class="col-md-4 control-label">City:</label>
                        <div class="col-md-8">
                        <sf:input type="text" class="form-control" required ="true" maxlength = "50"
                                  id="edit-city" 
                                  path="city"
                                  placeholder="City" />
                        <sf:errors path="city" cssClass="error"></sf:errors>

                        </div>
                    </div>

                    <div class="form-group">
                        <label for="edit-state" 
                               class="col-md-4 control-label">State:</label>
                        <div class="col-md-8">
                        <sf:input type="text" class="form-control" required ="true" maxlength = "50"
                                  id="edit-state" 
                                  path="state"
                                  placeholder="State" />
                        <sf:errors path="state" cssClass="error"></sf:errors>

                        </div>
                    </div>
                         <div class="form-group">
                        <label for="edit-zip" 
                               class="col-md-4 control-label">Zip:</label>
                        <div class="col-md-8">
                        <sf:input type="number" class="form-control" required ="true" maxlength = "5"
                                  id="edit-zip" 
                                  path="zip"
                                  placeholder="Zip" />
                        <sf:errors path="zip" cssClass="error"></sf:errors>

                        </div>
                    </div>
            </center>
                    <div class="form-group">
                        <div class="col-md-offset-4 col-md-8">
                        <sf:hidden path="addressId" />
                        <button type="submit" id="edit-button"
                                class="btn btn-primary">Update Contact</button>
                    </div>
                </div>
            </sf:form>
        </div>

        <script src="${pageContext.request.contextPath}/js/jquery-2.2.4.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    </body>
</html>