function changeVotes(text, id) {
  let selector = '#' + id;
  let parent = $(selector);
  let licon = parent.find('.icon-like')[0];
  let dicon = parent.find('.icon-dislike')[0];
  let dcount = parent.find('.dislike-count')[0];
  let lcount = parent.find('.like-count')[0];
  if (text === 'like') {
    if (licon.className.indexOf('icon-like-active') === -1) {
      licon.className += ' icon-like-active';
      lcount.innerHTML = +lcount.innerText + 1;
      if (dicon.className.indexOf('icon-dislike-active') !== -1) {
        dicon.className = 'icofont-thumbs-down icon-dislike';
        dcount.innerHTML = +dcount.innerText - 1;
      }
      send(id, 'like');
    }
  }
  if (text === 'dislike') {
    if (dicon.className.indexOf('icon-dislike-active') === -1) {
      dicon.className += ' icon-dislike-active';
      dcount.innerHTML = +dcount.innerText + 1;
      if (licon.className.indexOf('icon-like-active') !== -1) {
        licon.className = 'icofont-thumbs-up icon-like';
        lcount.innerHTML = +lcount.innerText - 1;
      }
      send(id, 'dislike');
    }
  }
}

function send(id, value) {
  $.ajax({
    type: 'post',
    url: '/user',
    data: {
      id,
      value,
    },
    cache: false,
  });
}
