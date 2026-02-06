const father = document.getElementById('father2');
const inputText = document.getElementById('textoAñadir')
function js3(){
    const li = document.createElement("li");
    li.innerText = inputText.value;
    father.prepend(li);
}
function p2(){
    const li = document.createElement("li");
    li.innerText = inputText.value;
    father.appendChild(li);
}
function remove(){
    father.removeChild(father.firstElementChild);
}
function removeUp(){
    father.removeChild(father.lastElementChild);
}