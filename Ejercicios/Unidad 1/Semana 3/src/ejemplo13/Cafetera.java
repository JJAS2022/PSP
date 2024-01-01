package ejemplo13;

public class Cafetera implements Runnable{
    private int contador = 0;

    public int getContador() {
        return contador;
    }

    @Override
    public void run() {
        try {
            while(true) {
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
