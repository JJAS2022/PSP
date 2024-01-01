package ejercicio2;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){
        System.out.print("Introduce el número de hilos a crear: ");
        while (!scanner.hasNextInt()) {
            scanner.nextLine();
        }
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            Primos primos = new Primos();
            primos.name = String.valueOf(i+1);
            Thread thread = new Thread(primos);
            thread.setName(primos.name);
            System.out.println("Hilo " + thread.getName() + ": Mostrando primos hasta el " + primos.maxValue);
            thread.start();
        }


    }
}
