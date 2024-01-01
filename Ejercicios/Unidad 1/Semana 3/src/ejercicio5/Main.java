package ejercicio5;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws IOException {
        String location = "C:\\Users\\jjase\\Desktop\\hola_mundo.txt";
        PrintWriter pW = new PrintWriter(new BufferedWriter(new FileWriter(location, false)));
        Scanner scanner = new Scanner(System.in);
        int seconds;

        System.out.print("Indica cada cuántos segundos quieres que se guarde el saludo: ");
        while (!scanner.hasNextInt()) {
            scanner.nextLine();
        }
        seconds = scanner.nextInt();

        Thread thread = new Thread(() -> {
            try{
                while(!Thread.currentThread().isInterrupted()) {
                    pW.println("¡Hola, mundo!");
                    TimeUnit.SECONDS.sleep(seconds);
                }
            } catch (InterruptedException ie) {
                System.out.println("Interrumpiendo hilo.");
            }
        });
        thread.start();

        System.out.println("Pulsa enter para interrumpir el hilo:");
        scanner.nextLine();
        scanner.nextLine();
        thread.interrupt();

        try {
            thread.join();
            System.out.println("Hilo interrumpido.");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        pW.close();
        System.out.println("¡Adiós!");
    }
}
