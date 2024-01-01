package ejercicio3;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Thread> threads= new ArrayList<Thread>();

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
            threads.add(thread);
            thread.setName(primos.name);
            System.out.println("Hilo " + thread.getName() + ": Mostrando primos hasta el " + primos.maxValue);
            thread.start();
        }

        while (threadsAlive()) {
            for (int i = 0; i < n; i++) {
                Thread subThread = threads.get(i);
                System.out.println("ID: " + subThread.getId() + ", Hilo: " + subThread.getName() + ", Estado: " + subThread.getState());
            }
            try {

                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private static boolean threadsAlive() {
        for (int i = 0; i < threads.size(); i++) {
            Thread thread = threads.get(i);
            if (thread.isAlive())
                return true;
        }
        return false;
    }
}
