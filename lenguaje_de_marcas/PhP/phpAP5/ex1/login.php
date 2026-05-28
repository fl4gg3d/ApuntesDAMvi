<?php

header('Content-Type: application/json');

$host = "localhost";
$dbname = "anime_db";  // Cambia esto
$user = "root";               // Cambia esto
$pass = "";                   // Cambia esto

$pdo = new PDO("mysql:host=$host;dbname=$dbname;charset=utf8", $user, $pass);

if ($_SERVER["REQUEST_METHOD"] === "POST") {
    $email = $_POST["emailRe"] ?? "";
    $password = $_POST["passwordRe"] ?? "";

    // Comprovar si l'usuari existeix
    $stmt = $pdo->prepare("SELECT * FROM usuaris WHERE email = ?");
    $stmt->execute([$email]);
    $usuari = $stmt->fetch();

    if (!$usuari) {
        echo json_encode([
            "estat" => "KO",
            "error" => "Usuari no existeix",
            "usuari_app" => $email
        ]);
        exit;
    }

    // Comprovar contrasenya
    if ($usuari["contrasenya"] !== $password) {
        echo json_encode([
            "estat" => "KO",
            "error" => "Credencial incorrecte",
            "usuari_app" => $email
        ]);
        exit;
    }

    // Login correcte
    echo json_encode([
        "estat" => "OK",
        "error" => "",
        "usuari_app" => $email
    ]);
}
