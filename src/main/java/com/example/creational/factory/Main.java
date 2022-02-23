package com.example.creational.factory;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

//        Empleado mecanico = new Mecanico();

        // Desacoplar la creación de un objeto de quien la tiene que utilizar

        Empleado prog1 = EmpleadoFactory.getEmpleado(EmpleadoType.PROGRAMADOR);
        System.out.println(prog1);

        Empleado prog2 = EmpleadoFactory.getEmpleado(EmpleadoType.PROGRAMADOR);
        System.out.println(prog2);

        Empleado prog3 = EmpleadoFactory.getEmpleado(EmpleadoType.PROGRAMADOR);
        System.out.println(prog3);

        Empleado mecanico1 = EmpleadoFactory.getEmpleado(EmpleadoType.MECANICO);
        Empleado mecanico2 = EmpleadoFactory.getEmpleado(EmpleadoType.MECANICO);

    }
}

enum EmpleadoType {
    PROGRAMADOR, MECANICO
}
abstract class Empleado {
    private String nss;
    private String salary;
}
class Mecanico extends Empleado {
    private Boolean electrostatica;
}
class Programador extends Empleado {
    List<String> languages = new ArrayList<>();
}
class EmpleadoFactory {

    public static Empleado getEmpleado(EmpleadoType type){

        return switch (type) {
            case MECANICO -> new Mecanico();
//            case MECANICO_ELECTRICO -> new Mecanico("", true);
//            case MECANICO_HIBRIDO -> new Mecanico("", false);
            case PROGRAMADOR -> new Programador();
        };
    }
}