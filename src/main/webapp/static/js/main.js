let textAnimate = (function () {
  let h1 = document.getElementById('typewrite');
  text = 'Poster, service';
  tick = 0;
  setTimeout(
    setInterval(() => {
      h1.innerHTML = text.slice(0, tick);
      if (tick === text.length) {
        clearInterval();
      }
      tick++;
    }, 100),
    1000
  );
})();

let roflanAway = () => {
  document.getElementById('roflan').style.animation = 'none';
};
