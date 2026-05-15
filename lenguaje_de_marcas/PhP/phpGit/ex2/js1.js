const input = document.getElementById("nomAnime");
const p = document.getElementById("texto");
function mostrar(){
    p.innerText = "";
    $.ajax({
        method:"POST",
        url:"ex1.php",
        data:{"edat": input.value},
        dataType:"json",
        success:function (data){
            for (const datum of data) {
                p.innerText += "Titol: "+datum.titol+ "\n";
            }
        },
        error: function (jqXHR, textStatus, error){
            console.log(jqXHR);

        }
    });
}
