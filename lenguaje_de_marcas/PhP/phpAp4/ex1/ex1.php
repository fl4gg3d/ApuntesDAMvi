<?php
include "ex1_pt2.php";

function volumCercle($diametro): float|int
{
    $radio = $diametro / 2;
    $radio3C = pow($radio, 3);
    return $radio3C * ((4/3) * M_PI);
}
function volumenCilindre($radio) {
    $radio3 = pow($radio, 3);
    $areaB = M_PI * $radio3;
    return $areaB * $radio3;
}
$numeroC = generaNumeros();
$numeroCI = generaNumeros();
echo "El volumen del cercle de {$numeroC}cm es: " . volumCercle($numeroC) . "<br>";
echo "El volumen del cilindre de {$numeroCI}cm es: " . volumenCilindre($numeroCI) . "<br>";