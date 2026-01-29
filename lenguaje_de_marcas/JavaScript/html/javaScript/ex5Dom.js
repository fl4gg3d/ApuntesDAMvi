
function acti5(){
    let multilinea = document.getElementById("multilinea").value;
    let array = multilinea.split("");
    let conta = 0;
    for (let i = 0; i < multilinea.length; i++){
        if(array[i] == "a" || array[i] == "A"){
            conta++;
        }
    }
    let resultado = "";
    resultado += conta;
    document.getElementById("resultadoMulti").innerText = resultado;
}