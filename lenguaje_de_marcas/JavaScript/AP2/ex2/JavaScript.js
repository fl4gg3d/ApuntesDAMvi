let monitors = [
    {
        cod: "M001",
        nom: "Samsung Odyssey",
        amplada: 60,
        alcada: 35,
        polzades: 27,
        hercis: 144
    },
    {
        cod: "M002",
        nom: "LG UltraGear",
        amplada: 62,
        alcada: 36,
        polzades: 27,
        hercis: 165
    },
    {
        cod: "M003",
        nom: "ASUS TUF Gaming",
        amplada: 55,
        alcada: 32,
        polzades: 24,
        hercis: 144
    }
];
function boton(){
    let taula = document.getElementById("tbody");

    for (let i = 0; i < monitors.length; i++) {
        tbody.innerHTML +=
            "<tr>" +
            "<td>" + monitors[i].cod + "</td>" +
            "<td>" + monitors[i].nom + "</td>" +
            "<td>" + monitors[i].amplada + "</td>" +
            "<td>" + monitors[i].alcada + "</td>" +
            "<td>" + monitors[i].polzades + "</td>" +
            "<td>" + monitors[i].hercis + "</td>" +
            "</tr>";

    }
}

