<?php
session_start();

// Comprovar si ja existeix la sessió
if (isset($_SESSION["visites"])) {
    $_SESSION["visites"]++;
} else {
    $_SESSION["visites"] = 1;
}

echo "<p>Visita registrada! Ja has visitat aquesta pàgina <strong>" . $_SESSION["visites"] . "</strong> vegades.</p>";
echo '<a href="mostrar.php">Veure resum</a>';