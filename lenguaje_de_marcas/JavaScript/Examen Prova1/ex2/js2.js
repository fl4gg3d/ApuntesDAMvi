const divHtml = document.getElementById("container");



function boton(){
    let divd = document.createElement("div");
    divd.classList.add("caixa");

    divd.style.backgroundColor = `rgb(${random(0, 256)},${random(0, 256)},${random(0, 256)})`
    divHtml.appendChild(divd);
}