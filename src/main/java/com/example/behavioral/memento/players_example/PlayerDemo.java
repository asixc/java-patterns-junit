package com.example.behavioral.memento.players_example;

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
public class PlayerDemo {

    public static void main(String args[]){
        PlayerStatusMemento playerStatusMemento;
        System.out.println("Game Started");
        CurrentPlayerStatusOriginator currentPlayerStatus=new CurrentPlayerStatusOriginator();
        currentPlayerStatus.setPlayerPoints(1200L);
        currentPlayerStatus.setPlayerLevel(2);
        System.out.println("Player reached 2nd level with 1200 points");
        printCurrentPlayerStatus(currentPlayerStatus);
        System.out.println("Player stores current status as memento");
        playerStatusMemento= currentPlayerStatus.createMementoFromStatus();
        currentPlayerStatus.setPlayerPoints(2200L);
        currentPlayerStatus.setPlayerLevel(4);
        printCurrentPlayerStatus(currentPlayerStatus);
        System.out.println("At this point player loses & is relegated to status saved in memento");
        currentPlayerStatus.setStatusFromMemento(playerStatusMemento);
        printCurrentPlayerStatus(currentPlayerStatus);
    }
    public  static void printCurrentPlayerStatus(CurrentPlayerStatusOriginator currentPlayerStatus){
        System.out.println("Player points->"+currentPlayerStatus.getPlayerPoints()+",level->"+currentPlayerStatus.getPlayerLevel());
    }
}

class CurrentPlayerStatusOriginator {
    private int playerLevel = 1;
    private long playerPoints = 0;

    public void setStatusFromMemento(PlayerStatusMemento memento) {
        this.playerLevel = memento.getPlayerStatus().getPlayerLevel();
        this.playerPoints = memento.getPlayerStatus().getPlayerPoints();
    }

    public PlayerStatusMemento createMementoFromStatus() {
        PlayerStatusMemento memento = new PlayerStatusMemento();
        PlayerStatus playerStatus = new PlayerStatus();
        playerStatus.setPlayerLevel(this.playerLevel);
        playerStatus.setPlayerPoints(this.playerPoints);
        memento.setPlayerStatus(playerStatus);
        return memento;
    }

    public void setPlayerPoints(long playerPoints) {
        this.playerPoints = playerPoints;
    }

    public long getPlayerPoints() {
        return this.playerPoints;
    }

    public void setPlayerLevel(int playerLevel) {
        this.playerLevel = playerLevel;
    }

    public int getPlayerLevel() {
        return this.playerLevel;
    }
}

class PlayerStatusMemento {
    private PlayerStatus playerStatus;

    public void setPlayerStatus(PlayerStatus playerStatus) {
        this.playerStatus = playerStatus;
    }

    public PlayerStatus getPlayerStatus() {
        return this.playerStatus;
    }
}


class PlayerStatus {
    private long playerPoints;
    private int playerLevel;

    public void setPlayerPoints(long playerPoints) {
        this.playerPoints = playerPoints;
    }

    public long getPlayerPoints() {
        return this.playerPoints;
    }

    public void setPlayerLevel(int playerLevel) {
        this.playerLevel = playerLevel;
    }

    public int getPlayerLevel() {
        return this.playerLevel;
    }
}