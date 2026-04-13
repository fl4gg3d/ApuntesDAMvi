const p = document.getElementById("resultat");
const nom = document.getElementById("inputNom");
const valor = document.getElementById("inputValue");

function afegir(){
    localStorage.setItem(nom.value, valor.value);
    p.innerText = "cookie afegida";
}
function mostrar(){
    p.innerText = localStorage.getItem(nom.value);
}
function eliminar(){
    localStorage.removeItem(nom.value);
    p.innerText = "cookie eliminada";
}