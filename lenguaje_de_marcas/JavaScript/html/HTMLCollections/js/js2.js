const aletoris = new Set();
const llista = document.getElementById("ul");
const p = document.getElementById("textoId")
function boton(){
    aletoris.clear();

    for(let i=0;i<100;i++){
        const naleatori = Math.floor(Math.random()*101);
        if(!aletoris.has(naleatori)){
            const li = document.createElement("li");
            li.innerText = String(naleatori);
            llista.appendChild(li);
        }
        aletoris.add(naleatori);
    }
    p.innerText= `Finalmente hi ha ${aletoris.size} numeros`
}
