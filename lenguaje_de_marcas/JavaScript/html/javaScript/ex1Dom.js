const p = document.getElementById('resultado');
function contar() {
    let contador = 10;
    let missatge = "";
    while (contador >= 1){
        missatge += contador+" ";
        contador--;
    }
        p.innerText = missatge;
    }
