const p = document.getElementById("resultat");
const input = document.getElementById("nom");
const llista = document.getElementById("llista");

function randomNote(min, max){
    min = Math.ceil(min);
    max = Math.floor(max);
    return Math.floor(Math.random() * (max - min) + min);
}

function notas(){

    llista.innerText = "";

    let name = nom.value;
    let total = 0;
    for(i = 0; i < 10; i++){
        let nota = randomNote(0, 15);
        let li = document.createElement("li");
        li.innerText += nota;
        llista.appendChild(li);
        total += nota;
    }

    if(total < 50){
        p.innerText = name + " " + total + ": " + "Suspens";
        p.style.color = "red";
    }
    else if(total == 50 || total <= 69){
        p.innerText = name + " " + total + ": " + "Aprovat";
        p.style.color = "gray";
    }
    else if(total == 70 || total <= 89){
        p.innerText = name + " " + total + ": " + "Notable";
        p.style.color = "blue";
    }
    else if(total >= 90){
        p.innerText = name + " " + total + ": " + "Excellent";
        p.style.color = "green";
    }

}