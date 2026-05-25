<?php
$servername = "localhost";
$username = "root";
$password = "";
$dbname = "videojocexamen";
$nomJoc = $_GET["nombreJuego"];

try {
    $conn = new PDO("mysql:host=$servername;dbname=$dbname", $username, $password);
    try {
        $query = $conn->prepare("select * from videojocs where TitolVideojoc like :nomJoc ");
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