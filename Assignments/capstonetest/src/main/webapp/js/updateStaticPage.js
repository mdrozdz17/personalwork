/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function() {


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


    window.onload = function(){

        var btn = document.getElementById('updateStaticButton');

        btn.onclick = function(){

            tinymce.triggerSave();

            //$('#update-blogpost-validation-errors').text('');

            $('#confirmationUpdate').text('');



            var myStaticPage = {
                id: $('#updateId').val(),
                body: $('#mytextarea').val(),
                title:$('#updatetitle').val(),
                active: $('#updateactive').val()


            };
            console.log(myStaticPage);

            var myStaticPageData = JSON.stringify(myStaticPage);

            $.ajax({
                url: contextRoot + "/staticpage/update/" + myStaticPage.id,
                type: "PUT",
                data: myStaticPageData,
                dataType: "json",
                beforeSend: function(xhr) {
                    xhr.setRequestHeader("Accept", "application/json");
                    xhr.setRequestHeader("Content-type", "application/json");

                },
                success: function(data, status) {

                    var tableRow = buildStaticPageRow(data);

                    $('#staticpage-row-' + data.id).replaceWith($(tableRow));

                    //$('#confirmationUpdate').append("Your updates have been saved.");

                    var div = document.createElement('div');
                    div.setAttribute('class', 'someClass');
                    div.innerHTML = document.getElementById('homeRedirect').innerHTML;
                    document.getElementById('targetElement').appendChild(div);

                    console.log(myStaticPageData);


                },
                error: function(data, status) {

                    // var errors = data.responseJSON.errors;
                    //
                    // $.each(errors, function(index, error) {
                    //     //$('#update-blogpost-validation-errors').append('<li>'+ error.message + '</li>');
                    //     console.log("Nice work KDAWG, the rest of your group are bums and you're all MAAANNNN!");
                    //
                    // });

                    console.log("An error occurred while submitting updates.");

                }

            })

        }
    }

});
