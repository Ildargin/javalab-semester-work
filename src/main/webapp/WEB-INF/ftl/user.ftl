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
        <div class="post">
            <div class="post__left">
                <div class="post__image"><img src="https://picsum.photos/200" alt="U" /></div>
                <div class="post__info">
                    <div class="post__username">
                        <span class="name" id="name">ildar Gainatullin</span>
                        <span class="email" id="email">ildar@Gainatullin.gmail.com</span>
                    </div>
                    <div class="post__title">
                        <span class="title" id="title">How to do money</span>
                    </div>
                </div>
            </div>
            <div class="post__right">
                <div class="post__details" id="1">
                    <div class="likes" onclick="changeVotes('like', 1)">
                        <i class="icofont-thumbs-up icon-like"></i>
                        <span class="like-count">21</span>
                    </div>
                    <div class="dislikes" onclick="changeVotes('dislike', 1)">
                        <i class="icofont-thumbs-down icon-dislike"></i>
                        <span class="dislike-count">32 </span>
                    </div>
                </div>
            </div>
        </div>
    </div>
</main>

<#include 'footer.ftl'>

<script src="static/lib/jquery/jquery.min.js"></script>
<script defer src="static/js/user.js"></script>
</body>
</html>
