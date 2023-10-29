package ejercicio8a;

public class Consumidor implements Runnable{
    final Contenedor contenedor;

    public Consumidor(Contenedor contenedor) {
        this.contenedor = contenedor;
    }

    @Override
    public void run() {
        while (contenedor.getCajas() < 10) {
            producirCaja();
        }
    }

    private void producirCaja() {
        synchronized (contenedor) {
            while (contenedor.getCapsulas() < 6) {
                try {
                    System.out.println("Hilo consumidor a la espera de cápsulas.");
                    contenedor.wait();
                    System.out.println("Hilo Consumidor: Creando una caja");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("Hilo Consumidor: Caja creada.");
            contenedor.empaquetarCapsulas();
        }
    }
}
