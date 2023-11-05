package ejercicio9;

import java.util.Arrays;
import java.util.Random;

public class Lanzamiento implements Runnable{
    private int nJuego;
    private int nTirada;
    private int[] resultadosEsperados;
    private int[] resultadosObtenidos;
    private boolean exito;
    private Random random = new Random();

    public Lanzamiento(int nJuego, int [] resultadosEsperados) {
        this.nJuego = nJuego;
        this.resultadosEsperados = resultadosEsperados;
        resultadosObtenidos = new int[resultadosEsperados.length];
    }

    @Override
    public void run() {
        while (!exito) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            nTirada++;
            boolean iguales = true;

            for (int i = 0; i < resultadosEsperados.length; i++) {
                resultadosObtenidos[i] = random.nextInt(1, 7);
            }

            Arrays.sort(resultadosObtenidos);

            for (int i = 0; i < resultadosObtenidos.length; i ++) {
                if (resultadosObtenidos[i] != resultadosEsperados[i]){
                    iguales = false;
                }
            }

            if (iguales) {
                exito = true;
                System.out.printf("Juego %d: Éxito en la tirada %d.\n", nJuego, nTirada);
            }
        }
    }
}
