function subChanges(e) {
  let formData = new FormData();
  let firstname = document.getElementById('firstname').value;
  let lastname = document.getElementById('lastname').value;
  let birthdate = document.getElementById('birthdate').value;
  let file = document.getElementById('file').files[0];
  formData.append('firstname', firstname);
  formData.append('lastname', lastname);
  formData.append('birthdate', birthdate);
  formData.append('file', file);

  debugger;
  $.ajax({
    type: 'post',
    url: '/profile',
    data: formData,
    processData: false,
    contentType: false,
    cache: false,
    success: () => {
      window.location.replace('/success');
    },
  });
  e.preventDefault();
}
