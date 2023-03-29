package lesson1;

public class DogTester {
    public static void main(String[] args) {

        // конструктор по умолчанию. Нужен, чтобы создать класс даже тогда, когда в самом классе конструктор еще не объявлен
        Dog trezor = new Dog();

        trezor.setAge(5);
        trezor.setName("Trezor");
        trezor.setBreed("Bulldog");
        trezor.setColor("White");

        System.out.println("trezor breed is: " + trezor.getBreed());

        // Используем 4-х параметрический конструктор
        final Dog eleonora = new Dog("Bolonka", "Eleonora", 3, "White");
        System.out.println("Eleonora's age is: " + eleonora.getAge());

        // Сделать, чтобы Трезор и Элеонора погавкали
        trezor.bark();
        eleonora.bark();

        trezor.setAge(15);
        System.out.println("Trezor age: " + trezor.getAge());

        trezor.setAge(-8); // Попытка присвоить невалидное значение
        System.out.println("Trezor age: " + trezor.getAge());

        trezor.setAge(40); // Попытка присвоить невалидное значение
        System.out.println("Trezor age: " + trezor.getAge());

        System.out.println("Number of dogs: " + Dog.numberOfDogs);

        Dog.hello(); // Вызов static метода через класс, не используя экземпляр класса
        trezor.hello(); // Можно, но не рекомендуется.

        int a = 5;
        int b = 10;
        a = b; // присваивание примитивных типов - из одного куска памяти копируем данные в другой кусок памяти

        // Модификатор final
        final int d = 7;
        int e = 12;
        //d = e; // для final переприсвоить и изменить значение нельзя

        //eleonora = trezor; // Если final - нельзя поменять ссылку

    }
}

// Класс - объединение чего-либо по характерным признакам
// Класс - шаблон для описания его представителей (экземпляров)
// Экземпляр - конкретный представитель класса
// Класс - набор свойств и действий

// Модификаторы доступа:
// - если ничего не указывать, то доступ package private - поля видны только в пакете
// - public - доступ к полю или методу имеют все классы отовсюду в проекте
// - private - доступ к полю или методу имеют только методы этого класса
// - protected - доступ к полю или методу имеют только методы класса и его наследников
class Dog {

    // Конструктор - нужен, чтобы правильно инициализировать свойства экземпляра класса
//    public Dog(String dogBreeed, String dogName, int dogAge, String dogColor) {
//        breed = dogBreeed;
//        name = dogName;
//        age = dogAge;
//        color = dogColor;
//    }

    public Dog(String breed, String name, int age, String color) {
        // this - текущий экземпляр класса
        this.breed = breed;
        this.name = name;
        this.age = age;
        this.color = color;
    }

    // Конструктор по умолчанию
    public Dog() {

    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    // Меняйте возраст собаки только если он больше 0 или <30
    public void setAge(int age) {
        if (age >0 && age < 30){
            this.age = age;
        }
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    // Свойства - переменные класса == поля класса
    private String breed;
    private String name;
    private int age;
    private String color;

    public static int numberOfDogs = 2;

    // Методы == функции == действия
    void bark() {
        // гавкнуть
        System.out.println(name + " bark-bark!");
        hello(); // Можно вызвать статический метод изнутри метода объекта
    }

    // Сделать статическую функцию Hello которая печатает Hello
    // и вызвать чяерез класс из main
    public static void hello(){
        System.out.println("Hello!");
    }
}
