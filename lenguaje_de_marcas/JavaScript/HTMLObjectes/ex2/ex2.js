const p = document.getElementById("ex2P");
let vehicle =
    {

        marca:"Opel",
        model:"Corsa",
        any:"2001",
        ecológic: false

    };
function boto(){
    msg = "";
    for (const vehicleElement in vehicle) {
        msg += vehicleElement + ": "+vehicle[vehicleElement]+", ";
    }
    p.innerText = msg;
}