<?php
// login.php — Valida les credencials d'un usuari (POST)
header('Content-Type: application/json');
header('Access-Control-Allow-Origin: *');

require 'db.php';

if ($_SERVER['REQUEST_METHOD'] !== 'POST') {
    echo json_encode(['estat' => 'ko', 'missatge' => 'Mètode no permès']);
    exit;
}

$email      = trim($_POST['email']      ?? '');
$contrasenya = trim($_POST['contrasenya'] ?? '');

// --- Validacions bàsiques ---
if ($email === '' || $contrasenya === '') {
    echo json_encode(['estat' => 'ko', 'missatge' => 'Tots els camps són obligatoris', 'usuari' => $email]);
    exit;
}

// --- Buscar usuari ---
$stmt = $pdo->prepare('SELECT idUsuari, email, contrasenya FROM usuari WHERE email = ?');
$stmt->execute([$email]);
$usuari = $stmt->fetch(PDO::FETCH_ASSOC);

if (!$usuari) {
    echo json_encode(['estat' => 'ko', 'missatge' => 'L\'usuari no existeix', 'usuari' => $email]);
    exit;
}

// --- Verificar contrasenya ---
if (!password_verify($contrasenya, $usuari['contrasenya'])) {
    echo json_encode(['estat' => 'ko', 'missatge' => 'Contrasenya incorrecta', 'usuari' => $email]);
    exit;
}

echo json_encode(['estat' => 'ok', 'missatge' => 'Login correcte', 'usuari' => $usuari['email']]);
