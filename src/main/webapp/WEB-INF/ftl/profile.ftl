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
    <link rel="stylesheet" href="static/style/profile.css" />
    <link rel="stylesheet" href="static/style/footer.css" />
</head>
<body>

<#include "header-user.ftl">

<main class="main">
    <div class="profile container d-flex">
        <div class="d-flex flex-row col-sm-12 col-md-6 mb-3">
            <div class="profile__info">
                <h1 class="mb-3" >Profile</h1>
                <div class="profile__image">
                    <img src=${(user.imagePath)!"https://picsum.photos/500"} alt="profile__photo">
                </div>
                <div class="profile__info__col mt-4 ">
                    <div class="row">
                        <span>First name: <h5 id="fn">${(user.firstName)!"undefined"}</h5></span>
                    </div>
                    <div class="row">
                        <span>Last name: <h5 id="ln">${(user.lastName)!"undefined"}</h5></span>
                    </div>
                    <div class="row">
                        <span>birthdate: <h5 id="bd">${(user.birthDate)!"undefined"}</h5></span>
                    </div>
                </div>
            </div>
        </div>
        <div class="d-flex flex-column col-sm-12 col-md-6" id="signup">
            <form class="profile__updater d-flex flex-column" action="">
                <h1 class="mb-3" >Update fields</h1>
                <label>first name</label>
                <input  minlength="3" id="firstname" required autocomplete="off"/>
                <label>last name</label>
                <input  minlength="3" id="lastname" required autocomplete="off"/>
                <label class="mt-2" >birth-date</label>
                <input  type="date" minlength="3" id="birthdate" required autocomplete="off"/>
                <label class="mt-2"style="color: lightgray;">
                    *Fill all the fields for update</br>
                    **if you want to change your password,</br>
                    contact with <a href="https://ildargin.com">admin</a>
                </label>
                <button type="submit" value="submit" class="button button-block mt-3 mb-5" onclick="UpdateProfile(event)"/>submit changes</button>
            </form>
            <form action="">
                <label class="mt-2">Profile picture (jpeg, png)</label>
                <input type="file" name="image" id="image">
                <button type="submit" value="submit" class="button button-block mt-5" onclick="UpdateProfilePic()"/>Update picture</button>
            </form>
        </div>
    </div>
</main>

<#include "footer.ftl">
<script src="static/lib/jquery/jquery.min.js"></script>
<script src="static/js/profile.js"></script>
</body>
</html>
