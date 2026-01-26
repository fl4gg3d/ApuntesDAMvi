const p = document.getElementById("resultado");
function js(){
    function getRandomInt(max) {
        return Math.floor(Math.random() * max);
    }
    let aletori1 = getRandomInt(10);
    let aletori2 = getRandomInt(10);
    let contador = 0;
    let missatge = "";

    while(aletori1 != aletori2) {
        aletori2 = getRandomInt(10);
        contador++;

        console.log(aletori2 +" "+ "Aleatori2");
        console.log(aletori2 +" "+ "Aleatori1");
    }

    missatge += contador;
    p.innerText = missatge + " " + aletori2;
}
