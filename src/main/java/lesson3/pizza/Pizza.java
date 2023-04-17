package lesson3.pizza;

// Классы именуются с большой буквы, использовать только анггл буквы и цифры, CamelCase
// Класс "крокодил Данди":
// CrocodileDandy

// Свойства и функции именуются англ буквами, с маленькой буквы, далее CamelCase
// calculateSalary

// Константы: все большими буквами
// PI

// Не использовать тире, подчеркивания и знаки препинания

public class Pizza {

    //private String size; // первая версия
    private PizzaSize size;
    private int ham;
    private int cheese;
    private int peperoni;
    private int pineapple;

    public Pizza(PizzaSize size, int ham, int cheese, int peperoni, int pineapple) {
        this.size = size;
        this.ham = ham;
        this.cheese = cheese;
        this.peperoni = peperoni;
        this.pineapple = pineapple;
    }

    // SMALL 10
    // MEDIUM 12
    /// LARGE 14
    // каждый топпинг +2

    // определяем цену пиццы
    public int calculatePrice() {

        int basePrice = Pizza.basePrice(size);
        return basePrice + (cheese + ham + peperoni + pineapple)*2;
    }

    static int basePrice(PizzaSize sise) {

        int price = 0;

        switch (sise) {

            case SMALL: price = 10;
            break;
            case MIDDLE: price = 12;
            break;
            case LARGE: price = 14;
            break;
            default: price = 0;
        }
        return price;
    }

}
