<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Post'er</title>
    <link rel="preconnect" href="https://fonts.gstatic.com" />
    <link href="https://fonts.googleapis.com/css2?family=Oswald:wght@200;400;700&display=swap" rel="stylesheet" />
    <link rel="stylesheet" href="static/lib/iconfonts/icon.css" />
    <link rel="stylesheet" href="static/lib/bootstrap/css/bootstrap.css" />
    <link rel="stylesheet" href="static/style/index.css" />
    <link rel="stylesheet" href="static/style/userheader.css" />
    <link rel="stylesheet" href="static/style/createpost.css" />
    <link rel="stylesheet" href="static/style/footer.css" />
</head>
<body>

<#include "header-user.ftl">

<main class="main">
    <div class="create container d-flex">
        <div class=" d-flex flex-row col-sm-12 col-md-6 mb-3">
            <div class="info">
                <h5>Make sure, that you set your first name and last name, if you didnt set it the information about you will not be displayed </h5>
                <h5>Title must be longer than 10 symbols</h5>
                <h5>Description must be longer than 50 symbols</h5>
                <h5>Try to write correctly, observing the rules of grammar, etc.</h5>
            </div>
        </div>
        <div class="d-flex flex-column col-sm-12 col-md-6" id="signup">
            <h3 class="auth-title text-center">Adding post</h3>
            <form  class="d-flex flex-column" action="">
                <label>Set a title</label>
                <input  minlength="10" class="create__input" id="title" required autocomplete="off"/>
                <label>Descpition</label>
                <textarea required name="text" id="text" cols="10" rows="10" maxlength="500" minlength="50"></textarea>
                <button type="submit" value="submit" class="button button-block mt-5" onclick="submitForm()"/>Post</button>
            </form>
        </div>
    </div>
</main>

<#include "footer.ftl">

<script src="static/lib/jquery/jquery.min.js"></script>
<script src="static/js/createpost.js"></script>
</body>
</html>
