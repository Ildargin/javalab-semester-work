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
    <link rel="stylesheet" href="static/style/signup.css" />
    <link rel="stylesheet" href="static/style/footer.css" />
</head>
<body>

<#include "header.ftl">

<main class="main">
    <div class="container">
        <div class="m-auto" id="signup">
            <h1 class="auth-title text-center">Please sign up to continue</h1>
            <form action="">
                <label>Set A Email</label>
                <input class="mb-2" id="email" type="email"required autocomplete="off"/>
                <label>Set A Password</label>
                <input class="mb-1" id="password" type="password"required autocomplete="off"/>
                <label>Retype password</label>
                <input id="repassword" type="password" required autocomplete="off"/>
                <div class="form__problem mt-3 text-center" id="form__problem " >
                    <p id="form__problem__msg"></p>
                </div>
                <button type="submit" value="submit" class="button button-block mt-5" onclick="submitForm(event)"/>Get Started</button>
                <div class="signup__text-mini mt-2 text-center">
                    <span class=" " >Already registred? <a href="/signin"> Sign in </a></span>
                </div>
            </form>
        </div>
    </div>
</main>

<#include "footer.ftl">

<script src="static/lib/jquery/jquery.min.js"></script>
<script src="static/js/signup.js"></script>
</body>
</html>
