package ejercicio4;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        boolean match = false;

        while (!match) {
            int number = random.nextInt(10, 21);
            System.out.println("Pulsa enter cuando creas que el contador ha llegado a " + number + ".");

            Contador contador = new Contador();
            Thread thread = new Thread(contador);
            thread.start();

            for (int i = 1; i <= 5; i++) {
                System.out.println(i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

            System.out.println();
            scanner.nextLine();
            contador.stopCounting();


            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            int value = contador.getCounter();
            if (number == value) {
                System.out.println("!Lo has conseguido!");
                match = true;
            } else {
                System.out.println("Vuelve a intentarlo, has detenido el contador en " + value + "...");
                System.out.println();
            }
        }
    }
}
