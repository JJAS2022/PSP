package ejemplo1;

import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args)  {
        try {
            System.out.println("CLIENTE: Creado...");
            Socket client = new Socket("localhost", 1234);
            System.out.println("CLIENTE: Conectando al servidor...");

            InputStream entrada = client.getInputStream();
            OutputStream salida = client.getOutputStream();

            DataInputStream flujoEntrada = new DataInputStream(entrada);
            DataOutputStream flujoSalida = new DataOutputStream(salida);

            System.out.println("CLIENTE: Espero el saludo del servidor...");
            String lineaRecibida = flujoEntrada.readUTF();
            System.out.println("CLIENTE: El mensaje recibido es: " + lineaRecibida);
            flujoSalida.writeUTF("¡Hola, soy el cliente!");

            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
