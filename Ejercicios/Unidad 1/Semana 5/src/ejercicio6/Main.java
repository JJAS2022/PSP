package ejercicio6;

public class Main {
    public static void main(String[] args) {
        Log log = new Log();
        for (int i = 1; i <= 5; i++) {
            Thread thread = new Thread(log);
            thread.setName(String.valueOf(i));
            thread.start();
        }
    }
}
