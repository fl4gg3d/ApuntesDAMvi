const botones = document.getElementById("botones");
const temps = document.getElementById("temps");
const puntuacion = document.getElementById("puntuacio");
const container = document.getElementById("contenidor");


let punts = 0;
let casillas = 0;
let mines = 0;
let dany = 0;
let bonusD = 0;
let bonusF  = 0;
let bonusC = 0;

let contador = 0;



function facil(){
    datosD("facil");
    generarTauler()
    compteenrrere(30);

}
function normal(){
    datosD("normal");
    compteenrrere(30);
    generarTauler()
}
function dificil(){
    datosD("dificil");
    compteenrrere(30);
    generarTauler()
}

function esdevenimentDiv(){

}
function generarTauler(){
    container.innerHTML = '';
    for(let i=0; i < casillas; i++){
        let div0 = document.createElement("div");
        div0.classList.add("roca");
        div0.onclick = esdevenimentDiv();
        container.appendChild(div0);
    }
}
function compteenrrere(tiempo) {
    contador = tiempo;
    let interval = setInterval(()=>{
        if(contador>=0)
        {
            temps.innerText = contador;
            contador--
        }
        else if (contador===0)
        {
            clearInterval(interval)
        }
    }, 1000)
}
function datosD(dificultad){
    $.ajax({
        method:"POST",
        url:"js/php/phpGameData.php",
        data:{"dificultad": dificultad},
        dataType:"json",
        success:function (data){
            casillas = data.QuantitatCaselles;
            mines = data.QuantitatCaselles;
            dany = data.DanyMines;
            bonusD = data.bonusDiamant;
            bonusF = data.bonusFerro;
            bonusC = data.bonusCoure;
        },
        error: function (jqXHR, textStatus, error){
            console.log(jqXHR);

        }
    });
}