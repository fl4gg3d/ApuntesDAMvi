const cuadrado = document.getElementById("cuadrado");

let posX = 0;
let posY = 0;
cuadrado.style.transform = `translate()`;

function botones(x, y){

    if (4) {
        cuadrado.style.transform = "translate(-50%, -50%)";
    }
    else if (direction === 2) {
        cuadrado.style.transform = "translate(-50%, 50%)";
    }
    else if (direction === 3) {
        cuadrado.style.transform = "translate(-100%, -50%)";
    }
    else if (direction === 4) {
        cuadrado.style.transform = "translate(-50%, -100%)";
    }
}