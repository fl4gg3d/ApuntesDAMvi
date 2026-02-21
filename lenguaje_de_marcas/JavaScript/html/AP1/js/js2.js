const p = document.getElementById("textoP");
function ramdomHour(min, max){
    return Math.random() * (max - min) + min;
}
let hour = ramdomHour(0, 23);
console.log(hour);


function saludo(){
    let salutacio = hour <= 12 ? "Bon dia" : "Bona tarda";

    p.innerText = salutacio;
}