<?php

header('Content-Type: application/json');

$host = "localhost";
$dbname = "anime_db";  // Cambia esto
$user = "root";              // Cambia esto
$pass = "";                  // Cambia esto

$pdo = new PDO("mysql:host=$host;dbname=$dbname;charset=utf8", $user, $pass);

$stmt = $pdo->query("SELECT * FROM usuaris");
$usuaris = $stmt->fetchAll(PDO::FETCH_ASSOC);

echo json_encode($usuaris);
