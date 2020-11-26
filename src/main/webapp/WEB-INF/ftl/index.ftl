<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Post'er</title>
    <link rel="preconnect" href="https://fonts.gstatic.com" />
    <link href="https://fonts.googleapis.com/css2?family=Oswald:wght@200;400;700&display=swap" rel="stylesheet" />
    <link rel="stylesheet" href="static/lib/font-awesome/css/font-awesome.css" />
    <link rel="stylesheet" href="static/lib/bootstrap/css/bootstrap.css" />
    <link href="static/style/style.css"  rel="stylesheet"/>
  </head>
  <body>
    <div class="container">
      <header>
        <div class="header h2">Post'er</div>
        <div class="header__nav">
          <nav class="nav">
            <a class="nav__item active" href="#">main</a>
            <a class="nav__item" href="#">sign up</a>
            <a class="nav__item" href="#">sign in</a>
          </nav>
        </div>
      </header>
    </div>
    <main>
      <div class="container">
        <section class="title">
          <div class="title__right">
            <h1 id="typewrite">
            </h1>
            <p>An elite application with which you can share your precious opinion.<br/> And leave your kind messages to the posts of other people.
            </p>
            <small><p class="title__small">* Of course, we do not approve of insulting other people and racial, gender discrimination</p></small>
          </div>
          <div class="title__left roflan__container " onclick="roflanAway()" >
            <img src="static/img/face.png" alt="pic" id="roflan"/>
          </div>
        </section>
      </div>
    </main>
    <footer>
      <div class="container">
          made by <a href="https://ildargin.com">ildargin</a>
      </div>
    </footer>
    <script src="static/js/move.js"></script>
    <script src="static/js/main.js"></script>
  </body>
</html>
