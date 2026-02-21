const input = document.getElementById("input");
const nomTabla = document.getElementById("Nom");
const notaTabla = document.getElementById("Nota");
function randomNote(min, max){
    min = Math.ceil(min);
    max = Math.floor(max);
    return Math.floor(Math.random() * (max - min) + min);
}
function boto(){
    let nota = randomNote(0, 10);
    let notaText = "";
    notaText += nota;
    let thN = document.createElement("th");
    thN.innerText = input.value;
    nomTabla.appendChild(thN);
    let thNumber = document.createElement("th");
    thNumber.innerText = notaText;
    notaTabla.appendChild(thNumber);
    if(nota < 5){
       thNumber.style.backgroundColor = "red";
       thNumber.style.color = "white";

    }
}
