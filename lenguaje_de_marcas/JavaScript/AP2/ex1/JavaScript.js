let cod=document.getElementById("cod");
let nom=document.getElementById("nom");
let amplada=document.getElementById("amplada");
let alcada=document.getElementById("alcada");
let polzades=document.getElementById("polzada");
let hercis=document.getElementById("hercis");
let monitors = [];

// function boton1(){
//     let taula = document.getElementById("tbody");
//     taula.innerHTML= "";
//
//     for (let i = 0; i < monitors.length; i++) {
//         tbody.innerHTML +=
//             "<tr>" +
//             "<td>" + monitors[i].cod + "</td>" +
//             "<td>" + monitors[i].nom + "</td>" +
//             "<td>" + monitors[i].amplada + "</td>" +
//             "<td>" + monitors[i].alcada + "</td>" +
//             "<td>" + monitors[i].polzades + "</td>" +
//             "<td>" + monitors[i].hercis + "</td>" +
//             "</tr>";
//
//     }
// }

function boton2(){

    let taula = document.getElementById("dadesM");
    let nouMonitor = {
        cod: cod.value,
        nom: nom.value,
        amplada: amplada.value,
        alcada: alcada.value,
        polzades: polzades.value,
        hercis: hercis.value
    }
    monitors.push(nouMonitor);

    taula.innerHTML +=
        "<tr>"+
        "<td>"+nouMonitor.cod+"</td>"+
        "<td>"+nouMonitor.nom+"</td>"+
        "<td>"+nouMonitor.amplada+"</td>"+
        "<td>"+nouMonitor.alcada+"</td>"+
        "<td>"+nouMonitor.polzades+"</td>"+
        "<td>"+nouMonitor.hercis+"</td>"+
        "</tr>";

}

