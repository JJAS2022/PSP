package ejercicio9;

import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args){
        //boolean salir = false;
        int juego = 0;
        System.out.println("Bienvenido al juego de los dados");

        ExecutorService executor = Executors.newFixedThreadPool(2);

        while(juego < 5) {
            juego++;
            System.out.printf("\nJuego %d:\n", juego);
            System.out.println("Indica cuántos dados quieres lanzar (1-6):");
            int nDados = getInput();
            int[] resultadosEsperados = new int[nDados];
            System.out.println("Indica los resultados que deseas obtener:");
            for (int i = 0; i < nDados; i++) {
                resultadosEsperados[i] = getInput();
            }
            Arrays.sort(resultadosEsperados);
            Lanzamiento lanzamiento = new Lanzamiento(juego, resultadosEsperados);
            executor.execute(lanzamiento);
        }

        executor.shutdown();
    }

    private static int getInput() {
        int input = 0;
        while(input <= 0 || input >= 7) {
            if(scanner.hasNextInt()) {
                input = scanner.nextInt();
            } else {
                scanner.nextLine();
            }
        }
        return input;
    }
}
