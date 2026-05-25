<?php
session_start();
if(isset($_SESSION['nombre']) && isset($_SESSION['nota'])){
    echo "Sesion 1: ". $_SESSION['nombre'];
    echo "<br>";
    echo "Sesion 2: ". $_SESSION['nota'];
}