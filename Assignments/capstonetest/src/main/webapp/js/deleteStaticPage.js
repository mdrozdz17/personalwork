/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function () {
    $('#deleteStaticPageModal').on('shown.bs.modal', function (e) {
        var link = $(e.relatedTarget);

        var staticPageId = link.data('staticpage-id');
        console.log(staticPageId);

        $.ajax({
            url: contextRoot + "/staticpage/" + staticPageId,
            type: "GET",
            dataType: "json",
            beforeSend: function (xhr) {
                xhr.setRequestHeader("Accept", "application/json")
            },
            success: function (data, status) {
                $('#deleteId').val(data.id);
                $('#deleteTitle').text(data.title);
                $('#deleteBody').text(data.body);
                $('#deleteActive').text(data.active);

            },
            error: function (data, status) {
                alert(" NOT FOUND");
            }
        });
    });
    $('#deleteStaticPageButton').on('click', function (e) {

        e.preventDefault();

        var myStaticPage = {
            id: $('#deleteId').val(),
            title: $('#deleteTitle').text,
            body: $('#deleteBody').text(),
            approval_status: $('#deleteActive').text()

        };
        console.log(myStaticPage.id);

        var myStaticPageData = JSON.stringify(myStaticPage);

        $.ajax({
            url: contextRoot + "/staticpage/" + myStaticPage.id,
            type: "DELETE",
            data: myStaticPageData,
//            dataType: "json",
            beforeSend: function (xhr) {
                xhr.setRequestHeader("Accept", "application/json");
                xhr.setRequestHeader("Content-type", "application/json");
            },
            success: function (data, status) {

                console.log(myStaticPage.id);

                $('#staticpage-row-' + myStaticPage.id).remove();

                $('#deleteStaticPageModal').modal('hide');

            },
            error: function (data, status) {
                console.log("ERROR");
            }
        });
    });

});
