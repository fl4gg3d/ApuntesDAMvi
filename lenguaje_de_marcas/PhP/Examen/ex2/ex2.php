<?php
session_start();

$numR = rand(1, 10);
$numRUser = $_POST["numeroAle"];
$nombreUser = $_POST["nombreUser"];

$_SESSION["nombreUser"] = $nombreUser;
if($numR == $numRUser) {
    $_SESSION["mensaje"] = "L'usuari ha encertat";
}else{
    $_SESSION["mensaje"] = "L'usuari no ha encertat";
}

