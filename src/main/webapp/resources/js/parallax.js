const cards = document.querySelector(".logo-text img");
const images = document.querySelectorAll(".logo-text h1");
const backgrounds = document.querySelectorAll("#logo-block .logo");
const range = 40;

const calcValue = (a, b) => (a / b * range - range / 2).toFixed(1) // thanks @alice-mx

let timeout;
document.querySelector('#logo-block .logo').addEventListener('mousemove', ({
    x,
    y
}) => {
    if (timeout) {
        window.cancelAnimationFrame(timeout);
    }

    timeout = window.requestAnimationFrame(() => {
        const yValue = calcValue(y, window.innerHeight);
        const xValue = calcValue(x, window.innerWidth);

        cards.style.transform = `rotateX(${yValue}deg) rotateY(${xValue}deg) translateX(${xValue}px) translateY(${yValue}px)`;

    [].forEach.call(images, (image) => {
            image.style.transform = `rotateX(${yValue}deg) rotateY(${xValue}deg) translateX(${xValue}px) translateY(${yValue}px)`;
        });

    [].forEach.call(backgrounds, (background) => {
            background.style.transform = `rotateX(${yValue}deg) rotateY(${xValue}deg) translateX(${xValue}px) translateY(${yValue}px)`;
        })
    })
}, false);

document.querySelector('#logo-block .logo').addEventListener('mouseout', ({
    x,
    y
}) => {
    if (timeout) {
        window.cancelAnimationFrame(timeout);
    }

    timeout = window.requestAnimationFrame(() => {
        const yValue = calcValue(y, window.innerHeight);
        const xValue = calcValue(x, window.innerWidth);

        cards.style.transform = `rotateX(0) rotateY(0) translateX(0) translateY(0)`;

    [].forEach.call(images, (image) => {
            image.style.transform = `rotateX(0) rotateY(0) translateX(0) translateY(0)`;
        });

    [].forEach.call(backgrounds, (background) => {
            background.style.transform = `rotateX(0) rotateY(0) translateX(0) translateY(0)`;
        })
    })
}, false);
