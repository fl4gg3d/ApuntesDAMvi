const container = document.getElementById('contenidor');
const nTrobar = document.getElementById('ods');
const temps = document.getElementById('temps');
const resultado = document.getElementById('resultat');
const comptador = document.getElementById('comptador');

function randomNote(min, max) {
    return Math.floor(Math.random() * (max - min)) + min;
}

// Esto es un constructor para crear la fitxa
function Fitxa(id, path){
    this.id = id;
    this.path = path;
}

function compteenrrere() {
    let contador = 30;
    let interval = setInterval(()=>{
        if(contador>=0)
        {
            temps.innerText=contador
            contador--
        }
        else if (contador===0)
        {
            clearInterval(interval)
        }
    }, 1000)
}


//Esto es pa crear todos las fitxas hasta diecisiete
const arrayFitxas = [];
let fitxa;
for (let i = 1; i < 18; i++) {
    if (i < 10) {
        fitxa = new Fitxa(i, `imagenes/S-WEB-Goal-0${i}.png`);
        arrayFitxas.push(fitxa);
    } else {
        fitxa = new Fitxa(i, `imagenes/S-WEB-Goal-${i}.png`);
        arrayFitxas.push(fitxa);
    }
}
let nRODS = 0;
function posaCaixes(){
    nRODS = randomNote(0,17)
    resultat.innerText = ''
    comptador.innerText = ''
    temps.innerText=''
    nTrobar.innerText=arrayFitxas[nRODS].id;
    compteenrrere()
    let interval = setInterval(crearGraella,2000)
}
function crearGraella(){
    container.innerHTML = '';
    //Para esto a dejado utilizar el innerHtml no lo toques
    for (let i = 0; i < 20; i++) {
        let odsImg = arrayFitxas[randomNote(0,17)]
        let imgO = document.createElement('img');
        let divO = document.createElement('div');
        divO.classList.add('items');
        imgO.classList.add('imag');
        imgO.src = odsImg.path;
        divO.appendChild(imgO);
        divO.onclick = onclickDiv;
        container.appendChild(divO);
    }
}

function onclickDiv(evento){
    let puntos = 0;
    if(evento == arrayFitxas[nRODS].path){
        puntos++;
        comptador.innerText = puntos;
    }else{
        puntos--;
        comptador.innerText = puntos;
    }
}