$(document).ready(function() {


    window.onload = function () {

        var btn = document.getElementById('CreateStaticPageButton');

        btn.onclick = function () {

            tinymce.triggerSave();

            var myStaticPage = {
                body: $('#mytextarea').val(),
                title:$('#addStaticTitle').val(),
                active: $('#staticactive').val()


            };

            var myStaticPageData = JSON.stringify(myStaticPage);

            $.ajax({
                url: contextRoot + "/staticpage",
                type: "POST",
                data: myStaticPageData,
                dataType: "json",
                beforeSend: function (xhr) {
                    xhr.setRequestHeader("Accept", "application/json");
                    xhr.setRequestHeader("Content-type", "application/json");
                },
                success: function (data, status) {

                    $('#htmlDiv').append(data.body);

                    var tableRow = buildStaticPageRow(data);

                    $('#staticPageTable tbody').append(tableRow);

                    $('#mytextarea').val('');

                },
                error: function (data, status) {
                    console.log("No bueno");

                }

            });
        };


        function buildStaticPageRow(data) {


            var tableRow = '\
                        <tr id="staticpage-row-' + data.id + '"> \n\
                              <td><a href="/CapstoneBlog/staticpage/show/' + data.id +'">'+ data.title +'</a></td> \n\
                             <td>' + data.active + '</td> \n\
                            <td><a href="/CapstoneBlog/staticpage/update/' + data.id +'">Update</a></td> \n\
                            <td><a data-staticpage-id="' + data.id + '" data-toggle="modal" data-target="#deleteStaticPageModal">Delete</a></td> \n\
                        </tr>';

            return tableRow;
        }

    };

    });


