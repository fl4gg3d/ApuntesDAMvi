const num = document.getElementById("number");
const p = document.getElementById("tempText");

function celsius(){
    const temp = num.value;
    p.innerText += (temp - 32) * 5 / 9 + "ºC";
}
function fahrenheit(){
    const temp = num.value;
    p.innerText += (temp * 9) / 5 + 32 + "ºF";
}