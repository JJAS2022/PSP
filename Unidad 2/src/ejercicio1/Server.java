package ejercicio1;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(1234)){
            System.out.println("-----SERVIDOR-----");
            System.out.println("Esperando la conexión de un cliente...");
            Socket conexionCliente = server.accept();
            System.out.println("¡Cliente conectado!");

            InputStream entrada = conexionCliente.getInputStream();
            DataInputStream flujoEntrada = new DataInputStream(entrada);

            String lineaRecibida;
            do {
                lineaRecibida = flujoEntrada.readUTF();
                System.out.println("El mensaje recibido es: " + lineaRecibida);
            } while(!lineaRecibida.equalsIgnoreCase("fin"));

            System.out.println("Finalizando servidor.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
