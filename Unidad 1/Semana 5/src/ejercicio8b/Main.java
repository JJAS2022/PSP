package ejercicio8b;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Contenedor contenedor = new Contenedor();

        Consumidor consumidor = new Consumidor(contenedor);
        Thread hiloConsumidor = new Thread(consumidor);
        hiloConsumidor.start();

        Productor productor = new Productor("Café con leche", 3, contenedor);
        Thread hiloProductor = new Thread(productor);
        hiloProductor.start();

        scanner.nextLine();
        productor.detenerProduccion();
        consumidor.detenerProduccion();

        try {
            hiloConsumidor.join();
            hiloProductor.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.printf("Se han empaquetado %d cajas de cápsulas de café.", contenedor.getCajas());
    }
}
