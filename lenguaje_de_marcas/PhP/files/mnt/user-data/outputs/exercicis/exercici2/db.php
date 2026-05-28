<?php
// db.php — Connexió a la base de dades (exercici 2)
$host     = 'localhost';
$dbname   = 'el_teu_schema';   // <-- canvia pel nom del teu schema d'animes
$username = 'root';
$password = '';

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
