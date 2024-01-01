package ejercicio3;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args)  {
        try (ServerSocket server = new ServerSocket(1234)) {
            System.out.println("-----SERVIDOR-----");
            System.out.println("Esperando la conexión del cliente...");
            Socket conexionCliente = server.accept();
            System.out.println("Cliente conectado.");

            InputStream entrada = conexionCliente.getInputStream();
            OutputStream salida = conexionCliente.getOutputStream();
            DataInputStream flujoEntrada = new DataInputStream(entrada);
            DataOutputStream flujoSalida = new DataOutputStream(salida);

            Scanner scanner = new Scanner(System.in);
            String mensajeRecibido, mensajeAEnviar;
            do {
                mensajeRecibido = flujoEntrada.readUTF();
                if(mensajeRecibido.equalsIgnoreCase("fin")){
                    flujoSalida.writeUTF("fin");
                } else {
                    System.out.println("El mensaje recibido es " + mensajeRecibido);
                    System.out.print("Escribe la línea a enviar: ");
                    mensajeAEnviar = scanner.nextLine();
                    flujoSalida.writeUTF(mensajeAEnviar);
                    System.out.println("Envío información al cliente...");
                }
            } while (!mensajeRecibido.equalsIgnoreCase("fin"));

            System.out.println("Finalizando servidor.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
