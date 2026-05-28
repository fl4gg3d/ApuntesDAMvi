<?php
// deletePersonatge.php — Elimina un personatge de l'array JSON i decrementa numpersonatges (POST)
header('Content-Type: application/json');
header('Access-Control-Allow-Origin: *');

require 'db.php';

if ($_SERVER['REQUEST_METHOD'] !== 'POST') {
    echo json_encode(['estat' => 'ko', 'missatge' => 'Mètode no permès']);
    exit;
}

$idAnime  = trim($_POST['idAnime']    ?? '');
$nomPerso = trim($_POST['personatge'] ?? '');

// --- Validar camps buits ---
if ($idAnime === '' || $nomPerso === '') {
    echo json_encode(['estat' => 'ko', 'missatge' => 'Els camps idAnime i personatge són obligatoris']);
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
    echo json_encode(['estat' => 'ko', 'missatge' => 'No hi ha personatges per eliminar']);
    exit;
}

// --- Buscar l'índex del personatge ---
$indexTrobat = -1;
foreach ($personatges as $i => $p) {
    if ($p['nom'] === $nomPerso) {
        $indexTrobat = $i;
        break;
    }
}

if ($indexTrobat === -1) {
    echo json_encode(['estat' => 'ko', 'missatge' => "No existeix el personatge '$nomPerso' en aquest anime"]);
    exit;
}

// --- Eliminar amb array_splice (elimina 1 element a la posició trobada) ---
array_splice($personatges, $indexTrobat, 1);

// --- Si queda buit, guardar null; si no, l'array actualitzat ---
$nouJSON     = count($personatges) > 0 ? json_encode($personatges) : null;
$nouNumPerso = max(0, $anime['numpersonatges'] - 1);

$stmtUpdate = $pdo->prepare(
    'UPDATE animes SET personatges = ?, numpersonatges = ? WHERE idAnime = ?'
);
$stmtUpdate->execute([$nouJSON, $nouNumPerso, $idAnime]);

echo json_encode([
    'estat'          => 'ok',
    'missatge'       => "Personatge '$nomPerso' eliminat correctament",
    'personatges'    => $personatges,   // array buit [] si no en queden
    'numpersonatges' => $nouNumPerso
]);
