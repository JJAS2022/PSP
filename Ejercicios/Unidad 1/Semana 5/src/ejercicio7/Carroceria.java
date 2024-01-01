package ejercicio7;

public class Carroceria implements Runnable{
    private final Coche coche;

    public Carroceria(Coche coche) {
        this.coche = coche;
    }

    @Override
    public void run() {
        try {
            montarCarroceria();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void montarCarroceria() throws InterruptedException {
        System.out.println("CARROCERIA: Se ponen los marcos.");
        Thread.sleep(2000);
        System.out.println("CARROCERIA: Se ponen los asientos y el suelo.");
        Thread.sleep(2000);
        System.out.println("CARROCERIA: Se colocan las puertas.");
        Thread.sleep(2000);
        System.out.println("CARROCERIA: Se pone número de bastidor");
        Thread.sleep(2000);
        System.out.println("CARROCERIA: Se monta la carrocería.");
        synchronized (coche) {
            coche.setCarroceria();
            coche.notifyAll();
        }
    }
}
