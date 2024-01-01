package ejercicio8d;

import java.util.Random;

public class Consumidor implements Runnable{
    final Contenedor contenedor;
    private boolean detener = false;
    private Random random = new Random();

    public void detenerProduccion() {
        detener = true;
    }

    public Consumidor(Contenedor contenedor) {
        this.contenedor = contenedor;
    }

    @Override
    public void run() {
        while (!detener) {
            try {
                producirCaja();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void producirCaja() throws InterruptedException {
        synchronized (contenedor) {
            while (contenedor.getCapsulas() < 6) {
                try {
                    System.out.println("Hilo consumidor a la espera de cápsulas.");
                    contenedor.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            contenedor.empaquetarCapsulas();
            System.out.println("Hilo Consumidor: Creando una caja");
        }
        Thread.sleep(random.nextInt(1000, 3000));
        System.out.println("Hilo Consumidor: Caja creada.");
    }
}
