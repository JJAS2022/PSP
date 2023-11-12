package ejemplo1;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args)  {
        try {
            System.out.println("SERVIDOR: Creado...");
            ServerSocket server = new ServerSocket(1234);
            System.out.println("SERVIDOR: Esperando conexión del cliente...");

            Socket conexionCliente = server.accept();
            System.out.println("SERVIDOR: Cliente conectado.");

            InputStream entrada = conexionCliente.getInputStream();
            OutputStream salida = conexionCliente.getOutputStream();

            DataInputStream flujoEntrada = new DataInputStream(entrada);
            DataOutputStream flujoSalida = new DataOutputStream(salida);

            System.out.println("SERVIDOR: Envío información al cliente...");
            flujoSalida.writeUTF("¡Hola, soy el servidor!");
            System.out.println("SERVIDOR: Y espero una respuesta....");
            String lineaRecibida = flujoEntrada.readUTF();
            System.out.println("SERVIDOR: El mensaje recibido es: " + lineaRecibida);
            conexionCliente.close();
            server.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
