package ejemplo21;

public class Cuenta {
    private double saldo = 0;

    public double getSaldo(){
        return saldo;
    }

    public void ingresar(double cantidad) {
        saldo += cantidad;
    }

    public void reintegrar(double cantidad) {
        saldo -= cantidad;
    }
}
