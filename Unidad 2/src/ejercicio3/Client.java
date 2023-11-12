package ejercicio3;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args)  {
        try (Socket client = new Socket("localhost",1234)) {
            System.out.println("-----CLIENTE-----");
            InputStream entrada = client.getInputStream();
            OutputStream salida = client.getOutputStream();
            DataInputStream flujoEntrada = new DataInputStream(entrada);
            DataOutputStream flujoSalida = new DataOutputStream(salida);

            Scanner scanner = new Scanner(System.in);
            String mensajeRecibido, mensajeAEnviar;
            mensajeAEnviar = "Hola servidor";
            flujoSalida.writeUTF(mensajeAEnviar);
            do {
                mensajeRecibido = flujoEntrada.readUTF();
                if(mensajeRecibido.equalsIgnoreCase("fin")){
                    flujoSalida.writeUTF("fin");
                } else {
                    System.out.println("El mensaje recibido es " + mensajeRecibido);
                    System.out.print("Escribe la línea a enviar: ");
                    mensajeAEnviar = scanner.nextLine();
                    flujoSalida.writeUTF(mensajeAEnviar);
                    System.out.println("Envío información al servidor...");
                }
            } while (!mensajeRecibido.equalsIgnoreCase("fin") && !mensajeAEnviar.equalsIgnoreCase("fin"));
            System.out.println("Finalizando cliente.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
