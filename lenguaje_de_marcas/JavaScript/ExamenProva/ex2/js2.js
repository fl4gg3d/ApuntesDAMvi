const contenidor = document.getElementById("contenidor");
const p = document.getElementById("resultat");

function randomNote(min, max) {
    return Math.floor(Math.random() * (max - min)) + min;
}

let comptador = 0;
function posarCaixes(){
    for (let i = 0; i < randomNote(1, 5); i++) {
        console.log(i);
        const div = document.createElement("div");
        div.classList.add("items");
        div.style.backgroundColor = `rgb(${randomNote(0, 256)},${randomNote(0, 256)},${randomNote(0, 256)})`;
        contenidor.appendChild(div);
        comptador++;
        div.addEventListener('mouseenter', (event) => {
            event.target.classList.add("classe1");
        })
        div.addEventListener('mouseleave', (event) => {
            event.target.classList.remove("classe1");
        })
        div.addEventListener('click', (event) => {
            div.remove();
            comptador--;
            p.innerText = `En total hi ha ${comptador} elements`;
        })
    }
    p.innerText = `En total hi ha ${comptador} elements`;
}

localStorage.setItem("comptadorCaixes", comptador);


function clica2(){
    localStorage.removeItem("comptadorCaixes");
    comptador = 0;
    contenidor.innerHTML = "";
    p.innerText = "S'ha resetejat el contingut!";
}