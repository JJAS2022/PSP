package ejemplo13;

public class Main {
    public static void main(String[] args){
        Cafetera cafetera = new Cafetera();
        Thread thread = new Thread(cafetera);
        thread.start();
    }
}
