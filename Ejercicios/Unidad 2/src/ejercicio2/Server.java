package ejercicio2;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(1234)) {
            System.out.println("-----SERVIDOR-----");
            System.out.println("Esperando conexión del cliente....");
            Socket conexionCliente = server.accept();
            System.out.println("¡Cliente conectado!");

            InputStream entrada = conexionCliente.getInputStream();
            OutputStream salida = conexionCliente.getOutputStream();
            DataInputStream flujoEntrada = new DataInputStream(entrada);
            DataOutputStream flujoSalida = new DataOutputStream(salida);

            int number, sum = 0;
            do{
                number = flujoEntrada.readInt();
                sum += number;
            } while (number > 0);

            flujoSalida.writeInt(sum);
            System.out.println("Finalizando servidor.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
