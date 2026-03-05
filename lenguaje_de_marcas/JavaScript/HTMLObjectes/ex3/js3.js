const p = document.getElementById("mostrarFecha");
const dia = document.getElementById("dia").value;
const mes = document.getElementById("mes").value-1;
const any = document.getElementById("any").value;
function mostrarfechaBoton(){
    let date = new Date(any, mes, dia);
    let data2 = new Date();

    const diferenciaMilisegundos = data2.getTime()-date.getTime();

    const diferenciaDies = Math.abs(Math.floor(diferenciaMilisegundos/(1000*60*60*24)));

    p.innerText = `La diferencia en dies es: ${diferenciaDies}`;
}