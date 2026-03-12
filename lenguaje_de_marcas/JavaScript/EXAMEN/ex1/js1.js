const nombre = document.getElementById("nom");
const puntosP = document.getElementById("puntosPrecision");
const cadenciaTiro = document.getElementById("cadenciaTiro");
const classe = document.getElementById("classe");
const pP = document.getElementById("retornarArrayP");
const pF = document.getElementById("retornarArrayF");
let arrayF = [];
let arrayP = [];

function crear(){

    let personaje = {

        nom: nombre.value,
        puntosP: puntosP.value,
        cadenciaTiro: cadenciaTiro.value,
        classe: classe.value

    }

    if(personaje.classe == 1){
        arrayF.push(personaje);
    }else if(personaje.classe == 2){
        arrayP.push(personaje);
    }

}
function retornar(){

    for (const arrayPElement of arrayP) {
        pP.innerText += `El pistoler ${arrayPElement.nom} té ${arrayPElement.puntosP} i ${arrayPElement.cadenciaTiro}. `;
    }
    for (const arrayPElement of arrayF) {
        pF.innerText += `El francotirador ${arrayPElement.nom} té ${arrayPElement.puntosP} i ${arrayPElement.cadenciaTiro}. `;
    }
}