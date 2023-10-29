package ejercicio7;

public class Main {
    public static void main(String[] args) {
        Coche coche = new Coche();

        Motor motor = new Motor(coche);
        Thread hiloMotor = new Thread(motor);
        Bateria bateria = new Bateria(coche);
        Thread hiloBateria = new Thread(bateria);
        Carroceria carroceria = new Carroceria(coche);
        Thread hiloCarroceria = new Thread(carroceria);

        hiloMotor.start();
        hiloBateria.start();
        hiloCarroceria.start();

        try {
            hiloMotor.join();
            hiloBateria.join();
            hiloCarroceria.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("El coche se ha montado correctamente.");
    }
}
