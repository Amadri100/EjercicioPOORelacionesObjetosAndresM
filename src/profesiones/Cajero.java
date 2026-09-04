package src.profesiones;

public class Cajero extends Persona {
    private int cantidadTransacciones;
    private final double PRECIO = 10; //Todo cuesta 10 en la tienda imaginaria
    private int objetosEnLaTienda;
    private double dineroEnCaja;

    public Cajero(String pName, int pEdad) {
        super(pName, (byte)pEdad);
        this.cantidadTransacciones = 0;
        this.dineroEnCaja = 0;
        this.objetosEnLaTienda = 50;
    }

    public double cobrar(int cantidadDeObjetosComprados) {
        int objetosTotales = objetosTotalesAVender(cantidadDeObjetosComprados);
        double resultado = PRECIO*objetosTotales;
        this.cantidadTransacciones++;
        this.dineroEnCaja += resultado;
        this.objetosEnLaTienda -= objetosTotales;
        return resultado;
    }

    public void rellenarObjetos(int cantidad) {
        if (cantidad > 0) {
            this.objetosEnLaTienda +=cantidad;
        }
    }

    private int objetosTotalesAVender(int cantidadTotal) {
        if (cantidadTotal > objetosEnLaTienda) 
            return objetosEnLaTienda;
        else 
            return cantidadTotal;
    }

    public String getName() {
        return this.nombre;
    }
    public int getCantidadTransacciones() {
        return this.cantidadTransacciones;
    }
    public double getPrecio() {
        return this.PRECIO;
    }
    public double  getDineroEnCaja() {
        return this.dineroEnCaja;
    }

}
