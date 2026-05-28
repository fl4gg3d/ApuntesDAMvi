<?php
// getUsers.php — Retorna tots els usuaris (GET)
header('Content-Type: application/json');
header('Access-Control-Allow-Origin: *');

require 'db.php';

$stmt = $pdo->query('SELECT idUsuari, email FROM usuari');
$usuaris = $stmt->fetchAll(PDO::FETCH_ASSOC);

// Retorna l'array d'usuaris (sense contrasenyes!)
echo json_encode($usuaris);
