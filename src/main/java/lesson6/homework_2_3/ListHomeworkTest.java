package lesson6.homework_2_3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListHomeworkTest {

    public static void main(String[] args) {

        // Задание 2 (инвертировать список) - тест:
        List<String> toInvert = new ArrayList<>(
                Arrays.asList("Dima", "Max", "Alina", "Foma", "Alexander", "Semen")
        );
        System.out.println("Before invert: " + toInvert);
        invertList(toInvert);
        System.out.println("After invert: " + toInvert);


        // Задание 3 (очистить дубли из списка) - тест:
        List<String> toCollapse = new ArrayList<>(
                Arrays.asList("Dima", "Max", "Alina", "Dima", "Alexander", "Max")
        );
        System.out.println("Before clearing duolicates: " + toCollapse);
        clearDuplicates(toCollapse);
        System.out.println("After clearing duolicates: " + toCollapse);

    }

    /*
    2. Напишите функцию, меняющую порядок следования элементов передаваемого в нее списка на противоположный
    ["Dima", "Max", "Alina"] -> ["Alina", "Max", "Dima"]
    */
    private static void invertList(List<String> lst) {

        for (int i = 0; i < lst.size() / 2 ; i++) {
            String tmp = lst.get(i);
            lst.set(i, lst.get(lst.size() - i - 1));
            lst.set(lst.size() - i - 1, tmp);
        }

    }

    /*
    3*. Напишите функцию, удаляющие дубликаты из передаваемого в нее списка
    ["Dima", "Sam", "Dima", "Alina"] -> ["Dima", "Sam", "Alina"]
     */
    private static void clearDuplicates(List<String> lst) {

        // Похоже, не обойтись без дополнительного листа, чтобы складывать в него неповторяющиеся значения
        List<String> unique = new ArrayList<>();

        for (int i = 0; i < lst.size(); i++) {
            if (!unique.contains(lst.get(i))) {
                unique.add(lst.get(i));
            }
        }
        lst.clear(); // Имхо, правильнее всегда возвращать новый объект, а не замещать переданный. Но пусть будет так.
        lst.addAll(unique);
    }

}
