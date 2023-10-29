package ejemplo20;

public class HiloReintegro implements Runnable{
    private Cuenta cuenta;

    public HiloReintegro(Cuenta cuenta){
        this.cuenta = cuenta;
    }

    @Override
    public void run() {
        for(int i = 0; i < 1000; i++) {
            synchronized (cuenta){
                cuenta.reintegrar(1000);
            }
        }
    }
}
