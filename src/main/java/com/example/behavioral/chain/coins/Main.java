package com.example.behavioral.chain.coins;

/*
Permite desacoplar emisor y receptor.

Esto significa que el emisor no sabe cuántos manejadores hay, etc.
Cada gestor tiene una instancia de otro gestor como miembro.

Si no puede procesar la solicitud, la pasa al siguiente.

Para desacoplar el emisor y el receptor
Simplificar el código desde el punto de vista del emisor
Para añadir/eliminar manejadores sin afectar al emisor
Para cambiar el manejador dinámicamente

Sirve para:
Para gestionar las solicitudes
Para "filtrar" las solicitudes
Para manejar eventos
Cuando tienes varias implementaciones de algún comando y tú (como emisor)
no sabes cuál debe manejar la petición. Usted (como receptor) puede simplemente encadenarlas
y cuando se recibe una petición puede pasarla entre los manejadores encadenados,
hasta que uno de ellos maneje la petición.

 */
public class Main {

    public static void main(String[] args) {

        CoinInserter inserter = new CoinInserter1Dollar();

        // Crear cadena de responsabilidad
        inserter.setNextInserter(new CoinInserter50Cent())
                .setNextInserter(new CoinInserter25Cent());

        Coin coin1d = new Coin(100, 100); // 1 dollar
        insertCoin(coin1d, inserter);

        Coin coin25c = new Coin(25, 25); // 25 cents
        insertCoin(coin25c, inserter);

        Coin coin10c = new Coin(10, 10); // 10 cents
        insertCoin(coin10c, inserter);

        Coin coin50c = new Coin(50, 50); // 50 cents
        insertCoin(coin50c, inserter);
    }

    private static void insertCoin(Coin coin, CoinInserter inserter){
        boolean accepted = inserter.insert(coin);

        if(accepted)
            System.out.println(coin.toString() + " accepted!");
        else
            System.out.println(coin.toString() + " not accepted! Please, insert another coin!");


    }

}
