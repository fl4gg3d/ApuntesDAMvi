const monitors = [
    {
        COD:1234,
        nom: "AOC123",
        amplada: 3,
        altura: 4,
        polzadas:56,
        hez:20
    },
    {
        COD:2222,
        nom: "LG234",
        amplada: 2,
        altura: 3,
        polzadas:62,
        hez:50
    },
    {
        COD:4344443,
        nom: "SAMSUNG124",
        amplada: 1,
        altura: 2,
        polzadas:94,
        hez:80
    }
];

function boton2(){
    for (const monitor of monitors) {
        const taula = document.getElementById("dadesM");
        const tr = document.createElement("tr");
        const codTd = document.createElement('td');
        const nomTd = document.createElement('td');
        const ampTd = document.createElement('td');
        const alcTd = document.createElement('td');
        const polzadesTd = document.createElement('td');
        const hercisTd = document.createElement('td');

        codTd.innerText = monitor.COD;
        nomTd.innerText = monitor.nom;
        ampTd.innerText = monitor.amplada;
        alcTd.innerText = monitor.altura;
        polzadesTd.innerText = monitor.polzadas;
        hercisTd.innerText = monitor.hez;

        tr.appendChild(codTd);
        tr.appendChild(nomTd);
        tr.appendChild(ampTd);
        tr.appendChild(alcTd);
        tr.appendChild(polzadesTd);
        tr.appendChild(hercisTd);
        taula.appendChild(tr);
    }


}


