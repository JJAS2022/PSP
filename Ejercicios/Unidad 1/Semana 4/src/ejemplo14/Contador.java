package ejemplo14;

public class Contador implements Runnable{
    private int contador = 0;

    @Override
    public void run() {
        for (int i = 0; i < 100; i++){
            contador++;
        }
        System.out.println(
                            "Finalizando el " + Thread.currentThread().getName() +
                            ". El valor del contador es " + contador);
    }
}
