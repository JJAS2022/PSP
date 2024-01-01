package ejemplo21;

public class HiloIngreso implements Runnable{
    private final Cuenta cuenta;

    public HiloIngreso(Cuenta cuenta){
        this.cuenta = cuenta;
    }

    @Override
    public void run() {
        for(int i = 0; i < 100000; i++) {
            synchronized (cuenta) {
                cuenta.ingresar(100);
                System.out.println("INGRESO. Saldo: " + cuenta.getSaldo());
                cuenta.notify();
            }
        }
    }
}
