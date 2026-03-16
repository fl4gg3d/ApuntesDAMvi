const input = document.getElementById("texto");
const tbody = document.getElementById("tbody");
function ex3(){

    let tr = document.createElement("tr");
    let tdPalabra = document.createElement("td");
    let tdNumero = document.createElement("td");


    tdPalabra.innerText = input.value;
    tdNumero.innerText = input.value.length;
    tr.appendChild(tdPalabra);
    tr.appendChild(tdNumero);
    tbody.appendChild(tr);



    if(input.value.charAt(input.value.length - 1) == "a" || input.value.charAt(input.value.length - 1) == "e" || input.value.charAt(input.value.length - 1) == "i" || input.value.charAt(input.value.length - 1) == "o" || input.value.charAt(input.value.length - 1) == "u"){
        tr.style.backgroundColor = "transparent";
    }else{
        tr.style.backgroundColor = "blue";
    }

}