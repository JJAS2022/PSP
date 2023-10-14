package ejemplo10;

public class Main {
    public static void main(String[] args) {
        Thread thread = Thread.currentThread();
        System.out.println("ID: " + thread.getId());
        System.out.println("Nombre: " + thread.getName());
        System.out.println("Prioridad: " + thread.getPriority());
        System.out.println("Estado: " + thread.getState());
        System.out.println("Está vivo: " + thread.isAlive());
    }
}
