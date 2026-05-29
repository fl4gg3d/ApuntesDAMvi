const stockMin= document.getElementById("stockMin").value;
const stockMax= document.getElementById("stockMax").value;
const ul = document.getElementById("llistat");
const p = document.getElementById("resultat");

function buscar(){
    stockMinint = parseInt(stockMin);
    stockMaxint = parseInt(stockMax);

    $.ajax({
        method: "GET",
        url: "buscarStock.php",
        data: {"stockMin": stockMinint, "stockMax": stockMaxint},
        dataType: "json",
        success: function (data) {
            console.log(data);
            if(data.estado == "dead"){
                p.innerText = "No existeixen productes";
            }else{
                ul.appendChild(data);
            }
        },
        error: function (jqXHR, textStatus, error) {
            console.log(jqXHR)
        }
    })
};