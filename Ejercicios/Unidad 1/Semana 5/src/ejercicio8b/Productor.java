package ejercicio8b;

import java.util.Random;

public class Productor implements Runnable{
    private String variedad;
    private int intensidad;
    private Contenedor contenedor;
    private Random random = new Random();
    private boolean detener = false;

    public void detenerProduccion() {
        detener = true;
    }

    public Productor(String variedad, int intensidad, Contenedor contenedor) {
        this.variedad = variedad;
        this.intensidad = intensidad;
        this.contenedor = contenedor;
    }

    @Override
    public void run() {
        try{
            while (!detener) {
                producirCapsula();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void producirCapsula() throws InterruptedException {
        synchronized (contenedor) {
            while (contenedor.getCapsulas() < 6) {
                Capsula capsula = new Capsula(variedad, intensidad);
                contenedor.anyadirCapsula();
                System.out.println("Hilo Productor: Se ha fabricado una cápsula. Total en contenedor: " + contenedor.getCapsulas());
                if (contenedor.getCapsulas() == 6) {
                    contenedor.notify();
                }
                Thread.sleep(random.nextInt(500, 1000));
            }
        }
    }
}
