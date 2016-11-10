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
        <title>Address Book - Home</title>
        <!-- BootStrap CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
        <!-- SWC ICON -->
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/icon.png">
    </head>
     <body style="background-color:powderblue;" >
        <div class="container">

            <center> <h1>Address Book</h1>
            <hr />
            <div class ="navbar">
                <ul class ="nav nav-tabs">
                    <li role="presentation" class="active">
                        <a href="${pageContext.request.contextPath}/home">Home</a>
                    </li>
                    <li role="presentation">
                        <a href="${pageContext.request.contextPath}/search">Search</a>
                    </li>
                    <li role="presentation">
                        <a href="${pageContext.request.contextPath}/stats">Stats</a>
                    </li>
                    <li role="presentation">
                        <a href="${pageContext.request.contextPath}/displayAddressBook">AddressBook</a>
                    </li>
                </ul>
            </div>
            <div class="row">
                <div class="col-md-6 col-lg-6 col-xs-6">
                    <!-- Our list of contacts -->
                    <h2>My Contacts</h2>
                    <table id="contactTable" class="table table-hover table-striped">
                        <tr>
                            <th width="40%">Contact Name</th>
                            <th width="30%">State</th>
                            <th width="15%"></th>
                            <th width="15%"></th>
                        </tr>
                        <!-- This is where our contacts will be.  We will populate this with JS -->
                        <tbody id="contentRows"></tbody>
                    </table>
                </div>
                <div class="col-md-6 col-lg-6 col-xs-6">
                    <!-- Add contact form -->
                    <h2>Add New Contact</h2>
                    <div id="validationErrors" class="warning bg-danger"></div>

                    <form class="form-horizontal" role="form">
                        <div class="form-group">
                            <label for="add-first-name" 
                                   class="col-md-4 control-label">First Name:</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" id="add-first-name" placeholder="First Name" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="add-last-name" 
                                   class="col-md-4 control-label">Last Name:</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" id="add-last-name" placeholder="Last Name" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="add-street" 
                                   class="col-md-4 control-label">Street:</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" id="add-street" placeholder="Street" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="add-city" 
                                   class="col-md-4 control-label">City:</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" id="add-city" placeholder="City" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="add-state" 
                                   class="col-md-4 control-label">State:</label>
                            <div class="col-md-8">
                                     <select style="width: 290px;" id="add-state" name="state">
                                       <option disabled ="disabled" selected="selected" value="0"/>Please Select An Option</option>
                                        <c:forEach items="${state}"  var="states">
                                         <option value="${states.name}">${states.name}
                                            </option>
                                        </c:forEach>
                                     </select>
                            </div>
                        </div>
                            <div class="form-group">
                            <label for="add-zip" 
                                   class="col-md-4 control-label">Zip:</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" id="add-zip" placeholder="Zip" />
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-offset-4 col-md-8">
                                <button type="submit"
                                        id="add-button"
                                        class="btn btn-primary">
                                    Create Contact
                                </button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
            <!-- Modal to display contact details -->
            <!-- aria- attributes for Accessible Rich Internet Applications standards
            their purpose is to make web applications more accessible to people with disabilities.
            -->
            <div class="modal fade" id="detailsModal" tabindex="-1" role="dialog"
                 aria-labelledby="detailsModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal">
                                <span aria-hidden="true">&times;</span>
                                <span class="sr-only">Close</span>
                            </button>
                            <h4 class="modal-title" id="detailsModalLabel">Contact Details</h4>
                        </div>
                        <div class="modal-body">
                            <h3 id="contactId"></h3>
                            <table class="table table-bordered">
                                <tr>
                                    <th>First Name:</th>
                                    <td id="contact-firstName"></td>
                                </tr>
                                <tr>
                                    <th>Last Name:</th>
                                    <td id="contact-lastName"></td>
                                </tr>
                                <tr>
                                    <th>Street:</th>
                                    <td id="contact-street"></td>
                                </tr>
                                <tr>
                                    <th>City:</th>
                                    <td id="contact-city"></td>
                                </tr>
                                <tr>
                                    <th>State:</th>
                                    <td id="contact-state"></td>
                                </tr>
                                 <tr>
                                    <th>Zip:</th>
                                    <td id="contact-zip"></td>
                                </tr>
                            </table>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-primary" data-dismiss="modal">Close</button>
                        </div>
                    </div>
                </div>
            </div>
            <div class="modal fade" id="editModal" tabindex="-1" role="dialog"
                 aria-labelledby="editDetailsModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal">
                                <span aria-hidden="true">&times;</span>
                                <span class="sr-only">Close</span>
                            </button>
                            <h4 class="modal-title" id="editDetailsModalLabel">Edit Contact</h4>
                        </div>
                        <div class="modal-body">
                            <h2>Edit Contact</h2>
                            <form class="form-horizontal" role="form">
                                <div class="form-group">
                                    <label for="edit-first-name" 
                                           class="col-md-4 control-label">First Name:</label>
                                    <div class="col-md-8">
                                        <input type="text" class="form-control" id="edit-first-name" placeholder="First Name" />
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="edit-last-name" 
                                           class="col-md-4 control-label">Last Name:</label>
                                    <div class="col-md-8">
                                        <input type="text" class="form-control" id="edit-last-name" placeholder="Last Name" />
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="edit-street" 
                                           class="col-md-4 control-label">Street:</label>
                                    <div class="col-md-8">
                                        <input type="text" class="form-control" id="edit-street" placeholder="Street" />
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="edit-city" 
                                           class="col-md-4 control-label">City:</label>
                                    <div class="col-md-8">
                                        <input type="text" class="form-control" id="edit-city" placeholder="City" />
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="edit-state" 
                                           class="col-md-4 control-label">State:</label>
                                    <div class="col-md-8">
                                        <input type="text" class="form-control" id="edit-state" placeholder="State" />
                                    </div>
                                </div>
                                 <div class="form-group">
                                    <label for="edit-zip" 
                                           class="col-md-4 control-label">Zip:</label>
                                    <div class="col-md-8">
                                        <input type="text" class="form-control" id="edit-zip" placeholder="Zip" />
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-md-offset-4 col-md-8">
                                        <button type="submit"
                                                id="edit-button"
                                                class="btn btn-primary" data-dismiss="modal">
                                            Edit Contact
                                        </button>
                                        <button type="button" class="btn btn-primary" data-dismiss="modal">Cancel</button>

                                        <input type="hidden" id="edit-address-id" />
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
</center>
        <!-- Placing our JS at the end of the document so that the page loads faster-->
        <script src="${pageContext.request.contextPath}/js/jquery-2.2.4.min.js"></script>
        <script src = "${pageContext.request.contextPath}/js/bootstrap.min.js" ></script>
        <script src="${pageContext.request.contextPath}/js/contactList.js"></script>
    </body>
</html>
