const h = document.getElementById("cuenta");
let interval;
function atras(){
    clearInterval(interval);
    h.innerText = "10";
    interval = setInterval(()=>{
        h.innerText=String(Number(h.innerText)-1);
        if(h.innerText === "0"){
            clearInterval(interval);
        }
    }, 1000)
}