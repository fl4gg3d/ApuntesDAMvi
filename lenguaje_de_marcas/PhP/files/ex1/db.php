<?php
// db.php — Connexió compartida a la base de dades
// Inclou aquest fitxer des de getUsers.php, login.php i register.php

$host     = 'localhost';
$dbname   = 'el_teu_schema';   // <-- canvia pel nom del teu schema
$username = 'root';             // <-- canvia si cal
$password = '';                 // <-- canvia si cal

try {
    $pdo = new PDO(
        "mysql:host=$host;dbname=$dbname;charset=utf8",
        $username,
        $password,
        [PDO::ATTR_ERRMODE => PDO::ERRMODE_EXCEPTION]
    );
} catch (PDOException $e) {
    http_response_code(500);
    echo json_encode(['estat' => 'ko', 'missatge' => 'Error de connexió: ' . $e->getMessage()]);
    exit;
}
