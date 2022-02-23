package com.example.structural.composite;

import org.w3c.dom.Text;

/*
El patrón se utiliza para implementar una estructura jerárquica en forma de árbol
de elementos, que tienen el mismo comportamiento. Los elementos pueden ser primitivos
(hojas) u objetos compuestos.

Los objetos compuestos tienen hijos, que pueden ser hojas u objetos compuestos.

Componer objetos en estructuras de árbol para representar jerarquías parte-total.
Composite permite a los clientes tratar los objetos individuales y
las composiciones de objetos de manera uniforme.

    El patrón de diseño compuesto es uno de los patrones de diseño estructural
    El objeto compuesto y el objeto individual se tratan de manera uniforme
    Hay 2 tipos de objetos Objeto compuesto y objeto hoja.
    Objeto compuesto: es un objeto que contiene otro objeto
    Objeto hoja: es un objeto individual.
    Los datos pueden representarse como una estructura de árbol
 */
public class Main {

    public static void main(String[] args) {
        TextFile child1 = new TextFile(100L);
        TextFile child2 = new TextFile(200L);

        Directory home = new Directory();
        TextFile cv = new TextFile(400L);
        home.addFile(cv);

        Directory root = new Directory();
        root.addFile(child1); // file 100
        root.addFile(child2); // file 200
        root.addFile(home); // directory 400

        System.out.println(child1.getSize());      // output : 100
        System.out.println(root.getSize());    // output : 700
    }
}
