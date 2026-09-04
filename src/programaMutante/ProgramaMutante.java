package src.programaMutante;
import org.omg.PortableServer.POAManagerPackage.AdapterInactive;

import src.personas.*;
import src.profesiones.*;
import src.poderes.*;

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
                    break;
                case 1:
                    profesionales[i] = new Cajero("Pepito"+i, 23);
                    break;
                case 2:
                    profesionales[i] = new Medico("Carlos "+i, 30);
                    break;
                default:
                    profesionales[i] = new Cajero("Matias "+i, 18);
            }
            profesionales[i].setPower(poderesDisponibles[(int)(Math.random()*5)]);
        }

        for(Persona p : profesionales) {
            System.out.println("Usa Poderes "+p.getNombre());
            p.usarPoder();
        }

    }
}
