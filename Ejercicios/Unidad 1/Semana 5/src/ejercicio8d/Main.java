package ejercicio8d;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Contenedor contenedor = new Contenedor();

        Consumidor consumidor = new Consumidor(contenedor);
        Thread hiloConsumidor = new Thread(consumidor);
        hiloConsumidor.start();

        Productor productor1 = new Productor("Café con leche", 3, contenedor);
        Productor productor2 = new Productor("Café con leche", 3, contenedor);
        Productor productor3 = new Productor("Café con leche", 3, contenedor);
        Productor productor4 = new Productor("Café con leche", 3, contenedor);

        Thread hiloProductor1 = new Thread(productor1);
        Thread hiloProductor2 = new Thread(productor2);
        Thread hiloProductor3 = new Thread(productor3);
        Thread hiloProductor4 = new Thread(productor4);
        hiloProductor1.start();
        hiloProductor2.start();
        hiloProductor3.start();
        hiloProductor4.start();

        scanner.nextLine();
        consumidor.detenerProduccion();
        productor1.detenerProduccion();
        productor2.detenerProduccion();
        productor3.detenerProduccion();
        productor4.detenerProduccion();

        try {
            hiloConsumidor.join();
            hiloProductor1.join();
            hiloProductor2.join();
            hiloProductor3.join();
            hiloProductor4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.printf("Se han empaquetado %d cajas de cápsulas de café.", contenedor.getCajas());
    }
}
