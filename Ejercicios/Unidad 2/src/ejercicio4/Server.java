package ejercicio4;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(1234)) {
            System.out.println("-----SERVIDOR-----");
            System.out.println("Esperando la conexión del cliente...");

            while (true) {
                Socket conexionCliente = server.accept();
                System.out.println("Cliente conectado: " + conexionCliente.getInetAddress().getHostAddress());
                GestorConexion gestor = new GestorConexion(conexionCliente);
                Thread thread = new Thread(gestor);
                thread.start();
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class GestorConexion implements Runnable {
    Socket socket;

    public GestorConexion(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            InputStream entrada = socket.getInputStream();
            OutputStream salida = socket.getOutputStream();
            DataInputStream flujoEntrada = new DataInputStream(entrada);
            DataOutputStream flujoSalida = new DataOutputStream(salida);

            Scanner scanner = new Scanner(System.in);
            String mensaje;
            do {
                mensaje = flujoEntrada.readUTF();
                System.out.println("El mensaje recibido es " + mensaje);
            } while (!mensaje.equalsIgnoreCase("fin"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}