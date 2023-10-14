package ejemplo13b;

public class Cafetera implements Runnable{
    private int contador = 0;
    private boolean ejecutar = true;

    public int getContador() {
        return contador;
    }

    public void Detener() {
        ejecutar = false;
    }

    @Override
    public void run() {
        try {
            while(ejecutar) {
                Thread.sleep(200);
                Thread.sleep(200);
                Thread.sleep(200);
                contador++;
                System.out.println("Número de cafés preparados: " + contador);
            }
        } catch (InterruptedException ie) {
            System.out.println("Hilo interrumpido.");
        }
    }
}
