package ejemplo9;

public class Main {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            try {
                for (int i = 0; i < 5; i++) {
                    Thread.sleep(1000);
                    System.out.println("Hola, soy un hilo.");
                }
            } catch (InterruptedException ie) {
                System.out.println("Hilo interrumpido.");
            }
        });
        thread.start();

        while (thread.isAlive()) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Hilo terminado.");
    }
}
