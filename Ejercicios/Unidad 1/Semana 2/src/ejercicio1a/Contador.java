package ejercicio1a;

import java.util.Random;

public class Contador extends Thread implements Runnable{
    int n1, n2;
    Random random = new Random();
    @Override
    public void run() {
        for (int i = n1; i <= n2; i++){
            System.out.println(i);
            try {
                Thread.sleep(random.nextInt(1, 1000));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public Contador(int n1, int n2) {
        this.n1 = n1;
        this.n2 = n2;
    }
}
