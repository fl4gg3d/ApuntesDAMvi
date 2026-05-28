<?php
// addPersonatge.php — Afegeix un personatge a l'array JSON de la BD (POST)
header('Content-Type: application/json');
header('Access-Control-Allow-Origin: *');

require 'db.php';

if ($_SERVER['REQUEST_METHOD'] !== 'POST') {
    echo json_encode(['estat' => 'ko', 'missatge' => 'Mètode no permès']);
    exit;
}

$idAnime    = trim($_POST['idAnime']     ?? '');
$nomPerso   = trim($_POST['personatge']  ?? '');
$ordre      = trim($_POST['ordre']       ?? '');

// --- Validar que els camps no siguin buits ---
if ($idAnime === '' || $nomPerso === '' || $ordre === '') {
    echo json_encode(['estat' => 'ko', 'missatge' => 'Tots els camps són obligatoris']);
    exit;
}

if (!is_numeric($ordre)) {
    echo json_encode(['estat' => 'ko', 'missatge' => 'L\'ordre ha de ser un número']);
    exit;
}

// --- Comprovar que l'anime existeix ---
$stmt = $pdo->prepare('SELECT idAnime, personatges, numpersonatges FROM animes WHERE idAnime = ?');
$stmt->execute([$idAnime]);
$anime = $stmt->fetch(PDO::FETCH_ASSOC);

if (!$anime) {
    echo json_encode(['estat' => 'ko', 'missatge' => "No existeix cap anime amb id $idAnime"]);
    exit;
}

// --- Descodificar l'array actual (pot ser null o buit) ---
// json_decode amb true per obtenir array associatiu
$personatges = json_decode($anime['personatges'], true);

// Si és null o no és un array, inicialitzem com a array buit
if (!is_array($personatges)) {
    $personatges = [];
}

// --- Afegir el nou personatge ---
$personatges[] = [
    'nom'   => $nomPerso,
    'ordre' => (int)$ordre
];

$nouJSON      = json_encode($personatges);
$nouNumPerso  = $anime['numpersonatges'] + 1;

$stmtUpdate = $pdo->prepare(
    'UPDATE animes SET personatges = ?, numpersonatges = ? WHERE idAnime = ?'
);
$stmtUpdate->execute([$nouJSON, $nouNumPerso, $idAnime]);

echo json_encode([
    'estat'         => 'ok',
    'missatge'      => "Personatge '$nomPerso' afegit correctament",
    'personatges'   => $personatges,
    'numpersonatges'=> $nouNumPerso
]);
