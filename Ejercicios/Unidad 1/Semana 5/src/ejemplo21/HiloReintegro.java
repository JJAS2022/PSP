package ejemplo21;

public class HiloReintegro implements Runnable{
    private final Cuenta cuenta;

    public HiloReintegro(Cuenta cuenta){
        this.cuenta = cuenta;
    }

    @Override
    public void run() {
        for(int i = 0; i < 100000; i++) {
            synchronized (cuenta){
                while (cuenta.getSaldo() < 100) {
                    try {
                        System.out.println("No hay saldo, Esperamos...");
                        cuenta.wait();
                        System.out.println("Ya se ha producido un ingreso.");
                    } catch (InterruptedException ie) {
                        ie.printStackTrace();
                    }
                }
                cuenta.reintegrar(100);
                System.out.println("REINTEGRO. Saldo: " + cuenta.getSaldo());
            }
        }
    }
}
