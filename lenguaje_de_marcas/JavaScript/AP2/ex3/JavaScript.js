let cod=document.getElementById("cod");
let nom=document.getElementById("nom");
let amplada=document.getElementById("amplada");
let alcada=document.getElementById("alcada");
let polzades=document.getElementById("polzada");
let hercis=document.getElementById("hercis");
let monitors = [];

function eliminar(){

}

function boton3(){

    let taula = document.getElementById("dadesM");
    taula.replaceChildren();
    let nouMonitor = {
        cod: cod.value,
        nom: nom.value,
        amplada: amplada.value,
        alcada: alcada.value,
        polzades: polzades.value,
        hercis: hercis.value
    }
    monitors.push(nouMonitor);
    const tr = document.createElement("tr");
    const codTd = document.createElement('td');
    const nomTd = document.createElement('td');
    const ampTd = document.createElement('td');
    const alcTd = document.createElement('td');
    const polzadesTd = document.createElement('td');
    const hercisTd = document.createElement('td');

    for (const monitor of monitors) {

        codTd.innerText = monitor.cod;
        nomTd.innerText = monitor.nom;
        ampTd.innerText = monitor.amplada;
        alcTd.innerText = monitor.amplada;
        polzadesTd.innerText = monitor.polzades;
        hercisTd.innerText = monitor.hercis;

        tr.appendChild(codTd);
        tr.appendChild(nomTd);
        tr.appendChild(ampTd);
        tr.appendChild(polzadesTd);
        tr.appendChild(hercisTd);
        tr.appendChild(polzadesTd);
        tr.appendChild(hercisTd);

        document.querySelector("tbody").append(tr);

    }


}


