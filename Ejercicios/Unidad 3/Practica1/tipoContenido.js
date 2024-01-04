function tipoContenido(extension) {
    switch(extension) {
        case '.html':
            return 'text/html';
        case '.css':
            return 'text/css';
        case '.jpg':
        case '.jpeg':
        case '.svg':
            return 'image/jpg';
    }
}

module.exports = tipoContenido;