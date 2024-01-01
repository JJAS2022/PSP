package ejemplo4;

public class Tostadora implements Runnable {
    @Override
    public void run() {
        try {
            System.out.println("Tostadas: Comenzamos a preparar tostadas.");
            System.out.println("Tostadas: Ponemos el pan a tostar.");
            Thread.sleep(2000);
            System.out.println("Tostadas: Echamos aceite.");
            Thread.sleep(2000);
            System.out.println("Tostadas: Echamos sal.");
            Thread.sleep(2000);
            System.out.println("Tostadas: Tostadas finalizadas.");
        }catch (InterruptedException ie) {
            System.out.println("Se ha interrumpido el hilo");
        }
    }
}
