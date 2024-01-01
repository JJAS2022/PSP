package ejercicio4;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try (Socket client = new Socket("localhost",1234)) {
            System.out.println("-----CLIENTE-----");
            OutputStream salida = client.getOutputStream();
            DataOutputStream flujoSalida = new DataOutputStream(salida);

            Scanner scanner = new Scanner(System.in);
            String mensaje;
            do {
                System.out.print("Escribe la línea a enviar: ");
                mensaje = scanner.nextLine();
                flujoSalida.writeUTF(mensaje);
            } while (!mensaje.equalsIgnoreCase("fin"));
            System.out.println("Finalizando cliente.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
