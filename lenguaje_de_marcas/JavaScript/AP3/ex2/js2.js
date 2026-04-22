let num = document.getElementById("numCuentaAtras");
let tiempo = 10;
let intervalo = null;

// --- Cookies ---
function guardarCookie(valor) {
    document.cookie = "tiempo=" + valor + ";path=/";
}

function leerCookie() {
    let partes = document.cookie.split("=");
    return partes[1] ? parseInt(partes[1]) : null;
}

// --- Cargar cookie si existe ---
let guardado = leerCookie();
if (guardado !== null) {
    tiempo = guardado;
}
num.textContent = tiempo;

// --- Función del contador ---
function empezarCuenta() {
    clearInterval(intervalo);
    intervalo = setInterval(() => {
        tiempo--;
        num.textContent = tiempo;
        guardarCookie(tiempo);

        if (tiempo <= 0) {
            clearInterval(intervalo);
        }
    }, 1000);
}

// --- Botón comenzar ---
function comenzar() {
    tiempo = 10;
    num.textContent = tiempo;
    guardarCookie(tiempo);
    empezarCuenta();
}

// --- Botón pausar ---
function pausar() {
    clearInterval(intervalo);
}

// --- Botón despausar ---
function despausar() {
    empezarCuenta();
}
