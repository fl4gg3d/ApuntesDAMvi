const inputNecesario = document.getElementById('necesarias');
const inputPreferencias = document.getElementById('preferencias');
const inputEstadisticas = document.getElementById('estadisticas');
const resultatP = document.getElementById("resultat");

function aceptar(){
    const data = new Date();
    data.setDate(data.getDate()+30);
    console.log(inputPreferencies.checked)

    document.cookie = `necesarias=${inputNecesario.checked}; expires=${data}`;
    document.cookie = `preferencias=${inputPreferencias.checked}; expires=${data}`;
    document.cookie = `estadisticas=${inputEstadisticas.checked}; expires=${data}`;
}
function rebutjar(){
    const data = new Date();
    data.setDate(data.getDate()+30);

    document.cookie = `necesarias=false; expires=${data}`;
    document.cookie = `estadisticas=false; expires=${data}`;
    document.cookie = `preferencias=false; expires=${data}`;
}

function mostrar(){
    let valorNecesario = "No encontrada";
    let valorPreferencias = "No encontrada";
    let valorEstadisticas = "No encontrada";

    const listaCookies = document.cookie.split(';');
    for (let i = 0; i < listaCookies.length; i++) {
        let cookie = listaCookies[i].trim();
        const clave = cookie.split('=')[0];
        if(clave.trim() == 'necesarias'){
            console.log("encontrado")
            valorNecesario = cookie.split('=')[1];
        }else if(clave.trim() == 'estadisticas'){
            console.log("encontrado")
            valorEstadisticas = cookie.split('=')[1];
        }
        else if (clave.trim() == 'estadisticas'){
            console.log("encontrado")
            valorPreferencias = cookie.split('=')[1];
        }
    }
    resultatP.innerText = `Configuracion de cookies: Necesarias:${valorNecesario =="true"?"Aceptada":(valorNecesario == "false"?"Rebutjada":valorNecesario)}, Preferencies: ${valorPreferencias==="true"?"Acceptada":(valorPreferencias==="false"?"Rebutjada":valorPreferencias)}, Estadistiques: ${valorEstadisticas==="true"?"Acceptada":(valorEstadisticas==="false"?"Rebutjada":valorEstadisticas)}}`
}