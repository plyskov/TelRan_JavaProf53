package lesson6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListIntroduction {
    public static void main(String[] args) {
        // Array
        // List - список элементов определенного типа, может динамически меняться в размере
        // Set  - набор неповторяющихся элементов определенного типа
        // Map  - набор пар из ключа и значения заданных типов
        // ...  - другие контейнеры

        // Создаем список, он же List
        List<String> countries = new ArrayList<>();
        countries.add("France");
        countries.add("Germany");
        countries.add("Denmark");

        System.out.println(countries);

        // Вставка элемента на произвольное место
        countries.add(1, "Poland");

        System.out.println(countries);
        System.out.println(countries.size()); // количество элементов в списке
        System.out.println(countries.get(3)); // получение элемента по индексу

        // Замена значения в элементе списка
        countries.set(0, "Norway");
        System.out.println(countries);

        // Элементы за пределами размера списка вставлять нельзя!
        //countries.add(8, "Andorra");
        //System.out.println(countries);

        // Удаление элементов
        countries.remove(0);
        countries.remove("Poland"); // по индексу
        System.out.println(countries); // по значению

        // Проерка наличия значений в списке
        System.out.println(countries.contains("Denmark"));

        System.out.println(countries.indexOf("Denmark")); // Позиция элемента в списке

        countries.add("Chad");
        printStringsGreaterThan4(countries);

        // Печать списка с использованием стримов и лямбда-выражений
        // В будущее!!!
        //countries.stream().filter(s -> s.length() > 5).forEach(System.out::println);

        // Инициализация списка готовыми значениями сразу - пример
        // Такая инициализация - константного размера, добавлять элементы в такой лист НЕЛЬЗЯ,
        // потому что лист создается readonly - нельзя добавлять и удалять элементы
        List<String> names = Arrays.asList("Max", "Amalia", "Dina", "Sergey");
        System.out.println(names);

        // А вот таким образом можно создавать изменяемый список, инициализируя готовыми значениями
        List<String> capitals = new ArrayList<>(
                Arrays.asList("Warshaw", "Vilnius", "Riga", "Berlin")
        );
        capitals.add("Praga");
        System.out.println(capitals);

        countries.addAll(capitals); // Добавление коллекции в конец другой коллекции
        System.out.println(countries);

        List<String> names1 = new ArrayList<>(
                Arrays.asList("Dima", "Max", "Sveta")
        );

        List<String> names2 = new ArrayList<>(
                Arrays.asList("Dima", "Anna", "Alina")
        );

        List<Boolean> comparison = compareLists(names1, names2);
        System.out.println(comparison);

    }

    // Принимает лист строк и печатает элементы длиной больше 5
    public static void printStringsGreaterThan4(List<String> a) {
//        for (int i = 0; i < a.size(); i++) {
//            if (a.get(i).length() > 4){
//                System.out.println(a.get(i));
//            }
//        }
        // Здесь цикл foreach правильный
        for (String s : a) {
            if (s.length() > 4) {
                System.out.println(s);
            }
        }

        // В списках List могут быть объекты только ссылочных типов!
        // и вообще во всех коллекциях
        // Например, лист для целых чисел:
        List<Integer> ints = new ArrayList<>();
    }

    // Написать функцию, которая принимает на вход 2 списка строк одинаковой длины
    // и возвращает список boolean
    // - true, если элементы одинаковы,
    // - false, если элементы отличаются
    public static List<Boolean> compareLists(List<String> a, List<String> b) {
        List<Boolean> r = new ArrayList<>();
        for (int i = 0; i < a.size(); i++) {
            r.add(
                    a.get(i).equals(b.get(i))
            );
        }
        return r;
    }
}
