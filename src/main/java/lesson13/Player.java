package lesson13;

import org.jetbrains.annotations.NotNull;

public class Player implements Comparable<Player> {
    private int rank;
    private String name;
    private int age;

    public Player(int rank, String name, int age) {
        this.rank = rank;
        this.name = name;
        this.age = age;
    }

    public int getRank() {
        return rank;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Player{" +
                "rank=" + rank +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Player o) {
        // напишите сравнение по возрасту
        // если this < o нужно возвратить что-то отрицательное
        // если this == o нужно возвратить 0
        // если this > o нужно возвратить что-то положительное
//        if (this.age < o.age) {
//            return -1;
//        } else if (this.age == o.age) {
//            return 0;
//        }
//        return 1;

        // return (getAge() - o.getAge()); // -2млрд - 2млрд - переполнится Integer (ограничение +/- 2 млрд)

        // От преподавателя - избегаем переполнения Integer
        return Integer.compare(getAge(), o.getAge());

    }
}
