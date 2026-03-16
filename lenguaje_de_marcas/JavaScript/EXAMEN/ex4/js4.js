const p = document.getElementById("ptexto4");
function randomNote(min, max){
    min = Math.ceil(min);
    max = Math.floor(max);
    return Math.floor(Math.random() * (max - min) + min);
}


function boton4 (){
    let arrayNumero = [];
    let numeroR = randomNote(50, 150);
    arrayNumero.push(numeroR);

    for (const arrayNumeroElement of arrayNumero) {



    }
}