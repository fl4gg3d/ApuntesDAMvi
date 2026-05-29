<?php
$servername = "localhost";
$username = "root";
$password = "super3";
$dbname = "videojocExamen";

try {
    $videojoc = $_POST["nomVideojoc"];
    $conn = new PDO("mysql:host=$servername;dbname=$dbname", $username, $password);
    try{
        $query =$conn->prepare ("Select puntuació from videojocs where TitolVideojoc = :nomVideojoc");
        $query->bindParam(":nomVideojoc",$videojoc);
        $query->execute();
        $resultat= $query->fetch(PDO::FETCH_ASSOC);

        if($query->rowCount() > 0){
            echo json_encode($resultat);
        }


    } catch (Exception $exception){
        $resposta = [
            "estat"=>"KO",
            "missatge"=>$exception->getMessage()
        ];
        echo json_encode($resposta);
    }
} catch (PDOException $e) {
    echo "Connection failed: " . $e->getMessage();
}


