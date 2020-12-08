function UpdateProfile(e) {
  let inputFN = document.getElementById('firstname').value;
  let inputLN = document.getElementById('lastname').value;
  let inputBD = document.getElementById('birthdate').value;

  let firstName = inputFN ? inputFN : document.getElementById('fn').innerHTML;
  let lastName =inputLN ? inputLN : document.getElementById('ln').innerHTML;
  let birthDate = inputBD? inputBD : formatted(document.getElementById('bd').innerHTML);
  e.preventDefault();
  $.ajax({
    type: 'post',
    url: '/profile',
    data: {
      firstName,
      lastName,
      birthDate,
    },
    cache: false,
    statusCode: {
      200: () => {
          window.location.reload();
      },
      400: () => {
        alert("oops, something goes wrong");
      },

    }
  });
}

function UpdateProfilePic() {
  let formData = new FormData();
  let file = document.getElementById('image').files[0];
  formData.append('image', file);
  $.ajax({
    type: 'post',
    url: '/profile/updateimage',
    data: formData,
    contentType: false,
    processData: false,
    cache: false,
    // success: () => {
    //   window.location.reload();
    // },
  });
}

