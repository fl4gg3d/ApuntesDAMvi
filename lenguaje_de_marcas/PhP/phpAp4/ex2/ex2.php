<?php
$valorU = "";
for ($i=0; $i < 10; $i++) {
    $valorU .=chr(rand(65, 133));
}
setcookie("usuari",$valorU,time()+3600);