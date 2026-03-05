const p = document.getElementById("textoEX4");

function mostrarfechaBoton(){

    let hoy = new Date();
    let dias = ["Domingo","Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado"];


    let comptador = 1;
    let resultado = "";
    while(comptador < 10){
        hoy.setDate(hoy.getDate()+1);

        let diaSemana = hoy.getDay();
        if(diaSemana !== 0 && diaSemana !== 6){
            comptador++;
            let dia = hoy.getDate();
            let mes = hoy.getMonth()+1;
            let año = hoy.getFullYear();
            let nomDia = dias[diaSemana];
            resultado += `Dia ${comptador}; ${nomDia}, ${dia}/${mes}/${año}, `;
        }
    p.innerText = resultado;
    }
}