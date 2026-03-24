const ul = document.querySelector("ul");


function añadirClase(){
    this.classList.add("classe1");
    ul.children.classList.remove("classe1");
}

ul.addEventListener('click', (event) => {
    if (event.target.tagName==="LI") {
        for (let i; i < ul.children.length; i++) {
            ul.children[i].classList.remove("classe1");
        }
        event.target.classList.add("classe1");
    }
})