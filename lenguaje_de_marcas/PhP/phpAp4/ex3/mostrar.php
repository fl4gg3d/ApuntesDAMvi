<?php
session_start();

if (isset($_SESSION["visites"])) {
    echo "<h1>Nombre de visites: " . $_SESSION["visites"] . "</h1>";
} else {
    echo "<h1>La pàgina encara no s'ha visitat.</h1>";
}

echo '<br><a href="visites.php">Visitar pàgina</a>';