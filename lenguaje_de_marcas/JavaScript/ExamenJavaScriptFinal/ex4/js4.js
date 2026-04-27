const angles = document.getElementById("Angles");
const espanol = document.getElementById("Español");
const catalan = document.getElementById("Catalan");

const h1 = document.querySelector("h1");
const p = document.getElementById("p");

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
const data = new Date();
data.setDate(data.getDate()+30);
document.cookie = `idioma = catalan; expires=${data}`;

//PORQUE LO HACE CUANDO HAGO DOBLE CLICK, HOLA?!
function setIdioma(){
    let idioma = getCookie("idioma");
    if(idioma == 'catalan'){
        h1.innerText = "Hola, Bon Dia"
        p.innerText = "Aquesta pagina no serveix de res!"
    }
    else if(idioma == 'angles'){
        h1.innerText = "Hello, Good Mornign"
        p.innerText = "This page is useless!"
    }
    else if(idioma == 'español'){
        h1.innerText = "Hola, Bueno Dias"
        p.innerText = "Esta pagina no sirve de nada!"
    }

    angles.addEventListener("click", function (){
        document.cookie = `idioma = angles; expires=${data}`;
    })
    espanol.addEventListener("click", function () {
        document.cookie = `idioma = español; expires=${data}`;
    })
    catalan.addEventListener("click", function () {
        document.cookie = `idioma = catalan; expires=${data}`;
    })
}