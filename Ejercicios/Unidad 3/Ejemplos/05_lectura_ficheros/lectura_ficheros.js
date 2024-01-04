const fs = require("fs")

const lectura = function(err, data){
    if(err){
        console.log("Error: " + err);
        return;
    }
    console.log("Datos leídos: " + data);
}

fs.readFile('./prueba.txt', lectura);