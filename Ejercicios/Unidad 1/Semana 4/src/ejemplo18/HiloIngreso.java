package ejemplo18;

public class HiloIngreso implements Runnable{
    private Cuenta cuenta;

    public HiloIngreso(Cuenta cuenta){
        this.cuenta = cuenta;
    }

    @Override
    public void run() {
        for(int i = 0; i < 1000; i++) {
            cuenta.ingresar(100);
        }
    }
}
