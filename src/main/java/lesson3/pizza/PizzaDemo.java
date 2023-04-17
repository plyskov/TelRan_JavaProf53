package lesson3.pizza;

public class PizzaDemo {

    public static void main(String[] args) {

        Pizza p1 = new Pizza(PizzaSize.SMALL, 1, 0, 1, 3);
        System.out.println(p1.calculatePrice());

    }


}
