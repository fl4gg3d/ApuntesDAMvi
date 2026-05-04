<?php

$random = rand(1,10);

echo "<h1>Ex1"."</h1>";
echo "tabla del: ".$random;
echo "<br/>";
for($i = 0; $i < 10; $i++){
    $multiplicacio = $random * $i;
    echo $random." x ".$i." = ".$multiplicacio."<br/>";
};

echo "<br/>";


$randomT = rand(1,20);
echo "<h1>Ex2"."</h1>";
for($i = $randomT; $i >= 1; $i--){
    for($j = 1; $j <= $i; $j++){
        echo "X";
    }
    echo "<br/>";
};
