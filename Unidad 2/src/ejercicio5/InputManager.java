package ejercicio5;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class InputManager implements Runnable{
    Socket socket;

    public InputManager(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            InputStream entrada = socket.getInputStream();
            DataInputStream flujoEntrada = new DataInputStream(entrada);

            String mensaje;
            do {
                mensaje = flujoEntrada.readUTF();
                System.out.println("Mensaje recibido: " + mensaje);
            } while (!mensaje.equalsIgnoreCase("fin"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
