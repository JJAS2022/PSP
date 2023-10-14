package ejemplo5;

public class Main {
    public static void main(String[] args) {
        Thread tostadora = new Thread(() -> {
            try {
                System.out.println("Tostadas: Comenzamos a preparar tostadas.");
                System.out.println("Tostadas: Ponemos el pan a tostar.");
                Thread.sleep(2000);
                System.out.println("Tostadas: Echamos aceite.");
                Thread.sleep(2000);
                System.out.println("Tostadas: Echamos sal.");
                Thread.sleep(2000);
                System.out.println("Tostadas: Tostadas finalizadas.");
            } catch (InterruptedException ie) {
                System.out.println("Se ha interrumpido el hilo");
            }
        });

        tostadora.start();

        try {
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
