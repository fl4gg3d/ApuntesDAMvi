<?php
// register.php — Registra un nou usuari (POST)
header('Content-Type: application/json');
header('Access-Control-Allow-Origin: *');

require 'db.php';

// Només acceptem POST
if ($_SERVER['REQUEST_METHOD'] !== 'POST') {
    echo json_encode(['estat' => 'ko', 'missatge' => 'Mètode no permès']);
    exit;
}

$email      = trim($_POST['email']      ?? '');
$contrasenya = trim($_POST['contrasenya'] ?? '');

// --- Validacions ---

// 1. Camps buits
if ($email === '' || $contrasenya === '') {
    echo json_encode(['estat' => 'ko', 'missatge' => 'Tots els camps són obligatoris', 'usuari' => $email]);
    exit;
}

// 2. Ha de ser correu de l'institut
if (!str_ends_with($email, '@ies-sabadell.cat')) {
    echo json_encode(['estat' => 'ko', 'missatge' => 'El correu ha de ser de l\'institut (@ies-sabadell.cat)', 'usuari' => $email]);
    exit;
}

// 3. Format de correu vàlid
if (!filter_var($email, FILTER_VALIDATE_EMAIL)) {
    echo json_encode(['estat' => 'ko', 'missatge' => 'Format de correu no vàlid', 'usuari' => $email]);
    exit;
}

// 4. Comprovar si ja existeix
$stmt = $pdo->prepare('SELECT idUsuari FROM usuari WHERE email = ?');
$stmt->execute([$email]);
if ($stmt->fetch()) {
    echo json_encode(['estat' => 'ko', 'missatge' => 'Aquest correu ja està registrat', 'usuari' => $email]);
    exit;
}

// --- Inserció ---
$hash = password_hash($contrasenya, PASSWORD_DEFAULT);
$stmt = $pdo->prepare('INSERT INTO usuari (email, contrasenya) VALUES (?, ?)');
$stmt->execute([$email, $hash]);

echo json_encode(['estat' => 'ok', 'missatge' => 'Usuari registrat correctament', 'usuari' => $email]);
