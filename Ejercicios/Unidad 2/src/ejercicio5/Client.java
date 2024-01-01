package ejercicio5;

import java.io.IOException;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        System.out.println("-----CLIENTE-----");
        try (Socket socket = new Socket("localhost", 1234)) {
            InputManager input = new InputManager(socket);
            Thread inputThread = new Thread(input);
            inputThread.start();
            OutputManager output = new OutputManager(socket);
            Thread outputThread = new Thread(output);
            outputThread.start();

            try {
                inputThread.join();
                outputThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Finalizando cliente.");
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
