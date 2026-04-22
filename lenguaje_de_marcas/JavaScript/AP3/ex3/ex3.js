const formulari = document.getElementById('registreForm');
const missatge = document.getElementById('missatge');

function mostrarMissatge(text, tipus) {
    missatge.innerText = text;
    missatge.classList.remove('error', 'success');
    missatge.classList.add(tipus);
}

formulari.addEventListener('submit', function(e) {
    e.preventDefault();

    const usuari = document.getElementById('usuari').value.trim();
    const email = document.getElementById('email').value.trim();
    const password = document.getElementById('password').value;
    const repetirPassword = document.getElementById('repetirPassword').value;

    if (!usuari || !email || !password || !repetirPassword) {
        mostrarMissatge('Tots els camps han d’estar omplerts', 'error');
        return;
    }

    else if (!email.endsWith('@ies-sabadell.cat')) {
        mostrarMissatge('El correu ha de ser de l’institut', 'error');
        return;
    }

    else if (password.length < 8) {
        mostrarMissatge('La contrasenya ha de contenir almenys 8 caràcters', 'error');
        return;
    }

    mostrarMissatge('Formulari enviat correctament', 'success');
});