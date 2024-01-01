package ejemplo11;

import java.util.Random;

public class Main {
    public static void main(String [] args) throws InterruptedException {
        Thread thread = new Thread( () -> {
           try {
               Random random = new Random();
               for (int i = 0; i <10; i++) {
                   Thread.sleep(random.nextInt(1500));
                   System.out.println("Número " + i);
               }
           } catch (InterruptedException ie){
               System.out.println("El hilo se ha interrumpido.");
            }
        });
        thread.start();

        thread.join();

        System.out.println("El hilo ha finalizado");
    }
}
