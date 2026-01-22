/*Ex3*/

function suma(num1, num2) {
    return num1 + num2;
}
function resta (num1, num2) {
    return num1 - num2;
}
function multi (num1, num2) {
    return num1 * num2;
}

let num3prompt = Number(prompt("Indica el numero"));
let num4prompt = Number(prompt("Indica el numero 2"));

if (num3prompt == num4prompt) {
    console.log(suma(num3prompt, num4prompt) * 2);
} else if (num3prompt < num4prompt) {
    console.log(suma(num3prompt, num4prompt));
} else {
    console.log(resta(num3prompt, num4prompt));
}
