const list = document.querySelector("#list-of-lang");
const sel = document.querySelector("#choice-lang");
sel.addEventListener('change', () => {
    let newLangLi = document.createElement('li');
    let newLangLabel = document.createElement('label');
    let newLangInput = document.createElement('input');
    let newLangSpan = document.createElement('span');
    newLangLi.id = 'learned-lang';
    newLangInput.type = 'checkbox';
    newLangInput.name = 'profile.languages';
    newLangInput.value = sel.value;
    newLangInput.setAttribute('checked', 'true');
    newLangSpan.innerHTML = sel.options[sel.value].text;
    console.log(sel.value);
    newLangLabel.appendChild(newLangInput);
    newLangLabel.appendChild(newLangSpan);
    newLangLi.appendChild(newLangLabel);
    list.appendChild(newLangLi);
})

const learned_lang = document.querySelectorAll("#learned-lang");

learned_lang.forEach((item) => {
    item.addEventListener('click', (event) => {
        item.remove();
    })
})
