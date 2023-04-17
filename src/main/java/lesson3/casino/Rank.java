package lesson3.casino;

public enum Rank {
    DEUCE(2), THREE(3), FOUR(4), FIVE(5), SIX(6),
    SEVEN(7), EIGHT(8), NINE(9), TEN(10),
    JACK(2), QUEEN(3), KING(4), ACE(11);


    Rank(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    private int value; // количество очков, которые приносит каждая карта
}
