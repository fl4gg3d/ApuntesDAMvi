const inputText = document.getElementById("input");
const p = document.getElementById("resultat");

inputText.addEventListener("input", e => {

    let text = inputText.value;

    let paraules = text.split(" ");

    for (const palabra of paraules) {
        if(palabra.length % 2 == 0) {
            p.innerText = palabra.toUpperCase();
        }else{
            p.innerText = palabra.toLowerCase();
        }

    }

})
