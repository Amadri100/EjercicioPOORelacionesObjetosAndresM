import java.util.ArrayList;
package profesiones;

public class AdministradorDeEdificio extends Persona{
    private ArrayList<Cajero> cajerosEnEdificio;
    private ArrayList<Medico> medicosEnEdificio;

    public AdministradorDeEdificio(String pNombre,  int pEdad) {
        super(pNombre, (byte)pEdad);
    }

    public void contratarCajero(Cajero cajero) {
        this.cajerosEnEdificio.add(cajero);
    }

    public void contratarMedico(Medico medico) {
        this.medicosEnEdificio.add(medico);
    }

    public int cantidadDeTrabajadores() {
        return cajerosEnEdificio.size() + medicosEnEdificio.size();
 
    }

    public int cantidadCajeros() {
        return cajerosEnEdificio.size();
    }

     public int cantidadMedicos() {
        return medicosEnEdificio.size();
    }

    public ArrayList<Cajero> getCopiaCajeros() {
        return new ArrayList<>(cajerosEnEdificio);
    }
    public ArrayList<Medico> getCopiaMedicos() {
        return new ArrayList<>(medicosEnEdificio);
    }


}
