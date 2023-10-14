package ejercicio4;

public class Contador implements Runnable{
    private int counter = 0;
    private boolean stop = false;

    public int getCounter(){
        return counter;
    }

    public Contador() { }

    public void stopCounting() {
        stop = true;
    }

    @Override
    public void run() {
        while(!stop) {
            try {
                counter++;
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
