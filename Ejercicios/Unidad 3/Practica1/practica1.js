// Importa los módulos necesarios
const http = require('http');
const fs = require('fs');
const path = require('path');
const contenido = require('./tipoContenido.js')
const url_module = require('url');

// Variable que almacena la función para obtener el listener de petición y respuesta
const requestListener = function (request, response){    
    // Variable que almacena la url de la petición dividida en partes lógicas
    var url_partes = url_module.parse(request.url, true);
    var url_path = url_partes.pathname;
    var busqueda = url_partes.query;
        
    // Si solo se indica 'localhost', devuelve index.html en inglés o español
    if (url_path == '/') {
        // Si la url contiene un query string lang=en devuelve la página en inglés
        if (busqueda['lang'] == 'en'){
            url_path = './enindex.html'
        } 
        // De lo contrario, la devuelve en español
        else {  
            url_path = './index.html';
        }
    } 
    // Si se busca el archivo "styles.css" se redirecciona a "estilos.css"
    else if (url_path == '/styles.css') {
        response.writeHead(301, {'Location' : '/estilos.css'});
        response.end();
    }
    // De lo contrario, devuelve el directorio actual y el recurso pedido
    else {
        // Si la url contiene un query string lang=en devuelve la página en inglés
        if (busqueda['lang'] == 'en'){
            // Separa la url para quitarle el /
            var recursos = url_path.split('/');

            // Construye la url con ./en delante del nombre del recurso
            url_path = path.join(__dirname, `./en${recursos[1]}`);
        } 
        // De lo contrario, la devuelve en español
        else {  
            url_path = path.join(__dirname, url_path);
        }
    }
    
    // Lee el archivo indicado en la URL construida
    fs.readFile(url_path, (err, data) => {
        // Si se produce un error, devuelve el código 400
        if(err){
            response.writeHead(404, {'Content-Type' : 'text/plain'});
            response.end('404 Not Found');
        } 
        // Si la petición es correcta, devuelve el código 200 y el contenido del recurso
        else {
            response.writeHead(200, {
                /* Se utiliza un módulo propio que devuelve el tipo de contenido según
                   la extensión del fichero de la URL*/  
                'Content-Type' : contenido(path.extname(url_path))
            });
            response.end(data);
        }
    });
}

// Variable que inicializa el servidor
const server = http.createServer(requestListener)

// Se indica que el servidor está a la escucha en el puerto indicado
const puerto = 80;
server.listen(puerto);

