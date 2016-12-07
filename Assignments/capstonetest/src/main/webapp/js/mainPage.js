/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(function(){

    loadPosts();
    
});
// add the onclick handling for our add button
    $('#add-button').click(function (event) {
        event.preventDefault();
        // need to submit this via AJAX
        $.ajax({
            type: 'POST',
            url: 'post',
            // make the JSON contact
            data: JSON.stringify({
                title: $('#add-title').val(),
                author: $('#add-author').val(),
                body: $('#add-body').val(),
                category: $('#add-category').val(),
                taglist: $('#add-taglist').val()

            }),
            contentType: 'application/json; charset=utf-8',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            dataType: 'json'
        }).success(function () {
            // removing data, status for a question on if we need them
            // realistically, if you are getting an object back from an endpoint
            // and you need to work with the data coming back, 
            // then you want to include the parameters in the anonymous function's signature
            // clear the form and reload the summary table
            $('#add-title').val('');
            $('#add-author').val('');
            $('#add-body').val('');
            $('#add-category').val('');
            $('#add-taglist').val('');


            // reload the summary table
            $('#validationErrors').empty();
            loadPosts();
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
        // update our post via AJAX
        $.ajax({
          
            type: 'PUT',
            url: 'post' + $('#edit-post-id').val(),
            data: JSON.stringify({
                postId: $('#edit-post-id').val(),
                title: $('#edit-title').val(),
                author: $('#edit-author').val(),
                body: $('#edit-body').val(),
                category: $('#edit-category').val(),
                taglist: $('#edit-taglist').val()
            }),
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            'dataType': 'json'
        }).success(function () {
            loadPosts();
        });
    });


function loadPosts() {
    //Get our JSON objects from the controller
    $.ajax({
        url: 'post',
        cache: false,
        contentType: 'application/json',
        dataType: 'json'
    }).success(function (data, status) {
        fillPostTable(data, status);
        fillAuthorTable(data, status);
        fillCategoryTable(data, status);
        fillTagTable(data, status);
    });
}

function fillPostTable(postList, status) {
    clearPostTable();
    var postTable = $('#postRows');
    var sortedPosts = postList.sort(function(a,b){
        return b.postId - a.postId;
    });
    $.each(sortedPosts, function (arrayPosition, post) {
        postTable.append($('<tr>')
                .append($('<td>')
                        .append($('<h2>' + post.title + '</h2>\n\
        <p><span class="glyphicon glyphicon-user"></span><a href="#"> ' + post.author + '</a>&nbsp;\n\
        <span class="glyphicon glyphicon-time"></span> Posted on ' + post.month + ' ' + post.day + ', ' + post.year + '&nbsp;\n\
        <span class="glyphicon glyphicon-duplicate"></span><a href="#"> ' + post.category + ' </a>&nbsp;\n\
        <span class="glyphicon glyphicon-comment"></span><a href="#"> ' + post.commentList.length + " Comments</a>"
        + '<p>' + post.body + '</p>'       
        ))));
        
        var tags = "";
        for (var i = 0; i < post.tagList.length; i++) {
            tags = tags + "#" + post.tagList[i] + " ";

        }

        postTable.append($('<p>' + tags + '</p><a class="btn btn-primary" href="displayPost' + post.postId + '">Read More <span class="glyphicon glyphicon-chevron-right"></span></a>'));

    });
}
function fillAuthorTable(postList, status) {
    var authorTable = $('#authorRows');
    authorTable.empty();
    var authorList = [];
    var authorString = "";
    $.each(postList, function(arrayPosition, post) {
        authorString += post.author;
    });
    $.each(postList, function (arrayPosition, post) {
        if (!contains(authorList, post.author)) {
            authorTable.append($('<tr><td><a href="#">' + post.author + 
                    ' (' + countInstances(authorString, post.author) + ')</a></td></tr>'));
            authorList.push(post.author);
        }
    }
    );
}
function contains(a, obj) {
    for (var i = 0; i < a.length; i++) {
        if (a[i] === obj) {
            return true;
        }
    }
    return false;
}

function countInstances(string, word) {
    var substrings = string.split(word);
    return substrings.length - 1;
}

function fillCategoryTable(postList, status) {
    var categoryTable = $('#categoryRows');
    categoryTable.empty();
    var categoryList = [];
    var categoryString = "";
    $.each(postList, function(arrayPosition, post) {
        categoryString = categoryString + post.category;
    });
    $.each(postList, function (arrayPosition, post) {
        if (!contains(categoryList, post.category)) {
            categoryTable.append($('<tr><td><a href="#">' + post.category + ' (' 
                    + countInstances(categoryString, post.category) + ')</a></td></tr>'));
            categoryTable.push(post.category);
        }
    });
}

function fillTagTable(postList, status) {
    var tagTable = $('#tagRows');
    tagTable.empty();
    $.each(postList, function (arrayPosition, post) {

        for (var i = 0; i < post.tagList.length; i++) {
            tagTable.append($('<a href="#">#' + post.tagList[i] + ' </a></'));
        }
    });
}
function clearPostTable() {
    $('#postRows').empty();
}
