package ejercicio5;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try(ServerSocket server = new ServerSocket(1234)) {
            System.out.println("-----SERVIDOR-----");
            System.out.println("Esperando conexión con cliente...");
            Socket client = server.accept();
            System.out.println("¡Cliente conectado!");

            InputManager input = new InputManager(client);
            Thread inputThread = new Thread(input);
            inputThread.start();
            OutputManager output = new OutputManager(client);
            Thread outputThread = new Thread(output);
            outputThread.start();

            try {
                inputThread.join();
                outputThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Finalizado servidor.");
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
