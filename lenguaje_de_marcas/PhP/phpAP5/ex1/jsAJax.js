
function getUsers(){
    $.ajax({
        method: "GET",
        url: "getUsers.php",
        dataType: "json",
        success: function (data) {
            let p = document.getElementById("resultat");
            p.innerText = "";
            p.style.color = "black"

            data.forEach(function(usuari) {
                p.innerText += usuari.idUsuari + " - " + usuari.email + "\n";
            });
        },
        error: function (jqXHR, textStatus, error) {
            console.log(jqXHR);
        }
    });
}

function login(){
    $.ajax({
        method: "POST",
        url: "login.php",
        data: {
            "emailRe": document.getElementById("correo").value, "passwordRe": document.getElementById("contraseña").value
        },
        dataType: "json",
        success: function (data) {
            let p = document.getElementById("resultat");

            if (data.estat === "OK") {
                p.style.color = "green";
                p.innerText = "Usuari: " + data.usuari_app;
            } else {
                p.style.color = "red";
                p.innerText = data.error + " - " + data.usuari_app;
            }
        },
        error: function (jqXHR, textStatus, error) {
            console.log(jqXHR);
        }
    });
}

function register(){
    $.ajax({
        method: "POST",
        url: "register.php",
        data: {"emailRe": document.getElementById("correo").value, "passwordRe": document.getElementById("contraseña").value},
        dataType: "json",
        success: function (data) {
            let p = document.getElementById("resultat");
            if (data.estat === "OK") {
                // Mostrar el usuario en verde
                p.style.color = "green";
                p.innerText = "Usuari: " + data.usuari_app;
            } else {
                // Mostrar el error + usuario en rojo
                p.style.color = "red";
                p.innerText = data.error + " - " + data.usuari_app;
            }
        },
        error: function (jqXHR, textStatus, error) {
            console.log(jqXHR)
        }
    })
}