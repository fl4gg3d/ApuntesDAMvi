let cod=document.getElementById("cod");
let nom=document.getElementById("nom");
let amplada=document.getElementById("amplada");
let alcada=document.getElementById("alcada");
let polzades=document.getElementById("polzada");
let hercis=document.getElementById("hercis");
let body = document.getElementsByTagName("body")[0];

let monitors = new Map ();
function recarregarTaula(){

    let taula = document.getElementById("dadesM");
    taula.replaceChildren();

    for (const monitor of monitors.values()) {

        const tr = document.createElement("tr");

        const codTd = document.createElement("td");
        const nomTd = document.createElement("td");
        const ampTd = document.createElement("td");
        const alcTd = document.createElement("td");
        const polzadesTd = document.createElement("td");
        const hercisTd = document.createElement("td");

        codTd.innerText = monitor.cod;
        nomTd.innerText = monitor.nom;
        ampTd.innerText = monitor.amplada;
        alcTd.innerText = monitor.alcada;
        polzadesTd.innerText = monitor.polzades;
        hercisTd.innerText = monitor.hercis;

        tr.appendChild(codTd);
        tr.appendChild(nomTd);
        tr.appendChild(ampTd);
        tr.appendChild(alcTd);
        tr.appendChild(polzadesTd);
        tr.appendChild(hercisTd);

        taula.appendChild(tr);

        if(Number(monitor.cod) === 67){
            tr.classList.add("perrico67");
            body.classList.add("rgb");
        }
        else if(monitor.nom.toLowerCase().includes("persona")){
            tr.classList.add("persona5");
        }
        else if(Number(monitor.hercis) >= 200){
            tr.classList.add("marathon");
        }
    }
}
function boton3(){

    if(monitors.has(cod.value)){
        alert("Aquest COD ja existeix");
        return;
    }

    let nouMonitor = {
        cod: cod.value,
        nom: nom.value,
        amplada: amplada.value,
        alcada: alcada.value,
        polzades: polzades.value,
        hercis: hercis.value
    };

    monitors.set(cod.value, nouMonitor);
    recarregarTaula();
}
function eliminar(){

    let codiEliminar = cod.value;

    if(monitors.has(codiEliminar)){
        monitors.delete(codiEliminar);
        recarregarTaula();
    }else{
        alert("No existeix aquest monitor");
    }

}


