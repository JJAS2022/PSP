package ejemplo18;

public class HiloReintegro implements Runnable{
    private Cuenta cuenta;

    public HiloReintegro(Cuenta cuenta){
        this.cuenta = cuenta;
    }

    @Override
    public void run() {
        for(int i = 0; i < 1000; i++) {
            cuenta.reintegrar(100);
        }
    }
}
