package com.example.structural.flyweight;

/*



Cuando necesitamos un gran número de objetos similares que son únicos en
 términos de sólo unos pocos parámetros y la mayoría de las cosas
 son comunes en general.

Necesitamos controlar el consumo de memoria por un gran número de objetos -
 creando menos objetos y compartiéndolos entre ellos.

 */
public class Main {

    private static final String[] colors = { "Red", "Green", "Blue", "White", "Black" };
    public static void main(String[] args) {

        for(int i=0; i < 20; ++i) {
            // ShapeFactory busca el círculo del color indicado, si lo encuentra lo recupera
            // tal cual del mapa, si no lo encuentra lo crea y lo inserta en el mapa
            Circle circle = (Circle)ShapeFactory.getCircle(getRandomColor());
            circle.setX(getRandomX());
            circle.setY(getRandomY());
            circle.setRadius(100);
            circle.draw();
        }
        System.out.println("fin");
    }
    private static String getRandomColor() {
        return colors[(int)(Math.random()*colors.length)];
    }
    private static int getRandomX() {
        return (int)(Math.random()*100 );
    }
    private static int getRandomY() {
        return (int)(Math.random()*100);
    }
}
