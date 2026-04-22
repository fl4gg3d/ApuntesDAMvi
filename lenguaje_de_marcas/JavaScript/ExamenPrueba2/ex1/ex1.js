const container = document.getElementById("container");
const resultatP = document.getElementById("resultat");


function afegirItem(){
    let cubico = document.createElement("div");
    cubico.classList.add("caixa");
    cubico.style.backgroundColor = "lime";
    container.appendChild(cubico);
    let contador = 0;
    cubico.addEventListener("click", ev => {
        contador++;
        resultatP.innerText = contador;
    })
}