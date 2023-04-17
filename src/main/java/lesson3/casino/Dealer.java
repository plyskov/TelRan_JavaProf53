package lesson3.casino;

import java.util.Random;

public class Dealer {
    // генератор псевдо-рандомных карт
    private Random r = new Random();

    public Card getCard() {
        int suite = r.nextInt(4); // случ число от 0 до 3 - для индекса масти
        int rank = r.nextInt(13); // случ число от 0 до 12 - для индекса вида карты
        return new Card(
                Rank.values()[rank],
                Suite.values()[suite]
        );
    }
}
