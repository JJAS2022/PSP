package ejercicio7;

public class Motor implements Runnable{
    private final Coche coche;

    public Motor(Coche coche) {
        this.coche = coche;
    }

    @Override
    public void run() {
        try {
            montarMotor();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void montarMotor() throws InterruptedException {
        System.out.println("MOTOR: Se ponen los pistones.");
        Thread.sleep(2000);
        System.out.println("MOTOR: Se ponen los cilindros.");
        Thread.sleep(2000);
        System.out.println("MOTOR: Se echa el aceite de motor.");
        Thread.sleep(2000);
        synchronized (coche) {
            while (!coche.getCarroceria()) {
                try {
                    coche.wait();
                    System.out.println("MOTOR. Imposible montar motor. El coche aún no tiene carrocería.");
                } catch (InterruptedException | IllegalMonitorStateException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("MOTOR: Se monta el motor.");
    }
}
