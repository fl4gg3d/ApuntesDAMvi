const nomInput = document.getElementById("nom");
const valorInput = document.getElementById("valor");
const resultadP = document.getElementById("resultat");
function getCookie(cname) {
    let name = cname + "=";
    let ca = document.cookie.split(';');
    for(let i = 0; i < ca.length; i++) {
        let c = ca[i];
        while (c.charAt(0) == ' ') {
            c = c.substring(1);
        }
        if (c.indexOf(name) == 0) {
            return c.substring(name.length, c.length);
        }
    }
    return "";
}

function añadirCookie(){
    const data = new Date();
    data.setDate(data.setDate()+1);
    document.cookie = `${nomInput.value}=${valorInput.value}; expires=${data}`;
}

function getGaleta(){
    const cookie = getCookie(input.value);
    if (cookie == "") {
        resultadP.innerText = "Cookie Invalida";
    }
    else{
        resultadP.innerText = `Clave de la cookie = ${nomInput.value} | Tiene el valor = ${valorInput.value}`;
    }
}