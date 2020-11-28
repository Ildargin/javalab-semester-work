document.getElementById('nav__three').className += ' active';

function submitForm(e) {
  let email = document.getElementById('email').value;
  let password = document.getElementById('password').value;

  if (password.length < 8) {
    formError('Not valid Password');
  }
  if (!validateEmail(email)) {
    formError('Incorrect email');
  } else {
    debugger;
    $.ajax({
      type: 'post',
      url: '/signup',
      data: {
        email,
        password,
      },
      cache: false,
      success: () => {
        window.location.replace('/success');
      },
    });
    clearForm();
    e.preventDefault();
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
  document.getElementById('repassword').value = '';
}