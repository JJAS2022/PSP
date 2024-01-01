package ejemplo13c;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Cafetera cafetera = new Cafetera();
        Thread thread = new Thread(cafetera);
        thread.start();

        System.out.println("Presione intro para detener la cafetera.");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        thread.interrupt();

        try {
            thread.join();
        } catch (InterruptedException ie){
            ie.printStackTrace();
        }

        System.out.printf("Total: %d cafés", cafetera.getContador());
    }
}
