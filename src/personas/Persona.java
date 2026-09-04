package src.personas;

public class Persona {
    private byte edad;  
    protected String nombre;
    //private enum status = {CAMINANDO(0), DURMIENDO, TRABAJNADO, CANTANDO };



    public Persona() { 
        edad = 19;
        nombre = "Andres Madrigal";
    }

    public Persona(byte pEdad, String pNombre) {
        this.edad = pEdad;
        this.nombre = pNombre;
    }


    public Persona(String pNombre, byte pEdad) {
        this.edad = pEdad;
        this.nombre = pNombre;
    }

    public Persona(String nombre) {
        this.edad = 0; 
        this.nombre = nombre;  
    }

    public String getNombre() {
        return this.nombre;
    }

    public byte getEdad() {
        return this.edad;
    }

    public void setEdad(byte pEdad) {
        this.edad = pEdad;
    }


    public void cantar() {
        System.out.println(
                          "Soon, I'll be sixty years old, my daddy got sixty-one\n" + 
                          "Remember life and then your life becomes a better one\n" + 
                          "I made a man so happy when I wrote a letter once\n" + 
                          "Lukas Graham - 7 Years"
                          );
    }

}
