package lesson3.casino;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BlackJack {

    public static void main(String[] args) {
        Dealer dealer = new Dealer();

        // генерируем случайную карту
//        Card c = dealer.getCard();
//        System.out.println(c);

        Scanner scanner = new Scanner(System.in);
        List<Card> hand = new ArrayList<>();

        do {
            Card c = dealer.getCard();
            hand.add(c);
            System.out.println("Card: "  + c);
            int score = 0;
            for (Card card : hand) {  // обход всех элементов листа hand
                score += card.getValue();
            }
            System.out.println("Our score: " + score);
            System.out.println("Press N for exit.");
        } while (!scanner.next().equals("N"));
    }

}
