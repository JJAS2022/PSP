package ejercicio5;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class OutputManager implements Runnable{
    Socket socket;

    public OutputManager(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        try {
            OutputStream salida = socket.getOutputStream();
            DataOutputStream flujoSalida = new DataOutputStream(salida);

            String mensaje;
            do {
                System.out.print("Escribe un mensaje: ");
                mensaje = scanner.nextLine();
                flujoSalida.writeUTF(mensaje);
            } while (!mensaje.equalsIgnoreCase("fin"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
