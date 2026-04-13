const pContador = document.getElementById('visites');

let contador=0;
if(localStorage.getItem("nVisites") != null) {
    contador = Number(localStorage.getItem("nVisites"));
}
contador++;
localStorage.setItem("nVisites", contador);

pContador.innerText = contador;

function eliminar(){
    localStorage.removeItem("nVisites");
    contador = 0;
    pContador.innerText = contador;
}
