package ejercicio7;

public class Bateria implements Runnable{
    private final Coche coche;

    public Bateria(Coche coche) {
        this.coche = coche;
    }

    @Override
    public void run() {
        try {
            montarBateria();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void montarBateria() throws InterruptedException {
        System.out.println("BATERIA: Se ponen los cables.");
        Thread.sleep(2000);
        System.out.println("BATERIA: Se enchufan los fusibles.");
        Thread.sleep(2000);
        System.out.println("BATERIA: Se rellena el líquido de batería.");
        Thread.sleep(2000);
        synchronized (coche) {
            while (!coche.getCarroceria()) {
                try {
                    System.out.println("BATERIA. Imposible montar batería. El coche aún no tiene carrocería.");
                    coche.wait();
                } catch (InterruptedException | IllegalMonitorStateException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("BATERIA: Se monta la batería.");
    }
}
