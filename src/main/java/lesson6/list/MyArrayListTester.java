package lesson6.list;

import java.util.Iterator;

public class MyArrayListTester {
    public static void main(String[] args) {
        MyArrayList list = new MyArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(list);

        list.add(0, 0);
        System.out.println(list);

        list.add(0, -1);
        list.add(4);
        System.out.println(list);

        System.out.println(list.size());
        System.out.println(list.contains(4));
        System.out.println(list.contains(-4));

        list.remove(2);
        list.remove(1);

        // Проверяем обратный итератор
        Iterator<Integer> backwardIterator = list.backwardIterator();
        while (backwardIterator.hasNext())
            System.out.println("<" + backwardIterator.next() + ">");

        list.add(-10);
        System.out.println(list);

        Iterator<Integer> minToMax = list.smallToBigIterator();
        while (minToMax.hasNext())
            System.out.println("(" + minToMax.next() + ")");


    }
}
