package com.example.behavioral.memento;

/*
Memento es un patrón de diseño de comportamiento que permite guardar y
restaurar el estado anterior de un objeto sin revelar los detalles de su implementación.

También se conoce como patrón snapshot.

Un memento es como un punto de restauración durante el ciclo de vida del objeto,
que la aplicación cliente puede utilizar para restaurar el estado del objeto
a su estado. Conceptualmente, es muy parecido a los puntos de restauración
 que creamos para los sistemas operativos y que utilizamos para restaurar
  el sistema si algo se rompe o el sistema se bloquea.

Sin violar la encapsulación, capturar y externalizar el estado interno de
un objeto para que el objeto pueda ser restaurado a este estado más tarde.

- Originator
- ConcreteOriginator
- Memento
- ConcreteMementor
- Caretaker (guarda el histórico de mementos)

*/
public class Main {

    public static void main(String[] args) {
        // commit 1
        TextFileOriginator file1 = new TextFileOriginator("Draft1.txt");
        file1.writeContent("write 1");
        TextFileHistory.commit(file1, "commit 1");
        TextFileHistory.listCommits(file1);

        // commit 2
        file1.writeContent("write 2");
        TextFileHistory.commit(file1, "commit 2");
        TextFileHistory.listCommits(file1);

        // commit 3
        file1.writeContent("write 3");
        TextFileHistory.commit(file1, "commit 3");
        TextFileHistory.listCommits(file1);

        // restaurar commit 1
        TextFileHistory.restore(file1, 0);
        TextFileHistory.listCommits(file1);
        System.out.println("Current state of the file: " + file1);
    }
}
