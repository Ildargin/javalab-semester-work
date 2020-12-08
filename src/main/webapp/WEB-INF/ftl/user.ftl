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
    <link rel="stylesheet" href="static/style/footer.css" />
    <link rel="stylesheet" href="static/style/user.css" />
</head>
<body>

<#include 'header-user.ftl'>

<main class="main">
    <div class="container">
        <#list posts as post>
            <a href="/user/post:${post.id}" class="post">
                <div class="post__left">
                    <div class="post__image"><img src="${post.image_path}" alt="UserImage" /></div>
                    <div class="post__info">
                        <div class="post__username">
                            <span class="name" id="name">${(post.firstName)!} ${((post.lastName)!)}
                            <span class="email" id="email">${post.email}
                        </div>
                        <div class="post__title">
                            <span class="title" id="title">${post.title}
                        </div>
                    </div>
                </div>
            </a>
        </#list>
    </div>
</main>

<#include 'footer.ftl'>

</body>
</html>
