package lesson9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lesson9 {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        // ArrayList - реализация интерфейса List, основанная на массиве


        List<String> dogs = Arrays.asList("Dog", "Chau-chau", "Terrier");
        // Arrays.asList() - это функция, создающая List со значениями только для чтения
        //dogs.add("Sheperd dog"); // не работает
        dogs.set(0, "Akita");
        System.out.println(dogs);

        List<String> countries = new ArrayList<>(
                Arrays.asList("Norway") // Инициализация нормального листа для записи на основне листа, созданного как ридонли
        );
    }
}
