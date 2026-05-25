<?php
$servername = "localhost";
$username = "root";
$password = "super3";
$dbname = "minadb";

try {
    $dificultad = $_POST["dificultad"];
    $conn = new PDO("mysql:host=$servername;dbname=$dbname", $username, $password);
    try {
        $query = $conn->prepare("select * from configuraciopartida where dificultat = :dificultad");
        $query->bindParam(":dificultad", $dificultad, PDO::PARAM_STR);
        $query->execute();
        $result = $query->fetch(PDO::FETCH_ASSOC);
        if ($query->rowCount() == 0) {
            print_r(json_encode("No se ha encotrando ninguna linea"));
        } else {
            print_r(json_encode($result));
        }
    } catch (PDOException $e) {
        echo "Error: " . $e->getMessage();
    }
} catch (PDOException $e) {
    echo "Connection failed: " . $e->getMessage();
}