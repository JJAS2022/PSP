package ejercicio1a;

import java.util.Scanner;

public class Main {
    static int n1, n2;
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.print("Introduce n1: ");
        n1 = getInput();
        System.out.print("Introduce n2: ");
        n2 = getInput();

        Thread thread = new Thread(new Contador(n1, n2));
        thread.start();

        System.out.println("El hilo se ha lanzado.");
    }

    private static int getInput() {
        while (!scanner.hasNextInt()) {
            scanner.nextLine();
        }
        return scanner.nextInt();
    }
}
