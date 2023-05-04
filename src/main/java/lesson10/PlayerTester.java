package lesson10;

import java.util.HashSet;
import java.util.Iterator;

public class PlayerTester {
    public static void main(String[] args) {
        HashSet <Player> players = new HashSet<>();
        players.add (new Player(11,"Mike"));
        players.add (new Player(12,"Misha"));
        players.add (new Player(11,"Galina"));
        System.out.println(players);
        System.out.println(players.size());

    // 8 распечатать всех игроков через итератор
        Iterator<Player> playerIterator = players.iterator();
        while (playerIterator.hasNext())
            System.out.println(playerIterator.next());

        for (Player p:players)
        {
            System.out.println("for each "+p);
        }

        players.add(new Player(15, "Alexander"));
        players.add(new Player(1, "Natasha"));
        players.add(new Player(25, "Alexander"));

        // Удалить всех игроков с именем Alexander
        // распечатайте Set чтобы убедиться, что они удалились

//        for (Player p : players) {
//            if (p.getName() == "Alexander") {
//                players.remove(p);
//                // Так нельзя! При обходе по итератору удаление элемента из внешнего объекта "портит" итератор
//            }
//        }

        // Нужно удалять через итератор непосредственно средствами итератора
        Iterator<Player> toRemove = players.iterator();
        while (toRemove.hasNext()){
            Player p = toRemove.next();
            if (p.getName().equals("Alexander")) {
                toRemove.remove();
            }
        }
        System.out.println(players);

    }
}
