/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

// When the document is ready, populate our summary table
$(document).ready(function () {
    loadDvds();

    // add the onclick handling for our add button
    $('#add-button').click(function (event) {
        event.preventDefault();
        // need to submit this via AJAX
        $.ajax({
            type: 'POST',
            url: 'dvd',
            // make the JSON Dvd
            data: JSON.stringify({
                title: $('#add-title').val(),
                releaseDate: $('#add-release-date').val(),
                mpaaRating: $('#add-mpaa-rating').val(),
                directorsName: $('#add-directors-name').val(),
                studio: $('#add-studio').val(),
                userRating: $('#add-user-rating').val()

            }),
            contentType: 'application/json; charset=utf-8',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            dataType: 'json'
        }).success(function (data, status) {
            // clear the form and reload the summary table
            $('#add-title').val('');
            $('#add-release-date').val('');
            $('#add-mpaa-rating').val("default");
            $('#add-directors-name').val('');
            $('#add-studio').val('');
            $('#add-user-rating').val('');


            // reload the summary table
            $('#validationErrors').empty();
            loadDvds();
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
        // update our Dvd via AJAX
        $.ajax({
            type: 'PUT',
            url: 'dvd/' + $('#edit-dvd-id').val(),
            data: JSON.stringify({
                dvdId: $('#edit-dvd-id').val(),
                title: $('#edit-title').val(),
                releaseDate: $('#edit-release-date').val(),
                mpaaRating: $('#edit-mpaa-rating').val(),
                directorsName: $('#edit-directors-name').val(),
                studio: $('#edit-studio').val(),
                userRating: $('#edit-user-rating').val()

            }),
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            'dataType': 'json'
        }).success(function () {
            loadDVDS();
        });
    });

    $("#search-button").click(function (event) {
        event.preventDefault();
        $.ajax({
            type: 'POST',
            url: 'search/dvd',
            dataType: 'json',
            data: JSON.stringify({
                title: $('#search-title').val(),
                releaseDate: $('#search-release-date').val(),
                mpaaRating: $('#search-mpaa-rating').val(),
                directorsName: $('#search-directors-name').val(),
                studio: $('#search-studio').val(),
                userRating: $('#search-user-rating').val()
            }),
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            }
        }).success(function (data, status) {
            $('#search-title').val('');
            $('#search-release-date').val('');
            $('#search-mpaa-rating').val('');
            $('#search-directors-name').val('');
            $('#search-studio').val('');
            $('#search-user-rating').val('');


            fillDvdTable(data, status);
        });
    });
});

// Load Dvd into our summary table
function loadDvds() {
    //  Get our JSON object from the endpoint
    $.ajax({
        url: 'dvd'
    }).success(function (data, status) {
        fillDvdTable(data, status);
    });
}

// used with Search button and loadDvd function
function fillDvdTable(dvdLibrary, status) {
    // clear the previous list
    clearDvdTable();

    // store our tbody in a variable 
    var summaryTable = $('#contentRows');

    $.each(dvdLibrary, function (index, dvd) {
        summaryTable.append($('<tr>')
                .append($('<td>')
                        .append($('<a>')
                                .attr({
                                    'data-dvd-id': dvd.dvdId,
                                    'data-toggle': 'modal',
                                    'data-target': '#detailsModal'
                                })
                                //.text((index) + ' - ' + dvd.title + ' ' + dvd.releaseDate)))
                                .text((index) + ' - ' + dvd.title)))
                .append($('<td>').text(dvd.releaseDate))
                .append($('<td>')
                        .append($('<a>')
                                .attr({
                                    'data-dvd-id': dvd.dvdId,
                                    'data-toggle': 'modal',
                                    'data-target': '#editModal'
                                })
                                .text('Edit')))
                .append($('<td>')
                        .append($('<a>')
                                .attr({
                                    'onClick': 'deleteDvd(' + dvd.dvdId + ')'
                                })
                                .text('Delete'))));
    });
}

// Clear all the rows from our summary table
function clearDvdTable() {
    $('#contentRows').empty();
}

// Run in response to the show.bs.modal event
// It gets the contact data and renders it to the dialog
$('#detailsModal').on('show.bs.modal', function (event) {
    var element = $(event.relatedTarget);
    var dvdId = element.data('dvd-id');
    var modal = $(this);
    // Get our object via AJAX
    $.ajax({
        type: 'GET',
        url: 'dvd/' + dvdId
    }).success(function (sampleDvd) {
        modal.find('#dvd-id').text(sampleDvd.dvdId);
        modal.find('#dvd-title').text(sampleDvd.title);
        modal.find('#dvd-releaseDate').text(sampleDvd.releaseDate);
        modal.find('#dvd-mpaaRating').text(sampleDvd.mpaaRating);
        modal.find('#dvd-directorsName').text(sampleDvd.directorsName);
        modal.find('#dvd-studio').text(sampleDvd.studio);
        modal.find('#dvd-userRating').text(sampleDvd.userRating);

    });
});

$('#editModal').on('show.bs.modal', function (event) {
    var element = $(event.relatedTarget);
    var dvdId = element.data('dvd-id');
    var modal = $(this);

    // get our object via AJAX
    $.ajax({
        type: 'GET',
        url: 'dvd/' + dvdId
    }).success(function (sampleEditDvd) {
        modal.find('#edit-dvd-id').val(sampleEditDvd.dvdId);
        modal.find('#edit-title').val(sampleEditDvd.title);
        modal.find('#edit-release-date').val(sampleEditDvd.releaseDate);
        modal.find('#edit-mpaa-rating').val(sampleEditDvd.mpaaRating);
        modal.find('#edit-directors-name').val(sampleEditDvd.directorsName);
        modal.find('#edit-studio').val(sampleEditDvd.studio);
        modal.find('#edit-user-rating').val(sampleEditDvd.userRating);

    });
});

function deleteDvd(id) {
    var answer = confirm('Do you really want to delete this DVD?');

    if (answer === true) {
        $.ajax({
            type: 'DELETE',
            url: 'dvd/' + id
        }).success(function () {
            // reload summary
            loadDvds();
        });
    }
}        