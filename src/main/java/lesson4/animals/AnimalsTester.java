package lesson4.animals;

public class AnimalsTester {

    public static void main(String[] args) {
        Cat cat = new Cat("Kitty");
        cat.greets();

        // Собаки маленькуая и большая
        Dog dog = new Dog("Tuzik");
        dog.greets();
        dog.greets(dog);

        BigDog bigDog = new BigDog("Rex");
        bigDog.greets();

        dog.greets(bigDog);

        bigDog.greets(dog);
        bigDog.greets(bigDog);

    }

}
