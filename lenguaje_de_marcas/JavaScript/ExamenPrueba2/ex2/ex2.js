const nombre  = document.getElementById('nombre');
const tipemasa  = document.getElementById('massa');
const tamany = document.getElementById('tamany');
const ingredients = document.getElementById('ingredientes');
const resultat = document.getElementById('resultat');

let arrayPisa = [];

function crearPisa(){

    let pisa = {
        nombre : nombre.value,
        tipoMassa : tipemasa.value,
        tamany : tamany.value,
        ingredients : ingredients.value,
        retornaNom : function (){
            resultat.innerText = `Nombre: ${this.nombre} | Massa: ${this.tipemasa} `;
        }
    }
    arrayPisa.push(pisa);
    localStorage.setItem('UltimAfegir', pisa.retornaNom());
}