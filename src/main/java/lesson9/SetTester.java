package lesson9;

import java.util.*;

public class SetTester {
    public static void main(String[] args) {
        // Set - коллекция для хранения НЕПОВТОРЯЮЩИХСЯ элементов
        // 3 варианта реализации:
        // 1. HashSet - основан на хеш-коде: операции доступа O(1), но требуется много памяти
        // 2. LinkedHashSet - хранит элементы в порядке вставки
        // 3. TreeSet - хранит элементы в определенном порядке сортировки

        // Применение сетов:
        // - Удаление дубликатов
        // - Поиск дубликатов

        Set<String> groups = new HashSet<>();
        groups.add("Abba");
        groups.add("Guns n Roses");
        groups.add("Pearl Jam");
        groups.add("Abba");
        groups.add("Beatles");

        System.out.println(groups);
        System.out.println(groups.size());

        for (String g : groups) {
            System.out.println(g);
        }

        TreeSet<String> groupsTree = new TreeSet<>(groups); // инициализация на основе другого сета
        System.out.println(groupsTree); // TreeSet отсортированный

        System.out.println(groups.contains("Abba"));

        // у TreeSet есть возможноость отфильтровать
        Set<String> slice =  groupsTree.subSet("C", "R");
        System.out.println("slice: " + slice);

        //groupsTree.floor("C"); // все что меньше
        //groupsTree.ceiling("G"); // все что больше

        Set<String> names = new HashSet<>();
        names.add("Alex");
        names.add("Abba");
        names.add("Kristina");

        groups.addAll(names); // сложение
        System.out.println(groups);

        groups.removeAll(names); // вычитание
        System.out.println(groups);

        //groups.containsAll(names) // находятся ли все элементы сета в другом

        // groups.retainAll(names) // общие элементы сетов


        String [] gr = new String[groups.size()];
        groups.toArray(gr); // Из сета в массив сетов

        System.out.println(letters("hello lake mid"));

        System.out.println(getDoubles("dima max sveta max lena gena lena sveta max"));

    }

    // напишите функцию которая возвращает список дубликатов из строки
    // "dima max sveta max lena gena lena sveta max" -> [max sveta lena]
    public static Set<String> getDoubles(String s)
    {
//        // s.split(" ")
////        Set<String> doubles = new HashSet<>(); // дубликаты
////        //List<String> words = Arrays.asList(s.split(" ")); // слова
////        String [] words = s.split(" ");
////        Set<String> uniqWords = new HashSet<>();
////
////        for (String w : words) {
////            int prevSize = uniqWords.size();
////            uniqWords.add(w);
////            if (prevSize == uniqWords.size()) { // дубликат
////                doubles.add(w);
////            }
////        }
////        return doubles;

        // От преподавателя:

        Set<String> doubles = new HashSet<>(); // дубликаты
        Set<String> words = new HashSet<>(); // слова
        for(String w : s.split(" ")) {
            if(words.contains(w))
                doubles.add(w);
            words.add(w);
        }
        return doubles;

    }



    // напишите функцию которая возвращает набор уникальных букв из строки
    public static Set<String> letters(String s)
    {
        // "hello lake mid" -> h e l a k m d
        // до 21:26
        String [] symb = s.split("");
        Set<String> lettters = new TreeSet<>(Arrays.asList(symb));
        return lettters;
    }

}
