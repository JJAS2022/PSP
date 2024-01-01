package ejercicio8a;

public class Main {
    public static void main(String[] args) {
        Contenedor contenedor = new Contenedor();

        Consumidor consumidor = new Consumidor(contenedor);
        Thread hiloConsumidor = new Thread(consumidor);
        hiloConsumidor.start();

        Productor productor = new Productor("Café negro", 5, contenedor);
        Thread hiloProductor = new Thread(productor);
        hiloProductor.start();

        try {
            hiloConsumidor.join();
            hiloProductor.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.printf("Se han empaquetado %d cajas de cápsulas de café.", contenedor.getCajas());
    }
}
