const http = require("http");

const requestListener = function (request, response){
    console.log("Se ha producido una petición")
    console.log("URL: " + request.url)
    console.log("Método: " + request.method)
    console.log("Algunos campos de la cabecera:")
    console.log("Host: " + request.headers['host'])
    console.log("User-Agent: " + request.headers['user-agent'])
    console.log("Accept-Language: " + request.headers['accept-language'])
    response.setHeader("Content-Type", "text/html")
    response.writeHead(200)
    response.write("<h1>Hola, mundo!</h1>")
    response.end()
};

const server = http.createServer(requestListener);

server.listen(80);