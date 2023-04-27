package lesson7;

import lesson6.list.MyArrayList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class IteratorTest {
    public static void main(String[] args) {
        List<String> rivers = new ArrayList<>(
                Arrays.asList("Volga", "Danube", "Rein", "Sena")
        );

        // iterator - это способ обхода произвольного контейнера с элементами
        // должны быть 2 операции:
        // boolean hasNext() - проверка, есть ли следующий элемент
        // T next() - возвращение следующего элемента

        Iterator<String> riversIterator = rivers.iterator();
//        System.out.println(riversIterator.hasNext()); // true
//        System.out.println(riversIterator.next()); // Volga
//        System.out.println(riversIterator.hasNext()); // true
//        System.out.println(riversIterator.next()); // Danube

        // цикл с использованием итератора, который переберет весь контейнер и распечатает
        while (riversIterator.hasNext()) {
            System.out.println(riversIterator.next());
        }

        MyArrayList list = new MyArrayList();
        list.add(10);
        list.add(20);
        list.add(30);

        Iterator<Integer> arrayIterator = list.iterator();
        while (arrayIterator.hasNext()) {
            int value = arrayIterator.next();
            System.out.println(arrayIterator.next());
            if (value > 25)
                arrayIterator.remove();
        }

        // чтобы foreach работал
        // контейнер должен реализовывать интерфейс Iterable
        for (int i : list) {
            System.out.println("foreach " + i);
        }

    }
}
