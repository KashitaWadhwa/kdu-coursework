function codeString(inputString) {
    inputString = inputString.trim();
    inputString = inputString.replace(/a/g, '4');
    inputString = inputString.replace(/e/g, '3');
    inputString = inputString.replace(/i/g, '1');
    inputString = inputString.replace(/o/g, '0');
    inputString = inputString.replace(/s/g, '5');

    return inputString;
}

console.log(codeString("javascript is cool"));
console.log(codeString("programming is fun")); 
console.log(codeString("become a coder")); 
