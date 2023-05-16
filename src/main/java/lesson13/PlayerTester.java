package lesson13;

import java.util.*;

public class PlayerTester {
    public static void main(String[] args) {
        List<Player> team = new ArrayList<>(
                Arrays.asList(
                        new Player(14, "Sam", 24),
                        new Player(16, "Alex", 27),
                        new Player(10, "John", 34),
                        new Player(27, "Sam", 19),
                        new Player(12, "Michael", 37)
                )
        );

        System.out.println(team);
        Collections.sort(team); // сортировка через Comparable<Player>
        System.out.println(team);

        Comparator<Player> reverseAge = new PlayerReverseAgeComparator();
        Collections.sort(team, reverseAge);
        System.out.println(team);

        // Компаратор через анонимный внутренний класс
        Comparator<Player> namesComparator = new Comparator<Player>() {
            @Override
            public int compare(Player o1, Player o2) {
                // Сравнение по именам - лексиграфическое
                return o1.getName().compareTo(o2.getName());
            }
        };

        Collections.sort(team, namesComparator);
        System.out.println(team);

        // Интерфейс состоящий из одного метода называется в Яве "функиональным интерфейсом"
        // реализацию функционального интерфейса можно заменить лямбда-выражением

        Comparator<Player> reverseNamesComparator = (o1, o2) -> o2.getName().compareTo(o1.getName());

        // Объекдинение двух компараторов и последовательное применение:
        Collections.sort(
                team,
                namesComparator
                        .thenComparing(reverseAge.reversed()) // Обращение компаратора на противоположный
        );
        System.out.println(team);

        // Композитный компаратор
        Comparator<Player> composite = namesComparator.thenComparing(reverseAge.reversed());


    }
}
