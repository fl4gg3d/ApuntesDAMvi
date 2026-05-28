<?php
// updatePersonatge.php — Actualitza l'ordre d'un personatge existent (POST)
header('Content-Type: application/json');
header('Access-Control-Allow-Origin: *');

require 'db.php';

if ($_SERVER['REQUEST_METHOD'] !== 'POST') {
    echo json_encode(['estat' => 'ko', 'missatge' => 'Mètode no permès']);
    exit;
}

$idAnime  = trim($_POST['idAnime']    ?? '');
$nomPerso = trim($_POST['personatge'] ?? '');
$nouOrdre = trim($_POST['ordre']      ?? '');

// --- Validar camps buits ---
if ($idAnime === '' || $nomPerso === '' || $nouOrdre === '') {
    echo json_encode(['estat' => 'ko', 'missatge' => 'Tots els camps són obligatoris']);
    exit;
}

if (!is_numeric($nouOrdre)) {
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

// --- Descodificar (true = array associatiu) ---
$personatges = json_decode($anime['personatges'], true);

if (!is_array($personatges) || count($personatges) === 0) {
    echo json_encode(['estat' => 'ko', 'missatge' => 'No hi ha personatges per actualitzar']);
    exit;
}

// --- Buscar el personatge pel nom ---
$trobat = false;
foreach ($personatges as &$p) {
    if ($p['nom'] === $nomPerso) {
        $p['ordre'] = (int)$nouOrdre;
        $trobat = true;
        break;
    }
}
unset($p); // Bona pràctica després de foreach per referència

if (!$trobat) {
    echo json_encode(['estat' => 'ko', 'missatge' => "No existeix el personatge '$nomPerso' en aquest anime"]);
    exit;
}

// --- Guardar els canvis ---
$nouJSON = json_encode($personatges);
$stmtUpdate = $pdo->prepare('UPDATE animes SET personatges = ? WHERE idAnime = ?');
$stmtUpdate->execute([$nouJSON, $idAnime]);

echo json_encode([
    'estat'       => 'ok',
    'missatge'    => "Ordre de '$nomPerso' actualitzat a $nouOrdre",
    'personatges' => $personatges
]);
