document.getElementById('nav__three').className += ' active';

function submitForm(e) {
  e.preventDefault();
  let email = document.getElementById('email').value;
  let password = document.getElementById('password').value;
  if (password.length < 8) {
    formError('Not valid Password');
  }
  if (!validateEmail(email)) {
    formError('Incorrect email');
  } else {
    $.ajax({
      type: 'post',
      url: '/signin',
      data: {
        email,
        password,
      },
      cache: false,
      statusCode: {
        200: function (response) {
          window.location.replace('/user');
        },
        400: function (response) {
          window.location.reload(true);
        },
      }
    });
    clearForm();
  }
}

function formError(text) {
  let msc = document.getElementById('form__problem__msg');
  msc.innerHTML = text;
  setTimeout(() => {
    msc.innerHTML = '';
  }, 4000);
}

function validateEmail(email) {
  const re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
  return re.test(String(email).toLowerCase());
}

function clearForm() {
  document.getElementById('email').value = '';
  document.getElementById('password').value = '';
}
