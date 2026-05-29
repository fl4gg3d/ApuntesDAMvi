<?php
session_start();
if (!isset($_SESSION["nombreUser"]) and !isset($_SESSION["mensaje"])) {
    echo "no existe la sesion";
}
else{
    echo $_SESSION["nombreUser"]."<br>";
    echo $_SESSION["mensaje"]."<br>";
}