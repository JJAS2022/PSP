package ejercicio2;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try (Socket client = new Socket("localhost", 1234)) {
            System.out.println("-----CLIENTE-----");

            InputStream entrada = client.getInputStream();
            OutputStream salida = client.getOutputStream();
            DataInputStream flujoEntrada = new DataInputStream(entrada);
            DataOutputStream flujoSalida = new DataOutputStream(salida);

            Scanner scanner = new Scanner(System.in);
            int number, sum;
            do {
                System.out.print("Escribe un número positivo: ");
                number = scanner.nextInt();
                flujoSalida.writeInt(number);
            } while (number > 0);

            sum = flujoEntrada.readInt();
            System.out.println("La suma de los número es " + sum);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
