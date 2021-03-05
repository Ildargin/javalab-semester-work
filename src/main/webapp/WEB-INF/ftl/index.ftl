<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>Poster</title>
  <link rel="preconnect" href="https://fonts.gstatic.com">
  <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@200;400;700&display=swap" rel="stylesheet">
  <link rel="stylesheet" href="static/lib/bootstrap/css/bootstrap.css" />
  <link rel="stylesheet" href="static/style/index.css" />
  <link rel="stylesheet" href="static/style/header.css" />
  <link rel="stylesheet" href="static/style/main.css" />
  <link rel="stylesheet" href="static/style/footer.css" />
</head>
<body>

<#include "header.ftl">

<main class="main">
  <div class="container">
    <div class="main__container row">
      <div class="main__left col-md-6 col-sm-12">
        <h1 id="typewrite"></h1>
        <p>An elite application with which you can share your precious opinion. And leave your kind messages to the posts of other people.</p>
        <small><p class="main__small">* Of course, we do not approve of insulting other people and racial, gender discrimination</p></small>
      </div>
      <div class="main__right col-md-6 col-sm-12" onclick="roflanAway()">
        <div class="roflan__container col-sm-12">
          <img src="static/img/face.png" alt="pic" id="roflan" />
        </div>
      </div>
    </div>
  </div>
</main>

<#include "footer.ftl">

<script src="static/js/main.js"></script>
</body>
</html>
