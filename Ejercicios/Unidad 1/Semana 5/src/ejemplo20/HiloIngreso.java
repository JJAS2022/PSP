package ejemplo20;

public class HiloIngreso implements Runnable{
    private final Cuenta cuenta;

    public HiloIngreso(Cuenta cuenta){
        this.cuenta = cuenta;
    }

    @Override
    public void run() {
        for(int i = 0; i < 1000; i++) {
            synchronized (cuenta) {
                cuenta.ingresar(1000);
            }
        }
    }
}
