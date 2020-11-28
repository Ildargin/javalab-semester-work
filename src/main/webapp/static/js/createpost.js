document.getElementById('nav__one').className += ' active';

function submitForm(e) {
  let title = document.getElementById('title').value;
  let description = document.getElementById('description').value;
  if (title.length < 10 || description.length < 50) {
    alert('follow the rules for post');
    break;
  }
  $.ajax({
    type: 'post',
    url: '/createpost',
    data: {
      title,
      description,
    },
    cache: false,
    success: () => {
      window.location.replace('/success');
    },
  });
  clearForm();
  e.preventDefault();
}

function clearForm() {
  document.getElementById('title').value = '';
  document.getElementById('description').value = '';
}
