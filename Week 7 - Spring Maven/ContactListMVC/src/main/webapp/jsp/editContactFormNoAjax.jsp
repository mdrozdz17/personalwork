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
        <title>Company Contacts - Home (No Ajax)</title>
        <!-- Bootstrap CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet" />
        <!-- SWC Icon -->
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/icon.png">
    </head>
    <body>
        <div class="container">
            <h1>Company Contacts (No Ajax)</h1>
            <hr />
            <h2>New Contact Form</h2>
            <a href="displayContactListNoAjax">Contact List (No Ajax)</a><br />
            <hr />
            <sf:form class="form-horizontal" role="form" modelAttribute="contact"
                     action="editContactNoAjax"
                     method="POST">
                <div class="form-group">
                    <label for="add-first-name" 
                           class="col-md-4 control-label">First Name:</label>
                    <div class="col-md-8">
                        <sf:input type="text" class="form-control"
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
                        <sf:input type="text" class="form-control"
                                  id="add-last-name" 
                                  path="lastName"
                                  placeholder="Last Name" />
                        <sf:errors path="lastName" cssClass="error"></sf:errors>

                        </div>
                    </div>

                    <div class="form-group">
                        <label for="add-company" 
                               class="col-md-4 control-label">Company:</label>
                        <div class="col-md-8">
                        <sf:input type="text" class="form-control"
                                  id="add-company" 
                                  path="company"
                                  placeholder="Company" />
                        <sf:errors path="company" cssClass="error"></sf:errors>

                        </div>
                    </div>

                    <div class="form-group">
                        <label for="add-email" 
                               class="col-md-4 control-label">Email:</label>
                        <div class="col-md-8">
                        <sf:input type="text" class="form-control"
                                  id="add-email" 
                                  path="email"
                                  placeholder="Email" />
                        <sf:errors path="email" cssClass="error"></sf:errors>

                        </div>
                    </div>

                    <div class="form-group">
                        <label for="add-phone" 
                               class="col-md-4 control-label">Phone:</label>
                        <div class="col-md-8">
                        <sf:input type="text" class="form-control"
                                  id="add-phone" 
                                  path="phone"
                                  placeholder="Phone" />
                        <sf:errors path="phone" cssClass="error"></sf:errors>

                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-offset-4 col-md-8">
                        <sf:hidden path="contactId" />
                        <button type="submit" id="edit-button"
                                class="btn btn-default">Update Contact</button>
                    </div>
                </div>
            </sf:form>
        </div>
        <script src="${pageContext.request.contextPath}/js/jquery-2.2.4.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    </body>
</html>