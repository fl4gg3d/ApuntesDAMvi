<?php
$servername = "localhost";
$username = "root";
$password = "";
$dbname = "anime_db";


try {
    $edat = $_POST["edat"];
    $conn = new PDO("mysql:host=$servername;dbname=$dbname", $username, $password);
    try {
        $query = $conn->prepare("select titol from animes where edatPublic >= :edat");
        $query->bindParam(":edat", $edat, PDO::PARAM_INT);
        $query->execute();
        $result = $query->fetchAll(PDO::FETCH_ASSOC);
        if($query->rowCount() == 0){
            print_r(json_encode("No s'ha trobat cap anime amb aquesta edat de publicació"));
        }else{
            print_r(json_encode($result));
        }
    } catch (PDOException $e) {
        echo "Error: " . $e->getMessage();
    }
} catch (PDOException $e) {
    echo "Connection failed: " . $e->getMessage();
}
