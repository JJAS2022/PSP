package ejemplo4;

public class Main {
    public static void main(String[] args) {
        try {
            Thread tostadora = new Thread(new Tostadora());
            tostadora.start();
            prepararCafe();
        } catch (InterruptedException ie) {
            System.out.println("Hilo interrumpido");
        }
    }

    public static void prepararCafe() throws InterruptedException {
        System.out.println("Café: Comenzamos a preparar el café.");
        System.out.println("Café: Ponemos la cafetera.");
        Thread.sleep(2000);
        System.out.println("Café: Servimos el café en la taza.");
        Thread.sleep(2000);
        System.out.println("Café: Echamos la leche.");
        Thread.sleep(2000);
        System.out.println("Café: Café finalizado.");
    }
}
