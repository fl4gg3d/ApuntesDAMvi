const father = document.getElementById("llistaTasques");
const textoInput = document.getElementById("input");
function buttonAgefir (){
   const li = document.createElement("li");
   li.innerText = textoInput.value+" ";

   const buttonResaltar = document.createElement("button");
   buttonResaltar.innerText="Resaltar";
   li.appendChild(buttonResaltar);

    const buttonEliminar = document.createElement("button");
    buttonEliminar.innerText="Eliminar";
    li.appendChild(buttonEliminar);

    father.appendChild(li);

}