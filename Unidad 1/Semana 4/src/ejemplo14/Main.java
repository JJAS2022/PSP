package ejemplo14;

public class Main {
    public static void main(String[] args) {
        Contador c = new Contador();
        for (int i = 1; i <= 5; i++) {
            Thread thread = new Thread(c);
            thread.setName("Hilo " + i);
            thread.start();
        }
    }
}
