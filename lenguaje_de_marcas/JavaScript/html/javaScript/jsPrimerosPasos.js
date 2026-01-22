
const institut = "IES SABADELL";
let numero1 = 10;
let numero2 = 20;
let resultatSuma = numero1 + numero2;
alert(resultatSuma);
let resultatResta = numero1 - numero2;
console.log(resultatResta);
let num1 = Number(prompt("Indica el numero"));
let num2 = Number(prompt("Indica el numero 2"));

let resultadoPrompt = num1 + num2;
console.log(resultadoPrompt);

/*Ex1*/
const random = getRandomInt(10);
let numPrompt = Number(prompt("Acierta el numero"));

if (numPrompt == random) {
    console.log("Trobat");
} else {
    console.log("Has fallat")
}
function getRandomInt(max) {
    return Math.floor(Math.random() * max);
}

/*ex2*/
let num1Prompt = Number(prompt("Indica el numero"));
let num2Prompt = Number(prompt("Indica el numero 2"));

if (num1Prompt == num2Prompt) {
    console.log(num1Prompt + num2Prompt * 2);
} else {
    console.log(num1Prompt + num2Prompt);
}

