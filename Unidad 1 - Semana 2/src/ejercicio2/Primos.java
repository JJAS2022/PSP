package ejercicio2;

import java.util.Random;

public class Primos implements Runnable{
    String name;
    Random random = new Random();
    int maxValue = random.nextInt(1, 100);

    @Override
    public void run() {
        for (int i = 1; i <= maxValue; i++) {
            if (isPrime(i)) {
                System.out.println("Hilo " + name + ": " + i);
                try {
                    Thread.sleep(random.nextInt(500, 1000));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    boolean isPrime(int value) {
        for (int i = 2; i < value; i++) {
            if (value % i == 0) {
                return false;
            }
        }
        return true;
    }
}
