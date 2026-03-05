const p = document.getElementById('textoP');
function boto(){
    let clase = [
        {nom: "Adria", cognom: "Piquer", nota: 1},
        {nom: "Ramon", cognom: "Ruiz", nota: 6},
        {nom: "Gabriel", cognom: "Flores", nota: 3}
    ];
    let msg = "";
    for (const claseElement of clase) {
        msg += `Alumne nom: ${claseElement.nom} \n Alumne cognom: ${claseElement.cognom}\nAlumne nota: ${claseElement.nota}\n`;
    }
    p.innerText = msg;
}