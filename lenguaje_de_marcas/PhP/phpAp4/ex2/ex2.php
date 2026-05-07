<?php
$valorU = "";
$caracter = chr(rand(65,133));
for ($i=0; $i < 10; $i++) {
    $valorU .= $caracter;
}

setcookie("usuari",$valorU,time()+3600);