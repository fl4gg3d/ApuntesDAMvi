<?php
session_start();
$numeroRandom = rand(1, 10);
$nombre = $_GET['inputJuego'];
$_SESSION['nombre'] = $nombre;
$_SESSION['nota'] = $numeroRandom;


print_r("El juego ".$nombre . " ha sacada una puntuacion de: ". $numeroRandom);