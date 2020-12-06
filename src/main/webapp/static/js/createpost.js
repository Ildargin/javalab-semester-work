document.getElementById('nav__one').className += ' active';

function submitForm(e) {
  let title = document.getElementById('title').value;
  let text = document.getElementById('text').value;
  if (title.length < 10 || text.length < 50) {
    alert('follow the rules for post');
  } else{
    $.ajax({
      type: 'post',
      url: '/createpost',
      data: {
        title,
        text
      },
      cache: false,
      success: () => {
        window.location.replace('/success');
      },
    });
  }
  clearForm();
  e.preventDefault();
}

function clearForm() {
  document.getElementById('title').value = '';
  document.getElementById('text').value = '';
}
