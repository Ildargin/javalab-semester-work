<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Post'er</title>
    <link rel="preconnect" href="https://fonts.gstatic.com" />
    <link href="https://fonts.googleapis.com/css2?family=Oswald:wght@200;400;700&display=swap" rel="stylesheet" />
    <link rel="stylesheet" href="static/lib/bootstrap/css/bootstrap.css" />
    <link rel="stylesheet" href="static/style/index.css" />
    <link rel="stylesheet" href="static/style/header.css" />
    <link rel="stylesheet" href="static/style/footer.css" />
</head>
<body>

<#include "header.ftl">

<main class="main">
    <div class="container d-flex justify-content-center">
        <div class="m-auto" id="signup">
            <h1 class="auth-title text-center mb-1">Success</h1>
            <div class=" text-center mb-3">Please check your email and activate your account before enter</div>
            <img class="gif" src="https://media.giphy.com/media/aWRWTF27ilPzy/source.gif" alt="gif"/>
        </div>
    </div>
</main>

<#include "footer.ftl">

</body>
</html>
