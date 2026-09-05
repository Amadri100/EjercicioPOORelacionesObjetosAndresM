Autor: Andrés Madrigal
# Explicación del programa
## Paquetes 
## personas
Contiene la clase de Persona.

### Persona
+ Representa una persona con, edad, nombre y un poder
+ Permite usar sus poderes y cantar
+ tiene getters y setters para todos los atributos, pero no permite cambiar el nombre
## poderes
Contine varias subclases con poderes
### IPower
+ Intefaz que tiene un metodo dispararPoder()
+ El cual muestra un

### Clonación
+ Implementa IPower
+ Poder de clonación
+ Imprime: "O - O O - O O O O -  OO OO OO OO"

### Teletransporte
+ Implementa IPower
+ Poder de teletransporte
+ Imprime: "| - - - - | - - - - | ... |"

### TirarBombas
+ Implementa IPower
+ Poder de tirar bombas
+ Imprime: "O' > O* >  > \**!** 

### TirarTriangulos
+ Implementa IPower
+ Poder de tirar triángulos
+ Imprime: "^ - > - v - < - ^"

### VueloMutante
+ Implementa IPower
+ Poder de vuelo mutante
+ Imprime: "~~~~~~~> ~~~~~~~~> "

## profesiones
posee varias profesiones que una persona puede tener

### AdministradorDeEdificio
+ Hereda de persona
+ Puede contratar cajeros o Medicos
+ Contar cuantos trabajadores tiene de cada tipo y el total
+ Además de almacenar las clases de estos

### Cajero
+ Hereda de Persona
+ Cobra por objetos comprados a un precio fijo (10) y limitado al stock disponible
+ Puede rellenar objetos en la tienda
+ Almacena cantidad de transacciones, dinero en caja y objetos disponibles

### Medico
+ Hereda de Persona
+ Vende medicina a un precio fijo (100) y limitado al stock disponible
+ Puede crear medicina y realizar diagnósticos
+ Almacena cantidad de medicina disponible y dinero acumulado

## programaMutante

Tiene la clase main
### ProgramaMutante
+ Clase main
+ Elige la profesión y poder de una persona aleatoriamente
+ Contiene varios metodos estaticos para realizar pruebas con cada clase
+ Realiza primero con cada clase una prueba de su profesión despues realiza una prueba general para su poder aprovechando las propiedades del polimorfismo

# UML
```
@startuml ProgramaMutante

package personas {
    class Persona {
        - edad : byte
        # nombre : String
        - power : IPower
        + Persona()
        + Persona(pEdad : byte, pNombre : String)
        + Persona(pNombre : String, pEdad : byte)
        + Persona(nombre : String)
        + getNombre() : String
        + getEdad() : byte
        + setEdad(pEdad : byte) : void
        + setPower(pPower : IPower) : void
        + getPoder() : IPower
        + usarPoder() : void
        + cantar() : void
    }
}

package profesiones {
    class AdministradorDeEdificio {
        - cajerosEnEdificio : ArrayList<Cajero>
        - medicosEnEdificio : ArrayList<Medico>
        + AdministradorDeEdificio(pNombre : String, pEdad : int)
        + contratarCajero(cajero : Cajero) : void
        + contratarMedico(medico : Medico) : void
        + cantidadDeTrabajadores() : int
        + cantidadCajeros() : int
        + cantidadMedicos() : int
        + getCopiaCajeros() : ArrayList<Cajero>
        + getCopiaMedicos() : ArrayList<Medico>
    }

    class Cajero {
        - cantidadTransacciones : int
        - PRECIO : double {readOnly}
        - objetosEnLaTienda : int
        - dineroEnCaja : double
        + Cajero(pName : String, pEdad : int)
        + cobrar(cantidadDeObjetosComprados : int) : double
        + rellenarObjetos(cantidad : int) : void
        - objetosTotalesAVender(cantidadTotal : int) : int
        + getName() : String
        + getCantidadTransacciones() : int
        + getPrecio() : double
        + getDineroEnCaja() : double
    }

    class Medico {
        - PRECIO : double {readOnly}
        - cantidadMedicina : int
        - dinero : double
        + Medico(pName : String, pEdad : int)
        + venderMedicina(cantidadMedicina : int) : double
        + crearMedicina(cantidad : int) : void
        + diagnosticar() : void
        - objetosTotalesAVender(cantidadTotal : int) : int
        + getName() : String
        + getPrecio() : double
        + getDinero() : double
    }
}

package poderes {
    interface IPower {
        + dispararPoder() : void
    }

    class Clonacion {
        + Clonacion()
        + dispararPoder() : void
    }

    class Teletransporte {
        + Teletransporte()
        + dispararPoder() : void
    }

    class TirarBombas {
        + TirarBombas()
        + dispararPoder() : void
    }

    class TirarTriangulos {
        + TirarTriangulos()
        + dispararPoder() : void
    }

    class VueloMutante {
        + VueloMutante()
        + dispararPoder() : void
    }
}

package programaMutante {
    class ProgramaMutante {
        + {static} main(args : String[]) : void
        + {static} pruebaAdministrador(admin : AdministradorDeEdificio) : void
        + {static} pruebaCajero(cajero : Cajero) : void
        + {static} pruebaMedico(medico : Medico) : void
    }
}

' Herencias
Persona <|-- AdministradorDeEdificio
Persona <|-- Cajero
Persona <|-- Medico

' Implementaciones
IPower <|.. Clonacion
IPower <|.. Teletransporte
IPower <|.. TirarBombas
IPower <|.. TirarTriangulos
IPower <|.. VueloMutante

' Asociaciones
Persona "1" o-- "1" IPower : usa >
AdministradorDeEdificio "1" o-- "0..*" Cajero : contrata >
AdministradorDeEdificio "1" o-- "0..*" Medico : contrata >

' Dependencia
ProgramaMutante ..> Persona
ProgramaMutante ..> AdministradorDeEdificio
ProgramaMutante ..> Cajero
ProgramaMutante ..> Medico
ProgramaMutante ..> IPower

@enduml

```