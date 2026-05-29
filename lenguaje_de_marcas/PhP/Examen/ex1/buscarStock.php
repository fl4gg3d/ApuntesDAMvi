<?php
$servername = "localhost";
$username = "root";
$password = "super3";
$dbname = "productesexamen";
$stockMin = $_GET["stockMin"];
$stockMax = $_GET["stockMax"];
try {
    $conn = new PDO("mysql:host=$servername;dbname=$dbname", $username, $password);
    try {
        $query = $conn->prepare("Select nomProducte from productes where stock > :stockMin and stock < :stockMax;");
        $query->bindParam(":stockMin", $stockMin);
        $query->bindParam(":stockMax", $stockMax);
        $query->execute();
        $result = $query->fetchAll(PDO::FETCH_ASSOC);
        if($query->rowCount() == 0){
            echo json_encode(["estado"=>"dead"]);
        }else{
            echo json_encode($result);
        }
    } catch (PDOException $e) {
        echo "Error: " . $e->getMessage();
    }
} catch (PDOException $e) {
    echo "Connection failed: " . $e->getMessage();
}