package src.profesiones;
import src.personas.*;

public class Medico extends Persona{

    private final double PRECIO = 100; 
    private int cantidadMedicina;
    private double dinero;

    public Medico(String pName, int pEdad) {
        super(pName, (byte)pEdad);
        this.dinero = 0;
        this.cantidadMedicina = 10;
    }

    public double venderMedicina(int cantidadMedicina) {
        int objetosTotales = objetosTotalesAVender(cantidadMedicina);
        double resultado = PRECIO*objetosTotales;
        this.dinero += resultado;
        this.cantidadMedicina -= objetosTotales;
        return resultado;
    }

    public void crearMedicina(int cantidad) {
        if (cantidad > 0) {
            this.cantidadMedicina +=cantidad;
        }
    }

    public void diagnosticar() {
        System.out.println("Observación...");
        System.out.println("Analisis...");
        System.out.println("Diagnostico...");
    }


    private int objetosTotalesAVender(int cantidadTotal) {
        if (cantidadTotal > cantidadMedicina) 
            return cantidadMedicina;
        else 
            return cantidadTotal;
    }

    public String getName() {
        return this.nombre;
    }
    public double getPrecio() {
        return this.PRECIO;
    }
    public double  getDinero() {
        return this.dinero;
    }

}

