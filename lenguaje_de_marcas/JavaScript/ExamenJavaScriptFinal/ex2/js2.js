const p = document.getElementById("resultado");
const container = document.getElementById("container");
const input = document.getElementById("nombreP");

let array = []
function crearPersonaje(){
    let personaje = {
        nombre: input.value,
        score: 0,
        toString: function() {
            return this.nombre.toString() +" "+ this.score.toString();
        }
    }
    array.push(personaje);
    let botonP = document.createElement("button");
    botonP.innerText = personaje.nombre;
    container.appendChild(botonP);
    botonP.addEventListener("click", ev => {
        personaje.score++;
        resultado.innerText = personaje.toString();
    });
    input.value = "";
}