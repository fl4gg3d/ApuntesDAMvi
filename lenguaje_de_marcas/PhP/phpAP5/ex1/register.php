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

    // Validar que el correo sea del domini correcte
    if (!str_ends_with($email, "@ies-sabadell.cat")) {
        echo json_encode([
            "estat" => "KO",
            "error" => "correu incorrecte",
            "usuari_app" => $email
        ]);
        exit;
    }

    // Comprovar si l'usuari ja existeix
    $stmt = $pdo->prepare("SELECT * FROM usuaris WHERE email = ?");
    $stmt->execute([$email]);
    $usuari = $stmt->fetch();

    if ($usuari) {
        echo json_encode([
            "estat" => "KO",
            "error" => "L'usuari existeix",
            "usuari_app" => $email
        ]);
        exit;
    }

    // Registrar el nou usuari
    $stmt = $pdo->prepare("INSERT INTO usuaris (email, contrasenya) VALUES (?, ?)");
    $stmt->execute([$email, $password]);

    echo json_encode([
        "estat" => "OK",
        "error" => "",
        "usuari_app" => $email
    ]);
}