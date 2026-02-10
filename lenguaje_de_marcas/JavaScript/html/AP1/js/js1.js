const p = document.getElementById("pepe");
function js1(){
    let puntsInicials = 50;
    let bonificacio = 10;
    let penalitzacio = 5;
    let missatge = "El teu perfil és: ";

    let resultat = (((puntsInicials + bonificacio) - penalitzacio) * 2) / 5;

    p.innerText = missatge + resultat;

}