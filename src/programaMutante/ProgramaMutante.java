package programaMutante;

import personas.*;
import profesiones.*;
import poderes.*;

public class ProgramaMutante {
    public static void main(String[] args) {
        Persona profesionales[] = new Persona[10];
        IPower poderesDisponibles[] = {new Clonacion(), new Teletransporte(), new TirarBombas(), 
                                       new TirarTriangulos(),new VueloMutante()};

        for (int i = 0; i < 10; i++) {
            int tipoProfesion = (int)(Math.random()*3);
            switch (tipoProfesion) {
                case 0:
                    profesionales[i] = new AdministradorDeEdificio("Juan"+i, 28);
                    System.out.println("Nombre: " + profesionales[i].getNombre());
                    pruebaAdministrador((AdministradorDeEdificio)profesionales[i]);
                    break;
                case 1:
                    profesionales[i] = new Cajero("Pepito"+i, 23);
                    pruebaCajero((Cajero)profesionales[i]);
                    break;
                case 2:
                    profesionales[i] = new Medico("Carlos"+i, 30);
                    pruebaMedico((Medico)profesionales[i]);
                    break;
                default:
                    profesionales[i] = new Cajero("Matias"+i, 18);
                    pruebaCajero((Cajero)profesionales[i]);
            }
            System.out.println("-------------------------");
            profesionales[i].setPower(poderesDisponibles[(int)(Math.random()*5)]);
        }

        for(Persona p : profesionales) {
            System.out.println("Nombre: "+p.getNombre()+" Usa poderes: " );
            p.usarPoder();
            System.out.println("-------------------------");
        }
 
    } 
    //static pues es requisito para usarse en el main; no es necesario tener una instancia de ProgramaMutante para usarse
    public static void pruebaAdministrador(AdministradorDeEdificio admin) {
        int num1 = (int)(Math.random()*8);
        int num2 = (int)(Math.random()*8);
        for (int i = 0; i < num1; i++) {
            admin.contratarCajero(new Cajero("A", 20));
        }
        for (int i = 0; i < num2; i++) {
            admin.contratarMedico(new Medico("B", 20));
        }
        System.out.println("Se contrataron: " + admin.cantidadCajeros() + " cajeros y: "+ admin.cantidadMedicos() + " Medicos");
        System.out.println("Total: " + admin.cantidadDeTrabajadores());
    }
    public static void pruebaCajero(Cajero cajero) {
        int num1 = (int)(Math.random()*45);
        int num2 = (int)(Math.random()*23);
        System.out.println("El cajero llena con: " + num1 + " objetos la tienda");
        cajero.rellenarObjetos(num1);
        System.out.println("Se intenta compran " + num2 + " y el costo total es: " + cajero.cobrar(num2));
    }
    public static void pruebaMedico(Medico medico) {
        int num1 = (int)(Math.random()*45);
        int num2 = (int)(Math.random()*23);
        System.out.println("El Medico crea: " + num1 + " medicinas para la farmacia");
        medico.crearMedicina(num1);
        System.out.println("Se intenta compran " + num2 + " y el costo total es: " + medico.venderMedicina(num2));
        medico.diagnosticar();
    }
}
