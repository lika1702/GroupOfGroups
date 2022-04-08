const cards = document.querySelector(".first-level");
const images = document.querySelectorAll(".third-level");
const backgrounds = document.querySelectorAll(".second-level");
const range = 40;

const calcValue = (a, b) => (a / b * range - range / 2).toFixed(1) // thanks @alice-mx

let timeout;
document.querySelector('.parallax').addEventListener('mousemove', ({
    x,
    y
}) => {
    if (timeout) {
        window.cancelAnimationFrame(timeout);
    }

    timeout = window.requestAnimationFrame(() => {
        const yValue = calcValue(y, window.innerHeight);
        const xValue = calcValue(x, window.innerWidth);

        cards.style.transform = `rotateX(${yValue}deg) rotateY(${xValue}deg)`;

    [].forEach.call(images, (image) => {
            image.style.transform = `translateX(${xValue}px) translateY(${yValue}px)`;
        });

    [].forEach.call(backgrounds, (background) => {
            background.style.transform = `translateX(${xValue*.45}px) translateY(${yValue*.45}px)`;
        })
    })
}, false);
