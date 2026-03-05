const p = document.getElementById("pepe")
function random(min, max){
    min = Math.ceil(min);
    max = Math.floor(max);
    return Math.floor(Math.random() * (max - min) + min);
}
function boton1 (){
    const arrayNum = [];

    for (let i = 0; i <= 4; i++){
        arrayNum.push(random(0, 10));
    }
    let booleana = true;
    for (let i = 0; i < arrayNum.length- 1; i++) {
        if(arrayNum[i] > arrayNum[i-1]){
            booleana = false;
        }
        p.innerText = arrayNum +" "+ booleana;
    }
}


