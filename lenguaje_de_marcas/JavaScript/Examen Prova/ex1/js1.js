const nombreCarro = document.getElementById("nomCarro");
const cancionCarro = document.getElementById("cancionCarro");
const tematicaCarro = document.getElementById("tematicaCarro");
const numeroCarro = document.getElementById("numeroCarro");
const p = document.getElementById("textoProyectar");
const arrayCarro = [];
function crear(){
    let carroza =
        {
            nombre: nombreCarro.value,
            cancion: cancionCarro.value,
            tematica: tematicaCarro.value,
            numero: numeroCarro.value,

            nomMusica: function (){
                return this.nombre +" "+ this.cancion;
            }
        };
    arrayCarro.push(carroza);
    console.log(arrayCarro);
}
function proyectar(){
    resultado = "";
    for (const arrayCarroElement of arrayCarro) {
        resultado += `${arrayCarroElement.nombre}, ${arrayCarroElement.cancion}, ${arrayCarroElement.tematica}, ${arrayCarroElement.numero} \n`;
    }
    p.innerText = resultado;
}
