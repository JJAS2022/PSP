package ejercicio1;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try (Socket client = new Socket("localhost", 1234)) {
            System.out.println("-----CLIENTE-----");

            OutputStream salida = client.getOutputStream();
            DataOutputStream flujoSalida = new DataOutputStream((salida));

            Scanner scanner = new Scanner(System.in);
            String lineaAEnviar;

            do {
                System.out.print("Escribe la línea de texto a enviar: ");
                lineaAEnviar = scanner.nextLine();
                flujoSalida.writeUTF(lineaAEnviar);
                System.out.println("Envío información al servidor...");
            } while (!lineaAEnviar.equalsIgnoreCase("fin"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
