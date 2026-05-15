<?php
$array = [];
for ($i = 0; $i < 4; $i++) {
    $array[] = rand(1, 10);
}

echo "L'array és: ";
print_r($array);
echo "<br><br>";

function isInArray($array, $nombre) {
    if (in_array($nombre, $array)) {
        echo "El nombre $nombre es troba a dintre de l'array.<br>";
    } else {
        echo "El nombre $nombre NO es troba a dintre de l'array.<br>";
    }
}

$num1 = $_POST["num1"];
$num2 = $_POST["num2"];
$num3 = $_POST["num3"];
$num4 = $_POST["num4"];

isInArray($array, $num1);
isInArray($array, $num2);
isInArray($array, $num3);
isInArray($array, $num4);