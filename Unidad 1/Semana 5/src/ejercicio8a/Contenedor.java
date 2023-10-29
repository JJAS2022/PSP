package ejercicio8a;

public class Contenedor {
    private int capsulas;
    private int cajas;

    public int getCapsulas() {
        return capsulas;
    }

    public int getCajas() {
        return cajas;
    }

    public void setCapsulas(int capsulas) {
        this.capsulas = capsulas;
    }

    public void setCajas(int cajas) {
        this.cajas = cajas;
    }

    public Contenedor() {}

    public void anyadirCapsula() {
        capsulas++;
    }

    public void empaquetarCapsulas() {
        capsulas -= 6;
        cajas++;
    }
}
