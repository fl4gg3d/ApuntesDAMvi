const h1 = document.getElementById("infoCookie");

function getCookie(cname) {
    let name = cname + "=";
    let Cookie = document.cookie;
    let ca = Cookie.split(';');
    for(let i = 0; i <ca.length; i++) {
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
if(getCookie("usuari") != ""){
    h1.innerText = "usuari: "+ getCookie("usuari");
} else{
    h1.innerText = "usuari no registrat";
}
function limpiarC(){
    const data = new Date();
    data.setDate(data.getDate() - 20);
    if(getCookie("usuari") != ""){
        document.cookie = `usuari=; expires=${data}`;
    }
}