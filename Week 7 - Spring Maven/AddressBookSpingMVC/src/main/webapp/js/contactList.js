/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

// When the document is ready, populate our summary table
$(document).ready(function () {
    loadContacts();

    // add the onclick handling for our add button
    $('#add-button').click(function (event) {
        event.preventDefault();
        // need to submit this via AJAX
        $.ajax({
            type: 'POST',
            url: 'contact',
            // make the JSON contact
            data: JSON.stringify({
                firstName: $('#add-first-name').val(),
                lastName: $('#add-last-name').val(),
                street: $('#add-street').val(),
                city: $('#add-city').val(),
                state: $('#add-state').val(),
                zip: $('#add-zip').val()

            }),
            contentType: 'application/json; charset=utf-8',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            dataType: 'json'
        }).success(function (data, status) {
            // clear the form and reload the summary table
            $('#add-first-name').val('');
            $('#add-last-name').val('');
            $('#add-street').val('');
            $('#add-city').val('');
            $('#add-state').val("0");
            $('#add-zip').val('');


            // reload the summary table
            $('#validationErrors').empty();
            loadContacts();
        }).error(function (data, status) {
            $('#validationErrors').empty();
            $.each(data.responseJSON.fieldErrors, function (index, validationError) {
                var errorDiv = $('#validationErrors');
                errorDiv.append(validationError.message).append($('<br>'));
            });
        });
    });

    $('#edit-button').click(function (event) {
        event.preventDefault();
        // update our contact via AJAX
        $.ajax({
            type: 'PUT',
            url: 'contact/' + $('#edit-address-id').val(),
            data: JSON.stringify({
                addressId: $('#edit-address-id').val(),
                firstName: $('#edit-first-name').val(),
                lastName: $('#edit-last-name').val(),
                street: $('#edit-street').val(),
                city: $('#edit-city').val(),
                state: $('#edit-state').val(),
                zip: $('#edit-zip').val()

            }),
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            'dataType': 'json'
        }).success(function () {
            loadContacts();
        });
    });

    $("#search-button").click(function (event) {
        event.preventDefault();
        $.ajax({
            type: 'POST',
            url: 'search/contacts',
            dataType: 'json',
            data: JSON.stringify({
                firstName: $('#search-first-name').val(),
                lastName: $('#search-last-name').val(),
                street: $('#search-street').val(),
                city: $('#search-city').val(),
                state: $('#search-state').val(),
                zip: $('#search-zip').val()

            }),
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            }
        }).success(function (data, status) {
            $('#search-first-name').val('');
            $('#search-last-name').val('');
            $('#search-street').val('');
            $('#search-city').val('');
            $('#search-state').val("0");
            $('#search-zip').val('');


            fillContactTable(data, status);
        });
    });
});

// Load contacts into our summary table
function loadContacts() {
    //  Get our JSON object from the endpoint
    $.ajax({
        url: 'contacts'
    }).success(function (data, status) {
        fillContactTable(data, status);
    });
}

// used with Search button and loadContact function
function fillContactTable(contactList, status) {
    // clear the previous list
    clearContactTable();

    // store our tbody in a variable 
    var summaryTable = $('#contentRows');

    $.each(contactList, function (index, person) {
        summaryTable.append($('<tr>')
                .append($('<td>')
                        .append($('<a>')
                                .attr({
                                    'data-contact-id': person.addressId,
                                    'data-toggle': 'modal',
                                    'data-target': '#detailsModal'
                                })
                                .text((index) + ' - ' + person.firstName + ' ' + person.lastName)))
                .append($('<td>').text(person.state))
                .append($('<td>')
                        .append($('<a>')
                                .attr({
                                    'data-contact-id': person.addressId,
                                    'data-toggle': 'modal',
                                    'data-target': '#editModal'
                                })
                                .text('Edit')))
                .append($('<td>')
                        .append($('<a>')
                                .attr({
                                    'onClick': 'deleteContact(' + person.addressId + ')'
                                })
                                .text('Delete'))));
    });
}

// Clear all the rows from our summary table
function clearContactTable() {
    $('#contentRows').empty();
}

// Run in response to the show.bs.modal event
// It gets the contact data and renders it to the dialog
$('#detailsModal').on('show.bs.modal', function (event) {
    var element = $(event.relatedTarget);
    var contactId = element.data('contact-id');
    var modal = $(this);
    // Get our object via AJAX
    $.ajax({
        type: 'GET',
        url: 'contact/' + contactId
    }).success(function (sampleContact) {
        modal.find('#contact-id').text(sampleContact.contactId);
        modal.find('#contact-firstName').text(sampleContact.firstName);
        modal.find('#contact-lastName').text(sampleContact.lastName);
        modal.find('#contact-street').text(sampleContact.street);
        modal.find('#contact-city').text(sampleContact.city);
        modal.find('#contact-state').text(sampleContact.state);
        modal.find('#contact-zip').text(sampleContact.zip);

    });
});

$('#editModal').on('show.bs.modal', function (event) {
    var element = $(event.relatedTarget);
    var contactId = element.data('contact-id');
    var modal = $(this);

    // get our object via AJAX
    $.ajax({
        type: 'GET',
        url: 'contact/' + contactId
    }).success(function (sampleEditContact) {
        modal.find('#edit-contact-id').val(sampleEditContact.contactId);
        modal.find('#edit-first-name').val(sampleEditContact.firstName);
        modal.find('#edit-last-name').val(sampleEditContact.lastName);
        modal.find('#edit-street').val(sampleEditContact.street);
        modal.find('#edit-city').val(sampleEditContact.city);
        modal.find('#edit-state').val(sampleEditContact.state);
        modal.find('#edit-zip').val(sampleEditContact.zip);

    });
});

function deleteContact(id) {
    var answer = confirm('Do you really want to delete this contact?');

    if (answer === true) {
        $.ajax({
            type: 'DELETE',
            url: 'contact/' + id
        }).success(function () {
            // reload summary
            loadContacts();
        });
    }
}        