package ejemplo19;

public class Cuenta {
    private double saldo = 0;

    public double getSaldo(){
        return saldo;
    }

    public synchronized void ingresar(double cantidad) {
        saldo += cantidad;
    }

    public synchronized void reintegrar(double cantidad) {
        saldo -= cantidad;
    }
}
