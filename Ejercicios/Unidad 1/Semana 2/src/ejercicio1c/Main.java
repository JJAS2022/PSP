package ejercicio1c;

import java.util.Random;
import java.util.Scanner;

public class Main {
    static int n1, n2;
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();
    public static void main(String[] args) {
        System.out.print("Introduce n1: ");
        n1 = getInput();
        System.out.print("Introduce n2: ");
        n2 = getInput();

        Thread thread = new Thread(()-> {
            for (int i = n1; i <= n2; i++) {
                System.out.println(i);
                try {
                    Thread.sleep(random.nextInt(1, 1000));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        thread.start();

        System.out.println("El hilo se ha lanzado");
    }

    private static int getInput() {
        if(!scanner.hasNextInt()) {
            scanner.nextLine();
        }
        return scanner.nextInt();
    }
}
