package com.example.behavioral.command.guru;

import com.example.behavioral.command.guru.invoker.Editor;

/*
El patrón de comandos se ve comúnmente en el código de la interfaz gráfica
de usuario, como el manejo de las acciones de los botones, elementos de menú,
 enlaces de acción y también barras de progreso y asistentes de Java.

 También se ve en código relacionado con Runnable.
 Pero, este patrón no se limita a ellos
 */
public class Main {

    public static void main(String[] args) {
        Editor editor = new Editor();
        editor.init();
    }
}
