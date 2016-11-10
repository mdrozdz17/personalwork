<%-- 
    Document   : home
    Created on : Oct 26, 2016, 11:17:03 AM
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
        <title>Address Book</title>
        <!-- BootStrap CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
        <!-- SWC ICON -->
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/icon.png">
    </head>
    <body style="background-color:powderblue;" >
        <div class="container">

            <center><h1>Address Book</h1>
            <a href="displayNewAddressForm">Add a Contact</a><br />
            <hr />
            <div class ="navbar">
                <ul class ="nav nav-tabs">
                    <li role="presentation">
                        <a href="${pageContext.request.contextPath}/home">Home</a>
                    </li>
                    <li role="presentation">
                        <a href="${pageContext.request.contextPath}/search">Search</a>
                    </li>
                    <li role="presentation">
                        <a href="${pageContext.request.contextPath}/stats">Stats</a>
                    </li>
                    <li role="presentation" class ="active">
                        <a href="${pageContext.request.contextPath}/displayAddressBook">Address Book</a>
                    </li>
                </ul>
            </div><br />
                   
            <c:if test="${fn:length(contactList) lt 1}">
                <form action="loadContacts" method="POST">
                    <button type="submit" class="btn btn-primary btn-lg">Load Contacts</button>
                </form>
                
            </c:if>
                    <p></p>
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th>Name</th>
                        <th>Street</th>
                        <th>City</th>
                        <th>State</th>
                        <th>Zip</th>
                        <th>&nbsp;</th>
                    </tr>
                </thead>
                <tbody>

                    <!-- interate through our contacts and show information -->
                    <c:forEach var="address" items="${addressBook}">
                        <!-- For each contact:
                        1. First Name & Last Name
                        2. Edit Link
                        3. Delete Link
                        -->
                        <s:url value="deleteAddress" var="deleteAddress_url">
                            <s:param name="addressId" value="${address.addressId}" />
                        </s:url>

                        <s:url value="displayEditAddressForm" var="editAddress_url">
                            <s:param name="addressId" value="${address.addressId}" />
                        </s:url>
                        <tr>
                            <td>Name: ${address.firstName} ${address.lastName}</td>
                            <td>Street: ${address.street}</td>
                            <td>City: ${address.city}</td>
                            <td>State: ${address.state}</td>
                            <td>Zip: ${address.zip}</td>
                            <td><a href="${deleteAddress_url}">Delete</a> |
                                <a href="${editAddress_url}">Edit</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
</center>
        <script src="${pageContext.request.contextPath}/js/jquery-2.2.4.min.js"></script>
        <script src = "${pageContext.request.contextPath}/js/bootstrap.min.js" ></script>
    </body>
</html
