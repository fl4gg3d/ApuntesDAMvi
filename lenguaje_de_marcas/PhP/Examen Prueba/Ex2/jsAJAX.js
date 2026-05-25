const input = document.getElementById("inputJuego");

function peticion(){
    $.ajax({
        method:"GET",
        url:"ex2.php",
        data:{"nombreJuego":input.value},
        dataType:"json",
        success:function (data){
            for (const datum of data) {
                console.log(datum);
            }
        },
        error: function (jqXHR, textStatus, error){
            console.log(jqXHR);

        }
    });
}