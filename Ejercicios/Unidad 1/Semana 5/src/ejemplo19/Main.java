package ejemplo19;

public class Main {
    public static void main(String[] args) {
        Cuenta c = new Cuenta();

        HiloIngreso hi = new HiloIngreso(c);
        HiloReintegro hr = new HiloReintegro(c);

        Thread ti = new Thread(hi);
        Thread tr = new Thread(hr);

        ti.start();
        tr.start();

        try {
            ti.join();
            tr.join();
        } catch(InterruptedException ie) {
            ie.printStackTrace();
        }

        System.out.println("Saldo final: " + c.getSaldo());
    }
}
